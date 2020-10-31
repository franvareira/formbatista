package Task;

import Framework.Report;
import Framework.Screenshot;
import PageObjects.MenuFormPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MenuFormTask {

    private WebDriver driver;
    private MenuFormPage menuFormPage;

    public MenuFormTask(WebDriver driver) {
        this.driver = driver;
        menuFormPage = new MenuFormPage(this.driver);
    }

    public void acessarFormulario(){

        validaPaginaForm();
        menuFormPage.getFormularioLink().click();
        menuFormPage.getCriarUsuarioLink().click();
        validaFormCarregado();

    }

    private void validaPaginaForm(){

        try{

            String text = menuFormPage.getTextTitle().getText();
            Assertions.assertEquals("Lista de Funcionalidades",text);
            Report.extentTest.log(Status.PASS, "Carregou a pagina do formulario com sucesso" , Screenshot.captureBase64(driver));

        }catch (Exception e){

            Report.extentTest.log(Status.FAIL, "Pagina nao foi carregada", Screenshot.captureBase64(driver));
        }
    }

    private void validaFormCarregado(){

        try{

            Assertions.assertEquals("Novo Usuário!!",menuFormPage.getTextFormUsuarioTitle().getText());
            Report.extentTest.log(Status.PASS, "Carregou o formulario com sucesso" , Screenshot.captureBase64(driver));

        }catch (Exception e){

            Report.extentTest.log(Status.FAIL, "Formulario não carregado", Screenshot.captureBase64(driver));

        }


    }

}
