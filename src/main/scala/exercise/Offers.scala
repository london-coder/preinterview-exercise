package exercise

object Offers {
	
	// Apple promotion
	def bogof(productCount: Int): Int = {
		(productCount / 2) + (productCount % 2)
	}
	// Orange promotion
	def threeForTwo(productCount: Int): Int = {
		2 * (productCount / 3) + (productCount % 3)
	}

}