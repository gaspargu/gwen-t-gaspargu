package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.cards.Card

class Turn(private val context: GameController) extends GameState(context){
  override def isTurn(): Boolean = true

  override def playCard(card: Card): Unit = context.state = new EndTurn(context)
  override def pass(): Unit = context.state = new FreeTurn(context)
}
