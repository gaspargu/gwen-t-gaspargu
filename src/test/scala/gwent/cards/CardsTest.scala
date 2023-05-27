package cl.uchile.dcc
package gwent.cards

class CardsTest extends munit.FunSuite {
  var card1: CloseCombatCard = null
  var card2: SiegeCombatCard = null
  var card3: RangedCombatCard = null
  var closecombatCard: CloseCombatCard = null
  var siegeCard: SiegeCombatCard = null
  var rangeCard: Range = null
  var wheatherCard: WeatherCard = null
  var null_card: SiegeCombatCard = null

  override def beforeEach(context: BeforeEach): Unit= {
    card1 = new CloseCombatCard("carta 1","bla",10)
    card2 = new SiegeCombatCard("carta 2","bla",5)
    card3 = new RangedCombatCard("carta 3","bla",4)
  }

  test("equals") {
    assertEquals(card1, new CloseCombatCard("carta 1", "bla",10))
    assertEquals(card2, new SiegeCombatCard("carta 2", "bla", 5))
    assertEquals(card3, new RangedCombatCard("carta 3", "bla", 4))
  }
}


