package addressbook_JDBC;

import com.db.EmployeePayrollData;
import com.db.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

public class EmployeePayrollDatabaseTest {

    /**
     * Test Case 1 : To check the count in database is matching in java program or not
     */
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(3, employeePayrollData.size());
    }
}