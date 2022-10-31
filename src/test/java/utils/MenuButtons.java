package utils;

import org.openqa.selenium.By;

public enum MenuButtons {
    CUSTOMERS(By.xpath("//header//a[./span[text()='Customers']]")),
    ;
    private By locator;

    MenuButtons(By locator) {
        this.locator = locator;
    }


}
