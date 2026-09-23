Open-Ended Questions for Machine Problem 8:
	
**1. Why is ShoppingCart said to have CartItem objects?**

Because each CartItem represents a product that was added to the cart, along with its quantity and price. The ShoppingCart keeps track of all the CartItems.

**2. Why should Product stock be reduced only after a cart addition succeeds?**

So the stock doesn't get reduced when something goes wrong, like when the product code is invalid or there isn't enough stock.

**3. What is the benefit of combining repeated additions of the same product into one CartItem?**

It keeps the cart organized and avoids having the same product appear multiple times. The quantity can simply be increased instead.

**4. Where should discount rules be located if the system later supports several discount strategies?**

The discount rules should be placed in a separate discount or pricing class. This makes it easier to add or change different discount types without changing the ShoppingCart code.
