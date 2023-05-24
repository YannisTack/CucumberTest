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

    @When("^I\\s(?:add|added)\\sa\\snew\\stodo\\sitem\\scalled\\s\"(.+)\"$")
    public void addTodoItem(String itemName) {
    	System.out.println("StepDef - ENTER ITEM");
    	page.addNewTodoItem(itemName);
    }
    
    @When("^I\\s(?:add|added)\\s(\\d)\\snew\\stodo\\sitems$")
    public void addMultipleTodoItems(int count) {
    	System.out.println("StepDef - ENTER ITEM");
    	page.addMultipleNewTodoItems(count);
    }

    @Then("^the\\s(?:todo)?\\s?item\\scalled\\s\\\"(.+)\\\"\\sis\\svisible$")
    public void theScenarioPasses(String itemName) {
    	System.out.println("StepDef - ASSERT");
    	assertTrue(page.isListItemVisible(itemName));
    }

}
