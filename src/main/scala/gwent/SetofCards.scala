package cl.uchile.dcc
package gwent

trait SetofCards {
  def draw(): Unit
  def add(card: Card): Unit
}
