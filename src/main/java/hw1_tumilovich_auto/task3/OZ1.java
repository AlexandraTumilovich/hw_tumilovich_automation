package hw1_tumilovich_auto.task3;

/*
Задание 1
1. Открыть oz.by
2. Зайти в корзину
3. Проверить, что она пустая
4. Вернуться назад
5. В поиске ввести "Программирование"
6. Открыть первый результат
7. Добавить его в корзину
8. Зайти в корзину и проверить, что товар добавился.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OZ1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://oz.by");
        driver.findElement(By.xpath("//a[@class=\"top-panel__userbar__cart__item\"]")).click();
        WebElement text1 = driver.findElement(By.xpath("//div[contains(text(), \"корзине пусто.\")]"));
        if (text1.isDisplayed()) {
            System.out.println("Корзина пустая");
        }
        driver.navigate().back();
        WebElement searchField = driver.findElement(By.xpath("//input[@id=\"top-s\"]"));
        searchField.sendKeys("Программирование");
        searchField.submit();
        List<WebElement> results = driver.findElements(By.xpath("//li[@class=\"viewer-type-card__li \"]"));
        results.get(0).click();
        driver.findElement(By.xpath("//button[contains(@class, 'addtocart-btn')]")).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"/checkout/\" and @class=\"top-panel__userbar__cart__item\"]")));
        driver.findElement(By.xpath("//a[@href=\"/checkout/\" and @class=\"top-panel__userbar__cart__item\"]")).click();
        WebElement element2 = driver.findElement(By.xpath("//a[@href=\"https://oz.by/books/more10883310.html\"]"));
        if (element2.isDisplayed()) {
            System.out.println("Книга добавлена в корзину.");
        } else {
            driver.navigate().refresh();
        }
        driver.quit();
    }
}
