package etc.etc.demonstrate.examples._super;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples.base.*;
import etc.etc.demonstrate.examples.super2.*;

public interface EtcSuper extends EtcSuper2 {
	public static EtcSuper of(Super impl) {
		if (impl instanceof SuperDelegateDelegate dd) { 
			return dd.delegate();
		}
		else if (impl instanceof Base base) {
			return EtcBase.of(base);
		}
		return new SuperDelegate(impl);
	}
	
	public Super unEtc();
	
	public String super2Method();
	public String speak();
}
