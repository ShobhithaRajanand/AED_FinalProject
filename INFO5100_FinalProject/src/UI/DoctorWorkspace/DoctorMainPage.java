/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorWorkspace;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Entity.Donor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonorValidationWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amityadav
 */
public class DoctorMainPage extends javax.swing.JPanel {

    /**
     * Creates new form DoctorMainPage
     */
    JPanel rightJPanel;
    Enterprise enterprise;
    UserAccount account;
    EcoSystem business;
    
    public DoctorMainPage(JPanel rightJPanel, Enterprise enterprise, UserAccount account, EcoSystem business) {
        initComponents();
        this.rightJPanel = rightJPanel;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        populateDonorValidationReqTable();
        doctorNameLbl.setText(account.getEmployee().getEmpName());
    }
    
    void populateDonorValidationReqTable(){
        DefaultTableModel model = (DefaultTableModel) donorValidationWorkRequestsTbl.getModel();
        model.setRowCount(0);
        for(WorkRequest obj : enterprise.getWorkQueue().getWorkRequestList()){
            if(obj instanceof DonorValidationWorkRequest && (obj.getReceiver() == null || obj.getReceiver() == account)){
                DonorValidationWorkRequest finalobj = (DonorValidationWorkRequest) obj;
                Object[] row = new Object[6];
                row[0] = finalobj;
                row[1] = finalobj.getPatientId();
                row[2] = finalobj.getSender();
                row[3] = finalobj.getReceiver() == null ? "Unassigned" : finalobj.getReceiver();
                row[4] = finalobj.getStatus();
                row[5] = finalobj.getTestResult();
                model.addRow(row); 
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

        appointRequestToMeBtn = new javax.swing.JButton();
        doctorMainPageLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        donorValidationWorkRequestsTbl = new javax.swing.JTable();
        donorValidationWorkRequestsLbl = new javax.swing.JLabel();
        doctorNameLbl = new javax.swing.JLabel();
        testingAreaBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

        appointRequestToMeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        appointRequestToMeBtn.setText("Appoint Request To Me");
        appointRequestToMeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointRequestToMeBtnActionPerformed(evt);
            }
        });

        doctorMainPageLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        doctorMainPageLbl.setText("Doctor Main Page");

        donorValidationWorkRequestsTbl.setBackground(java.awt.SystemColor.info);
        donorValidationWorkRequestsTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        donorValidationWorkRequestsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Donor Id", "Sender", "Receiver", "Status", "Test Results"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane3.setViewportView(donorValidationWorkRequestsTbl);
        donorValidationWorkRequestsTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        donorValidationWorkRequestsLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        donorValidationWorkRequestsLbl.setText("Donor Validation Work Requests");

        doctorNameLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        doctorNameLbl.setText("<DoctorName>");

        testingAreaBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        testingAreaBtn.setText(" Testing Area");
        testingAreaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingAreaBtnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/doc.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(doctorMainPageLbl)
                        .addGap(179, 179, 179)
                        .addComponent(doctorNameLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(donorValidationWorkRequestsLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(appointRequestToMeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(testingAreaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(196, 196, 196)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(doctorNameLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(doctorMainPageLbl)))
                .addGap(9, 9, 9)
                .addComponent(donorValidationWorkRequestsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(appointRequestToMeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(testingAreaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void appointRequestToMeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointRequestToMeBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_appointRequestToMeBtnActionPerformed

    private void testingAreaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingAreaBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_testingAreaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointRequestToMeBtn;
    private javax.swing.JLabel doctorMainPageLbl;
    private javax.swing.JLabel doctorNameLbl;
    private javax.swing.JLabel donorValidationWorkRequestsLbl;
    private javax.swing.JTable donorValidationWorkRequestsTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton testingAreaBtn;
    // End of variables declaration//GEN-END:variables
}
