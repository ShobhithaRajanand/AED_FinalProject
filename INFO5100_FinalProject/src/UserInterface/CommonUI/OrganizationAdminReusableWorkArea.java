/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.CommonUI;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.HospitalAdminWorkspace.CheckDonorRecipientRatio;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shobhitha
 */
public class OrganizationAdminReusableWorkArea extends javax.swing.JPanel {
    
    EcoSystem system;
    Enterprise enterpriseObj;
    JPanel rightJPanel;
    UserAccount account;

    /**
     * Creates new form OrganizationAdminReusableWorkArea
     */
    public OrganizationAdminReusableWorkArea( EcoSystem system,JPanel rightJPanel, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.system = system;
        this.rightJPanel = rightJPanel;
        this.enterpriseObj = enterprise;
        this.account = account;
        adminValue.setText(enterpriseObj.getName());
        if(enterprise instanceof HospitalEnterprise){
            checkRatioBtn.setVisible(true);
        }else{
            checkRatioBtn.setVisible(false);
        }

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        managePeopleInOrganizationBtn = new javax.swing.JButton();
        manageOrgButton = new javax.swing.JButton();
        adminLbl = new javax.swing.JLabel();
        adminValue = new javax.swing.JLabel();
        enterpriseAdminScreenLbl = new javax.swing.JLabel();
        manageUserInOrganizationBtn = new javax.swing.JButton();
        checkRatioBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        managePeopleInOrganizationBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        managePeopleInOrganizationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/management.png"))); // NOI18N
        managePeopleInOrganizationBtn.setText(" Manage People In Organization  ");
        managePeopleInOrganizationBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        managePeopleInOrganizationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePeopleInOrganizationBtnActionPerformed(evt);
            }
        });
        add(managePeopleInOrganizationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 570, 40));

        manageOrgButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageOrgButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/planning.png"))); // NOI18N
        manageOrgButton.setText(" Manage Organization In Enterprise");
        manageOrgButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageOrgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrgButtonActionPerformed(evt);
            }
        });
        add(manageOrgButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 570, 40));

        adminLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminLbl.setText("Admin :");
        add(adminLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        adminValue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminValue.setText("<value>");
        add(adminValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 430, -1));

        enterpriseAdminScreenLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        enterpriseAdminScreenLbl.setText("Enterprise Admin Screen");
        add(enterpriseAdminScreenLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        manageUserInOrganizationBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageUserInOrganizationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/team-management.png"))); // NOI18N
        manageUserInOrganizationBtn.setText(" Manage User In Organization    ");
        manageUserInOrganizationBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageUserInOrganizationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserInOrganizationBtnActionPerformed1(evt);
            }
        });
        add(manageUserInOrganizationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 570, 40));

        checkRatioBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        checkRatioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-analysis-24.png"))); // NOI18N
        checkRatioBtn.setText("Check Donor and Recipeint Ratio");
        checkRatioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRatioBtnActionPerformed(evt);
            }
        });
        add(checkRatioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 570, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void manageUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserButtonActionPerformed
        if(enterpriseObj.getOrganizationDirectory().getOrganizationList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Currently there are no organizations. Please create organizations first.");
            return;
        }
      
        for(Organization orgObj : enterpriseObj.getOrganizationDirectory().getOrganizationList()){
            if(!orgObj.getEmployeeDirectory().getEmpList().isEmpty()){
                ManageUserAccountReusablePanel manageUserJPanel = new ManageUserAccountReusablePanel(rightJPanel, enterpriseObj);
                rightJPanel.add("manageUserJPanel", manageUserJPanel);
                CardLayout layout = (CardLayout) rightJPanel.getLayout();
                layout.next(rightJPanel);
                return;
            }
                
        }
        JOptionPane.showMessageDialog(null, "Please create employees before creating users."); 
    }//GEN-LAST:event_manageUserButtonActionPerformed

    private void managePeopleInOrganizationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePeopleInOrganizationBtnActionPerformed
        if(enterpriseObj.getOrganizationDirectory().getOrganizationList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Currently there are no organizations. Please create an organization first.");
            return;
        }
        ManageEmployeeReusablePanel managePeopleJPanel = new ManageEmployeeReusablePanel(rightJPanel, enterpriseObj);
        rightJPanel.add("manageEmployeeRuseableJPanel", managePeopleJPanel);
        CardLayout layout = (CardLayout) rightJPanel.getLayout();
        layout.next(rightJPanel);
    }//GEN-LAST:event_managePeopleInOrganizationBtnActionPerformed

    private void manageOrgButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        ManageOrganizationReusablePanel manageOrgaJpanel = new ManageOrganizationReusablePanel(rightJPanel, enterpriseObj);
        rightJPanel.add("manageOrgJpanel", manageOrgaJpanel);
        CardLayout layout = (CardLayout) rightJPanel.getLayout();
        layout.next(rightJPanel);
    }

    private void checkRatioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRatioBtnActionPerformed
        // TODO add your handling code here:
        CheckDonorRecipientRatio checkRatio = new CheckDonorRecipientRatio(system, rightJPanel, account, enterpriseObj);
                rightJPanel.add("manageEntAdmins", checkRatio);
                CardLayout layout = (CardLayout) rightJPanel.getLayout();
                layout.next(rightJPanel);
    }//GEN-LAST:event_checkRatioBtnActionPerformed

    private void manageUserInOrganizationBtnActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserInOrganizationBtnActionPerformed1
        // TODO add your handling code here:
         if(enterpriseObj.getOrganizationDirectory().getOrganizationList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Currently there are no organizations. Please create organizations first.");
            return;
        }
      
        for(Organization orgObj : enterpriseObj.getOrganizationDirectory().getOrganizationList()){
            if(!orgObj.getEmployeeDirectory().getEmpList().isEmpty()){
                ManageUserAccountReusablePanel manageUserJPanel = new ManageUserAccountReusablePanel(rightJPanel, enterpriseObj);
                rightJPanel.add("manageUserJPanel", manageUserJPanel);
                CardLayout layout = (CardLayout) rightJPanel.getLayout();
                layout.next(rightJPanel);
                return;
            }
                
        }
        JOptionPane.showMessageDialog(null, "Please create employees before creating users."); 
    }//GEN-LAST:event_manageUserInOrganizationBtnActionPerformed1

                                                



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminLbl;
    private javax.swing.JLabel adminValue;
    private javax.swing.JButton checkRatioBtn;
    private javax.swing.JLabel enterpriseAdminScreenLbl;
    private javax.swing.JButton manageOrgButton;
    private javax.swing.JButton managePeopleInOrganizationBtn;
    private javax.swing.JButton manageUserInOrganizationBtn;
    // End of variables declaration//GEN-END:variables
}
