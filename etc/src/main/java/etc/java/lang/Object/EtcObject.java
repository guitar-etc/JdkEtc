package etc.java.lang.Object;

import static java.util.Objects.*;

import etc.demonstrate.examples.*;
import etc.etc.demonstrate.examples._super.*;

public interface EtcObject {
	public static EtcObject of(Object impl) {
		requireNonNull(impl);
		if (impl instanceof ObjectDelegateDelegate dd) {
			return dd.delegate();
		} else if (impl instanceof Super super_) {
			return EtcSuper.of(super_); // need utility that finds good Etc
		}
		return new ObjectDelegate(impl);
	}

	public Object unEtc();

	public int hashCode();

	public boolean equals(Object obj);

	public String toString();
}
