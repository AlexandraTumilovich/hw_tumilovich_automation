package hw1_tumilovich_auto.task3;
/*
Задание 2
1. Открыть oz.by
2. Проверить, что слева отображаются все фильтры (Продукты и деликатесы … Здоровье, медтехника).
3. Для хранения имен фильтров завести коллекцию (expectedResults)
4. Названия фильтров собрать в коллекцию (actualResults)
5. Сравнить две коллекции.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OZ2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://oz.by");
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("Продукты, деликатесы");
        expectedResults.add("Книги");
        expectedResults.add("Косметика, парфюмерия");
        expectedResults.add("Дом, сад, зоотовары");
        expectedResults.add("Развлечения, творчество");
        expectedResults.add("Канцтовары, учёба");
        expectedResults.add("Сувениры, подарки");
        expectedResults.add("Детям и мамам");
        expectedResults.add("Туризм, отдых, спорт");
        expectedResults.add("Техника, электроника");
        expectedResults.add("Здоровье, медтехника");
        ArrayList<String> actualResults = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class=\"menu-link-action main-nav__list__item \"]"));
        for (int i = 0; i < elements.size(); i++) {
            actualResults.add(elements.get(i).getText());
        }
        if (expectedResults.containsAll(actualResults) && expectedResults.size() == actualResults.size()) {
            System.out.println("All filters are shown");
        } else {
            System.out.println("Some filters are NOT shown");
        }
        driver.quit();
    }
}
