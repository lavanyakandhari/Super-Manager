# Super-Manager

## Application Overview 
This application is supermarket menu and cart management system for a supermarket:
- #### What will the application do?
Here a **customer** can access this application to *add or delete items in his cart or look at product descriptions 
like price and view total price of items in their cart*, 
on the other hand an **employee** at the supermarket can access this application to *add or delete items in the menu 
or list of items at the super market*. 
There will be an option for either a customer to access the application or an employee.
- #### Why is this project of interest to you?
This seemed like an interesting topic since we go grocery shopping every month and just observing the employees 
checking in items on the counter, and, also customers at self check out viewing their cart and total balance due, trying 
to make something of that mechanism would be a good challenge.

## User Stories
- As a user (customer), I want to be able to:
    - view a list of items in the menu.
    - add  items in my cart.
    - delete items from my cart.
    - see the total bill and view items in my cart.
    - get an option to save my cart or not for when I return before quitting.
    - load my cart from file.
- As a user (employee), I want to be able to:
    - add items on the menu.
    - delete items on the menu.
    - view items on the menu.
    - save the edited menu or not before quitting.
    - to load the edited menu from file.

## Phase 4: Task 2
the option that I completed was : Test and design a class in your model package that is robust. You must have at 
least one method that throws a checked exception.  You must have one test for the case where the exception is 
expected and another where the exception is not expected.
- The class that has a robust design is cart class, and the method is removeFromCart().

## Phase 4: Task 3
If I had more time to work on the project, I would have refactored my project code to improve my design in the following 
ways:
- I would have tried to incorporate data for cart nad menu both in the same file so that I would have only one object 
each of JsonReader and JsonWriter in InitialMenu class.
- I could refactor to avoid duplicate pieces of code like the deleteFromCart & deleteFromMenu have a lot of 
overlapping code. Also the SeeMenu & SeeCart have overlapping code.
