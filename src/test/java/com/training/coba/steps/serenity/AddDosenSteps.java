package com.training.coba.steps.serenity;

import com.training.coba.pages.DosenAddPage;
import com.training.coba.pages.DosenListPage;
import net.thucydides.core.annotations.Step;


public class AddDosenSteps {

    DosenListPage dosenListPage;
    DosenAddPage dosenAddPage;

    @Step
    public void openAdminPage(){
        dosenListPage.openAt("http://gosoft.web.id/example/ui/");
    }

    @Step
    public void clickMenuDaftarDosen(){
        dosenListPage.clickMenuDaftarDosen();
    }

    @Step
    public void clickBtnAddDosen(){
        dosenListPage.clickBtnAddDosen();
    }

    @Step
    public void typeNamaDosen(String namaDosen){
        dosenAddPage.typeInto(dosenAddPage.txtNamaDosen,namaDosen);
    }

    @Step
    public void selectMataKuliah(String mataKuliah){
        dosenAddPage.selectMataKuliahByVisibleText(mataKuliah);
    }

    @Step
    public void typeNoHp(String noHp){
        dosenAddPage.typeInto(dosenAddPage.txtNoHp,noHp);
    }

    @Step
    public void clickBtnSubmit(){
        dosenAddPage.clickBtnSubmit();
    }

    @Step
    public Boolean waitModalSuccessAppear(){
        return dosenAddPage.isModalSuccessAppear();
    }

    @Step
    public Integer getIdDosen(){
        return  dosenAddPage.getIdAdd();
    }

    @Step
    public void clickBtnOk(){
        dosenAddPage.clickModalOk();
    }

}
