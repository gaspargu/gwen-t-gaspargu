package cl.uchile.dcc
package gwent.observer

trait Observer[T] {
  def update(o: ISubject[T], arg: T): Unit
}
