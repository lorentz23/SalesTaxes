Feature: Calculate sales taxes

  Scenario: Input 1
    Given 1 book at 12.49 with sales tax EXEMPT
    Given 1 music CD at 14.99 with sales tax BASIC
    Given 1 chocolate bar at 0.85 with sales tax EXEMPT
    Then total price is 29.83 and total sales tax is 1.50
    Given 1 book: 12.49
    Given 1 music CD: 16.49
    Given 1 chocolate bar: 0.85

  Scenario: Input 2
    Given 1 imported box of chocolate at 10.00 with sales tax IMPORTED
    Given 1 imported bottle of perfume at 47.50 with sales tax IMPORTED, BASIC
    Then total price is 65.15 and total sales tax is 7.65
    Given 1 imported box of chocolate: 10.50
    Given 1 imported bottle of perfume: 54.65

  Scenario: Input 3
    Given 1 imported bottle of perfume at 27.99 with sales tax IMPORTED, BASIC
    Given 1 bottle of perfume at 18.99 with sales tax BASIC
    Given 1 packet of headache pills at 9.75 with sales tax EXEMPT
    Given 1 imported box of chocolate at 11.25 with sales tax IMPORTED
    Then total price is 74.68 and total sales tax is 6.70
    Given 1 imported bottle of perfume: 32.19
    Given 1 bottle of perfume : 20.89
    Given 1 packet of headache pills: 9.75
    Given 1 imported box of chocolate: 11.85