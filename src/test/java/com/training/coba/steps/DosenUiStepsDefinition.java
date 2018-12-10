package com.training.coba.steps;

import com.training.coba.steps.api.DosenApi;
import com.training.coba.steps.serenity.AddDosenSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class DosenUiStepsDefinition {
    @Steps
    AddDosenSteps addDosenSteps;

    @Steps
    DosenApi dosenApi;

    Integer idDosen;
    Response response;

    @Given("^user on dashboard page$")
    public void userOnDashboardPage() {
        addDosenSteps.openAdminPage();
    }

    @When("^user click on Daftar dosen$")
    public void userClickOnDaftarDosen() {
        addDosenSteps.clickMenuDaftarDosen();
    }

    @When("^user click on add Dosen$")
    public void userClickOnAddDosen() {
        addDosenSteps.clickBtnAddDosen();
    }

    @When("^user type \"([^\"]*)\" on field nama dosen$")
    public void userTypeOnFieldNamaDosen(String namaDosen) {
        addDosenSteps.typeNamaDosen(namaDosen);
    }

    @When("^user select \"([^\"]*)\" on Mata Kuliah$")
    public void userSelectOnMataKuliah(String mataKuliah) {
        addDosenSteps.selectMataKuliah(mataKuliah);
    }

    @When("^user type \"([^\"]*)\" on field no hp$")
    public void userTypeOnFieldNoHp(String noHp) {
        addDosenSteps.typeNoHp(noHp);
    }

    @When("^user click submit$")
    public void userClickSubmit() throws Throwable {
        addDosenSteps.clickBtnSubmit();
    }

    @Then("^user should see modal success$")
    public void userShouldSeeModalSuccess() {
        assertThat("Modal is not appear", addDosenSteps.waitModalSuccessAppear(), Matchers.equalTo(true));
    }

    @Given("^user get id from modal windows$")
    public void userGetIdFromModalWindows() {
        idDosen = addDosenSteps.getIdDosen();
    }

    @When("^user press ok on modal windows$")
    public void userPressOkOnModalWindows() {
        addDosenSteps.clickBtnOk();
    }

    @And("^user check on API get one dosen$")
    public void userCheckOnAPIGetOneDosen() {
        response = dosenApi.getSingleDosen(idDosen);
    }

    @Then("^name should be \"([^\"]*)\"$")
    public void nameShouldBe(String namaDosen) {
        assertThat("Nama Tidak sama" , response.path("content.nama") , Matchers.equalTo(namaDosen));
    }

    @And("^mata kuliah is \"([^\"]*)\"$")
    public void mataKuliahIs(String mataKuliah) {
        assertThat("Nama Tidak sama" , response.path("content.matkul") , Matchers.equalTo(mataKuliah));
    }

    @And("^no hp is \"([^\"]*)\"$")
    public void noHpIs(String noHp) throws Throwable {
        assertThat("Nama Tidak sama" , response.path("content.no_hp") , Matchers.equalTo(noHp));
    }

}
