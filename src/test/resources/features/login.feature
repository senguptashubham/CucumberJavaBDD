Feature: Login to application page
  As a user I want to be able to login to the application

  Background:
    Given I am on the application login page

  Scenario: Successful login with valid credentials
    Given I have entered valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have enetered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message "<errormessage>"
    Examples:
      | username        | password     | errormessage                                                              |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | abcd            | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | abcd            | abcd         | Epic sadface: Username and password do not match any user in this service |