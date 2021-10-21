package etc.java.util.array_list;

import java.util.*;

import etc.java.util.list.*;

abstract class _ArrayListDelegate<E> extends ListDelegate<E> {
	private final ArrayList<E> impl;

	public _ArrayListDelegate(ArrayList<E> impl) {
		super(impl);
		this.impl = impl;
	}

	@Override
	public ArrayList<E> unEtc() {
		return (ArrayList<E>) super.unEtc();
	}	

	public void trimToSize() {
		impl.trimToSize();
	}

	public void ensureCapacity(int minCapacity) {
		impl.ensureCapacity(minCapacity);
	}
}