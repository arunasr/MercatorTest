package uk.softar.Mercator

/*
 * (c) 2019-2022 Softar consulting limited. All rights reserved.
 */
case class BasketFromFile(fileName: String) extends BasketInterface {
  override def getItems: Seq[Product] = Seq.empty
}
