package TestCases;

import Framework.BaseTest;
import Framework.Report;
import Framework.Screenshot;
import Task.HomeTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuarioTestCase extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask  homeTask = new HomeTask(driver);


    @Test
    public void realizarCadastro() {

        try{

            Report.startReport("Cadastrando Novo Usuario");

            homeTask.acessaPageAutomacaoWeb();





        }catch (Exception e){

             Report.extentTest.log(Status.ERROR, e.getMessage(), Screenshot.captureBase64(driver));
        }



    }
}
