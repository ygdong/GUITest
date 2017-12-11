package po_demo;

import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import po_demo.po.LoginPO;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private FirefoxDriver driver;
    private LoginPO loginPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        loginPage = new LoginPO(driver);
    }

    @Test
    public void valid_login() throws Exception {
        loginPage.open();

        loginPage.inputUserName("demo");
        loginPage.inputPassword("mode");

        loginPage.submit();

        loginPage.waitUntilTitleOccur(5);

        assertEquals("Welcome Page", loginPage.getWelcome());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
