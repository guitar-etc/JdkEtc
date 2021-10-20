package etc.etc.demonstrate.examples.super_sibling2;

import java.util.function.*;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples.sub_final.*;
import etc.etc.demonstrate.examples.super2.*;

public interface EtcSuperSibling2 extends EtcSuper2 {
	public static EtcSuperSibling2 of(SuperSibling2 impl) {
		if (impl instanceof SuperSibling2DelegateDelegate dd) { 
			return dd.delegate();
		}
		else if (impl instanceof SubFinal base) {
			return EtcSubFinal.of(base);
		}
		return new SuperSibling2Delegate(impl);
	}
	
	
	public SuperSibling2 unEtc();
	
	public String superSiblingMethod();
//	String apply_superSiblingMethod(String str);

	public void setOnSuperSiblingMethod(Consumer<String> result);
//	public void onSuperSiblingMethod(String result);
}
