import org.testng.annotations.Test;
import pages.BaseTest;

public class Jenkins01 extends BaseTest {

    @Test
    public void test01() throws InterruptedException {


        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        driver.quit();


    }


}
