/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.CommonUI;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.Utils.Utils;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shobhitha
 */
public class ManageUserAccountReusablePanel extends javax.swing.JPanel {

    JPanel rightJPanel;
    Enterprise enterpriseObj;

    /**
     * Creates new form ManageUserAccountReusablePanel
     */
    public ManageUserAccountReusablePanel(JPanel rightJPanel, Enterprise enterpriseObj) {
        initComponents();
        this.rightJPanel = rightJPanel;
        this.enterpriseObj = enterpriseObj;
        populateOrgCombo();
        populateTableData();
    }

    private void populateTableData() {
        DefaultTableModel model = (DefaultTableModel) manageUserAccountTbl.getModel();
        model.setRowCount(0);
        for (Organization organization : enterpriseObj.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount account : organization.getUserAccountDirectory().getUserAccountList()) {
                Object rowObj[] = new Object[3];
                rowObj[0] = account;
                rowObj[1] = account.getRole();
                rowObj[2] = account.getEmployee().getEmpName();
                model.addRow(rowObj);
            }
        }
    }

    public void populateEmployeeComboBox(Organization org) {
        employeeDropdown.removeAllItems();
        for (Employee employeeObj : org.getEmployeeDirectory().getEmpList()) {
            employeeDropdown.addItem(employeeObj);
        }
    }

    private void populateRoleComboBox(Organization org) {
        roleDropdown.removeAllItems();
        for (Role role : org.getSupportedRole()) {
            roleDropdown.addItem(role);
        }
    }

    private void populateOrgCombo() {
        organizationDropdown.removeAllItems();
        for (Organization organization : enterpriseObj.getOrganizationDirectory().getOrganizationList()) {
            organizationDropdown.addItem(organization);
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

        organizationDropdownLbl1 = new javax.swing.JLabel();
        organizationDropdown1 = new javax.swing.JComboBox();
        organizationDropdownLbl = new javax.swing.JLabel();
        manageUserAccountsLbl = new javax.swing.JLabel();
        employeeDropdownLbl = new javax.swing.JLabel();
        employeeDropdown = new javax.swing.JComboBox();
        roleDropdown = new javax.swing.JComboBox();
        roleDropdownLbl = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        passwordLbl = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        manageUserAccountTbl = new javax.swing.JTable();
        organizationDropdown = new javax.swing.JComboBox();
        emailLbl = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();

        organizationDropdownLbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        organizationDropdownLbl1.setText("Organization:");

        organizationDropdown1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        organizationDropdown1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationDropdown1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationDropdown1ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(153, 204, 255));

        organizationDropdownLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        organizationDropdownLbl.setText("Organization:");

        manageUserAccountsLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageUserAccountsLbl.setText("Manage User Accounts");

        employeeDropdownLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        employeeDropdownLbl.setText("Employee:");

        employeeDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        employeeDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeDropdownActionPerformed(evt);
            }
        });

        roleDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roleDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleDropdownActionPerformed(evt);
            }
        });

        roleDropdownLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        roleDropdownLbl.setText("Role:");

        passwordTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passwordLbl.setText("Password:");

        createBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-plus-+-24.png"))); // NOI18N
        createBtn.setText("Create");
        createBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        manageUserAccountTbl.setBackground(java.awt.SystemColor.info);
        manageUserAccountTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manageUserAccountTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role", "Employee Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(manageUserAccountTbl);

        organizationDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        organizationDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationDropdownActionPerformed(evt);
            }
        });

        emailLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailLbl.setText("Email:");

        emailTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(manageUserAccountsLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(organizationDropdownLbl)
                                    .addComponent(employeeDropdownLbl)
                                    .addComponent(roleDropdownLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(roleDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(156, 156, 156)
                                        .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(passwordLbl)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(organizationDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(121, 121, 121)
                                                    .addComponent(emailLbl)))
                                            .addComponent(employeeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(748, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageUserAccountsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationDropdownLbl)
                    .addComponent(organizationDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLbl)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeDropdownLbl)
                    .addComponent(employeeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleDropdownLbl)
                    .addComponent(roleDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(470, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void employeeDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeDropdownActionPerformed

    private void roleDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleDropdownActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String userEmail = emailTxt.getText();
        String password = String.valueOf(passwordTxt.getPassword());
        Utils util = new Utils();
        if (!util.notNullOrEmpty(userEmail) && !util.notNullOrEmpty(password)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid username and password!");
            return;
        }
        Organization org = (Organization) organizationDropdown.getSelectedItem();
        Employee employeeObj = (Employee) employeeDropdown.getSelectedItem();
        Role role = (Role) roleDropdown.getSelectedItem();
        if (!util.isEmaildIdvalid(userEmail)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid emailId.");
            return;
        }
        if (!util.isPasswordValid(password)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid password.");
            return;
        }

        for(UserAccount e: org.getUserAccountDirectory().getUserAccountList()){
            if(e.getEmployee() == employeeObj){
                JOptionPane.showMessageDialog(null, "User for this employee already exists!.");
                return;
            }
        }

        UserAccount account = org.getUserAccountDirectory().createUserAccount(userEmail, password, employeeObj, role);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "User already exists!. Please enter a different emailId.");
            emailTxt.setText("");
            passwordTxt.setText("");
            return;
        }
        populateTableData();
        emailTxt.setText("");
        passwordTxt.setText("");
    }//GEN-LAST:event_createBtnActionPerformed

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        // TODO add your handling code here:
        rightJPanel.remove(this);
        CardLayout layout = (CardLayout) rightJPanel.getLayout();
        layout.previous(rightJPanel);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void organizationDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationDropdownActionPerformed
        Organization org = (Organization) organizationDropdown.getSelectedItem();
        if (org != null) {
            populateEmployeeComboBox(org);
            populateRoleComboBox(org);
        }
    }//GEN-LAST:event_organizationDropdownActionPerformed

    private void organizationDropdown1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationDropdown1ActionPerformed
        Organization org = (Organization) organizationDropdown.getSelectedItem();
        if (org != null) {
            populateEmployeeComboBox(org);
            populateRoleComboBox(org);
        }
    }//GEN-LAST:event_organizationDropdown1ActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JComboBox employeeDropdown;
    private javax.swing.JLabel employeeDropdownLbl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable manageUserAccountTbl;
    private javax.swing.JLabel manageUserAccountsLbl;
    private javax.swing.JComboBox organizationDropdown;
    private javax.swing.JComboBox organizationDropdown1;
    private javax.swing.JLabel organizationDropdownLbl;
    private javax.swing.JLabel organizationDropdownLbl1;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JComboBox roleDropdown;
    private javax.swing.JLabel roleDropdownLbl;
    // End of variables declaration//GEN-END:variables
}
