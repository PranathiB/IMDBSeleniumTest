package helpers;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelperClass extends TestWatcher {
    private final TakesScreenshot takesScreenshot;

    public ScreenshotHelperClass(TakesScreenshot takesScreenshot) {
        this.takesScreenshot = takesScreenshot;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("src/reports/" + description + ".png");
        try {
            FileUtils.copyFile(screenshot, targetFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
