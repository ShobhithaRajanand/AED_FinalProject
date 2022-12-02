/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author aditi
 */
public class Employee {
    
    private int empID;
    private String empName;  
    private String empRole;
    
    //Counter to set Employee ID
    private static int counter = 101;

    public Employee() {
        empID = counter;
        counter = counter + 1;    
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    @Override
    public String toString() {
        return empName;
    }    
}
