package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */
case class Checkout(prices: PriceProvider) {
  type Price = PriceProvider#Price

  def getTotal(basket: BasketInterface, promotions: Seq[PromotionInterface]): Price = {
    val price = basket.getItems
      .map(prices.getPrice)
      .sum
    val discount = promotions.map(_.getDiscount(basket)).sum
    price - discount
  }
}
