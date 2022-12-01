/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Entity.DonorDirectory;
import Business.Entity.RecipientDirectory;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class ApplicantOrg extends Organization {
      
    public ApplicantOrg() {
        super(Organization.OrganizationType.Receptionist.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList <Role> supportedRole = new ArrayList<>();
        supportedRole.add(new ReceptionistRole());
        return supportedRole;        
    }
}
