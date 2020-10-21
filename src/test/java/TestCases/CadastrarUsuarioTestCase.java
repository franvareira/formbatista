package TestCases;

import Framework.BaseTest;
import Task.HomeTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuarioTestCase extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask  homeTask = new HomeTask(driver);


    @Test
    public void realizarCadastro() throws InterruptedException {

        homeTask.acessaPageAutomacaoWeb();

    }
}
