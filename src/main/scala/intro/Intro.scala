package intro

object Intro extends App {
  val f = new Intro
  println("Foo: " + f.foo)
}

class Intro {
  def foo = 1
}