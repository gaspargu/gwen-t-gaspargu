package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

class InitRound(private val context: GameController) extends GameState(context){
  override def isInitRound(): Boolean = true

  override def draw3Card(): Unit = context.state = new Turn(context)
}
