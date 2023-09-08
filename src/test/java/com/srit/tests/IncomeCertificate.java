package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.IncomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncomeCertificate extends BaseTest{

String Incomeno=null;

@Test
    public void applyforIncomeService()
{
    try
    {
        CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();

        IncomePage in=cp.click_incomeCertifcate();
        in.click_Proceed();
        System.out.println(in.getDocumentTitle());
        try
        {
            JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,300)", "");
            DropDownUtils.dropdownSelect(in.districtdropdown());

            DropDownUtils.dropdownList(in.districtdropdownlist(), "bargarh");
            Thread.sleep(4000);

            DropDownUtils.dropdownSelect(in.subdivisiondropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(in.subdivisiondropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(in.tahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(in.tahsildropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(in.ridropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(in.ridropdownlist(), "jamurda");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(in.villagedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(in.villagedropdownlist(),"jamu");
        } catch (InterruptedException e) {
            throw new RuntimeException("Dropdown is not selected");
        }
        in.txt_policestation("some station");
        in.txt_agriculture("50");
        in.txt_salary("50");
        in.txt_trade("50");
        in.txt_others("52");
        FileUploadUtils.fileUpload(in.fileUpload(), FrameworkConstants.getUploadfilepath());
        in.txt_purpose("some purpose");
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(in.agree());
        in.txt_place("place");
        in.clicksubmit();
        HandlePop.getHandlePop();
        in.click_Yes();
        String text=in.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application Number", text.substring(0,18));
        Incomeno=in.getIncomeCertNo();
        System.out.println(Incomeno);
        in.clickConfirm();
        HandlePop.getHandlePop();
        in.clickContinue();
        HandlePop.getHandlePop();
        in.clickNext();
        in.clickUser();
        in.clickLogout();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test(dependsOnMethods = "applyforIncomeService")
    public void forwardbyDAtoRI()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("da.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_incomeapplications();

        IncomePage in= new IncomePage();
        in.click_firstrecord();
        Thread.sleep(2000);
        in.txt_da_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.officedropdownlist(), "ri Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(in.forwardtori());
        in.clickdasubmit();
        HandlePop.getHandlePop();
        in.clickdacontinue();
        HandlePop.getHandlePop();
        in.clickdaclose();
        in.clickUser();
        in.clickLogout();


    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test(dependsOnMethods = "forwardbyDAtoRI")
    public void forwardtoTahsilByRI()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_incomeapplications();
        IncomePage in=new IncomePage();
        in.txt_searchbox(Incomeno);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(in.tahsilfirstrecord());
        Thread.sleep(3000);
        DropDownUtils.dropdownSelect(in.getUpdateVerificationReport());
        HandlePop.getHandlePop();
        String ConfirmVerificationApplicationNo=in.getIncomeVerificationNo().substring(2);
        System.out.println(ConfirmVerificationApplicationNo);
        Assert.assertEquals(Incomeno,ConfirmVerificationApplicationNo );
        in.txt_verification_remarks("some remarks");
        in.verification_fileupload(FrameworkConstants.getUploadfilepath());
        in.clickVerificationSubmit();
        HandlePop.getHandlePop();
        in.clickVerificationContinue();
        HandlePop.getHandlePop();
        in.txt_ri_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(in.officedropdown());
        DropDownUtils.dropdownSelect(in.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.officedropdownlist(), "tahsil Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(in.forward());
        in.clickrisubmit();
        HandlePop.getHandlePop();
        in.clickricontinue();
        String confirm= in.getConfirmText().substring(12,26);
        System.out.println("the Application No:" +confirm);
        Assert.assertEquals(Incomeno, confirm, "Income No didnt match");
        in.clickdaclose();
        in.clickUser();
        in.clickLogout();


    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test(dependsOnMethods = "forwardtoTahsilByRI")
    public void approvebyTahsil()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox()
                .click_mypendingapplications()
                .click_incomeapplications();
        IncomePage in= new IncomePage();
        in.txt_searchbox(Incomeno);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(in.tahsilfirstrecord());
        JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,1000)", "");
        in.txt_tahsil_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.actiondropdownlist(), "approve");
        Thread.sleep(1000);
        HandlePop.getHandlePop();
        in.clicktahsilpreviewsave();
        in.clickTahsilsubmit();
        HandlePop.getHandlePop();
        in.clickTahsilcontinue();
        HandlePop.getHandlePop();
        in.clickDigitalSignature();


    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}

}
