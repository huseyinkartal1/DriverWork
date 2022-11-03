package temp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MenuHover {

    @Test
    public void test1(){
        open("https://www.htmlelements.com/demos/menu/basic/");
        switchTo().frame(0);

        for (SelenideElement element : $$(By.cssSelector("#menuMainContainer>smart-menu-items-group"))) {
            element.hover();
            sleep(300);
        }


    }

}
