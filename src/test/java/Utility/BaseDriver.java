package Utility;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class BaseDriver {

    public WebDriver driver;

    @BeforeTest
    public void BaseDriverTest() {

// declaration and instantiation of objects/variables
// System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
////    WebDriver driver=new ChromeDriver();

// Initialize the WebDriver with the existing Chrome instance

        ChromeOptions options = new ChromeOptions();

// Specify the debugging address for the already opened Chrome browser

        options.setExperimentalOption("debuggerAddress", "localhost:2524");
        this.driver = new ChromeDriver(options);

    }
//    @AfterTest
//    public void testImageDiff() throws IOException {
//            // ...
//
//            // Read the three files as bytes
//            byte[] expected = Files.readAllBytes(Paths.get("expected.png"));
//            byte[] actual = Files.readAllBytes(Paths.get("actual.png"));
//            byte[] diff = Files.readAllBytes(Paths.get("diff.png"));
//
//            // Encode the data, wrap into a JSON, encode as bytes
//            String content = new JSONObject()
//                    .put("expected", "data:image/png;base64,"
//                            + Base64.getEncoder().encodeToString(expected))
//                    .put("actual", "data:image/png;base64,"
//                            + Base64.getEncoder().encodeToString(actual))
//                    .put("diff", "data:image/png;base64,"
//                            + Base64.getEncoder().encodeToString(diff))
//                    .toString();
//
//            // Attach to the test report
//            Allure.addAttachment("Screenshot diff",
//                    "application/vnd.allure.image.diff",
//                    content);
//        }

}
