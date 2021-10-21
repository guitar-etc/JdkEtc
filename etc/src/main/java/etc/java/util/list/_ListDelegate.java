package etc.java.util.list;

import java.util.*;
import java.util.function.*;

import etc.java.util.collection.*;

public abstract class _ListDelegate<E> extends CollectionDelegate<E> {
	private final List<E> impl;

	public _ListDelegate(List<E> impl) {
		super(impl);
		this.impl = impl;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return impl.addAll(index, c);
	}
	public void replaceAll(UnaryOperator<E> operator) {
		impl.replaceAll(operator);
	}
	public void sort(Comparator<? super E> c) {
		impl.sort(c);
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
	public int indexOf(Object o) {
		return impl.indexOf(o);
	}
	public int lastIndexOf(Object o) {
		return impl.lastIndexOf(o);
	}
	public ListIterator<E> listIterator() {
		return impl.listIterator();
	}
	public ListIterator<E> listIterator(int index) {
		return impl.listIterator(index);
	}
	public List<E> subList(int fromIndex, int toIndex) {
		return impl.subList(fromIndex, toIndex);
	}

	public List<E> unEtc() {
		return (List<E>) super.unEtc();
	}
}
