package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.RestaurantListPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomOrderSteps extends Base_Step {
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
        List<WebElement> restaurantsCategoryList = new RestaurantListPage(driver).getRestaurantsResultCategoryList();
        for (int i = 0; i < restaurantsCategoryList.size(); i++) {
            if (restaurantsCategoryList.get(i).isDisplayed()) {
                Assert.assertTrue(restaurantsCategoryList.get(i).getText().contains(category));
            }
        }
    }

    @And("User randomly select delivery price filter")
    public void userRandomlySelectDeliveryPriceFilter() {
        List<WebElement> deliveryPriceFilter = new RestaurantListPage(driver).getDeliveryPriceFilters();
        Random randomPriceFilter = new Random();
        int randomPriceFilterInt = randomPriceFilter.nextInt(deliveryPriceFilter.size());
        deliveryPriceFilter.get(randomPriceFilterInt).click();
        String deliveryPrice = deliveryPriceFilter.get(randomPriceFilterInt).getText();
        dataList.add(deliveryPrice);
        List<WebElement> deliveryPriceList = new RestaurantListPage(driver).getDeliveryPriceList();
        if (deliveryPrice.equals("Za darmo")) {
            for (int i = 0; i < deliveryPriceList.size(); i++) {
                if (deliveryPriceList.get(i).isDisplayed()) {
                    Assert.assertEquals(deliveryPrice, deliveryPriceList.get(i).getText());
                }
            }
        } else if (deliveryPrice.equals("Nie gra roli")) {
        } else if (deliveryPrice.equals("10,00 zł lub mniej")) {
            for (int i = 0; i < deliveryPriceList.size(); i++) {
                if (deliveryPriceList.get(i).isDisplayed()) {
                    String price = deliveryPriceList.get(i).getText();
                    String priceArray[] = price.split(",");
                    double priceDouble = Double.parseDouble(priceArray[0]);
                    Assert.assertTrue(priceDouble < 10);

                }
            }
        } else if (deliveryPrice.equals("5,00 zł lub mniej")) {
            for (int i = 0; i < deliveryPriceList.size(); i++) {
                if (deliveryPriceList.get(i).isDisplayed()) {
                    String price = deliveryPriceList.get(i).getText();
                    String priceArray[] = price.split(",");
                    double priceDouble = Double.parseDouble(priceArray[0]);
                    Assert.assertTrue(priceDouble < 5);
                }
            }
        }
    }
}