Feature: LogIn Validation

Scenario Outline: Login credential

Given open browser
And navigate to facebook url
When user types "<userid>" on useridBox
And user types "<userpassword>" in passwordBox
And user click on login button
Then user should be in his profile page 

Examples:
|userid|userpassword|
|user1|1234|
|user2|1234|
|user3|3456|