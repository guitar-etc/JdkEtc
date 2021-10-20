package etc.java.util.collection;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import etc.java.lang.Object.*;

public interface _EtcCollection<E> extends EtcObject {
	
	Collection<E> unEtc();
	
	void forEach(Consumer<? super E> action);

	int size();

	boolean isEmpty();

	boolean contains(Object o);

	Iterator<E> iterator();

	Object[] toArray();

	<T> T[] toArray(T[] a);

	<T> T[] toArray(IntFunction<T[]> generator);

	boolean add(E e);

	boolean remove(Object o);

	boolean containsAll(Collection<?> c);

	boolean addAll(Collection<? extends E> c);

	boolean removeAll(Collection<?> c);

	boolean removeIf(Predicate<? super E> filter);

	boolean retainAll(Collection<?> c);

	void clear();

	Spliterator<E> spliterator();

	Stream<E> stream();

	Stream<E> parallelStream();
}
