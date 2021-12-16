package wether_api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @When("запрос погоды в городе {string}")
    public void getWeatherData(String city) {

    }

    @When("запрос погоды")
    public void getWeatherData() {

    }

    @Then("проверка ответа от weatherstack")
    public void assertWeatherData() {}

}
