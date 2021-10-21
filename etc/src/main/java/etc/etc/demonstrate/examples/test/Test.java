package etc.etc.demonstrate.examples.test;

import static etc.util.Util.*;

import etc.etc.demonstrate.examples._super.*;
import etc.etc.demonstrate.examples.base.*;
import etc.etc.demonstrate.examples.super_sibling.*;
import etc.etc.demonstrate.examples.super_sibling2.*;
import etc.demonstrate.*;
import etc.demonstrate.examples.*;

public class Test {
	
	public static void main(String[] args) {
		var etcBase = EtcBase.of();
		
		log(etcBase);
		log(etcBase.say().equals("I'm Base in EtcBase"), etcBase.say());
		log(etcBase.speak().equals("Speaking as Super in EtcSuper in EtcBase"), etcBase.speak());
		log(etcBase.unEtc().speak().equals("Speaking as Super in EtcSuper in EtcBase"), etcBase.speak());
		
		log(EtcDemonstrate.of(etcBase.unEtc()).speak().equals("Speaking as Super in EtcSuper in EtcBase"), etcBase.speak());
//		log(etcBase.someNewSuperMethod().equals("someNewSuperMethod"), etcBase.someNewSuperMethod());
//		log(Etc.of(etcBase.unEtc()).someNewSuperMethod().equals("someNewSuperMethod"), etcBase.someNewSuperMethod());
		
		log(etcBase.super2Method().equals("super2Method in Base in EtcSuper2 in EtcSuper in EtcBase"), etcBase.super2Method());
		
		log(etcBase.unEtc() instanceof Base, etcBase.unEtc());
		
		var etcSuper = (EtcSuper)etcBase;
		log(etcSuper.unEtc().super2Method().equals("super2Method in Base in EtcSuper2 in EtcSuper in EtcBase"), etcSuper.super2Method());
		
		log(etcSuper instanceof EtcBase, etcSuper);
		log(etcSuper.unEtc().getClass().getSimpleName().equals("BaseDelegateDelegate"), etcSuper.unEtc());
		log(etcSuper.unEtc() instanceof Super, etcSuper.unEtc(), 3);
		Super temp2 = etcSuper.unEtc();
		log(EtcDemonstrate.of(temp2) instanceof EtcBase, temp2, 2);
		EtcBase etcBase2 = (EtcBase)EtcDemonstrate.of(temp2);
		log(etcBase2.super2Method().equals("super2Method in Base in EtcSuper2 in EtcSuper in EtcBase"), etcBase2.super2Method());
		
		etcBase = EtcBase.of(etcBase2.unEtc());
		log(etcBase == etcBase2, "temp == base");
		log(etcBase.unEtc() == etcBase2.unEtc(), "temp.unEtc() == base.unEtc()");
		
		log(etcBase.superSiblingMethod().equals("superSiblingMethod in Base in EtcSuperSibling in EtcBase"), etcBase.superSiblingMethod());
		
		var etcSuperSibling = EtcSuperSibling.of(new Base());
		log(etcSuperSibling instanceof EtcBase, etcSuperSibling);
		log(etcSuperSibling.superSiblingMethod().equals("superSiblingMethod in Base in EtcSuperSibling in EtcBase"), etcSuperSibling.superSiblingMethod());
		etcSuperSibling = EtcSuperSibling.of(etcBase.unEtc());
		log(etcBase.toString().equals(etcSuperSibling.toString()), etcBase.toString());
		log(etcSuperSibling.superSiblingMethod().equals("superSiblingMethod in Base in EtcSuperSibling in EtcBase"), etcSuperSibling.superSiblingMethod());

		log(etcSuperSibling == etcBase, etcSuperSibling);
		log(etcBase.someNewSuperSiblingMethod().equals("someNewSuperSiblingMethod in EtcSuperSibling"), etcBase.someNewSuperSiblingMethod());
		
		
		var subFinal = new SubFinal();
		var etcSubFinal = EtcDemonstrate.of(subFinal);
		log(new SubFinal().number() == 2, new SubFinal().number());
		log(etcSubFinal.number() == 1002, etcSubFinal.number());
		try {
			var etcSubFinal_unEtc = etcSubFinal.unEtc();
			log(false, etcSubFinal_unEtc);
		}
		catch (UnsupportedOperationException e) {
			log(true, e);
		}
		// doesn't compile.
//		try {
//			var etcBase_impl = etcBase.impl();
//			log(false, etcBase_impl);
//		}
//		catch (UnsupportedOperationException e) {
//			log(true, e);
//		}
		
		var etcSubFinal_impl = etcSubFinal.impl();
		log(etcSubFinal_impl instanceof SubFinal, etcSubFinal_impl);
		log(etcSubFinal_impl == subFinal, etcSubFinal_impl);
		
		log(etcSubFinal.superSiblingMethod().equals("superSiblingMethod in Base in EtcSuperSibling in EtcBase in EtcSuperSibling2"), etcSubFinal.superSiblingMethod());
		
		var holder = new String[1];
		
		class Temp implements SuperSibling2 {
			@Override
			public String super2Method() {
				return null;
			}

			@Override
			public String superSiblingMethod() {
				return null;
			}
		}
		var etcSuperSibling2Temp = EtcSuperSibling2.of(new Temp());
		etcSuperSibling2Temp.setOnSuperSiblingMethod(str -> holder[0] = str);
		log(etcSuperSibling2Temp.super2Method().equals("null in EtcSuper2"), etcSuperSibling2Temp.super2Method());
		log(etcSuperSibling2Temp.superSiblingMethod().equals("null in EtcSuperSibling2"), etcSuperSibling2Temp.superSiblingMethod());
		log(etcSuperSibling2Temp.superSiblingMethod().equals(holder[0]), holder[0]);
		holder[0] = null;
		
		etcSubFinal.setOnSuperSiblingMethod(str -> holder[0] = str);
		log(etcSubFinal.super2Method().equals("super2Method in Base in SubFinal in EtcSuper2 in EtcSuper in EtcBase"), etcSubFinal.super2Method());
		log(etcSubFinal.superSiblingMethod().equals("superSiblingMethod in Base in EtcSuperSibling in EtcBase in EtcSuperSibling2"), etcSubFinal.superSiblingMethod());
		log(etcSubFinal.superSiblingMethod().equals(holder[0]), holder[0]);
	}
}
