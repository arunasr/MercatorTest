package uk.softar.Mercator

import org.scalatest.flatspec._
import org.scalatest.matchers.should

class MainTest extends AnyFlatSpec with should.Matchers {
  private val priceProvider = new PriceProvider {
    private val prices = Map("Apple" → 60, "Orange" → 25)

    override def getPrice(product: Product): Price =
      prices(product)
  }

  "Prices" should "be correct" in {
    priceProvider getPrice "Apple" shouldEqual 60
    priceProvider getPrice "Orange" shouldEqual 25
  }

  "Checkout" should "return correct totals" in {
    val checkout = Checkout(priceProvider)
    case class TestBasket(val products: Seq[PriceProvider#Product]) extends BasketInterface {
      override def getItems: Seq[Product] = products
    }
    checkout getTotal TestBasket(Seq.empty) shouldEqual 0
    checkout getTotal TestBasket(Seq("Apple")) shouldEqual 60
    checkout getTotal TestBasket(Seq("Orange")) shouldEqual 25
    checkout getTotal TestBasket("Apple,Apple,Orange,Apple".split(',')) shouldEqual 205
  }
}