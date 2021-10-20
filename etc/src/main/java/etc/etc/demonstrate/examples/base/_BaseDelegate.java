package etc.etc.demonstrate.examples.base;

import etc.etc.demonstrate.examples._super.*;
import etc.etc.demonstrate.examples.super_sibling.*;
import etc.demonstrate.examples.*;

/**
 * This class has delegating code which theoretically should never change.
 * @author pycs9
 *
 */
abstract class _BaseDelegate extends SuperDelegate implements SuperSiblingDelegateFacade {
	private Base base;
	private SuperSiblingDelegate superSiblingDelegate;
	
	@Override
	public SuperSiblingDelegate superSiblingDelegate() {
		return superSiblingDelegate;
	}
	
	public _BaseDelegate(Base base) {
		super(base);
		this.base = base;
//		this.etcSuperSibling = EtcSuperSibling.make(base);
		this.superSiblingDelegate = new SuperSiblingDelegate(base);
	}

	@Override
	public Base unEtc() {
		return (Base)super.unEtc();
	}

	public String say() {
		return base.say();
	}

	public String superSiblingMethod() {
		return apply_superSiblingMethod(base.superSiblingMethod());
	}
}