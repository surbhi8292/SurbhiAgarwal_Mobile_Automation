package PageMethods;
import TestFactory.TestPageObjectsFactory;

public class ProductDetailsPageMethods extends TestPageObjectsFactory {
    public void Verify_PDP(String mobile_no) throws InterruptedException {
        productDetailsPageObjects().verifyPDP(mobile_no);
    }
    public String getValueFromExcelPage(String key) {
        return productDetailsPageObjects().getValueFromExcel(key);
    }

}
