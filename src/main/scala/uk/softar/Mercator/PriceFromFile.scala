package uk.softar.Mercator

import scala.io.Source

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */

case class PriceFromFile(fileName: String) extends PriceProvider {
  /** Build map of Product -> Price */
  private val prices = Map.from(
    Source.fromInputStream(getClass.getResourceAsStream(fileName)
    ).getLines()
      .map(_.split(','))
      .collect({
        case Array(product, price) ⇒ product -> price.toInt
      }))

  override def getPrice(product: Product): Price = prices(product)
}