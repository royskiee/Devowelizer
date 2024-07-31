package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commands {

    private static final int MAX_RETRIES = 3;
    private static final int SLEEP_BEFORE_RETRY = 4000; 
    private static final int PAGE_LOAD_DELAY = 5000; 

    public static void runTestCase(WebDriver driver, int index) {
        String input = Commons.TEST_CASES[index];
        String expected = Commons.EXPECTED_RESULTS[index];
        boolean testPassed = false;
        int attempt = 0;

        System.out.println("Running Test Case " + (index + 1) + ": \"" + input + "\"");

        while (attempt < MAX_RETRIES && !testPassed) {
            String responseText = fetchResponse(driver, input);

            if ("Internal Server Error".equals(responseText)) {
                attempt++;
                System.out.println("Attempt " + attempt + " of " + MAX_RETRIES + ": Internal Server Error encountered for Test Case " + (index + 1) + ".");

                if (attempt < MAX_RETRIES) {
                    sleep(SLEEP_BEFORE_RETRY);
                } else {
                    System.out.println("Test Case " + (index + 1) + " failed after " + MAX_RETRIES + " attempts due to Internal Server Error.");
                }
            } else {
                if (expected.equals(responseText)) {
                    System.out.println("Test Case " + (index + 1) + " passed.");
                    testPassed = true;
                } else {
                    System.out.println("Test Case " + (index + 1) + " failed. Expected: \"" + expected + "\" but got: \"" + responseText + "\"");
                    testPassed = true; 
                }
            }
        }

        if (!testPassed && attempt == MAX_RETRIES) {
            System.out.println("Test Case " + (index + 1) + " failed after " + MAX_RETRIES + " attempts.");
        }
    }

    private static String fetchResponse(WebDriver driver, String input) {
        try {
            driver.get("http://localhost:8080/" + input);
            sleep(PAGE_LOAD_DELAY);

            WebElement body = driver.findElement(By.tagName("body"));
            String text = body.getText();

            return text.contains("Internal Server Error") ? "Internal Server Error" : text;
        } catch (Exception e) {
            return "Internal Server Error"; 
        }
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
