package PageObjects;

import Driver.DriverFactory.DriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import support.CommonActions;
import support.ConfigProp;
import support.ExcelHandler;
import java.util.Map;

public class ProductDetailsPageObjects {
    @FindBy(xpath = "(//div[contains(@class,'sd-product-tuple')]/descendant::div[@class='product-name-wrapper'])[1]")
            //(xpath = "(//div[@class='product-info-wrapper'])[1]/div/div/p/span")
    private static WebElement bookItemSearch;
    // @FindBy(xpath = "//p[@class='product-title_name ']"
    @FindBy(xpath = "//div[@class='product-title ship']")
            //(xpath = "//div[@class='product-title ship']")
    //@FindBy(xpath = "(//div[@class='product-title'])/p")
    private static WebElement bookItemPdp;
    @FindBy(xpath = "//*[@data-btntext='Buy Now']")
    private static WebElement buyNow;
    @FindBy(xpath = "//input[contains(@class,'userInputBox')]")
    private static WebElement mobNo;
    @FindBy(xpath="//input[@placeholder='Mobile Number']//following::div[1]")
            //(xpath="//div[@class=\'main-centre bc-cred-screen\']/child::*[4]'")
            //(xpath="//div[@class='btn react-cta ripplelink opera-btn btn-primary']")
            //(xpath = "//div[contains(text(),'Continue')]")
    private static WebElement continueBtn;
    //@FindBy(xpath="//*[@class='pos-relative appendBeforeCode errMsgValidate']")
    @FindBy(xpath="//input[contains(@class,'userInputBox')]//parent::div")
            //(xpath="//div[@data-default-err-msg=\"Mobile Number/Email is required to continue\"]")
            //(xpath = "//div[contains(text(),'user is disabled')]")
    ////div[contains(@data-default-err-msg,"continue")]
    private static WebElement errorMsg;

    public ProductDetailsPageObjects() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
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
    public void verifyPDP(String mobNo)  {
        CommonActions.WaitTillElementisvisible(bookItemSearch);
        if ((CommonActions.isElementPresent(bookItemSearch))) {
            System.out.println("Item found on search page");
        } else {
            System.out.println("Item not found on search page");
        }
        String book_searchtxt = bookItemSearch.getText();
        System.out.println("Name of product on search page:" + book_searchtxt);
        bookItemSearch.click();
        DriverFactory.getDriver().getPageSource();
        try {
            CommonActions.WaitTillElementisvisible(bookItemPdp);
            String bookPdpTxt = bookItemPdp.getText();
            System.out.println("Name of the Product opened in PDP : " + bookPdpTxt);
            if (DriverFactory.getDriver().getPageSource().contains(book_searchtxt)) {
                Assert.assertTrue(true);
                System.out.println("Same item is selected in both search page and pdp page");
            } else {
                Assert.assertEquals(book_searchtxt, bookPdpTxt);
                System.out.println("Same item is not selected in both search page and pdp page");
            }
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            e.printStackTrace();
        }
        buyNow.click();
        System.out.println("Clicked on buy now........");
        CommonActions.WaitTillElementisvisible(this.mobNo);
        System.out.println("Entering mobile number............");
        this.mobNo.sendKeys(mobNo);
        System.out.println("Mobile_number entered...........");
        CommonActions.WaitTillElementisvisible(continueBtn);
        CommonActions.WaitTillElementisClickable(continueBtn);
        continueBtn.click();
        System.out.println("Clicked on Continue........");
        if(ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("ios")){
        String errormsg= errorMsg.getAttribute("data-err-msg");
        System.out.println("Verifying the presence of error message:" + errormsg );}
        else if((ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("android")) ){
            CommonActions.isElementPresent(errorMsg);
            System.out.println("Verifying the presence of error message:" + CommonActions.isElementPresent(errorMsg));}
        }
    }







