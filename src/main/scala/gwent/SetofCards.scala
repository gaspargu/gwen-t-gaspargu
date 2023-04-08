package cl.uchile.dcc
package gwent

trait SetofCards {
  def draw(): Card
  def add(card: Card): Unit
}
