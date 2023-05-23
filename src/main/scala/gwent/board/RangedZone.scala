package cl.uchile.dcc
package gwent.board

import gwent.Player

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, RangedCombatCard}

class RangedZone(val player: Player) extends CombatZone {
  var list: List[RangedCombatCard] = List()

  def addCard(card: RangedCombatCard): Unit = {
    list = card :: list
  }
  
  def putRangedCard(card: Card): Unit = card.putInRangedZone(this)
}

