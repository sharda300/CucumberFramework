@Test
Feature: login page

Background:
Given user should be on login page


Scenario: InvalidLoginTC01
When user enters invalid userid and password and click on login button
Then user can see error message above the login block
 
 
@sanity @smoke @regression
Scenario: ValidLoginTC02
When user enters valid userid and password and click on login button
Then user should be navigated to home page
And user can see logout link is appear on top right corner
 
 
 