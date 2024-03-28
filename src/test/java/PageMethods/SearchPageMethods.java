package PageMethods;
import TestFactory.TestPageObjectsFactory;
public class SearchPageMethods extends TestPageObjectsFactory  {
    public String getValueFromExcelPage(String key) {
        return searchPageObjects().getValueFromExcel(key);
    }

    public void search_For_Product(String product) throws InterruptedException {
        searchPageObjects().searchForProduct(product);
    }
    public void verifyingShoeItemPdp() throws InterruptedException {
        searchPageObjects().selectingImpaktoItemAndVerifyingInpdp();
        searchPageObjects().selectingSizeAndScrollingTillPinCodeField();
    }
    public void enterPinCode(String value) throws InterruptedException {
        searchPageObjects().enteringPinCode(value);
    }
    public void checkAndVerifyDeliveryText() throws InterruptedException {
        searchPageObjects().clickingOnCheckAndVerifyingDeliveryText();
        searchPageObjects().clickingOnBuyNow();
    }
    public void enterMob_noAndClickContinue(String mobile_no) throws InterruptedException {
        searchPageObjects().enterMobileNo(mobile_no);
        searchPageObjects().clickContinueandVerifyErrormsg();
    }

}
