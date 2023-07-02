package wtf.popov;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Map;

public class SeleniumLambdaHandler implements RequestHandler<Map<String, Object>, String> {

    @Override
    public String handleRequest(Map<String, Object> stringObjectMap, Context context) {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(new File("/opt/chrome/chrome"));
        options.addArguments(
                "--headless",
                "--no-sandbox",
                "--disable-gpu",
                "--window-size=1280x1024",
                "--single-process",
                "--disable-dev-shm-usage",
                "--disable-dev-tools",
                "--no-zygote",
                "--remote-debugging-port=9222"
        );

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/opt/chromedriver"))
                .withSilent(false)
                .build();

        WebDriver driver = new ChromeDriver(service, options);

        driver.get("https://example.com/");

        return driver.findElement(By.xpath("//html")).getText();
    }

}
