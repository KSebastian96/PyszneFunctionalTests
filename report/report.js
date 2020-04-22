$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/randomFilter.feature");
formatter.feature({
  "name": "Random filter in Pyszne.pl",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User can filter restaurants at Pyszne.pl",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Privacy policy is accepted",
  "keyword": "Given "
});
formatter.step({
  "name": "User enter \u003caddress\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "User randomly select category",
  "keyword": "And "
});
formatter.step({
  "name": "User randomly select delivery price filter",
  "keyword": "And "
});
formatter.step({
  "name": "User randomly select minimum order price filter",
  "keyword": "And "
});
formatter.step({
  "name": "All results should match the filters",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "address"
      ]
    },
    {
      "cells": [
        "Świętojańska, Gdynia"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User can filter restaurants at Pyszne.pl",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Privacy policy is accepted",
  "keyword": "Given "
});
formatter.match({
  "location": "RandomFilterSteps.privacyPolicyIsAccepted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter Świętojańska, Gdynia",
  "keyword": "When "
});
formatter.match({
  "location": "RandomFilterSteps.userEnterAddress(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User randomly select category",
  "keyword": "And "
});
formatter.match({
  "location": "RandomFilterSteps.userRandomlySelectCategory()"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: bound must be positive\n\tat java.base/java.util.Random.nextInt(Random.java:388)\n\tat steps.RandomFilterSteps.userRandomlySelectCategory(RandomFilterSteps.java:37)\n\tat ✽.User randomly select category(src/test/resources/features/randomFilter.feature:6)\n",
  "status": "failed"
});
formatter.step({
  "name": "User randomly select delivery price filter",
  "keyword": "And "
});
formatter.match({
  "location": "RandomFilterSteps.userRandomlySelectDeliveryPriceFilter()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User randomly select minimum order price filter",
  "keyword": "And "
});
formatter.match({
  "location": "RandomFilterSteps.userRandomlySelectMinimumOrderPriceFilter()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All results should match the filters",
  "keyword": "Then "
});
formatter.match({
  "location": "RandomFilterSteps.allResultsShouldMatchTheFilters()"
});
formatter.result({
  "status": "skipped"
});
});