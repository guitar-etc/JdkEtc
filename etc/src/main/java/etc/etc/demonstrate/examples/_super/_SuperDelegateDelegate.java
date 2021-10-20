package etc.etc.demonstrate.examples._super;

import etc.demonstrate.examples.*;

/**
 * Doesn't extends ObjectDelegateDelegate since Super could've been an object.
 * @author pycs9
 *
 */
abstract class _SuperDelegateDelegate implements Super {
	private SuperDelegate delegate;
	
	public SuperDelegate delegate() {
		return delegate;
	}

	public _SuperDelegateDelegate(SuperDelegate delegate) {
		this.delegate = delegate;
	}

	public String super2Method() {
		return delegate.super2Method();
	}

	public String speak() {
		return delegate.speak();
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

////	@Override
//	public Super unEtc() {
//		return this;
//	}
}