# Moving Average of the Last N Elements Added
[![][license img]][license]
[![docs-badge][]][docs]
![Java CI](https://github.com/EOnyenezido/file-sorter/workflows/Java%20CI%20with%20Maven/badge.svg)

This project defines an interface that for a data structure that can provide the moving average of the last N elements added.

The interface basically defines 6 functions;
* Adding an element
* Getting an element
* Getting the last N elements in the order they were added
* Getting the average of the last N elements added
* Getting the value of N, the window size
* Changing the value of N, the window size

An implementation of the interface for integers is also provided, along with tests and documentation.

The implementation essentially uses an `array` of length N to maintain the last N elements added. The `sum` and `count` of all the elements in the array is also maintained.
When a new element is added to the `array` it is added to the `sum` and the last N + 1 element is removed from the `sum` and the `average` is returned as `(sum / count)`.

[license]:https://github.com/EOnyenezido/moving-average/blob/main/LICENSE
[license img]:https://img.shields.io/badge/License-Apache%202-blue.svg

[docs-badge]:https://img.shields.io/badge/API-docs-blue.svg?style=flat-square
[docs]:https://eonyenezido.github.io/moving-average/	
