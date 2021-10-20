package etc.etc.demonstrate.examples.super2;

import etc.demonstrate.examples.*;

public class Super2Delegate extends _Super2Delegate implements EtcSuper2 {
	public Super2Delegate(Super2 super_) {
		super(super_);
	}

	@Override
	protected Super2 createDelegateDelegateForInit() {
		return new Super2DelegateDelegate(this);
	}
	
	@Override
	public String super2Method() {
		return super.super2Method() + " in EtcSuper2";
	}
}