/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SystemAdminWorkspace;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Network.Network;
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
public class ManageCitiesNetwork extends javax.swing.JPanel {

    EcoSystem ecoSystem;
    JPanel rightJPanel;
    Utils util = new Utils();
    private DB4OUtil dB4OUtilObj = DB4OUtil.getInstance();
    /** 
     * Creates new form ManageCitiesNetwork
     */
    public ManageCitiesNetwork(JPanel rightJPanel, EcoSystem ecoSystemObj) {
        initComponents();
        this.ecoSystem = ecoSystemObj;
        this.rightJPanel = rightJPanel;
        populateNetworkTable();
    }

    private void populateNetworkTable() {
        DefaultTableModel networkTable = (DefaultTableModel) citiesNetworkTbl.getModel();
        networkTable.setRowCount(0);
        // hide column networks table column
        citiesNetworkTbl.getColumnModel().getColumn(1).setMinWidth(0);
        citiesNetworkTbl.getColumnModel().getColumn(1).setMaxWidth(0);
        for (Network network : ecoSystem.getNetworks()) {
            Object[] tableRow = new Object[2];
            tableRow[0] = network.getName();
            tableRow[1] = network;
            networkTable.addRow(tableRow);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        citiesNetworkTbl = new javax.swing.JTable();
        createNewCityNetworkTxt = new javax.swing.JTextField();
        currentNetworksLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        createNewCityNetworkLbl = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        manageNetworkLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        citiesNetworkTbl.setBackground(java.awt.SystemColor.info);
        citiesNetworkTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        citiesNetworkTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "City Network Name", "Object"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        citiesNetworkTbl.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(citiesNetworkTbl);
        citiesNetworkTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (citiesNetworkTbl.getColumnModel().getColumnCount() > 0) {
            citiesNetworkTbl.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 528, 121));

        createNewCityNetworkTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        createNewCityNetworkTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewCityNetworkTxtActionPerformed(evt);
            }
        });
        add(createNewCityNetworkTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 528, -1));

        currentNetworksLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        currentNetworksLbl.setForeground(new java.awt.Color(255, 255, 255));
        currentNetworksLbl.setText("Current Networks");
        add(currentNetworksLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 37, 116, -1));

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-submit-resume-24.png"))); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, -1, -1));

        createNewCityNetworkLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createNewCityNetworkLbl.setForeground(new java.awt.Color(255, 255, 255));
        createNewCityNetworkLbl.setText("Create New City Network");
        add(createNewCityNetworkLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 123, -1));

        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 123, -1));

        manageNetworkLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageNetworkLbl.setForeground(new java.awt.Color(255, 255, 255));
        manageNetworkLbl.setText("Manage Networks");
        add(manageNetworkLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 37, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/us-state-map-hd (3).jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1830, 1020));
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

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        String networkName = createNewCityNetworkTxt.getText();
        if (util.notNullOrEmpty(networkName)) {
            if (util.isValidName(networkName)) {
                for (Network network : ecoSystem.getNetworks()) {
                    if (network.getName().equalsIgnoreCase(networkName)) {
                        JOptionPane.showMessageDialog(null, "City already exists. Please enter a new city!", "Error", JOptionPane.ERROR_MESSAGE);
                        createNewCityNetworkTxt.setText("");
                        return;
                    }
                }
                System.out.println("Creating a new network with name :" + networkName);
                Network newNetwork = ecoSystem.createAddNetwork();
                newNetwork.setName(networkName);
                populateNetworkTable();
                dB4OUtilObj.storeSystem(ecoSystem);
                System.out.println("Successfully created new network with name :" + networkName);
                createNewCityNetworkTxt.setText("");
                JOptionPane.showMessageDialog(null, "Sucessfully created a city.", "INFO", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Please enter a valid city.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Please do not leave city name as empty!", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_submitBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = citiesNetworkTbl.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a city to be deleted", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Network networkToBeDeleted = (Network) citiesNetworkTbl.getValueAt(selectedRow, 1);
        ecoSystem.deleteNetwork(networkToBeDeleted);
        populateNetworkTable();
        dB4OUtilObj.storeSystem(ecoSystem);
        JOptionPane.showMessageDialog(null, "Sucessfully deleted city network.", "INFO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = citiesNetworkTbl.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a city to be updated", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Network networkToBeChanged = (Network) citiesNetworkTbl.getValueAt(selectedRow, 1);
        String newNameChanged = (String) citiesNetworkTbl.getValueAt(selectedRow, 0);
        if (util.notNullOrEmpty(newNameChanged)) {
            if (newNameChanged.equalsIgnoreCase(networkToBeChanged.getName())) {
                JOptionPane.showMessageDialog(this, "No change in name detected", "INFO", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                if (util.isValidName(newNameChanged)) {
                    for (Network network : ecoSystem.getNetworks()) {
                        if (network.getName().equalsIgnoreCase(newNameChanged)) {
                            JOptionPane.showMessageDialog(null, "City already exists. Please enter a new city!", "Error", JOptionPane.ERROR_MESSAGE);
                            createNewCityNetworkTxt.setText("");
                            return;
                        }
                    }
                    System.out.println("Updating network name from :" + networkToBeChanged.getName() + " to :" + newNameChanged);
                    networkToBeChanged.setName(newNameChanged);
                    populateNetworkTable();
                    dB4OUtilObj.storeSystem(ecoSystem);
                    JOptionPane.showMessageDialog(null, "Sucessfully updated city network.", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid city.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Please do not leave city name as empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void createNewCityNetworkTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewCityNetworkTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewCityNetworkTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable citiesNetworkTbl;
    private javax.swing.JLabel createNewCityNetworkLbl;
    private javax.swing.JTextField createNewCityNetworkTxt;
    private javax.swing.JLabel currentNetworksLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel manageNetworkLbl;
    private javax.swing.JButton submitBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}