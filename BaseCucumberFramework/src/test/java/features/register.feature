Feature: Register


Scenario: User should be able to register using valid credentials


Given url is navigated to register page
When user enters valid credentials

# Only applicable to this particular step

| M | Test | manualtest | qs_manualtest@gmail.com | Password@123 |
| M | Test | manualtest12 | qs_manualtest123@gmail.com | Password@123 |

And clicks on register button
Then a new account should be created


