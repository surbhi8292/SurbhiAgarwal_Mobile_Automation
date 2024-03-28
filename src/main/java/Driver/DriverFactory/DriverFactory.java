package Driver.DriverFactory;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static AppiumDriver getDriver(){
        return (AppiumDriver) driver.get();
    }

    public static void setDriver(AppiumDriver Driver){
        if (Objects.nonNull(driver)){
            driver.set(Driver);
            System.out.println("Driver is all set");
        }
    }
}
