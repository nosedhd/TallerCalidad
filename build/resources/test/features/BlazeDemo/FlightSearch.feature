#Author: Luis Cruz
  # language: en


@blaze_demo
  Feature: Flight Search
    I as user of the flight search web
    I want to find flights between two cities
    To be able to see available options

  @search @smoke
  Scenario Outline: Search for flights from "<origin>" to "<destination>"
    Given User opens the booking page
    When searches for flights from "<origin>" to "<destination>"
    Then should see a list of available flights from "<origin>" to "<destination>"

    Examples: Different origins and destinations
      | origin       | destination   |
      | Paris        | Buenos Aires  |
      | Philadelphia | Rome          |
      | Boston       | London        |
      | Portland     | Berlin        |
      | San Diego    | New York      |
      | Mexico City  | Dublin        |