package cl.uchile.dcc
package gwent

import gwent.cards.{CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import cl.uchile.dcc.gwent.effects.{ClearWeather, NullEffect}

class PlayerTest extends munit.FunSuite {
  var jugador1: Player = null
  var jugador2: Player = null
  var nullplayer: Player = null
  var nullEffect: NullEffect = new NullEffect
  var clearWeather: ClearWeather = new ClearWeather
  var carta1: CloseCombatCard = new CloseCombatCard("carta1","",2, nullEffect)
  var carta2: CloseCombatCard = new CloseCombatCard("carta2","",3, nullEffect)
  var carta3: SiegeCombatCard = new SiegeCombatCard("carta3","",3, nullEffect)
  var carta4: SiegeCombatCard = new SiegeCombatCard("carta4","",7, nullEffect)
  var carta5: RangedCombatCard = new RangedCombatCard("carta5","",2, nullEffect)
  var carta6: RangedCombatCard = new RangedCombatCard("carta6","", 6, nullEffect)
  var carta7: WeatherCard = new WeatherCard("rain","", clearWeather)
  var carta8: WeatherCard = new WeatherCard("snow", "", clearWeather)

  override def beforeEach(context: BeforeEach): Unit= {
    jugador1 = new Player("Jugador 1", 3, List(carta1, carta2), List(carta3,carta4))
    jugador2 = new Player("Jugador 2",3,List(carta5,carta6), List(carta7,carta8))
  }

  test("equals and not equals") {
    assertEquals(jugador1, new Player("Jugador 1", 3, List(carta1, carta2), List(carta3,carta4)))
    assertNotEquals(jugador1, jugador2)
    assertNotEquals(jugador2, nullplayer)
  }

  test("player play card") {
    assertEquals(jugador1.chooseCard(carta3).get,
      new SiegeCombatCard("carta3","",3, nullEffect))
    assertEquals(jugador1.hand, List(carta4))
  }

  test("player draw card") {
    assertEquals(jugador2.drawCard(), carta5)
    assertEquals(jugador2.deck, List(carta6))
    assertEquals(jugador2.hand, List(carta5,carta7,carta8))
  }

  test("shuffle deck") {
    val lenDeck = jugador1.deck.length
    jugador1.shuffleDeck()
    assertEquals(jugador1.deck.length,lenDeck)
  }
}
