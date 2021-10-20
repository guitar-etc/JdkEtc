package etc.etc.demonstrate.examples.sub_final;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples.base.*;
import etc.etc.demonstrate.examples.super_sibling2.*;

/**
 * Etc interface holds all the methods in Delegate.
 * The reason Etc interface exists and Delegate and DelegateDelegate both implements this interface, is to enforce that Delegate and DelegateDelegate has same methods.
 * Also, Etc interface associates the two unrelated classes.
 * 
 * @author pycs9
 *
 */
public interface EtcSubFinal extends EtcBase, EtcSuperSibling2 {
	
	public static EtcSubFinal of(SubFinal impl) {
		if (impl == null) {
			impl = new SubFinal();
		}
//		else if (impl instanceof SubFinalDelegateDelegate dd) { // cannot extend SubFinal
//			return dd.delegate();
//		}
		return new SubFinalDelegate(impl);
	}
	
	public static EtcSubFinal of() {
		return of(null);
	}
	
	public SubFinal unEtc(); // declared due to compatibility issue between EtcBase.unEtc() and EtcSuperSibling2.unEtc()
	public SubFinal impl();
	public int number();
	
}
