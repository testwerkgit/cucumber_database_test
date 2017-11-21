package databaseobject;

import database.Employee;
import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeObject {
    Employee employee = new Employee();
    ResultSet rs;

    public void connectToEmployee(String dbname) {
        employee.connect(dbname, "employee", "testwerk");
    }

    public void checkEmployee(String firstname, String lastname, String tablename) {
        rs = employee.executeSelect("select " + firstname + ", " + lastname + " from " + tablename);
    }

    public void countNumerOfRows(int resultsize) {
        //Get size of resultset
        int size = 0;
        try {
            size = rs.getFetchSize();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Assert size with expectionation
        assertEquals(resultsize, size);
    }

    public void getEmployees(String firstname, String lastname) {
        rs = employee.executeSelect("select " + firstname + ", " + lastname + " from employees");
    }

    public void checkEmployees(String firstname, String lastname, String email, String birthdate) {
        try {
            assertEquals(firstname, rs.getString("firstname"));
            assertEquals(lastname, rs.getString("lastname"));
            assertEquals(email, rs.getString("email"));
            assertEquals(birthdate, rs.getString("birthdate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
