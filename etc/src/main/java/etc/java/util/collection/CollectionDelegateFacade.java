package etc.java.util.collection;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Meant for any sub-delegates that inherits multiple.
 * If I wanted this for general public, I would name it EtcCollectionFacade.
 * 
 * @author pycs9
 *
 */
public interface CollectionDelegateFacade<E> extends ICollectionDelegate<E> {
	public CollectionDelegate<E> collectionDelegate();

	public default Object impl() {
		return collectionDelegate().impl();
	}

	public default String someNewCollectionMethod() {
		return collectionDelegate().someNewCollectionMethod();
	}

	public default void forEach(Consumer<? super E> action) {
		collectionDelegate().forEach(action);
	}

	public default int size() {
		return collectionDelegate().size();
	}

	public default boolean isEmpty() {
		return collectionDelegate().isEmpty();
	}

	public default boolean contains(Object o) {
		return collectionDelegate().contains(o);
	}

	public default Iterator<E> iterator() {
		return collectionDelegate().iterator();
	}

	public default Object[] toArray() {
		return collectionDelegate().toArray();
	}

	public default <T> T[] toArray(T[] a) {
		return collectionDelegate().toArray(a);
	}

	public default <T> T[] toArray(IntFunction<T[]> generator) {
		return collectionDelegate().toArray(generator);
	}

	public default boolean add(E e) {
		return collectionDelegate().add(e);
	}

	public default boolean remove(Object o) {
		return collectionDelegate().remove(o);
	}

	public default boolean containsAll(Collection<?> c) {
		return collectionDelegate().containsAll(c);
	}

	public default boolean addAll(Collection<? extends E> c) {
		return collectionDelegate().addAll(c);
	}

	public default boolean removeAll(Collection<?> c) {
		return collectionDelegate().removeAll(c);
	}

	public default boolean removeIf(Predicate<? super E> filter) {
		return collectionDelegate().removeIf(filter);
	}

	public default boolean retainAll(Collection<?> c) {
		return collectionDelegate().retainAll(c);
	}

	public default void clear() {
		collectionDelegate().clear();
	}

	public default Spliterator<E> spliterator() {
		return collectionDelegate().spliterator();
	}

	public default Stream<E> stream() {
		return collectionDelegate().stream();
	}

	public default Stream<E> parallelStream() {
		return collectionDelegate().parallelStream();
	}
}
