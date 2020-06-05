package hw1_tumilovich_auto.task3;
/*
Задание 3
1. Открыть oz.by
2. В правом верхнем углу нажать на кнопку "Оплата"
3. Переключиться на открывшееся окно оплаты
4. Нажать на кнопку "закрыть это окно".
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class OZ3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://oz.by");
        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"top-page\"]/div[1]/div[2]/ul/li[3]/a")).click();
        String childHandle = "";
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                childHandle = handle;
            }
        }
        driver.switchTo().window(childHandle);
        driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]"));
        driver.quit();
    }
}
