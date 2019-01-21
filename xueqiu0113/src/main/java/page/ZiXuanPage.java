package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static driver.Driver.getCurrentDriver;

public class ZiXuanPage {

    By search=By.id("action_create_cube");
    By zixuanStock=By.id("portfolio_stockName");
    By remove=By.xpath("//*[@text='删除']");

    public SearchPage gotoSearch(){
        getCurrentDriver().findElement(search).click();
        return new SearchPage();
    }

    public ZiXuanPage removeSelect(String stockName){
        MobileElement e= getCurrentDriver().findElement(By.xpath("//*[@text='"+stockName+"']"));
        PointOption po=new PointOption();
        po.withCoordinates(e.getLocation().getX(),e.getLocation().getY());

        TouchAction action = new TouchAction(getCurrentDriver());
        action.longPress(po).release().perform();
        getCurrentDriver().findElement(remove).click();
        return this;
    }

    public ArrayList<String> getZiXuanList(){
        ArrayList<String> stockList=new ArrayList<String>();
        for(MobileElement e: getCurrentDriver().findElements(zixuanStock)){
            stockList.add(e.getText());
        }
        return stockList;
    }

}
