package com.srit.pages;

import com.srit.enums.WaitStrategy;
import com.srit.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CoreApplicationPage extends BasePage{


    private final By lk_citizen_login=By.partialLinkText("Citizen");

    private final By txt_emailadddress=By.id("_com_liferay_login_web_portlet_LoginPortlet_login");

    private final By txt_password=By.id("_com_liferay_login_web_portlet_LoginPortlet_password");

    private final By lk_signin=By.xpath("//*[@type='submit' and contains(@id,'_com_liferay_login_web_portlet_LoginPortlet_')]");

    private final By lk_forgotpassword=By.partialLinkText("Forgot");
    private final By lk_applyforservices=By.id("menuHeading1");

    private final By lk_viewallavailableservices=By.partialLinkText("View all");

    private final By lk_coreapplication=By.linkText("Core application");

    private final By lk_services=By.linkText("Services");

    private final By lk_submitapplication=By.linkText("Submit Application");

    private final By textbox_username=By.id("mat-input-0");
    private final By textbox_password=By.id("mat-input-1");
    private final By button_login=By.xpath("//button[@type='submit']");

    private final By txt_uai1=By.id("uai1");

    private final By txt_uai2=By.id("uai2");

    private final By txt_uai3=By.id("uai3");

    private final By txt_uai4=By.id("uai4");

    private final By btn_submit=By.xpath("//span[normalize-space()='Submit']");

    private final By clk_residentCert=By.partialLinkText("Residence Certificate");

    private final By lk_incomeCert=By.partialLinkText("Income Certificate");

    private final By lk_casteCert=By.partialLinkText("Schedule Caste");

    private final By lk_tribeCert=By.partialLinkText("Scheduled Tribe");

    private final By lk_assetCert=By.partialLinkText("Asset");

    private final By lk_rorCert=By.partialLinkText("ROR");

    private final By lk_solCert=By.partialLinkText("Solvency");

    private final By lk_guaCert=By.partialLinkText("Guardianship");

    private final By lk_sebcCert=By.partialLinkText("SEBC");

    private final By lk_obcCert=By.partialLinkText("OBC");

    private final By lk_legalCert=By.partialLinkText("Legal");
    private final By lk_applicationsbox=By.linkText("Applications Box");

    private final By lk_mypendingapplications=By.linkText("My Pending Applications");

    private final By lk_scrollleft=By.xpath("//aside[@id='leftsidebar']//div[@class='menu']//div[@class='ps__rail-y']");

    private final By lk_othertahsilapplications=By.xpath("//span[@class='ng-star-inserted']//li[contains(a,'Other Tahasil Applications')]");

    private final By lk_issuanceResidenceCertificate=By.xpath("//*[contains(text(),'Residence')]");

    private final By lk_issuanceIncomeCertificate=By.xpath("//*[contains(text(),'Income Cer')]");

    private final By lk_issuanceCasteCertificate=By.xpath("//*[contains(text(),'Caste')]");

    private final By lk_issuanceTribeCertificate=By.xpath("//*[contains(text(),'Tribe')]");
    private final By lk_issuanceAssetCertificate=By.xpath("//*[contains(text(),'Asset')]");

    private final By lk_issuanceRorCertificate=By.xpath("//*[contains(text(),'ROR')]");

    private final By lk_issuanceSolCertificate=By.xpath("//*[contains(text(),'Solvency')]");

    private final By lk_issuanceGuaCertificate=By.xpath("//*[contains(text(),'Guardianship')]");

    private final By lk_issuanceSebcCertificate=By.xpath("//*[contains(text(),'SEBC')]");

    private final By lk_issuanceObcCertificate=By.xpath("//*[contains(text(),'OBC')]");

    private final By lk_issuanceLegalCertificate=By.xpath("//*[contains(text(),'Legal')]");
    private final By lk_officiallogin=By.linkText("Official Login");


    public CoreApplicationPage click_OfficialLogin()
    {
        click(lk_officiallogin, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage enter_username(String username) throws Exception
    {
        sendkeys(textbox_username, username, WaitStrategy.PRESENCE);
       // ExtentLogger.pass("entered the user name", true);

        return this;

    }

    public CoreApplicationPage enter_password(String password) throws Exception
    {
        sendkeys(textbox_password, password, WaitStrategy.PRESENCE);
       // ExtentLogger.pass("password entered", true);

        return this;
    }

    public CoreApplicationPage clickLogin() throws Exception
    {
        click(button_login, WaitStrategy.CLICKABLE);
       // ExtentLogger.pass("clicked on homepage", true);
        return this;
    }

    public CoreApplicationPage clickCoreApplication ()
    {
        click(lk_coreapplication, WaitStrategy.CLICKABLE);
      //  ExtentLogger.pass("Clicked on Core Application");
        return this;
    }

    public CoreApplicationPage clickServices ()
    {
        click(lk_services, WaitStrategy.CLICKABLE);
       // ExtentLogger.pass("Clicked on Service");
        return this;
    }

    public CoreApplicationPage clickSubmitApplication()
    {
        click(lk_submitapplication, WaitStrategy.CLICKABLE);
       // ExtentLogger.pass("Clicked on SubmitApplication");
        return this;
    }

    public CoreApplicationPage txt_createuai1(String uai)


    {
        sendkeys(txt_uai1, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage txt_createuai2(String uai)
    {
        sendkeys(txt_uai2, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage txt_createuai3(String uai)
    {
        sendkeys(txt_uai3, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage txt_createuai4(String uai)
    {
        sendkeys(txt_uai4, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage btn_create_uai()
    {
        click(btn_submit, WaitStrategy.CLICKABLE);
        return this;
    }

    public ResidentPage click_residentCertifcate()
    {
        click(clk_residentCert, WaitStrategy.CLICKABLE);
        return new ResidentPage();
    }
    public IncomePage click_incomeCertifcate()
    {
        click(lk_incomeCert, WaitStrategy.CLICKABLE);
        return new IncomePage();
    }

    public CastePage click_casteCertifcate()
    {
        click(lk_casteCert, WaitStrategy.CLICKABLE);
        return new CastePage();
    }
    public TribePage click_tribeCertificate()
    {
        click(lk_tribeCert, WaitStrategy.CLICKABLE);
        return new TribePage();
    }

    public RORPage click_rorCertificate()
    {
        click(lk_rorCert, WaitStrategy.CLICKABLE);
        return new RORPage();
    }
    public SolvencyPage click_solCertificate()
    {
        click(lk_solCert, WaitStrategy.CLICKABLE);
        return new SolvencyPage();
    }

    public WebElement click_guaCertificate()
    {
        return getWebElement(lk_guaCert);

    }

    public SebcPage click_sebcCertificate()
    {
        click(lk_sebcCert, WaitStrategy.CLICKABLE);
        return new SebcPage();
    }

    public ObcPage click_obcCertificate()
    {
        click(lk_obcCert, WaitStrategy.CLICKABLE);
        return new ObcPage();
    }


    public LegalHeirPage click_legalCertificate()
    {
        click(lk_legalCert, WaitStrategy.CLICKABLE);
        return new LegalHeirPage();
    }
    public IncomeAssetPage getassetCertificate()
    {
        click(lk_assetCert, WaitStrategy.CLICKABLE);
        return new IncomeAssetPage();
    }
    public CoreApplicationPage click_applicationbox()
    {
        click(lk_applicationsbox, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_mypendingapplications()
    {
        click(lk_mypendingapplications, WaitStrategy.CLICKABLE);
        return this;
    }

    public WebElement othertahsilapplications()
    {
      return getWebElement(lk_othertahsilapplications);

    }
    public CoreApplicationPage click_scrollleftlapplications()
    {
        click(lk_scrollleft, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_residenceapplications()
    {
        click(lk_issuanceResidenceCertificate, WaitStrategy.CLICKABLE);
        return this;
    }


    public CoreApplicationPage click_incomeapplications()
    {
        click(lk_issuanceIncomeCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_casteapplications()
    {
        click(lk_issuanceCasteCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_tribeapplications()
    {
        click(lk_issuanceTribeCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_incomeandassetapplications()
    {
        click(lk_issuanceAssetCertificate, WaitStrategy.CLICKABLE);
        return this;
    }
    public CoreApplicationPage click_rorapplications()
    {
        click(lk_issuanceRorCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_solapplications()
    {
        click(lk_issuanceSolCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_guaapplications()
    {
        click(lk_issuanceGuaCertificate, WaitStrategy.CLICKABLE);
        return this;
    }


    public CoreApplicationPage click_sebcapplications()
    {
        click(lk_issuanceSebcCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_obcapplications()
    {
        click(lk_issuanceObcCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_legalapplications()
    {
        click(lk_issuanceLegalCertificate, WaitStrategy.CLICKABLE);
        return this;
    }
    public CoreApplicationPage click_citizenlogin()
    {
        click(lk_citizen_login, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage txt_email(String value)
    {
        sendkeys(txt_emailadddress, value, WaitStrategy.PRESENCE);
        return this;
    }
    public CoreApplicationPage txt_password(String value)
    {
        sendkeys(txt_password, value, WaitStrategy.PRESENCE);
        return this;
    }
    public CoreApplicationPage click_sigin()
    {
        click(lk_signin, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_applyforServices()
    {
        click(lk_applyforservices, WaitStrategy.CLICKABLE);
        return this;
    }
    public CoreApplicationPage click_viewallavailableServices()
    {
        click(lk_viewallavailableservices, WaitStrategy.CLICKABLE);
        return this;
    }

}
