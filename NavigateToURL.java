package TestScripts;

import static org.testng.AssertJUnit.assertEquals;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;//explicit wait
import org.openqa.selenium.support.ui.WebDriverWait;//explicit wait
import org.testng.annotations.Test;

public class NavigateToURL {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebDriverWait wait2;
    public static WebDriverWait wait3;
    public static WebElement element;

    @Test
    public void mate() throws Exception {

        driver = new FirefoxDriver();
        driver.get("http://www.mate1.com/");

        // driver .manage().window().maximize();//for managing browsers
        // driver.findElement(By.xpath(".//*[@id='what']")).sendKeys("QA");//inputting
        // data in a text box.
        driver.findElement(By.xpath(".//*[@id='header-container']/div/a"))
                .click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);
        wait3 = new WebDriverWait(driver, 40);
        WebElement frame = driver.findElement(
                By.xpath("//*[@id='ajax_flow_holder']/div[1]/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@id='member_login']/div[2]/input"))
                .sendKeys("ranbir.singh.523@gmail.com");
        driver.findElement(By.xpath("//*[@id='member_login']/div[3]/input"))
                .sendKeys("waheguru");
        driver.findElement(By.xpath("//*[@id='member_login']/div[5]/input"))
                .click();
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait.until(ExpectedConditions
                .elementToBeClickable(By.id("profile_completed")));
        driver.findElement(By.id("profile_completed")).click();
        /*
         * WebElement input = driver.findElement(By.id("profile_completed"));
         * new Actions(driver).moveToElement(input).click().perform();
         * driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); new
         * Select(driver.findElement(By.id("income"))) .selectByVisibleText(
         * "Rather Not Say");
         */
        Thread.sleep(5000);
        wait2 = new WebDriverWait(driver, 40);
        wait2.until(ExpectedConditions
                .presenceOfElementLocated(By.id("aboutMyself")));
        driver.findElement(By.id("aboutMyself")).clear();
        driver.findElement(By.id("aboutMyself")).sendKeys(
                "Contact my mail at ranbir.singh.523@gmail.com and my website at www.in.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/html/body/div[3]/div/div[4]/div[2]/div/div[3]/form[1]/div/div[6]/input[1]")));
        driver.findElement(By
                .xpath("/html/body/div[3]/div/div[4]/div[2]/div/div[3]/form[1]/div/div[6]/input[1]"))
                .click();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("stmt");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/html/body/div[3]/div/div[4]/div[2]/div/div[5]/div[2]/div/center/a")));
        element = driver.findElement(By.xpath(
                "/html/body/div[3]/div/div[4]/div[2]/div/div[5]/div[2]/div/center/a"));
        element.click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div/div[4]/div[2]/div/span/a")));
        driver.findElement(
                By.xpath("/html/body/div[3]/div/div[4]/div[2]/div/span/a"))
                .click();

        try {
            // Thread.sleep(7000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "/html/body/div[3]/div/div[4]/div[2]/div/div[3]/form[1]/div/div[4]/p")));

            String Expected = "Contact my mail at ranbir.singh.523@gmail.com and my website at www.in.com";
            String Actual = driver
                    .findElement(By
                            .xpath("/html/body/div[3]/div/div[4]/div[2]/div/div[3]/form[1]/div/div[4]/p"))
                    .getText();
            System.out.println("current string:-" + driver
                    .findElement(By
                            .xpath("/html/body/div[3]/div/div[4]/div[2]/div/div[3]/form[1]/div/div[4]/p"))
                    .getText());

            assertEquals(Actual, Expected);
            System.out.println("All strings containing @something and www.something.com are being omitted successfully");

        }

        catch (AssertionError | Exception e) {
            e.printStackTrace();
        }

        driver.close();
    }
}