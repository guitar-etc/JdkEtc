package etc.etc.demonstrate.examples.super_sibling2;

import etc.demonstrate.examples.*;

class _SuperSibling2DelegateDelegate implements SuperSibling2 {
	private SuperSibling2Delegate delegate;
	
	public SuperSibling2Delegate delegate() {
		return delegate;
	}

	public _SuperSibling2DelegateDelegate(SuperSibling2Delegate delegate) {
		this.delegate = delegate;
	}

	public String superSiblingMethod() {
		return delegate.superSiblingMethod();
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

//	public SuperSibling2 unEtc() {
//		return this;
//	}
}