package etc.java.util.collection;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

abstract class _CollectionDelegateDelegate<E> implements Collection<E> {
	private final CollectionDelegate<E> delegate;
	
	CollectionDelegate<E> delegate() {
		return delegate;
	}

	public _CollectionDelegateDelegate(CollectionDelegate<E> delegate) {
		this.delegate = delegate;
	}

//	public Object impl() {
//		return delegate.impl();
//	}

	public void forEach(Consumer<? super E> action) {
		delegate.forEach(action);
	}

	public int size() {
		return delegate.size();
	}

	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	public Iterator<E> iterator() {
		return delegate.iterator();
	}

	public Object[] toArray() {
		return delegate.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	public <T> T[] toArray(IntFunction<T[]> generator) {
		return delegate.toArray(generator);
	}

	public boolean add(E e) {
		return delegate.add(e);
	}

	public boolean remove(Object o) {
		return delegate.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		return delegate.addAll(c);
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

	public Spliterator<E> spliterator() {
		return delegate.spliterator();
	}

	public Stream<E> stream() {
		return delegate.stream();
	}

	public Stream<E> parallelStream() {
		return delegate.parallelStream();
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	public String toString() {
		return delegate.toString();
	}
}