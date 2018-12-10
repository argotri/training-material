package com.training.coba.steps;

import com.training.coba.steps.api.DosenApi;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class DosenDefinitionSteps {
    @Steps
    DosenApi dosenApi;
    Response response;
    Integer idDosen;


    @Given("^user preparing the data$")
    public void userPreparingTheData() {

    }

    @When("^user hit API to get All Dosen$")
    public void userHitAPIToGetAllDosen() {
        response = dosenApi.getAllDosen();
        System.out.println(response.prettyPrint());
    }

    @Then("^error should be false$")
    public void errorShouldBeFalse() {
        response.then().statusCode(200);
        Boolean isError = response.path("error");
        assertThat("Error is true" , isError , equalTo(false));
    }


    @Given("^user preparing data for add$")
    public void userPreparingDataForAdd() {

    }

    @When("^user hit API to add Dosen$")
    public void userHitAPIToAddDosen() {
        response = dosenApi.addDosen();
    }

    @Given("^user preparing the data for get one dosen$")
    public void userPreparingTheDataForGetOneDosen(){
        idDosen = response.path("content.id");
    }

    @When("^user hit API to get one Dosen$")
    public void userHitAPIToGetDosen() {
        response = dosenApi.getSingleDosen(idDosen);
    }

    @Given("^user preparing data for delete$")
    public void userPreparingDataForDelete() throws Throwable {
        idDosen = response.path("content.id");
    }

    @When("^user hit API to delete dosen$")
    public void userHitAPIToDeleteDosen() throws Throwable {
        response = dosenApi.deleteSingleDosen(idDosen);
    }
}
