package etc.java.util.list;

import java.util.*;
import java.util.function.*;

import etc.java.util.array_list.*;
import etc.java.util.collection.*;

public interface EtcList<E> extends EtcCollection<E> {
	
	public static <E> EtcList<E> of(List<E> impl) {
		if (impl instanceof ListDelegateDelegate<E> dd) { 
			return dd.delegate();
		}
		else if (impl instanceof ArrayList<E> al) {
			return EtcArrayList.of(al);
		}
		return new ListDelegate<>(impl);
	}

	boolean addAll(int index, Collection<? extends E> c);

	void replaceAll(UnaryOperator<E> operator);

	void sort(Comparator<? super E> c);

	E get(int index);

	E set(int index, E element);

	void add(int index, E element);

	E remove(int index);

	int indexOf(Object o);

	int lastIndexOf(Object o);

	ListIterator<E> listIterator();

	ListIterator<E> listIterator(int index);

	List<E> subList(int fromIndex, int toIndex);

	List<E> unEtc();
}