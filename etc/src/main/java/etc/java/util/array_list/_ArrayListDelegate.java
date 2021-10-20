package etc.java.util.array_list;

import java.util.*;
import java.util.function.*;

import etc.java.util.collection.*;

abstract class _ArrayListDelegate<E> extends CollectionDelegate<E> {
	private ArrayList<E> impl;

	public _ArrayListDelegate(ArrayList<E> impl) {
		super(impl);
		this.impl = impl;
	}

	@Override
	public ArrayList<E> unEtc() {
		return (ArrayList<E>) super.unEtc();
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	protected ArrayList<E> clone() {
//		return (ArrayList<E>)impl.clone();
//	}

	public void trimToSize() {
		impl.trimToSize();
	}

	public void ensureCapacity(int minCapacity) {
		impl.ensureCapacity(minCapacity);
	}

	public boolean containsAll(Collection<?> c) {
		return impl.containsAll(c);
	}

	public int indexOf(Object o) {
		return impl.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return impl.lastIndexOf(o);
	}

	public String toString() {
		return impl.toString();
	}

	public E get(int index) {
		return impl.get(index);
	}

	public E set(int index, E element) {
		return impl.set(index, element);
	}

	public void add(int index, E element) {
		impl.add(index, element);
	}

	public E remove(int index) {
		return impl.remove(index);
	}

	public boolean equals(Object o) {
		return impl.equals(o);
	}

	public int hashCode() {
		return impl.hashCode();
	}

	public boolean addAll(Collection<? extends E> c) {
		return impl.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return impl.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return impl.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return impl.retainAll(c);
	}

	public ListIterator<E> listIterator(int index) {
		return impl.listIterator(index);
	}

	public ListIterator<E> listIterator() {
		return impl.listIterator();
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return impl.subList(fromIndex, toIndex);
	}

	public void replaceAll(UnaryOperator<E> operator) {
		impl.replaceAll(operator);
	}

	public void sort(Comparator<? super E> c) {
		impl.sort(c);
	}
}