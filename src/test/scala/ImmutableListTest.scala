package br.unb.cic.ed

import org.scalatest.funsuite.AnyFunSuite

import br.unb.cic.ed.ImmutableList.{head, size, elementAt, find, remove, add}

class ImmutableListTest extends AnyFunSuite {
  test("Fetching head of empty list returns None") {
    val list = new Empty()

    assert(head(list).isEmpty)
  }

  test("Fetching head of non-empty list return the list's first element") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(head(list).contains(1))
  }

  test("Size of empty list must be 0") {
    val list = Empty()

    assert(0 == size(list))
  }

  test("Size of list with 3 elements must be 3") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(3 == size(list))
  }

  test ("Fetching element on an empty list returns None") {
    val list = Empty()

    assert(elementAt(list, 0).isEmpty)
  }

  test("Fetching element at a valid position returns its value") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(elementAt(list, 0).contains(1))
    assert(elementAt(list, 1).contains(10))
    assert(elementAt(list, 2).contains(100))
  }

  test("Fetching element at a invalid position returns None") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(elementAt(list, -1).isEmpty)
    assert(elementAt(list, 3).isEmpty)
  }

  test("Fetching element present in list should return it") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(find(list, 100).contains(100))
  }

  test("Fetching element not present in list should return None") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(find(list, 1000).isEmpty)
  }

  test("Adding element to list puts it at the end of the list") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))
    val emptyList = Empty()

    assert(add(list, 1000) == Cons(1, Cons(10, Cons(100, Cons(1000, Empty())))))
    assert(add(emptyList, 1000) == Cons(1000, Empty()))
  }

  test("Removing element present in list should return a list without that element") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(remove(list, 1).contains(Cons(1, Cons(100, Empty()))))
  }

  test("Removing element not present in list should return None") {
    val list = Cons(1, Cons(10, Cons(100, Empty())))

    assert(remove(list, 3).isEmpty)
  }
}
