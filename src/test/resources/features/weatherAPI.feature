Feature: Weather API tests

  @positive
  Scenario Outline: get correct weather info
    When отправлен запрос погоды в городе <city>
    Then проверка полей <requset.query>, <location.timezone_id>, <location.uts_offset> и current.temperature ответа от weatherstack

    Examples:
    |city      |requset.query                       |location.timezone_id|location.uts_offset|
    |"Vladimir"|"Vladimir, Russia"                  |"Europe/Moscow"      |"3.0"             |
    |"New York"|"New York, United States of America"|"America/New_York"   |"-5.0"            |
    |"Tokyo"   |"Tokyo, Japan"                      |"Asia/Tokyo"         |"9.0"             |
    |"Prague"  |"Prague, Czech Republic"            |"Europe/Prague"      |"1.0"             |

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
