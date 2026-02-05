package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {
    public static String getScreenshot(String name) throws IOException {
        // Dosya ismine tarih ekleyerek her seferinde yeni bir dosya oluşmasını sağlarız
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Ekran görüntülerini projenin içindeki "test-output/Screenshots" klasörüne kaydeder
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + "_" + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}