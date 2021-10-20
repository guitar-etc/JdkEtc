package etc.java.util.collection;

import static etc.util.Util.*;

import java.util.*;
import java.util.function.*;

/**
 * If an exception is thrown, how do I know if any were removed?
 * @author pycs9
 *
 * @param <E>
 */
public class CollectionDelegate<E> extends _CollectionDelegate<E> implements ICollectionDelegate<E> {
	private Consumer<? super Object> removeListener;
	private Consumer<? super E> addListener;
	
	public CollectionDelegate(Collection<E> impl) {
		super(impl);
	}

	@Override
	protected Collection<E> createDelegateDelegateForInit() {
		return new CollectionDelegateDelegate<>(this);
	}
	
	@Override
	public String someNewCollectionMethod() {
		return "someNewCollectionMethod in EtcCollection";
	}
	
	public void setOnAfterAdd(Consumer<? super E> addListener) {
		this.addListener = addListener;
	}
	
	/**
	 * There is no guarantee on how "add" and "addAll" (or any other adding operations) will interact.
	 * So add a flag to ensure the listener is called only once.
	 */
	private boolean disableOnAfterAdd = false;
	
	protected void onAfterAdd(E e) {
		if (!disableOnAfterAdd && addListener != null) {
			addListener.accept(e);
		}
	}
	
	protected <O> O addOp(Supplier<O> supp) {
		var prev = disableOnAfterAdd;
		disableOnAfterAdd = true;
		try {
			return supp.get();
		}
		finally {
			disableOnAfterAdd = prev;
		}
	}
	
	public boolean add(E e) {
		var result = addOp(() -> super.add(e));

		if (result) {
			onAfterAdd(e);
		}

		return result;
	}
	
	/**
	 * Assumes all elements are added. If the implementation filters the elements for some reason, (i.e. Set), then override there.
	 */
	public boolean addAll(Collection<? extends E> c) {
		var result = addOp(() -> super.addAll(c));
		
		if (result) {
			for (E e : c) {
				onAfterAdd(e);
			}
		}

		return result;
	}
	
	public void setOnAfterRemove(Consumer<? super Object> removeListener) {
		this.removeListener = removeListener;
	}
	
	private boolean disableOnAfterRemove = false;
	
	protected void onAfterRemove(Object o) {
		if (!disableOnAfterRemove && removeListener != null) {
			removeListener.accept(o);
		}
	}
	
	protected <O> O removeOp(Supplier<O> supp) {
		var prev = disableOnAfterRemove;
		disableOnAfterRemove = true;
		try {
			return supp.get(); 
		}
		finally {
			disableOnAfterRemove = prev;
		}
	}
	
//	private void removeOp(Runnable run) {
//		var prev = disableOnAfterRemove;
//		disableOnAfterRemove = true;
//		try {
//			run.run();
//		}
//		finally {
//			disableOnAfterRemove = prev;
//		}
//	}

	public boolean remove(Object o) {
		var result = removeOp(() -> super.remove(o));

		if (result) {
			onAfterRemove(o);
		}

		return result;
	}

	/**
	 * Does not rely on Collection.removeAll because "removeAll" doesn't tell me which elements were removed in an efficient manner.
	 * Implemented using "removeIf" in order to guarantee that "onAfterRemove" is called "after" the remove operation is performed.
	 * 
	 * Collection's subclasses have strange behavior difference when "contains" or the filter throws an exception during removeAll or removeIf.
	 * Namely, ArrayList vs ArrayDeque.
	 */
	public boolean removeAll(Collection<?> c) {
		return removeIf(e -> c.contains(e));
	}

	/**
	 * wrap the predicate in order to keep track of which elements will be removed.
	 * 
	 * Collection's removeIf implementation can remove only few elements if the filter throws an exception.
	 * Assume so and call onAfterRemove to the elements that passed the filter.
	 * Subclasses like ArrayList or ArrayDeque doesn't remove any elements if the filter throws an exception, so will need to override to modify this method's behavior.
	 */
	public boolean removeIf(Predicate<? super E> filter) {
		return removeIf(filter, true);
	}
	
	protected boolean removeIf(Predicate<? super E> filter, boolean removedOneByOne) {
		ArrayList<E> removeds = null;
		Predicate<? super E> filter2 = filter;
		
		// no need to collect the removeds.
		if (!disableOnAfterRemove) {
			removeds = new ArrayList<E>(size());
			var f_removeds = removeds;
			filter2 = e -> {
				if (filter.test(e)) {
					f_removeds.add(e);
					return true;
				}
				return false;
			};
		}
		
		var f_filter2 = filter2;
		
		boolean isThrown = false;
		try {
			return removeOp(() -> super.removeIf(f_filter2));
		}
		catch (Throwable th) {
			isThrown = true;
			throw th;
		}
		finally {
//			if (isThrowable) {
//				if (removedOneByOne) {
//					// onAfter remove
//				}
//			}
//			else {
//				// onAfter remove
//			}
			
			if ((!isThrown || removedOneByOne) && removeds != null) {
				for (E e : removeds) {
					onAfterRemove(e);
				}
			}
		}
	}

	public boolean retainAll(Collection<?> c) {
		return removeIf(e -> !c.contains(e));
	}

	public void clear() {
		var copy = super.toArray();
		
		removeOp(toSupplier(() -> super.clear()));
		
		for (Object o : copy) {
			onAfterRemove(o);
		}
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	protected Collection<E> clone() throws CloneNotSupportedException {
//		return (Collection<E>) super.clone();
//	}
}