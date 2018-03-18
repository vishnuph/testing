


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class auto1 {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.gecko.driver", "C:/eclipse/firefoxdriver/geckodriver.exe");
            driver = new FirefoxDriver();
            baseUrl = "https://www.flipkart.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testJava() throws Exception {
            driver.get(baseUrl + "/");
            driver.findElement(By.cssSelector("svg._1LYY3m")).click();
            driver.findElement(By.cssSelector("a._2etDcX._2487fi")).click();
            driver.findElement(By.cssSelector("a._2etDcX._2487fi")).click();
            driver.findElement(By.linkText("CART0")).click();
            driver.findElement(By.cssSelector("img[alt=\"Flipkart\"]")).click();
            driver.findElement(By.linkText("Payments")).click();
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }

