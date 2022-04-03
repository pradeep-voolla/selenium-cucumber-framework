package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.CommonLibrary;

import java.time.Duration;

public class MenuStepDefinition extends CommonLibrary {

    @Given("I am on the home page {string}")
    public void i_am_on_the_home_page(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedUrl = url;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        WebElement cookieButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookieButton.click();
    }

    @When("I hoover on the menu option {string}")
    public void i_hoover_on_the_menu_option(String menuText) {
        WebElement menu = driver.findElement(By.xpath(".//span[text() ='" + menuText + "']"));
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(menu).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));

    }

    @When("I click the women link {string}")
    public void i_click_the_women_link(String menuText) {
        WebElement menu = driver.findElement(By.xpath("//span[text() ='" + menuText + "']"));
        menu.click();
    }

    @Then("I should navigate to the women screen{string}")
    public void i_should_navigate_to_the_women_screen(String pageTitle) {
        String actualTitle = driver.getTitle();
        String expectedTitle = pageTitle;
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


}



