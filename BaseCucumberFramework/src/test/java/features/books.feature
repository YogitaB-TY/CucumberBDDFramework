Feature: Books

Background:
Given browser is open to welcome page
When user is logged in 
| qa_testuser123@gmail.com | Password@123 |
And user clicks on Book page
And Books page is displayed


Scenario: Validate user can sort the page alphabetically
And User chooses A-Z in sort by drop down
Then page should be sorted alphabetically

Scenario: Validate user can add Computing and Internet book to cart
And user clicks on add to cart button for Computing and Internet book
Then Book should be added to cart

Scenario: Validate user can add Health book to cart 
And user clicks on add to cart button for Health book
Then Book should be added to cart