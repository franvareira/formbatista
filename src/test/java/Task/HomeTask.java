package Task;

import Framework.Report;
import Framework.Screenshot;
import Framework.Waits;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeTask {

    private static WebDriver driver;
    private static HomePage homePage;
    private static Waits waits;

    public HomeTask(WebDriver driver) {

        this.driver = driver;
        homePage = new HomePage(this.driver);
        waits = new Waits(this.driver);
    }

    public void acessaPageAutomacaoWeb(){

        homeValidation();
        waits.loadElement(homePage.startButton());
        homePage.startButton().click();

    }

    private void homeValidation(){

        try{

        Assertions.assertTrue(homePage.homeTitle().isDisplayed());
        Report.extentTest.log(Status.PASS, "Pagina Acessada com sucesso", Screenshot.capture(driver));

    }catch (Exception e){

        Report.extentTest.log(Status.FAIL, "Não foi possivel acessar a pagina", Screenshot.capture(driver));

        }
    }



}
