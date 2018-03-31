Feature: As an Owner I can register my vehicle

  Scenario: Register vehicle with correct inputs
    Given I am connected to the online system and owner with email "example@email.com" exists in the database
    When I register a vehicle for owner with email "example@email.com"
    Then the vehicle should now be registered to owner with email "example@email.com" in the database
    And A message "Successfully registered vehicle" is displayed on the screen

  Scenario: Register vehicle with incorrect date formats
    Given I am connected to the online system and owner with email "example@email.com" exists in the database
    When I register a vehicle with plate "ZXC123" and manufacture date "32/32/1990" reg year "12128" wof "32/32/1990" for owner with email "example@email.com"
    Then the vehicle with plate "ZXC123" is not in the database
    And A message "Invalid date format" is displayed on the screen

  Scenario: Register vehicle with incorrect fuel type
    Given I am connected to the online system and owner with email "example@email.com" exists in the database
    When I register a vehicle with plate "CBA321" fuel type "oil" for an owner with email "example@email.com"
    Then the vehicle with plate "CBA321" is not in the database
    And A message "Invalid fuel type" is displayed on the screen

  Scenario: Register vehicle that is already registered to an owner
    Given I am connected to the online system and vehicle with plate "ABC123" is registered to email "example@yahoo.com"
    When I register a vehicle with plate "ABC123" to an owner with email "test@gmail.com"
    Then A message "Vehicle is already registered" is displayed on the screen
    And The owner with email "test@gmail.com" has no registered vehicle with plate "ABC123"
