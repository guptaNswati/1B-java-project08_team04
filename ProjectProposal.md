# project08_team04
project08 for team04

An overview of the your design and placement of your JComponents (if applicable): 
We want to give user an option of selectig the countires to be graphed based on their names.
Also of selecting the years he/she wants to see the data.
We would remove the labels of current points and it will be visible when user clicks on those points

JCompoment will have a 
- graph panel
- the legned panel
- drop down checklist panel
- panel for selecting the number of years 
- a JButton for taking her to the graph

A high level overview of how the user becomes aware of your two features: 
We outputs a message on screen telling that he she can choose the countries by selecting the name of countries fron the given drop down checklist.
For the years we will tell the user that we have subcription data of countries starting from 1960-2012. So, user can choose which year's data to be graphed for a more detailed analysis.

The name of the classes you will use to implement the interactions: 
CursorDataPoint and UIMenu. 
CursorDataPoint that will implement MouseListener and when a data point on the graph will be clicked it will show the x and y value of those data points.
UIMenu that will implement MouseListener and have a drop down checklist for names of countries  and years to be graphed.
