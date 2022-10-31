Feature: Feature1

  @Tag1
  Scenario: Scenario 1

    Given user on homepage
    When  user login as follow
      | username | demo |
      | password | demo |
    Then  login should be successfull

