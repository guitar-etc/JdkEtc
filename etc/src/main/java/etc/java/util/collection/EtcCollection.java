package etc.java.util.collection;

import java.util.*;
import java.util.function.*;

import etc.java.util.array_list.*;

public interface EtcCollection<E> extends _EtcCollection<E> {
	public static <E> EtcCollection<E> of(Collection<E> impl) {
		if (impl instanceof CollectionDelegateDelegate<E> dd) { 
			return dd.delegate();
		}
		else if (impl instanceof ArrayList<E> al) {
			return EtcArrayList.of(al);
		}
		return new CollectionDelegate<>(impl);
	}
	
	
	public String someNewCollectionMethod();
	
	public void setOnAfterAdd(Consumer<? super E> addListener);
	public void setOnAfterRemove(Consumer<? super Object> removeListener);

}
