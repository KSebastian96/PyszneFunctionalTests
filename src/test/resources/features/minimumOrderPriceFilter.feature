Feature: Random filtering by minimum order price at pyszne.pl
  Scenario: User can filter restaurants by minimum order price at pyszne.pl
    Given User accepted privacy policy
    When User type Mokotowska, Warszawa into address field
    And User randomly select minimum order price filter
    Then Results should match the minimun order price filter
