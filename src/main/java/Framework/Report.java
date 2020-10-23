package Framework;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {

    public static WebDriver driver;
    public static String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report" + File.separator + "Report_" + DateTime.getDateTimeFormatReport();
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void setExtentReport(){

        CreateFolder.createFolderReport(PATH_REPORT);

        htmlReporter = new ExtentHtmlReporter(PATH_REPORT + File.separator + "MyReport_" + DateTime.getDateTimeFormatReport()+  ".html");
        htmlReporter.config().setDocumentTitle("Reltorio Execucao de Testes Automatizados");
        htmlReporter.config().setReportName("Relatorio de Execução do Form Batista");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setTimeStampFormat(" EEEE , MMMM dd , yyyy , hh:mm a '('zzz')'");

        extentReports = new ExtentReports();

        extentReports.attachReporter(htmlReporter);

    }

    public static  void endReport(){

        extentReports.flush();

        if (driver!=null){

            driver.quit();
            driver=null;
        }

    }

    public static void startReport(String testName){

        extentTest = extentReports.createTest(testName);

    }

}
