package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass extends ExcelHelper{

	public static WebDriver driver;
	public static Actions a;
	public static Alert al; 
	public static Robot r;
	public static Select s;

	
	public static void openFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	public static void openSafari() {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();

	}

	public static void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void openEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	
	public static void launchurl(String url) {
		driver.get(url);
	}
	
	public static void printAttribute(WebElement ele) {
		String atrValue = ele.getAttribute("value");
		System.out.println(atrValue);

	}
	

	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowsers() {
		driver.quit();
	}

	public static String printUrl() {
		String curl = driver.getCurrentUrl();
		return curl;
	}
	
	public static void toReload() {
		driver.navigate().refresh();
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert();
		al.accept();
	}
	
	public static void cancelAlert() {
		driver.switchTo().alert();
		al.dismiss();
	}
	
	public void printAlert() {
		String alertMsg = al.getText();
		System.out.println(alertMsg);

	}
	
	public static void promptAlert(WebElement value) {
		a.sendKeys(value);

	}
	
	public static void winWait(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static String printTitle() {
	String title = driver.getTitle();
	return title;

	}

	public static void fillTextBox(WebElement element, String input) {
		element.sendKeys(input);
	}

	public static void mousehover(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public static void clickActions(WebElement ele) {
		a = new Actions(driver);
		a.click(ele).perform();

	}
	
	
	
	
	
	public static  void mouseKeyUp(CharSequence value) {
		a.keyUp(value);

	}
	
	public static  void mouseKeyDown(CharSequence value) {
		a.keyDown(value);

	}
	
	public static void mouseClickHold(WebElement ele) {
		a = new Actions(driver);
		a.clickAndHold(ele).perform();
	}
	
	public static void mouseDoubleClick(WebElement ele) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public static void mouseRightClick(WebElement ele) {
		a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	
	
	public static void dragDrop(WebElement ele1, WebElement ele2) {
		a = new Actions(driver);
		a.dragAndDrop(ele1, ele2).perform();
	}
	
	public static void toClick(WebElement element) {
		element.click();
	}
	
	public static void ImplicitWait() throws InterruptedException {
		driver.manage().timeouts().getPageLoadTimeout();

	}
	
	public static void checkAlertPresent(Duration time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());

	}
	
	public static void elementClickable(WebElement ele, Duration time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	public static void copyUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void pasteUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void tabUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void enterUsingKeyboard() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void datetime() {
		Date d = new Date();
		System.out.println(d);
	}

	public static void takeSnap(String picName) throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		File sr = tk.getScreenshotAs(OutputType.FILE);
		File de = new File("C:\\Users\\Berlin\\eclipse-workspace\\TestNGProject\\Screenshots\\" + picName + ".png");
		FileUtils.copyFile(sr, de);
	}
	
	public static void fillUsingJs(WebElement e, String input) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+ input + "')", e );
	}
	
	public static void clickUsingJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void scrollToElement(WebElement scrollEle) {
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",scrollEle);
	}
	
	public static void getUsingJs(WebElement ele) {
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		Object value = js.executeScript("return arguments[0].getAttribute('value')", ele);
		String text = (String)value;
		System.out.println(text);
	
	}
	
	public static void switchFrameIndex(int indexValue) {
		driver.switchTo().frame(indexValue);

	}
	
	public static void switchFrameElement(WebElement ele) {
		driver.switchTo().frame(ele);

	}
	
	public static void switchFrameIndex(String name) {
		driver.switchTo().frame(name);

	}
	
	public static void linkCount() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("No of Links: "+allLinks.size());
	}
	
	public static void tableCount() {
		List<WebElement> allTable = driver.findElements(By.tagName("table"));
		System.out.println("No of Tables: "+allTable.size());
	}
	
	public static void selectUsingVisibileText(WebElement e1, String value) {
		s = new Select(e1);
		s.selectByVisibleText(value);
	}
	
	public static boolean selectMultiple(WebElement e1) {
		s = new Select(e1);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	
	public static WebElement selectFirstSelected(WebElement e1) {
		s = new Select(e1);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	
	public static void selectUsingValue(WebElement e1, String value) {
		s = new Select(e1);
		s.selectByVisibleText(value);
	
	}	
	
	public static void selectUsingIndex(WebElement e2, int index) {
		s = new Select(e2);
		s.selectByIndex(index);
	}
	
	public static void deSelectAll(WebElement ele) {
		s = new Select(ele);
		s.deselectAll();

	}
	
	public static void deselectUsingValue(WebElement e1, String value) {
		s = new Select(e1);
		s.deselectByValue(value);
	}
	
	public static void deselectUsingIndex(WebElement e1, int index) {
		s = new Select(e1);
		s.deselectByIndex(index);
		
	}
	
	public static void printAllSelectedOptions(WebElement e1) {
		s = new Select(e1);
		List<WebElement> selectedOptions = s.getAllSelectedOptions();
		for (WebElement slist : selectedOptions) {
			System.out.println(slist.getText());
		}
	}
	
	
	public static void deselectUsingVisibleText(WebElement e1, String value) {
		s = new Select(e1);
		s.deselectByVisibleText(value);
	}
	
	public static boolean eleVisible(WebElement ele) {
		boolean displayed = ele.isDisplayed();
		return displayed;

	}
	
	public static boolean eleEnabled(WebElement ele) {
		boolean enabled = ele.isEnabled();
		return enabled;

	}
	
	public static boolean eleSelected(WebElement ele) {
		boolean selected = ele.isDisplayed();
		return selected;

	}	
	
	public static void printAllOptions(WebElement e3) {
		
		s = new Select(e3);
		List<WebElement> allOptions = s.getOptions();
		for(WebElement eachOption: allOptions) {
			System.out.println(eachOption.getText());
		}

	}
	
}
