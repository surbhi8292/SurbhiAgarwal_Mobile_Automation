package PageObjects;

import Driver.DriverFactory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.CommonActions;
import support.ConfigProp;
import support.ExcelHandler;
import java.time.Duration;
import static java.lang.Thread.sleep;

public class HomePageObjects {
    public HomePageObjects() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
    }

    @FindBy(xpath = "//*[contains(@text,'Continue')]")
    private static WebElement continueBtn;
    //@FindBy(xpath = "//*[@id='new-app-header']/div[1]/div[1]")
    @FindBy(xpath = "//div[@class=\"inner-elements-container left-side-elements\"]/child::*")
    private static WebElement snapdealLogo;
   // @FindBy(xpath = "//div[@class='snapcash-icon-container nh-sd}']")
    @FindBy(xpath = "(//div[@class=\"inner-elements-container right-side-elements\"]/child::*)[1]")
    private static WebElement walletLogo;
    //@FindBy(xpath = "//*[@id='new-app-header']/div[1]/div[2]/div[1]/div/span[2]/span")
    @FindBy(xpath = "(//div[@class=\"inner-elements-container right-side-elements\"]/child::*)[1]")
    private static WebElement walletAmount;
    //@FindBy(xpath = "//*[@id='new-app-header']/div[1]/div[2]/a[@style='line-height: 0%;']")
    @FindBy(xpath = "(//div[@class=\"inner-elements-container right-side-elements\"]/child::*)[2]")
    private static WebElement wishList;
    //@FindBy(xpath = "//*[@id='new-app-header']/div[1]/div[2]/div[2][@class='vernac-icon-ct']")
    @FindBy(xpath = "(//div[@class=\"inner-elements-container right-side-elements\"]/child::*)[3]")
    private static WebElement language;
    @FindBy(xpath="//li[@data-title=\"Home\"]")
    //@FindBy(xpath = "//ul[@class=\"footer\"]/child::li[@data-title=\"Home\"]")
    private static WebElement footerHome;
    @FindBy(xpath = "//ul[@class=\"footer\"]/child::li[@data-title=\"Category\"]")
    private static WebElement footerCategory;
    @FindBy(xpath = "//ul[@class=\"footer\"]/child::li[@data-title=\"Cart\"]")
    private static WebElement footerCart;
    @FindBy(xpath = "//ul[@class=\"footer\"]/child::li[@data-title=\"Profile\"]")
    private static WebElement footerProfile;
    @FindBy(xpath = "//span[@id='preFillInput']/parent::div")
    //(xpath="//*[@id='new-app-header']/div[2]/div/div")
    private static WebElement searchBar;
    public void launchAppAndGoToSnapDealWebpage() {
        try {

            if (CommonActions.isElementPresent(continueBtn)) {
                continueBtn.click();
            }
            DriverFactory.getDriver().get(ConfigProp.getPropertyValue("url"));
            sleep(10000);
            System.out.println("Launched browser Navigated to SnapDeal Webpage");
        } catch (Exception e) {

        }
    }
    public void validateSnapdealHomePageheaders() {
        CommonActions.isElementPresentt(snapdealLogo, "Snapdeal logo");
        CommonActions.isElementPresentt(walletLogo, "wallet logo");
        CommonActions.isElementPresentt(walletAmount, "wallet amt");
        CommonActions.isElementPresentt(wishList, "wishlist btn");
        CommonActions.isElementPresentt(language, "language btn");
        System.out.println("++++++Verified Header section+++++++");
    }

    public void validateFooterOptions()  {
        CommonActions.WaitTillElementisvisible(footerHome);
        CommonActions.isElementPresentt(footerHome, "Footer home");
        CommonActions.isElementPresentt(footerCategory, "Footer category");
        CommonActions.isElementPresentt(footerCart, "Footer cart");
        CommonActions.isElementPresentt(footerProfile, "Footer profile");
        System.out.println("++++++Verified Footer section+++++++");
    }

    public void validateSearchBar()  {
            CommonActions.isElementPresentt(searchBar, "Search input");
            System.out.println("++++++Verified Search box section+++++++");
    }
}


