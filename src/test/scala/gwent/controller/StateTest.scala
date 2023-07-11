package cl.uchile.dcc
package gwent.controller

class StateTest extends munit.FunSuite {
  var controller: GameController = null

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController
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
