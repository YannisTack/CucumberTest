package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	public static String url = "https://todomvc.com/examples/vanillajs/";
	
	@FindBy (className = "new-todo")
	private WebElement fldNewTodo;
	@FindBy (xpath = "//ul[@class='todo-list']")
	private WebElement ulItemList;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public HomePage inputNewTodo()
	{
		fldNewTodo.sendKeys("Automation is fun!");
		fldNewTodo.sendKeys(Keys.ENTER);
		return new HomePage(driver);
	}
	
	public Boolean isListItemVisible(String itemName) {
		WebElement listItem = ulItemList.findElement(By.xpath(".//label[text()='" + itemName + "']"));
		if (listItem != null) {
			return true;
		}
		else return false;
	}

}
