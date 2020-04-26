package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RestaurantListPage {
    public RestaurantListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".filter-label.subcatlink.swiper-slide.kitchen-types__category")
    private List<WebElement> categoryList;
    @FindBy(xpath = "//a[@href='koszty-dostawy']")
    private List<WebElement> deliveryPriceFilters;
    @FindBy(xpath = "//div[@class='js-restaurant restaurant restaurant__open'] //div[@class='delivery-cost js-delivery-cost']")
    private List<WebElement> deliveryPriceList;
    @FindBy(css = ".kitchens")
    private List<WebElement> restaurantsResultCategoryList;
    @FindBy(xpath = "//a[@href='minimalna-kwota-zamowienia']")
    private List<WebElement> minimumOrderPriceFilterList;
    @FindBy(xpath = "//div[@class='js-restaurant restaurant restaurant__open'] //div[@class='min-order']")
    private List<WebElement> minimumOrderCostsResultList;

    public List<WebElement> getMinimumOrderCostsResultList() {
        return minimumOrderCostsResultList;
    }

    public List<WebElement> getMinimumOrderPriceFilterList() {
        return minimumOrderPriceFilterList;
    }

    public List<WebElement> getRestaurantsResultCategoryList() {
        return restaurantsResultCategoryList;
    }

    public List<WebElement> getDeliveryPriceList() {
        return deliveryPriceList;
    }

    public List<WebElement> getDeliveryPriceFilters() {
        return deliveryPriceFilters;
    }

    public List<WebElement> getCategoryList() {
        return categoryList;
    }
}
