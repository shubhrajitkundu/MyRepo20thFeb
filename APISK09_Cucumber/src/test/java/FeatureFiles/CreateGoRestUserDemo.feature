@sanity
Feature: Cretion of demo Go rest User

  Scenario Outline: New User Creation Go rest Demo
    Given user opens the go rest site
    When user enters the payload data to go rest
    And user submits the payload to the  go rest server with an endpoint as "<endpoint>"
    Then user validates the created data and confirms the status code as "<status_code>"

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
