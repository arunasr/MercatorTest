package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */
trait BasketInterface {
  type Product = PriceProvider#Product

  def getItems: Seq[Product]
}