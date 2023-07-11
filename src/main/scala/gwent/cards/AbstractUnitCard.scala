package cl.uchile.dcc
package gwent.cards

import gwent.board.{CloseCombatZone, RangedZone, SiegeZone}

import cl.uchile.dcc.gwent.effects.{CombatEffect, Effect}
import cl.uchile.dcc.gwent.observer.{ISubject, Observer}

/** Abstract class representing a unit card in the Gwen't game.
 *
 * An `AbstractUnitCard` is a type of [[Card]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, description, and
 *              power.
 * @param name The name of the card.
 * @param description The description of the card, explaining its specific abilities or
 *                    role in the game.
 * @param power The base power of the card, indicating the contribution of this card to
 *              the player's total power when unaffected by any special conditions.
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractUnitCard(private val _name: String, private val _description: String,
                                private val _power: Int, private val _effect:CombatEffect)
  extends Card with Observer[Int] {

  def power: Int = _power

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[_power]] of the card.
   */
  var currentPower: Int = _power

  def getCurrentPower: Int = currentPower
  
  def setCurrentPower(newPower: Int): Unit = currentPower = newPower

  def update(o: ISubject[Int], arg: Int): Unit = {
    setCurrentPower(getCurrentPower + arg)
  }

  

  
}
