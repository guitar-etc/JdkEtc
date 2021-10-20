package etc.etc.demonstrate.examples.super_sibling;

import etc.java.lang.Object.*;
import etc.demonstrate.examples.*;

abstract class _SuperSiblingDelegate extends ObjectDelegate {
	private SuperSibling superSibling_;

	public _SuperSiblingDelegate(SuperSibling superSibling_) {
		super(superSibling_);
		this.superSibling_ = superSibling_;
	}

	public SuperSibling unEtc() {
		return (SuperSibling) super.unEtc();
	}

	public String superSiblingMethod() {
		return superSibling_.superSiblingMethod();
	}
}