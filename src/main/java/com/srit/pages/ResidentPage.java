package com.srit.pages;

import com.srit.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResidentPage extends BasePage{


    private final By btn_proceed=By.xpath("//span[normalize-space()='Proceed']");

    private final By txt_years=By.xpath("//input[@ng-reflect-name='residingYear']");

    private final By btn_back=By.xpath("//span[normalize-space()='Back']");

    private final By document_Required=By.xpath("//h5[normalize-space()='Documents Required']");

    private final By family_Members=By.xpath("//mat-radio-button[@id='mat-radio-23']//div[@class='mat-mdc-radio-touch-target']");

    private final By district_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='districtPresent']");

    private final By lst_district_drpdn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By subdivision_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='subdivisionsPresent']");

    private final By lst_subdivision_drpdn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By tahsil_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='tahsilPresent']");

    private final By lst_tahsil_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ri_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='riPresent']");

     private final By lst_ri_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By village_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='villagePresent']");

    private  final By lst_village_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_policestation=By.xpath("//*[@ng-reflect-name='policeStationPresent']");

    private final By txt_months=By.xpath("//*[@ng-reflect-name='residingMonth']");

    private final By txt_purpose=By.xpath("//*[@ng-reflect-name='purpose']");

    private final By chk_agree=By.xpath("//*[@ng-reflect-name='iAgree']//*[contains(@id, 'mat-mdc-checkbox')]");

    private final By txt_place=By.xpath("//*[@ng-reflect-name='declarationPlace']");

    private final By btn_submit=By.xpath("//*[@class='mdc-button__label' and text()='Submit']");


    private final By btn_applicant_photo=By.xpath("//*[@ng-reflect-name='uploadPhoto']");

    private final By btn_submit_yes=By.xpath("//*[@class='mdc-button__label' and text()='Yes']");

    private final By txt_applicationno=By.xpath("//*[text()=' Application Number : ']");

    private final By residentApplicationno=By.xpath("//*[@class='ng-tns-c136-81' and contains(text(), 'E-RES')]");

    private final By btn_Confirm=By.xpath("//*[@class='mdc-button__label' and text()='Confirm']");

    private final By btn_continue=By.xpath("//*[@class='mdc-button__label' and text()='Continue']");

    private final By btn_next=By.xpath("//*[@class='mdc-button__label' and text()='Next']");

    private final By lk_user=By.xpath("//*[@alt='User']");

    private final By lk_logout=By.xpath("//*[@ng-reflect-name='log-out']");

    private final By lk_da_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span");

    private final By txt_da_remarks=By.xpath("//*[@ng-reflect-name='remarks']");

    private final By btn_action_drpdwn=By.xpath("//*[@ng-reflect-name='action']");

    private final By lst_action_drpdwn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_office_drpdwn=By.xpath("//*[@ng-reflect-name='office']");

    private final By lst_office_drpdwn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_tahsil_forward=By.xpath("//td[contains(text(),'Approving')]//following-sibling::td//mat-radio-button//div//div//input");

    private final By btn_ri_forward=By.xpath("//td[contains(text(),'Processing')]//following-sibling::td//mat-radio-button//div//div//input");


    private final By btn_da_submit=By.xpath("//span[@class='mdc-button__label' and text()='Submit']");

    private final By btn_tahsil_submit=By.xpath("//span[@class='mdc-button__label' and text()='Submit']");

    private final By btn_da_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

    private final By btn_da_close=By.xpath("//span[@class='mdc-button__label' and text()='Close']");

    private final By txt_searchbox=By.xpath("//input[@placeholder='Search']");

    private final By lk_th_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");

    private final By btn_tahsilpreview_save=By.xpath("//span[@class='mdc-button__label' and text()='Save and Continue']");

    private final By btn_applydsc=By.xpath("//span[@class='mdc-button__label' and text()='Apply Digital Signature']");

    private final By txt_confirm=By.xpath("//mat-dialog-content//p[contains(text(),'Application')]");

    private final By lk_updateVerification=By.xpath("//mat-label//h6[contains(text(),'Update')]");

    private final By txt_resiverificationApplicationNo=By.xpath("//div[@class='p-2 ng-tns-c162-10']//div[1]//div[contains(text(),'E-RES')]");

    private final By txt_verification_mouza=By.xpath("//input[@ng-reflect-name='mauza']");

    private final By txt_verification_khata=By.xpath("//input[@ng-reflect-name='khataNo']");

    private final By txt_verification_plot=By.xpath("//input[@ng-reflect-name='plotNo']");

    private final By txt_verification_extent=By.xpath("//input[@ng-reflect-name='area']");

    private final By txt_verification_khatadarname=By.xpath("//input[@ng-reflect-name='nok']");

    private final By txt_verification_remarks=By.xpath("//textarea[@ng-reflect-name='remarks' and contains(@id, 'mat-input-')]");

    private final By btn_verification_fileUpload=By.xpath("//*[@ng-reflect-name='riUpload']");

    private final By btn_verification_submit=By.xpath("//mat-dialog-actions//button//span[text()='Submit']");

    private final By btn_verification_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

    private final By lk_return_to_applicant=By.partialLinkText("Returned");

    private final By txt_returned_search_box=By.xpath("//input[@placeholder='Search']");

    private final By btn_returned_edit=By.xpath("//*[@ng-reflect-icon='edit']//i-feather");

    private final By txt_returned_edit_year=By.xpath("//*[@ng-reflect-name='residingYear']");

    private final By txt_returned_purpose=By.xpath("//*[@ng-reflect-name='purpose']");





    public WebElement tahsilfirstrecord()
    {
        return getWebElement(lk_th_firstrecord);
    }
    public void click_tahsilfirstrecord()
    {
        click(lk_th_firstrecord, WaitStrategy.CLICKABLE);
    }

    public void click_firstrecord()
    {
        click(lk_da_firstrecord, WaitStrategy.CLICKABLE);
    }

    public WebElement firstrecord()
    {
        return getWebElement(lk_da_firstrecord);
    }
    public void txt_da_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
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
    public ResidentPage clickProceed()
    {
        click(btn_proceed, WaitStrategy.CLICKABLE);
        return this;
    }

    public ResidentPage txt_years(String years)
    {
        sendkeys(txt_years, years, WaitStrategy.PRESENCE);
        return this;
    }

    public ResidentPage clickBack()
    {
        click(btn_back, WaitStrategy.CLICKABLE);
        return this;
    }


    public String getDocumentTitle()
    {
        return getElementText(document_Required,WaitStrategy.PRESENCE);

    }

    public ResidentPage clickFamilyYes()
    {
        click(family_Members, WaitStrategy.CLICKABLE);
        return this;
    }

    public WebElement btnFamilyYes()
    {
     return getWebElement(family_Members);
    }

    public WebElement years()
    {
        return getWebElement(txt_years);
    }

    public WebElement districtdropdown()
    {
        return getWebElement(district_dpd);
    }
    public ResidentPage clickDistrictdropdown()
    {
        click(district_dpd, WaitStrategy.CLICKABLE);
        return this;
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

    public ResidentPage txt_policestation(String value)
    {
        sendkeys(txt_policestation, value, WaitStrategy.PRESENCE);
        return this;
    }

    public ResidentPage txt_months(String months)
    {
        sendkeys(txt_months, months, WaitStrategy.PRESENCE);
        return this;
    }

    public ResidentPage txt_purpose(String value)
    {
        sendkeys(txt_purpose, value, WaitStrategy.PRESENCE);
        return this;
    }
    public ResidentPage txt_place(String value)
    {
        sendkeys(txt_place, value, WaitStrategy.PRESENCE);
        return this;
    }

    public void clickagree()
    {
        click(chk_agree,WaitStrategy.CLICKABLE);

    }
    public WebElement agree()
    {
        return getWebElement(chk_agree);
    }
    public void clicksubmit()
    {
        click(btn_submit, WaitStrategy.CLICKABLE);
    }

    public void clickApplicantPhoto()
    {
        click(btn_applicant_photo, WaitStrategy.CLICKABLE);
    }

    public WebElement fileupload()
    {
        return getWebElement(btn_applicant_photo);
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
    public String getResidentNo()
    {
        return getElementText(residentApplicationno, WaitStrategy.PRESENCE);
    }

    public void clickConfirm()
    {
        click(btn_Confirm, WaitStrategy.CLICKABLE);
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

    public void txt_searchbox(String value)
    {
        sendkeys(txt_searchbox, value, WaitStrategy.PRESENCE);
    }

    public void clicktahsilpreviewsave()
    {
        click(btn_tahsilpreview_save, WaitStrategy.CLICKABLE);
    }

    public void clickDigitalSignature()
    {
        click(btn_applydsc, WaitStrategy.CLICKABLE);
    }

    public WebElement getUpdateVerificationReport()
    {
        return getWebElement(lk_updateVerification);
    }

    public String getResidentVerificationNo()
    {
        return getElementText(txt_resiverificationApplicationNo, WaitStrategy.PRESENCE);
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

    public void txt_verification_remarks(String value)
    {
        sendkeys(txt_verification_remarks, value, WaitStrategy.PRESENCE);
    }

    public void txt_verification_fileupload(String value)
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

    public void clickreturnedtoApplicant()
    {
        click(lk_return_to_applicant, WaitStrategy.CLICKABLE);
    }

    public void txtreturnedsearchbox(String value)
    {
        sendkeys(txt_returned_search_box, value, WaitStrategy.PRESENCE);
    }

    public WebElement returnedtoedit()
    {
        return getWebElement(btn_returned_edit);
    }

    public void txt_returned_edit_year(String value)
    {
        sendkeys(txt_returned_edit_year, value, WaitStrategy.PRESENCE);
    }

    public void clear_returnedyear()
    {
        clear(txt_returned_edit_year, WaitStrategy.PRESENCE);
    }

    public WebElement getEditSubmit()
    {
        return getWebElement(btn_submit);
    }

    public void txt_returned_edit_purpose(String value)
    {
        sendkeys(txt_returned_purpose, value, WaitStrategy.PRESENCE);
    }
    public void clear_returnedpurpose()
    {
        clear(txt_returned_purpose, WaitStrategy.PRESENCE);
    }

}
