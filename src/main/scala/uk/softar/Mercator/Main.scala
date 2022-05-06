package uk.softar.Mercator

object Main extends App {
  val prices = PriceFromFile("prices.lst")
  val basket = BasketFromFile("basket-1.txt")
  val checkout = Checkout(prices)
  val total = checkout.getTotal(basket)
  println(s"Total: £${total % 100}.${total / 100}")
}
