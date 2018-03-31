Feature: As an Owner I can register my vehicle
  Scenario: Register vehicle with correct inputs
    Given I am connected to the online system
    When I register a vehicle for owner with email "example@email.com" with plate "DQS123" model "levin" make "toyota" manufacture date "12/12/1998" fuel type "petrol" vin "124325363467547" odometer "12141" reg year "12/12/2017" wof "12/12/2018"
    Then the vehicle should now be registered to that owner in the database