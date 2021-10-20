# How to Start a New `Etc` class + Implementation Details

This document will describe how to create a new `Etc` class for a Jdk class that doesn't yet have an `Etc` class.
The document will also describe the reasoning behind the implementation choices.

For the purpose of simplicity, the document assumes `EtcList` is being created and `EtcCollection` and `EtcArrayList` already exists. 

1. Create a package that will contain all the files for `EtcList`.
	2. Package name should be `etc.original_package_name.lowercase_class_name`. So, in this case, `etc.java.util.list`.
2. and then
