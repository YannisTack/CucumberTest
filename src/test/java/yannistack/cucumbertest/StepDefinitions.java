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

    @When("^I (?:add|added) a new todo item called \"(.+)\"$")
    public void addTodoItem(String itemName) {
    	System.out.println("StepDef - ENTER ITEM");
    	page.addNewTodoItem(itemName);
    }
    
    @When("^I (?:add|added) (\\d) new todo items$")
    public void addMultipleTodoItems(int count) {
    	System.out.println("StepDef - ENTER ITEM");
    	page.addMultipleNewTodoItems(count);
    }

    @Then("the item is visible")
    public void theScenarioPasses() {
    	System.out.println("StepDef - ASSERT");
    	assertTrue(page.isListItemVisible("Automation is fun!"));
    }

}
