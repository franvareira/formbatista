package Task;

import Framework.Report;
import Framework.Screenshot;
import PageObjects.FormularioPage;
import Utils.FakerGeneration;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormularioTask {

    private WebDriver driver;
    private FormularioPage formularioPage;
    private FakerGeneration faker;

    public FormularioTask(WebDriver driver) {
        this.driver = driver;
        formularioPage = new FormularioPage(this.driver);
        faker = new FakerGeneration(this.driver);
    }

    public void preencherForm(){

        formularioPage.getNomeTextField().sendKeys(faker.getFirstName());
        formularioPage.getUltimoNomeTextField().sendKeys(faker.getLastName());
        formularioPage.getEmailTextField().sendKeys(faker.getEmail());
        formularioPage.getEnderecoTextField().sendKeys(faker.getAddress());
        formularioPage.getUniversityTextField().sendKeys(faker.getUniversity());
        formularioPage.getProfissaoTextField().sendKeys(faker.getProfession());
        formularioPage.getGeneroTextField().sendKeys(faker.getGenre());
        formularioPage.getIdadeTextField().sendKeys(faker.getAge());
        formularioPage.getEnviarButton().click();
        validaCriacaoUsuario();

    }

    private void validaCriacaoUsuario(){

        try{

            String text = formularioPage.getMensagemTitle().getText();
            Assertions.assertEquals("Usuário Criado com sucesso",text);
            Report.extentTest.log(Status.PASS, "Usuario criado com sucesso" , Screenshot.captureBase64(driver));


        }
        catch (Exception e){

            Report.extentTest.log(Status.FAIL, "Pagina nao foi carregada", Screenshot.captureBase64(driver));
        }


    }
}
