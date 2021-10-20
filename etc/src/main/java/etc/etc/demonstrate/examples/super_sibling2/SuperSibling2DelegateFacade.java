package etc.etc.demonstrate.examples.super_sibling2;

import java.util.function.*;

/**
 * Meant for any sub-delegates that inherits multiple.
 * If I wanted this for general public, I would name it EtcSuperSibling2Facade.
 * 
 * @author pycs9
 *
 */
// Do I need to extend? 
// Maybe I need a seperate interface for internal use only.
public interface SuperSibling2DelegateFacade extends ISuperSibling2Delegate {
//public interface SuperSibling2DelegateFacade { 
	public SuperSibling2Delegate superSibling2Delegate();

	public default String superSiblingMethod() {
		return superSibling2Delegate().superSiblingMethod();
	}

	@Override
	default String apply_superSiblingMethod(String str) {
		return superSibling2Delegate().apply_superSiblingMethod(str);
	}
	
	@Override
	default void setOnSuperSiblingMethod(Consumer<String> result) {
		superSibling2Delegate().setOnSuperSiblingMethod(result);
	}

	@Override
	default String onSuperSiblingMethod(String result) {
		return superSibling2Delegate().onSuperSiblingMethod(result);
	}
}