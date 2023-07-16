package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

class InitFirstRound(private val context: GameController) extends GameState(context){
  override def isInitFirstRound(): Boolean = true
  
  override def flipCoin(): Unit = context.state = new Turn(context)
}
