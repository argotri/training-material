package com.training.coba.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DosenListPage extends Menu{

    @FindBy(id = "add-data")
    WebElementFacade btnAddDosen;

    public void clickBtnAddDosen(){
        btnAddDosen.click();
    }

}
