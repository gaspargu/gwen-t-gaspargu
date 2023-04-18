package cl.uchile.dcc
package gwent

class CardTest extends munit.FunSuite{
  var magoOscuro: Card = null
  var magoOscuro2: Card = null
  var dragonBello: Card = null
  var nubecita: Card = null

  override def beforeEach(context: BeforeEach): Unit ={
    magoOscuro = new Card("Mago Oscuro")
    magoOscuro2 = new Card("Mago Oscuro")
    dragonBello = new Card("Dragón Bello")
    nubecita = new Card("Nubecita")
  }

  test("gets of name of cards") {
    assertEquals(magoOscuro.getName(),"Mago Oscuro")
    assertEquals(nubecita.getName(), "Nubecita")
  }

  test("equal") {
    assertEquals(magoOscuro, magoOscuro2)
    assertNotEquals(magoOscuro,nubecita)
    assertEquals(new Card("Dragón Bello"), dragonBello)
  }

}

