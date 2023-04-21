package cl.uchile.dcc
package gwent

import scala.collection.mutable.ListBuffer

class Hand(private var hand: ListBuffer[Card]) extends AbstractListOfCards(hand) {
  override def toString: String = s"Hand(hand=$hand)"
  
  def chooseCard(name: String): Option[Card] = {
    for (i <- hand.indices) {
      if (hand(i).getName()==name) {
        return Some(hand.remove(i))
      }
    }
    println("You don't have that card")
    None
  }

  def addCard(card: Card): Unit = {
    hand += card
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Hand]) {
      val other_hand = other.asInstanceOf[Hand]
      hand == other_hand.getList()
    } else {
      false
    }
  }
}
