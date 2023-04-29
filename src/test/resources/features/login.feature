Feature: Login and auth

  Some details about this feature that might be interesting
  for other team members

  Scenario: Login to existing account
    Given that we navigate to home page
    * we accept cookies
    * we press Mein Konto icon
    Then we see a login form
    When we enter valid creds of existing user
    And we submit this form
    Then user icon shows that we're logged in