@DosenFeature
Feature: CRUD Dosen Melalui API

  Scenario: Get All dosen and make sure error is false
    Given user preparing the data
    When user hit API to get All Dosen
    Then error should be false

  @Regression
  Scenario: Add and Delete Dosen then Validate error is false
    Given user preparing data for add
    When user hit API to add Dosen
    Then error should be false
    Given user preparing the data for get one dosen
    When user hit API to get one Dosen
    Then error should be false
    Given user preparing data for delete
    When user hit API to delete dosen
    Then error should be false

  @UiIntegration
  Scenario: Add dosen and Verify data via API
    Given user on dashboard page
    When user click on Daftar dosen
    And user click on add Dosen
    And user type "Argo" on field nama dosen
    And user select "Kimia" on Mata Kuliah
    And user type "085852773775" on field no hp
    And user click submit
    Then user should see modal success
    Given user get id from modal windows
    When user press ok on modal windows
    And user check on API get one dosen
    Then name should be "Argo"
    And mata kuliah is "Kimia"
    And no hp is "085852773775"