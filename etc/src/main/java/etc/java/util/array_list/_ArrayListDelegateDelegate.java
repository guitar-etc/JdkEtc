package etc.java.util.array_list;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

abstract class _ArrayListDelegateDelegate<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1L;
	private ArrayListDelegate<E> delegate;
	
	public ArrayListDelegate<E> delegate() {
		return delegate;
	}

	public _ArrayListDelegateDelegate(ArrayListDelegate<E> delegate) {
		this.delegate = delegate;
	}

	public void trimToSize() {
		delegate.trimToSize();
	}

	public void forEach(Consumer<? super E> action) {
		delegate.forEach(action);
	}

	public void ensureCapacity(int minCapacity) {
		delegate.ensureCapacity(minCapacity);
	}

	public int size() {
		return delegate.size();
	}

	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	public String someNewCollectionMethod() {
		return delegate.someNewCollectionMethod();
	}

	public int indexOf(Object o) {
		return delegate.indexOf(o);
	}

	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	public int lastIndexOf(Object o) {
		return delegate.lastIndexOf(o);
	}

	public Iterator<E> iterator() {
		return delegate.iterator();
	}

	public void setOnAfterAdd(Consumer<? super E> addListener) {
		delegate.setOnAfterAdd(addListener);
	}

//	public ArrayList<E> clone() {
//		return delegate.clone();
//	}

	public Object[] toArray() {
		return delegate.toArray();
	}

	public String toString() {
		return delegate.toString();
	}

	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	public E get(int index) {
		return delegate.get(index);
	}

	public <T> T[] toArray(IntFunction<T[]> generator) {
		return delegate.toArray(generator);
	}

	public E set(int index, E element) {
		return delegate.set(index, element);
	}

	public void add(int index, E element) {
		delegate.add(index, element);
	}

	public E remove(int index) {
		return delegate.remove(index);
	}

	public boolean equals(Object o) {
		return delegate.equals(o);
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public boolean addAll(Collection<? extends E> c) {
		return delegate.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return delegate.addAll(index, c);
	}

	public boolean add(E e) {
		return delegate.add(e);
	}

	public boolean removeAll(Collection<?> c) {
		return delegate.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return delegate.retainAll(c);
	}

	public Spliterator<E> spliterator() {
		return delegate.spliterator();
	}

	public ListIterator<E> listIterator(int index) {
		return delegate.listIterator(index);
	}

	public Stream<E> stream() {
		return delegate.stream();
	}

	public ListIterator<E> listIterator() {
		return delegate.listIterator();
	}

	public Stream<E> parallelStream() {
		return delegate.parallelStream();
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return delegate.subList(fromIndex, toIndex);
	}

	public void setOnAfterRemove(Consumer<? super Object> removeListener) {
		delegate.setOnAfterRemove(removeListener);
	}

	public void replaceAll(UnaryOperator<E> operator) {
		delegate.replaceAll(operator);
	}

	public void sort(Comparator<? super E> c) {
		delegate.sort(c);
	}

	public boolean remove(Object o) {
		return delegate.remove(o);
	}

	public boolean removeIf(Predicate<? super E> filter) {
		return delegate.removeIf(filter);
	}

	public void clear() {
		delegate.clear();
	}
}