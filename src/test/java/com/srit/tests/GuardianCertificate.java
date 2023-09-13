package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.GuardianshipPage;
import com.srit.pages.TribePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuardianCertificate extends BaseTest{


    String guardian=null;

    @Test
    public void applyforGuardianservice() throws Exception {
        CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(cp.click_guaCertificate());
        GuardianshipPage gp= new GuardianshipPage();
        gp.click_Proceed();
        System.out.println(gp.getDocumentTitle());
        try
        {
            JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,300)", "");
            DropDownUtils.dropdownSelect(gp.districtdropdown());

            DropDownUtils.dropdownList(gp.districtdropdownlist(), "bargarh");
            Thread.sleep(4000);

            DropDownUtils.dropdownSelect(gp.subdivisiondropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.subdivisiondropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.tahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.tahsildropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.ridropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.ridropdownlist(), "jamurda");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.villagedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(gp.villagedropdownlist(),"jamu");
            gp.txt_policestation("police station");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_prefixdropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_prefixdropdownlist(),"shri");
            gp.txt_legal_firstname("rakesh");
            gp.txt_legal_lastname("r");
            gp.txt_legal_age("25");
            gp.txt_legal_father_firstname("father");
            gp.txt_legal_father_lastname("fa");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_districtdropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_districtdropdownlist(),"bargarh");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_subdivisiondropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_subdivisiondropdownlist(),"bargarh");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_tahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_tahsildropdownlist(),"bargarh");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_ri_dropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_ridropdownlist(),"jamurda");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_village_dropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_villagedropdownlist(),"jamu");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.legal_relation_dropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(gp.legal_relationdropdownlist(),"aunt");
            gp.txt_legal_policestation("police station");

        } catch (InterruptedException e)
        {
            throw new RuntimeException("Dropdown is not selected");

        }

        FileUploadUtils.fileUpload(gp.fileUpload(), FrameworkConstants.getUploadfilepath());
        gp.txt_purpose("some purpose");
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(gp.agree());
        gp.txt_place("place");
        Thread.sleep(1000);
        gp.clicksubmit();
        HandlePop.getHandlePop();
        gp.click_Yes();
        String text=gp.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application Number", text.substring(0,18));
        guardian=gp.getGuardianCertNo();
        System.out.println(guardian);
        gp.clickConfirm();
        HandlePop.getHandlePop();
        gp.clickContinue();
        HandlePop.getHandlePop();
        gp.clickNext();
        gp.clickUser();
        gp.clickLogout();


    }

    @Test(dependsOnMethods = "applyforGuardianservice")
    public void forwardbyDAtoTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("dcda1.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_guaapplications();
            GuardianshipPage gp= new GuardianshipPage();
            gp.txt_searchbox(guardian);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(gp.tahsilfirstrecord());
            Thread.sleep(4000);
            gp.txt_da_remarks("some remarks");
            DropDownUtils.dropdownSelect(gp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(gp.forwardtotahsilforprocessing());
            gp.clickrisubmit();
            HandlePop.getHandlePop();
            gp.clickricontinue();
            String confirm= gp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(guardian, confirm, "Guardianship No didnt match");
            gp.clickdaclose();
            gp.clickUser();
            gp.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardtoTahsilbyRI")
    public void forwardtoDCbyTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_guaapplications();
            GuardianshipPage gp= new GuardianshipPage();
            gp.txt_searchbox(guardian);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(gp.tahsilfirstrecord());
            Thread.sleep(4000);
            gp.txt_da_remarks("some remarks");
            DropDownUtils.dropdownSelect(gp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.officedropdownlist(), "district collector Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(gp.forward());
            gp.clickrisubmit();
            HandlePop.getHandlePop();
            gp.clickricontinue();
            String confirm= gp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(guardian, confirm, "Guardianship No didnt match");
            gp.clickdaclose();
            gp.clickUser();
            gp.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardbyDAtoTahsil")
    public void forwardtoRIbyTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_guaapplications();
            GuardianshipPage gp= new GuardianshipPage();
            gp.txt_searchbox(guardian);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(gp.tahsilfirstrecord());
            Thread.sleep(4000);
            gp.txt_da_remarks("some remarks");
            DropDownUtils.dropdownSelect(gp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.officedropdownlist(), "ri office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(gp.forwardtotahsilforprocessing());
            gp.clickrisubmit();
            HandlePop.getHandlePop();
            gp.clickricontinue();
            String confirm= gp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(guardian, confirm, "Guardianship No didnt match");
            gp.clickdaclose();
            gp.clickUser();
            gp.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardtoRIbyTahsil")
    public void forwardtoTahsilbyRI()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_guaapplications();
            GuardianshipPage gp= new GuardianshipPage();
            gp.txt_searchbox(guardian);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(gp.tahsilfirstrecord());
            Thread.sleep(4000);
            DropDownUtils.dropdownSelect(gp.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=gp.getGuardianVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals(guardian,ConfirmVerificationApplicationNo );
            gp.txt_verification_remarks("some remarks");
            gp.verification_fileupload(FrameworkConstants.getUploadfilepath());
            gp.clickVerificationSubmit();
            HandlePop.getHandlePop();
            gp.clickVerificationContinue();
            HandlePop.getHandlePop();
            gp.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(gp.officedropdown());
            DropDownUtils.dropdownSelect(gp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(gp.forwardtotahsilforprocessing());
            gp.clickrisubmit();
            HandlePop.getHandlePop();
            gp.clickricontinue();
            String confirm= gp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(guardian, confirm, "guardian No didnt match");
            gp.clickdaclose();
            gp.clickUser();
            gp.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardtoDCbyTahsil")
    public void approvebyDC()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("dc1.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_guaapplications();
            GuardianshipPage gp= new GuardianshipPage();
            gp.txt_searchbox(guardian);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(gp.tahsilfirstrecord());
            Thread.sleep(4000);
            JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");
            gp.txt_ri_remarks("remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(gp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(gp.actiondropdownlist(), "approve");
            Thread.sleep(1000);
            HandlePop.getHandlePop();
            gp.clickDCpreviewsave();
            gp.clickDCsubmit();
            HandlePop.getHandlePop();
            gp.clickDCcontinue();
            HandlePop.getHandlePop();
            gp.clickDigitalSignature();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
