package etc.demonstrate;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples._super.*;
import etc.etc.demonstrate.examples.base.*;
import etc.etc.demonstrate.examples.sub_final.*;
import etc.etc.demonstrate.examples.super2.*;
import etc.etc.demonstrate.examples.super_sibling.*;
import etc.etc.demonstrate.examples.super_sibling2.*;
import etc.java.lang.Object.*;

/**
 * For now, let's maintain the Etc.of chain manually.
 * EtcSuper.of(..) should call EtcBase.of(..) or any other child.of(..) manually.
 * 
 * @author pycs9
 *
 */

public class EtcDemonstrate {
	
	public static EtcObject of(Object impl) {
		return EtcObject.of(impl);
	}
	
	public static EtcSuper2 of(Super2 impl) {
		return EtcSuper2.of(impl);
	}
	
	public static EtcSuper of(Super impl) {
		return EtcSuper.of(impl);
	}
	
	public static EtcSuperSibling of(SuperSibling impl) {
		return EtcSuperSibling.of(impl);
	}
	
	public static EtcSuperSibling2 of(SuperSibling2 impl) {
		return EtcSuperSibling2.of(impl);
	}
	
	public static EtcBase of(Base impl) {
		return EtcBase.of(impl);
	}
	
	public static EtcSubFinal of(SubFinal impl) {
		return EtcSubFinal.of(impl);
	}
}
