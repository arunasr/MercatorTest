package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */

case class PriceFromFile(fileName: String) extends PriceProvider {
  override def getPrice(product: Product): Price = 0
}