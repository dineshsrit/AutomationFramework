package com.srit.pages;

import com.srit.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LegalHeirPage extends BasePage{

    private final By btn_proceed=By.linkText("Proceed");

    private final By document_Required=By.xpath("//h2[normalize-space()='Documents Required']");

    private final By deceased_person=By.id("dpfirstName");

    private final By deceased_spouseperson=By.id("dpsfirstName");

    private final By deceased_relation=By.id("dpRelation");

    private final By deceased_gender=By.id("dpgender");

    private final By placeofdeath=By.id("placeOfDeath");

    private final By dateofdeath=By.xpath("//*[@class='ui-datepicker-trigger']");

    private final By deathaddress=By.id("deathAddress");

    private final By legalheir1name=By.id("lhname1");

    private final By legal1age=By.id("lhage1");

    private final By legal1status=By.id("lhMaritalStatus1");

    private final By legal1relation=By.id("lhrelationship1");

    private final By receipt=By.id("receiptCheckbox1");

    private final By otherpurpose=By.id("otherPurpose");

    private final By district=By.id("pdistrict");

    private final By subdivision=By.id("psubdivision");

    private final By tahsil=By.id("ptahsil");

    private final By ri=By.id("pri");

    private final By village=By.id("pvillage");

    private final By policestation=By.id("ppoliceStation");

    private final By applicant_photo=By.id("photograph");

    private final By supportingdoc=By.id("supportingDocuments352");

    private final By agree=By.id("agree");

    private final By place=By.id("place");

    private final By submit=By.id("submitDetails");

    private final By btn_Confirm=By.id("confirmBtnSubmit");

    private final By btn_submit_yes=By.xpath("//*[@class='btn btn-success']");

    private final By txt_applicationno=By.xpath("//*[@class='col-sm-3 heading-title' and contains(text(),'Application No. :')]");

    private final By lhcApplicationno=By.xpath("//*[@class='col-sm-3' and contains(text(),'E-LHC')]");

    private final By btn_continue=By.xpath("//*[@class='btn btn-success']");

    private final By lk_user_citizen=By.id("dropdownClick");

    private final By lk_citizen_logout=By.xpath("//*[@class='icon']//img[contains(@src,'logout')]");

    private final By month=By.xpath("//*[@class='ui-datepicker-month']");

    private final By year=By.xpath("//*[@class='ui-datepicker-year']");

    private final By selectday=By.xpath("//*[@data-handler='selectDay']//a[@data-date='3']");








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
        return getWebElement(district);
    }

    public WebElement subdivisiondropdown()
    {
        return getWebElement(subdivision);
    }

    public WebElement tahsildropdown()
    {
        return getWebElement(tahsil);
    }

    public WebElement ridropdown()
    {
        return getWebElement(ri);
    }
    public WebElement villagedropdown()
    {
        return getWebElement(village);
    }
    public void txt_policestation(String value)
    {
        sendkeys(policestation, value, WaitStrategy.PRESENCE);
    }

    public void txt_deceasedFirstName(String value)
    {
        sendkeys(deceased_person, value, WaitStrategy.PRESENCE);
    }

    public void txt_deceasedSpouseFirstName(String value)
    {
        sendkeys(deceased_spouseperson, value, WaitStrategy.PRESENCE);
    }
    public WebElement relationdropdown()
    {
        return getWebElement(deceased_relation);
    }

    public WebElement deceasedgenderdropdown()
    {
        return getWebElement(deceased_gender);
    }

    public void  txt_placeofdeath(String value)
    {
       sendkeys(placeofdeath, value, WaitStrategy.PRESENCE);
    }

    public WebElement  getdateofdeath()
    {
        return getWebElement(dateofdeath);
    }

    public void  txt_deathaddress(String value)
    {
        sendkeys(deathaddress, value, WaitStrategy.PRESENCE);
    }

    public void  txt_legalname(String value)
    {
        sendkeys(legalheir1name, value, WaitStrategy.PRESENCE);
    }

    public void  txt_legalage(String value)
    {
        sendkeys(legal1age, value, WaitStrategy.PRESENCE);
    }

    public WebElement  getlegalstatus()
    {
       return getWebElement(legal1status);
    }

    public void  txt_legalrelation(String value)
    {
        sendkeys(legal1relation, value, WaitStrategy.PRESENCE);
    }

    public WebElement  clickreceipt()
    {
       return getWebElement(receipt);
    }
    public void  txt_others(String value)
    {
        sendkeys(otherpurpose, value, WaitStrategy.PRESENCE);
    }

    public WebElement fileUpload()
    {
        return getWebElement(applicant_photo);
    }

    public WebElement fileUploadSupport()
    {
        return getWebElement(supportingdoc);
    }
    public WebElement agree()
    {
        return  getWebElement(agree);
    }
    public void txt_place(String value)
    {
        sendkeys(place, value, WaitStrategy.PRESENCE);
    }
    public void clicksubmit()
    {
        click(submit, WaitStrategy.CLICKABLE);
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

    public void clickContinue()
    {
        click(btn_continue, WaitStrategy.CLICKABLE);
    }

    public String getIhcCertNo()
    {
        return getElementText(lhcApplicationno, WaitStrategy.PRESENCE);
    }

    public void clickCitizenUser()
    {
        click(lk_user_citizen, WaitStrategy.CLICKABLE);
    }

    public void clickCitizenlogout()
    {
        click(lk_citizen_logout, WaitStrategy.CLICKABLE);
    }



    public WebElement getmonth()
    {
        return getWebElement(month);
    }


    public WebElement getyear()
    {
        return getWebElement(year);
    }

    public void clickDate()
    {
        click(selectday, WaitStrategy.CLICKABLE);
    }


    /*xpath for DA */

    private final By textbox_username=By.id("mat-input-0");
    private final By textbox_password=By.id("mat-input-1");
    private final By button_login=By.xpath("//button[@type='submit']");

    private final By lk_coreapplication=By.linkText("Core application");

    private final By lk_applicationsbox=By.linkText("Applications Box");

    private final By lk_mypendingapplications=By.linkText("My Pending Applications");

    private final By lk_da_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");
    private final By txt_da_remarks=By.xpath("//*[@ng-reflect-name='remarks']");
    private final By btn_action_drpdwn=By.xpath("//*[@ng-reflect-name='action']");
    private final By lst_action_drpdwn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_office_drpdwn=By.xpath("//*[@ng-reflect-name='office']");

    private final By lst_office_drpdwn=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By btn_ri_forward=By.xpath("//td[contains(text(),'Processing')]//following-sibling::td//mat-radio-button//div//div//input");

    private final By btn_da_submit=By.xpath("//span[@class='mdc-button__label' and text()='Submit']");
    private final By btn_da_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");
    private final By btn_da_close=By.xpath("//span[@class='mdc-button__label' and text()='Close']");
    private final By lk_user=By.xpath("//*[@alt='User']");

    private final By lk_logout=By.xpath("//*[@ng-reflect-name='log-out']");

    private final By btn_csv=By.xpath("//*[@ng-reflect-message='CSV']");

    private final By search=By.xpath("//*[@placeholder='Search']");

    public void click_csv()
    {
        click(btn_csv,WaitStrategy.CLICKABLE);
    }

    public void click_search()
    {
        click(search,WaitStrategy.CLICKABLE);
    }
    public void click_firstrecord()
    {
       click(lk_da_firstrecord, WaitStrategy.CLICKABLE);
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


    public WebElement forwardtori()
    {
        return getWebElement(btn_ri_forward);
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

    public void clickUser()
    {
        click(lk_user, WaitStrategy.CLICKABLE);
    }

    public void clickLogout()
    {
        click(lk_logout, WaitStrategy.CLICKABLE);
    }


    /*xpath for RI */
    private final By txt_searchbox=By.xpath("//input[@placeholder='Search']");

    private final By lk_th_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");

    private final By lk_updateVerification=By.xpath("//mat-label//h6[contains(text(),'Update')]");

    private final By txt_lhcverificationapplicationno=By.xpath("//*[@class='col-xl-6 col-lg-6 col-md-12 col-sm-12' and contains(text(),'E-LHC')]");

    private final By txt_verification_remarks=By.xpath("//textarea[@ng-reflect-name='remarks' and contains(@id, 'mat-input-')]");

    private final By btn_verification_fileUpload=By.xpath("//*[@ng-reflect-name='riUpload']");
    private final By btn_verification_submit=By.xpath("//mat-dialog-actions//button//span[text()='Submit']");
    private final By btn_verification_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

    private final By btn_tahsil_forward=By.xpath("//td[contains(text(),'Approving')]//following-sibling::td//mat-radio-button//div//div//input");

    private final By txt_ri_purpose=By.xpath("//*[@ng-reflect-name='purposeCertificate']");

    private final By txt_confirm=By.xpath("//mat-dialog-content//p[contains(text(),'Application')]");

    private final By txt_othertahsil_district=By.xpath("//*[@ng-reflect-name='district']");

    private final By lk_highligh=By.xpath("//*[@class='highlightTxt']");

    private final By txt_othertahsil_subdivision=By.xpath("//*[@ng-reflect-name='subdivision']");

    private final By txt_othertahsil_tahsil=By.xpath("//*[@ng-reflect-name='tahsil']");

    private final By lk_othertahsil=By.xpath("//*[contains(@class,'mat-content ng-tns-c88-')]//mat-panel-title[contains(text(),'Bar')]");

    public WebElement tahsilfirstrecord()
    {
        return getWebElement(lk_th_firstrecord);
    }

    public WebElement forward()
    {
        return getWebElement(btn_tahsil_forward);
    }
    public void txt_searchbox(String value)
    {
        sendkeys(txt_searchbox, value, WaitStrategy.PRESENCE);
    }

    public WebElement getUpdateVerificationReport()
    {
        return getWebElement(lk_updateVerification);
    }

    public String getIncomeVerificationNo()
    {
        return getElementText(txt_lhcverificationapplicationno, WaitStrategy.PRESENCE);
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

    public String getConfirmText()
    {
        return getElementText(txt_confirm, WaitStrategy.PRESENCE);
    }

    public void txt_ri_purpose(String value)
    {
        sendkeys(txt_ri_purpose, value, WaitStrategy.PRESENCE);
    }
    public void clickrisubmit()
    {
        click(btn_da_submit, WaitStrategy.CLICKABLE);
    }

    public void clickricontinue()
    {
        click(btn_da_continue, WaitStrategy.CLICKABLE);
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
