$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/randomOrder.feature");
formatter.feature({
  "name": "Random order in Pyszne.pl",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User can make a random order at Pyszne.pl",
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
  "name": "User can make a random order at Pyszne.pl",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Privacy policy is accepted",
  "keyword": "Given "
});
formatter.match({
  "location": "RandomOrderSteps.privacyPolicyIsAccepted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter Świętojańska, Gdynia",
  "keyword": "When "
});
formatter.match({
  "location": "RandomOrderSteps.userEnterAddress(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User randomly select category",
  "keyword": "And "
});
formatter.match({
  "location": "RandomOrderSteps.userRandomlySelectCategory()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat steps.RandomOrderSteps.userRandomlySelectCategory(RandomOrderSteps.java:43)\n\tat ✽.User randomly select category(src/test/resources/features/randomOrder.feature:6)\n",
  "status": "failed"
});
formatter.step({
  "name": "User randomly select delivery price filter",
  "keyword": "And "
});
formatter.match({
  "location": "RandomOrderSteps.userRandomlySelectDeliveryPriceFilter()"
});
formatter.result({
  "status": "skipped"
});
});