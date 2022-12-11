/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.HospitalAdminWorkspace;

import Business.EcoSystem;
import Business.Enterprise.CampaignEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FundingEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Entity.Donor;
import javax.swing.JPanel;
import Business.Entity.DonorDirectory;
import Business.Entity.Recipient;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AwarenessWorkRequest;
import UI.CommonUI.OrganizationAdminReusableWorkArea;
import UI.SystemAdminWorkspace.SystemAdminDashboard;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amityadav
 */
public class CheckDonorRecipientRatio extends javax.swing.JPanel {

    EcoSystem system;
    JPanel panel;
    Enterprise ent;
    private UserAccount userAccount;
    
    /**
     * Creates new form CheckDonorRecipientRatio
     */
    public CheckDonorRecipientRatio(EcoSystem system, JPanel panel, UserAccount userAccount, Enterprise ent) {
        initComponents();
        this.system = system;
        this.panel = panel;
        this.userAccount = userAccount;
        this.ent = ent;
        populateValues();
        checkAllcount();
    }
    
    
    private void populateValues(){
        int totalRecipeint = 0;
        int totalDonors = 0;
        
        for (Network n : system.getNetworks()) {
            for (Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()) {
                if(enterprise instanceof HospitalEnterprise)
                {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization.getName().equalsIgnoreCase("Applicant Org")) 
                        {
                            totalRecipeint = organization.getRecipientDirectory().getRecipientRecords().size();
                            totalDonors = organization.getDonorDirectory().getDonorRecords().size();
  
                        }
                         
                   }
                }
            
            if(totalRecipeint <= totalDonors){
                raiseRequestForAwarenessCampaignsBtn.setEnabled(true);
            }else{
                raiseRequestForAwarenessCampaignsBtn.setEnabled(false);
            }         
        }
        } 
        totalDonorCountTxt.setText(String.valueOf(totalDonors));
        totalRecipientCountTxt.setText(String.valueOf(totalRecipeint));

    }
    
    private void checkAllcount(){
        int dCorneas = 0, dheart = 0, dkidkey = 0, dlungs = 0, dliver = 0, dpanceras = 0;
        int rCorneas = 0, rheart = 0, rkidkey = 0, rlungs = 0, rliver = 0, rpanceras = 0;
        for (Network n : system.getNetworks()){
            for (Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()) {
                if(enterprise instanceof HospitalEnterprise)
                {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization.getName().equalsIgnoreCase("Applicant Org")) 
                        {
                            for (Recipient rec : organization.getRecipientDirectory().getRecipientRecords()) { 
                                    if(rec.getOrganType().equalsIgnoreCase("Corneas")){
                                        rCorneas++;
                                    }else if(rec.getOrganType().equalsIgnoreCase("Kidney")){
                                        rheart++;
                                    }else if(rec.getOrganType().equalsIgnoreCase("Heart")){
                                        rkidkey++;
                                    }else if(rec.getOrganType().equalsIgnoreCase("Lungs")){
                                        rlungs++;
                                    }else if (rec.getOrganType().equalsIgnoreCase("Liver")){
                                        rliver++;
                                    }else if (rec.getOrganType().equalsIgnoreCase("Panceras")){
                                        rpanceras++;
                                    }
                            }
                            for (Donor donor : organization.getDonorDirectory().getDonorRecords()) {
                                List<String> list = donor.getOrganList();
                                for(String str : list){
                                   if(str.equalsIgnoreCase("Corneas")){
                                        dCorneas++;
                                    }else if(str.equalsIgnoreCase("Kidney")){
                                        dkidkey++;
                                    }else if(str.equalsIgnoreCase("Heart")){
                                        dheart++;
                                    }else if(str.equalsIgnoreCase("Lungs")){
                                        dlungs++;
                                    }else if (str.equalsIgnoreCase("Liver")){
                                        dliver++;
                                    }else if (str.equalsIgnoreCase("Panceras")){
                                        dpanceras++;
                                    } 
                                }
                                    
                            }
                        }
                   }
                }
            }
    }
        
 
        DefaultTableModel dtm = (DefaultTableModel) checkDonorReceipientRatioTbl.getModel();
        dtm.setRowCount(0);
        
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Corneas");
        arrayList.add("Kidney");
        arrayList.add("Heart");
        arrayList.add("Lungs");
        arrayList.add("Liver");
        arrayList.add("Panceras");
    
        Map<String, Integer> map1 = new HashMap<>();

        map1.put("Corneas", Integer.valueOf(dCorneas));
        map1.put("Kidney", Integer.valueOf(dkidkey));
        map1.put("Heart", Integer.valueOf(dheart));
        map1.put("Lungs", Integer.valueOf(dlungs));
        map1.put("Liver", Integer.valueOf(dliver));
        map1.put("Panceras", Integer.valueOf(dpanceras));
             
        Map<String, Integer> map2 = new HashMap<>();

        map2.put("Corneas", Integer.valueOf(rCorneas));
        map2.put("Kidney", Integer.valueOf(rheart));
        map2.put("Heart", Integer.valueOf(rkidkey));
        map2.put("Lungs", Integer.valueOf(rlungs));
        map2.put("Liver", Integer.valueOf(rliver));
        map2.put("Panceras", Integer.valueOf(rpanceras));

        for (String orggans : arrayList) {
            Object[] rows = new Object[3];
            rows[0] = orggans;
            rows[1] = map1.get(orggans);
            rows[2] = map2.get(orggans);           
            dtm.addRow(rows);        
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

        backBtn = new javax.swing.JButton();
        totalDonorCountTxt = new javax.swing.JTextField();
        totalRecipientCountTxt = new javax.swing.JTextField();
        totalDonorCountLbl = new javax.swing.JLabel();
        totalRecipientCountLbl = new javax.swing.JLabel();
        raiseRequestForAwarenessCampaignsBtn = new javax.swing.JButton();
        selectOrgansLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkDonorReceipientRatioTbl = new javax.swing.JTable();
        kidneyCheckBox = new javax.swing.JCheckBox();
        lungsCheckBox = new javax.swing.JCheckBox();
        pancreasCheckBox = new javax.swing.JCheckBox();
        liverCheckBox = new javax.swing.JCheckBox();
        heartCheckBox = new javax.swing.JCheckBox();
        corneasCheckBox = new javax.swing.JCheckBox();
        viewStatusOfRequestedCampainsBtn = new javax.swing.JButton();
        checkDonorReceipientRatioLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        totalDonorCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDonorCountTxtActionPerformed(evt);
            }
        });

        totalRecipientCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalRecipientCountTxtActionPerformed(evt);
            }
        });

        totalDonorCountLbl.setText("Total Donor Count");

        totalRecipientCountLbl.setText("Total Recipient Count");

        raiseRequestForAwarenessCampaignsBtn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        raiseRequestForAwarenessCampaignsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/process.png"))); // NOI18N
        raiseRequestForAwarenessCampaignsBtn.setText("Raise Request for Awarness Campaigns");
        raiseRequestForAwarenessCampaignsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseRequestForAwarenessCampaignsBtnActionPerformed(evt);
            }
        });

        selectOrgansLbl.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        selectOrgansLbl.setText("Select the organs to initiate awareness campaigns");

        checkDonorReceipientRatioTbl.setBackground(java.awt.SystemColor.info);
        checkDonorReceipientRatioTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkDonorReceipientRatioTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Organ", "Donor Count", "Recipient Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(checkDonorReceipientRatioTbl);

        kidneyCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        kidneyCheckBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        kidneyCheckBox.setText("Kidney");

        lungsCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        lungsCheckBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lungsCheckBox.setText("Lungs");

        pancreasCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        pancreasCheckBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pancreasCheckBox.setText("Pancreas");

        liverCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        liverCheckBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        liverCheckBox.setText("Liver");

        heartCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        heartCheckBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        heartCheckBox.setText("Heart");

        corneasCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        corneasCheckBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        corneasCheckBox.setText("Corneas");

        viewStatusOfRequestedCampainsBtn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        viewStatusOfRequestedCampainsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/request.png"))); // NOI18N
        viewStatusOfRequestedCampainsBtn.setText("View Status of Requested Campaigns");
        viewStatusOfRequestedCampainsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatusOfRequestedCampainsBtnActionPerformed(evt);
            }
        });

        checkDonorReceipientRatioLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        checkDonorReceipientRatioLbl.setText("Check Donor Receipient Ratio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalDonorCountLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(totalDonorCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalRecipientCountLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totalRecipientCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(checkDonorReceipientRatioLbl)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(selectOrgansLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lungsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(corneasCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pancreasCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(liverCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(heartCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(kidneyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(raiseRequestForAwarenessCampaignsBtn)
                        .addGap(30, 30, 30)
                        .addComponent(viewStatusOfRequestedCampainsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkDonorReceipientRatioLbl))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalDonorCountLbl)
                    .addComponent(totalDonorCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalRecipientCountLbl)
                    .addComponent(totalRecipientCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectOrgansLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kidneyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heartCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corneasCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lungsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pancreasCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liverCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raiseRequestForAwarenessCampaignsBtn)
                    .addComponent(viewStatusOfRequestedCampainsBtn))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        panel.remove(this);
        Component[] componentArray = panel.getComponents();
        Component componentObj = componentArray[componentArray.length - 1];
        OrganizationAdminReusableWorkArea sysAdminScreen = (OrganizationAdminReusableWorkArea) componentObj;
        CardLayout prevLayout = (CardLayout) panel.getLayout();
        // populate tree on admin screen
        //sysAdminScreen.populateTree();
        prevLayout.previous(panel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void totalDonorCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDonorCountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalDonorCountTxtActionPerformed

    private void raiseRequestForAwarenessCampaignsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiseRequestForAwarenessCampaignsBtnActionPerformed
       
        List<String> organs = new ArrayList<String>();
        if(!corneasCheckBox.isSelected() && !heartCheckBox.isSelected() && !kidneyCheckBox.isSelected()
                && !lungsCheckBox.isSelected() && !liverCheckBox.isSelected() && !pancreasCheckBox.isSelected()){
            JOptionPane.showMessageDialog(null, "Please select one or more organs to send the request!");
            return;
        }
        if (corneasCheckBox.isSelected()) {
            organs.add(corneasCheckBox.getText());
        }
        if (heartCheckBox.isSelected()) {
            organs.add(heartCheckBox.getText());
        }
        if (kidneyCheckBox.isSelected()) {
            organs.add(kidneyCheckBox.getText());
        }
        if (lungsCheckBox.isSelected()) {
            organs.add(lungsCheckBox.getText());
        }
        if (liverCheckBox.isSelected()) {
            organs.add(liverCheckBox.getText());
        }
        if (pancreasCheckBox.isSelected()) {
            organs.add(pancreasCheckBox.getText());
        }
        
        AwarenessWorkRequest req = new AwarenessWorkRequest();
        req.setMessage("Awarness Campaign Request!");
        req.setSender(userAccount);
        req.setStatus("Sent");
        req.setOrgans(organs);
        
        //req.setSender(enterpriseObj.getUserAccountDirectory().getUserAccountList().get(0));
        //requestObj.setMessage("Awarness Campaign Request!");
        //requestObj.setStatus("Request Sent");

        ent.getWorkQueue().getWorkRequestList().add(req);
        JOptionPane.showMessageDialog(null, "Request for awareness camp has been sent!");          
      
        /*
        // TODO add your handling code here:
        int column = 0;
        int row = jTable1.getSelectedRow();
        if(row < 1){
            JOptionPane.showMessageDialog(null, "Please select a row.");
             return;
        }
        String value = jTable1.getModel().getValueAt(row, column).toString();
        
        AwarenessWorkRequest req = new AwarenessWorkRequest();
        req.setMessage("Awarness Camp Required");
        req.setFrom("Admin");
        req.setStatus("Sent");
        req.setOrganType(value);
        
       Organization org1 = null;
         for(Network network : system.getNetworks()){          
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise instanceof CampaignEnterprise){                   
                    for(Organization org :  enterprise.getOrganizationDirectory().getOrganizationList()){  
                       if(org instanceof RedCrossAwarenessOrg){
                           org1 = org; 
                       }
                   }
                }
            }
        }
         if(org1 != null){
            org1.getWorkQueue().getWorkRequestList().add(req);
        }
         */
    }//GEN-LAST:event_raiseRequestForAwarenessCampaignsBtnActionPerformed

    private void viewStatusOfRequestedCampainsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatusOfRequestedCampainsBtnActionPerformed
        // TODO add your handling code here:
        ViewCampDetails campPanel = new ViewCampDetails(system, panel, userAccount, ent);
        panel.add("FundRequestStatusJPanel", campPanel);
        CardLayout layout = (CardLayout) panel.getLayout();
        layout.next(panel);
    }//GEN-LAST:event_viewStatusOfRequestedCampainsBtnActionPerformed

    private void totalRecipientCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalRecipientCountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalRecipientCountTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel checkDonorReceipientRatioLbl;
    private javax.swing.JTable checkDonorReceipientRatioTbl;
    private javax.swing.JCheckBox corneasCheckBox;
    private javax.swing.JCheckBox heartCheckBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox kidneyCheckBox;
    private javax.swing.JCheckBox liverCheckBox;
    private javax.swing.JCheckBox lungsCheckBox;
    private javax.swing.JCheckBox pancreasCheckBox;
    private javax.swing.JButton raiseRequestForAwarenessCampaignsBtn;
    private javax.swing.JLabel selectOrgansLbl;
    private javax.swing.JLabel totalDonorCountLbl;
    private javax.swing.JTextField totalDonorCountTxt;
    private javax.swing.JLabel totalRecipientCountLbl;
    private javax.swing.JTextField totalRecipientCountTxt;
    private javax.swing.JButton viewStatusOfRequestedCampainsBtn;
    // End of variables declaration//GEN-END:variables
}
