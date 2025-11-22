#Author: Luis Cruz
  # language: en


@blaze_demo
  Feature: Book Flight
    I as a user who has selected a flight
    I want to enter my personal information
    To complete the purchase process
    Background:
      Given User opens the booking page
      When searches for flights from "Paris" to "Buenos Aires"
      And selects the flight with the "lowest" price

    @booking @outline @valid_data
    Scenario Outline: Complete purchase with valid data
      When Complete the reservation form with:
        | Field          | Value            |
        | Name           | <name>           |
        | Address        | <address>        |
        | City           | <city>           |
        | State          | <state>          |
        | Zip Code       | <zip>            |
        | Card Type      | <cardType>       |
        | Card Number    | <card>           |
        | Month          | <month>          |
        | Year           | <year>           |
        | Name on card   | <nameOnCard>     |
      And clicks on Purchase Flight
      Then should see the message "Thank you for your purchase today!" of confirmation purchase

      Examples: Valid Purchase Data
        | name           | address            | city          | state   | zip     | cardType        | card             | month | year | nameOnCard      |
        | John Doe       | 123 Main St        | Boston        | MA      | 02101   | Visa            | 4111111111111111 | 12    | 2025 | JOHN DOE        |
        | Jane Smith     | 456 Oak Ave        | London        | N/A     | SW1A 1AA| Diner's Club    | 5500000000000004 | 08    | 2026 | JANE SMITH      |
        | Carlos Lopez   | Calle 45 #12-30    | Bogota        | DC      | 110111  | Visa            | 4111111111111111 | 03    | 2027 | CARLOS LOPEZ    |
        | Maria Garcia   | Av Libertador 1234 | Caracas       | DF      | 1010    | American Express| 378282246310005  | 11    | 2025 | MARIA GARCIA    |
        | Robert Brown   | 789 Pine Street    | New York      | NY      | 10001   | Visa            | 6011111111111117 | 05    | 2026 | ROBERT BROWN    |


    @booking @outline @invalid_data
    Scenario Outline: Validate required fields in purchase form
      When Complete the reservation form with:
        | Field          | Value            |
        | Name           | <name>           |
        | Address        | <address>        |
        | City           | <city>           |
        | State          | <state>          |
        | Zip Code       | <zip>            |
        | Card Type      | <cardType>       |
        | Card Number    | <card>           |
        | Month          | <month>          |
        | Year           | <year>           |
        | Name on card   | <nameOnCard>     |
      And clicks on Purchase Flight
      Then should see the message "Please fill all required fields" of confirmation purchase
      Examples: Invalid Purchase Data
        | name       | address      | city    | state | zip   | cardType | card             | month | year | nameOnCard |
        |            | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   |
        | John Doe   |              | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  |         | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  |       | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  | MA    |       | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 |          | 4111111111111111 | 12    | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     |                  | 12    | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 |       | 2025 | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    |      | JOHN DOE   |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 |            |