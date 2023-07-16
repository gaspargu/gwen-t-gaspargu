package cl.uchile.dcc
package gwent.controller

import gwent.states.{EndGame, GameState, Init}

import cl.uchile.dcc.gwent.Player
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.observer.{ISubject, Observer}

class GameController(private val players: List[Player]) extends Observer[String] {
  private var losePlayerMessage: String = "There is no losing player at the moment"

  def showLosingPlayer(): String = losePlayerMessage
  
  
  for (player <- players) {
    player.registerObserver(this)
  }
  

  override def update(o: ISubject[String], arg: String): Unit = {
    losePlayerMessage = arg + " lose the game"
    state = new EndGame(this)
  }

  var state: GameState = new Init(this)

  def finishInit() = state.finishInit()

  def flipCoin() = state.flipCoin()
  def playCard(card: Card): Unit = state.playCard(card)

  def changePlayer() = state.changePlayer()

  def pass() = state.pass()

  def draw3Card() = state.draw3Card()

  def gemsNot0() = state.gemsNot0()

  def someCountGemsIs0(message: String) = state.someCountGemsIs0(message)

}
