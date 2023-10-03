package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.LegalHeirPage;
import com.srit.pages.RORPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RorCertificate extends BaseTest
{

 String ror=null;

 Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());

 String sheetname="Ror";

@Test
    public void applyforRorService()
{
    try
    {

        CoreApplicationPage cp=new CoreApplicationPage();
        cp.click_citizenlogin();
        cp.txt_email(reader.getCellData(sheetname, "Portalemailaddress", 2));
        cp.txt_password(reader.getCellData(sheetname, "Portalpassword", 2));
        cp.click_sigin();
        cp.click_applyforServices();
        cp.click_viewallavailableServices();

        /*CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();*/
        RORPage rr= cp.click_rorCertificate();
        rr.click_Proceed();
        System.out.println(rr.getDocumentTitle());
        try
        {
            DropDownUtils.selectByText(rr.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));

            DropDownUtils.selectByText(rr.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
            DropDownUtils.selectByText(rr.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
            DropDownUtils.selectByText(rr.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
            DropDownUtils.selectByText(rr.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));
            rr.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));
            DropDownUtils.selectByText(rr.rordistrictdropdown(), reader.getCellData(sheetname, "Rdistrict", 2));
            DropDownUtils.selectByText(rr.rorsubdivisiondropdown(), reader.getCellData(sheetname, "Rsubdivision", 2));

            DropDownUtils.selectByText(rr.rortahsildropdown(), reader.getCellData(sheetname, "Rtahsil", 2));
            DropDownUtils.selectByText(rr.rorridropdown(), reader.getCellData(sheetname, "Rri", 2));
            DropDownUtils.selectByText(rr.rorvillagedropdown(), reader.getCellData(sheetname, "Rvillage", 2));
            rr.txt_ror_policestation(reader.getCellData(sheetname, "Rpolicestation", 2));
            rr.txt_khatano(reader.getCellData(sheetname, "Khatano", 2));
            rr.txt_plot_no(reader.getCellData(sheetname, "Plotno", 2));
            FileUploadUtils.fileUpload(rr.fileUpload(), FrameworkConstants.getUploadfilepath());
            rr.txt_castetribe(reader.getCellData(sheetname, "Caste", 2));
            rr.txt_purpose(reader.getCellData(sheetname, "Purpose", 2));
            DropDownUtils.dropdownSelect(rr.agree());
            rr.txt_place(reader.getCellData(sheetname, "Place", 2));
            rr.clicksubmit();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            rr.click_Yes();
            String text=rr.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application No", text.substring(0,14));
            ror=rr.getRorCertNo();
            System.out.println(ror);
            rr.clickConfirm();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            rr.clickContinue();
            rr.clickCitizenUser();
            rr.clickCitizenlogout();



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
            cp.click_OfficialLogin();
            HandleTab.getHandleTab(1);
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
            cp.click_OfficialLogin();
            HandleTab.getHandleTab(1);
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
        cp.click_OfficialLogin();
        HandleTab.getHandleTab(1);
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

    @Test
    public void forwardtoOtherTahsil()
    {
        try
        {

            CoreApplicationPage cp= new CoreApplicationPage();
            cp.click_OfficialLogin();
            HandleTab.getHandleTab(1);
            cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_rorapplications();
            RORPage rr=new RORPage();
            rr.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rr.tahsilfirstrecord());
            Thread.sleep(3000);
            rr.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(rr.actiondropdownlist(), "Forward To Other Tahsil");
            Thread.sleep(1000);
            rr.txt_othertahsil_district("Kalahandi");
            Thread.sleep(1000);
            rr.clickhighlighted();
            Thread.sleep(1000);
            rr.txt_othertahsil_subdivision("Bhawanipatna");
            Thread.sleep(1000);
            rr.clickhighlighted();
            Thread.sleep(1000);
            rr.txt_othertahsil_tahsil("Kalahandi");
            Thread.sleep(1000);
            rr.clickhighlighted();
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rr.forward());
            rr.clickrisubmit();
            HandlePop.getHandlePop();
            rr.clickricontinue();
            String confirm= rr.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "ror No didnt match");
            rr.clickdaclose();
            rr.clickUser();
            rr.clickLogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void sendBacktoParentTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.click_OfficialLogin();
            HandleTab.getHandleTab(1);
            cp.enter_username("tdr.kalahand").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox();
            cp.click_scrollleftlapplications();
            JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,50);");
            DropDownUtils.dropdownSelect(cp.othertahsilapplications());


            RORPage rr=new RORPage();
            rr.clickOtherTahsil();
            cp.click_rorapplications();
            rr.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rr.tahsilfirstrecord());
            Thread.sleep(3000);
            rr.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rr.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rr.actiondropdownlist(), "Sendback");
            Thread.sleep(1000);
            rr.clickrisubmit();
            HandlePop.getHandlePop();
            rr.clickricontinue();
            String confirm= rr.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "ror No didnt match");
            rr.clickdaclose();
            rr.clickUser();
            rr.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
