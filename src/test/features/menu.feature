Feature: Menu selection

  @menu
  Scenario Outline: Hoover over menu option
    Given I am on the home page "https://www.next.co.uk/"
    When I hoover on the menu option "<Menu>>"
    And I click the women link "<Menu>"
    Then I should navigate to the women screen "<PageTitle>"

    Examples:

      | Menu  | PageTitle        |
      | WOMEN | Women's Clothing |
      | MEN   | Mens Clothing    |
      | BABY  | Baby Clothes     |