package uk.softar.Mercator

import org.scalatest.flatspec._
import org.scalatest.matchers.should

class MainTest extends AnyFlatSpec with should.Matchers {
  private val priceProvider = new PriceProvider {
    private val prices = Map("Apple" → 60, "Orange" → 25)

    override def getPrice(product: Product): Price =
      prices(product)
  }

  case class TestBasket(val products: Seq[PriceProvider#Product]) extends BasketInterface {
    override def getItems: Seq[Product] = products
  }

  "Prices" should "be correct" in {
    priceProvider getPrice "Apple" shouldEqual 60
    priceProvider getPrice "Orange" shouldEqual 25
  }

  "Checkout" should "return correct totals" in {
    val checkout = Checkout(priceProvider)
    checkout.getTotal(TestBasket(Seq.empty), Seq.empty) shouldEqual 0
    checkout.getTotal(TestBasket(Seq("Apple")), Seq.empty) shouldEqual 60
    checkout.getTotal(TestBasket(Seq("Orange")), Seq.empty) shouldEqual 25
    checkout.getTotal(TestBasket("Apple,Apple,Orange,Apple".split(',')), Seq.empty) shouldEqual 205
  }

  it should "apply correct promotion discounts" in {
    val promotion = new PromotionInterface {
      override def getDiscount(basket: BasketInterface): Price = 30
    }
    val checkout = Checkout(priceProvider)
    checkout.getTotal(TestBasket("Apple,Apple,Orange,Apple".split(',')), Seq(promotion)) shouldEqual 175
  }
}