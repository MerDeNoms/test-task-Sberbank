package weather_api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import weather_api.pojo.ErrorMessage;
import weather_api.pojo.Response;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitions {

    private ErrorMessage errorMessage;
    private Response response;

    @When("отправлен запрос погоды в городе {string}")
    public void getWeatherData(String city) {
        response = given().
                contentType(ContentType.JSON).
                queryParam("access_key", "92d3a96db4964fc44f2f0166785aa900").queryParam("query", city).
                when().get("http://api.weatherstack.com/current").as(Response.class);
    }

    @When("отправлен неправильный запрос погоды в городе {string}, системой измерения {string}, локализацией {string}")
    public void getWeatherDataWithInvalidRequest(String city, String unitsChar, String lang) {
        errorMessage = given().contentType(ContentType.JSON).
                queryParam("access_key", "92d3a96db4964fc44f2f0166785aa900").
                queryParam("query", city).queryParam("units", unitsChar).queryParam("language", lang).
                when().get("http://api.weatherstack.com/current").as(ErrorMessage.class);
    }

    @Then("проверка полей {string}, {string}, {string} и current.temperature ответа от weatherstack")
    public void assertWeatherData(String query, String timeZone, String utfOffset) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response.getRequest().getQuery()).isEqualTo(query);
        softly.assertThat(response.getLocation().getTimezoneId()).isEqualTo(timeZone);
        softly.assertThat(response.getLocation().getUtcOffset()).isEqualTo(utfOffset);
        softly.assertThat(response.getCurrent().getTemperature().toString()).matches("[-]?[0-9]{1,2}");
        softly.assertAll();
    }

    @Then("пришёл ответ от weatherstack с кодом ошибки {int}")
    public void assertCorrectMistake(int code) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(errorMessage.getError().getCode()).isEqualTo(code);
        softly.assertAll();
    }

}
