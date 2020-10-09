package Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseTest extends DriverManager{

    private static WebDriver driver;

    private String url = "https://automacaocombatista.herokuapp.com/home/index";

    public static WebDriver getDriver(){

       return driver = getDriver(TypeDriver.CHROME);

    }

    @BeforeEach
    public void setUp() throws IOException {

        getDriver().get(url);
    }

    @AfterEach
    public void tearDown(){

        quitDriver();

    }
}
