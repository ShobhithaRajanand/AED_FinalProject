/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.CommonUI;

import Business.Enterprise.CampaignEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FundingEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.LabEnterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shobhitha
 */
public class ManageOrganizationReusablePanel extends javax.swing.JPanel {

    JPanel rightJPanel;
    Enterprise enterpriseObj;

    /**
     * Creates new form ManageOrganizationReusablePanel
     */
    public ManageOrganizationReusablePanel(JPanel rightJPanel, Enterprise enterpriseObj) {
        initComponents();
        this.rightJPanel = rightJPanel;
        this.enterpriseObj = enterpriseObj;
        populateDropDown();
        populateOrganizationTable();
        populateOrgCombo();
        System.out.println("Creating organization in enterprise of type :" + enterpriseObj.getEnterpriseType().getValue());
    }

    private void populateDropDown() {
        if (enterpriseObj instanceof HospitalEnterprise) {
            if (enterpriseObj.getOrganizationDirectory().getOrganizationList().size() == 3) {
                organizationTypeDropdown.removeAll();
                organizationTypeDropdown.setEnabled(false);
                addOrganizationBtn.setEnabled(false);
            }
        } else if (enterpriseObj instanceof LabEnterprise) {
            if (enterpriseObj.getOrganizationDirectory().getOrganizationList().size() == 2) {
                organizationTypeDropdown.removeAll();
                organizationTypeDropdown.setEnabled(false);
                addOrganizationBtn.setEnabled(false);
            }
        } else if (enterpriseObj instanceof CampaignEnterprise) {
            if (enterpriseObj.getOrganizationDirectory().getOrganizationList().size() == 1) {
                organizationTypeDropdown.removeAll();
                organizationTypeDropdown.setEnabled(false);
                addOrganizationBtn.setEnabled(false);
            }
        } else if (enterpriseObj instanceof FundingEnterprise) {
            if (enterpriseObj.getOrganizationDirectory().getOrganizationList().size() == 2) {
                organizationTypeDropdown.removeAll();
                organizationTypeDropdown.setEnabled(false);
                addOrganizationBtn.setEnabled(false);
            }
        }
    }

    private void removeItemsFromList() {
        organizationTypeDropdown.removeAll();
        organizationTypeDropdown.setEnabled(false);
        JOptionPane.showMessageDialog(null, "The same organization cannot be added twice.");
    }

    private void addItemsInOrgDirectory() {
        Organization.OrganizationType orgType = (Organization.OrganizationType) organizationTypeDropdown.getSelectedItem();
        Organization org = enterpriseObj.getOrganizationDirectory().createOrganization(orgType);
        org.setOrganizationID(enterpriseObj.getOrganizationDirectory().getOrganizationList().size());
        populateOrganizationTable();
        populateDropDown();
        organizationTypeDropdown.removeItem(organizationTypeDropdown.getSelectedItem());
        JOptionPane.showMessageDialog(null, "Sucessfully addded organization.");
    }

    private void populateOrganizationTable() {
        DefaultTableModel model = (DefaultTableModel) manageOrganizationTbl.getModel();
        model.setRowCount(0);
        for (Organization org : enterpriseObj.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = org.getOrganizationID();
            row[1] = org.getName();
            model.addRow(row);
        }
    }

    private void populateOrgCombo() {
        organizationTypeDropdown.removeAllItems();
        for (Organization.OrganizationType orgType : Organization.OrganizationType.values()) {
            if (enterpriseObj.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospital.getValue())) {
                if (orgType.getValue().equals(Organization.OrganizationType.Doctor.getValue())
                        || orgType.getValue().equals(Organization.OrganizationType.Receptionist.getValue())
                        || orgType.getValue().equals(Organization.OrganizationType.InternalLab.getValue())) {
                    organizationTypeDropdown.addItem(orgType);
                }
            }
            if (enterpriseObj.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Lab.getValue())) {
                if (orgType.getValue().equals(Organization.OrganizationType.Pathology.getValue())
                        || orgType.getValue().equals(Organization.OrganizationType.Radiology.getValue())) {
                    organizationTypeDropdown.addItem(orgType);
                }
            }
            if (enterpriseObj.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Funding.getValue())) {
                if (orgType.getValue().equals(Organization.OrganizationType.CorporateFund.getValue())
                        || orgType.getValue().equals(Organization.OrganizationType.TrustFund.getValue())) {
                    organizationTypeDropdown.addItem(orgType);
                }
            }
            if (enterpriseObj.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Campaign.getValue())) {
                if (orgType.getValue().equals(Organization.OrganizationType.RedCrossAwarenessOrg.getValue())) {
                    organizationTypeDropdown.addItem(orgType);
                }
            }
        }
        for(Organization org: enterpriseObj.getOrganizationDirectory().getOrganizationList()){
            for(int i =0 ; i < organizationTypeDropdown.getItemCount(); i++){
                Organization.OrganizationType type = (Organization.OrganizationType)organizationTypeDropdown.getItemAt(i);
                String val = type.getValue();
                if(val.equalsIgnoreCase(org.getName())){
                    organizationTypeDropdown.removeItemAt(i);
                }
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        manageOrganizationTbl = new javax.swing.JTable();
        organizationTypeDropdown = new javax.swing.JComboBox();
        organizationTypeDropdownLabel = new javax.swing.JLabel();
        addOrganizationBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        manageOrganizationsLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

        manageOrganizationTbl.setBackground(java.awt.SystemColor.info);
        manageOrganizationTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manageOrganizationTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manageOrganizationTbl);

        organizationTypeDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        organizationTypeDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationTypeDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationTypeDropdownActionPerformed(evt);
            }
        });

        organizationTypeDropdownLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        organizationTypeDropdownLabel.setText("Organization Type");

        addOrganizationBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addOrganizationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-plus-+-24.png"))); // NOI18N
        addOrganizationBtn.setText("Add Organization");
        addOrganizationBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addOrganizationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrganizationBtnActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        manageOrganizationsLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageOrganizationsLbl.setText("Manage Organizations");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/working gif.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(manageOrganizationsLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(organizationTypeDropdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(organizationTypeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(addOrganizationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageOrganizationsLbl))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(organizationTypeDropdownLabel)
                            .addComponent(organizationTypeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(addOrganizationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(264, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void organizationTypeDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationTypeDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationTypeDropdownActionPerformed

    private void addOrganizationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrganizationBtnActionPerformed

        HashSet<String> s = new HashSet<>();
        for (Organization org : enterpriseObj.getOrganizationDirectory().getOrganizationList()) {
            s.add(org.getName());
        }        
        Organization.OrganizationType orgTypeSelected = (Organization.OrganizationType) organizationTypeDropdown.getSelectedItem();
        boolean addOrg = s.add(orgTypeSelected.getValue());
        if (addOrg) {
            addItemsInOrgDirectory();
        } else {
            JOptionPane.showMessageDialog(null, "The same organization cannot be added twice.");
        }
    }//GEN-LAST:event_addOrganizationBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        rightJPanel.remove(this);
        CardLayout layout = (CardLayout) rightJPanel.getLayout();
        layout.previous(rightJPanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrganizationBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable manageOrganizationTbl;
    private javax.swing.JLabel manageOrganizationsLbl;
    private javax.swing.JComboBox organizationTypeDropdown;
    private javax.swing.JLabel organizationTypeDropdownLabel;
    // End of variables declaration//GEN-END:variables
}
