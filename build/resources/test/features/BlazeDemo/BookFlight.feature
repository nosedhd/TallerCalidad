#Author: Luis Cruz
  # language: en


@blaze_demo
  Feature: Book Flight
    I as a user who has selected a flight
    I want to enter my personal information
    To complete the purchase process

    Scenario Outline: Make a reservation with different information
      Given User opens the booking page
      When searches for flights from "<origin>" to "<destination>"
      And selects the flight with the "<price_criteria>" price
      And Complete the reservation form with:
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
      Then should see the message "<result>" of confirmation purchase



      @OriginDestination
      Examples: Different origins and destinations
        | origin       | destination   | price_criteria |
        | Paris        | Buenos Aires  | lowest         |
        | Paris        | Buenos Aires  | highest        |
        | Philadelphia | Rome          | lowest         |
        | Boston       | London        | highest        |
        | Mexico City  | Berlin        | lowest         |
        | SÒo Paolo    | Dublin        | highest        |

      @valid_data
      Examples: Valid Purchase Data
        | name           | address            | city          | state   | zip     | cardType        | card             | month | year | nameOnCard      | result                      |
        | John Doe       | 123 Main St        | Boston        | MA      | 02101   | Visa            | 4111111111111111 | 12    | 2025 | JOHN DOE        | Thank you for your purchase |
        | Jane Smith     | 456 Oak Ave        | London        | N/A     | SW1A 1AA| MasterCard      | 5500000000000004 | 08    | 2026 | JANE SMITH      | Thank you for your purchase |
        | Carlos López   | Calle 45 #12-30    | Bogotá        | DC      | 110111  | Visa            | 4111111111111111 | 03    | 2027 | CARLOS LOPEZ    | Thank you for your purchase |
        | Maria Garcia   | Av Libertador 1234 | Caracas       | DF      | 1010    | American Express| 378282246310005  | 11    | 2025 | MARIA GARCIA    | Thank you for your purchase |
        | Robert Brown   | 789 Pine Street    | New York      | NY      | 10001   | Discover        | 6011111111111117 | 05    | 2026 | ROBERT BROWN    | Thank you for your purchase |

      @invalid_data
      Examples: Invalid Purchase Data
        | name       | address      | city    | state | zip   | cardType | card             | month | year | nameOnCard | result              |
        |            | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   |              | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  |         | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  |       | 02101 | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  | MA    |       | Visa     | 4111111111111111 | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 |          | 4111111111111111 | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     |                  | 12    | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 |       | 2025 | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    |      | JOHN DOE   | Please fill all required fields |
        | John Doe   | 123 Main St  | Boston  | MA    | 02101 | Visa     | 4111111111111111 | 12    | 2025 |            | Please fill all required fields |