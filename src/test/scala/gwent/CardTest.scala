package cl.uchile.dcc
package gwent

class GwentTest extends munit.FunSuite{
  var magoOscuro: Card = null
  var dragonBello: Card = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugadorPepe = new Player("Pepe",10, )
    magoOscuro = new Card()
  }
}
