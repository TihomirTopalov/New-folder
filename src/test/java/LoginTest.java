import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @Test
    public void loginTest() {
        WebElement usernameInputName = driver.findElement(By.id("input-username"));
        usernameInputName.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("parola123!");
        driver.findElement(By.cssSelector(".btn-primary")).click();

        WebElement logout = driver.findElement(By.cssSelector("ul.navbar-nav li span"));

        assertEquals(logout.getText(), "Logout");
    }

    @AfterMethod
    public void tearDown()
    { driver.quit();

    }

}
