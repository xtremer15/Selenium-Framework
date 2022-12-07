package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Main {


    static String[] rowOptiosn = {"A", "B"};
    static List<String> testKeys = new ArrayList<>();
    static List<String> testValues = new ArrayList<>();
    private static String URL = "https://datatables.net/extensions/select/examples/initialisation/multi.html";
    private static String anotherURL = "https://cosmocode.io/automation-practice-webtable/";
    private static String thead = "#example > thead";
    private static String tbody = "#example > tbody";
    private static String theadRows = thead + " th";
    private static String tbodyRowsData = tbody + " tr td";

    public static void main(String[] args) {
        ChromeDriver chromeDriver = getChromeDriver();

        WebElement tableBody = chromeDriver.findElement(By.cssSelector(tbody));
        WebElement tableHead = chromeDriver.findElement(By.cssSelector(thead));
        List<WebElement> tableHeadRows = chromeDriver.findElements(By.cssSelector(theadRows));
        List<WebElement> tableBodyRowsData = chromeDriver.findElements(By.cssSelector(tbodyRowsData));
        List<String> headerValuesAsText = new ArrayList<>();
//        List<String> bodyRowsTxt = new ArrayList<>();
        tableHeadRows.forEach(ele -> headerValuesAsText.add(ele.getText()));
//        tableBodyRowsData.forEach(ele -> bodyRowsTxt.add(ele.getText()));
//        traversRowElements(tableBodyRowsData, tableHeadRows, "Office", "London", "Tokyo");


        selectElementsUsingHashMap(headerValuesAsText, tableBodyRowsData, "Age", "46", "28","61");

    }


//SOLUTION USING HASHMAP
    private static void selectElementsUsingHashMap(List<String> headerValues, List<WebElement> bodyRowsData, String theadRowToSelect, String... elementsToSelect) {

        HashMap<List<String>, List<WebElement>> tableData = new HashMap<>();
        tableData.put(headerValues, bodyRowsData);

        for (List<String> key : tableData.keySet()) {
            if (key.contains(theadRowToSelect)) {
                tableData.values().forEach(webElements -> {
                    webElements.forEach(element -> {
                        validateOptionsToSelect(element, elementsToSelect);
                    });
                });
            }
        }
    }

    private static void validateOptionsToSelect(WebElement element, String... elementsToSelect) {
        for (String ele : elementsToSelect) {
            if (element.getText().contains(ele)) {
                element.click();
            }
        }
    }

    private static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(URL);
        return chromeDriver;
    }

//    SOLUTION USING 2 LISTS
    private static void traversRowElements(List<WebElement> bodyElementsToCheck, List<WebElement> headerOptions, String headerOption, String... bodyOptions) {
        headerOptions.forEach(option -> {
            if (option.getText().equals(headerOption)) {
                bodyElementsToCheck.forEach(bodyData -> {
                    for (String bodyOption : bodyOptions) {
                        validateElemenet(bodyData, bodyOption);

                    }
                });
            }
        });

    }

    private static void validateElemenet(WebElement bodyData, String bodyOption) {
        if (bodyData.getText().equals(bodyOption)) {
            System.out.println("Clicked On " + bodyData.getText());
            bodyData.click();
        }
    }
}
