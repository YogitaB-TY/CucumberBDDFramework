Feature: Login


Scenario: Validate user is able to login using valid credentials
 

 Given Login page is displayed
 When user enters valid username and valid password
 And user clicks on login button
 Then User should be successfully logged in
 
