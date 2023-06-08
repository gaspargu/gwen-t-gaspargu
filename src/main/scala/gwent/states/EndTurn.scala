package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

class EndTurn(private val context: GameController) extends GameState(context) {
  override def isEndTurn(): Boolean = true

  override def changePlayer(): Unit = context.state = new Turn(context)
}
