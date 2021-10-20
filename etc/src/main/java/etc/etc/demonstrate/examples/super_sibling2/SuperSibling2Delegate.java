package etc.etc.demonstrate.examples.super_sibling2;

import java.util.function.*;

import etc.demonstrate.examples.*;

public class SuperSibling2Delegate extends _SuperSibling2Delegate implements ISuperSibling2Delegate {
	public SuperSibling2Delegate(SuperSibling2 super_) {
		super(super_);
	}

	@Override
	protected SuperSibling2 createDelegateDelegateForInit() {
		return new SuperSibling2DelegateDelegate(this);
	}
	
	@Override
	public String superSiblingMethod() {
		return onSuperSiblingMethod(apply_superSiblingMethod(super.superSiblingMethod()));
	}
	
	@Override
	public String apply_superSiblingMethod(String str) {
		return str + " in EtcSuperSibling2";
	}
	
	private Consumer<String> onSuperSiblingMethod;
	@Override
	public void setOnSuperSiblingMethod(Consumer<String> result) {
		onSuperSiblingMethod = result;
	}
	
	public String onSuperSiblingMethod(String result) {
		if (onSuperSiblingMethod != null) {
			onSuperSiblingMethod.accept(result);
		}
		return result;
	}
}