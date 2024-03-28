package Driver.DriverManager.Mobile.IOS.IOS_mWebApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import support.ConfigProp;

import java.net.URI;
import java.net.URL;

import static Driver.DriverFactory.DriverFactory.setDriver;

public class LaunchSaucelabIOSBrowser {
    public static void SetIOSSauceBrowserDriver(){
        if(ConfigProp.getPropertyValue("browserName").equalsIgnoreCase("chrome")){
            LaunchSaucelabIOSBrowser.SetSauceChromeBrowserDriver();
        } else if (ConfigProp.getPropertyValue("browserName").equalsIgnoreCase("safari")){
            LaunchSaucelabIOSBrowser.SetSauceSafariBrowserDriver();
        }
    }
    AndroidDriver driver;
    public static void SetSauceChromeBrowserDriver()
    {

    }
    public static void SetSauceSafariBrowserDriver(){
        try {
            System.out.println("Trying to connect to Saucelab iOS Safari Browser");
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "iOS");
//        caps.setCapability("appium:app", "storage:filename=Convivio.ipa");  // The filename of the mobile app
            caps.setCapability("appium:deviceName", "iPhone 12 pro");
            caps.setCapability("appium:browserName", "Safari");
            caps.setCapability("appium:platformVersion", "16");
            caps.setCapability("appium:automationName", "XCUITest");
           // caps.setCapability("appium:budleId", "com.apple.mobilesafari");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", ConfigProp.getPropertyValue("sauceUserName"));
            sauceOptions.setCapability("accessKey", ConfigProp.getPropertyValue("sauceAccessKey"));
            //sauceOptions.setCapability("build", "Build Number");
            sauceOptions.setCapability("name", "iOS Safari Browser Automation Test");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URI("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub").toURL();
            AppiumDriver driver = new IOSDriver(url, caps);
            System.out.println("iOS Session Started");
            Thread.sleep(5000);
            setDriver(driver);
            System.out.println("Safari Browser connected successfully in Sauce labs");
        }catch (Exception e) {
            System.out.println("iOS Session Creation Failed");
            e.printStackTrace();
        }
    }
}
