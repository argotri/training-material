package com.training.coba.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DosenAddPage extends Menu {

    @FindBy(id = "nama")
    public WebElementFacade txtNamaDosen;

    @FindBy(id = "mata-kuliah")
    WebElementFacade selectMataKuliah;

    @FindBy(id = "no-hp")
    public WebElementFacade txtNoHp;

    @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade btnSubmit;

    @FindBy(xpath = "//div[@class='swal-modal']")
    WebElementFacade swalModal;

    @FindBy(xpath = "//div[@class='swal-text']")
    WebElementFacade txtDataBerhasilDitambahkan;

    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    WebElementFacade btnConfirm;

    public void selectMataKuliahByVisibleText(String value){
        selectMataKuliah.selectByVisibleText(value);
    }

    public void clickBtnSubmit(){
        btnSubmit.click();
    }


    public Integer getIdAdd(){
        String fullText = txtDataBerhasilDitambahkan.getText();
        System.out.println(fullText);
        Pattern p = Pattern.compile("^Data Berhasil Ditambahkan Dengan ID '(.*)'$");
        Matcher m = p.matcher(fullText);
        m.find();
        System.out.println(" ID yang didapat : " + m.group(1));
        return Integer.valueOf(m.group(1));
    }

    public Boolean isModalSuccessAppear(){
        return swalModal.waitUntilPresent().isCurrentlyVisible();
    }

    public void clickModalOk(){
        btnConfirm.click();
    }
}
