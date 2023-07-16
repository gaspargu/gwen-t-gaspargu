package cl.uchile.dcc
package gwent.controller

import gwent.Player

import cl.uchile.dcc.gwent.cards.{Card, CloseCombatCard}
import cl.uchile.dcc.gwent.effects.{Effect, NullEffect}

class StateTest extends munit.FunSuite {
  var controller: GameController = null
  var jugador1: Player = null
  var jugador2: Player = null
  var card: Card = null
  var effect: Effect = new NullEffect

  override def beforeEach(context: BeforeEach): Unit = {
    jugador1 = new Player("Jugador 1", 3, List(), List())
    jugador2 = new Player("Jugador 2", 3, List(), List())
    controller = new GameController(List(jugador1,jugador2))
    card = new CloseCombatCard("","",1, effect)
  }

  test("controller start in Init state") {
    assert(controller.state.isInit())
    assert(!controller.state.isEndGame())
    assert(!controller.state.isInitRound())
    assert(!controller.state.isFreeTurn())
    assert(!controller.state.isTurn())
  }

  test("enter to other states") {
    controller.finishInit()
    assert(controller.state.isInitFirstRound())
    controller.flipCoin()
    assert(controller.state.isTurn())
    assert(!controller.state.isEndRound())
    controller.playCard(card)
    assert(controller.state.isEndTurn())
    controller.changePlayer()
    assert(controller.state.isTurn())
    controller.pass()
    assert(controller.state.isFreeTurn())
    controller.playCard(card)
    assert(controller.state.isFreeTurn())
    controller.pass()
    assert(controller.state.isEndRound())
  }

  test("Wrong state error") {
    var error = intercept[AssertionError] {
      controller.playCard(card)
    }
    assertEquals(error.getMessage, "Wrong state!")
    error = intercept[AssertionError] {
      controller.draw3Card()
    }
    assertEquals(error.getMessage, "Wrong state!")
  }

}
