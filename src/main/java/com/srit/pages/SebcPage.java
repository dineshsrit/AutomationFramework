package com.srit.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.srit.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SebcPage extends BasePage {

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

    private final By btn_permanentaddress=By.id("sebcPermanantAddressTypeRural");

    private final By btn_presentaddress=By.id("sebcPresentAddressTypeRural");

    private final By permanent_district_dpd=By.id("sebcPermanantRuralDistrict");

    private  final By lst_per_district_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By permanent_location_dpd=By.id("sebcPermanantRuralBlock");

    private  final By lst_per_location_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By permanent_location_gp_dpd=By.id("sebcPermanantRuralGP");

    private  final By lst_per_location_gp_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By permanent_location_village_dpd=By.id("sebcPermanantRuralVillage");

    private  final By lst_per_location_village_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By present_district_dpd=By.id("sebcPresentRuralDistrict");

    private  final By lst_pre_district_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");
    private final By present_location_dpd=By.id("sebcPresentRuralBlock");

    private  final By lst_pre_location_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By present_location_gp_dpd=By.id("sebcPresentRuralGP");

    private  final By lst_pre_location_gp_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");


    private final By present_location_village_dpd=By.id("sebcPresentRuralVillage");

    private  final By lst_pre_location_village_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By caste_dpd=By.id("casteName");

    private  final By lst_caste_dpd=By.id("casteName");

    private final By religion_dpd=By.id("casteSebcReligion");

    private  final By lst_religion_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By chk_father=By.id("casteFatherCheckbox");

    private final By txt_fatherDesgination=By.id("casteFatherCPDesignation");

    private final By father_service_dpd=By.id("casteFatherGSService");

    private  final By lst_father_service_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_fatherGovDesgination=By.id("casteFatherGSDesignation");

    private final By txt_father_scaleofpay=By.id("casteFatherGSScaleOfPay");

    private final By txt_father_age=By.id("casteFatherGSPromotionAge");

    private final By txt_father_organization=By.id("casteFatherEIOOrganization");

    private final By txt_fatherIntDesgination=By.id("casteFatherEIODesignation");

    private final By txt_father_pub_organization=By.id("casteFatherEPSUOrgName");

    private final By txt_fatherPubDesgination=By.id("casteFatherEPSUDesignation");

    private final By txt_annualincome=By.id("casteFatherEPSUAnnualIncome");

    private final By txt_fatherparaDesgination=By.id("casteFatherAFIPMFDesignation");
    private final By txt_para_scaleofpay=By.id("casteFatherAFIPMFScaleOfPay");


    private final By txt_father_occupation=By.id("casteFatherPCOccupation");

    private final By txt_father_agri_land_location=By.id("casteFatherPOLocation");

    private final By txt_father_agri_land_size=By.id("casteFatherPOSOH");

    private final By txt_father_irrigateone=By.id("casteFatherILI");

    private final By txt_father_irrigatetwo=By.id("casteFatherILII");

    private final By txt_father_irrigatethree=By.id("casteFatherILIII");

    private final By txt_father_unirrigateone=By.id("casteFatherULIV");

    private final By txt_father_unirrigatetwo=By.id("casteFatherULV");

    private final By txt_father_unirrigatethree=By.id("casteFatherULVI");


    private final By crops_dpd=By.id("casteFatherPlantaionCrop");

    private  final By lst_crops_dpd=By.xpath("//*[@class='mdc-list-item__primary-text']");

    private final By txt_plantation_location=By.id("casteFatherPlantaionLocation");

    private final By txt_area_plantation=By.id("casteFatherPlantaionArea");

    private final By txt_vacant_locationproperty=By.id("casteFatherVacantLandLocation");

    private final By txt_vacant_propertydetails=By.id("casteFatherVacantLandDetails");
    private final By txt_vacant_useto=By.id("casteFatherVacantLandUse");

    private final By txt_father_annual_income=By.id("casteFatherWealthAFI");

    private final By txt_father_taxdetails=By.id("casteFatherWealthTaxDetails");

    private final By txt_otherremarks=By.id("casteFatherRemarks");

    private final By btn_applicant_photo=By.id("photograph");

    private final By txt_purpose=By.id("purpose");

    private final By chk_agree=By.id("agree");

    private final By txt_place=By.id("place");

    private final By btn_submit=By.id("submitDetails");

    private final By btn_submit_yes=By.xpath("//*[@class='btn btn-success']");

    private final By txt_applicationno=By.xpath("//*[@class='col-sm-3 heading-title' and contains(text(),'Application No. :')]");

    private final By txt_confirm=By.xpath("//mat-dialog-content//p[contains(text(),'Application')]");
    private final By btn_Confirm=By.id("confirmBtnSubmit");

    private final By sebcApplicationno=By.xpath("//*[@class='col-sm-3' and contains(text(),'E-SEB')]");

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

    public WebElement clickpermanentAddress()
    {
       return getWebElement(btn_permanentaddress);
    }

    public WebElement clickpresentAddress()
    {
        return getWebElement(btn_presentaddress);
    }

    public WebElement permanentdistrictdropdown()
    {
        return getWebElement(permanent_district_dpd);
    }

    public By permanentdistrictdropdownlist()
    {
        return lst_per_district_dpd;
    }


    public WebElement permanentblockdropdown()
    {
        return getWebElement(permanent_location_dpd);
    }

    public By permanentblockdropdownlist()
    {
        return lst_per_location_dpd;
    }

    public WebElement permanentgpdropdown()
    {
        return getWebElement(permanent_location_gp_dpd);
    }

    public By permanentgpdropdownlist()
    {
        return lst_per_location_gp_dpd;
    }

    public WebElement permanentvillagedropdown()
    {
        return getWebElement(permanent_location_village_dpd);
    }

    public By permanentvillagedropdownlist()
    {
        return lst_per_location_village_dpd;
    }



    public WebElement presentdistrictdropdown()
    {
        return getWebElement(present_district_dpd);
    }

    public By presentdistrictdropdownlist()
    {
        return lst_pre_district_dpd;
    }


    public WebElement presentblockdropdown()
    {
        return getWebElement(present_location_dpd);
    }

    public By presentblockdropdownlist()
    {
        return lst_pre_location_dpd;
    }

    public WebElement presentgpdropdown()
    {
        return getWebElement(present_location_gp_dpd);
    }

    public By presentgpdropdownlist()
    {
        return lst_pre_location_gp_dpd;
    }

    public WebElement presenttvillagedropdown()
    {
        return getWebElement(present_location_village_dpd);
    }

    public By presentvillagedropdownlist()
    {
        return lst_pre_location_village_dpd;
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

    public WebElement clickFather()
    {
        return getWebElement(chk_father);
    }

    public void txt_designation(String value)
    {
        sendkeys(txt_fatherDesgination, value, WaitStrategy.PRESENCE);
    }

    public WebElement servicedropdown()
    {
        return getWebElement(father_service_dpd);
    }

    public By servicedropdownlist()
    {
        return lst_father_service_dpd;
    }


    public void txt_gov_designation(String value)
    {
        sendkeys(txt_fatherGovDesgination, value, WaitStrategy.PRESENCE);
    }

    public void txt_scaleofpay(String value)
    {
        sendkeys(txt_father_scaleofpay, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_age(String value)
    {
        sendkeys(txt_father_age, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_organization(String value)
    {
        sendkeys(txt_father_organization, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_intdesignation(String value)
    {
        sendkeys(txt_fatherIntDesgination, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_puborganization(String value)
    {
        sendkeys(txt_father_pub_organization, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_pubdesignation(String value)
    {
        sendkeys(txt_fatherPubDesgination, value, WaitStrategy.PRESENCE);
    }

    public void txt_annualincome(String value)
    {
        sendkeys(txt_annualincome, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_paradesignation(String value)
    {
        sendkeys(txt_fatherparaDesgination, value, WaitStrategy.PRESENCE);
    }
    public void txt_father_parascaleofpay(String value)
    {
        sendkeys(txt_para_scaleofpay, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_occupation(String value)
    {
        sendkeys(txt_father_occupation, value, WaitStrategy.PRESENCE);
    }
    public void txt_father_agri_landlocation(String value)
    {
        sendkeys(txt_father_agri_land_location, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_agri_landsize(String value)
    {
        sendkeys(txt_father_agri_land_size, value, WaitStrategy.PRESENCE);
    }
    public void txt_father_irrigateone(String value)
    {
        sendkeys(txt_father_irrigateone, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_irrigatetwo(String value)
    {
        sendkeys(txt_father_irrigatetwo, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_irrigatethree(String value)
    {
        sendkeys(txt_father_irrigatethree, value, WaitStrategy.PRESENCE);
    }


    public void txt_father_uniirrigateone(String value)
    {
        sendkeys(txt_father_unirrigateone, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_unirrigatetwo(String value)
    {
        sendkeys(txt_father_unirrigatetwo, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_unirrigatethree(String value)
    {
        sendkeys(txt_father_unirrigatethree, value, WaitStrategy.PRESENCE);
    }

    public WebElement cropsndropdown()
    {
        return getWebElement(crops_dpd);
    }

    public By cropsdropdownlist()
    {
        return lst_crops_dpd;
    }


    public void txt_plantation_location(String value)
    {
        sendkeys(txt_plantation_location, value, WaitStrategy.PRESENCE);
    }

    public void txt_plantation_area(String value)
    {
        sendkeys(txt_area_plantation, value, WaitStrategy.PRESENCE);
    }

    public void txt_vacant_locationproperty(String value)
    {
        sendkeys(txt_vacant_locationproperty, value, WaitStrategy.PRESENCE);
    }

    public void txt_vacant_detailsofproperty(String value)
    {
        sendkeys(txt_vacant_propertydetails, value, WaitStrategy.PRESENCE);
    }
    public void txt_vacant_useto(String value)
    {
        sendkeys(txt_vacant_useto, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_annualincome(String value)
    {
        sendkeys(txt_father_annual_income, value, WaitStrategy.PRESENCE);
    }


    public void txt_otherremarks(String value)
    {
        sendkeys(txt_otherremarks, value, WaitStrategy.PRESENCE);
    }

    public void txt_father_wealthtax(String value)
    {
        sendkeys(txt_father_taxdetails, value, WaitStrategy.PRESENCE);
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
    public String getSebcCertNo()
    {
        return getElementText(sebcApplicationno, WaitStrategy.PRESENCE);
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

    private final By btn_csv=By.xpath("//*[@ng-reflect-message='CSV']");


    public void txt_da_remarks(String value)
    {
        sendkeys(txt_da_remarks, value, WaitStrategy.PRESENCE);
    }
    public WebElement click_firstrecord()
    {
       return getWebElement(lk_da_firstrecord);
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

    public void click_csv()
    {
        click(btn_csv,WaitStrategy.CLICKABLE);
    }

    /*xpath for RI */

    private final By txt_searchbox=By.xpath("//input[@placeholder='Search']");

    private final By lk_th_firstrecord=By.xpath("//mat-row[1]//mat-cell[2]//span//a");

    private final By lk_updateVerification=By.xpath("//mat-label//h6[contains(text(),'Update')]");

    private final By txt_sebverificationapplicationno=By.xpath("//*[@class='col-xl-6 col-lg-6 col-md-12 col-sm-12' and contains(text(),'E-SEB')]");

    private final By txt_verification_remarks=By.xpath("//textarea[@ng-reflect-name='remarks' and contains(@id, 'mat-input-')]");

    private final By btn_verification_fileUpload=By.xpath("//*[@ng-reflect-name='riUpload']");
    private final By btn_verification_submit=By.xpath("//mat-dialog-actions//button//span[text()='Submit']");
    private final By btn_verification_continue=By.xpath("//span[@class='mdc-button__label' and text()='Continue']");

    private final By txt_landproperty=By.xpath("//*[@ng-reflect-name='landPropertyOfFamil']");

    private final By txt_familyincome=By.xpath("//*[@ng-reflect-name='familyIncome']");


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

    public String getsebVerificationNo()
    {
        return getElementText(txt_sebverificationapplicationno, WaitStrategy.PRESENCE);
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

    public void txt_familyincome(String value)
    {
        sendkeys(txt_familyincome, value, WaitStrategy.PRESENCE);
    }

    public void txt_landproperty(String value)
    {
        sendkeys(txt_landproperty, value, WaitStrategy.PRESENCE);
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
