package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

class EndRound(private val context: GameController) extends GameState(context){
  override def isEndRound(): Boolean = true

  override def gemsNot0(): Unit = context.state = new InitRound(context)

  override def someCountGemsIs0(message: String): Unit = {
    context.state = new EndGame(context)
  }
}
