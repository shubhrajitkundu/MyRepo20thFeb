@sanity

Feature: Creation of a new demo user

  Scenario Outline: Create new user data
    Given user sends data to server
    When user enters the data payload
    And user submits the payload to the server with an endpoint as "<endpoint>"
    Then user validates the created data and confirms the status code as "<status_code>"

    Examples: 
      | endpoint  | status_code |
      | api/users |         201 |
