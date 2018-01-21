package databaseobject;

import database.Employee;
import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeObject {
    Employee employee = new Employee();
    ResultSet rs;

    public void connectToEmployee(String dbname) {
        employee.connect(dbname, "employees", "testwerk");
    }

    public void checkEmployee(String firstname, String lastname, String tablename) {
        rs = employee.executeSelect("select " + firstname + ", " + lastname + " from " + tablename);
    }

    public void countNumerOfRows(int resultsize) {
        //Get size of resultset
        int size = 0;
        try {
            rs.last();
            size = rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Assert size with expectionation
        assertEquals(resultsize, size);
    }

    public void getEmployees(String firstname, String lastname) {
        rs = employee.executeSelect("select " + firstname + ", " + lastname + " from employees");
    }

    public void getFullEmployee(String emp_no) {
        rs = employee.executeSelect("select emp_no, first_name, last_name, hire_date, birth_date, gender from employees where emp_no = " + emp_no);
        try {
            rs.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void checkEmployees(String emp_no, String first_name, String last_name, String hire_date, String birth_date, String gender) {
        try {
            assertEquals(emp_no, rs.getString("emp_no"));
            assertEquals(first_name, rs.getString("first_name"));
            assertEquals(last_name, rs.getString("last_name"));
            assertEquals(hire_date, rs.getString("hire_date"));
            assertEquals(birth_date, rs.getString("birth_date"));
            assertEquals(gender, rs.getString("gender"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
