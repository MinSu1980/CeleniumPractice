import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";

    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        SharedDriver.closeDriver();

    }

    @AfterEach
    public void testTeardown() {
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");


    }


    @Test
    public void findElementsByXpathTest() {

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        WebElement createNewAccButton = driver.findElement(By.xpath("//a[@ajaxify = '/reg/spotlight/']"));
        assertNotNull(createNewAccButton);
    }


    @Test
    public void testAccCreationPage() throws InterruptedException {

        WebElement createNewAccButton = driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(2000);


        WebElement createFirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(createFirstName);
        createFirstName.sendKeys("MinSu");


        WebElement createSecondName = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(createSecondName);
        createSecondName.sendKeys("CHO");


        WebElement createEmailAddress = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(createEmailAddress);
        createEmailAddress.sendKeys("qwerty@inbox.ru");

        WebElement createNewPassword = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(createNewPassword);
        createNewPassword.sendKeys("1234656");


        WebElement chooseGenderMale = driver.findElement(By.xpath("//label[@class= '_58mt']"));
        assertNotNull(chooseGenderMale);
        chooseGenderMale.click();

        WebElement createSignUpButton = driver.findElement(By.xpath("//button[@name= 'websubmit']"));
        assertNotNull(createSignUpButton);
        createSignUpButton.click();

    }


    @Test
    public void inputIncorrectData() throws InterruptedException {


        WebElement inputIncorrectEmailAdress = driver.findElement(By.xpath("//input[@type='text']"));
        assertNotNull(inputIncorrectEmailAdress);
        inputIncorrectEmailAdress.sendKeys("eeeepforpgtlg;fg@inbox");

        WebElement inputIncorrectPassword = driver.findElement(By.xpath("//a[@name= pass]"));
        assertNotNull(inputIncorrectPassword);
        inputIncorrectPassword.sendKeys("11234687464ljloiyhklhiukyhlk");


        WebElement logInButton = driver.findElement(By.xpath("//a[@data-testid= royal_login_button]"));
        assertNotNull(logInButton);
        logInButton.click();


    }
}






















































