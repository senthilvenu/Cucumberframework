package stepdefinitions;
import java.io.IOException;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;


public class HomePageSteps {

HomePage homepage;	
TestContext testcontext;
	
public 	HomePageSteps(TestContext context) throws IOException {
	testcontext = context;
	homepage = testcontext.getpageObjectManager().gethomePage();
}

@Given("^user is on Home Page$")
public void user_is_on_Home_Page() throws IOException{
	homepage.navigateTo_HomePage();	
}

@When("^he search for \"([^\"]*)\"$")
public void he_search_for(String product)  {
	homepage.perform_Search(product);
}

}
