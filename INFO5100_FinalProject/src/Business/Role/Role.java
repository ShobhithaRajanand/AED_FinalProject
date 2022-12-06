/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author amityadav
 */
public abstract class Role {
   

    public enum RoleType {
        ApplicantRole("Receptionist"),
        CampaignManagerRole("Campaign Manager"),
        CorporateManagerRole("Corporate Manager"),
        DoctorRole("Doctor"),
        EnterpriseManagerRole("Enterprise Manager"),
        InternalLabAssistantRole("Internal Lab Assistant"),
        SystemAdminRole("System Admin"),
        RadiologistRole("Radiologist"),
        PathologistRole("Pathologist"),
        TrustManagerRole("Trust Manager");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public Role createRole(Role.RoleType roleType) {
        Role roleObj = null;
        if (roleType.equals(RoleType.ApplicantRole)) {
            roleObj = new ReceptionistRole();
        } else if (roleType.equals(RoleType.CampaignManagerRole)) {
            roleObj = new CampaignManagerRole();
        } else if (roleType.equals(RoleType.DoctorRole)) {
            roleObj = new DoctorRole();
        } else if (roleType.equals(RoleType.RadiologistRole)) {
            roleObj = new RadiologistRole();
        } else if(roleType.equals(RoleType.PathologistRole)){
             roleObj = new PathologistRole();
        }else if (roleType.equals(RoleType.InternalLabAssistantRole)) {
            roleObj = new InternalLabAssistantRole();
        } else if (roleType.equals(RoleType.CorporateManagerRole)) {
            roleObj = new CorporateManagerRole();
        } else if (roleType.equals(RoleType.TrustManagerRole)) {
            roleObj = new TrustManagerRole();
        } else if (roleType.equals(RoleType.SystemAdminRole)) {
            roleObj = new TrustManagerRole();
        } else if (roleType.equals(RoleType.EnterpriseManagerRole)) {
            roleObj = new EnterpriseManagerRole();
        }
        return roleObj;
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization org,
            Enterprise enterprise,
            EcoSystem business);
}
