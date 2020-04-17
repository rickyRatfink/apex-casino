My account manager wanted me to send you this assignment to complete by Friday morning. It will serve as the first round interview and we can move to the final round pending the results! This position is for Java developer with testing and automation experience. I was told it will take roughly an hour. Good luck!
 

Here is the take home interview assignment for candidates:

We will be utilizing the APIs available from http://deckofcardsapi.com/

Requirements:

-  Implement automation to test the following APIs in Java

o  Create a new deck of cards: **DONE

§  GET https://deckofcardsapi.com/api/deck/new/

§  Support adding Jokers with a POST:  **DONE But with GET not POST, was getting invalid response back and at 2:00am I stuck with a GET

o   Draw one or more cards from a deck:  **DONE

§  GET https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/

-  Consider Object Oriented principles and code organization. Assume the code you are creating will be the foundation for testing all of the http://deckofcardsapi.com/ APIs.

-  Automate at-least one test case, per API above, to demonstrate the design you have created

-  Code should be executable, please provide a README that indicates how to run it.

-  Submit your solution to us via a repo on https://github.com/


HOW TO RUN: 

I used Eclipse so....
Import project into Eclipse, right click on DeckRunner.java and Run As Java Application

If you are going to command line it, your Java Installation and Environment needs to be setup correctly.  Beyond the scope of the project/assignment.
But basically you would  
C:\INSTALL DIRECTORY\javac *.java (list all .java files in all packages)
c:\INSTALL DIRECTORY\java DeckRunner  (this is the main class that automates the tests)




