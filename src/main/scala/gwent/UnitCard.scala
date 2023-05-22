package cl.uchile.dcc
package gwent

/** An abstract class representing a unit card.
 *
 * The unit card is defined by its name and attack points. A unit card is an abstract card and extends of the card class.
 *
 * @param name The name of the card.
 * @param atk The attack points of the card.
 *
 *
 */
class UnitCard(name: String, atk: Int) extends Card(name){
  def getAttack(): Int = atk

}
