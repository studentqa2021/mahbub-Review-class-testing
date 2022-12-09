@SmokeTest
Feature: Login funtion Test

@TC_1234
Scenario: As a Luma application usre, must dosuccessfull login with valid credentioal
Given open any browser
And go to application
When click sign butten 
And put email
And put password
And click second signin button
Then validate login was susseccfull
