package etc.java.util.list;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class _ListDelegateDelegate<E> implements List<E> {
	private final ListDelegate<E> delegate;

	ListDelegate<E> delegate() {
		return delegate;
	}

	public _ListDelegateDelegate(ListDelegate<E> delegate) {
		this.delegate = delegate;
	}

	public Object impl() {
		return delegate.impl();
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return delegate.addAll(index, c);
	}

	public void replaceAll(UnaryOperator<E> operator) {
		delegate.replaceAll(operator);
	}

	public void forEach(Consumer<? super E> action) {
		delegate.forEach(action);
	}

	public void sort(Comparator<? super E> c) {
		delegate.sort(c);
	}

	public int size() {
		return delegate.size();
	}

	public E get(int index) {
		return delegate.get(index);
	}

	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	public E set(int index, E element) {
		return delegate.set(index, element);
	}

	public String someNewCollectionMethod() {
		return delegate.someNewCollectionMethod();
	}

	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	public void add(int index, E element) {
		delegate.add(index, element);
	}

	public Iterator<E> iterator() {
		return delegate.iterator();
	}

	public void setOnAfterAdd(Consumer<? super E> addListener) {
		delegate.setOnAfterAdd(addListener);
	}

	public E remove(int index) {
		return delegate.remove(index);
	}

	public Object[] toArray() {
		return delegate.toArray();
	}

	public int indexOf(Object o) {
		return delegate.indexOf(o);
	}

	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	public int lastIndexOf(Object o) {
		return delegate.lastIndexOf(o);
	}

	public <T> T[] toArray(IntFunction<T[]> generator) {
		return delegate.toArray(generator);
	}

	public ListIterator<E> listIterator() {
		return delegate.listIterator();
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public ListIterator<E> listIterator(int index) {
		return delegate.listIterator(index);
	}

	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return delegate.subList(fromIndex, toIndex);
	}

	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	public String toString() {
		return delegate.toString();
	}

	public List<E> unEtc() {
		return delegate.unEtc();
	}

	public boolean add(E e) {
		return delegate.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		return delegate.addAll(c);
	}

	public Spliterator<E> spliterator() {
		return delegate.spliterator();
	}

	public Stream<E> stream() {
		return delegate.stream();
	}

	public Stream<E> parallelStream() {
		return delegate.parallelStream();
	}

	public void setOnAfterRemove(Consumer<? super Object> removeListener) {
		delegate.setOnAfterRemove(removeListener);
	}

	public boolean remove(Object o) {
		return delegate.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return delegate.removeAll(c);
	}

	public boolean removeIf(Predicate<? super E> filter) {
		return delegate.removeIf(filter);
	}

	public boolean retainAll(Collection<?> c) {
		return delegate.retainAll(c);
	}

	public void clear() {
		delegate.clear();
	}
}