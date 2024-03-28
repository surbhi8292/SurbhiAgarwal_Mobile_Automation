package PageMethods;

import PageObjects.CategoryPageObjects;
import TestFactory.TestPageObjectsFactory;

public class CategoryPageMethods extends TestPageObjectsFactory {
    public void Open_AndVerify_Category() throws InterruptedException {
        categoryPageObjects().openAndVerifyCategory();
    }
    public void Open_Books(){
        categoryPageObjects().openBooks();
    }

    public String getValueFromExcelPage(String key) {
        return categoryPageObjects().getValueFromExcel(key);
    }
    public void EnterZipcode_AndVerify_Delivery(String pin) throws InterruptedException {
        categoryPageObjects().enterZipcodeAndVerifyDelivery(pin);
    }

}
