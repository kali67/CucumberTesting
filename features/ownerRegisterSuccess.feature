Feature: Success message displayed
  Scenario: Register
    Given I am connected to the online system
    When I have successfully registered as an owner
    Then A confirmation message "Successfully registered owner" is displayed on the screen