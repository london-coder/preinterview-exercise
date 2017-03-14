package exercise

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

import org.scalatest.{FlatSpec, Matchers}


class PreInterviewTest extends FlatSpec with Matchers {
	// psuedo product database
	private val inventory = Map("Apple" -> 60, "Orange" -> 25)
	// shopping basket representation
	private val basket: ListBuffer[String] = ListBuffer()

	// number and value of goods in the basket
	def checkOut(): Int = {
		basket map(inventory) sum
	}

	// format the cost of basket items in currency
	def formatCost(cost: Int): String = {
		val charge: Double = BigDecimal(cost.toDouble / 100).setScale(2, BigDecimal.RoundingMode.UP).toDouble
		f"£$charge"
	}

	"The inventory" should "include Apple" in {
		inventory contains("Apple") shouldBe true
	}

	"The price of an Apple" should "be 60 (pence)" in {
		inventory("Apple") should equal(60)
	}

	"The inventory" should "include Orange" in {
		inventory contains("Orange") shouldBe true
	}

	"The price of an Orange" should "be 25 (pence)" in {
		inventory("Orange") should equal(25)
	}

	"The inventory" should "contain 2 items" in {
		inventory.size should equal(2)
	}

	"The cost of 3 Apples and an Orange" should "be 205p" in {
		basket ++= List("Apple", "Apple", "Orange", "Apple")
		checkOut() should equal(205)
		basket.clear()
	}

	"The charge for 3 Apples and an Orange" should "be formatted as currency" in {
		basket ++= List("Apple", "Apple", "Orange", "Apple")
		formatCost(checkOut()) should equal("£2.05")
		basket.clear()
	}
}