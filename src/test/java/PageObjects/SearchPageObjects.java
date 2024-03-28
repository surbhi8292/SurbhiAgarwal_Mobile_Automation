package PageObjects;

import Driver.DriverFactory.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.CommonActions;
import support.ConfigProp;
import support.ExcelHandler;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SearchPageObjects {
    public SearchPageObjects() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
    }
    JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
    @FindBy(xpath = "//span[@id='preFillInput']/parent::div")
    private static WebElement searchBar;
    @FindBy(xpath = "//input[@enterkeyhint='search']")
    private static WebElement searchInputBox;
    @FindBy(xpath = "(//div[contains(@class,'sd-product-tuple')]/descendant::div[@class='product-name-wrapper'])[3]")
    private static WebElement impaktoshoesItem;
    @FindBy(xpath = "(//div[contains(@class,'sd-product-tuple')]/descendant::div[@class='product-name-wrapper'])")
    private static String impaktoShoesItemxpath;
    @FindBy(xpath = "//div[@class='product-title ship']")
    private static WebElement pDPProdName;
    @FindBy(xpath = "//div[@class='sliderAttCont']/descendant::div[@class='attr-val' and text()='6']")
    private static WebElement sizeButton;
    @FindBy(xpath = "//*[@id=\"pinCode\"]")
    private static WebElement ipPinCodeTextField;
    @FindBy(xpath = "//span[@class='check-pincode checkBtnn btn-primary']")
    private static WebElement ipCheckButton;
    @FindBy(xpath = "//div[@class='promise-cont show-inline renovate']")
    private static WebElement iPDeliveryByText;
    @FindBy(xpath = "//*[@data-btntext='Buy Now']")
    private static WebElement buyNow;
    @FindBy(xpath = "//input[contains(@class,'userInputBox')]")
    private static WebElement mobNo;
    @FindBy(xpath = "//div[contains(text(),'Continue')]")
    private static WebElement continueBtn;
    @FindBy(xpath="//input[contains(@class,'userInputBox')]//parent::div")
    private static WebElement errorMsg;

    public void searchForProduct(String product)  {
        CommonActions.isElementPresentt(searchBar, "search bar");
        searchBar.click();
        CommonActions.WaitTillElementisvisible(searchInputBox);
        searchInputBox.sendKeys(product);
        System.out.println("Item entered for searching.......");
        searchInputBox.sendKeys(Keys.ENTER);
    }

    public void selectingImpaktoItemAndVerifyingInpdp()  {
        CommonActions.WaitTillElementisvisible(impaktoshoesItem);
        CommonActions.SwipeUp(2);
        String searchPageItemName = impaktoshoesItem.getText();
        System.out.println("Name of the Product in search page:" + searchPageItemName);
        impaktoshoesItem.click();
        String pdpItemName = pDPProdName.getText();
        System.out.println("Name of the Product in PDP page : " + pdpItemName);
        if (DriverFactory.getDriver().getPageSource().contains(searchPageItemName)) {
            Assert.assertTrue(true);
            System.out.println("Same item is selected in both search page and pdp page");
        } else {
            Assert.assertEquals(searchPageItemName, pdpItemName);
            System.out.println("Same item is not selected in both search page and pdp page");
        }
    }

    public void selectingSizeAndScrollingTillPinCodeField()  {
        js.executeScript("window.scrollBy(158,2000)", "");
        js.executeScript("arguments[0].scrollIntoView();", sizeButton);
        CommonActions.WaitTillElementisvisible(sizeButton);
        CommonActions.WaitTillElementisClickable(sizeButton);
        sizeButton.click();
        System.out.println("Selected Size 6 in PDP");
        CommonActions.scrollUntilElementDisplays(ipPinCodeTextField, 30, "down");
        if (CommonActions.isElementPresent(ipPinCodeTextField)) {
            System.out.println("pincode field is found to enter the pincode");
        } else {
            System.out.println("pincode field is not found");
        }
    }

    public void enteringPinCode(String value)  {
        ipPinCodeTextField.sendKeys(value);
        System.out.println("Pincode entered.................");

    }

    public void clickingOnCheckAndVerifyingDeliveryText() {
        ipCheckButton.click();
        System.out.println("Check button clicked on pdp............");
        if (CommonActions.isElementDisplayed(iPDeliveryByText)) {
            System.out.println("Promise_Date:" + iPDeliveryByText.getText());
        }
    }

    public void clickingOnBuyNow()  {
        buyNow.click();
        System.out.println("Buy now Button is clicked");
//        WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(),
//                timeout).until(ExpectedConditions.elementToBeClickable(mobNo));
    }

    public void enterMobileNo(String mobileNo)  {
        CommonActions.WaitTillElementisvisible(mobNo);
        mobNo.sendKeys(mobileNo);
        System.out.println("Mobile no entered............");
    }

    public void clickContinueandVerifyErrormsg() {
        CommonActions.WaitTillElementisvisible(continueBtn);
        continueBtn.click();
        System.out.println("Clicked on Continue........");
        if(ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("ios")){
            String errormsg= errorMsg.getAttribute("data-err-msg");
            System.out.println("Verifying the presence of error message:" + errormsg );}
        else if((ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("android")) ){
            CommonActions.isElementPresent(errorMsg);
            System.out.println("Verifying the presence of error message:" + CommonActions.isElementPresent(errorMsg));}
    }


    public String getValueFromExcel(String key) {
        Map<String, String> testData = ExcelHandler.getTestDataInMap(
                ConfigProp.getPropertyValue("testdata.path"),
                ConfigProp.getPropertyValue("testdata.sheetName"),
                key);
        if (testData.size() > 0) {
            System.out.println("Test Data: " + testData.get(ConfigProp.getPropertyValue("testdata.input")));
        }
        return testData.get("value");
    }
}

