Feature: Validate Login Credential
Background: 
Given open browser
And navigate to facebook url

@Smoke
Scenario: Login to Profile Page with valid credentials
When user types userid on useridBox
And user types userpassword in passwordBox
And user click on login button
Then user should be in his profile page


@Reg
Scenario: Login to Profile Page with Invalid credentials
When user types invalid userid on useridBox
And user types invalid userpassword in passwordBox
And user click on login button
Then user should not be in his profile page

@Integrartion
Scenario: Verify Login Button is enabled or not
When user will check login button is enabled or not
Then Based on the result user should get return true or flase
