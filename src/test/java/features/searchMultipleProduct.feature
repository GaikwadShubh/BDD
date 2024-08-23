Feature: search multiple product
  @Multiple
  Scenario Outline: search experience for product search in both home and offers page

    Given user is on GreenKart landing page for multiple product
    When user searched with short name <product> and extract  actual name of product in multiple search
    Then user search for <product> in offers page to check product exist with same name in multiple search
    And validate landing page product name match with offer page product name for multiple product
    Examples:
      |product|
      |Pot    |
      |stra   |
