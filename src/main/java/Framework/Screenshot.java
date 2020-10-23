package Framework;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    private static String PATH_SCREENSHOT = Report.PATH_REPORT + File.separator + "Screenshot";

    public static MediaEntityModelProvider capture (WebDriver driver){

        try{

            CreateFolder.createFolderReport(PATH_SCREENSHOT);
            File scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = PATH_SCREENSHOT + File.separator + "Image_" + DateTime.getDateTimeFormatScreenshot() + ".png";
            FileUtils.copyFile(scrshot, new File(screenshotPath));
            return MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();

        }catch (IOException e){

            System.out.println("Erro ao copiar arquivo !" + e.getMessage());


        }

        return null;
    }

    public static MediaEntityModelProvider captureBase64(WebDriver driver){

        try{

            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();



        } catch (IOException e) {
            System.out.println("Erro ao criar string " + e.getMessage());
        }

         return null;

    }

}
