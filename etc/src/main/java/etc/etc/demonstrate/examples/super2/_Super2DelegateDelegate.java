package etc.etc.demonstrate.examples.super2;

import etc.demonstrate.examples.*;

/**
 * Doesn't extends ObjectDelegateDelegate since Super2 could've been an object.
 * @author pycs9
 *
 */
abstract class _Super2DelegateDelegate implements Super2 {
	private Super2Delegate delegate;
	
	public Super2Delegate delegate() {
		return delegate;
	}

	public _Super2DelegateDelegate(Super2Delegate delegate) {
		this.delegate = delegate;
	}

	public String super2Method() {
		return delegate.super2Method();
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	public String toString() {
		return delegate.toString();
	}
}