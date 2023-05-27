package cl.uchile.dcc
package gwent.cards
import gwent.board.{CloseCombatZone, RangedZone, SiegeZone, WeatherZone}

/** Class representing a close combat unit card in the Gwen't game.
 *
 * A `CloseCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `CloseCombatCard` with a specified name, description, and
 *              power.
 * @param name the name of the card.
 * @param description the description of the card.
 * @param power the initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */

class CloseCombatCard(private val _name: String, private val _description: String, private val _power: Int)
  extends AbstractUnitCard(_name, _description, _power) {
  def name: String = _name
  def description: String = _description
  override def putInCloseCombatZone(zone: CloseCombatZone): Unit = zone.addCard(this)
  override def putInSiegeZone(zone: SiegeZone): Unit = {}
  override def putInRangedZone(zone: RangedZone): Unit = {}
  override def putInWeatherzone(zone: WeatherZone): Unit = {}
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CloseCombatCard]) {
      val card = obj.asInstanceOf[CloseCombatCard]
      (card.name == _name && card.description == _description && card.currentPower == _power)
    } else {
      false
    }
  }
  
  
  
}
