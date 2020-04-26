$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/minimumOrderPriceFilter.feature");
formatter.feature({
  "name": "Random filtering by minimum order price at pyszne.pl",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User can filter restaurants by minimum order price at pyszne.pl",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User accepted privacy policy",
  "keyword": "Given "
});
formatter.match({
  "location": "MinimumOrderPriceFilterSteps.userAcceptedPrivacyPolicy()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User type Mokotowska, Warszawa into address field",
  "keyword": "When "
});
formatter.match({
  "location": "MinimumOrderPriceFilterSteps.userTypeAddressIntoAddressField(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User randomly select minimum order price filter",
  "keyword": "And "
});
formatter.match({
  "location": "MinimumOrderPriceFilterSteps.userRandomlySelectMinimumOrderPriceFilter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Results should match the minimun order price filter",
  "keyword": "Then "
});
formatter.match({
  "location": "MinimumOrderPriceFilterSteps.resultsShouldMatchTheMinimunOrderPriceFilter()"
});
formatter.result({
  "status": "passed"
});
});