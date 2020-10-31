package TestCases;

import Framework.BaseTest;
import Framework.Report;
import Framework.Screenshot;
import Task.FormularioTask;
import Task.HomeTask;
import Task.MenuFormTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuarioTestCase extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask  homeTask = new HomeTask(driver);
    private MenuFormTask menuFormTask = new MenuFormTask(driver);
    private FormularioTask formularioTask = new FormularioTask(driver);


    @Test
    public void realizarCadastro() {

        try{

            Report.startReport("Cadastrando Novo Usuario");

            homeTask.acessaPageAutomacaoWeb();
            menuFormTask.acessarFormulario();
            formularioTask.preencherForm();

        }catch (Exception e){

             Report.extentTest.log(Status.ERROR, e.getMessage(), Screenshot.captureBase64(driver));
        }



    }
}
