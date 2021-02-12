package br.unb.cic.ed

import scala.annotation.tailrec

trait ImmutableList

case class Empty() extends ImmutableList

case class Cons(head: Int, tail: ImmutableList) extends ImmutableList

object ImmutableList {
  def head(list: ImmutableList): Option[Int] = list match {
    case Empty() => None
    case Cons(head, tail) => Some(head)
  }

  def size(list: ImmutableList): Int = list match {
    case Empty() => 0
    case Cons(head, tail) => 1 + size(tail)
  }

  def elementAt(list: ImmutableList, pos: Int): Option[Int] =
    if (withinListSize(list, pos)) elementAt(list, pos, 0) else None

  @tailrec
  private def elementAt(list: ImmutableList, pos: Int, acc: Int): Option[Int] = list match {
    case Empty() => None
    case Cons(head, tail) => if (acc == pos) Some(head) else elementAt(tail, pos, acc + 1)
  }

  @tailrec
  def find(list: ImmutableList, value: Int): Option[Int] = list match {
    case Empty() => None
    case Cons(head, tail) => if (head == value) Some(head) else find(tail, value)
  }

  def add(list: ImmutableList, value: Int): ImmutableList = list match {
    case Empty() => Cons(value, Empty())
    case Cons(head, tail) => Cons(head, add(tail, value))
  }

  def remove(list: ImmutableList, pos: Int): Option[ImmutableList] = if(withinListSize(list, pos)) {
    remove(list, pos, 0, Empty())
  } else {
    None
  }

  @tailrec
  private def remove(list: ImmutableList, pos: Int, acc: Int, listAcc: ImmutableList): Option[ImmutableList] = list match {
    case Empty() => Some(listAcc)
    case Cons(head, tail) =>
      if (acc == pos) remove(tail, pos, acc + 1, listAcc) else remove(tail, pos, acc + 1, add(listAcc, head))
  }

  private def withinListSize(list: ImmutableList, index: Int): Boolean = index >= 0 && index < size(list)
}
