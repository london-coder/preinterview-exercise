package exercise


import org.scalatest.{FlatSpec, Matchers}


class PreInterviewTest extends FlatSpec with Matchers {

	"The inventory" should "include Apple" in {
		ShoppingCart.inventory contains("Apple") shouldBe true
	}

	"The price of an Apple" should "be 60 (pence)" in {
		ShoppingCart.inventory("Apple") should equal(60)
	}

	"The inventory" should "include Orange" in {
		ShoppingCart.inventory contains("Orange") shouldBe true
	}

	"The price of an Orange" should "be 25 (pence)" in {
		ShoppingCart.inventory("Orange") should equal(25)
	}

	"The inventory" should "contain 2 items" in {
		ShoppingCart.inventory.size should equal(2)
	}

	"The cost of 3 Apples and an Orange" should "be 205p" in {
		ShoppingCart.addItems(List("Apple", "Apple", "Orange", "Apple"))
		ShoppingCart.checkOut() should equal(2.05)
		ShoppingCart.clearBasket()
	}

	"The charge for 3 Apples and an Orange" should "be formatted as currency" in {
		ShoppingCart.addItems(List("Apple", "Apple", "Orange", "Apple"))
		ShoppingCart.formattedCost(ShoppingCart.checkOut()) should equal("£2.05")
		ShoppingCart.clearBasket()
	}

	// STEP 2 with promotions
	"Apple promotion" should "be buy one get one free" in {
		ShoppingCart.addItems(List("Apple", "Apple", "Apple"))
		ShoppingCart.checkOutWithOffers() should equal(1.20) // 3 apples
		ShoppingCart.clearBasket()
	}

	"Apple promotion" should "cost 2 apples when buying 4" in {
		ShoppingCart.addItems(List("Apple", "Apple", "Apple", "Apple"))
		ShoppingCart.checkOutWithOffers() should equal(1.20) // 4 apples
		ShoppingCart.clearBasket()
	}

	"Apple promotion" should "cost 3 apples when buying 5" in {
		ShoppingCart.addItems(List("Apple", "Apple", "Apple", "Apple", "Apple"))
		ShoppingCart.checkOutWithOffers() should equal(1.80) // 5 apples
		ShoppingCart.clearBasket()
	}

	"Orange promotion" should "be three for the price of two" in {
		ShoppingCart.addItems(List("Orange", "Orange"))
		ShoppingCart.checkOutWithOffers() should equal(0.50)
		ShoppingCart.addItem("Orange") // 3 oranges
		ShoppingCart.checkOutWithOffers() should equal(0.50)
		ShoppingCart.clearBasket()
	}

	"Orange promotion" should "cost 3 oranges when buying 4" in {
		ShoppingCart.addItems(List("Orange", "Orange", "Orange", "Orange"))
		ShoppingCart.checkOutWithOffers() should equal(0.75)
		ShoppingCart.clearBasket()
	}

	"Orange promotion" should "cost 4 oranges when buying 5" in {
		ShoppingCart.addItems(List("Orange", "Orange", "Orange", "Orange", "Orange"))
		ShoppingCart.checkOutWithOffers() should equal(1.00)
	}

	it should "cost 4 oranges when buying 6" in {
		ShoppingCart.addItem("Orange")
		ShoppingCart.checkOutWithOffers() should equal(1.00)
		ShoppingCart.clearBasket()
	}

	it should "cost 5 oranges when buying 7" in {
		ShoppingCart.addItems(List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange"))
		ShoppingCart.checkOutWithOffers() should equal(1.25)
		ShoppingCart.clearBasket()
	}
}