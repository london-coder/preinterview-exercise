package exercise

import scala.collection.mutable.ListBuffer
import scala.math.BigDecimal.RoundingMode


object ShoppingCart {
	// shopping basket representation
	private val basket: ListBuffer[String] = ListBuffer()
	// psuedo product database
	val inventory = Map("Apple" -> 60, "Orange" -> 25).withDefaultValue(0)

	// number and value of goods in the basket
	def checkOut(): Double = {
		val total = basket.map(inventory).sum
		cost(total)
	}

	// format the cost of basket items in currency
	def formattedCost(cost: Double): String = {
		f"£$cost"
	}

	def cost(total: Int): Double = {
		BigDecimal(total.toDouble/100).setScale(2, RoundingMode.UP).toDouble
	}

	def checkOutWithOffers(): Double = {
		val numberOfApples = basket.count(_.equals("Apple"))
		val applePromo = Offers.bogof(numberOfApples) * inventory("Apple")

		val numberOfOranges = basket.count(_.equals("Orange"))
		val orangePromo = Offers.threeForTwo(numberOfOranges) * inventory("Orange")

		val total = applePromo + orangePromo
		cost(total)
	}

	def addItem(item: String): Unit = {
		basket += item
	}

	def addItems(items: List[String]): Unit = {
		basket ++= items
	}

	def clearBasket(): Unit = {
		basket.clear()
	}
}