package etc.etc.demonstrate.examples.sub_final;

import etc.etc.demonstrate.examples.base.*;
import etc.etc.demonstrate.examples.super_sibling2.*;
import etc.demonstrate.examples.*;

/**
 * This class has delegating code which theoretically should never change.
 * @author pycs9
 *
 */
public abstract class _SubFinalDelegate 
extends BaseDelegate implements SuperSibling2DelegateFacade {
	private SubFinal impl;
	private SuperSibling2Delegate superSibling2Delegate;
	
	@Override
	public SuperSibling2Delegate superSibling2Delegate() {
		return superSibling2Delegate;
	}
	
	public _SubFinalDelegate(SubFinal impl) {
		super(impl);
		this.impl = impl;
		this.superSibling2Delegate = new SuperSibling2Delegate(impl);
	}

	@Override
	public SubFinal unEtc() {
		return (SubFinal)super.unEtc();
	}
	
	@Override
	public SubFinal impl() {
		return (SubFinal)super.impl();
	}

	public int number() {
		return impl.number();
	}
	
	@Override
	public String superSiblingMethod() {
		return onSuperSiblingMethod(superSibling2Delegate().apply_superSiblingMethod(super.superSiblingMethod()));
	}

	@Override
	public String apply_superSiblingMethod(String str) {
		return super.apply_superSiblingMethod(str);
	}

//	// can't call BaseDelegate.super.apply_superSiblingMethod... for some reason.
//	@Override
//	public String apply_superSiblingMethod(String str) {
//		return super.apply_superSiblingMethod(SuperSibling2DelegateFacade.super.apply_superSiblingMethod(str));
//	}
}