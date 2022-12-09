/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorWorkspace;

import Business.Enterprise.Enterprise;
import Business.Entity.Donor;
import Business.Entity.Recipient;
import Business.Organization.ApplicantOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonorValidationWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amityadav
 */
public class ActivityAreaForDoctorPanel extends javax.swing.JPanel {

    private UserAccount account;
    private JPanel rightJPanel;
    private Enterprise enterprise;
    String patientUserName;
    String patientType;
    List<String> tests;

    /**
     * Creates new form ActivityAreaForDoctorPanel
     */
    public ActivityAreaForDoctorPanel(JPanel rightJPanel, UserAccount account, Enterprise enterprise, String patientUserName, List<String> tests, String patientType) {
        initComponents();
        this.rightJPanel = rightJPanel;
        this.patientUserName = patientUserName;
        enterpriseValueLbl.setText(enterprise.getName());
        this.tests = tests;
        this.enterprise = enterprise;
        this.account = account;
        this.patientType = patientType;
        patientTypeLabel.setText(patientType);
        pateintIdLabel.setText(patientUserName);
        if (patientType.equalsIgnoreCase("Donor")) {
            priorityDropdown.setVisible(false);
            setPriorityBtn.setVisible(false);
        } else {
            markDonorFitBtn.setVisible(false);
            markDonorUnfitBtn.setVisible(false);
        }
        populateWorkRequestTable();
        //populateValidateTable();
    }

// public void populateValidateTable() {
//        DefaultTableModel model = (DefaultTableModel) validateWr.getModel();
//        model.setRowCount(0);
//        DonorValidationWorkRequest finalObj = null;
//        for (WorkRequest w : account.getWorkQueue().getWorkRequestList()) {
//            if (w instanceof DonorValidationWorkRequest) {
//                DonorValidationWorkRequest a = (DonorValidationWorkRequest) w;
//                if (patientUserName.equalsIgnoreCase(a.getPatientId())) {
//                    finalObj = a;
//                    break;
//                }
//            }
//        }
//        if (finalObj != null) {
//            Object[] row = new Object[5];
//            row[0] = finalObj.getPatientId();
//            row[1] = finalObj.getSender();
//            row[2] = finalObj.isReceiverName();
//            row[3] = finalObj.getStatus();
//            model.addRow(row);
//
//        }
//    }

    public void populateWorkRequestTable() {
        DefaultTableModel model = (DefaultTableModel) labTestsRequestsTable.getModel();
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            if (request instanceof LabTestWorkRequest) {
                if (((LabTestWorkRequest) request).getPatientId() != null) {
                    if (((LabTestWorkRequest) request).getPatientId().equals(patientUserName)) {
                        row[0] = ((LabTestWorkRequest) request).getPatientId();
                        row[1] = ((LabTestWorkRequest) request).getSender();
                        row[2] = ((LabTestWorkRequest) request).getReceiver();
                        row[3] = ((LabTestWorkRequest) request).getStatus();
                        row[4] = ((LabTestWorkRequest) request).getMessage();
                        String result = ((LabTestWorkRequest) request).getTestResult();
                        row[5] = result == null ? "Pending Results" : result;
                        model.addRow(row);
                    }
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

        backBtn = new javax.swing.JButton();
        markDonorUnfitBtn = new javax.swing.JButton();
        markDonorFitBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        labTestsRequestsTable = new javax.swing.JTable();
        labTestsRequestsLbl = new javax.swing.JLabel();
        priorityDropdown = new javax.swing.JComboBox();
        setPriorityBtn = new javax.swing.JButton();
        enterpriseLbl = new javax.swing.JLabel();
        enterpriseValueLbl = new javax.swing.JLabel();
        patientTypeLabel = new javax.swing.JLabel();
        pateintIdLabel = new javax.swing.JLabel();
        testResultsPageLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        markDonorUnfitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        markDonorUnfitBtn.setText("Mark Donor Unfit");
        markDonorUnfitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markDonorUnfitBtnActionPerformed(evt);
            }
        });
        add(markDonorUnfitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 210, 60));

        markDonorFitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        markDonorFitBtn.setText("Mark Donor Fit");
        markDonorFitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markDonorFitBtnActionPerformed(evt);
            }
        });
        add(markDonorFitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 200, 60));

        labTestsRequestsTable.setBackground(java.awt.SystemColor.info);
        labTestsRequestsTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labTestsRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Sender", "Receiver", "Status", "Test Message", "Results"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(labTestsRequestsTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 900, 120));

        labTestsRequestsLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTestsRequestsLbl.setText("Lab Tests Requests:");
        add(labTestsRequestsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        priorityDropdown.setBackground(new java.awt.Color(204, 204, 204));
        priorityDropdown.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        priorityDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1- High", "2- Medium", "3- Low" }));
        priorityDropdown.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(priorityDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        setPriorityBtn.setBackground(new java.awt.Color(204, 204, 204));
        setPriorityBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setPriorityBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/priority.png"))); // NOI18N
        setPriorityBtn.setText("Set Priority");
        setPriorityBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPriorityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPriorityBtnActionPerformed(evt);
            }
        });
        add(setPriorityBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        enterpriseLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLbl.setText("Enterprise :");
        add(enterpriseLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 70));

        enterpriseValueLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseValueLbl.setText("<value>");
        add(enterpriseValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 230, 50));

        patientTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(patientTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 160, 40));

        pateintIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(pateintIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 340, 40));

        testResultsPageLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        testResultsPageLbl.setText("Test Results Page");
        add(testResultsPageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/activity area for doctor panel gif.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 800, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        rightJPanel.remove(this);
        Component[] componentArray = rightJPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorRequestPatientTestPanel reqPatientLabTestObj = (DoctorRequestPatientTestPanel) component;
        CardLayout cardLayout = (CardLayout) rightJPanel.getLayout();
        cardLayout.previous(rightJPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void markDonorUnfitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markDonorUnfitBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Marking donor as unfit for transplant" + patientUserName);
        DonorValidationWorkRequest finalObj = null;
        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w instanceof DonorValidationWorkRequest) {
                DonorValidationWorkRequest a = (DonorValidationWorkRequest) w;
                if (patientUserName.equalsIgnoreCase(a.getPatientId())) {
                    finalObj = a;
                    break;
                }
            }
        }
        Donor d = finalObj.getDonorObj();
        d.setIsDonorFitForTransplant(true);
        finalObj.setStatus("Request Completed");
        finalObj.setTestResult("Donor Fit");
        JOptionPane.showMessageDialog(null, "Donor Marked Unfit!");
        //populateValidateTable();
    }//GEN-LAST:event_markDonorUnfitBtnActionPerformed

    private void markDonorFitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markDonorFitBtnActionPerformed
        // TODO add your handling code here:
        DonorValidationWorkRequest finalObj = null;
        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w instanceof DonorValidationWorkRequest) {
                DonorValidationWorkRequest a = (DonorValidationWorkRequest) w;
                if (patientUserName.equalsIgnoreCase(a.getPatientId())) {
                    finalObj = a;
                    break;
                }
            }
        }
        Donor d = finalObj.getDonorObj();
        d.setIsDonorFitForTransplant(true);
        finalObj.setStatus("Request Completed");
        finalObj.setTestResult("Donor Fit");
        JOptionPane.showMessageDialog(null, "Donor Marked Fit!");
        //populateValidateTable();
    }//GEN-LAST:event_markDonorFitBtnActionPerformed

    private void setPriorityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPriorityBtnActionPerformed
        int selectedRow = labTestsRequestsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to set priority!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (patientType.equals("Patient")) {
            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                for (Recipient rObj : org.getRecipientDirectory().getRecipientRecords()) {
                    if (rObj.getPersonEmailId().equals(patientUserName)) {
                        if ((labTestsRequestsTable.getValueAt(selectedRow, 3).equals("Completed"))) {
                            if (priorityDropdown.getSelectedIndex() == 0) {
                                rObj.setPriorityNo(1);
                                JOptionPane.showMessageDialog(null, "Priority set to HIGH!");
                            } else if (priorityDropdown.getSelectedIndex() == 1) {
                                rObj.setPriorityNo(2);
                                JOptionPane.showMessageDialog(null, "Priority set to MEDIUM!");
                            } else if (priorityDropdown.getSelectedIndex() == 2) {
                                rObj.setPriorityNo(3);
                                JOptionPane.showMessageDialog(null, "Priority set to LOW!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry, You cannot set priority for patients with pending tests!");
                            return;
                        }
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sorry, You cannot set priority for a donor!");
        }
    }//GEN-LAST:event_setPriorityBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel enterpriseLbl;
    private javax.swing.JLabel enterpriseValueLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labTestsRequestsLbl;
    private javax.swing.JTable labTestsRequestsTable;
    private javax.swing.JButton markDonorFitBtn;
    private javax.swing.JButton markDonorUnfitBtn;
    private javax.swing.JLabel pateintIdLabel;
    private javax.swing.JLabel patientTypeLabel;
    private javax.swing.JComboBox priorityDropdown;
    private javax.swing.JButton setPriorityBtn;
    private javax.swing.JLabel testResultsPageLbl;
    // End of variables declaration//GEN-END:variables
}
