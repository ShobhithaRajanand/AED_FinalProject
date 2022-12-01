/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TrustManagerRole;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class TrustFundOrg extends Organization{
    
    public TrustFundOrg() {
        super(Organization.OrganizationType.TrustFund.getValue());
    }    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRole = new ArrayList<>();
        supportedRole.add(new TrustManagerRole());
        return supportedRole;   
    }
}
