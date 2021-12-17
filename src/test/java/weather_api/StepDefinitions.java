package weather_api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import weather_api.pojo.ErrorMessage;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitions {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private ErrorMessage errorMessage;

    @When("отправлен запрос погоды в городе {string}")
    public void getWeatherData(String city) {
        given().
                contentType(ContentType.JSON).
                queryParam("access_key", "92d3a96db4964fc44f2f0166785aa900").queryParam("query", city).
        when().get("http://api.weatherstack.com/current");

    }

    @When("отправлен неправильный запрос погоды в городе {string}, системой измерения {string}, локализацией {string}")
    public void getWeatherDataWithInvalidRequest(String city, String unitsChar, String lang) {
        errorMessage = given().contentType(ContentType.JSON).
                queryParam("access_key", "92d3a96db4964fc44f2f0166785aa900").
                queryParam("query", city).queryParam("units", unitsChar).queryParam("language", lang).
                when().get("http://api.weatherstack.com/current").as(ErrorMessage.class);
    }

    @Then("проверка ответа от weatherstack")
    public void assertWeatherData() {

    }

    @Then("пришёл ответ от weatherstack с кодом ошибки {int}")
    public void assertCorrectMistake(int code) {
        assertThat(errorMessage.getError().getCode()).isEqualTo(code);
    }

}
