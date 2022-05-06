package uk.softar.Mercator

object Main extends App {
  val prices = PriceFromFile("/prices.lst")
  val basket = BasketFromFile("/basket-1.txt")
  val checkout = Checkout(prices)
  val total = checkout.getTotal(basket)
  val (pounds, pence) = (total / 100, total % 100)
  println(f"Total: £$pounds.$pence%02d")
}
