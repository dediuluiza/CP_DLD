package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChallengingPomPage {

	/**

     * All WebElements are identified by @FindBy annotation

     */
	WebDriver driver;
	
	//Web elements
	
	@FindBy (xpath = "//div[@class=\"example\"]/h3")
	WebElement header;
	
	@FindBy (xpath = "//table/thead/tr[1]/th")
	List tableHeader;
	
	@FindBy (xpath = "/html/body/div[2]/a/img")
	WebElement forkMeOnGitHubLink;
	
	@FindBy (xpath = "//div[@class=\"large-2 columns\"]/a[@class=\"button\"]")
	WebElement buttonBlue;
	
	@FindBy (xpath = "//div[@class=\"large-2 columns\"]/a[@class=\"button alert\"]")
	WebElement buttonRed;
	
	@FindBy (xpath = "//div[@class=\"large-2 columns\"]/a[@class=\"button success\"]")
	WebElement buttonGreen;
	
	@FindBy (xpath = "//div[@class=\"large-10 columns\"]/table/tbody/tr[6]/td[7]/a[1]")
	WebElement editLnk;
	
	@FindBy (xpath = "//div[@class=\"large-10 columns\"]/table/tbody/tr[6]/td[7]/a[2]")
	//*[@id="content"]/div/div/div/div[2]/table/tbody/tr[4]/td[7]/a[2]
	WebElement deleteLnk;
	
	public ChallengingPomPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void checkOpenBrowser() {
		/* Check if the correct URl is opened*/
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        
        String actualURL = driver.getCurrentUrl(); 
        String expectedURL="https://the-internet.herokuapp.com/challenging_dom";
        
        Assert.assertEquals(expectedURL,actualURL);
         
    }
	
	 public void checkPageTitle() {
		 
		    driver.get("https://the-internet.herokuapp.com/challenging_dom");   
		    String actualTitle = driver.getTitle();  
		    assertEquals("The Internet",actualTitle);
		    
		    }
	
	public void checkHeader () {
		
		//Check if the page header matches the expected name "Challenging DOM"
		String getHeaderText = header.getText();
		assertEquals("Challenging DOM", getHeaderText);
		
	}
	
	public void check_link_forkMeOnGitHubLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(forkMeOnGitHubLink).perform();
		forkMeOnGitHubLink.click();
		
	}
	
	public void checkTableHeader() {
		/* Check the static header of the table*/
		List<String> expTableHeader = Arrays.asList("Lorem Ipsum Dolor Sit Amet Diceret Action");
		List<String> tableHeader = driver.findElements(By.xpath("//table/thead/tr[1]"))
		            .stream()
		            .map(elem -> elem.getText())
		            .collect(Collectors.toList());
		assertEquals(expTableHeader, tableHeader);
		//boolean isEqual = expTableHeader.equals(tableHeader);

		   
	}
	
	public void checkButtonBlue() throws InterruptedException {
		/*Test that checks the operation of the element "button" in blue
	    This also checks that the element attribute "id" is changed after the button is clicked*/
		String blueId1 = buttonBlue.getAttribute("id");
		buttonBlue.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		String blueId2 = buttonBlue.getAttribute("id");		
		assertNotEquals(blueId1, blueId2);	
		Thread.sleep(5000);
	}
	
	public void checkButtonGreen() throws InterruptedException {
		/*Test that checks the operation of the element "button" in green
	    This also checks that the element attribute "id" is changed after the button is clicked*/
		String greenId1 = buttonGreen.getAttribute("id");
		buttonGreen.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		String greenId2 = buttonBlue.getAttribute("id");		
		assertNotEquals(greenId1, greenId2);	
		Thread.sleep(5000);
		
	}
	
	public void checkButtonRed() throws InterruptedException {
		/*Test that checks the operation of the element "button" in red
	    This also checks that the element attribute "id" is changed after the button is clicked*/
		String redId1 = buttonRed.getAttribute("id");
		buttonRed.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		
		String redId2 = buttonRed.getAttribute("id");		
		assertNotEquals(redId1, redId2);
	}
	
	public void checkDeleteLink() {
		/*Check the operation of the delete link on the second line of the table
	    I'm not clear what's meant to happen when the edit button is clicked*/
		String url = driver.getCurrentUrl();
	    deleteLnk.click();
	    String strUrl = driver.getCurrentUrl();    
	    System.out.println("delete: "+ strUrl);
	    assertEquals(url+"#delete", strUrl);
	   buttonBlue.click();
	    

	}
	
	public void checkEditLink() {
		/*Check the operation of the edit link on the second line of the table
	    I'm not clear what's meant to happen when the edit button is clicked*/
		String url = driver.getCurrentUrl();
	    editLnk.click();
	    String strUrl = driver.getCurrentUrl();   
	    System.out.println("edit: "+ strUrl);
	    assertEquals(url+"#edit", strUrl);
	    buttonBlue.click();

	}
	
	public void checkCanvas(){
		/*Check if the answer change on refresh*/
		  String answer = new String();
		  
		  ArrayList<WebElement>scripts = new ArrayList<WebElement>((ArrayList<WebElement>) driver.findElements(By.tagName("script")));
		 
		  	    
		  	    for(int i = 0; i < scripts.size(); i++) {
		  	        String focusText = scripts.get(i).getAttribute("innerHTML"); 
		  	        if(focusText.contains("canvas.strokeText")) {
		  	               answer = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
		  	                break;  	                
		  	        	}
		  	    	}
		  	    	System.out.println(answer);
		  	  //click to refresh the page
		  	    	buttonBlue.click();
		  	    	
		  	    	String answerAfterRfh= new String();
		  	    	 ArrayList<WebElement>scripts2 = new ArrayList<WebElement>((ArrayList<WebElement>) driver.findElements(By.tagName("script")));
		  	    	for(int i = 0; i < scripts2.size(); i++) {
		  	    		String focusText2 = scripts2.get(i).getAttribute("innerHTML");
	  	        
		  	    		if(focusText2.contains("canvas.strokeText")) {
		  	    			answerAfterRfh = focusText2.substring(focusText2.indexOf("Answer"), focusText2.indexOf("',"));
	  	                break;   
		  	    		}
		  	    	}
		  	    	System.out.println(answerAfterRfh);
		  	  assertNotEquals(answer, answerAfterRfh);;
	}
	
	public void checkTableValues() {
		
		/*check if the table values matches a given string with all the values from the table*/
		 WebElement mytable = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody"));
	    	//To locate rows of table. 
	    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	    	//To calculate no of rows In table.
	    	int rows_count = rows_table.size();
	    	String expectedCel = "Iuvaret0 Apeirian0 Adipisci0 Definiebas0 Consequuntur0 Phaedrum0 Iuvaret1 Apeirian1 Adipisci1 Definiebas1 Consequuntur1 Phaedrum1 Iuvaret2 Apeirian2 Adipisci2 Definiebas2 Consequuntur2 Phaedrum2 Iuvaret3 Apeirian3 Adipisci3 Definiebas3 Consequuntur3 Phaedrum3 Iuvaret4 Apeirian4 Adipisci4 Definiebas4 Consequuntur4 Phaedrum4 Iuvaret5 Apeirian5 Adipisci5 Definiebas5 Consequuntur5 Phaedrum5 Iuvaret6 Apeirian6 Adipisci6 Definiebas6 Consequuntur6 Phaedrum6 Iuvaret7 Apeirian7 Adipisci7 Definiebas7 Consequuntur7 Phaedrum7 Iuvaret8 Apeirian8 Adipisci8 Definiebas8 Consequuntur8 Phaedrum8 Iuvaret9 Apeirian9 Adipisci9 Definiebas9 Consequuntur9 Phaedrum9 ";
	    	String celtext = "";
	    	//Loop will execute untill the last row of table.
	    	for (int row = 0; row < rows_count; row++) {
	    	    //To locate columns(cells) of that specific row.
	    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    	    //To calculate no of columns (cells). In that specific row.
	    	    int columns_count = Columns_row.size();
	    	    //System.out.println("Number of cells In Row " + row + " are " + columns_count);
	    	    //Loop will execute till the last cell of that specific row.
	    	    for (int column = 0; column < columns_count-1; column++) {
	    	        // To retrieve text from that specific cell.
	    	         celtext += Columns_row.get(column).getText() + " ";
	    	       
	    	    	       
	    	    }
	    	    		
	    	   
	    	}
	 
	    	assertEquals(expectedCel, celtext);
	}
	
	
}
