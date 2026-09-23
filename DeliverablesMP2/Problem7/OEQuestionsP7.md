Open-Ended Questions for Machine Problem 7:
	
**1. Why is Reservation useful as a separate class instead of placing all reservation data in Guest or Room?**

A Reservation is separate because it connects a guest and a room. It can store things like the reservation ID, number of nights, and total cost without putting all that information inside the Guest or Room.

**2. Which relationships are represented among Guest, Room, and Reservation?**

A Guest makes a Reservation, and a Reservation is for a Room. So, the Reservation connects the Guest and the Room.

**3. Why should Room availability be modified through reserve() and release()?**

This makes sure the room's availability is changed properly. Instead of changing it directly, reserve() can mark the room as unavailable, while release() can make it available again.

**4. What new field(s) would be needed to support actual check-in and check-out date**

You would need check-in date and check-out date fields in the Reservation class. For example, checkindate and checkoutdate could use Java's LocalDate type.
