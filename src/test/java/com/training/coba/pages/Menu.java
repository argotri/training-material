package com.training.coba.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Menu extends PageObject {
    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    WebElementFacade menuDashboard;

    @FindBy(xpath = "//a[contains(text(),'Daftar Dosen')]")
    WebElementFacade menuDaftarDosen;

    public void clickMenuDashboard(){
        menuDashboard.click();
    }

    public void clickMenuDaftarDosen(){
        menuDaftarDosen.click();
    }
}
