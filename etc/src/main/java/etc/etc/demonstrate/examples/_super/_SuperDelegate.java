package etc.etc.demonstrate.examples._super;

import etc.etc.demonstrate.examples.super2.*;
import etc.demonstrate.examples.*;

abstract class _SuperDelegate extends Super2Delegate {
	private Super super_;

	public _SuperDelegate(Super super_) {
		super(super_);
		this.super_ = super_;
	}

//	@Override
	public Super unEtc() {
		return (Super) super.unEtc();
	}

//	public String super2Method() {
//		return super_.super2Method();
//	}

	public String speak() {
		return super_.speak();
	}
}