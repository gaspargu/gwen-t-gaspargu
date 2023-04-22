package cl.uchile.dcc
package gwent

class UnitCardTest extends munit.FunSuite {
  var closecombatCard: CloseCombat = null
  var siegeCard: Siege = null
  var rangeCard: Range = null
  var wheatherCard: WeatherCard = null
  var null_card: Siege = null
  override def beforeEach(context: BeforeEach): Unit = {
    closecombatCard = new CloseCombat("Close Combat", 10)
    siegeCard = new Siege("Siege", 3)
    rangeCard = new Range("Range", 4)
    wheatherCard = new WeatherCard("Weather")
  }

  test("equals and not equals") {
    assertEquals(closecombatCard, new CloseCombat("Close Combat",10))
    assertEquals(siegeCard, new Siege("Siege",3))
    assertEquals(rangeCard, new Range("Range",4))
    assertEquals(wheatherCard, new WeatherCard("Weather"))
    assertNotEquals(siegeCard, null_card)
  }
}
