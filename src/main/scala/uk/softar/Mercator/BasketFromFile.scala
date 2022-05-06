package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */

import scala.io.Source

case class BasketFromFile(fileName: String) extends BasketInterface {
  private val items = Seq.from(
    Source.fromInputStream(getClass.getResourceAsStream(fileName)).getLines filter (_.nonEmpty)
  )

  override def getItems: Seq[Product] = items

}
