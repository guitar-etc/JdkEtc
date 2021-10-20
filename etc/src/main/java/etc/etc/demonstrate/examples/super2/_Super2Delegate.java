package etc.etc.demonstrate.examples.super2;

import etc.java.lang.Object.*;
import etc.demonstrate.examples.*;

abstract class _Super2Delegate extends ObjectDelegate {
	private Super2 super_;

	public _Super2Delegate(Super2 super_) {
		super(super_);
		this.super_ = super_;
	}

//	@Override
	public Super2 unEtc() {
		return (Super2) super.unEtc();
	}

	public String super2Method() {
		return super_.super2Method();
	}
}