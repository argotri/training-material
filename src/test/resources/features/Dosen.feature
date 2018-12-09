@DosenFeature
Feature: CRUD Dosen Melalui API
  Scenario: Get All dosen and make sure error is false

    Given user preparing the data
    When user hit API to get All Dosen
    Then error should be false