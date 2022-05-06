package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */

trait PriceProvider {
  type Product = String
  type Price = Int

  def getPrice(product: Product): Price
}
