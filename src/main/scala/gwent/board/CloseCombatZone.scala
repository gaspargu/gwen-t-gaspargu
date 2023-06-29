package cl.uchile.dcc
package gwent.board

import gwent.Player

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, CloseCombatCard}

/** Class representing a close combat zone in the [[Board]].
 *
 * A `RangedZone` is a type of [[CombatZone]].
 * In this zone the player only can play cards of type [[CloseCombatCard]].
 *
 * @param player
 */

class CloseCombatZone(val player: Player) extends CombatZone{
  var list: List[CloseCombatCard] = List()

  def addCard(card: CloseCombatCard): Unit = {
    for (c <- list) {
      card.effect.register
    }
    list = card :: list
  }

  def putCloseCombatCard(card: Card): Unit = card.putInCloseCombatZone(this)
  
  def show: List[CloseCombatCard] = list

}
