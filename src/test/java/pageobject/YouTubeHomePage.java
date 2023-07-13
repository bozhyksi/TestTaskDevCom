package pageobject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class YouTubeHomePage {
    private final SelenideElement searchInput = $(By.xpath("//input[@id='search']"));
}
