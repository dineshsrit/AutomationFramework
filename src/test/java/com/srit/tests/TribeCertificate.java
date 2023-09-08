package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.TribePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TribeCertificate extends BaseTest{

    String tribe=null;

    @Test
    public void applyforTribeServices()
    {
        try
        {
            CoreApplicationPage cp=new CoreApplicationPage();
            cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                    .clickServices().clickSubmitApplication().txt_createuai1("4462")
                    .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();
           TribePage tp= cp.click_tribeCertificate();
           tp.click_Proceed();
           System.out.println(tp.getDocumentTitle());
            try
            {
                JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
                js.executeScript("window.scrollBy(0,300)", "");
                DropDownUtils.dropdownSelect(tp.districtdropdown());

                DropDownUtils.dropdownList(tp.districtdropdownlist(), "bargarh");
                Thread.sleep(4000);

                DropDownUtils.dropdownSelect(tp.subdivisiondropdown());
                Thread.sleep(4000);
                DropDownUtils.dropdownList(tp.subdivisiondropdownlist(), "bargarh");

                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(tp.tahsildropdown());
                Thread.sleep(4000);
                DropDownUtils.dropdownList(tp.tahsildropdownlist(), "bargarh");

                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(tp.ridropdown());
                Thread.sleep(4000);
                DropDownUtils.dropdownList(tp.ridropdownlist(), "jamurda");

                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(tp.villagedropdown());
                Thread.sleep(6000);
                DropDownUtils.dropdownList(tp.villagedropdownlist(),"jamu");
                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(tp.castedropdown());
                Thread.sleep(6000);
                DropDownUtils.dropdownList(tp.castedropdownlist(), "jadu savar");
                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(tp.religiondropdown());
                Thread.sleep(6000);
                DropDownUtils.dropdownList(tp.religiondropdownlist(), "hindu");

            } catch (InterruptedException e)
            {
                throw new RuntimeException("Dropdown is not selected");

            }

            tp.txt_policestation("police station");
            FileUploadUtils.fileUpload(tp.fileUpload(), FrameworkConstants.getUploadfilepath());
            tp.txt_purpose("some purpose");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(tp.agree());
            tp.txt_place("place");
            Thread.sleep(1000);
            tp.clicksubmit();
            HandlePop.getHandlePop();
            tp.click_Yes();
            String text=tp.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application Number", text.substring(0,18));
            tribe=tp.getTribeCertNo();
            System.out.println(tribe);
            tp.clickConfirm();
            HandlePop.getHandlePop();
            tp.clickContinue();
            HandlePop.getHandlePop();
            tp.clickNext();
            tp.clickUser();
            tp.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test(dependsOnMethods = "applyforTribeServices")
    public void forwardbyDAtoRI()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("da.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_tribeapplications();
            TribePage tp= new TribePage();
            tp.click_firstrecord();
            Thread.sleep(2000);
            tp.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(tp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(tp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(tp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(tp.officedropdownlist(), "ri Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(tp.forwardtori());
            tp.clickdasubmit();
            HandlePop.getHandlePop();
            tp.clickdacontinue();
            HandlePop.getHandlePop();
            tp.clickdaclose();
            tp.clickUser();
            tp.clickLogout();

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
                    click_mypendingapplications().click_tribeapplications();
            TribePage tp= new TribePage();
            tp.txt_searchbox(tribe);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(tp.tahsilfirstrecord());
            Thread.sleep(4000);
            DropDownUtils.dropdownSelect(tp.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=tp.getCasteVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals(tribe,ConfirmVerificationApplicationNo );
            tp.txt_verification_mouza("mouza");
            tp.txt_verification_khata("90/90");
            tp.txt_verification_plot("9090/90");
            tp.txt_verification_extent("testing");
            tp.txt_verification_khatadarname("name");
            tp.txt_verification_recorded_tenant("dinesh");
            tp.txt_verification_relation_recorded_tenant("relation");
            tp.txt_verification_original_patta("patta");
            tp.txt_verification_father_land("father");
            tp.txt_verification_occupation("occupation");
            tp.txt_verification_applicant_native("nativefapplicant");
            tp.txt_verification_remarks("some remarks");
            tp.verification_fileupload(FrameworkConstants.getUploadfilepath());
            tp.clickVerificationSubmit();
            HandlePop.getHandlePop();
            tp.clickVerificationContinue();
            HandlePop.getHandlePop();
            tp.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(tp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(tp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(tp.officedropdown());
            DropDownUtils.dropdownSelect(tp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(tp.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(tp.forward());
            tp.clickrisubmit();
            HandlePop.getHandlePop();
            tp.clickricontinue();
            String confirm= tp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(tribe, confirm, "tribe No didnt match");
            tp.clickdaclose();
            tp.clickUser();
            tp.clickLogout();

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
                    .click_tribeapplications();
            TribePage tp=new TribePage();
            tp.txt_searchbox(tribe);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(tp.tahsilfirstrecord());
            JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");
            tp.txt_tahsil_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(tp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(tp.actiondropdownlist(), "approve");
            Thread.sleep(1000);
            HandlePop.getHandlePop();
            tp.clicktahsilpreviewsave();
            tp.clickTahsilsubmit();
            HandlePop.getHandlePop();
            tp.clickTahsilcontinue();
            HandlePop.getHandlePop();
            tp.clickDigitalSignature();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
