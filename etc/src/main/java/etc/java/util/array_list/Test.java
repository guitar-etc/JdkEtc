package etc.java.util.array_list;

import static etc.util.Util.*;

import etc.*;

public class Test {
	public static void main(String[] args) {
		var etcAL = EtcArrayList.of();
		
		var holder = new Object[1];
		var removed = new Object[1];
		etcAL.setOnAfterAdd(o -> holder[0] = o);
		etcAL.setOnAfterRemove(o -> removed[0] = o);
		etcAL.add(0, "First");
		log(etcAL.size() == 1, etcAL.size());
		log(etcAL.get(0).equals("First"), etcAL.get(0));
		log(holder[0].equals("First"), holder[0]);
		
		holder[0] = null;
		
		var setResult = etcAL.set(0, "Second");
		log(setResult.equals("First"), setResult);
		log(etcAL.get(0).equals("Second"), etcAL.get(0));
		log(holder[0].equals("Second"), holder[0]);
		log(removed[0].equals("First"), removed[0]);
		
		var al = etcAL.unEtc();
		
		al.add("Third");
		log(al.size() == 2, al.size());
		log(holder[0].equals("Third"), holder[0]);
		
		etcAL.clear();
		log(removed[0].equals("Third"), removed[0]);
		log(al.isEmpty(), al.isEmpty());
		
		var etcAL2 = Etc.of(al);
		log(etcAL2 == etcAL, "" + etcAL2.getClass() + System.identityHashCode(etcAL2));
		
	}
}
