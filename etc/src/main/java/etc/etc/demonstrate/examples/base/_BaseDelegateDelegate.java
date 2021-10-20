package etc.etc.demonstrate.examples.base;

import etc.demonstrate.examples.*;

abstract class _BaseDelegateDelegate extends Base {
	private BaseDelegate delegate;
	public BaseDelegate delegate() {
		return delegate;
	}

//	public Base unEtc() {
//		return this;
//	}

	public _BaseDelegateDelegate(BaseDelegate bd) {
		this.delegate = bd;
	}

	public String speak() {
		return delegate.speak();
	}

	public String say() {
		return delegate.say();
	}

	public String super2Method() {
		return delegate.super2Method();
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
}