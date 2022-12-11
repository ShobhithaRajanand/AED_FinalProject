/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public ArrayList<Organization> setOrganizationList() {
        return organizationList;
    }

    // create organization and add it to organization directory
    public Organization createOrganization(OrganizationType orgType) {
        
        Organization orgObj = null;
        
        if (orgType.getValue().equals(OrganizationType.Receptionist.getValue())) {
            orgObj = new ApplicantOrg();
        } 
        else if (orgType.getValue().equals(OrganizationType.Doctor.getValue())) {
            orgObj = new DoctorOrg();
        } 
        else if (orgType.getValue().equals(OrganizationType.InternalLab.getValue())) {
            orgObj = new InternalLabOrg();
        } 
        else if (orgType.getValue().equals(OrganizationType.Pathology.getValue())) {
            orgObj = new PathologyOrg();
        } 
        else if (orgType.getValue().equals(OrganizationType.Radiology.getValue())) {
            orgObj = new RadiologyOrg();
        } 
        else if (orgType.getValue().equals(OrganizationType.RedCrossAwarenessOrg.getValue())) {
            orgObj = new RedCrossAwarenessOrg();
        }
        else if (orgType.getValue().equals(OrganizationType.TrustFund.getValue())) {
            orgObj = new TrustFundOrg();
        }
        else if (orgType.getValue().equals(OrganizationType.CorporateFund.getValue())) {
            orgObj = new CorporateFundOrg();
        }
        
        if(orgObj != null) organizationList.add(orgObj);
        
        return orgObj;
    }

}
