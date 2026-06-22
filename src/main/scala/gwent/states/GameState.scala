package cl.uchile.dcc
package gwent.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.cards.Card

abstract class GameState(private val context: GameController) {
  def isInit() = false
  def isInitFirstRound() = false
  def isInitRound() = false
  def isTurn() = false
  def isEndTurn() = false
  def isFreeTurn() = false
  def isEndRound() = false
  def isEndGame() = false

  def error(): Unit = throw new AssertionError("Wrong state!")

  def finishInit() = error()

  def flipCoin() = error()

  def playCard(card: Card) = error()
  def changePlayer() = error()
  def pass() = error()
  def draw3Card() = error()
  def gemsNot0() = error()
  def someCountGemsIs0(messaje: String) = error()

}
