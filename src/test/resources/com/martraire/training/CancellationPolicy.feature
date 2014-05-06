Feature: Cancellation Policy

In order to 
As a 
I want


Scenario: Check if done order is cancellable

Given a done order
Then the order should be cancellable


Scenario: Check if shipped order is not cancellable

Given a shipped order
Then the order should not be cancellable


Scenario: A shipped order can be cancelled if the feature is activated

Given the shipped cancellation policy is activated
And a shipped order with the cancellation number 1234
Then the order should be cancellable with the cancellation number 1234

Scenario: A shipped order cannot be cancelled if the feature is activated and the cancellation number is wrong

Given the shipped cancellation policy is activated
And a shipped order with the cancellation number 1234
Then the order should not be cancellable with the cancellation number 3456

Scenario Outline: A shipped order cannot be cancelled if the feature is activated and the cancellation number is wrong

Given the shipped cancellation policy is activated
And a shipped order with the cancellation number <cancellation_number>
Then the order <is_cancellable> with the cancellation number <user_number>

Examples:
 | cancellation_number | user_number | is_cancellable             |
 | 1234                | 3456        | should not be cancellable  |
 | 1234                | 1234        | should be cancellable      |
