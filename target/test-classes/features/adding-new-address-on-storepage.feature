@mystore
Feature:  New address on MyStore
  Scenario Outline: Creating new address
    Given Im on main page
    When I sign in
    And I login using email donnie.darko11111@gmail.com and password donnie
    And I go to my addresses page
    And I create new address
    And I fill in the New address form with <alias>, <address>, <city>, <postalcode>, <number>
    And I will check if the data in the added address is correct
    And I will delete the address
    Then I will check if it is deleted
    And I close browser
    Examples:
      |alias|address|city|postalcode|number|
      |Second Address|Armley|Leeds|12-345|123456|