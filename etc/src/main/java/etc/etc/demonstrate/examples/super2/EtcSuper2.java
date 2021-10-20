package etc.etc.demonstrate.examples.super2;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples._super.*;
import etc.java.lang.Object.*;

public interface EtcSuper2 extends EtcObject {
	public static EtcSuper2 of(Super2 impl) {
		if (impl instanceof Super2DelegateDelegate dd) { 
			return dd.delegate();
		}
		else if (impl instanceof Super base) {
			return EtcSuper.of(base);
		}
		return new Super2Delegate(impl);
	}
	
	public Super2 unEtc();
	
	public String super2Method();
}
