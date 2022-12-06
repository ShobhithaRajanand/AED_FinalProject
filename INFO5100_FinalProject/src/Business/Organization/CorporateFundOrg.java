/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CorporateManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
//corporate
public class CorporateFundOrg extends Organization {

    public CorporateFundOrg() {
        super(Organization.OrganizationType.CorporateFund.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRole = new ArrayList<>();
        supportedRole.add(new CorporateManagerRole());
        return supportedRole;
    }

}
