package etc.java.util.array_list;

import static etc.util.Util.*;

import java.util.*;
import java.util.function.*;

/**
 * If an exception is thrown, how do I know if any were removed?
 * @author pycs9
 *
 * @param <E>
 */
public class ArrayListDelegate<E> extends _ArrayListDelegate<E> implements IArrayListDelegate<E> {
	
	public ArrayListDelegate(ArrayList<E> impl) {
		super(impl);
	}

	@Override
	protected ArrayList<E> createDelegateDelegateForInit() {
		return new ArrayListDelegateDelegate<>(this);
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
	
//	public ArrayList<E> clone() {
//		return (ArrayList<E>)super.clone();
//	}
}