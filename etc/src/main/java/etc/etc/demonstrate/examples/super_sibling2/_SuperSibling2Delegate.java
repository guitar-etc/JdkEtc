package etc.etc.demonstrate.examples.super_sibling2;

import etc.etc.demonstrate.examples.super2.*;
import etc.demonstrate.examples.*;

abstract class _SuperSibling2Delegate extends Super2Delegate {
	private SuperSibling2 superSibling_;

	public _SuperSibling2Delegate(SuperSibling2 superSibling_) {
		super(superSibling_);
		this.superSibling_ = superSibling_;
	}

	public SuperSibling2 unEtc() {
		return (SuperSibling2) super.unEtc();
	}

	public String superSiblingMethod() {
		return superSibling_.superSiblingMethod();
	}
}