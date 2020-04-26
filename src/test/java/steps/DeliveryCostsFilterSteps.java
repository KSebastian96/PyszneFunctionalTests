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

public class DeliveryCostsFilterSteps extends Base_Step {
    List<String> dataList = new ArrayList<>();

    @Given("Privacy policy at main page is accepted")
    public void privacyPolicyAtMainPageIsAccepted() {
        new HomePage(driver).CookiesButton();
    }

    @When("When User fill address field with (.*)")
    public void whenUserFillAddressFieldWithAddress(String address) throws InterruptedException {
        new HomePage(driver).RandomCity(address);
        List<WebElement> thisAddress = new HomePage(driver).getCorrectAddress();
        Thread.sleep(2000);
        thisAddress.get(1).click();
    }

    @And("User randomly select delivery price filter")
    public void userRandomlySelectDeliveryPriceFilter() {
        List<WebElement> deliveryPriceFilter = new RestaurantListPage(driver).getDeliveryPriceFilters();
        Random randomPriceFilter = new Random();
        int randomPriceFilterInt = randomPriceFilter.nextInt(deliveryPriceFilter.size());
        deliveryPriceFilter.get(randomPriceFilterInt).click();
        String deliveryPrice = deliveryPriceFilter.get(randomPriceFilterInt).getText();
        dataList.add(deliveryPrice);

    }

    @Then("Results should match the filter")
    public void resultsShouldMatchTheFilter() {
        String deliveryPrice = dataList.get(0);
        List<WebElement> deliveryPriceList = new RestaurantListPage(driver).getDeliveryPriceList();
        if (deliveryPrice.equals("Za darmo")) {
            for (int i = 0; i < deliveryPriceList.size() - 1; i++) {
                if (deliveryPriceList.get(i).isDisplayed()) {
                    Assert.assertEquals("GRATIS", deliveryPriceList.get(i).getText());
                }
            }
        } else if (deliveryPrice.equals("Nie gra roli")) {
        } else if (deliveryPrice.equals("10,00 zł lub mniej")) {
            for (int i = 0; i < deliveryPriceList.size() - 1; i++) {
                if (!deliveryPriceList.get(i).getText().equals("GRATIS")) {
                    String price = deliveryPriceList.get(i).getText();
                    String priceArray[] = price.split(",");
                    String priceGrArray[] = priceArray[1].split(" ");
                    String priceGr = "0." + priceGrArray[0];
                    double priceZłDouble = Double.parseDouble(priceArray[0]);
                    double priceGrDouble = Double.parseDouble(priceGr);
                    double priceDouble = priceZłDouble + priceGrDouble;
                    Assert.assertTrue(priceDouble <= 10);
                }
            }
        } else if (deliveryPrice.equals("5,00 zł lub mniej")) {
            for (int i = 0; i < deliveryPriceList.size() - 1; i++) {
                if (!deliveryPriceList.get(i).getText().equals("GRATIS")) {
                    String price = deliveryPriceList.get(i).getText();
                    String priceArray[] = price.split(",");
                    String priceGrArray[] = priceArray[1].split(" ");
                    String priceGr = "0." + priceGrArray[0];
                    double priceZłDouble = Double.parseDouble(priceArray[0]);
                    double priceGrDouble = Double.parseDouble(priceGr);
                    double priceDouble = priceZłDouble + priceGrDouble;
                    Assert.assertTrue(priceDouble <= 5);
                }
            }
        }
    }
}
