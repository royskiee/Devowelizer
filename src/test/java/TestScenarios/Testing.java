package TestScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.Commands;
import commons.Commons;

public class Testing {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Chromedriver\\chromedriver.exe");
 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--start-maximized", "--disable-notifications", "--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {
            for (int i = 0; i < Commons.TEST_CASES.length; i++) {
                Commands.runTestCase(driver, i);
            }
        } finally {
            driver.quit();
        }
    }
}