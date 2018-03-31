Feature: Register as vehicle owner
  Scenario: Submit firstname, lastname, email address and password correctly
    Given I am connected to the online system And the owner does not yet exist
    When I register with firstname "Joe" lastname "Bloggs" email "example@email.com" password "passw0rd"
    Then the owner with firstname "Joe" lastname "Bloggs" email "example@email.com" password "passw0rd" should exist in the database

  Scenario: Submit firstname, lastname, email address and password incorrectly
    Given I am connected to the online system And the owner does not yet exist
    When I register with firstname "joe" lastname "Bloggs" email "example@email.com" password "passw0rd"
    Then the owner with firstname "Joe" lastname "Bloggs" email "example@email.com" password "passw0rd" should not exist in the database
