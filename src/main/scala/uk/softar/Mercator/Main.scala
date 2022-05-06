package uk.softar.Mercator

object Main extends App {
  val prices = PriceFromFile("/prices.lst")
  val basket = BasketFromFile("/basket-1.txt")

  val applesBogof = new PromotionInterface {
    override def getDiscount(basket: BasketInterface): Price =
      basket.getItems.count(_ == "Apple") / 2 * prices.getPrice("Apple")
  }

  val oranges3for2 = new PromotionInterface {
    override def getDiscount(basket: BasketInterface): Price =
      basket.getItems.count(_ == "Orange") / 3 * prices.getPrice("Orange")
  }

  val promotions = Seq(
    applesBogof,
    oranges3for2
  )
  val checkout = Checkout(prices)
  val total = checkout.getTotal(basket, promotions)
  val (pounds, pence) = (total / 100, total % 100)
  println(f"Total: £$pounds.$pence%02d")
}
