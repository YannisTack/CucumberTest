package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Variables
	private WebDriver driver;
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
	
	public HomePage addMultipleNewTodoItems(int count) {
		addNewTodoItem("Item1");
		addNewTodoItem("Item2");
		addNewTodoItem("Item3");
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

}
