package br.unb.cic.ed

import org.scalatest.funsuite.AnyFunSuite

class ArrayListTest extends AnyFunSuite {
  test("An empty ArryList must have size == 0") {
    val arr = new ArrayList()
    assert(0 == arr.size())
  }

  test("An ArrayList with 5 elements must have size == 5") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 1)
    arr.insert(2, 1)
    arr.insert(3, 1)
    arr.insert(4, 1)

    assert(5 == arr.size())
  }

  test("Element on index 1 in list [1, 10 ,100] must be 10") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 10)
    arr.insert(2, 100)

    assert(arr.elementAt(1).contains(10))
  }

  test("Element on index 0 in list [1, 10 ,100] must be 1") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 10)
    arr.insert(2, 100)

    assert(arr.elementAt(0).contains(1))
  }

  test("Fetching element in position lower than 0 should return None") {
    val arr = new ArrayList()
    arr.insert(0, 1)

    assert(arr.elementAt(-1).isEmpty)
    assert(arr.elementAt(1).isEmpty)
  }

  test("Remove element in valid position returns that element") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 10)

    assert(arr.remove(1).contains(10))
  }

  test("Remove element in valid position decreases array's size") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 10)

    assert(arr.size() == 2)
    arr.remove(1)
    assert(arr.size() == 1)
  }

  test("Finding value present in array returns that element") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 10)

    assert(arr.find(10).contains(10))
  }

  test("Finding value not present in array returns None") {
    val arr = new ArrayList()
    arr.insert(0, 1)
    arr.insert(1, 10)

    assert(arr.find(2).isEmpty)
  }
}