package cl.uchile.dcc
package gwent.controller

import gwent.Player

class StateTest extends munit.FunSuite {
  var controller: GameController = null
  var jugador1: Player = null
  var jugador2: Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugador1 = new Player("Jugador 1", 3, List(), List())
    jugador2 = new Player("Jugador 2", 3, List(), List())
    controller = new GameController(List(jugador1,jugador2))
  }

  test("controller start in Init state") {
    assert(controller.state.isInit())
    assert(!controller.state.isEndGame())
    assert(!controller.state.isInitRound())
  }

  test("enter to other states") {
    controller.finishInit()
    assert(controller.state.isInitFirstRound())
    controller.flipCoin()
    assert(controller.state.isTurn())
    assert(!controller.state.isEndRound())
  }

}
