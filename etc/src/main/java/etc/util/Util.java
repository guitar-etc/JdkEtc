package etc.util;

import java.util.*;
import java.util.function.*;

/**
 * Miscellaneous utils.
 * 
 * They will be moved into the corresponding "Etc" classes when they are created.
 * 
 * @author pycs9
 *
 */
public class Util {
	
	/**
	 * usecase: log("name", name, "age", age);
	 * 
	 * If an object doesn't handle its array field, then the string will have the poor Array.toString().
	 * 
	 * 
	 * @param objects
	 */
	public static void log(Object...objects) {
		System.out.println(Arrays.deepToString(objects));
	}
	
//	public static void log(Object...objects) {
//		for (int i = 0; i < objects.length; i++) {
//			Object obj = objects[i];
//			if (obj instanceof List list) {
//				var lItr = list.listIterator();
//				while (lItr.hasNext()) {
//					var e = lItr.next();
//					if (e != null & e.getClass().isArray()) {
//						var str = Arrays.deepToString(new Object[] { e });
//						str = str.substring(1, str.length() - 1); // remove surrounding []
//						lItr.set(str);
//					}
//				}
//			}
//			
//			if (obj instanceof Iterable<?> itr) {
//				for (Object e : itr) {
//					if (e != null && e.getClass().isArray()) {
//						
//					}
//				}
//			}
//		}
//		
//		System.out.println(Arrays.deepToString(objects));
//	}
	
	public static <O> Supplier<O> toSupplier(Runnable run) {
		return () -> {
			run.run();
			return null;
		};
	}
	
	public static <O> Runnable toRunnable(Supplier<O> supp) {
		return () -> supp.get();
	}
}
