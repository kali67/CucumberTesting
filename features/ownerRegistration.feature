Feature: Register as vehicle owner

  Scenario: Submit firstname, lastname, email address and password correctly
    Given I am connected to the online system And the owner does not yet exist
    When I register with firstname "Joe" lastname "Bloggs" email "example@email.com" password "passw0rd"
    Then the owner with firstname "Joe" lastname "Bloggs" email "example@email.com" password "passw0rd" should exist in the database
    And A message "Successfully registered owner" is displayed on the screen

  Scenario: Submit firstname, lastname, email address and password with invalid characters
    Given I am connected to the online system
    When I register with firstname "J_3" lastname "Bl$00s" email "example2@email.com" password "passw0rd"
    Then the owner with email "example2@email.com" should not exist in the database
    And A message "Invalid name" is displayed on the screen

  Scenario: Submit firstname, lastname, email address and password with multiple firstnames
    Given I am connected to the online system
    When I register with firstname "Joe Joe" lastname "Bloggs" email "test@gmail.com" password "passw0rd"
    Then the owner with email "test@gmail.com" should exist in the database

  Scenario: Register as a owner with an a email that is already registered
    Given The email "example@email.com" already exists in the database
    When I register with firstname "Joe" lastname "Bloggs" email "example@email.com" password "passwo0rd"
    Then A message "Email address is already registered" is displayed on the screen
