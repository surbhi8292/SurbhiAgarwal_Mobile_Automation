package Driver.DriverManager.Mobile.Android.Android_mWebApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import support.ConfigProp;

import java.net.URI;
import java.net.URL;

import static Driver.DriverFactory.DriverFactory.setDriver;

public class LaunchSaucelabAndroidBrowser {
    public static void SetSauceBrowserDriver(){
        if(ConfigProp.getPropertyValue("browserName").equalsIgnoreCase("chrome")){
            LaunchSaucelabAndroidBrowser.SetSauceChromeBrowserDriver();
        } else if (ConfigProp.getPropertyValue("browserName").equalsIgnoreCase("firefox")){
            //set your sauce lab android firefox browser configuration here
        }
    }
    public static void SetSauceChromeBrowserDriver()
    {
        try {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "Android");
            //caps.setCapability("appPackage", "com.android.chrome");
            //caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
            caps.setCapability("appium:browserName", "chrome");
            caps.setCapability("appium:deviceName", "Samsung galaxy S22 5G");
            caps.setCapability("appium:platformVersion", "13");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:autoGrantPermissions", true);
            caps.setCapability("autoAcceptAlerts", "true");
            caps.setCapability("noReset", true);
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", ConfigProp.getPropertyValue("sauceUserName"));
            sauceOptions.setCapability("accessKey", ConfigProp.getPropertyValue("sauceAccessKey"));
            sauceOptions.setCapability("appiumVersion", "2.0.0");
            sauceOptions.setCapability("build", "POC Test For Android Automation");
            sauceOptions.setCapability("name", "Sauce lab Android Chrome Browser Test");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URI("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub").toURL();
            AppiumDriver driver = new AndroidDriver(url, caps);
            setDriver(driver);
            Thread.sleep(5000);
            System.out.println("Android Saucelab Chrome Browser Connected successfully");
        }catch (Exception e) {
            System.out.println("Android Saucelab Chrome Browser Session Creation Failed");
            e.printStackTrace();
        }

    }
}
