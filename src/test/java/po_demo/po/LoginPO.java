package po_demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

public class LoginPO {

    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }


    public void open(){
        driver.get("http://localhost:7272");
    }

    public void inputUserName(String userName){
        driver.findElement(By.id("username_field")).sendKeys(userName);
    }

    public void inputPassword(String password){
        driver.findElement(By.id("password_field")).sendKeys(password);
    }

    public void submit(){
        driver.findElement(By.id("login_button")).click();
    }

    public void waitUntilTitleOccur(int timeOut){
        new WebDriverWait(driver,timeOut).until(new ExpectedCondition<Boolean>() {
            @Nullable
            public Boolean apply(@Nullable WebDriver webDriver) {
                return webDriver.getTitle().startsWith("Welcome");
            }
        });
    }

    public String  getWelcome(){
        return driver.findElement(By.xpath("//*[@id=\"container\"]/h1")).getText();
    }

}
