package com.training.coba.steps.api;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.training.coba.util.ConstantBaseUrl.DOSEN_URL;
import static net.serenitybdd.rest.RestRequests.*;

public class DosenApi extends ScenarioSteps{
    @Step
    public Response getAllDosen(){
        return given()
                .header("Content-Type","application/json")
                .log()
                .all()
                .when()
                .get(DOSEN_URL);
    }

    @Step
    public Response addDosen(){
        String body = "{\n" +
                "\t\"nama\":\"Argo Triwidodo\",\n" +
                "\t\"matkul\":\"matematika\",\n" +
                "\t\"no_hp\":\"0858527737752\"\n" +
                "}";
        return given()
                .header("Content-Type","application/json")
                .log()
                .all()
                .body(body)
                .when()
                .post(DOSEN_URL);
    }

    @Step
    public Response getSingleDosen(Integer idDosen){
        return given()
                .pathParam("idDosen",idDosen)
                .header("Content-Type","application/json")
                .log()
                .all()
                .get(DOSEN_URL + "/{idDosen}");
    }

    @Step
    public Response deleteSingleDosen(Integer idDosen){
        return given()
                .pathParam("idDosen",idDosen)
                .header("Content-Type","application/json")
                .log()
                .all()
                .delete(DOSEN_URL + "/{idDosen}");
    }
}
