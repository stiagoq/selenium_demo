Feature: Login

  Scenario: Login on the LUMA APP with created user
    Given user is on the login page of the site
    When enters the credentials
    Then it shows the user profile and your home page

    Scenario Outline: Login on the LUMA APP with invalid credentials
      Given user is on the login page of the site
      When enters invalid '<email>' and '<password>' credentials
      Then it shows an error message

      Examples:
      | email              | password     |
      | userinfo.txt       | Password123  |
      | emailNew@gmail.com | Password123  |
      | emailNew@gmail.com |              |
      |                    | Password123  |
      |                    |              |