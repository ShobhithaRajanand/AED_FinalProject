/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SystemAdminWorkspace;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.EnterpriseManagerRole;
import Business.UserAccount.UserAccount;
import Business.Utils.Utils;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shobhitha
 */
public class ManageEnterpriseAdminDash extends javax.swing.JPanel {

    EcoSystem ecoSystem;
    JPanel rightJPanel;
    /**
     * Creates new form ManageEnterpriseAdminDash
     */
    public ManageEnterpriseAdminDash(JPanel rightJPanel, EcoSystem ecoSystemObj) {
        initComponents();
        this.ecoSystem = ecoSystemObj;
        this.rightJPanel = rightJPanel;
        populateEnterpriseTable();
        populateNetworkList();
    }
   
    private void populateNetworkList() {
        cityDropdown.removeAllItems();
        for (Network network : ecoSystem.getNetworks()) cityDropdown.addItem(network);
        
    }
    
    private void populateEnterpriseTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseAdminTbl.getModel();
        model.setRowCount(0);
        for (Network network : ecoSystem.getNetworks()) {
            for (Enterprise enterpriseObj : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterpriseObj.getUserAccountDirectory().getUserAccountList()) {
                    Object[] rowObj = new Object[3];
                    rowObj[0] = enterpriseObj.getName();
                    rowObj[1] = network.getName();
                    rowObj[2] = userAccount.getUsername();
                    model.addRow(rowObj);
                }
            }
        }
    }     

    private void populateEnterpriseList(Network networkObj) {
        enterpriseDropdown.removeAllItems();
        for (Enterprise enterprise : networkObj.getEnterpriseDirectory().getEnterpriseList()) enterpriseDropdown.addItem(enterprise);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseAdminTbl = new javax.swing.JTable();
        cityDropdown = new javax.swing.JComboBox();
        cityLbl = new javax.swing.JLabel();
        enterpriseLbl = new javax.swing.JLabel();
        enterpriseDropdown = new javax.swing.JComboBox();
        emailTxt = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        submitBtn = new javax.swing.JButton();
        manageEnterpriseAdminsLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        enterpriseAdminTbl.setBackground(java.awt.SystemColor.info);
        enterpriseAdminTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterpriseAdminTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "City", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enterpriseAdminTbl.setDragEnabled(true);
        jScrollPane1.setViewportView(enterpriseAdminTbl);

        cityDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cityDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cityDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityDropdownActionPerformed(evt);
            }
        });

        cityLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cityLbl.setText("City");

        enterpriseLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLbl.setText("Enterprise");

        enterpriseDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseDropdownActionPerformed(evt);
            }
        });

        emailTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        emailLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailLbl.setText("Email");

        passwordLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passwordLbl.setText("Password");

        passwordTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-submit-resume-24.png"))); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        manageEnterpriseAdminsLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageEnterpriseAdminsLbl.setText("Manage  Enterprise Admins");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/Picture3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(manageEnterpriseAdminsLbl)
                        .addGap(319, 319, 319))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cityLbl)
                                        .addGap(72, 72, 72))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(emailLbl)
                                            .addComponent(enterpriseLbl)
                                            .addComponent(passwordLbl))
                                        .addGap(43, 43, 43)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cityDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enterpriseDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)))))
                .addContainerGap(833, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageEnterpriseAdminsLbl)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityLbl))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseLbl)
                            .addComponent(enterpriseDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLbl))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLbl))
                        .addGap(48, 48, 48)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        rightJPanel.remove(this);
        Component[] componentArray = rightJPanel.getComponents();
        Component componentObj = componentArray[componentArray.length - 1];
        SystemAdminDashboard sysAdminScreen = (SystemAdminDashboard) componentObj;
        CardLayout prevLayout = (CardLayout) rightJPanel.getLayout();
        // populate tree on admin screen
        sysAdminScreen.populateTree();
        prevLayout.previous(rightJPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void cityDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityDropdownActionPerformed
        Network networkObj = (Network) cityDropdown.getSelectedItem();
        if (networkObj != null)  populateEnterpriseList(networkObj);
    }//GEN-LAST:event_cityDropdownActionPerformed

    private void enterpriseDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseDropdownActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Validating Enterprise Admin Credentials");
        Utils util = new Utils();
        Enterprise enterpriseObj = (Enterprise) enterpriseDropdown.getSelectedItem();
        String emailId = emailTxt.getText();
        String password = String.valueOf(passwordTxt.getPassword());

        if (!(util.notNullOrEmpty(password) || util.notNullOrEmpty(emailId))) {
            JOptionPane.showMessageDialog(null, "Please enter emailId and password");
            return;
        }
        if (!util.isPasswordValid(password)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid password. (Minimum eight characters, at least one uppercase letter, one lowercase letter and one number)");
            return;
        }
        if (!util.isEmaildIdvalid(emailId)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email id.");
            return;
        }
        
        if(enterpriseObj.getEmployeeDirectory().getEmpList().size() > 0){
            JOptionPane.showMessageDialog(null, "Enterprise admin already exists");
            return;
        }
        Employee employee = enterpriseObj.getEmployeeDirectory().createEmployee(emailId);
        UserAccount account = enterpriseObj.getUserAccountDirectory().createUserAccount(emailId, password, employee, new EnterpriseManagerRole());
       
        System.out.println("Successfully created enterprise admin useraccount for emailId :"+emailId);
        
        emailTxt.setText("");
        passwordTxt.setText("");

        populateEnterpriseTable();
    }//GEN-LAST:event_submitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox cityDropdown;
    private javax.swing.JLabel cityLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTable enterpriseAdminTbl;
    private javax.swing.JComboBox enterpriseDropdown;
    private javax.swing.JLabel enterpriseLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageEnterpriseAdminsLbl;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
