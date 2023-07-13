package pageobject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class GoogleSearchResultsPage {
    private final SelenideElement youTubeLink = $(By.xpath("(//a[contains(@href,'https://www.youtube.com/')])[1]"));

    public void clickOnYouTubeLink(){
        youTubeLink.click();
    }
}
