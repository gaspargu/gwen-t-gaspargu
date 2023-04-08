package cl.uchile.dcc
package gwent

class CardTest extends munit.FunSuite{
  var magoOscuro: Card = null
  var dragonBello: Card = null
  var nubecita: Card = null

  override def beforeEach(context: BeforeEach): Unit ={
    magoOscuro = new Card("Mago Oscuro")
    dragonBello = new Card("Dragón Bello")
    nubecita = new Card("Nubecita")
  }

  test("equals") {
    assertEquals(magoOscuro, magoOscuro)
    assertNotEquals(magoOscuro, dragonBello)
  }

  test("gets") {
    assertEquals(magoOscuro.getName(),"Mago Oscuro")
    assertEquals(nubecita.getName(), "Nubecita")
  }
}

