/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shobhitha
 */
public class EnterpriseDirectory {

    private List<Enterprise> enterpriseList;

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    // create different types of enterprises based on enum value passed
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType enterpriseType) {

       
    }
}