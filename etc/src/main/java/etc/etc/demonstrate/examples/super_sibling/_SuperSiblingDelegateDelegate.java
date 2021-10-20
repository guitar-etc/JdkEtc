package etc.etc.demonstrate.examples.super_sibling;

import etc.demonstrate.examples.*;

abstract class _SuperSiblingDelegateDelegate implements SuperSibling {
	private SuperSiblingDelegate delegate;
	
	public SuperSiblingDelegate delegate() {
		return delegate;
	}

	public _SuperSiblingDelegateDelegate(SuperSiblingDelegate delegate) {
		this.delegate = delegate;
	}

	public String superSiblingMethod() {
		return delegate.superSiblingMethod();
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

//	public SuperSibling unEtc() {
//		return this;
//	}
}