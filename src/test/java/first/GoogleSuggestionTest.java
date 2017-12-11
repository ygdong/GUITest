package first;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleSuggestionTest {

    @Test
    public void google_search_suggestion() throws Exception {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com/webhp?complete=1&hl=en");

        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");


        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElements(By.className("sbsb_a")).size()>0;
            }
        });

        List<WebElement> allSuggestions = driver.findElements(By.xpath("//div[@class='sbqs_c']"));

        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }



        driver.quit();
    }
}

