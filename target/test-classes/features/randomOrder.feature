Feature: Random order in Pyszne.pl

  Scenario Outline: User can make a random order at Pyszne.pl
    Given Privacy policy is accepted
    When User enter <address>
    And User randomly select category
    And User randomly select delivery price filter
    Examples:
      | address                   |
      | Świętojańska, Gdynia |
