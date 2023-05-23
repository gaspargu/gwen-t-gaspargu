package cl.uchile.dcc
package gwent.board

import gwent.Player

import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, CloseCombatCard}

class CloseCombatZone(val player: Player) extends CombatZone{
  var list: List[CloseCombatCard] = List()

  def addCard(card: CloseCombatCard): Unit = {
    list = card :: list
  }

  def putCloseCombatCard(card: Card): Unit = card.putInCloseCombatZone(this)

}
