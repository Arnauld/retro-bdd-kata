Feature: Cancellation Policy

  In order to enhance my user experience
  As a customer
  I want to be able to cancel my order whenever I can

  @cancellation-policy
  Scenario: A done order should be cancellable

    Given a done order
    Then the order should be cancellable


  @cancellation-policy
  Scenario: A shipped order should not be cancellable

    Given a shipped order
    Then the order should not be cancellable


  @cancellation-policy
  Scenario Outline: Cancellation policy

  --
  This scenario illustrates the usage of `Examples`.
  Each column of the examples table corresponds to a variable which name correspond the
  the first row. The variable can then be used within the scenario by surrounding them
  with `<` and `>`.
  --

    Given a <kind_of> order
    Then the order <is_cancellable> cancellable

  Examples: Feature activation with valid and invalid cancellation number
    | kind_of | is_cancellable |
    | done    | should be      |
    | shipped | should not be  |