package br.unb.cic.ed

trait List {
  def size(): Int
  def insert(pos: Int, value: Int): Unit
  def elementAt(pos: Int): Option[Int]
  def remove(pos: Int): Option[Int]
  def find(value: Int): Option[Int]
}