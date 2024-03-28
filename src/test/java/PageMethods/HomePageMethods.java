package PageMethods;

import TestFactory.TestPageObjectsFactory;

public class HomePageMethods extends TestPageObjectsFactory {
    public void VerifySnapDealWebHomePage() {
        homePageObjects().launchAppAndGoToSnapDealWebpage();
        //homePageObjects() returns ho, from ho.launchAppAndGoToSnapDealWebpage();
    }

  public void Verify_Homepage_Snapdeal_Headers() {
       homePageObjects().validateSnapdealHomePageheaders();
    }

    public void Verify_footer_options() throws InterruptedException {
        homePageObjects().validateFooterOptions();
    }
    public void verify_search_bar() throws InterruptedException {
       homePageObjects().validateSearchBar();
    }

    /*public String getValueFromExcelPage(String key) {
        return homePageObjects().getValueFromExcel(key);
    }
    public void clickOnSearchBar() throws InterruptedException {
        homePageObjects().searchForProduct();
    }
    public void searchForProduct(String product) throws InterruptedException {
        homePageObjects().enterText(product);
    }
    public String getTheResultText() {
        return homePageObjects().getResultText();

    }*/
}