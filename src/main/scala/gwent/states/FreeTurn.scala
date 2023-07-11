package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.cards.Card

class FreeTurn(private val context: GameController) extends GameState(context) {
  override def isFreeTurn(): Boolean = true

  override def playCard(card: Card): Unit = {}
  override def pass(): Unit = new EndRound(context)
}
