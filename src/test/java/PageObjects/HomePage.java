package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement homeTitle(){

        //return this.driver.findElement(By.xpath("//h4[@class=' header col orange-text']"));
        return waits.visibilityOfElement(By.xpath("//h4[@class=' header col orange-text']"));

    }

    public WebElement startButton(){

        return waits.visibilityOfElement(By.xpath("//div[@class='row col s12']/div[@class='col s6']/div[@id='index-banner']/div/div/a"));
    }


}
