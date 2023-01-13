@SmokeTest
Feature: Final Login funtion Test
@TC_123
Scenario: As Automation application usrer must dosuccessfull login with valid credentioal
Given open the browser
And go to the application URL
When click the signin button 
And put the email
And put the password
And click the second signin button
Then validate the login was susseccfull
