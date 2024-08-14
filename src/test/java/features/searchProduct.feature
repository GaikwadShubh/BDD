Feature:Search and place order for product
  Scenario: search experience for product search in both home and offers page

    Given user is on GreenKart landing page
    When user searched with short name "Tom" and extract  actual name of product
    Then user search for "Tom" in offers page to check product exist with same name
    And validate landing page product name match with offer page product name