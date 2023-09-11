package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.SolvencyPage;
import com.srit.pages.TribePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SolvencyCertificate extends BaseTest{


String solvency=null;

@Test
    public void applyforSolvencyService()
{
    try
    {
        CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();
        SolvencyPage so= cp.click_solCertificate();
        so.click_Proceed();
        System.out.println(so.getDocumentTitle());
        try
        {
            JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,300)", "");
            DropDownUtils.dropdownSelect(so.districtdropdown());

            DropDownUtils.dropdownList(so.districtdropdownlist(), "bargarh");
            Thread.sleep(4000);

            DropDownUtils.dropdownSelect(so.subdivisiondropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(so.subdivisiondropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.tahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(so.tahsildropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.ridropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(so.ridropdownlist(), "jamurda");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.villagedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(so.villagedropdownlist(),"jamu");
            Thread.sleep(1000);


        } catch (InterruptedException e)
        {
            throw new RuntimeException("Dropdown is not selected");

        }
        so.txt_policestation("police station");
        so.txt_solvencyamount("1000");
        so.txt_landpropertyvalue("100");
        so.txt_builidngpropertyvalue("100");
        so.txt_immovableproperty("some property");
        so.txt_immovablepropertyvalue("100");
        FileUploadUtils.fileUpload(so.fileUpload(), FrameworkConstants.getUploadfilepath());
        so.txt_purpose("some purpose");
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(so.agree());
        so.txt_place("place");
        Thread.sleep(1000);
        so.clicksubmit();
        HandlePop.getHandlePop();
        so.click_Yes();
        String text=so.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application Number", text.substring(0,18));
        solvency=so.getSolvCertNo();
        System.out.println(solvency);
        so.clickConfirm();
        HandlePop.getHandlePop();
        so.clickContinue();
        HandlePop.getHandlePop();
        so.clickNext();
        so.clickUser();
        so.clickLogout();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    @Test(dependsOnMethods = "applyforSolvencyService")
    public void forwardbyDAtoRI()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("da.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_solapplications();
            SolvencyPage so= new SolvencyPage();
            so.click_firstrecord();
            Thread.sleep(2000);
            so.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.officedropdownlist(), "ri Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.forwardtori());
            so.clickdasubmit();
            HandlePop.getHandlePop();
            so.clickdacontinue();
            HandlePop.getHandlePop();
            so.clickdaclose();
            so.clickUser();
            so.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardbyDAtoRI")
    public void forwardtoTahsilbyRI()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_solapplications();
            SolvencyPage so= new SolvencyPage();

            so.txt_searchbox(solvency);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(so.tahsilfirstrecord());
            Thread.sleep(4000);
            DropDownUtils.dropdownSelect(so.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=so.getSolVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals(solvency,ConfirmVerificationApplicationNo );
            so.txt_verification_remarks("some remarks");
            so.verification_fileupload(FrameworkConstants.getUploadfilepath());
            so.clickVerificationSubmit();
            HandlePop.getHandlePop();
            so.clickVerificationContinue();
            HandlePop.getHandlePop();
            so.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.officedropdown());
            DropDownUtils.dropdownSelect(so.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.forward());
            so.clickrisubmit();
            HandlePop.getHandlePop();
            so.clickricontinue();
            String confirm= so.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(solvency, confirm, "Solvency No didnt match");
            so.clickdaclose();
            so.clickUser();
            so.clickLogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardtoTahsilbyRI")
    public void approvebyTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox()
                    .click_mypendingapplications()
                    .click_solapplications();
            SolvencyPage so=new SolvencyPage();
            so.txt_searchbox(solvency);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(so.tahsilfirstrecord());
            JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");
            so.txt_tahsil_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "approve");
            Thread.sleep(1000);
            HandlePop.getHandlePop();
            so.clicktahsilpreviewsave();
            so.clickTahsilsubmit();
            HandlePop.getHandlePop();
            so.clickTahsilcontinue();
            HandlePop.getHandlePop();
            so.clickDigitalSignature();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
