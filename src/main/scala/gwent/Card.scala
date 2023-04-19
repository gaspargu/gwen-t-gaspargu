package cl.uchile.dcc
package gwent

class Card(name: String){
  def getName(): String = name

  override def toString: String = s"Card(name=$name)"

  /// Documentation inherited from [[Equals]]
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Card]) {
      val other_card = other.asInstanceOf[Card]
      name == other_card.getName()
    } else {
      false
    }
  }
}
