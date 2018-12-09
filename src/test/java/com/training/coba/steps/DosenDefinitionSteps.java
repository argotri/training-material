package com.training.coba.steps;

import com.training.coba.steps.api.DosenApi;
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
}
