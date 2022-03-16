import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class News {

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/Users/soyoon/Downloads/chromedriver";

    public static void main(String[] args) {

        try {
            System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ChromeOptions options = new ChromeOptions();

        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);

        String url = "https://news.naver.com/";

        driver.get(url);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        List<WebElement> el = driver.findElements(By.className("main_content"));

        int count = 0;
        for (int i = 0; i < el.size(); i++) {

            if(el.get(i).getText().equals("해드라인 더보기")) {
                el.get(i).click();
;                break;
            }
            System.out.println(++count + el.get(i).getText());
        }

        try {Thread.sleep(1000);} catch (InterruptedException e) {}

        try {
            if(driver != null) {

                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
