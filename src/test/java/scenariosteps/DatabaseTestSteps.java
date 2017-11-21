package scenariosteps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import databaseobject.EmployeeObject;

/**
 * Created by in084kon on 21-11-2017.
 */
public class DatabaseTestSteps {
    EmployeeObject employee = new EmployeeObject();

    @Given("^I have a connection to the '(.*)' database$")
    public void iHaveAConnectionToTheEmployeeDatabase(String dbname)   {
        employee.connectToEmployee(dbname);
    }

    @When("^I select the columns '(.*)' and '(.*)' from table '(.*)'$")
    public void iSelectTheColumnsFirstnameAndLastnameFromTableEmployees(String firstname, String lastname, String tablename)   {
        employee.checkEmployee(firstname, lastname, tablename);
    }

    @Then("^I get '(\\d+)' records$")
    public void iGetRecords(int resultsize)   {
        employee.countNumerOfRows(resultsize);
    }

    @When("^I select the following data$")
    public void iSelectTheFollowingData(DataTable selectdata)   {
        String firstname = selectdata.getGherkinRows().get(1).getCells().get(1);
        String lastname = selectdata.getGherkinRows().get(2).getCells().get(1);
        employee.getEmployees(firstname, lastname);
    }

    @Then("^I get the following data$")
    public void iGetTheFollowingData(DataTable resultdata)   {
        String firstname = resultdata.getGherkinRows().get(1).getCells().get(1);
        String lastname = resultdata.getGherkinRows().get(2).getCells().get(1);
        String email = resultdata.getGherkinRows().get(3).getCells().get(1);
        String birthdate = resultdata.getGherkinRows().get(4).getCells().get(1);
        employee.checkEmployees(firstname, lastname, email, birthdate);

    }
}
