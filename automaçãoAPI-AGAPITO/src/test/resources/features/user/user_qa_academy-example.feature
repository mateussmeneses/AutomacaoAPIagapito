#charset: UTF8

@JIRA-002
  Feature: Simple example

    Scenario: Cucumber Example
      Given the user is on the table
      When the user get out
      Then the user should see the window

      Scenario: Simple user post
        Given the user wants to create a new user
        And the user fills field "login" with value equal "mateusmeneses"
        And the user fills field "full_name" with value equal "Mateus Meneses"
        And the user fills field "age" with value equal "20"
        And the user fills field "email" with value equal "mateus.meneses@gft.com"
        When the user saves new user
        Then the user should see "save with success" message

    Scenario: Simple user get
      Given the user wants to create a new user
      And the user fills field "login" with value equal "mateusmeneses"
      And the user fills field "full_name" with value equal "Mateus Meneses"
      And the user fills field "age" with value equal "20"
      And the user fills field "email" with value equal "mateus.meneses@gft.com"
      And the user saves new user
      When the user gets the same user
      Then the user should see "success" message
      And the user should see field "login" with value "mateusmeneses"
      And the user should see field "full_name" with value "Mateus Meneses"
      And the user should see field "age" with value "20"
      And the user should see field "email" with value "mateus.meneses@gft.com"


    Scenario: Simple user put
      Given the user wants to create a new user
      And the user fills field "login" with value equal "mateusmeneses"
      And the user fills field "full_name" with value equal "Mateus Meneses"
      And the user fills field "age" with value equal "20"
      And the user fills field "email" with value equal "mateus.meneses@gft.com"
      And the user saves new user
      When the user fills field "login" with value equal "ironman"
      And the user puts the same user
      And the user gets the same user
      Then the user should see "success" message
      And the user should see field "login" with value "ironman"
      And the user should see field "full_name" with value "Mateus Meneses"
      And the user should see field "age" with value "20"
      And the user should see field "email" with value "mateus.meneses@gft.com"

    Scenario: Simple user delete
      Given the user wants to create a new user
      And the user fills field "login" with value equal "mateusmeneses"
      And the user fills field "full_name" with value equal "Mateus Meneses"
      And the user fills field "age" with value equal "20"
      And the user fills field "email" with value equal "mateus.meneses@gft.com"
      And the user saves new user
      When the user deletes the same user
      And the user gets the same user
      Then the user should see "not found" message


