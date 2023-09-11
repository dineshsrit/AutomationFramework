package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.RORPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RorCertificate extends BaseTest
{

String ror=null;
@Test
    public void applyforRorService()
{
    try
    {
        CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();
        RORPage rr= cp.click_rorCertificate();
        rr.click_Proceed();
        System.out.println(rr.getDocumentTitle());
        try
        {
            DropDownUtils.dropdownSelect(rr.districtdropdown());

            DropDownUtils.dropdownList(rr.districtdropdownlist(), "bargarh");
            Thread.sleep(4000);

            DropDownUtils.dropdownSelect(rr.subdivisiondropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(rr.subdivisiondropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.tahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(rr.tahsildropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.ridropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(rr.ridropdownlist(), "jamurda");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.villagedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(rr.villagedropdownlist(),"jamu");
            Thread.sleep(1000);
            rr.txt_policestation("police station");
            DropDownUtils.dropdownSelect(rr.rordistrictdropdown());

            DropDownUtils.dropdownList(rr.rordistrictdropdownlist(), "bargarh");
            Thread.sleep(4000);

            DropDownUtils.dropdownSelect(rr.rorsubdivisiondropdown());
            //Thread.sleep(5000);
            DropDownUtils.dropdownList(rr.rorsubdivisiondropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.rortahsildropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(rr.rortahsildropdownlist(), "bargarh");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.rorridropdown());
            Thread.sleep(4000);
            DropDownUtils.dropdownList(rr.rorridropdownlist(), "jamurda");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.rorvillagedropdown());
            Thread.sleep(6000);
            DropDownUtils.dropdownList(rr.rorvillagedropdownlist(),"jamu");
            Thread.sleep(1000);
            rr.txt_ror_policestation("police station");
            rr.txt_khatano("2002/20");
            rr.txt_plot_no("200/20");
            FileUploadUtils.fileUpload(rr.fileUpload(), FrameworkConstants.getUploadfilepath());
            rr.txt_castetribe("caste");
            rr.txt_purpose("some purpose");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rr.agree());
            rr.txt_place("place");
            Thread.sleep(1000);
            rr.clicksubmit();
            HandlePop.getHandlePop();
            rr.click_Yes();
            String text=rr.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application Number", text.substring(0,18));
            ror=rr.getRorCertNo();
            System.out.println(ror);
            rr.clickConfirm();
            HandlePop.getHandlePop();
            rr.clickContinue();
            HandlePop.getHandlePop();
            rr.clickNext();
            rr.clickUser();
            rr.clickLogout();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    } catch (Exception e)
    {
        throw new RuntimeException(e);
    }




}

    @Test(dependsOnMethods = "applyforRorService")
    public void forwardbyRPtoHC()
    {

        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("rec.barg").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_rorapplications();
            RORPage rr= new RORPage();
            rr.click_firstrecord();
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rr.click_manualUpload());
            FileUploadUtils.fileUpload(rr.rorfileUpload(), FrameworkConstants.getUploadfilepath());
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.getUpdateVerification());
            HandlePop.getHandlePop();
            rr.txt_searchingfee("10");
            rr.txt_extrafee("10");
            rr.txt_noofpaper("10");
            rr.txt_others("10");
            rr.txt_plainpers("10");
            rr.txt_printedpapers("10");
            rr.txt_tracingcloth("10");
            rr.txt_copyingfee("10");
            rr.txt_noofwords("10");
            rr.clickVerificationSubmit();
            rr.clickVerificationContinue();
            HandlePop.getHandlePop();
            rr.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rr.actiondropdownlist(), "forward");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rr.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rr.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rr.forwardtori());
            rr.clickdasubmit();
            HandlePop.getHandlePop();
            rr.clickdacontinue();
            HandlePop.getHandlePop();
            rr.clickdaclose();
            rr.clickUser();
            rr.clickLogout();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test(dependsOnMethods = "forwardbyRPtoHC")
    public void forwardbyRPtoTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("hc.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_rorapplications();
            RORPage rr= new RORPage();
            rr.txt_searchbox(ror);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rr.tahsilfirstrecord());
            rr.txt_hc_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rr.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rr.officedropdown());
            DropDownUtils.dropdownSelect(rr.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rr.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rr.forward());
            rr.clickhcsubmit();
            HandlePop.getHandlePop();
            rr.clickhccontinue();
            String confirm= rr.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(ror, confirm, "tribe No didnt match");
            rr.clickdaclose();
            rr.clickUser();
            rr.clickLogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

@Test(dependsOnMethods = "forwardbyRPtoTahsil")
    public void approveByTahsil()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().
                click_applicationbox().
                click_mypendingapplications().click_rorapplications();
        RORPage rr= new RORPage();
        rr.txt_searchbox(ror);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(rr.tahsilfirstrecord());
        JavascriptExecutor js=  (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,1000)", "");
        rr.txt_tahsil_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(rr.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(rr.actiondropdownlist(), "approve");
        rr.clickTahsilsubmit();
        HandlePop.getHandlePop();
        rr.clickTahsilcontinue();
        HandlePop.getHandlePop();
        rr.clickDigitalSignature();


    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}
