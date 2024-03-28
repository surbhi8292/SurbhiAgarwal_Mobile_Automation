package Driver.DriverManager.Mobile.Android.Android_NativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import support.ConfigProp;

import java.net.URI;
import java.net.URL;

import static Driver.DriverFactory.DriverFactory.setDriver;

public class LaunchSaucelabAndroidApp {

    public static void setAndroidNativeAppDriver(){

        try {
            System.out.println("Trying to connect to Saucelab Android App");

            UiAutomator2Options caps = new UiAutomator2Options();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:app", "storage:filename=Evendor_Shopping_App.apk");
            caps.setCapability("appium:deviceName", "Google.*");
            caps.setCapability("appium:platformVersion", "13");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:autoGrantPermissions", true);

            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", ConfigProp.getPropertyValue("sauceUserName"));
            sauceOptions.setCapability("accessKey", ConfigProp.getPropertyValue("sauceAccessKey"));
            sauceOptions.setCapability("build", "POC for Appium Android Automation");
            sauceOptions.setCapability("name", "Sauce lab Android native App Test");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URI("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub").toURL();
            AppiumDriver driver = new AndroidDriver(url, caps);
            setDriver(driver);
            Thread.sleep(8000);
            System.out.println("Android Saucelab Connection is successfully");
        }catch (Exception e) {
            System.out.println("Android Session Creation Failed");
            e.printStackTrace();
        }
    }
}

