package com.company;


/*
Тестирование translate.google.com

Протестировать:
01. Открыть, нажать "Translate", проверить, что результат пустой.
02. Проверить, что тайтл = Google Translate.
03. Проверить наличие левого и правого полей и кнопки "Translate".
04. Проверить, что в правое поле не добавляется текст.
05. Нажать на стрелочку языков и проверить наличие греческого, мальтийского и словацкого.
06. Ввести слово "Hello" в левое поле, нажать "Translate" и проверить налиие кнопи прослушки.
07. Ввести в адресную строку "https://translate.google.com/#en/ru/hello", проверить, что в левом окне "hello",
   а в правом перевод.
08. Установить слева испанский язык, справа - английский, ввести слева "hello", нажать "<>" и проверить, что справа
   стало "hola"
09. Вводим слева "hello", нажимаем "x" и проверяем, что слева и справа стало пусто.
10. Выбираем слева украинский, справа узбекский, вводим слева "Слава Україні! Героям Слава!" - справа должен быть перевод.
11. Открываем ссылку https://translate.google.com/#uk/jw/Hello проверяем что слева выбран Украинский язык, справа Джаванизский, и что слева и справа "Hello"
12. Открываем сайт, проверяем быстро доступные кнопки языков слева и справа.
13.


Название функций
01 EmptyResult
02 TitleChecker
03
04
05
06
07
08
09
10


 */

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)

public class Main {

// ==================================================== Один раз открыть/закрыть браузер ===============================
/*
    @BeforeClass
    public static void OpenBrrrrr() {
        MyLibrary.OpenBrowser();
        MyLibrary.OpenURL();
    }

    @AfterClass
    public static void CloseBrowser() {
        // MyLibrary.CloseBrowser();
    }
*/
// ==================================================== Каждый раз открывать/закрывать браузер =========================
///*
    @Before
    public void OpenBrowser() {
        MyLibrary.OpenBrowser();
        MyLibrary.OpenURL();
    }

    @After
    public void CloseBrowser() {
        MyLibrary.CloseBrowser();
    }
//*/
// ==================================================== Собственно - тесты =============================================


    @Test
    public void Test01_EmptyResult () {
        Assert.assertTrue("Test with empty right field", MyLibrary.EmptyResult());
    }

    @Test
    public void Test02_TestTitle () {
        Assert.assertEquals("Test with title checking", "Google Translate", MyLibrary.TitleChecker());
    }

    @Test
    public void Test03_Fields () {
        Assert.assertTrue("Left field testing...", MyLibrary.LeftField());
        Assert.assertTrue("Right field testing...", MyLibrary.RightField());
        Assert.assertTrue("Button 'Translate' testing...", MyLibrary.TranslateButton());
    }

    @Test
    public void Test04_RightFieldIsSpan () {
        // Assert.assertTrue("Right field is 'span'-element", MyLibrary.RightFieldIsSpan());
    }

    @Test
    public void Test05_ThreeLanguagesTest () {
        Assert.assertTrue ("Maltian language testing...", MyLibrary.LanguageTesting("Maltese"));
        Assert.assertTrue ("Greek language testing...", MyLibrary.LanguageTesting("GreekZZZ"));
        Assert.assertTrue ("Slovak language testing...", MyLibrary.LanguageTesting("Slovak"));
    }

    @Test
    public void Test06_TextTranslateListen () {
        Assert.assertTrue ("Hello > Translate > Listen' testing...", MyLibrary.TextTranslateListen("Asdddddd"));
    }

    @Test
    public void Test07_UrlLeftTextRightTranslation () {
        Assert.assertTrue("Word in URL > translation...", MyLibrary.UrlLeftTextRightTranslation("en", "de", "hello", "Hallo"));
    }

    @Test
    public void Test08_InputLeftTextRightTranslation () {
        // Установить слева испанский язык, справа - английский, ввести слева "hello", нажать "<>" и проверить, что справа стало "hola"
        Assert.assertTrue("Word in left field > switch languages > translation...", MyLibrary.InputLeftTextRightTranslation("en", "es", "hello", "hola"));
    }

    @Test
    public void Test09_HelloCrossEmpty () {
        // Вводим слева "hello", нажимаем "x" и проверяем, что слева и справа стало пусто.
        Assert.assertTrue("Hello > Cross > Empty...", MyLibrary.HelloCrossEmpty("hello"));
    }

    @Test
    public void Test10_ () {
        //
    }



}
