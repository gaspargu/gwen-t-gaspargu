package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

class Init(private val context: GameController) extends GameState(context) {
  override def isInit(): Boolean = true

  override def finishInit(): Unit = context.state = new InitFirstRound(context)



}
