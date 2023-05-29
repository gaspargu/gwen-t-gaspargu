package cl.uchile.dcc
package gwent.cards

class CardsTest extends munit.FunSuite {
  var card1: CloseCombatCard = null
  var card2: SiegeCombatCard = null
  var card3: RangedCombatCard = null
  var nullCard: SiegeCombatCard = null
  var wrongCard: SiegeCombatCard = null
  var weatherCard: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit= {
    card1 = new CloseCombatCard("carta 1","bla",10)
    card2 = new SiegeCombatCard("carta 2","bla",5)
    card3 = new RangedCombatCard("carta 3","bla",4)
    weatherCard = new WeatherCard("rain", "a thing that wets things")
  }

  test("equals") {
    assertEquals(card1, new CloseCombatCard("carta 1", "bla",10))
    assertEquals(card2, new SiegeCombatCard("carta 2", "bla", 5))
    assertEquals(card3, new RangedCombatCard("carta 3", "bla", 4))
    assertEquals(weatherCard, new WeatherCard("rain", "a thing that wets things"))
  }

  test("not equals") {
    assertNotEquals(card1, new CloseCombatCard("carta1", "bla", 10))
    assertNotEquals(card2, nullCard)
    assert(card1 != card2)
    assert(card3 != new CloseCombatCard(".",".",0))
    assert(weatherCard != nullCard)
  }

  test("toString method") {
    assertEquals(card1.toString, "CloseCombatCard(carta 1, bla, 10)")
    assertEquals(card2.toString, "SiegeCombatCard(carta 2, bla, 5)")
    assertEquals(card3.toString, "RangedCombatCard(carta 3, bla, 4)")
    assertEquals(weatherCard.toString, "WeatherCard(rain, a thing that wets things)")
  }

  test("show the power of a Unit Card") {
    assertEquals(card3.power, 4)
  }
}


