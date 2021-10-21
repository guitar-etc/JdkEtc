package etc.java.util.array_list;

class ArrayListDelegateDelegate<E> extends _ArrayListDelegateDelegate<E> {

	private static final long serialVersionUID = 1L;

	public ArrayListDelegateDelegate(ArrayListDelegate<E> delegate) {
		super(delegate);
	}
}