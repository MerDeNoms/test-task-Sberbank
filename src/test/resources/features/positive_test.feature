Feature: Positive tests

  @positive
  Scenario: get weather info
    When запрос погоды в городе "Владимр"
    Then проверка ответа от weatherstack