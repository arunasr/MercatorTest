package uk.softar.Mercator

import org.scalatest.flatspec._
import org.scalatest.matchers.should

class MainTest extends AnyFlatSpec with should.Matchers {
  "Main object" should "exist" in {
    Main.getClass should not be null
  }
}