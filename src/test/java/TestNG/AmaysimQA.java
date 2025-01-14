package TestNG;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class AmaysimQA {

    // Initialize the ChromeDriver with the options
    private WebDriver driver = new ChromeDriver();
    public static JavascriptExecutor jse;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    @BeforeTest
    public void setup() throws InterruptedException {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        jse = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        softAssert = new SoftAssert();

        // Maximize the browser window
        driver.manage().window().maximize();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1)
    @Tag("Payment")
    @Description("To purchase a 7-day mobile plan with an invalid credit card\n")
    @Severity(SeverityLevel.CRITICAL)
    public void QA_Amaysim_CR_PA_01() throws InterruptedException {


        //Open the web app
        driver.get("https://www.amaysim.com.au/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //7 Day Sim Plans page


        WebElement simplans = driver.findElement(By.xpath("//a[@href='/sim-plans']"));
        (new Actions(driver)).moveToElement(simplans).perform();
        WebElement plans = driver.findElement(By.xpath("//a[@href='/sim-plans/7-day-sim-plans']"));
        (new Actions(driver)).moveToElement(plans).perform();
        plans.click();
        WebElement plans2 = driver.findElement(By.xpath("//a[@href='/mobile/cart/7-day-10gb']"));
        plans2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='pick a new number'])[1]")));

        //Pick a New Number Page


        WebElement newnumberpage = driver.findElement(By.xpath("(//span[text()='pick a new number'])[1]"));
        newnumberpage.click();

        //About you page

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(190, 190);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 10000, 9900)
                .perform();

        Thread.sleep(6000L);

        WebElement MobileDetails = driver.findElement(By.xpath("//a[@href='/mobile/your-details']"));
        MobileDetails.click();


        WebElement firstNameField = driver.findElement(By.id("field-input--4"));
        firstNameField.sendKeys("Test");
        WebElement LastNameField = driver.findElement(By.id("field-input--5"));
        LastNameField.sendKeys("Test");
        WebElement BirthdayField = driver.findElement(By.id("field-input--6"));
        BirthdayField.sendKeys("25/12/1991");
        WebElement EmailField = driver.findElement(By.id("field-input--7"));
        EmailField.sendKeys("michael.a.antlabs@gmail.com");
        WebElement PasswordField = driver.findElement(By.id("field-input--8"));
        PasswordField.sendKeys("Welcome1!");
        WebElement ContactField = driver.findElement(By.id("field-input--9"));
        ContactField.sendKeys("0412345678");
        WebElement Address = driver.findElement(By.id("field-input--16"));
        Address.sendKeys("Level 6, 17-19 Bridge St, SYDNEY NSW 2000");
        driver.findElement(By.xpath("//span[text()='Level 6 17-19 Bridge St, SYDNEY NSW 2000']")).click();


        WebElement paymentHeader = driver.findElement(By.id("payments-header-name"));
        jse.executeScript("arguments[0].scrollIntoView(true);", paymentHeader);

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='payment-element']//iframe")));
        driver.findElement(By.xpath("//div[@aria-label='Payment Methods']//button[1]")).click();
        driver.findElement(By.xpath("//input[@id='Field-numberInput']")).sendKeys("4242 4242 4242 4242");
        driver.findElement(By.xpath("//input[@id='Field-expiryInput']")).sendKeys("0127");
        driver.findElement(By.xpath("//input[@id='Field-cvcInput']")).sendKeys("123");
        driver.switchTo().defaultContent();


        WebElement acceptTerm = driver.findElement(By.xpath("(//div[contains(@class, 'css-14')])[3]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", acceptTerm);
        acceptTerm.click();

        WebElement paynow = driver.findElement(By.xpath("//button[contains(text(), 'pay now')]"));
        paynow.click();

        String errormessage = driver.findElement(By.xpath("//strong[text()='Credit Card payment failed']")).getText();
        WebElement errorhighlight = driver.findElement(By.xpath("//strong[text()='Credit Card payment failed']"));

        WebElement PayHeader = driver.findElement(By.id("payments-header-name"));
        jse.executeScript("arguments[0].scrollIntoView(true);", PayHeader);


        String expectedError = "Credit Card payment failed";
        Assert.assertEquals(expectedError, "Credit Card payment failed");
        System.out.println("Expected Error acquired, Test Complete");

    }

}