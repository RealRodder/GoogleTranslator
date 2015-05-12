package com.company;


/*
������������ translate.google.com

��������������:
01. �������, ������ "Translate", ���������, ��� ��������� ������.
02. ���������, ��� ����� = Google Translate.
03. ��������� ������� ������ � ������� ����� � ������ "Translate".
04. ���������, ��� � ������ ���� �� ����������� �����.
05. ������ �� ��������� ������ � ��������� ������� ����������, ������������ � ����������.
06. ������ ����� "Hello" � ����� ����, ������ "Translate" � ��������� ������ ����� ���������.
07. ������ � �������� ������ "https://translate.google.com/#en/ru/hello", ���������, ��� � ����� ���� "hello",
   � � ������ �������.
08. ���������� ����� ��������� ����, ������ - ����������, ������ ����� "hello", ������ "<>" � ���������, ��� ������
   ����� "hola"
09. ������ ����� "hello", �������� "x" � ���������, ��� ����� � ������ ����� �����.
10. �������� ����� ����������, ������ ���������, ������ ����� "����� �����! ������ �����!" - ������ ������ ���� �������.
11. ��������� ������ https://translate.google.com/#uk/jw/Hello ��������� ��� ����� ������ ���������� ����, ������ ������������, � ��� ����� � ������ "Hello"
12. ��������� ����, ��������� ������ ��������� ������ ������ ����� � ������.
13.


�������� �������
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

// ==================================================== ���� ��� �������/������� ������� ===============================
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
// ==================================================== ������ ��� ���������/��������� ������� =========================
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
// ==================================================== ���������� - ����� =============================================


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
        // ���������� ����� ��������� ����, ������ - ����������, ������ ����� "hello", ������ "<>" � ���������, ��� ������ ����� "hola"
        Assert.assertTrue("Word in left field > switch languages > translation...", MyLibrary.InputLeftTextRightTranslation("en", "es", "hello", "hola"));
    }

    @Test
    public void Test09_HelloCrossEmpty () {
        // ������ ����� "hello", �������� "x" � ���������, ��� ����� � ������ ����� �����.
        Assert.assertTrue("Hello > Cross > Empty...", MyLibrary.HelloCrossEmpty("hello"));
    }

    @Test
    public void Test10_ () {
        //
    }



}
