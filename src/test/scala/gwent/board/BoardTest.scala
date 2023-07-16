package cl.uchile.dcc
package gwent.board

import gwent.Player
import gwent.cards.{CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import cl.uchile.dcc.gwent.effects.{ClearWeather, NullEffect}

class BoardTest extends munit.FunSuite {
  var jugador1: Player = null
  var jugador2: Player = null
  var nullEffect: NullEffect = new NullEffect
  var clearWeather: ClearWeather = new ClearWeather
  var carta1: CloseCombatCard = new CloseCombatCard("carta1", "", 2, nullEffect)
  var carta2: CloseCombatCard = new CloseCombatCard("carta2", "", 3, nullEffect)
  var carta3: SiegeCombatCard = new SiegeCombatCard("carta3", "", 3, nullEffect)
  var carta4: SiegeCombatCard = new SiegeCombatCard("carta4", "", 7, nullEffect)
  var carta5: RangedCombatCard = new RangedCombatCard("carta5", "", 2, nullEffect)
  var carta6: RangedCombatCard = new RangedCombatCard("carta6", "", 6, nullEffect)
  var carta7: WeatherCard = new WeatherCard("rain", "", clearWeather)
  var carta8: WeatherCard = new WeatherCard("snow", "", clearWeather)
  var carta9: WeatherCard = new WeatherCard("fog", "", clearWeather)
  var notAvailableCard: WeatherCard = new WeatherCard("---", "", clearWeather)
  var board: Board = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugador1 = new Player("Jugador 1", 3, List(carta1, carta2), List(carta3, carta4, carta9))
    jugador2 = new Player("Jugador 2", 3, List(carta5, carta6), List(carta7, carta8))
    board = new Board(jugador1, jugador2)
  }

  test("player 1 play Siege Combat Card in board") {
    jugador1.playCard(carta4)
    assertEquals(jugador1.hand, List(carta3,carta9))
    assertEquals(board.zone1.siegeZone.show, List(carta4))
    assertEquals(board.zone1.rangedZone.show, List())
    assertEquals(board.zone1.closecombatZone.show, List())
  }

  test("player 1 draw card and play Close Combat Card in board") {
    jugador1.drawCard()
    jugador1.playCard(carta1)
    assertEquals(jugador1.hand, List(carta3, carta4, carta9))
    assertEquals(board.zone1.closecombatZone.show, List(carta1))
    assertEquals(board.zone1.rangedZone.show, List())
    assertEquals(board.zone1.siegeZone.show, List())
  }

  test("player 2 draw card and play Ranged Combat Card in board") {
    jugador2.drawCard()
    jugador2.playCard(carta5)
    assertEquals(jugador2.hand, List(carta7, carta8))
    assertEquals(board.zone2.closecombatZone.show, List())
    assertEquals(board.zone2.siegeZone.show, List())
    assertEquals(board.zone2.rangedZone.show, List(carta5))
  }

  test("player 2 play card that doesn't exit") {
    jugador2.playCard(notAvailableCard)
    assertEquals(jugador2.hand, List(carta7, carta8))
  }

  test("player 2 play weather card and player 1 too") {
    jugador2.playCard(carta7)
    assertEquals(jugador2.hand, List(carta8))
    assertEquals(board.weatherZone.show, carta7)
    jugador1.playCard(carta9)
    assertEquals(jugador1.hand, List(carta3,carta4))
    assertEquals(board.weatherZone.show, carta9)
  }


}
