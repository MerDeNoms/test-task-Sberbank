Feature: Weather API tests

  @positive
  Scenario: get correct weather info
    When отправлен запрос погоды в городе "Vladimir"
    Then проверка ответа от weatherstack

  @negative
  Scenario Outline: get incorrect weather info
    When отправлен неправильный запрос погоды в городе <city>, системой измерения <units>, локализацией <lang>
    Then пришёл ответ от weatherstack с кодом ошибки <code>

    Examples:
    |code|city      |units|lang|
    |615 |"123456"  |""   |""  |
    |601 |""        |"m"  |""  |
    |606 |"Vladimir"|"q"  |""  |
    |105 |"Vladimir"|""   |"ru"|