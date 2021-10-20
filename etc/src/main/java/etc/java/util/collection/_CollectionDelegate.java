package etc.java.util.collection;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import etc.java.lang.Object.*;

abstract class _CollectionDelegate<E> extends ObjectDelegate {
	private Collection<E> impl;

	public _CollectionDelegate(Collection<E> impl) {
		super(impl);
		this.impl = impl;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<E> unEtc() {
		return (Collection<E>) super.unEtc();
	}

	public void forEach(Consumer<? super E> action) {
		impl.forEach(action);
	}

	public int size() {
		return impl.size();
	}

	public boolean isEmpty() {
		return impl.isEmpty();
	}

	public boolean contains(Object o) {
		return impl.contains(o);
	}

	public Iterator<E> iterator() {
		return impl.iterator();
	}

	public Object[] toArray() {
		return impl.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return impl.toArray(a);
	}

	public <T> T[] toArray(IntFunction<T[]> generator) {
		return impl.toArray(generator);
	}

	public boolean add(E e) {
		return impl.add(e);
	}

	public boolean remove(Object o) {
		return impl.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return impl.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		return impl.addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return impl.removeAll(c);
	}

	public boolean removeIf(Predicate<? super E> filter) {
		return impl.removeIf(filter);
	}

	public boolean retainAll(Collection<?> c) {
		return impl.retainAll(c);
	}

	public void clear() {
		impl.clear();
	}

	public Spliterator<E> spliterator() {
		return impl.spliterator();
	}

	public Stream<E> stream() {
		return impl.stream();
	}

	public Stream<E> parallelStream() {
		return impl.parallelStream();
	}
}