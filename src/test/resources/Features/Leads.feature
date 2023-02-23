@Test
Feature: Leads feature

Background:
Given user should be on login page
When user enters valid userid and password and click on login button


Scenario: CreateLeadWithMandatoryFieldsTC03
When user click on new lead link link
And fill all mandatory fields
Then lead should be created successfully
