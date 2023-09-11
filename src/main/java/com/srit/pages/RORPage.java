package com.srit.pages;

import com.srit.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RORPage extends BasePage{

    private final By btn_proceed=By.xpath("//span[normalize-space()='Proceed']");

    private final By document_Required=By.xpath("//h5[normalize-space()='Documents Required']");

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


    private final By ror_district_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='districtLand']");

    private final By ror_lst_district_drpdn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ror_subdivision_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='subdivisionLand']");

    private final By ror_lst_subdivision_drpdn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ror_tahsil_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='tahsilLand']");

    private final By ror_lst_tahsil_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ror_ri_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='riLand']");

    private final By ror_lst_ri_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ror_village_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='mouza']");

    private  final By ror_lst_village_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By ror_txt_policestation=By.xpath("//*[@ng-reflect-name='policeStationLand']");

    private final By ror_txt_khatano=By.xpath("//*[@ng-reflect-name='khataNo']");

    private final By txt_plot_no=By.xpath("//*[@class='mat-mdc-form-field-infix ng-tns-c37-91']//input");

    private final By txt_castetribe=By.xpath("//*[@ng-reflect-name='casteAndTribe']");

    private final By btn_applicant_photo=By.xpath("//*[@ng-reflect-name='uploadPhoto']");

    private final By txt_purpose=By.xpath("//*[@ng-reflect-name='purpose']");

    private final By chk_agree=By.xpath("//*[@ng-reflect-name='iAgree']//*[contains(@id, 'mat-mdc-checkbox')]");

    private final By txt_place=By.xpath("//*[@ng-reflect-name='declarationPlace']");

    private final By btn_submit=By.xpath("//*[@class='mdc-button__label' and text()='Submit']");

    private final By btn_submit_yes=By.xpath("//*[@class='mdc-button__label' and text()='Yes']");

    private final By txt_applicationno=By.xpath("//*[text()=' Application Number : ']");

    private final By txt_confirm=By.xpath("//mat-dialog-content//p[contains(text(),'Application')]");
    private final By btn_Confirm=By.xpath("//*[@class='mdc-button__label' and text()='Confirm']");

    private final By rorApplicationno=By.xpath("//mat-label[contains(text(),'E-CCP')]");

    private final By btn_continue=By.xpath("//*[@class='mdc-button__label' and text()='Continue']");

    private final By btn_next=By.xpath("//*[@class='mdc-button__label' and text()='Next']");

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


    public void txt_policestation(String value)
    {
        sendkeys(txt_policestation, value, WaitStrategy.PRESENCE);
    }


    public WebElement rordistrictdropdown()
    {
        return getWebElement(ror_district_dpd);
    }

    public By rordistrictdropdownlist()
    {
        return ror_lst_district_drpdn;
    }

    public WebElement rorsubdivisiondropdown()
    {
        return getWebElement(ror_subdivision_dpd);
    }
    public By rorsubdivisiondropdownlist()
    {
        return ror_lst_subdivision_drpdn;
    }

    public WebElement rortahsildropdown()
    {
        return getWebElement(ror_tahsil_dpd);
    }
    public By rortahsildropdownlist()
    {
        return ror_lst_tahsil_dpd;
    }

    public WebElement rorridropdown()
    {
        return getWebElement(ror_ri_dpd);
    }
    public By rorridropdownlist()
    {
        return ror_lst_ri_dpd;
    }

    public WebElement rorvillagedropdown()
    {
        return getWebElement(ror_village_dpd);
    }
    public By rorvillagedropdownlist()
    {
        return ror_lst_village_dpd;
    }


    public void txt_ror_policestation(String value)
    {
        sendkeys(ror_txt_policestation, value, WaitStrategy.PRESENCE);
    }

    public void txt_khatano(String value)
    {
        sendkeys(ror_txt_khatano, value, WaitStrategy.PRESENCE);
    }

    public void txt_plot_no(String value)
    {
        sendkeys(txt_plot_no, value, WaitStrategy.PRESENCE);
    }

    public void txt_castetribe(String value)
    {
        sendkeys(txt_castetribe, value, WaitStrategy.PRESENCE);
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
      return getWebElement(chk_agree);
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
    public String getRorCertNo()
    {
        return getElementText(rorApplicationno, WaitStrategy.PRESENCE);
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


    /*xpath for DA */

    private final By lk_da_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span");

    private final By btn_manual_upload=By.xpath("//*[@ng-reflect-value='true' and contains(@id, 'mat-radio-')]");

    private final By ror_file=By.xpath("//*[@class='col-xl-3 col-lg-3 col-md-3 col-sm-3 fieldname-half ng-star-inserted']//input");
    private final By rc_update=By.xpath("//*[contains(text(),'Update')]");

    private final By txt_searchingfee=By.xpath("//*[@formcontrolname='searchingFee']");

    private final By txt_extrafee=By.xpath("//*[@ng-reflect-name='extraFee']");

    private final By txt_noofpaper=By.xpath("//*[@ng-reflect-name='noOfPaper']");

    private final By txt_others=By.xpath("//*[@ng-reflect-name='others']");

    private final By txt_plainpapers=By.xpath("//*[@ng-reflect-name='plainPapers']");

    private final By txt_printedpapers=By.xpath("//*[@ng-reflect-name='printedPaper']");

    private final By txt_tracingcloth=By.xpath("//*[@ng-reflect-name='tracingCloth']");

    private final By txt_copyingfee=By.xpath("//*[@ng-reflect-name='copyingFee']");

    private final By txt_noofwords=By.xpath("//*[@ng-reflect-name='noOfWords']");

    private final By btn_verification_submit=By.xpath("//mat-dialog-actions//button//span[text()='Submit']");
    private final By btn_verification_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

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

    public void txt_da_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }
    public void click_firstrecord()
    {
        click(lk_da_firstrecord, WaitStrategy.CLICKABLE);
    }

    public WebElement click_manualUpload()
    {
        return getWebElement(btn_manual_upload);
    }

    public WebElement rorfileUpload()
    {
        return getWebElement(ror_file);
    }

    public WebElement getUpdateVerification()
    {
       return getWebElement(rc_update);
    }


    public void txt_searchingfee(String value)
    {
        sendkeys(txt_searchingfee, value, WaitStrategy.PRESENCE);
    }

    public void txt_extrafee(String value)
    {
        sendkeys(txt_extrafee, value, WaitStrategy.PRESENCE);
    }

    public void txt_noofpaper(String value)
    {
        sendkeys(txt_noofpaper, value, WaitStrategy.PRESENCE);
    }

    public void txt_others(String value)
    {
        sendkeys(txt_others, value, WaitStrategy.PRESENCE);
    }

    public void txt_plainpers(String value)
    {
        sendkeys(txt_plainpapers, value, WaitStrategy.PRESENCE);
    }

    public void txt_printedpapers(String value)
    {
        sendkeys(txt_printedpapers, value, WaitStrategy.PRESENCE);
    }

    public void txt_tracingcloth(String value)
    {
        sendkeys(txt_tracingcloth, value, WaitStrategy.PRESENCE);
    }

    public void txt_copyingfee(String value)
    {
        sendkeys(txt_copyingfee, value, WaitStrategy.PRESENCE);
    }

    public void txt_noofwords(String value)
    {
        sendkeys(txt_noofwords, value, WaitStrategy.PRESENCE);
    }
    public void clickVerificationSubmit()
    {
        click(btn_verification_submit, WaitStrategy.CLICKABLE);
    }

    public void clickVerificationContinue()
    {
        click(btn_verification_continue, WaitStrategy.CLICKABLE);
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

    /* xpath for Head Clerk */

    private final By txt_searchbox=By.xpath("//input[@placeholder='Search']");

    private final By lk_th_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");

    private final By btn_applydsc=By.xpath("//span[@class='mdc-button__label' and text()='Apply Digital Signature']");


    public void txt_hc_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }

    public WebElement tahsilfirstrecord()
    {
        return getWebElement(lk_th_firstrecord);
    }
    public void txt_searchbox(String value)
    {
        sendkeys(txt_searchbox, value, WaitStrategy.PRESENCE);
    }

    public void clickhcsubmit()
    {
        click(btn_da_submit, WaitStrategy.CLICKABLE);
    }

    public void clickhccontinue()
    {
        click(btn_da_continue, WaitStrategy.CLICKABLE);
    }

    /*xpath for Tahsil */


    public void clickTahsilsubmit()
    {
        click(btn_da_submit, WaitStrategy.CLICKABLE);
    }

    public void clickTahsilcontinue()
    {
        click(btn_da_continue, WaitStrategy.CLICKABLE);
    }
    public void txt_tahsil_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }
    public void clickDigitalSignature()
    {
        click(btn_applydsc, WaitStrategy.CLICKABLE);
    }

}
