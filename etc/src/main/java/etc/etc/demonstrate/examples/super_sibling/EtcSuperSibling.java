package etc.etc.demonstrate.examples.super_sibling;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples.base.*;
import etc.java.lang.Object.*;

public interface EtcSuperSibling extends EtcObject {
	public static EtcSuperSibling of(SuperSibling impl) {
		if (impl instanceof SuperSiblingDelegateDelegate dd) { 
			return dd.delegate();
		}
		else if (impl instanceof Base base) {
			return EtcBase.of(base);
		}
//		return make(impl);
		return new SuperSiblingDelegate(impl);
	}
	
//	public static EtcSuperSibling make(SuperSibling impl) {
//		return new SuperSiblingDelegate(impl);
//	}
	
	public SuperSibling unEtc();
	
	public String superSiblingMethod();

//	String apply_superSiblingMethod(String str);
	
	String someNewSuperSiblingMethod();
}
