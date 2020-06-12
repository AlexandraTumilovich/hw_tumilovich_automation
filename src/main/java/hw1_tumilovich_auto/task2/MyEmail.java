package hw1_tumilovich_auto.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class MyEmail {
    private static String EMAIL_USERNAME = "test_at_group";
    private static String EMAIL_PASSWORD = "P5RPxyIcop5&";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mailbox:login\"]")));
        driver.findElement(By.xpath("//*[@id=\"mailbox:login\"]")).sendKeys(EMAIL_USERNAME);
        driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mailbox:password\"]")));
        driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]")).sendKeys(EMAIL_PASSWORD);
        driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div/a/span/span")));
        driver.findElement(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div/a/span/span")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"container--H9L5q size_s--3_M-_\" and @type=\"text\" and @style=\"width: 12px;\"]"))); // поле адреса
        driver.findElement(By.xpath("//input[@class=\"container--H9L5q size_s--3_M-_\" and @type=\"text\" and @style=\"width: 12px;\"]")).sendKeys("test_at_group@mail.ru"); // поле адреса
        driver.findElement(By.xpath("//button[@title='Увеличить']")).click();
        String randomLine = generateRandomString();
        driver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys(randomLine); // поле Тема
        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]")).sendKeys(randomLine);
        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]")).click(); // кнопка Отправить
        driver.navigate().refresh();
        driver.switchTo().alert().dismiss();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Входящие')]")));
        driver.findElement(By.xpath("//div[contains(text(), 'Входящие')]")).click();
        WebElement mail1 = driver.findElement(By.xpath("//span[contains(text()," + randomLine + ")]"));
        if (mail1.isDisplayed()) {
            System.out.println("The mail is delivered");
        } else {
            System.out.println("The mail is NOT delivered.");
        }
        driver.quit();
    }

    public static String generateRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
