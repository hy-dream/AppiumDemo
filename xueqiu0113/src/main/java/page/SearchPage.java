package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static page.BasePage.find;

public class SearchPage {

    By searchInput=By.id("search_input_text");
    By stock=By.id("stockName");
    By cancel=By.id("action_close");

    public SearchPage search(String keyword){
        Driver.getCurrentDriver().findElement(searchInput).sendKeys(keyword);
        return this;

    }

    public ArrayList<String> getStockList(){
        ArrayList<String> stockList=new ArrayList<String>();
        for(WebElement e:Driver.getCurrentDriver().findElements(stock) ){
            stockList.add(e.getText());
        }
        return stockList;
    }

    public ArrayList<String> addSelected(){
        ArrayList<String> attList=new ArrayList<String>();
        WebElement e=find(By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
        attList.add(e.getAttribute("resourceId"));
        e.click();
        WebElement e1=find(By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
        attList.add(e1.getAttribute("resourceId"));
        return attList;
    }

    public void cancel(){
        find(cancel).click();
    }
}
