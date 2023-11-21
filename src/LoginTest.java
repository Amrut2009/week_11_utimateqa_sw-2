import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://courses.ultimateqa.com";
    @Before
    public void setup(){
        openbrowser(baseUrl);
    }
@Test
    public void userShouldNavigateToLoginPageSuccessfully(){
     driver.findElement(By.xpath("//a[contains(text(),'Sign In')]" )).click();
    String expextedText="Welcome Back!";
    String actualText= driver.findElement(By.xpath("//h2")).getText();
    Assert.assertEquals("Not redirected to the sign in page",actualText,expextedText);

    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]" )).click();
driver.findElement(By.id("user[email]")).sendKeys("rutvishapatel123@gmail.com");
driver.findElement(By.id("user[password]")).sendKeys("rutu123");
driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
        String expextedText="Invalid username or password";
        String actualText=driver.findElement(By.xpath("//div[@id='notice']")).getText();
Assert.assertEquals("Invalid username or password",expextedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


    }


