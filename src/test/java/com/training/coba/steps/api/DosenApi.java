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
                .log()
                .all()
                .when()
                .get(DOSEN_URL);
    }
}
