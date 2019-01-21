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
        GlobleConfig con= GlobleConfig.load("/data/globalConfig.yaml");
        con.appcon.cap.keySet().forEach(key->{
            Object value=con.appcon.cap.get(key);
            desiredCapabilities.setCapability(key,value);
        });
        URL remoteUrl=null;
        try {
            remoteUrl = new URL(con.appcon.url);
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(con.appcon.wait, TimeUnit.SECONDS);
    }

    public static AndroidDriver<AndroidElement> getCurrentDriver(){
        return driver;
    }
}

