package com.srit.pages;

import com.srit.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IncomeAssetPage extends BasePage{

    /* xpath for Income and Asset Application Submission */

    private final By btn_proceed=By.linkText("Proceed");

    private final By category_dpd=By.id("prefix");

    private  final By lst_category_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By sibling_dpd=By.id("hasSiblingsYes");

    private  final By lst_sibling_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By children_dpd=By.id("hasChildrenYes");

    private  final By lst_children_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_sibling_name=By.id("siblingName1");

    private final By txt_sibling_age=By.id("siblingAge");

    private final By sibling_gender_dpd=By.id("siblinggender1");

    private  final By lst_siblinggender_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");


    private final By sibling_relation_dpd=By.id("siblingRelation1");

    private  final By lst_siblingrelation_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_children_name=By.id("childrenName1");

    private final By txt_children_age=By.id("childrenAge1");


    private final By children_gender_dpd=By.id("childrengender1");

    private  final By lst_childrengender_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");


    private final By children_relation_dpd=By.id("childrenRelation1");

    private  final By lst_children_relation_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_salary=By.id("salary");

    private final By txt_business=By.id("business");

    private final By txt_agriculture=By.id("agriculture");

    private final By txt_profession=By.id("profession");

    private final By othersources_yes=By.id("otherSourceOfIncome");

    private final By txt_pleasespecify=By.id("otherSourceOfIncomeSpecify");

    private final By txt_incomefromothersource=By.id("otherSourceOfIncomeValue");

    private final By asset_dpd=By.id("asset1");

    private final By lst_asset_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By unit_dpd=By.id("unit1");

    private final By lst_unit_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_asset_location=By.id("location1");

    private final By txt_asset_area=By.id("area1");


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

    private final By tribe_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='tribeDetails']");

    private final By lst_caste_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By religion_dpd=By.xpath("//*[@role='combobox' and @formcontrolname='religionDetails']");

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

    private final By chk_othersources=By.id("otherSourceOfIncome");

    private final By txt_othersourcesincome=By.id("otherSourceOfIncomeValue");


    private final By incomeassetApplicationno=By.xpath("//*[@class='col-sm-3' and contains(text(),'E-IAC')]");

    private final By btn_continue=By.xpath("//*[@class='btn btn-success']");

    private final By btn_next=By.xpath("//*[@class='mdc-button__label' and text()='Next']");

    private final By lk_user=By.xpath("//*[@alt='User']");

    private final By lk_logout=By.xpath("//*[@ng-reflect-name='log-out']");

    private final By lk_user_citizen=By.id("dropdownClick");

    private final By lk_citizen_logout=By.xpath("//*[@class='icon']//img[contains(@src,'logout')]");


    public void clickCitizenUser()
    {
        click(lk_user_citizen, WaitStrategy.CLICKABLE);
    }


    public void clickCitizenlogout()
    {
        click(lk_citizen_logout, WaitStrategy.CLICKABLE);
    }
    public void click_Proceed()
    {
        click(btn_proceed, WaitStrategy.CLICKABLE);
    }

    public String getDocumentTitle()
    {
        return getElementText(document_Required,WaitStrategy.PRESENCE);

    }

    public WebElement categorydropdown()
    {
        return getWebElement(category_dpd);
    }

    public By categorydropdownlist()
    {
        return lst_category_dpd;
    }

    public WebElement clicksibling()
    {
        return getWebElement(sibling_dpd);
    }

    public By siblingdropdownlist()
    {
        return lst_sibling_dpd;
    }

    public void txt_sibling_name(String value)
    {
        sendkeys(txt_sibling_name, value, WaitStrategy.PRESENCE);
    }
    public void txt_sibling_age(String value)
    {
        sendkeys(txt_sibling_age, value, WaitStrategy.PRESENCE);
    }

    public WebElement siblinggenderdropdown()
    {
        return getWebElement(sibling_gender_dpd);
    }

    public By siblinggenderdropdownlist()
    {
        return lst_siblinggender_dpd;
    }

    public WebElement assetdropdown()
    {
        return getWebElement(asset_dpd);
    }

    public By assetdropdownlist()
    {
        return lst_asset_dpd;
    }

    public WebElement unitdropdown()
    {
        return getWebElement(unit_dpd);
    }

    public By unitdropdownlist()
    {
        return lst_unit_dpd;
    }

    public WebElement siblingrelationdropdown()
    {
        return getWebElement(sibling_relation_dpd);
    }

    public void txt_assert_area(String value)
    {
        sendkeys(txt_asset_area, value, WaitStrategy.PRESENCE);
    }
    public void txt_assert_location (String value)
    {
        sendkeys(txt_asset_location, value, WaitStrategy.PRESENCE);
    }

    public By siblingrelationdropdownlist()
    {
        return lst_siblingrelation_dpd;
    }
    public WebElement districtdropdown()
    {
        return getWebElement(district_dpd);
    }

    public WebElement clickchildren()
    {
        return getWebElement(children_dpd);
    }

    public By childrendropdownlist()
    {
        return lst_children_dpd;
    }


    public void txt_children_name(String value)
    {
        sendkeys(txt_children_name, value, WaitStrategy.PRESENCE);
    }
    public void txt_children_age(String value)
    {
        sendkeys(txt_children_age, value, WaitStrategy.PRESENCE);
    }

    public WebElement childrengenderdropdown()
    {
        return getWebElement(children_gender_dpd);
    }

    public By childrengenderdropdownlist()
    {
        return lst_childrengender_dpd;
    }

    public WebElement childrenrelationdropdown()
    {
        return getWebElement(children_relation_dpd);
    }

    public By childrenrelationdropdownlist()
    {
        return lst_children_relation_dpd;
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

   public void txt_salary(String value)
   {
       sendkeys(txt_salary, value, WaitStrategy.PRESENCE);
   }

   public void txt_business(String value)
   {
       sendkeys(txt_business, value, WaitStrategy.PRESENCE);
   }

    public void txt_agriculture(String value)
    {
        sendkeys(txt_agriculture, value, WaitStrategy.PRESENCE);
    }

    public void txt_profession(String value)
    {
        sendkeys(txt_profession, value, WaitStrategy.PRESENCE);
    }

    public WebElement clickothersources()
    {
       return getWebElement(othersources_yes);
    }

    public void txt_pleasespecify(String value)
    {
        sendkeys(txt_pleasespecify, value, WaitStrategy.PRESENCE);
    }

    public void txt_incomefromothersource(String value)
    {
        sendkeys(txt_incomefromothersource, value, WaitStrategy.PRESENCE);
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

    public WebElement chkotherSources()
    {
        return getWebElement(chk_othersources);
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
    public String getincomeassetCertNo()
    {
        return getElementText(incomeassetApplicationno, WaitStrategy.PRESENCE);
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

    private final By txt_incomeassetverificationapplicationno=By.xpath("//*[@class='col-xl-6 col-lg-6 col-md-12 col-sm-12 ng-tns-c214-10' and contains(text(),'E-IAC')]");

    private final By txt_verification_remarks=By.xpath("//textarea[@ng-reflect-name='remarks' and contains(@id, 'mat-input-')]");

    private final By btn_verification_fileUpload=By.xpath("//*[@ng-reflect-name='riUpload']");
    private final By btn_verification_submit=By.xpath("//mat-dialog-actions//button//span[text()='Submit']");
    private final By btn_verification_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

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

    public String getIncomeAssetVerificationNo()
    {
        return getElementText(txt_incomeassetverificationapplicationno, WaitStrategy.PRESENCE);
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

    /*Xpath for Tahsil Approval*/

    private final By txt_othertahsil_district=By.xpath("//*[@ng-reflect-name='district']");

    private final By lk_highligh=By.xpath("//*[@class='highlightTxt']");

    private final By txt_othertahsil_subdivision=By.xpath("//*[@ng-reflect-name='subdivision']");

    private final By txt_othertahsil_tahsil=By.xpath("//*[@ng-reflect-name='tahsil']");

    private final By lk_othertahsil=By.xpath("//*[contains(@class,'mat-content ng-tns-c88-')]//mat-panel-title[contains(text(),'Bar')]");

    private final By btn_tahsilpreview_save=By.xpath("//span[@class='mdc-button__label' and text()='Save and Continue']");
    private final By btn_applydsc=By.xpath("//span[@class='mdc-button__label' and text()='Apply Digital Signature']");

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
