package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	// Variables
	private WebDriver driver;
	private int timeoutInSeconds = 2;
	public static String url = "https://todomvc.com/examples/vanillajs/";
	
	
	// Web elements
	@FindBy (className = "new-todo")
	private WebElement fldNewTodo;
	@FindBy (xpath = "//ul[@class='todo-list']")
	private WebElement ulItemList;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	// Public methods
	public HomePage addNewTodoItem(String itemName)	{
		fldNewTodo.sendKeys(itemName);
		fldNewTodo.sendKeys(Keys.ENTER);
		return new HomePage(driver);
	}
	
	public HomePage addListOfItems(List<String> list) {
		for (String item : list) {
			System.out.println("Adding item: " + item);
			addNewTodoItem(item);
		}
		return new HomePage(driver);
	}
	
	public Boolean isListItemVisible(String itemName) {
		try {
			WebElement listItem = ulItemList.findElement(By.xpath(".//label[text()='" + itemName + "']"));
			if (listItem != null) {
				return true;
			}
			else return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public HomePage deleteTodoItem(String itemName)	{
		//Duration dur = Duration.ofSeconds(timeoutInSeconds);
		//WebDriverWait wait = new WebDriverWait(driver, dur);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//label[text()='" + itemName + "']")));
		WebElement listItemDeleteButton = ulItemList.findElement(By.xpath(".//label[text()='" + itemName + "']/following-sibling::button[@class='destroy']"));
		if (listItemDeleteButton != null) {
			listItemDeleteButton.click();
		}
		return new HomePage(driver);
	}
	
	public HomePage deleteAllTodoItems() {
		List<WebElement> destroyButtons = ulItemList.findElements(By.xpath(".//button[@class='destroy']"));
		
		for (int i = destroyButtons.size() - 1; i >= 0; i--) {
			destroyButtons.get(i).click();			
		}
		
		return new HomePage(driver);
		
	}
	
	public HomePage completeTodoItem(String itemName) {
		WebElement listItemCompletedToggle = ulItemList.findElement(By.xpath(".//label[text()='" + itemName + "']/preceding-sibling::input"));
		listItemCompletedToggle.click();
		
		return new HomePage(driver);
	}
	
	// Debug methods
	public void logCurrentListItems() {
		List<WebElement> items = ulItemList.findElements(By.xpath(".//label"));
		System.out.println("Current list of todo items:");
		for (WebElement item : items) {
			System.out.println(item.getText());
		}
	}
	
	public void getTodoItemIndex(String itemName) {
		List<WebElement> items = ulItemList.findElements(By.xpath(".//label"));
		System.out.println("Checking elements for item '" + itemName + "'");
		for (int i = 0; i < items.size(); i++) {
			System.out.println("Item " + i + ": " + items.get(i).getText());
			if (items.get(i).getText().equals(itemName)) {
				System.out.println("Target index: " + i);
			}
		}
	}

}
