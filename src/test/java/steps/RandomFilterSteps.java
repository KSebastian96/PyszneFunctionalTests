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

public class RandomFilterSteps extends Base_Step {
    private List<String> dataList = new ArrayList<String>();

    @Given("Privacy policy is accepted")
    public void privacyPolicyIsAccepted() {
        new HomePage(driver).CookiesButton();
    }

    @When("User enter (.*)")
    public void userEnterAddress(String address) throws InterruptedException {
        new HomePage(driver).RandomCity(address);
        List<WebElement> thisAddress = new HomePage(driver).getCorrectAddress();
        Thread.sleep(2000);
        thisAddress.get(1).click();

    }

    @And("User randomly select category")
    public void userRandomlySelectCategory() {
        List<WebElement> categoryList = new RestaurantListPage(driver).getCategoryList();
        Random randomCategory = new Random();
        int randomCategoryInt = randomCategory.nextInt(categoryList.size());
        categoryList.get(randomCategoryInt).click();
        String category = categoryList.get(randomCategoryInt).getText();
        dataList.add(category);


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

    @And("User randomly select minimum order price filter")
    public void userRandomlySelectMinimumOrderPriceFilter() {
        List<WebElement> minimumOrderPriceFilterList = new RestaurantListPage(driver).getMinimumOrderPriceFilterList();
        Random randomMinimumOrderPriceFilter = new Random();
        int randomMinimumOrderPriceFilterInt = randomMinimumOrderPriceFilter.nextInt(minimumOrderPriceFilterList.size());
        minimumOrderPriceFilterList.get(randomMinimumOrderPriceFilterInt).click();
        String minimumOrderPrice = minimumOrderPriceFilterList.get(randomMinimumOrderPriceFilterInt).getText();
        dataList.add(minimumOrderPrice);
    }

    @Then("All results should match the filters")
    public void allResultsShouldMatchTheFilters() {
        String deliveryPrice = dataList.get(1);
        List<WebElement> deliveryPriceList = new RestaurantListPage(driver).getDeliveryPriceList();
        if (deliveryPrice.equals("Za darmo")) {
            for (int i = 0; i < deliveryPriceList.size()-1; i++) {
                if (deliveryPriceList.get(i).isDisplayed()) {
                    Assert.assertEquals("GRATIS", deliveryPriceList.get(i).getText());
                }
            }
        } else if (deliveryPrice.equals("Nie gra roli")) {
        } else if (deliveryPrice.equals("10,00 zł lub mniej")) {
            for (int i = 0; i < deliveryPriceList.size()-1; i++) {
                if (deliveryPriceList.get(i).isDisplayed() || !deliveryPriceList.get(i).getText().equals("GRATIS")) {
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
            for (int i = 0; i < deliveryPriceList.size()-1; i++) {
                if (deliveryPriceList.get(i).isDisplayed() || !deliveryPriceList.get(i).getText().equals("GRATIS")) {
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
        List<WebElement> restaurantsCategoryList = new RestaurantListPage(driver).getRestaurantsResultCategoryList();
        String category = dataList.get(0);
        for (int i = 0; i < restaurantsCategoryList.size()-1; i++) {
            if (restaurantsCategoryList.get(i).isDisplayed()) {
                Assert.assertTrue(restaurantsCategoryList.get(i).getText().contains(category));
            }
        }
        List<WebElement> minimumOrderPriceResults = new RestaurantListPage(driver).getMinimumOrderPriceResultList();
        String minimumOrderPrice = dataList.get(2);
        if (minimumOrderPrice.equals("Nie gra roli")) {
        } else if (minimumOrderPrice.equals("15,00 zł lub mniej")) {
            for (int i = 0; i < minimumOrderPriceResults.size()-1; i++) {
                if (minimumOrderPriceResults.get(i).isDisplayed()) {
                    String price = minimumOrderPriceResults.get(i).getText();
                    String priceArray[] = price.split(" ");
                    String splittedPriceArray[] = priceArray[1].split(",");
                    String priceGr = "0." + splittedPriceArray[1];
                    double priceGrDouble = Double.parseDouble(priceGr);
                    double priceZłDouble = Double.parseDouble(splittedPriceArray[0]);
                    double priceDouble = priceZłDouble + priceGrDouble;
                    Assert.assertTrue(priceDouble <= 15);
                }
            }
        } else if (minimumOrderPrice.equals("30,00 zł lub mniej")) {
            for (int i = 0; i < minimumOrderPriceResults.size()-1; i++) {
                if (minimumOrderPriceResults.get(i).isDisplayed()) {
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
}