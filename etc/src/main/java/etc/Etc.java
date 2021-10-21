package etc;

import java.util.*;

import etc.java.lang.Object.*;
import etc.java.util.array_list.*;
import etc.java.util.collection.*;
import etc.java.util.list.*;

/**
 * For now, let's maintain the Etc.of chain manually.
 * EtcSuper.of(..) should call EtcBase.of(..) or any other child.of(..) manually.
 * 
 * @author pycs9
 *
 */

public class Etc {
	
	public static EtcObject of(Object impl) {
		return EtcObject.of(impl);
	}
	
	public static <E> EtcCollection<E> of(Collection<E> impl) {
		return EtcCollection.of(impl);
	}
	
	public static <E> EtcArrayList<E> of(ArrayList<E> impl) {
		return EtcArrayList.of(impl);
	}
	
	public static <E> EtcList<E> of(List<E> impl) {
		return EtcList.of(impl);
	}
}
