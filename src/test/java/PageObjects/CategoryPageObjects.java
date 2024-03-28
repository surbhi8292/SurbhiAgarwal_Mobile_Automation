package PageObjects;

import Driver.DriverFactory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ExecuteMethod;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.CommonActions;
import support.ConfigProp;
import support.ExcelHandler;

import java.time.Duration;
import java.util.Map;

public class CategoryPageObjects {
    public CategoryPageObjects() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
    }
    @FindBy(xpath = "//div[@id=\"sidebar\"]")
    private static WebElement sideBar;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Men\")]")
    private static WebElement men;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Women\")]")
    private static WebElement women;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Kids\")]")
    private static WebElement kids;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Beauty\")]")
    private static WebElement beauty;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Home\")]")
    private static WebElement home;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Kitchen\")]")
    private static WebElement kitchen;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Fashion\")]")
    private static WebElement fashion;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Sports\")]")
    private static WebElement sports;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Health\")]")
    private static WebElement health;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Automotive\")]")
    private static WebElement automotive;

    @FindBy(xpath = "//div[@id=\"sidebar\"]/child::a[contains(@id,\"Other\")]")
    private static WebElement other;

    @FindBy(xpath = "//div[@class=\"component-categories-content-wise\"]/div[text()=\"Other Categories\"]")
    private static WebElement otherCatHeader;

    @FindBy(xpath = "//div[@class=\"main-heading\" and text()=\"Other Categories\"]/following-sibling::*/div/div")
    private static WebElement otherSubCat;
    @FindBy(xpath = "//*[@id='footerContainer']/li[@data-title='Category']")
    private static WebElement footerCategory;
    @FindBy(xpath = "//*[@id=\"Brand$\"]/div/img")
    private static WebElement categoryBrand;
    @FindBy(xpath = "//*[@id=\"Electronics & Accessories$\"]/div/img")
    private static WebElement categoryElectronicsAndAccessories;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='Pens & Markers']")
    private static WebElement categoryOtherContentPensAndMarkers;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='School Bags & Supplies']")
    private static WebElement categoryOtherContentSchoolsBagsSupplies;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='Art & Craft Supplies']")
    private static WebElement categoryOtherContentAirCraft;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='Stationery Supplies']")
    private static WebElement categoryOtherContentStationerySupplies;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='Lab Equipment']")
    private static WebElement categoryOtherContentLabEquipment;
    @FindBy(xpath="//div[@class=\"main-heading\"and text()='Other Categories']")
    private static WebElement otherCategoriesTitle;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='Collectibles']")
    private static WebElement categoryOtherCategoriesCollectibles;
    @FindBy(xpath = "//div[@class='sub-text-category' and text()='Books']")
    private static WebElement categoryOtherContentBooks;
    @FindBy(xpath="//div[@class=\"searchSugg\"]/span")
    private static WebElement booksCount;
    @FindBy(xpath = "//*[@id=\"editedPin\"]")
    private static WebElement booksPincode;
    @FindBy(xpath = "//span[@class='checkCol']")
    //(xpath ="//*[@id='serviceability']/div/span")
    private static WebElement booksCheckBtn;
    @FindBy(xpath = "//*[@id=\"serviceability\"]/span/span[1]/text()[1]")
    private static WebElement booksDeliverText;
    @FindBy(xpath = "//span[@class='pincodeVal']")
    private static WebElement pincodeValue;
    @FindBy(xpath = "//input[@name='serviceabilty']")
    //(xpath="//*[@id=\"serviceability\"]/span/input[@name='serviceabilty']")
    private static WebElement deliverCheckBox;
    @FindBy(xpath = "//i[@class='editPin']")
    private static WebElement edit;

    public boolean check(WebElement ele) {
        if (CommonActions.isElementPresent(ele))
            return true;
        return false;
    }

    public void openAndVerifyCategory()  {
        DriverFactory.getDriver().getPageSource();
        System.out.println("Verifying footer category status:" + footerCategory.isDisplayed());
        footerCategory.click();
        System.out.println("Selected category from footer");
        CommonActions.WaitTillElementisvisible(sideBar);
        if (check(categoryBrand)) {
            System.out.println("Category brand present");
        }
        if (check(men)) {
            System.out.println("Category men present");
        }
        if (check(women)) {
            System.out.println("Category women present");
        }
        if (check(kids)) {
            System.out.println("Category kids present");
        }
        if (check(beauty)) {
            System.out.println("Category Beauty and Personal Care present");
        }
        if (check(home)) {
            System.out.println("Category Home present");
        }

        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollBy(158,2000)", "");
        js.executeScript("arguments[0].scrollIntoView();", kitchen);
        //CommonActions.fingerSwipe(158, 1610, 184, 896, 2000);
        if (check(kitchen)) {
            System.out.println("Category kitchen present");
        }
        if (check(fashion)) {
            System.out.println("Category Fashion Accessories present");
        }
        js.executeScript("window.scrollBy(158,2000)", "");
        js.executeScript("arguments[0].scrollIntoView();", sports);
        //CommonActions.fingerSwipe(158, 1610, 184, 896, 2000);
        if (check(sports)) {
            System.out.println("Category Sports and travel present");
        }
        if (check(health)) {
            System.out.println("Category Health_and_wellness present");
        }
        js.executeScript("window.scrollBy(158,2000)", "");
        js.executeScript("arguments[0].scrollIntoView();", categoryElectronicsAndAccessories);
        //CommonActions.fingerSwipe(158, 1610, 184, 896, 2000);
        if (check(categoryElectronicsAndAccessories)) {
            System.out.println("Category Electronics and Accessories present");
        }
        if (check(automotive)) {
            System.out.println("Category Automotive present");
        }
        js.executeScript("window.scrollBy(158,2000)", "");
        js.executeScript("arguments[0].scrollIntoView();", other);
        //CommonActions.fingerSwipe(158, 1610, 184, 896, 2000);
        //CommonActions.fingerSwipe(158, 1610, 184, 896, 2000);
        if (check(other)) {
            System.out.println("Other Categories present");
        }
        System.out.println("Verified all categories");
        other.click();
        System.out.println("Clicked on other categories..........");
        System.out.println("************ Validating other categories title- Sub categories********************");
        if (check(otherCategoriesTitle)) {
            System.out.println("Other category heading title is present");
        }
        if (check(categoryOtherContentBooks)) {
            System.out.println("Sub Categories - Book is present");
        }
        if (check(categoryOtherContentPensAndMarkers)) {
            System.out.println("Sub Categories - Pens_and_markers is present");
        }
        if (check(categoryOtherContentSchoolsBagsSupplies)) {
            System.out.println("Sub Categories - Schools bags supplies is present");
        }
        if (check(categoryOtherContentAirCraft)) {
            System.out.println("Sub Categories - Art craft is present");
        }
        if (check(categoryOtherContentStationerySupplies)) {
            System.out.println("Sub Categories - Stationery supplies is present");
        }
        if (check(categoryOtherContentLabEquipment)) {
            System.out.println("Sub Categories - Lab equipment is present");
        }
        if (check(categoryOtherCategoriesCollectibles)) {
            System.out.println("Sub Categories - Collectibles is present");
        }
        System.out.println("Verified all sub-categories");

    }

    public void openBooks() {
        if (CommonActions.isElementPresent(categoryOtherContentBooks)) {
            categoryOtherContentBooks.click();
            System.out.println("Clicked on books..........");
        }
        CommonActions.isElementPresent(booksCount);
        System.out.println("Verified books count: " + booksCount.getText());
    }

    public void enterZipcodeAndVerifyDelivery(String pin) {
        DriverFactory.getDriver().getPageSource();
        try {
            CommonActions.WaitTillElementisvisible(booksPincode);
            System.out.println("Verifying presence of pincode input box:" + CommonActions.isElementPresent(booksPincode));
            booksPincode.sendKeys(pin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Verifying Check button enabling:" + booksCheckBtn.isEnabled());
        booksCheckBtn.click();
        String Actpincode = pincodeValue.getText();
        Assert.assertEquals(Actpincode, pin);
        System.out.println("Entered ZipCode Value matches the displayed zipcode value");
        DriverFactory.getDriver().getPageSource();
        if (CommonActions.isElementPresent(booksDeliverText)) {
            System.out.println("Verifying Deliver To text:" + booksDeliverText.getText());
        }
        if (deliverCheckBox.isDisplayed()) {
            if (deliverCheckBox.isEnabled()) {
                System.out.println("Books delivery checkbox is verified");
            } else {
                System.out.println("Books delivery checkbox not verified");
            }
        }
    }

    public String getValueFromExcel(String key) {
        Map<String, String> testData = ExcelHandler.getTestDataInMap(
                ConfigProp.getPropertyValue("testdata.path"),
                ConfigProp.getPropertyValue("testdata.sheetName"),
                key);
        if (testData.size() > 0) {
            System.out.println("Test Data: " + testData.get(ConfigProp.getPropertyValue("testdata.input")));
        }

        return testData.get(ConfigProp.getPropertyValue("testdata.input"));
    }
}


