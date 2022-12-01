/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RadiologistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class RadiologyOrg extends Organization {
    
    public RadiologyOrg() {
        super(Organization.OrganizationType.Radiology.getValue());
    }    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRole = new ArrayList<>();
        supportedRole.add(new RadiologistRole());
        return supportedRole;
    }
}
