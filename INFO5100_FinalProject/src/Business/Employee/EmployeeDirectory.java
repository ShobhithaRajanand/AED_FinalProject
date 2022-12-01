/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class EmployeeDirectory {
    
    //List of Employees
    private ArrayList<Employee> empList;

    public EmployeeDirectory() {
        empList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public Employee createEmployee(String empName){
        
        Employee e1 = new Employee();
        e1.setEmpName(empName);
        empList.add(e1);
        return e1;
    }
}