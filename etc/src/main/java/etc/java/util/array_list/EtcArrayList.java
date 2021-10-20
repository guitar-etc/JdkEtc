package etc.java.util.array_list;

import java.util.*;

public interface EtcArrayList<E> extends _EtcArrayList<E> {
	public static <E> EtcArrayList<E> of() {
		return of(null);
	}
	
	public static <E> EtcArrayList<E> of(ArrayList<E> impl) {
		if (impl == null) {
			impl = new ArrayList<>();
		}
		if (impl instanceof ArrayListDelegateDelegate<E> dd) { 
			return dd.delegate();
		}
//		else if (impl instanceof Base base) {
//			return EtcBase.of(base);
//		}
		return new ArrayListDelegate<>(impl);
	}
}