package cl.uchile.dcc
package gwent.board

import gwent.*

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, SiegeCombatCard}

class SiegeZone(val player: Player) extends CombatZone {
  var list: List[SiegeCombatCard] = List()

  def addCard(card: SiegeCombatCard): Unit = {
    list = card :: list
  }

  
  def putSiegeCard(card: Card): Unit = card.putInSiegeZone(this)
  
  
}
