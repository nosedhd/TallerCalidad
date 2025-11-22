#Author: Luis Cruz
  # language: en


@blaze_demo
Feature: Flight Selection by Price Criteria
  As a traveler
  I want to select flights based on different price criteria
  So that I can find the best option for my budget

  @flight_selection @price_criteria
  Scenario Outline: Select flight by price criteria
    Given User opens the booking page
    When searches for flights from "<origin>" to "<destination>"
    And selects the flight with the "<price_criteria>" price
    Then should see the details of the selected flight

    Examples: Different origins, destinations and price criteria
      | origin       | destination   | price_criteria |
      | Paris        | Buenos Aires  | lowest         |
      | Paris        | Buenos Aires  | highest        |
      | Philadelphia | Rome          | lowest         |
      | Boston       | London        | highest        |
      | Mexico City  | Berlin        | lowest         |
      | Sao Paolo    | Dublin        | highest        |
