package etc.java.util.array_list;

import java.util.*;
import java.util.function.*;

import etc.java.util.collection.*;

public interface _EtcArrayList<E> extends EtcCollection<E> {
	
	ArrayList<E> unEtc();
	
//	ArrayList<E> clone();

	void trimToSize();

	void ensureCapacity(int minCapacity);

	boolean containsAll(Collection<?> c);

	int indexOf(Object o);

	int lastIndexOf(Object o);

	String toString();

	E get(int index);

	E set(int index, E element);

	void add(int index, E element);

	E remove(int index);

	boolean equals(Object o);

	int hashCode();

	boolean addAll(Collection<? extends E> c);

	boolean addAll(int index, Collection<? extends E> c);

	boolean removeAll(Collection<?> c);

	boolean retainAll(Collection<?> c);

	ListIterator<E> listIterator(int index);

	ListIterator<E> listIterator();

	List<E> subList(int fromIndex, int toIndex);

	void replaceAll(UnaryOperator<E> operator);

	void sort(Comparator<? super E> c);
}
