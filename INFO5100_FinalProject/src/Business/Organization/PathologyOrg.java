/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PathologistRole;
import Business.Role.RadiologistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class PathologyOrg extends Organization {

    public PathologyOrg() {
        super(Organization.OrganizationType.Pathology.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRole = new ArrayList<>();
        supportedRole.add(new PathologistRole());
        return supportedRole;    
    }
}
