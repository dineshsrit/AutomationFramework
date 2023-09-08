package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CastePage;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.IncomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CasteCertificate extends  BaseTest{

    String caste=null;
@Test
    public void applyforCasteService()
{
    try
    {
        CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();

        CastePage sc= cp.click_casteCertifcate();
        sc.click_Proceed();
        System.out.println(sc.getDocumentTitle());
        try
        {
            JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,300)", "");
            DropDownUtils.dropdownSelect(sc.districtdropdown());

            DropDownUtils.dropdownList(sc.districtdropdownlist(), "bargarh");
            Thread.sleep(4000);

            DropDownUtils.dropdownSelect(sc.subdivisiondropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(sc.subdivisiondropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(sc.tahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(sc.tahsildropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(sc.ridropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(sc.ridropdownlist(), "jamurda");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(sc.villagedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(sc.villagedropdownlist(),"jamu");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(sc.castedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(sc.castedropdownlist(), "asur");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(sc.religiondropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(sc.religiondropdownlist(), "hindu");

        } catch (InterruptedException e)
        {
            throw new RuntimeException("Dropdown is not selected");

        }
        sc.txt_policestation("police station");
        FileUploadUtils.fileUpload(sc.fileUpload(), FrameworkConstants.getUploadfilepath());
        sc.txt_purpose("some purpose");
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(sc.agree());
        sc.txt_place("place");
        sc.clicksubmit();
        HandlePop.getHandlePop();
        sc.click_Yes();
        String text=sc.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application Number", text.substring(0,18));
        caste=sc.getCasteCertNo();
        System.out.println(caste);
        sc.clickConfirm();
        HandlePop.getHandlePop();
        sc.clickContinue();
        HandlePop.getHandlePop();
        sc.clickNext();
        sc.clickUser();
        sc.clickLogout();



    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}

@Test(dependsOnMethods = "applyforCasteService")
    public void forwardbyDAtoRI()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("da.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().
                click_applicationbox().
                click_mypendingapplications().click_casteapplications();
        CastePage sc= new CastePage();
        sc.click_firstrecord();
        Thread.sleep(2000);
        sc.txt_da_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.officedropdownlist(), "ri Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(sc.forwardtori());
        sc.clickdasubmit();
        HandlePop.getHandlePop();
        sc.clickdacontinue();
        HandlePop.getHandlePop();
        sc.clickdaclose();
        sc.clickUser();
        sc.clickLogout();



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
                .clickCoreApplication().
                click_applicationbox().
                click_mypendingapplications().click_casteapplications();
        CastePage sc= new CastePage();
        sc.txt_searchbox(caste);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(sc.tahsilfirstrecord());
        Thread.sleep(3000);
        DropDownUtils.dropdownSelect(sc.getUpdateVerificationReport());
        HandlePop.getHandlePop();
        String ConfirmVerificationApplicationNo=sc.getCasteVerificationNo().substring(2);
        System.out.println(ConfirmVerificationApplicationNo);
        Assert.assertEquals(caste,ConfirmVerificationApplicationNo );
        sc.txt_verification_mouza("mouza");
        sc.txt_verification_khata("90/90");
        sc.txt_verification_plot("9090/90");
        sc.txt_verification_extent("testing");
        sc.txt_verification_khatadarname("name");
        sc.txt_verification_recorded_tenant("dinesh");
        sc.txt_verification_relation_recorded_tenant("relation");
        sc.txt_verification_original_patta("patta");
        sc.txt_verification_father_land("father");
        sc.txt_verification_occupation("occupation");
        sc.txt_verification_applicant_native("nativefapplicant");
        sc.txt_verification_remarks("some remarks");
        sc.verification_fileupload(FrameworkConstants.getUploadfilepath());
        sc.clickVerificationSubmit();
        HandlePop.getHandlePop();
        sc.clickVerificationContinue();
        HandlePop.getHandlePop();
        sc.txt_ri_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(sc.officedropdown());
        DropDownUtils.dropdownSelect(sc.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.officedropdownlist(), "tahsil Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(sc.forward());
        sc.clickrisubmit();
        HandlePop.getHandlePop();
        sc.clickricontinue();
        String confirm= sc.getConfirmText().substring(12,26);
        System.out.println("the Application No:" +confirm);
        Assert.assertEquals(caste, confirm, "Caste No didnt match");
        sc.clickdaclose();
        sc.clickUser();
        sc.clickLogout();

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
                .click_casteapplications();
        CastePage sc=new CastePage();
        sc.txt_searchbox(caste);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(sc.tahsilfirstrecord());
        JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,1000)", "");
        sc.txt_tahsil_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.actiondropdownlist(), "approve");
        Thread.sleep(1000);
        HandlePop.getHandlePop();
        sc.clicktahsilpreviewsave();
        sc.clickTahsilsubmit();
        HandlePop.getHandlePop();
        sc.clickTahsilcontinue();
        HandlePop.getHandlePop();
        sc.clickDigitalSignature();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}



}
