Feature: Default behavior

  In order to simplify the writing of the feature
  As a scenario writer
  I want to rely on well defined, known and verified default values
  so that I don't have to over-describe the expected behavior

  Scenario: Shipped cancellation policy feature activation

    Given the standard settings
    Then the shipped cancellation policy should not be activated


