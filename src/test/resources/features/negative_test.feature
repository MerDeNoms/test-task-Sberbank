Feature: Positive tests

  @negative
  Scenario: get weather info
    When запрос погоды
    Then проверка ответа от weatherstack