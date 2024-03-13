package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class SG_AutomationHandler {

    public void processWebAutomation(String[] credentials) {
        WebDriver driver = null;

        if (credentials != null && credentials.length == 2) {
            String id = credentials[0];
            String password = credentials[1];
            System.out.println("ID: " + id);
            System.out.println("Password: " + password);
        } else {
            System.out.println("User canceled the input or an error occurred.");
            return;
        }

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\atath\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            // 웹 페이지 열기
            driver.get("http://sgelectservice.com/");

            WebDriverWait wait = new WebDriverWait(driver, 20);

            // 웹 페이지에서 필요한 작업 수행
            // id 입력창에 값 입력
            WebElement idInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
            idInput.sendKeys(credentials[0]);

            // password 입력창에 값 입력
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userpassword")));
            passwordInput.sendKeys(credentials[1]);

            // 로그인 버튼 클릭
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_submit")));
            loginButton.click();

            // 대기 후 접속하기 버튼 클릭
            WebElement connectButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_submit")));
            connectButton.click();

            // 버튼이 클릭 가능한 상태가 되면 클릭
            WebElement receiveLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("접수시스템")));
            receiveLink.click();

            // 다른 작업 수행...

            // 대기 후 프로그램 종료 방지
            Thread.sleep(300000); // 5분 동안 대기 (종료 방지 목적)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
