package test;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ChallengingPomPage;

public class TestChallengingPomPage {
	
	String driverPath = "C:/Users/luiza.dediu/eclipse-workspace/ChallengingPom/drivers/chromedriver.exe";
	static WebDriver driver;
	ChallengingPomPage objChallengingPomPage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:/Users/luiza.dediu/eclipse-workspace/ChallengingPom/drivers/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
		}
	@Test
	public void checkIfBrowserIsOpen() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkOpenBrowser();
	}

	@Test
	
	public void checkPagetitle() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkPageTitle();
		
	}

	@Test
	public void checkLinksToGitHub() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.check_link_forkMeOnGitHubLink();
	}
	
	@Test
	public void checkTextheader() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkHeader();
	}
	
	@Test
	
	public void checkEditLnk() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkEditLink();
		
	
	}
	
	@Test
	
	public void checkDeleteLnk() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkDeleteLink();
	
	}
	@Test
	
	public void checkButtons() throws InterruptedException {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkButtonBlue();
		objChallengingPomPage.checkButtonRed();
		objChallengingPomPage.checkButtonGreen();	
		
	}

	@Test
	public void checkTable() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkTableHeader();	
		objChallengingPomPage.checkTableValues();	
	}
	
	@Test
	public void checkCanvasAnswer() {
		objChallengingPomPage = new ChallengingPomPage(driver);
		objChallengingPomPage.checkCanvas();
	}
	
	 @AfterTest
	    public static void closeBrowser()
	    {   
				driver.close();
				driver.quit();	
	    }
	
}
