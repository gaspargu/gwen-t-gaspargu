package cl.uchile.dcc
package gwent

/** A class representing a card.
 *
 * The card is defined by its name.
 *
 * @param name The name of the card.
 *
 * @constructor Creates a new card with the specified name.
 *
 * @example
 * {{{
 * val card = new Card("Dark Dragon")
 * val name = card.getName()
 * println(s"The name of the card is $name")
 * }}}
 *
 */

class Card(name: String){
  def getName(): String = name

  override def toString: String = s"Card(name=$name)"

  /// Documentation inherited from [[Equals]]
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Card]) {
      val other_card = other.asInstanceOf[Card]
      name == other_card.getName()
    } else false
  }
}
