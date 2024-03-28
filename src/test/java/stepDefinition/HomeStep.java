package stepDefinition;

import PageMethods.CategoryPageMethods;
import PageMethods.SearchPageMethods;
import TestFactory.TestPageMethodsFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.ConfigProp;

public class HomeStep extends TestPageMethodsFactory {
    @Given("user launches the snapdeal web application")
    public void UserLaunchesTheSnapdealApplication() throws InterruptedException {
        String platform = ConfigProp.getPropertyValue("platformName");
        System.out.println("Running for " + platform);
        homePageMethods().VerifySnapDealWebHomePage();}

    @And("Verify Home Page")
    public void Verify_HomePage() throws InterruptedException {
        homePageMethods().Verify_Homepage_Snapdeal_Headers();
        homePageMethods().Verify_footer_options();
        homePageMethods().verify_search_bar();
    }

    @When("Enter zipcode {string} and verify checkbox")
    public void enterZipcodeAndVerifyCheckbox(String key) throws InterruptedException {
        categoryPageMethods().Open_AndVerify_Category();
        categoryPageMethods().Open_Books();
        String pin=categoryPageMethods().getValueFromExcelPage(key);
        categoryPageMethods().EnterZipcode_AndVerify_Delivery(pin);
    }

    @Then("Verify PDP {string}")
    public void verifyPDP(String key) throws InterruptedException {
        String mobile_no=productDetailsPageMethods().getValueFromExcelPage(key);
        productDetailsPageMethods().Verify_PDP(mobile_no);
    }

    @When("Validate search item {string} after searching for product")
    public void validateSearchItemAfterProductSearching(String key) throws InterruptedException {
        String product = searchPageMethods().getValueFromExcelPage(key);
        searchPageMethods().search_For_Product(product);
    }
    @Then ("Verify Shoe Item")
    public void verifyShoeItemPdp() throws InterruptedException {
        searchPageMethods().verifyingShoeItemPdp();
    }
    @Then("the user should see the pin code {string} on the screen")
    public void theUserShouldSeeThePinCodeOnTheScreen(String key) throws InterruptedException {
        String pin=searchPageMethods().getValueFromExcelPage(key);
        searchPageMethods().enterPinCode(pin);
    }
    @Then("The user should verify the entered pin code")
    public void userVerifiesPinCode() throws InterruptedException {
        searchPageMethods().checkAndVerifyDeliveryText();
    }
    @When("The user enters mobile number {string} and Click continue")
    public void theUserEntersMobileNumberAndClickContinue(String key) throws InterruptedException {
        String mobile_no=searchPageMethods().getValueFromExcelPage(key);
        searchPageMethods().enterMob_noAndClickContinue( mobile_no);
    }

    /*@When("the user sends key {string} to get data from excel")
    public void theUserSendsKeyToGetDataFromExcel(String key) {
        excelData = homePageMethods().getValueFromExcelPage(key);
    }*/


    /*@Then("the user should see the text {string} on the screen")
    public void theUserShouldSeeTheTextOnTheScreen(String value) {
        assert excelData.equals(value);
    }*/

    /*@When("the user   {string}")
    public void theUserClicksOnTheSearchBarAndSearchProduct(String key) throws InterruptedException {
        homePageMethods().clickOnSearchBar();
        String product = homePageMethods().getValueFromExcelPage(key);
        homePageMethods().searchForProduct(product);
    }

    @Then("the user should see the result test {string}")
    public void theUserShouldSeeTheResultTest(String expectedText) {
        String actualText = homePageMethods().getTheResultText();
        assert actualText.equals(expectedText);
    }*/
    }



