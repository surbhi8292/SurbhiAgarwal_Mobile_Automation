package Driver.DriverManager.Mobile.IOS.IOS_NativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import support.ConfigProp;

import java.net.URI;
import java.net.URL;

import static Driver.DriverFactory.DriverFactory.setDriver;

public class LaunchSaucelabIOSNativeApp {

    public static void setIOSNativeAppDriver(){

        try {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "iOS");
//        caps.setCapability("appium:app", "storage:filename=Convivio.ipa");  // The filename of the mobile app
            caps.setCapability("appium:deviceName", "iPhone.*");
            caps.setCapability("appium:platformVersion", "16");
            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:budleId", "com.apple.Preferences");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", ConfigProp.getPropertyValue("sauceUserName"));
            sauceOptions.setCapability("accessKey", ConfigProp.getPropertyValue("sauceAccessKey"));
            sauceOptions.setCapability("build", "IOS POC AUTOMATION");
            sauceOptions.setCapability("name", "iOS Native App Test");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URI("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub").toURL();
            AppiumDriver driver = new IOSDriver(url, caps);
            System.out.println("iOS Session Started");
            setDriver(driver);
            Thread.sleep(10000);
            System.out.println("App Launched successfully");
        }catch (Exception e) {
            System.out.println("iOS Session Creation Failed");
            e.printStackTrace();
        }
    }
}

