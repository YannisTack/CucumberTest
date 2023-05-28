package yannistack.cucumbertest;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import utils.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	private HomePage page;

    @Given("the homepage is shown")
    public void anExampleScenario() {
    	System.out.println("StepDef - HOMEPAGE");
    	page = new HomePage(DriverManager.getEDriver());
    }
    
    @Given("the item called {string} is not yet added")
    public void removeItemIfExists(String s) {
    	System.out.println("Item check: " + s);
    	if (page.isListItemVisible(s)) {
    		page.deleteTodoItem(s);
    	}
    }
    
    @Given("there are no (todo) items")
    public void clearAllItems() {
    	System.out.println("Clearing all items");
    	page.deleteAllTodoItems();
    }

    @When("^I\\s(?:add|added)\\sa\\snew\\stodo\\sitem\\scalled\\s\"(.+)\"$")
    public void addTodoItem(String itemName) {
    	System.out.println("Adding todo item '" + itemName + "'");
    	page.addNewTodoItem(itemName);
    }
    
    @When("^I\\s(?:add|added)\\s(\\d)\\snew\\stodo\\sitems$")
    public void addMultipleTodoItems(int count) {
    	System.out.println("StepDef - ENTER ITEM");
    	page.addMultipleNewTodoItems(count);
    }
    
    @When("^I\\sdelete\\sthe\\stodo\\sitem\\scalled\\s\"(.+)\"$")
    public void deleteTodoItem(String itemName) {
    	System.out.println("Deleting todo item '" + itemName + "'");
    	page.deleteTodoItem(itemName);
    }

    @Then("^the\\s(?:todo)?\\s?item\\scalled\\s\\\"(.+)\\\"\\sis\\svisible$")
    public void theItemIsVisible(String itemName) {
    	System.out.println("Validating item " + itemName + " is visible");
    	assertTrue(page.isListItemVisible(itemName));
    }
    
    @Then("the item called {string} is not visible")
    public void theItemIsInvisible(String itemName) {
    	System.out.println("Validating item " + itemName + " is not visible");
    }
    
    @Then("{int} (todo) items are visible")
    public void numberOfItemsAreVisible(int itemCount) {
    	System.out.println("Validating itemlist has " + itemCount + " todo items");
    }
}
