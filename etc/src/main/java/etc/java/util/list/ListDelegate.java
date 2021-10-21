package etc.java.util.list;

import static etc.util.Util.*;

import java.util.*;
import java.util.function.*;

public class ListDelegate<E> extends _ListDelegate<E> implements EtcList<E> {

	public ListDelegate(List<E> impl) {
		super(impl);
	}
	
	@Override
	protected List<E> createDelegateDelegateForInit() {
		return new ListDelegateDelegate<>(this);
	}
	
	public E set(int index, E element) {
		var removed = addOp(() -> removeOp(() -> super.set(index, element)));
		
		onAfterRemove(removed);
		onAfterAdd(element);
		
		return removed;
	}

	public void add(int index, E element) {
		addOp(toSupplier(() -> super.add(index, element)));
		
		onAfterAdd(element);
	}

	public E remove(int index) {
		var removed = removeOp(() -> super.remove(index));
		
		onAfterRemove(removed);
		
		return removed;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		var result = addOp(() -> super.addAll(index, c));
		
		for (E e : c) {
			onAfterAdd(e);
		}
		
		return result;
	}
	
	/**
	 * ArrayList implementation doesn't remove any elements if filter throws an exception
	 */
	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		return super.removeIf(filter, false);
	}
}
