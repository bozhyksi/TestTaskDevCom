package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.GoogleHomePage;
import pageobject.GoogleSearchResultsPage;
import pageobject.YouTubeHomePage;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {
    private final GoogleHomePage googleHomePage = new GoogleHomePage();
    private final GoogleSearchResultsPage searchResultsPage = new GoogleSearchResultsPage();
    private final YouTubeHomePage youTubeHomePage = new YouTubeHomePage();

    @Given("I am on the Google homepage")
    public void iAmOnTheGoogleHomepage() {
        open(Configuration.baseUrl);
    }

    @When("I search for {string}")
    public void iSearchFor(String searchText) {
        googleHomePage.search(searchText);
    }

    @And("I click on the YouTube link")
    public void iClickOnTheYouTubeLink() {
        searchResultsPage.clickOnYouTubeLink();
    }

    @Then("I should be redirected to the YouTube page")
    public void iShouldBeRedirectedToTheYouTubePage() {
        youTubeHomePage.getSearchInput().shouldBe(Condition.visible);
    }
}
