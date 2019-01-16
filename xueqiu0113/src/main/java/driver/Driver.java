package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver{

    private static  AndroidDriver<AndroidElement> driver;

    public static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "192.168.74.101:5555");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl=null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    public static AndroidDriver<AndroidElement> getCurrentDriver(){
        return driver;
    }
}

