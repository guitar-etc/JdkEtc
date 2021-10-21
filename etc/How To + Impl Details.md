# How to Start a New `Etc` class + Implementation Details

This document will describe how to create a new `Etc` class for a Jdk class that doesn't yet have an `Etc` class.
It requires quite a few user interactions. It would be ideal if I could build some sort of automation, but this is POC, so not for now.

The document will also describe the reasoning behind the implementation choices.

For the purpose of simplicity, the document assumes `EtcList` is being created and `EtcCollection` and `EtcArrayList` already exists. 

1. Create a package named `etc.java.util.list` that will contain all the files for `EtcList`.
	1. Package name should be `etc.original_package_name.lowercase_class_name`.
#### `_Delegate`
2. Create an abstract class named `_ListDelegate<E>` that extends `CollectionDelegate<E>`.
	1. `_Delegate` contains the logic that handles the inheritance, delegation, composition, etc. needed to build a unique structure.
	2. `_Delegate` extends the closest `Delegate` class that exists in order to inherit the enhancements. 
		1. If none exists, it can inherit `ObjectDelegate`.
	3. This class is abstract because the purpose of this class is to hide the infrastructure code that will (hopefully) never change. A subclass of this class, `Delegate`, will be created in the later steps.
4. Create a constructor that accepts `List` then pass the `List` to super.
5. Create a private final `List` field named `impl` and assign the received `List` in the constructor.
	1. This is to delegate the methods that only exist in `List` and not in `Collection` to `impl`.
		1. Methods that exist in `Collection` should not be overriden in this class. Any enhancement will be added to `Delegate` which will be introduced in the later steps.
6. Generate methods that delegate calls to `impl`. Be sure to only generate methods that exist in `List` and doesn't exist in `Collection`.
	1. I do this in Eclipse like the following.
		1. Create a temporary `Collection` field,
		2. Generate delegate methods for the temp field, then
		3. Generate delegate methods for the `impl` field, then finally
		4. Remove the temp field and its delegate methods.
	5. The remaining methods should be the methods that exist in `List` but not in `Collection`.
7. Override `unEtc()` and change the return type to `List<E>` and type cast the return object.
	1. `impl()` is only for final classes. `impl()` returns the internally managed instance and any methods called on it will not go through the `Etc` classes.
#### `Delegate`
8. Create a class named `ListDelegate<E>` that extends `_ListDelegate<E>`.
	1. This class will hold all the enhancements for `List`.
9. Override `createDelegateDelegateForInit` and change the return type to `List` and return `new ListDelegateDelegate<>(this);`
	1. ListDelegateDelegate will be created in the later steps.
#### `_DelegateDelegate`
- This class is called "DelegateDelegate" because it delegates the method calls to `Delegate` instance. `_DelegateDelegate`'s subclass, `DelegateDelegate`, will inherit the target class so the users can retrieve it using `unEtc()` if the API they want to use expects `ArrayList`. 
- **If the target class is final, `_DelegateDelegate` and `DelegateDelegate` aren't needed and the users are expected to use `impl()`**.
10. Create a class named `_ListDelegateDelegate<E>` that implements `List<E>`
	1. `_DelegateDelegate` implements or extends the target class.
11. Create a private final `ListDelegate<E>` field named `delegate` and generate delegate methods for all the methods of `delegate`.
	1. `impl()` and `unEtc()` are probably unnecessary but they can stay.
	2. This is probably not different from generating the delegate methods for `List<E>` at this point.
12. Create a package-private method `delegate()` that returns `delegate`.
	1. This is to allow `EtcList<E>` to access `delegate` in `EtcList.of` which will be created in the later steps.
#### `DelegateDelegate`
13. Create a class named `ListDelegateDelegate<E>` that extends `_ListDelegateDelegate`.
	1. This class will hold all the delegate methods to the new methods added in `Delegate`.
		1. However, it has been decided to not add those delegate methods, but to encourage using `Etc.of(..).newMethod()`, because it would be extremely rare for a user to have an instance of `ListDelegateDelegate` declared as `ListDelegateDelegate`.
			1. It would be more natural that the user has an instance of `ListDelegateDelegate` declared as `List` and calls `Etc.of(list)` without knowing the implementation type. `Etc.of(list)` will notice the implementation type and handle appropriately.
	2. So, this class is empty for now.
#### `EtcList`
14. Extract an interface from `_ListDelegate`, using the IDE's feature (I used Eclipse) and name it `EtcList`.
	1. `Etc` declares all the methods that target class has and all the new methods in `Delegate`.
	2. Since there are no new methods in `ListDelegate`, it's okay to extract the interface from `_ListDelegate`. 
15. Make the interface extend `EtcCollection`.
	1. This is to inherit any new methods declared in EtcCollection. The implementation has been inherited by having `_ListDelegate` inherit `CollectionDelegate`.
16. Make `ListDelegate` implement this interface and remove it from `_ListDelegate`.
	1. This is to emphasize that `_ListDelegate` will not contain any newly created method but only the delegate methods.

#### `EtcArrayList`, `_ArrayListDelegate`, and `ArrayListDelegate`
17. Find if there is any `Etc` for the subclass of `List`. At this point in time, `EtcArrayList` is the only one.
18. `EtcArrayList` currently extends `EtcCollection` because that was the closest `Etc` class. Change it to extend `EtcList` instead.
19. `_ArrayListDelegate` currently extends `CollectionDelegate`. Change it to extend `ListDelegate` instead.
20. Remove the methods that already exist in `EtcList` and `ListDelegate`. This is to allow calls to `List`'s methods (i.e. `add`) is delegated correctly to `ListDelegate`.
21. Move all the enhancements in `ArrayListDelegate` to `ListDelegate` if the enhancement also applies to `List`.

#### `EtcList.of(..)` and `Etc.of(..)`
22. Go back to `EtcList` and reate the `EtcList.of(List impl)` static method that returns `EtcList` . The method should...
	1. Does not check if `impl` is null because `List` is an interface. `_ObjectDelegate` which is the ancestor of all `Delegate` classes will handle the null by throwing.
		1. If `impl` is null and the target class is a class with some simple enough constructor, create an instance of the target class and assign to impl.
	2. Check if `impl` is `ListDelegateDelegate`. If so, return the associated `ListDelegate` instance.
	3. Check if `impl` is a subclass of `List` and an `Etc` class exists for it. At this point, `ArrayList` is the only subclass with the `Etc` class.
		1. If `impl` is `ArrayList` return `EtcArrayList.of(impl)`;
	4. Otherwise, return a new instance of `ListDelegate`.
23. Add `Etc.of(List impl)` that calls `EtcList.of(List)`.

#### Test
24. It would be ideal to create some JUnit testcases. But for simplicity, I just ran some methods in `Test.java`'s `main()`. I copied the test from `ArrayList`'s test and passed a `LinkedList` to `EtcList.of`.

**The following is optional**

It is possible that a subclass, `Sub`, that extends something else, `Super`, also implements `List`. `ListDelegate` is a class and the `SubDelegate` cannot extend both `SuperDelegate` and `ListDelegate`. Since `List` is an interface and I decided that the concrete class has precedence, `SubDelegate` inherits the enhancements of `ListDelegate` via composition.

#### `IDelegate`
1. Create an interface named `IListDelegate` that extends `EtcList` and make `ListDelegate` implement the interface.
	1. This interface will hold any "semi-protected" methods that helps combining multiple enhancements to a method into one.
		1. They are "semi-protected" because all interface methods are actually public and I can't stop anyone from using this.
		2. For example, 2 different `Etc` for 2 interfaces can have different enhancements to the methods whose signatures are the same. If a class implements both interfaces, the class's `Etc` should somehow combine the enhancements.
			1. Code example is `Base.superSiblingMethod` and `SubFinal.superSiblingMethod`
	2. For now, this interface will be empty.

#### `DelegateFacade`
2. Create an interface named `ListDelegateFacade` that extends `IListDelegate`.
3. Declare a method, `delegate()` that returns `ListDelegate`.
4. Generate the delegate methods.
	1. In Eclipse, I do it by
		1. Creating a temp class.
		2. Creating a temp field, `temp`, deciared as `ListDelegate`.
		3. Generate the methods.
		4. Replace all "temp" to "delegate()"
		5. Replace all "public" to "public default"
		6. Copy-paste the generated methods into this interface.

#### Expectations

Among the classes created in this document, `EtcList` is the only class that is expected to be used by the user. I couldn't find a good way to only expose `EtcList` because of the package structure I decided to use and module-info.java doesn't seem to allow exporting a single class.


