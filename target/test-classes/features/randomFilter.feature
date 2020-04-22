Feature: Random filter in Pyszne.pl

  Scenario Outline: User can filter restaurants at Pyszne.pl
    Given Privacy policy is accepted
    When User enter <address>
    And User randomly select category
    And User randomly select delivery price filter
    And User randomly select minimum order price filter
    Then All results should match the filters
    Examples:
      | address              |
      | Świętojańska, Gdynia |
