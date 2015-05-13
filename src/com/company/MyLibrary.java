package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Vitaly on 29.04.2015.
 */
public class MyLibrary {

    public static WebDriver Browser;
    public static WebElement Element;

// ==================================================== Внутренний набор функций========================================

    public static boolean WaitForElement (int WaitTime, String WFEString) {
        // WaitTime - in seconds
        // WFEString - xPath of element
        boolean TmpBoolean = false;
        for (int timerz= 0; timerz < WaitTime*1000; ) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException a) {
                a.printStackTrace();
            }
            try {
                if (Browser.findElement(By.xpath(WFEString)).isDisplayed()) {
                    TmpBoolean = true;
                    break;
                }
            } catch (Exception e) {}
            timerz = timerz + 100;
        }
        return TmpBoolean;
    }

// ==================================================== Собственно - для тестов ========================================

    public static void OpenBrowser() {
        // Browser running (for starting from IDEA)
        // System.setProperty("webdriver.chrome.driver", "C:/Automation/WebDrivers/chromedriver.exe");
        // Browser running (for starting from drone.io)
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // Работаем  опциями Хрома
        ChromeOptions Options = new ChromeOptions();
        // Запускаем Хром на английском языке
        Options.addArguments("--lang=en");
        Browser = new ChromeDriver(Options);
        // Browser = new FirefoxDriver();
    }

    public static void CloseBrowser () {
        Browser.close();
    }

    public static void OpenURL() {
        // URL Opening
        Browser.get("https://translate.google.com/");
    }

    public static boolean EmptyResult() {
        boolean TmpBoolean = false;
        // 01. Открыть, нажать "Translate"...
        Browser.findElement(By.xpath("//*[@id=\"gt-submit\"]")).click();
        // Waiting for translation
        WaitForElement (10, "//*[@id=\"result_box\"]");
        // ...проверить, что результат пустой.
        if (Browser.findElement(By.xpath("//*[@id=\"result_box\"]")).getText().length() == 0) {
            TmpBoolean = true;
        }
        return TmpBoolean;
    }

    public static String TitleChecker () {
        return Browser.getTitle();
    }

    public static boolean LeftField() {
        boolean TmpBoolean = false;
        if (Browser.findElement(By.xpath("//*[@id=\"source\"]")).isDisplayed()) {TmpBoolean = true;}
        return TmpBoolean;
    }

    public static boolean RightField() {
        boolean TmpBoolean = false;
        if (Browser.findElement(By.xpath("//*[@id=\"result_box\"]")).isDisplayed()) {TmpBoolean = true;}
        return TmpBoolean;
    }

    public static boolean TranslateButton() {
        boolean TmpBoolean = false;
        if (Browser.findElement(By.xpath("//*[@id=\"gt-submit\"]")).isDisplayed()) {TmpBoolean = true;}
        return TmpBoolean;
    }

    public static boolean RightFieldIsSpan () {
        boolean TmpBoolean = false;
        // Element = Browser.findElement(By.tagName("span"));
        // if (Element.getAttribute("id").equals("result_box")) {TmpBoolean = true;}
        Element = Browser.findElement(By.xpath("//*[@id='result_box']"));
        /// if (Element.getAttribute("tagname").equals("span")) {TmpBoolean = true;}
        return TmpBoolean;
    }

    public static boolean LanguageTesting (String LTString) {
        boolean TmpBoolean = false;
        // Жмём кнопку первый раз - "нажимаем"
        Browser.findElement(By.xpath("//*[@id=\"gt-sl-gms\"]")).click();
        if (Browser.findElement(By.id("gt-sl-gms-menu")).getText().contains(LTString)) {
            TmpBoolean = true;
        }
        // Жмём кнопку второй раз - "отпускаем"
        Browser.findElement(By.xpath("//*[@id=\"gt-sl-gms\"]")).click();
        return TmpBoolean;
    }

    public static boolean TextTranslateListen (String TTLString) {
        boolean TmpBoolean = false;
        // Hello
        Browser.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys(TTLString);
        // Translate
        Browser.findElement(By.xpath("//*[@id=\"gt-submit\"]")).click();
        // Waiting for translation appearing
        if (WaitForElement(10, "//*[@id=\"gt-res-listen\"]/span")) {
            TmpBoolean = true;
        }
        return TmpBoolean;
    }

    public static boolean UrlLeftTextRightTranslation (String LngFrom, String LngTo, String WordIn, String WordOut) {
        boolean TmpBoolean = false;
        // Combined URL - url + languages settings + word
        Browser.get("https://translate.google.com/"+"#"+LngFrom+"/"+LngTo+"/"+WordIn);
        // WAiting for translation
        WaitForElement (10, "//*[@id=\"result_box\"]/span");
        if (Browser.findElement(By.xpath("//*[@id=\"result_box\"]/span")).getText().contains(WordOut)) {
            TmpBoolean = true;
        }
        return TmpBoolean;
    }

    public static boolean InputLeftTextRightTranslation (String LngFrom, String LngTo, String WordIn, String WordOut) {
        boolean TmpBoolean = false;
        // Switching languages
        Browser.get("https://translate.google.com/" + "#" + LngTo + "/" + LngFrom + "/");
        // Input word in left field
        Browser.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys(WordIn);
        // Pressing button "switch languages"
        Browser.findElement(By.xpath("//*[@id=\"gt-swap\"]/span")).click();
        // Waiting for for translation appearing
        WaitForElement (10, "//*[@id=\"result_box\"]/span");
        if (Browser.findElement(By.xpath("//*[@id=\"result_box\"]/span")).getText().contains(WordOut)) {
            TmpBoolean = true;
        }
        return TmpBoolean;
    }

    public static boolean HelloCrossEmpty (String WordIn) {
        // Вводим слева "hello", нажимаем "x" и проверяем, что слева и справа стало пусто.
        boolean TmpBoolean = false;
        // Input word in left field
        Browser.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys(WordIn);
        // Pressing cross button (empty)
        Browser.findElement(By.xpath("//*[@id=\"gt-clear\"]/span")).click();
        // Waiting for for translation appearing
        WaitForElement(10, "//*[@id=\"result_box\"]");
        // ...проверить, что результат пустой.
        if (Browser.findElement(By.xpath("//*[@id=\"result_box\"]")).getText().length() == 0) {
            TmpBoolean = true;
        }
        return TmpBoolean;
    }

    public static boolean Dork03 (String TTLString) {
        boolean TmpBoolean = false;
        return TmpBoolean;
    }



}
