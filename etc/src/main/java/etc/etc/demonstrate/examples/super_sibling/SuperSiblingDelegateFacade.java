package etc.etc.demonstrate.examples.super_sibling;

/**
 * Meant for any sub-delegates that inherits multiple.
 * If I wanted this for general public, I would name it EtcSuperSiblingFacade.
 * 
 * @author pycs9
 *
 */
public interface SuperSiblingDelegateFacade extends ISuperSiblingDelegate2 {
	public SuperSiblingDelegate superSiblingDelegate();

	@Override
	public default String superSiblingMethod() {
		return superSiblingDelegate().superSiblingMethod();
	}

	@Override
	default String apply_superSiblingMethod(String str) {
		return superSiblingDelegate().apply_superSiblingMethod(str);
	}

	@Override
	default String someNewSuperSiblingMethod() {
		return superSiblingDelegate().someNewSuperSiblingMethod();
	}
}
