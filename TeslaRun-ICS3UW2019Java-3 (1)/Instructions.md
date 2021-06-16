# INSTRUCTIONS

- [x] A protected variable called modelName for the vehicle’s model name (Case Sensitive Uppercase)
- [x] A protected variable called modelNum for Model Number (Alpha Numeric - Be creative)*
- [x] A protected variable called year for the Year of Manufacture (On/After 2013)
- [x] A protected variable called numDoors (Match this to the chosen image)
- [x] A protected image (consider utilizing the image array for better load times)
- [x] A protected variable for numWheels
- [x] A private variable for horsePower (You can be realistically creative with this)
- [x] A private variable for price (You can be realistically creative with this)
- [x] A private variable for serial number
- [x] A private boolean variable called isSelfDriving (assume this is false on delivery)
- [x] A public variable for sound (Try to search for suitable WAV files that play upon entrance of each vehicle – Again, load these WAV files within the Sketch and store within an array)
- [x] A private variable called vin for the VIN
- [x] Include both a main constructor (all params) and a default constructor (no params) for all vehicle objects and associated subclasses.
- [x] Elon Musk (Owner of Tesla) would like a method called makeElectricV that returns an ElectricV object that is a clone of any currently produced vehicle and would maintain its specs.
- [x] Any electric vehicle should be able to enable/disable its self driving capability.

https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/ 
# Level 4+

- [x] Create a clickable user menu within the PApplet:
- [x] Allow a user of your program to be able to choose a Year and Model for any ONE of your 5 (or more) vehicles. Use a series of displayed menu lists/button/selectable options
- [x] After a user makes their selection, have your program display the corresponding vehicle. e.g. have it drive in from the right side of the screen, stop in the middle, make its sound and produce its specs in the PApplet.
- [x] Include a “Buy” option/button/choice which, when clicked/selected, will add its pertinent details to a receipt (output). Allow for another vehicle to then be ordered (append to the receipt). Using the toString.

# Important
- [ ] Improve the Vehicle class and subclasses for efficiency to ensure they do not allow impossible values in case other programmers decide to use your classes for other purposes (e.g. throw exceptions (ideal) or modify to only allowable values
- [ ] However, for Level 4+, try not to include/allow/ask for any typed user input. Utilize mouse clicks or keypresses for options within the PApplet only for this assignment.
- [ ] Have the Vehicle class implement the Comparable Interface by checking Year of Manufacture to see if two Vehicle objects match (This functionality is also not used by the user but must be implemented) – Stay tuned for mini lesson on this later.
- [ ] Include Comment Headers for methods in this assignment. /** and */ Pre, Post, Brief Descriptions, (e.g. @ Params, @Return – CODE MAINTENANCE)
- [ ] Have the Car, Truck and Bus classes implement the comparable interface. Note: a car will compare its price and be considered less than another car if its price is less.
- [ ] Implement the equals method for each vehicle type. Any Vehicle and its subclasses will be considered equal IFF all pertinent details are exactly the same except for the VIN and Serial
Numbers.
- [ ] Include toString methods for each class detailing all pertinent details in a nicely formatted way.
- [ ] Be sure that any/all constructors initialize other variables to appropriate values as necessary.

# Bonus
- [ ] Implement the game into the program after a user selects their preferred vehicle.