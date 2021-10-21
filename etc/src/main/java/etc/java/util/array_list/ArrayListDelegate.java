package etc.java.util.array_list;

import static etc.util.Util.*;

import java.util.*;
import java.util.function.*;

/**
 * If an exception is thrown, how do I know if any were removed?
 * @author pycs9
 *
 * @param <E>
 */
public class ArrayListDelegate<E> extends _ArrayListDelegate<E> implements IArrayListDelegate<E> {
	
	public ArrayListDelegate(ArrayList<E> impl) {
		super(impl);
	}

	@Override
	protected ArrayList<E> createDelegateDelegateForInit() {
		return new ArrayListDelegateDelegate<>(this);
	}
}