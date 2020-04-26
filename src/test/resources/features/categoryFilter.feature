Feature: Random filtering by category at pyszne.pl

  Scenario: User can filter restaurants by category at pyszne.pl
    Given Privacy policy is accepted
    When User enter Świętojańska, Gdynia
    And User randomly select category
    Then Results should match the category filter
