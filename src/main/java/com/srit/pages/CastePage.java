package com.srit.pages;

import com.srit.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CastePage extends BasePage{

    private final By btn_proceed=By.linkText("Proceed");

    private final By document_Required=By.xpath("//h2[normalize-space()='Documents Required']");

    private final By district_dpd=By.id("pdistrict");

    private final By lst_district_drpdn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By subdivision_dpd=By.id("psubdivision");

    private final By lst_subdivision_drpdn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By tahsil_dpd=By.id("ptahsil");

    private final By lst_tahsil_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ri_dpd=By.id("pri");

    private final By lst_ri_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By village_dpd=By.id("pvillage");

    private  final By lst_village_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_policestation=By.id("ppoliceStation");

    private final By caste_dpd=By.id("caste");

    private final By lst_caste_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By religion_dpd=By.id("casteReligion");

    private final By lst_religion_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_applicant_photo=By.id("photograph");

    private final By txt_purpose=By.id("purpose");

    private final By chk_agree=By.id("agree");

    private final By txt_place=By.id("place");

    private final By btn_submit=By.id("submitDetails");

    private final By btn_submit_yes=By.xpath("//*[@class='btn btn-success']");

    private final By txt_applicationno=By.xpath("//*[@class='col-sm-3 heading-title' and contains(text(),'Application No. :')]");

    private final By txt_confirm=By.xpath("//mat-dialog-content//p[contains(text(),'Application')]");
    private final By btn_Confirm=By.id("confirmBtnSubmit");

    private final By casteApplicationno=By.xpath("//*[@class='col-sm-3' and contains(text(),'E-SCO')]");

    private final By btn_continue=By.xpath("//*[@class='btn btn-success']");

    private final By btn_next=By.xpath("//*[@class='mdc-button__label' and text()='Next']");

    private final By lk_user_citizen=By.id("dropdownClick");

    private final By lk_citizen_logout=By.xpath("//*[@class='icon']//img[contains(@src,'logout')]");


    private final By lk_user=By.xpath("//*[@alt='User']");

    private final By lk_logout=By.xpath("//*[@ng-reflect-name='log-out']");

    public void click_Proceed()
    {
        click(btn_proceed, WaitStrategy.CLICKABLE);
    }

    public String getDocumentTitle()
    {
        return getElementText(document_Required,WaitStrategy.PRESENCE);

    }

    public WebElement districtdropdown()
    {
        return getWebElement(district_dpd);
    }

    public By districtdropdownlist()
    {
        return lst_district_drpdn;
    }

    public WebElement subdivisiondropdown()
    {
        return getWebElement(subdivision_dpd);
    }
    public By subdivisiondropdownlist()
    {
        return lst_subdivision_drpdn;
    }

    public WebElement tahsildropdown()
    {
        return getWebElement(tahsil_dpd);
    }
    public By tahsildropdownlist()
    {
        return lst_tahsil_dpd;
    }

    public WebElement ridropdown()
    {
        return getWebElement(ri_dpd);
    }
    public By ridropdownlist()
    {
        return lst_ri_dpd;
    }

    public WebElement villagedropdown()
    {
        return getWebElement(village_dpd);
    }
    public By villagedropdownlist()
    {
        return lst_village_dpd;
    }

    public WebElement castedropdown()
    {
        return getWebElement(caste_dpd);
    }

    public By castedropdownlist()
    {
        return lst_caste_dpd;
    }
    public WebElement religiondropdown()
    {
        return getWebElement(religion_dpd);
    }

    public By religiondropdownlist()
    {
        return lst_religion_dpd;
    }

    public void txt_policestation(String value)
    {
        sendkeys(txt_policestation, value, WaitStrategy.PRESENCE);
    }
    public WebElement fileUpload()
    {
        return getWebElement(btn_applicant_photo);
    }
    public void txt_purpose(String value)
    {
        sendkeys(txt_purpose, value, WaitStrategy.PRESENCE);
    }
    public WebElement agree()
    {
        return  getWebElement(chk_agree);
    }
    public void txt_place(String value)
    {
        sendkeys(txt_place, value, WaitStrategy.PRESENCE);
    }
    public void clicksubmit()
    {
        click(btn_submit, WaitStrategy.CLICKABLE);
    }

    public void clickConfirm()
    {
        click(btn_Confirm, WaitStrategy.CLICKABLE);
    }
    public void click_Yes()
    {
        click(btn_submit_yes, WaitStrategy.CLICKABLE);
    }

    public String getApplicationNo()
    {
        return   getElementText(txt_applicationno, WaitStrategy.PRESENCE);
    }

    public String getConfirmText()
    {
        return getElementText(txt_confirm, WaitStrategy.PRESENCE);
    }
    public String getCasteCertNo()
    {
        return getElementText(casteApplicationno, WaitStrategy.PRESENCE);
    }
    public void clickContinue()
    {
        click(btn_continue, WaitStrategy.CLICKABLE);
    }
    public void clickNext()
    {
        click(btn_next, WaitStrategy.CLICKABLE);
    }

    public void clickUser()
    {
        click(lk_user, WaitStrategy.CLICKABLE);
    }

    public void clickLogout()
    {
        click(lk_logout, WaitStrategy.CLICKABLE);
    }

    private final By lk_da_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");
    private final By txt_da_remarks=By.xpath("//*[@ng-reflect-name='remarks']");
    private final By btn_action_drpdwn=By.xpath("//*[@ng-reflect-name='action']");
    private final By lst_action_drpdwn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_office_drpdwn=By.xpath("//*[@ng-reflect-name='office']");

    private final By lst_office_drpdwn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_tahsil_forward=By.xpath("//td[contains(text(),'Approving')]//following-sibling::td//mat-radio-button//div//div//input");

    private final By btn_ri_forward=By.xpath("//td[contains(text(),'Processing')]//following-sibling::td//mat-radio-button//div//div//input");

    private final By btn_da_submit=By.xpath("//span[@class='mdc-button__label' and text()='Submit']");

    private final By btn_da_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

    private final By btn_da_close=By.xpath("//span[@class='mdc-button__label' and text()='Close']");

    public void clickCitizenUser()
    {
        click(lk_user_citizen, WaitStrategy.CLICKABLE);
    }

    public void clickCitizenlogout()
    {
        click(lk_citizen_logout, WaitStrategy.CLICKABLE);
    }
    public void txt_da_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }
    public void click_firstrecord()
    {
        click(lk_da_firstrecord, WaitStrategy.CLICKABLE);
    }

    public WebElement actiondropdown()
    {
        return getWebElement(btn_action_drpdwn);
    }

    public By actiondropdownlist()
    {
        return lst_action_drpdwn;
    }
    public WebElement officedropdown()
    {
        return getWebElement(btn_office_drpdwn);
    }

    public By officedropdownlist()
    {
        return lst_office_drpdwn;
    }

    public WebElement forward()
    {
        return getWebElement(btn_tahsil_forward);
    }

    public WebElement forwardtori()
    {
        return getWebElement(btn_ri_forward);
    }
    public void click_forward()
    {
        click(btn_tahsil_forward, WaitStrategy.CLICKABLE);
    }

    public void clickdasubmit()
    {
        click(btn_da_submit, WaitStrategy.CLICKABLE);
    }

    public void clickdacontinue()
    {
        click(btn_da_continue, WaitStrategy.CLICKABLE);
    }

    public void clickdaclose()
    {
        click(btn_da_close, WaitStrategy.CLICKABLE);
    }

    /*xpath for RI */

    private final By txt_searchbox=By.xpath("//input[@placeholder='Search']");

    private final By lk_th_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");

    private final By lk_updateVerification=By.xpath("//mat-label//h6[contains(text(),'Update')]");

    private final By txt_castverificationapplicationno=By.xpath("//*[@class='col-xl-6 col-lg-6 col-md-12 col-sm-12 ng-tns-c174-10' and contains(text(),'E-SCO')]");

    private final By txt_verification_remarks=By.xpath("//textarea[@ng-reflect-name='remarks' and contains(@id, 'mat-input-')]");

    private final By btn_verification_fileUpload=By.xpath("//*[@ng-reflect-name='riUpload']");
    private final By btn_verification_submit=By.xpath("//mat-dialog-actions//button//span[text()='Submit']");
    private final By btn_verification_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

    private final By txt_verification_mouza=By.xpath("//input[@ng-reflect-name='mauza']");

    private final By txt_verification_khata=By.xpath("//input[@ng-reflect-name='khataNo']");

    private final By txt_verification_plot=By.xpath("//input[@ng-reflect-name='plotNo']");

    private final By txt_verification_extent=By.xpath("//input[@ng-reflect-name='area']");

    private final By txt_verification_khatadarname=By.xpath("//input[@ng-reflect-name='nok']");

    private final By txt_verification_recorded_tenant=By.xpath("//input[@ng-reflect-name='recoredtenant']");

    private final By txt_verification_relation_recorded_tenant=By.xpath("//input[@ng-reflect-name='relationTenant']");

    private final By txt_verification_original_patta=By.xpath("//input[@ng-reflect-name='originalPatta']");

    private final By txt_verification_female_father_land=By.xpath("//input[@ng-reflect-name='femaleFatherLand']");

    private final By txt_verification_traditional_occupation=By.xpath("//input[@ng-reflect-name='traitionalOccupation']");

    private final By txt_verification_applicant_native=By.xpath("//input[@ng-reflect-name='applicantNative']");



    public WebElement tahsilfirstrecord()
    {
        return getWebElement(lk_th_firstrecord);
    }
    public void txt_searchbox(String value)
    {
        sendkeys(txt_searchbox, value, WaitStrategy.PRESENCE);
    }

    public WebElement getUpdateVerificationReport()
    {
        return getWebElement(lk_updateVerification);
    }

    public String getCasteVerificationNo()
    {
        return getElementText(txt_castverificationapplicationno, WaitStrategy.PRESENCE);
    }

    public void txt_verification_remarks(String value)
    {
        sendkeys(txt_verification_remarks, value, WaitStrategy.PRESENCE);
    }

    public void verification_fileupload(String value)
    {
        sendkeys(btn_verification_fileUpload, value, WaitStrategy.PRESENCE);
    }

    public void clickVerificationSubmit()
    {
        click(btn_verification_submit, WaitStrategy.CLICKABLE);
    }

    public void clickVerificationContinue()
    {
        click(btn_verification_continue, WaitStrategy.CLICKABLE);
    }

    public void txt_ri_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }

    public void clickrisubmit()
    {
        click(btn_da_submit, WaitStrategy.CLICKABLE);
    }

    public void clickricontinue()
    {
        click(btn_da_continue, WaitStrategy.CLICKABLE);
    }

    public void txt_verification_mouza(String value)
    {
        sendkeys(txt_verification_mouza, value, WaitStrategy.PRESENCE);
    }
    public void txt_verification_khata(String value)
    {
        sendkeys(txt_verification_khata, value, WaitStrategy.PRESENCE);
    }
    public void txt_verification_plot(String value)
    {
        sendkeys(txt_verification_plot, value, WaitStrategy.PRESENCE);
    }
    public void txt_verification_extent(String value)
    {
        sendkeys(txt_verification_extent, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_khatadarname(String value)
    {
        sendkeys(txt_verification_khatadarname, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_recorded_tenant(String value)
    {
        sendkeys(txt_verification_recorded_tenant, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_relation_recorded_tenant(String value)
    {
        sendkeys(txt_verification_relation_recorded_tenant, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_original_patta(String value)
    {
        sendkeys(txt_verification_original_patta, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_father_land(String value)
    {
        sendkeys(txt_verification_female_father_land, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_occupation(String value)
    {
        sendkeys(txt_verification_traditional_occupation, value, WaitStrategy.PRESENCE);
    }
    public void txt_verification_applicant_native(String value)
    {
        sendkeys(txt_verification_applicant_native, value, WaitStrategy.PRESENCE);
    }


    /*Xpath for Tahsil Approval*/


    private final By btn_tahsilpreview_save=By.xpath("//span[@class='mdc-button__label' and text()='Save and Continue']");
    private final By btn_applydsc=By.xpath("//span[@class='mdc-button__label' and text()='Apply Digital Signature']");

    private final By txt_othertahsil_district=By.xpath("//*[@ng-reflect-name='district']");

    private final By lk_highligh=By.xpath("//*[@class='highlightTxt']");

    private final By txt_othertahsil_subdivision=By.xpath("//*[@ng-reflect-name='subdivision']");

    private final By txt_othertahsil_tahsil=By.xpath("//*[@ng-reflect-name='tahsil']");

    private final By lk_othertahsil=By.xpath("//*[contains(@class,'mat-content ng-tns-c88-')]//mat-panel-title[contains(text(),'Bar')]");

    public void clicktahsilpreviewsave()
    {
        click(btn_tahsilpreview_save, WaitStrategy.CLICKABLE);
    }

    public void clickTahsilsubmit()
    {
        click(btn_da_submit, WaitStrategy.CLICKABLE);
    }

    public void clickTahsilcontinue()
    {
        click(btn_da_continue, WaitStrategy.CLICKABLE);
    }

    public void clickDigitalSignature()
    {
        click(btn_applydsc, WaitStrategy.CLICKABLE);
    }

    public void txt_tahsil_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }

    public void txt_othertahsil_district(String value)
    {
        sendkeys(txt_othertahsil_district, value, WaitStrategy.PRESENCE);
    }

    public void txt_othertahsil_subdivision(String value)
    {
        sendkeys(txt_othertahsil_subdivision, value, WaitStrategy.PRESENCE);
    }

    public void txt_othertahsil_tahsil(String value)
    {
        sendkeys(txt_othertahsil_tahsil, value, WaitStrategy.PRESENCE);
    }
    public void clickhighlighted()
    {
        click(lk_highligh, WaitStrategy.CLICKABLE);
    }

    public void clickOtherTahsil()
    {
        click(lk_othertahsil, WaitStrategy.CLICKABLE);
    }


}
