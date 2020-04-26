package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.RestaurantListPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinimumOrderPriceFilterSteps extends Base_Step {
    List<String> dataList = new ArrayList<>();

    @Given("User accepted privacy policy")
    public void userAcceptedPrivacyPolicy() {
        new HomePage(driver).CookiesButton();

    }

    @When("User type (.*) into address field")
    public void userTypeAddressIntoAddressField(String address) throws InterruptedException {
        new HomePage(driver).RandomCity(address);
        List<WebElement> thisAddress = new HomePage(driver).getCorrectAddress();
        Thread.sleep(2000);
        thisAddress.get(1).click();
    }

    @And("User randomly select minimum order price filter")
    public void userRandomlySelectMinimumOrderPriceFilter() throws InterruptedException {
        List<WebElement> minimumOrderPriceFilterList = new RestaurantListPage(driver).getMinimumOrderPriceFilterList();
        Random randomMinimumOrderPriceFilter = new Random();
        int randomMinimumOrderPriceFilterInt = randomMinimumOrderPriceFilter.nextInt(minimumOrderPriceFilterList.size());
        minimumOrderPriceFilterList.get(randomMinimumOrderPriceFilterInt).click();
        String minimumOrderPrice = minimumOrderPriceFilterList.get(randomMinimumOrderPriceFilterInt).getText();
        dataList.add(minimumOrderPrice);
        Thread.sleep(5000);
    }

    @Then("Results should match the minimun order price filter")
    public void resultsShouldMatchTheMinimunOrderPriceFilter() {
        List<WebElement> minimumOrderPriceResults = new RestaurantListPage(driver).getMinimumOrderCostsResultList();
        String minimumOrderPrice = dataList.get(0);
        if (minimumOrderPrice.equals("Nie gra roli")) {
        } else if (minimumOrderPrice.equals("15,00 zł lub mniej")) {
            for (int i = 0; i < minimumOrderPriceResults.size() - 1; i++) {
                String price = minimumOrderPriceResults.get(i).getText();
                String priceArray[] = price.split(" ");
                String splittedPriceArray[] = priceArray[1].split(",");
                String priceGr = "0." + splittedPriceArray[1];
                double priceGrDouble = Double.parseDouble(priceGr);
                double priceZłDouble = Double.parseDouble(splittedPriceArray[0]);
                double priceDouble = priceZłDouble + priceGrDouble;
                Assert.assertTrue(priceDouble <= 15);

            }
        } else if (minimumOrderPrice.equals("30,00 zł lub mniej")) {
            for (int i = 0; i < minimumOrderPriceResults.size() - 1; i++) {
                String price = minimumOrderPriceResults.get(i).getText();
                String priceArray[] = price.split(" ");
                String splittedPriceArray[] = priceArray[1].split(",");
                String priceGr = "0." + splittedPriceArray[1];
                double priceGrDouble = Double.parseDouble(priceGr);
                double priceZłDouble = Double.parseDouble(splittedPriceArray[0]);
                double priceDouble = priceZłDouble + priceGrDouble;
                Assert.assertTrue(priceDouble <= 30);
            }
        }
    }
}



