Feature: Random filtering by delivery costs at pyszne.pl
  Scenario: User can filter restaurants by delivery costs
    Given Privacy policy at main page is accepted
    When When User fill address field with Długa, Gdańsk
    And User randomly select delivery price filter
    Then Results should match the filter
