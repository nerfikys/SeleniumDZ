package DZ1;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

    @Test
    public void test() {
        System.setProperties("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sberbank.ru/ru/person");
    }
}
