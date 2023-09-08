package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.constants.FrameworkConstants;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.RORPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RorCertificate extends BaseTest{

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

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}




}
