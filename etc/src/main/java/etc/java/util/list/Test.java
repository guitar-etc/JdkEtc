package etc.java.util.list;

import static etc.util.Util.*;

import java.util.*;

import etc.*;

public class Test {
	public static void main(String[] args) {
		var etcL = Etc.of(new LinkedList<>());

		var holder = new Object[1];
		var removed = new Object[1];
		etcL.setOnAfterAdd(o -> holder[0] = o);
		etcL.setOnAfterRemove(o -> removed[0] = o);
		etcL.add(0, "First");
		log(etcL.size() == 1, etcL.size());
		log(etcL.get(0).equals("First"), etcL.get(0));
		log(holder[0].equals("First"), holder[0]);
		
		holder[0] = null;
		
		var setResult = etcL.set(0, "Second");
		log(setResult.equals("First"), setResult);
		log(etcL.get(0).equals("Second"), etcL.get(0));
		log(holder[0].equals("Second"), holder[0]);
		log(removed[0].equals("First"), removed[0]);
		
		var l = etcL.unEtc();
		
		l.add("Third");
		log(l.size() == 2, l.size());
		log(holder[0].equals("Third"), holder[0]);
		
		etcL.clear();
		log(removed[0].equals("Third"), removed[0]);
		log(l.isEmpty(), l.isEmpty());
		
		var etcL2 = Etc.of(l);
		log(etcL2 == etcL, "" + etcL2.getClass() + System.identityHashCode(etcL2));
	}
}
