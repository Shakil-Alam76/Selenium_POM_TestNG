import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Setup {
    public WebDriver driver;
    @BeforeTest
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void logout(){
        driver.close();
    }
}

}
