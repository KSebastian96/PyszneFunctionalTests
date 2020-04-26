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

public class CategoryFilterSteps extends Base_Step {
    List<String> dataList = new ArrayList<>();
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
    @Then("Results should match the category filter")
    public void resultsShouldMatchTheCategoryFilter() {
        List<WebElement> restaurantsCategoryList = new RestaurantListPage(driver).getRestaurantsResultCategoryList();
        String category = dataList.get(0);
        for (int i = 0; i < restaurantsCategoryList.size()-1; i++) {
            if (restaurantsCategoryList.get(i).isDisplayed()) {
                Assert.assertTrue(restaurantsCategoryList.get(i).getText().contains(category));
            }
        }
    }
}
