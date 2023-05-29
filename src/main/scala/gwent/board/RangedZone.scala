package cl.uchile.dcc
package gwent.board

import gwent.Player

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, RangedCombatCard}

/** Class representing a ranged zone in the [[Board]].
 * 
 * A `RangedZone` is a type of [[CombatZone]].
 * In this zone the player only can play cards of type [[RangedCombatCard]].
 * 
 * @param player
 */
class RangedZone(val player: Player) extends CombatZone {
  private var list: List[RangedCombatCard] = List()

  def addCard(card: RangedCombatCard): Unit = {
    list = card :: list
  }
  
  def putRangedCard(card: Card): Unit = card.putInRangedZone(this)

  def show: List[RangedCombatCard] = list
}

