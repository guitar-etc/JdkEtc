package etc.etc.demonstrate.examples.base;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples._super.*;
import etc.etc.demonstrate.examples.super_sibling.*;

/**
 * Etc interface holds all the methods in Delegate.
 * The reason Etc interface exists and Delegate and DelegateDelegate both implements this interface, is to enforce that Delegate and DelegateDelegate has same methods.
 * Also, Etc interface associates the two unrelated classes.
 * 
 * @author pycs9
 *
 */
public interface EtcBase extends EtcSuper, EtcSuperSibling {
	
	/**
	 * Can't use BaseDelegate as return type because EtcSub may have to be returned if "impl" is Sub.
	 * 
	 * @param impl
	 * @return
	 */
	public static EtcBase of(Base impl) {
		if (impl == null) {
			impl = new Base();
		}
		else if (impl instanceof BaseDelegateDelegate dd) { 
			return dd.delegate();
		}
		return new BaseDelegate(impl);
	}
	
	public static EtcBase of() {
		return of(null);
	}
	
//	// cannot cast BaseDelegateDelegate into SuperDelegateDelegate when EtcSuper.of(Base)
	// can probably cast to EtcBase. Also not using BaseDelegateDelegate as the main object because it may not be able to extend Base if it's a final class.
	// If so, I need to build a workaround for that special case. I want to standardize into one architecture.
//	public static BaseDelegateDelegate of(Base impl) {
//		if (impl == null) {
//			impl = new Base();
//		}
//		else if (impl instanceof BaseDelegateDelegate base_) { 
//			return base_;
//		}
//		return new BaseDelegateDelegate(new BaseDelegate(impl));
//	}
//	
//	public static EtcBase of() {
//		return of(null);
//	}
	public Base unEtc();
	public String say();
}
