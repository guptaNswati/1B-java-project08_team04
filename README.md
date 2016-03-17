# project08_team04
project08 for team04

Description of submitted files:

Brief description of submitted files:
-src/TestUI
Tests the GUI by creating objects of type GraphView, LegendPanel, CountryMenuItem.
Implements ActionListener and ItemListener

-src/CountryMenuItem
Extends JCheckBoxMenuItem
Creates a Checkbox with name of country and a default selected state.

-src/GraphView.java
Maps the cellular data of a country to the width and height of the panel.
Constructor that takes width, height nad list of countries to create a graph.
Implements MouseMotionListener interface
Include map() that maps the data to the available space of the screen.
Include paintComponent() that draws the axis and colored points of data.

-src/LegendPanel.java
Provides a visual guide to viewing the list of random countries.
Constructor that creates a panel and takes width, height, color and GraphView object and initializes its attributes.
Include paintComponent()that draws a rectangle using legend objects and writes its name

-src/Legend.java
A key that holds the country name and color of its correspnding country.
Constructor that takes country name and color of the country.
Setters and getters for its member attributes.

-src/ColoredPoint.java
Represents a point on the graph which is the subscription data of one country for one year.
Constructor that takes an object of type color, original x and y values and mapped x and y values.
Include getColor() an accessor for the color.
Include getLabel() that returns a string representation x and y values of the data point.

-src/PlottedDataSet.java
Holds a list of ColoredPoints.
Constructor that initializes the list of ColoredData points and generates a random color to generate a ColoredPoint.
Include addDataPoints() that creates and adds an object of coloredPoint to linkedlist of ColoredPoints.
Include getRandomColor() that returns the randonly color.
Include getDataPoints() that returns the linkedlist of ColoredPoint.

-src/Node.java 
Node Class with two private fields, one is a generic object and second one is an object of parameterized Node type. 
First constructor that takes in one parameter, a generic object. 
Second constructor that takes in two parameters, a generic object and an object of parameterized Node type. 
Include setter () for the attribute next. 
Include getter () for all attributes. 
Include toString () that returns the string representation of "data".

-src/LinkedList.java 
LinkedList class that contains collection of generic Node objects and its size. 
Implements the generic Iterable interface - A constructor that creates an empty LinkedList object. 
Include isEmpty() that checks if head is pointing to any node. 
Include add() that takes a generic object as parameter and adds that new object to the end of the list. 
Include contains() that takes a generic object as parameter and checks if the object can be found in the linked list. 
Include toString() which uses an iterator to print the contents of the list. - Include getNodeAtIndex() that gets a node at a specific index. 
Include size() that returns the size of the list. 
Include iterator() that returns object of type ListIterator. 
Have an inner class called ListIterator to traverse the collection of objects in the list. 
ListIterator class includes - A generic field called current that keeps track of the current location being traversed. - Implements generic Iterator interface - A constructor that initializes current to the beginning of the list. 
method next() that returns the next object in the list.

-src/CSVReader.java 
CSVReader Class with three private fields. 
constructor that takes in filename, reads the cellular.csv file and sets its members data. 
getters for members.

-src/SubscriptionYear.java 
SubscriptionYear Class having two private instance variables, year of type int & subscriptions of type double 
A constructor that takes in the year and number of subscriptions. - Include getter() and setter() for instance variable year. 
Include getter() and setter() for instance variable subscriptions. - Include toString() which returns the number of subscriptions. 
Include equals() that

-src/Country.java 
Country Class having three private instance variables, name of type String, subscriptions a linked list of SubscriptionYear objects, minYear and maxYear of type int. 
A constructor that takes in an object of type String, which is the name of the country and creates a new list of SubscriptionYear, initializes min year to a large number and max year to a small number. 
Added equals() that override Object.equlas() to check if two objects of type Country are equal, based on their name. 
Include getter() and setter() for instance variable name. - Include getter() and setter() for instance variable subscriptions. 
Includes addSubscriptionYear() that create a new SubscriptionYear object and adds it in subscriptions list.
Also, updates the minimum and maximum year. 
Includes getNumSubscriptionsForPeriod() that returns total number of subscriptions for a specified period using an iterator. 
Includes toString() which overrides subscription.toString() and returns a representation of the country with its data.

src/CellularData
-One object of class CellularData represents a table for containing the cellular data for all countries.

-resources/cellular.csv
A CSV (comma seperated value) file.
First line contains number of countries, country names, and years from 1960 to 2012
Each row contains the name of the country and the corresponding cellular data values from 1960 to 2012

-resources/snapshots of  Run
Snapshots of Program when it is run

README.txt - description of submitted files
