package etc.etc.demonstrate.examples._super;

import etc.demonstrate.examples.*;

public class SuperDelegate extends _SuperDelegate implements EtcSuper {
	public SuperDelegate(Super super_) {
		super(super_);
	}

	@Override
	protected Super createDelegateDelegateForInit() {
		return new SuperDelegateDelegate(this);
	}

	public String speak() {
		return super.speak() + " in EtcSuper";
	}
	
	@Override
	public String super2Method() {
		return super.super2Method() + " in EtcSuper";
	}
}