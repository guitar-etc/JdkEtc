package etc.java.util.array_list;

import java.util.*;

import etc.java.util.list.*;

public interface _EtcArrayList<E> extends EtcList<E> {
	
	ArrayList<E> unEtc();
	
	void trimToSize();

	void ensureCapacity(int minCapacity);
}