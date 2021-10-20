# How to Start a New `Etc` class + Implementation Details

This document will describe how to create a new `Etc` class for a Jdk class that doesn't yet have an `Etc` class.
The document will also describe the reasoning behind the implementation choices.

For the purpose of simplicity, the document assumes `EtcList` is being created and `EtcCollection` and `EtcArrayList` already exists. 

1. Create a package named `etc.java.util.list` that will contain all the files for `EtcList`.
	1. Package name should be `etc.original_package_name.lowercase_class_name`.
2. Create an abstract class named `_ListDelegate<E>` that extends `CollectionDelegate<E>`.
	1. `_Delegate` contains the logic that handles the inheritance, delegation, composition, etc. needed to build a unique structure.
	2. `_Delegate` extends the closest `Delegate` class that exists in order to inherit the enhancements. 
		1. If none exists, it can inherit `ObjectDelegate`.
	3. This class is abstract because the purpose of this class is to hide the infrastructure code that will (hopefully) never change. A subclass of this class, `Delegate`, will be created in the later steps.
4. Create a constructor that accepts `List` then pass the `List` to super.
5. Create a `List` field named `impl` and assign the received `List` in the constructor.
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
8. 
