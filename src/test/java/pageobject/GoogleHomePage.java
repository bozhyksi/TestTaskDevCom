package pageobject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class GoogleHomePage {
    private final SelenideElement searchField = $(By.name("q"));

    public void search(String textToSearch) {
        searchField.val(textToSearch);
        searchField.pressEnter();
    }
}
