package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InsiderPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class InsiderTest {
    WebDriverWait wait;

    @Test
    public void testInsiderSteps() throws IOException, InterruptedException {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        InsiderPage insiderPage = new InsiderPage();

        try {
            // --- 0. ADIM: ANA SAYFA VE ÇEREZLERİ KAPATMA ---
            System.out.println("0. Ana sayfa açılıyor...");
            Driver.getDriver().get("https://insiderone.com/");

            // Çerezleri Reddet (Decline All)
            try {
                WebElement declineCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("wt-cli-reject-btn")));
                declineCookies.click();
                System.out.println("Çerezler başarıyla reddedildi.");
            } catch (Exception e) {
                System.out.println("Çerez uyarısı çıkmadı veya zaten kapatılmış.");
            }

            Thread.sleep(2000);
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("insider"), "Ana sayfa açılamadı!");

            // Blok Kontrolleri
            wait.until(ExpectedConditions.visibilityOf(insiderPage.navigationBar));
            Assert.assertTrue(insiderPage.navigationBar.isDisplayed(), "Header yüklenmedi!");
            Assert.assertTrue(insiderPage.footer.isDisplayed(), "Footer yüklenmedi!");

            // --- 1 & 2. ADIM: QA Sayfası ---
            Driver.getDriver().get("https://useinsider.com/careers/quality-assurance/");

            // QA sayfasında da çerez çıkarsa kapat
            try {
                if (Driver.getDriver().findElements(By.id("wt-cli-reject-btn")).size() > 0) {
                    Driver.getDriver().findElement(By.id("wt-cli-reject-btn")).click();
                }
            } catch (Exception e) { /* Gerek yoksa geç */ }

            WebElement seeAllJobsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("See all QA jobs")));
            js.executeScript("arguments[0].click();", seeAllJobsBtn);

            // ... (Kodun geri kalanı aynı şekilde devam ediyor)

            js.executeScript("window.scrollTo(0, 600)");
            Thread.sleep(5000);

            // Lokasyon Seçimi - Istanbul
            WebElement nativeSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#filter-by-location")));
            js.executeScript("arguments[0].style.display='block'; arguments[0].scrollIntoView({block: 'center'});", nativeSelect);
            Thread.sleep(2000);

            Select select = new Select(nativeSelect);
            select.selectByVisibleText("Istanbul, Turkiye");

            // İlan Kontrolü
            Thread.sleep(5000);
            List<WebElement> jobs = Driver.getDriver().findElements(By.className("position-list-item"));
            Assert.assertFalse(jobs.isEmpty(), "İlan listesi yüklenemedi!");

            // İlana Tıklama
            String exactJobTitle = "Software Quality Assurance Engineer (Remote)";
            WebElement targetJobWrapper = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//p[contains(text(),'" + exactJobTitle + "')]/parent::div")));

            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetJobWrapper);
            Thread.sleep(2000);
            actions.moveToElement(targetJobWrapper).build().perform();
            Thread.sleep(2000);

            WebElement viewRoleBtn = targetJobWrapper.findElement(By.linkText("View Role"));
            js.executeScript("arguments[0].click();", viewRoleBtn);

            // Sekme Kontrolü
            Thread.sleep(3000);
            for (String handle : Driver.getDriver().getWindowHandles()) {
                Driver.getDriver().switchTo().window(handle);
            }
            wait.until(ExpectedConditions.urlContains("lever"));
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("lever"), "Lever sayfası açılmadı!");
            System.out.println("7. TEST BAŞARIYLA TAMAMLANDI!");

        } catch (Exception e) {
            System.out.println("!!! HATA: " + e.getMessage());
            ReusableMethods.getScreenshot("Final_Hata");
            throw e;
        }
    }
}