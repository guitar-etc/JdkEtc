package etc.etc.demonstrate.examples.base;

import etc.demonstrate.examples.*;

/**
 * Delegate class extends the super's Delegate class to inherit new or modified behaviors.
 * Any new or modified logic will be implemented in this class.
 * 
 * @author pycs9
 *
 */
public class BaseDelegate extends _BaseDelegate implements EtcBase {
	public BaseDelegate(Base base) {
		super(base);
	}

	@Override
	protected Base createDelegateDelegateForInit() {
		return new BaseDelegateDelegate(this);
	}

	public String say() {
		return super.say() + " in EtcBase";
	}

	@Override
	public String speak() {
		return super.speak() + " in EtcBase";
	}

	@Override
	public String super2Method() {
		return super.super2Method() + " in EtcBase";
	}
	
	@Override
	public String superSiblingMethod() {
		return super.superSiblingMethod() + " in EtcBase";
	}
}