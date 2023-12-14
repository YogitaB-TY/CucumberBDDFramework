Feature: Search


Scenario Outline:  Validate when user enters text in search text field then the search result
 must be displayed
 
 
 When user enters "<Search text>" in search text field
 Then Search results must be displyaed

Examples:
     |  Search text | 
     |  Computer    |
     |  Books       |
     |  10          |
     |   12.02      |
