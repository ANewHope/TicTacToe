import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GameWebTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.is/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTitle() throws Exception {
    driver.get("http://pacific-temple-3094.herokuapp.com/");
    assertEquals("TicTacToe", driver.getTitle());
  }

  @Test
  public void testClear() throws Exception {
    driver.get("http://pacific-temple-3094.herokuapp.com/");
    driver.findElement(By.id("first")).clear();
    driver.findElement(By.id("first")).sendKeys("1");
    driver.findElement(By.id("second")).clear();
    driver.findElement(By.id("second")).sendKeys("1");
    driver.findElement(By.cssSelector("#playerMoveForm > button.btn.btn-default")).click();
    assertEquals(false, isElementPresent(By.id("#22 > img")));
    //assertEquals(true, isElementPresent(By.id("#00 > img")));
    driver.findElement(By.cssSelector("#resetForm > button.btn.btn-default")).click();
    assertEquals("", driver.findElement(By.id("00")).getText());
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

