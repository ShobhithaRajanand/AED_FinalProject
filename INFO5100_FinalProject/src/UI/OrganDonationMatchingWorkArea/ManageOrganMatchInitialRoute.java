/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.OrganDonationMatchingWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Entity.Donor;
import Business.Entity.Recipient;
import Business.Network.Network;
import Business.Organization.Organization;
import UI.SystemAdminWorkspace.ManageCitiesNetwork;
import UI.SystemAdminWorkspace.SystemAdminDashboard;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aditi
 */
public class ManageOrganMatchInitialRoute extends javax.swing.JPanel {

    EcoSystem ecoSystem;
    JPanel panel;
    /**
     * Creates new form ManageOrganMatchInitialRoute
     */
    public ManageOrganMatchInitialRoute(EcoSystem ecoSystem, JPanel panel) {
        initComponents();
        this.ecoSystem = ecoSystem;
        this.panel = panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matchOrganByDonorAvailabilityBtn = new javax.swing.JButton();
        matchOrganByRecipientSeverityBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        matchOrganByDonorAvailabilityBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        matchOrganByDonorAvailabilityBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-available-updates-32.png"))); // NOI18N
        matchOrganByDonorAvailabilityBtn.setText("Match Organ by Donor Availability");
        matchOrganByDonorAvailabilityBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        matchOrganByDonorAvailabilityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchOrganByDonorAvailabilityBtnActionPerformed(evt);
            }
        });

        matchOrganByRecipientSeverityBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        matchOrganByRecipientSeverityBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-available-updates-red.png"))); // NOI18N
        matchOrganByRecipientSeverityBtn.setText("Match Organ by Recipient Severity");
        matchOrganByRecipientSeverityBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        matchOrganByRecipientSeverityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchOrganByRecipientSeverityBtnActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matchOrganByRecipientSeverityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matchOrganByDonorAvailabilityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1051, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(matchOrganByDonorAvailabilityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(matchOrganByRecipientSeverityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(684, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void matchOrganByDonorAvailabilityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchOrganByDonorAvailabilityBtnActionPerformed

        List<Donor> donorL= createDonorsList();
        
        //Check if there are donors available
        if(donorL.size() > 0){
            OrganMatchByDonorPanel organM = new OrganMatchByDonorPanel(ecoSystem, panel, donorL);
            panel.add("organ", organM);
            CardLayout layout = (CardLayout) panel.getLayout();
            layout.next(panel);
        }else {
            JOptionPane.showMessageDialog(null, "There are currently no donors available in the system!!");
        }
    }//GEN-LAST:event_matchOrganByDonorAvailabilityBtnActionPerformed
    
    //Method to create Donor List
    private List<Donor> createDonorsList() {
        
        List<Donor> donorL = new ArrayList();        
        for (Network network : ecoSystem.getNetworks()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if(e instanceof HospitalEnterprise){
                    for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                        if (organization.getName().equalsIgnoreCase("Applicant Org")) {
                            for (Donor donors : organization.getDonorDirectory().getDonorRecords()) {
                                if(donors.isIsOrganAvailable() && donors.isIsDonorFitForTransplant()){
                                    donors.setNetwork(network.getName());
                                    donorL.add(donors);
                                }
                            }
                        }

                    }
                }
                
            }
        }
        //Return the donor List
        return donorL;
    }
    
    
    private void matchOrganByRecipientSeverityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchOrganByRecipientSeverityBtnActionPerformed
        
        List<Recipient> rList = createRecipientsList();
        if(rList.size() > 0){
            OrganMatchByRecipientPanel organMatch = new OrganMatchByRecipientPanel(ecoSystem, panel, rList);
            panel.add("panel", organMatch);
            CardLayout layout = (CardLayout) panel.getLayout();
            layout.next(panel);
        }else {
            JOptionPane.showMessageDialog(null, "There are currently no Recipients alailable in the system");
        }
    }//GEN-LAST:event_matchOrganByRecipientSeverityBtnActionPerformed

    private List<Recipient> createRecipientsList(){
        
                
            
        }
        
       
    }
    
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        SystemAdminDashboard manageCitiesNetwork = new SystemAdminDashboard(panel, ecoSystem);
        panel.add("manageCitiesJPanel", manageCitiesNetwork);
        CardLayout layout = (CardLayout) panel.getLayout();
        layout.next(panel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton matchOrganByDonorAvailabilityBtn;
    private javax.swing.JButton matchOrganByRecipientSeverityBtn;
    // End of variables declaration//GEN-END:variables
}
