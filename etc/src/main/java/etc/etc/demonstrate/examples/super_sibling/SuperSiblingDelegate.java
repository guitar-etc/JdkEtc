package etc.etc.demonstrate.examples.super_sibling;

import etc.demonstrate.examples.*;

public class SuperSiblingDelegate extends _SuperSiblingDelegate implements ISuperSiblingDelegate2 {
	public SuperSiblingDelegate(SuperSibling super_) {
		super(super_);
	}

	@Override
	protected SuperSibling createDelegateDelegateForInit() {
		return new SuperSiblingDelegateDelegate(this);
	}
	
	@Override
	public String superSiblingMethod() {
		return apply_superSiblingMethod(super.superSiblingMethod());
	}
	
	@Override
	public String apply_superSiblingMethod(String str) {
		return str + " in EtcSuperSibling";
	}
	
	public String someNewSuperSiblingMethod() {
		return "someNewSuperSiblingMethod in EtcSuperSibling";
	}
}