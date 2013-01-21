package intro

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class IntroTest extends FunSuite with ShouldMatchers {
  test("doing something") {
    val f = new Intro
    f.foo should be(1)
  }
}