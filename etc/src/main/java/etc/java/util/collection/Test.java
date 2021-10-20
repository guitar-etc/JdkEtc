package etc.java.util.collection;

import static etc.util.Util.*;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		var etcCollection = EtcCollection.of(new ArrayList<>());
		
		etcCollection.add(null);
		log(etcCollection.size() == 1, etcCollection.size());
		
		var holder = new Object[1];
		etcCollection.setOnAfterAdd(o -> holder[0] = o);
		etcCollection.add("First");
		log(etcCollection.size() == 2, etcCollection.size());
		log(!etcCollection.isEmpty(), etcCollection.isEmpty());
		log(holder[0].equals("First"), holder[0]);
	}
}
