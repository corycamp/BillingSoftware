package DataFilling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CunyFirstUpdater{
	
	
	@SuppressWarnings("deprecation")
	public CunyFirstUpdater() {
		
		WebDriver driver = new EdgeDriver();
		
		String cf = "https://ssologin.cuny.edu/cuny.html?resource_url=https%3A%2F%2Fhome.cunyfirst.cuny.edu%252Fpsc%252Fcnyihprd%252FEMPLOYEE%252FEMPL%252Fc%252FNUI_FRAMEWORK.PT_LANDINGPAGE.GBL";
		String accountPage = "https://home.cunyfirst.cuny.edu/psp/cnyihprd/EMPLOYEE/SA/c/SCC_ADMIN_OVRD_STDNT.SSS_STUDENT_CENTER.GBL";

		driver.get(accountPage);
		
		this.login(driver);
		this.studentSelect(driver);
		this.financialAidPage(driver);
		
		
	}
	
	public void login(WebDriver driver) {
		
	
		
		WebElement loginName = driver.findElement(By.cssSelector("input[id*='CUNYfirstUsernameH']"));
		loginName.clear();
		loginName.sendKeys(userName);
		
		WebElement loginPassword = driver.findElement(By.cssSelector("input[id*='CUNYfirstPassword']"));
		loginPassword.sendKeys(passWrd);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement loginBtn = driver.findElement(By.id("submit"));
		loginBtn.click();
	}
	
	public void studentSelect(WebDriver driver) {
		
		String emplid = "23558619";
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[4]/div[1]/iframe")));
		
		WebElement userID = driver.findElement(By.xpath("//*[@id=\"STDNT_SRCH_EMPLID\"]"));
		
		userID.clear();
		userID.sendKeys(emplid);
		
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"#ICSearch\"]"));
		searchBtn.click();
	}
	
	public void financialAidPage(WebDriver driver) {
		
		//Financial Aid Page
		
		String amount = "100";
		
		WebElement financialAidBtn = driver.findElement(By.xpath("//*[@id=\"PSTAB\"]/table/tbody/tr/td[7]/a/span"));
		financialAidBtn.click();
		
		WebElement academicYear = driver.findElement(By.xpath("//*[contains(text(),'2023 - Financial Aid Year 2022-2023')]"));
		
		System.out.println(academicYear.getText());
		
		WebElement assignAwardBtn = driver.findElement(By.xpath("//*[@id=\"DERIVED_SCC_FA_SFA_AWRD_STD_LINK\"]"));
		assignAwardBtn.click();
		
		//Award Entry Pop-up
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/iframe")));
		
		WebElement addAwardBtn = driver.findElement(By.xpath("//*[@id=\"trSTDNT_AWD_PKG$0_row1\"]/td[10]"));
		addAwardBtn.click();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement actionField = driver.findElement(By.xpath("//*[@id=\"DERIVED_AWARDS_AWARD_ACTION$1\"]"));
		WebElement itemTypeField = driver.findElement(By.xpath("//*[@id=\"ITEM_TYPE$1\"]"));
//		WebElement offerField = driver.findElement(By.xpath("//*[@id=\"STDNT_AWD_PKG_OFFER_AMOUNT$1\"]"));
//		WebElement acceptedField = driver.findElement(By.xpath("//*[@id=\"STDNT_AWD_PKG_ACCEPT_AMOUNT$1\"]"));
//		WebElement disbursementPlanField = driver.findElement(By.xpath("//*[@id=\"STDNT_AWD_PKG_DISBURSEMENT_PLAN$1\"]"));
//		WebElement splitCodeField = driver.findElement(By.xpath("//*[@id=\"STDNT_AWD_PKG_SPLIT_CODE$1\"]"));
		
//		actionField.sendKeys("B");
		itemTypeField.sendKeys("986100000526");
//		offerField.sendKeys(amount);
//		acceptedField.sendKeys(amount);
//		disbursementPlanField.sendKeys("FY");
//		splitCodeField.sendKeys("03");
		
		
	}
}