Open-Ended Questions for Machine Problem 5:	

**1. Why should gross pay be returned by a method instead of stored as a user-entered field?**

Because gross pay is something the program can calculate using the employee’s hours and hourly rate. The user doesn’t need to enter it, which also helps avoid wrong values.

**2. Which condition determines whether overtime pay is applied?**

Overtime applies when the employee works more than 40 hours. The hours above 40 are paid at 1.5 times the normal hourly rate.

**3. How does encapsulation help prevent an invalid negative hourly rate?**

It can keep the hourly rate protected and only allow it to be changed through a method that checks the value first. If the rate is negative, the method can reject it.

**4. If tax rules change, which class should contain the update and why?**

The Payroll or Tax class should handle it because that class is responsible for calculating taxes. This way, if the tax rates change, we only need to update that part of the program.
