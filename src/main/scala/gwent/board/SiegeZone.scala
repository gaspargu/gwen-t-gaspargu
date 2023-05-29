package cl.uchile.dcc
package gwent.board

import gwent.*

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, SiegeCombatCard}

/** Class representing a siege zone in the [[Board]].
 *
 * A `RangedZone` is a type of [[CombatZone]].
 * In this zone the player only can play cards of type [[SiegeCombatCard]].
 *
 * @param player
 */

class SiegeZone(val player: Player) extends CombatZone {
  private var list: List[SiegeCombatCard] = List()

  def addCard(card: SiegeCombatCard): Unit = {
    list = card :: list
  }

  
  def putSiegeCard(card: Card): Unit = card.putInSiegeZone(this)

  def show: List[SiegeCombatCard] = list
  
  
}
