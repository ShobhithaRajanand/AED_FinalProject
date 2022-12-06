/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.FundsRetrieval.GovtFundingPanel;
import javax.swing.JPanel;

/**
 *
 * @author amityadav
 */
public class TrustManagerRole extends Role {
  
    RoleType roleType = RoleType.TrustManagerRole;
    
    @Override
    public String toString() {
        return this.roleType.getValue();
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization org, Enterprise enterprise, EcoSystem business) {
        return new GovtFundingPanel(business, enterprise, org, userProcessContainer, account);
    }

    
}
