package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LocatorInterface;
import utils.Driver;
import utils.Waits;

import java.sql.*;

public class ScrollToMail extends BaseTest implements LocatorInterface {

    WebDriver driver;
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    String email;

    @BeforeTest
    public void beforeTest() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://142.93.110.12:3306/admindashboarddb",
                "gsuser",
                "Gsuser!123456");
        statement = conn.createStatement();
        resultSet = statement.executeQuery("SELECT email FROM customers WHERE id=1341;");
        email = resultSet.getString(1);
        conn.close();
        statement.close();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void login(){
        driver.get(url);
        sendKeys(usernameInputLogin, "demo");
        sendKeys(passwordInputLogin, "demo");
        click(buttonSubmitLogin);
        waitForElement(buttonLogout, Waits.VISIBILITY);
    }

    @Test
    public void test2() {
        click(By.xpath("//header//a[./span[text()='Customers']]"));
        waitForElement(By.cssSelector("datatable-header"), Waits.VISIBILITY);
        while (true){
            scrollBy(100);
            By emailLocator = By.xpath("//span[text()='" + email+ "']");
            if (driver.findElements(emailLocator).get(0).isDisplayed())
                break;
        }
    }

    public void scrollBy(int val){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + val +")");
    }
}
