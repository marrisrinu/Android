package POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class IrctcLogin {
	static AppiumDriver<WebElement> driver;
	
	
	@FindBy(id="cris.org.in.prs.ima:id/book_ticket")
	WebElement ticket;
	@FindBy(id="cris.org.in.prs.ima:id/et_valid_pin")
	WebElement password;
	@FindBy(id="cris.org.in.prs.ima:id/tv_login")
	WebElement submit;
	@FindBy(id="cris.org.in.prs.ima:id/from")
	WebElement from;
	@FindBy(id="cris.org.in.prs.ima:id/tv_search_text")
	WebElement search;
	@FindBys(@FindBy(id="cris.org.in.prs.ima:id/rv_station_list"))
	List<WebElement> fromstations;
	@FindBy(name="To")
	WebElement to;
	@FindBy(how = How.XPATH, using="//*[@resource-id='cris.org.in.prs.ima:id/tv_station_name' and @text='SECUNDERABAD JN']")
	WebElement destination;
	@FindBy(name="Journey Date")
	WebElement journeydate;
	@FindBy(name="28")
	WebElement date;
	@FindBy(id="android:id/button1")
	WebElement ok;
	@FindBy(name="Search Train")
	WebElement searchtrains;
	@FindBy(name="General")
	WebElement general;
	@FindBys(@FindBy(id="cris.org.in.prs.ima:id/tv_train_name"))
	List<WebElement> trainname;
	@FindBy(name="SL")
	WebElement tickettype;
	@FindBy(name="Book Now")
	WebElement book;
	@FindBy(id="cris.org.in.prs.ima:id/add_passenger")
	WebElement passenger;
	@FindBy(name="Name")
	WebElement passengername;
	@FindBy(name="Age between 05 to 125")
	WebElement passengerage;
	@FindBy(name="Select Berth Preference")
	WebElement berth;
	@FindBy(name="UPPER")
	WebElement berthtype;
	@FindBy(name="Male")
	WebElement gender;
	@FindBy(name="Done")
	WebElement donebutton;
	@FindBy(id="cris.org.in.prs.ima:id/tv_book_btn")
	WebElement bookbtn;
	@FindBy(id="cris.org.in.prs.ima:id/make_payment")
	WebElement payment;
	
	
	public IrctcLogin(AppiumDriver<WebElement>  d){
		driver=d;
		PageFactory.initElements(driver, IrctcLogin.this);
		
	}
	
	public void login(String pinnumber){
		ticket.click();
		password.sendKeys(pinnumber);
		submit.click();
	}
	public void fromstations(String stationfrom){
		from.click();
		search.sendKeys(stationfrom);
		fromstations.get(0).click();
		
	}
	public void tostations(String stationto) throws InterruptedException{
		to.click();
		search.sendKeys(stationto);
		destination.click();
		Thread.sleep(2000);
	}
	public void traveldate(){
		journeydate.click();
		date.click();
		ok.click();
	}
	public void searchtrainslist() throws InterruptedException{
		WebElement ispresent = null;
		searchtrains.click();
		Thread.sleep(2000);
		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			ispresent=general;
			
		}catch(Exception e){
			System.out.println("Fail");
		}finally{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		if(ispresent !=null && ispresent.isDisplayed())	{
			System.out.println("Trains list is displayed");
		}else{
			System.out.println("Trains list is not displayed");
		}
		
	}
	
	public boolean diffTrains(String train){
		List<WebElement> textViewColl = driver.findElementsById("cris.org.in.prs.ima:id/tv_train_name");
		  boolean flag = false;
		  System.out.println(textViewColl.size());
		  for(int i=0; i<textViewColl.size(); i++){
		   if (textViewColl.get(i).getText().equals(train)){
		    textViewColl.get(i).click();
		    flag = true;
		    break;
		   }
		  }
		  return flag;
	}
	
	public static void swipeUp() {
		  Dimension size = driver.manage().window().getSize();   
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  int startx = size.width / 2;
		  driver.swipe(startx, starty, startx, endy, 3000);
		 }
	public void selectTrain(){
		while (!diffTrains("NS NSL EXP")){   //"NS NSL EXP"
			   swipeUp();
			  }
	}
	public void classtype() throws InterruptedException{
		tickettype.click();
		Thread.sleep(2000);
	}
	public void booknow(){
		book.click();
	}
	public void passengerclick(){
		passenger.click();
	}
	public void addPassengername(){
		passengername.sendKeys("Srinu Marri");
	}
	public void addPassengerage() throws InterruptedException{
		passengerage.sendKeys("28");
		driver.hideKeyboard();
	}
	public void passengerGender(){
		gender.click();
	}
	public void berthPreference(){
		berth.click();
	}
	public void berthType(){
		berthtype.click();
	}
	public void done() throws InterruptedException{
		donebutton.click();
		Thread.sleep(2000);
	}
	public void bookticket() throws InterruptedException{
		bookbtn.click();
		Thread.sleep(2000);
	}
	public void captcha(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('defaultRealHash')[0].setAttribute('value', '-897204064')");
		  driver.findElementByName("Enter the captcha").sendKeys("QNXCUL");
	}
	
	public void proceedtopayment(){
		payment.click();
	}
}
