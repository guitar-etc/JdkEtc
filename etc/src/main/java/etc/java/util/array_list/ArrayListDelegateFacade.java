//I probably don't need this since ArrayList is a class and a class cannot inherit more than 1 class

//package etc.java.util.array_list;
//
//import java.util.*;
//import java.util.function.*;
//import java.util.stream.*;
//
///**
// * Meant for any sub-delegates that inherits multiple.
// * If I wanted this for general public, I would name it EtcArrayListFacade.
// * 
// * @author pycs9
// *
// */
//public interface ArrayListDelegateFacade<E> extends IArrayListDelegate<E> {
//	public ArrayListDelegate<E> arrayListDelegate();
//
////	public default Object impl() {
////		return arrayListDelegate().impl();
////	}
//
////	public default ArrayList<E> unEtc() {
////		return arrayListDelegate().unEtc();
////	}
//
//	public default void trimToSize() {
//		arrayListDelegate().trimToSize();
//	}
//
//	public default void forEach(Consumer<? super E> action) {
//		arrayListDelegate().forEach(action);
//	}
//
//	public default void ensureCapacity(int minCapacity) {
//		arrayListDelegate().ensureCapacity(minCapacity);
//	}
//
//	public default int size() {
//		return arrayListDelegate().size();
//	}
//
//	public default boolean containsAll(Collection<?> c) {
//		return arrayListDelegate().containsAll(c);
//	}
//
//	public default boolean isEmpty() {
//		return arrayListDelegate().isEmpty();
//	}
//
//	public default String someNewCollectionMethod() {
//		return arrayListDelegate().someNewCollectionMethod();
//	}
//
//	public default int indexOf(Object o) {
//		return arrayListDelegate().indexOf(o);
//	}
//
//	public default boolean contains(Object o) {
//		return arrayListDelegate().contains(o);
//	}
//
//	public default int lastIndexOf(Object o) {
//		return arrayListDelegate().lastIndexOf(o);
//	}
//
//	public default Iterator<E> iterator() {
//		return arrayListDelegate().iterator();
//	}
//
//	public default void setOnAfterAdd(Consumer<? super E> addListener) {
//		arrayListDelegate().setOnAfterAdd(addListener);
//	}
//
////	public default ArrayList<E> clone() {
////		return arrayListDelegate().clone();
////	}
//
//	public default Object[] toArray() {
//		return arrayListDelegate().toArray();
//	}
//
////	public default String toString() {
////		return arrayListDelegate().toString();
////	}
//
//	public default <T> T[] toArray(T[] a) {
//		return arrayListDelegate().toArray(a);
//	}
//
//	public default E get(int index) {
//		return arrayListDelegate().get(index);
//	}
//
//	public default <T> T[] toArray(IntFunction<T[]> generator) {
//		return arrayListDelegate().toArray(generator);
//	}
//
//	public default E set(int index, E element) {
//		return arrayListDelegate().set(index, element);
//	}
//
//	public default void add(int index, E element) {
//		arrayListDelegate().add(index, element);
//	}
//
//	public default E remove(int index) {
//		return arrayListDelegate().remove(index);
//	}
//
////	public default boolean equals(Object o) {
////		return arrayListDelegate().equals(o);
////	}
////
////	public default int hashCode() {
////		return arrayListDelegate().hashCode();
////	}
//
//	public default boolean addAll(Collection<? extends E> c) {
//		return arrayListDelegate().addAll(c);
//	}
//
//	public default boolean addAll(int index, Collection<? extends E> c) {
//		return arrayListDelegate().addAll(index, c);
//	}
//
//	public default boolean add(E e) {
//		return arrayListDelegate().add(e);
//	}
//
//	public default boolean removeAll(Collection<?> c) {
//		return arrayListDelegate().removeAll(c);
//	}
//
//	public default boolean retainAll(Collection<?> c) {
//		return arrayListDelegate().retainAll(c);
//	}
//
//	public default Spliterator<E> spliterator() {
//		return arrayListDelegate().spliterator();
//	}
//
//	public default ListIterator<E> listIterator(int index) {
//		return arrayListDelegate().listIterator(index);
//	}
//
//	public default Stream<E> stream() {
//		return arrayListDelegate().stream();
//	}
//
//	public default ListIterator<E> listIterator() {
//		return arrayListDelegate().listIterator();
//	}
//
//	public default Stream<E> parallelStream() {
//		return arrayListDelegate().parallelStream();
//	}
//
//	public default List<E> subList(int fromIndex, int toIndex) {
//		return arrayListDelegate().subList(fromIndex, toIndex);
//	}
//
//	public default void setOnAfterRemove(Consumer<? super Object> removeListener) {
//		arrayListDelegate().setOnAfterRemove(removeListener);
//	}
//
//	public default void replaceAll(UnaryOperator<E> operator) {
//		arrayListDelegate().replaceAll(operator);
//	}
//
//	public default void sort(Comparator<? super E> c) {
//		arrayListDelegate().sort(c);
//	}
//
//	public default boolean remove(Object o) {
//		return arrayListDelegate().remove(o);
//	}
//
//	public default boolean removeIf(Predicate<? super E> filter) {
//		return arrayListDelegate().removeIf(filter);
//	}
//
//	public default void clear() {
//		arrayListDelegate().clear();
//	}
//}
