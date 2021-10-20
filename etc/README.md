# JDK Etc

***

## Summary
JDK Etc is an implementation of a delegation pattern to tightly couple the JDK classes and its utility that's not part of JDK.

## Scenario 1
Imagine a scenario where you have an instance of `java.util.List` or its subclass named `vehicles`.
You want to throw `MoreThan3VehiclesException` whenever a vehicle is added to `vehicles` and `vehicles` has more than 3 vehicles. Note that you don't want to throw the exception when the number of vehicles go down (i.e. 5 -> 4)

Static utility method is not a good fit because each instance could have different `addListener` assigned.
A static `Map<List, AddListener>` can be maintained but others may bypass the static method and call `List.add`.

You can maintain `vehicles` in a Manager instance and modify `vehicles` only through the Manager and call the `MoreThan3VehiclesException` logic in all of the add operations in the Manager. However, you can't stop other developers from omitting the call to your `Exception` logic. Moreover, if you want similar behavior for `houses`, you may need to duplicate the logic.

***

It would be convenient if you can attach an `addListener` to `vehicles` itself and `List` instance supports it.

Unfortunately it is not easy to modify the classes in the Jdk or other third party library. One way could be to contribute to the library. The other could be to download the source, modify, then package.
However, this requires extended permissions and/or thorough insight into the implementation.

This project will use the delegate pattern to add any modifications to existing methods and to add any new fields or methods to existing Jdk classes. Each Jdk class will have a corresponding `Etc` class (i.e. `ArrayList` -> `EtcArrayList`)

## Sample (snippet from tests).
```java
var etcAL = EtcArrayList.of(); // type of EtcArrayList.
		
var holder = new Object[1];
var removed = new Object[1];
etcAL.setOnAfterAdd(o -> holder[0] = o);
etcAL.setOnAfterRemove(o -> removed[0] = o);
etcAL.add(0, "First");
log(etcAL.size() == 1, etcAL.size()); // true
log(etcAL.get(0).equals("First"), etcAL.get(0)); // true
log(holder[0].equals("First"), holder[0]); // true

holder[0] = null;
		
var setResult = etcAL.set(0, "Second"); // set is considered as a remove and then an add.
log(setResult.equals("First"), setResult); // true
log(etcAL.get(0).equals("Second"), etcAL.get(0)); // true
log(holder[0].equals("Second"), holder[0]); // true
log(removed[0].equals("First"), removed[0]); // true

var al = etcAL.unEtc(); // type of ArrayList.
```

## Goal

### Using `Base` as a placeholder for class names.
```java
class Super {..}

class Base {
	public String base() {
		return "base()";
	}
}

class EtcSuper extends Super {..}

class EtcBase extends Base, Super /*???*/ {
	public String base() {
		return super.base() + " in EtcBase";
	}
}
```

1. The `EtcBase` instance (1) should inherit `Base` or (2) should be easily convertible to `Base`.
	1. If Approach (2) is taken, the converted `Base` instance should keep the modifications made in `EtcBase`
		1. For example, the converted `Base` instance's `base()` should return "base() in EtcBase" as if `EtcBase.base()` is called.
2. The `EtcBase` instance (1) should inherit `EtcSuper` or (2) should be easily convertible to `EtcSuper`.
	1. This is so that any enhancements made in `EtcSuper` should also apply to `EtcBase` instances since `Base` inherits `Super`.
3. Add modifications to existing methods.
	1. The modifications should also apply to the converted `Base`. A redundant statement to 1.1.
4. Add new methods.
	1. Also add to the converted `Base` if `Base` is extensible?
	~~2. If the new method can be implemented as a static method, add a static version.~~
		1. I think this would be too much duplication and the static method will probably use some instance methods that may have some enhancements. Encourage to convert to `EtcBase` and then call the new method.
5. `Base` instance should be easily convertible to `EtcBase`.
	1. If `Base` instance was a converted `Base` from `EtcBase`, the conversion should return the same, identical `EtcBase` such that `orig == new`.
	2. If `Base` instance is actually a sub-type of `Base`, `Sub` and `EtcSub` exists, the returned `EtcBase` should actually be `EtcSub` so that any modifications made for `Sub` applies even if the variable is declared as `Base`. 
		1. This should be recursive so that if `Base` instance is actually a sub-type of `Sub`, `SubSub`, `EtcSubSub` should be returned.

## Implementation of the Goal
1. Approach 2 is taken since `Base` can be a final class and `EtcBase` also need to inherit `EtcSuper`.
2. Approach 1 is taken to reduce the amount of coding (which is already too much) and reduce too many delegations.
	1. Jump from `EtcBase` to `Base` is 1 jump but Jump from `EtcBase` all the way up to `EtcObject` can be several jumps.
3. Done
4. Done
	1. No. the converted `Base` has to be returned as type of `Base`, not its sub-type because of `EtcBase.unEtc()` and `EtcSuper.unEtc()` should be compatible.
		1. A sub-type of `Base` is not a sub-type of (sub-type of `Super`).
5. Done
	1. Done
	2. Done
		1. I can probably maintain a `Map<Class<?>, Function<Object, EtcObject>>` and write some logic to find the closest `Etc` class to the given instance. However, maintain this manually in code for now.


