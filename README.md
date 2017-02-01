StableSort
===

Introduction
---
[Stable sorting](http://stackoverflow.com/questions/1517793/stability-in-sorting-algorithms) algorithms maintain the relative order of records with equal keys. 
A sorting algorithm is stable if whenever there are two records R and S with the same 
key and with R appearing before S in the original list, R will appear before S in the sorted list.


Installation
---
There are two required libraries for this project, including:

 - Java 8
 - JUnit 4

Usage
---

Here is an example to use StableSort library:
```java
final Integer FIRST_INT = 2, SECOND_INT = 1;
    
SortableFactory<Integer> sortableFactory = new SortableFactory<>();
// Build sortable array with helpers
Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT);

// Sort the array
Sortable<Integer>[] result = sorter.stableSort(sortables);
assertEquals(2, result.length);
assertEquals(SECOND_INT, result[0].getPayload());
assertEquals(1, result[0].getIndex());
assertEquals(FIRST_INT, result[1].getPayload());
assertEquals(0, result[1].getIndex());
```

Both Eclipse and Intellij are supported to run the unit tests.

Contributing
---
1. Fork it!
2. Create your feature branch: git checkout -b new-feature
3. Commit your changes: git commit -am 'Add new feature'
4. Push to the branch: git push origin new-feature
5. Submit a pull request :D

Author
---

Yang Liu ( Harry ) from Worcester Polytechnic Institute

License
---
GPL