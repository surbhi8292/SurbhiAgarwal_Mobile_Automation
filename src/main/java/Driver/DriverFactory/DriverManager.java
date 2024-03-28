package Driver.DriverFactory;


import Driver.DriverManager.Mobile.Android.Android_NativeApp.LaunchSaucelabAndroidApp;
import Driver.DriverManager.Mobile.Android.Android_mWebApp.LaunchSaucelabAndroidBrowser;
import Driver.DriverManager.Mobile.IOS.IOS_NativeApp.LaunchSaucelabIOSNativeApp;
import Driver.DriverManager.Mobile.IOS.IOS_mWebApp.LaunchSaucelabIOSBrowser;
import support.ConfigProp;

public class DriverManager {
    
    public static void initDriver(){
        switch (ConfigProp.getPropertyValue("executionType").toLowerCase()){
            case "local" :
                local_driverInitialization();
                break;
            case "sauce_labs" :
                sauceLabCloud_driverInitialization();
                break;
            default:
                break;
        }
    }

    public static void local_driverInitialization(){
        if (ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("ios")){
            //set your local ios configuration here
        }
        else if(ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("android")) {
            //set your local android configuration here
        }
    }


    public static void sauceLabCloud_driverInitialization(){
        if (ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("ios")){
            if(ConfigProp.getPropertyValue("appType").equalsIgnoreCase("native")){
                LaunchSaucelabIOSNativeApp.setIOSNativeAppDriver();
            } else if (ConfigProp.getPropertyValue("appType").equalsIgnoreCase("mWeb")) {
                LaunchSaucelabIOSBrowser.SetIOSSauceBrowserDriver();
            }
        }
        else if (ConfigProp.getPropertyValue("platformName").equalsIgnoreCase("android")){
            if(ConfigProp.getPropertyValue("appType").equalsIgnoreCase("native")){
                LaunchSaucelabAndroidApp.setAndroidNativeAppDriver();
            } else if (ConfigProp.getPropertyValue("appType").equalsIgnoreCase("mWeb")) {
                LaunchSaucelabAndroidBrowser.SetSauceBrowserDriver();
            }
        }
    }

    public static void CloseDriver(){
        if(DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
        }
    }
}
