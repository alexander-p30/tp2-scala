package br.unb.cic.ed

class ArrayList extends List {
  val elements = new Array[Int](10)
  var total = 0

  def size(): Int = total

  def insert(pos: Int, value: Int): Unit = {
    if(pos >= 0 && pos <= total) {
      elements(pos) = value
      total += 1
    }
  }

  def elementAt(pos: Int): Option[Int] = if(withinArraySize(pos)) Some(elements(pos)) else None

  def remove(pos: Int): Option[Int] = {
    if(withinArraySize(pos)) {
      val originalValue = elements(pos)
      elements(pos) = if(pos < total) elements(pos + 1) else 0
      total -= 1
      Some(originalValue)
    } else {
      None
    }
  }

  def find(value: Int): Option[Int] = elements.find(element => element == value)

  private def withinArraySize(pos: Int): Boolean = pos >= 0 && pos < total
}