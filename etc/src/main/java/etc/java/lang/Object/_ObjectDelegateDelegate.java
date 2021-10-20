package etc.java.lang.Object;

/**
 * Will probably never use this class but added for completeness
 * 
 * @author pycs9
 *
 */
abstract class _ObjectDelegateDelegate {
	private ObjectDelegate delegate;

	public ObjectDelegate delegate() {
		return delegate;
	}

	public _ObjectDelegateDelegate(ObjectDelegate delegate) {
		this.delegate = delegate;
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public boolean equals(Object obj) {
		return this.delegate.equals(obj);
	}

	public String toString() {
		return delegate.toString();
	}

//	public Object unEtc() {
//		return this;
//	}
}