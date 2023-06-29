package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

class EndGame(private val context: GameController) extends GameState(context){
  override def isEndGame(): Boolean = true

}
