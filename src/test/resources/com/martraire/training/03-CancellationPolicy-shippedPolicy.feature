Feature: Shipped Cancellation Policy

  ## Note that this line is a "double-commented" line, it means it won't appear in
  ## the generated pdf
  ## To indicate documentation block just surround them with the "--" line

  --
  In order to enhance further the customer user experience
  As a marketing director
  I want to allow my customer to cancel its order even if it has been shipped.
  But to understand and improve the customer relationship I want to know why
  the customer cancel it, and force him to call the customer assistance first.
  --

  @cancellation-policy
  @feature-shipped-cancellation
  Scenario: A shipped order should be cancellable if the feature is activated and the cancellation number is valid

  --
    **Because** one changed the default runner by a custom one. It is possible to embed within
  the scenario some fancy documentation with basic styling. Styling is based on markdown syntax
  if you need further information.

  Brand new policy whereby you can cancel your order even after your product has been shipped
  but has not yet been delivered. For that particular case you need to call the Customer assistance
  and ask for a cancellation number.
  --

    Given the shipped cancellation policy is activated
    And a shipped order with the cancellation number 1234
    Then the order should be cancellable with the cancellation number 1234


  @cancellation-policy
  @feature-shipped-cancellation
  Scenario: A shipped order should not be cancellable if the feature is activated and the cancellation number is wrong

  --
  Brand new policy whereby you can cancel your order even after your product has been shipped
  but has not yet been delivered. For that particular case you need to call the Customer assistance
  and ask for a cancellation number.
  --


    Given the shipped cancellation policy is activated
    And a shipped order with the cancellation number 1234
    Then the order should not be cancellable with the cancellation number 3456


  @cancellation-policy
  @feature-shipped-cancellation
  Scenario Outline: A shipped order cancellation policy

  --
  This scenario illustrates the usage of `Examples`.
  Each column of the examples table corresponds to a variable which name correspond the
  the first row. The variable can then be used within the scenario by surrounding them
  with `<` and `>`.
  --

    Given the shipped cancellation policy is <activated>
    And a shipped order with the cancellation number <cancellation_number>
    Then the order <is_cancellable> with the cancellation number <user_number>

  Examples: Feature activation with valid and invalid cancellation number
    | activated     | cancellation_number | user_number | is_cancellable            |
    | not activated | 1234                | 3456        | should not be cancellable |
    | not activated | 1234                | 1234        | should not be cancellable |
    | activated     | 1234                | 3456        | should not be cancellable |
    | activated     | 1234                | 1234        | should be cancellable     |
