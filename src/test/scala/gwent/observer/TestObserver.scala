package cl.uchile.dcc
package gwent.observer

import gwent.Player
import gwent.controller.GameController

import cl.uchile.dcc.gwent.states.{EndRound, InitFirstRound}

class TestObserver extends munit.FunSuite {
  var controller: GameController = null
  var jugador1: Player = null
  var jugador2: Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugador1 = new Player("Jugador 1", 1, List(), List())
    jugador2 = new Player("Jugador 2", 3, List(), List())
    controller = new GameController(List(jugador1, jugador2))
  }

  test("Jugador 1 lose the game") {
    controller.state = new EndRound(controller)
    assertEquals(controller.showLosingPlayer(), "There is no losing player at the moment")
    jugador1.lostGem()
    assert(controller.state.isEndGame())
    assertEquals(controller.showLosingPlayer(), "Jugador 1 lose the game")
  }






}


