Feature: Place order for product
  @OfferPage
  Scenario: search experience for product search in both home and offers page

    Given user is on GreenKart landing page
    When user searched with short name "Tom" and extract  actual name of product
    And Added "3" items of the selected product to cart
    Then User proceed to checkout and validate the "Tom" item in the checkout page
    And validate user has ability to enter promo code and place the order