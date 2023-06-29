package cl.uchile.dcc
package gwent.controller

import gwent.states.{GameState, Init}

import cl.uchile.dcc.gwent.cards.Card

class GameController {

  var state: GameState = new Init(this)

  def finishInit() = state.finishInit()

  def flipCoin() = state.flipCoin()
  def playCard(card: Card): Unit = state.playCard(card)

  def changePlayer() = state.changePlayer()

  def pass() = state.pass()

  def draw3Card() = state.draw3Card()

  def gemsNot0() = state.gemsNot0()

  def someCountGemsIs0() = state.someCountGemsIs0()

}
