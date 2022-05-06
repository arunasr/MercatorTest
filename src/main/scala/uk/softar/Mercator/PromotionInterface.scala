package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */

/**
 * Interface to get discount applicable to a basket
 */
trait PromotionInterface {
  type Price = PriceProvider#Price

  def getDiscount(basket: BasketInterface): Price
}
