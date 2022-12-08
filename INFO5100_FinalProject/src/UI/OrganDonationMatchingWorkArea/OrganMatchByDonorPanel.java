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
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditi
 */
public class OrganMatchByDonorPanel extends javax.swing.JPanel {

    EcoSystem ecoSystem;
    JPanel panel;
    Donor donor;
    Recipient recipient;
    List<Donor> donorL;

    /**
     * Creates new form OrganMatchByApplicantPanel
     */
    public OrganMatchByDonorPanel(EcoSystem ecoSystem, JPanel panel, List<Donor> donorL) {
        initComponents();
        this.ecoSystem = ecoSystem;
        this.panel = panel;
        this.donorL = donorL;
        populateDonorTable();
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
        donorInfoTbl = new javax.swing.JTable();
        findMatchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipientDetailTbl = new javax.swing.JTable();
        informOrganMatchBtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        donorInfoTbl.setBackground(java.awt.SystemColor.info);
        donorInfoTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        donorInfoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Applicant (Donor) Name", "Network", "Organ", "Current Organ Availabilty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(donorInfoTbl);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 125, 970, 150));

        findMatchBtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        findMatchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-searching-32.png"))); // NOI18N
        findMatchBtn.setText("Click To Find Match");
        findMatchBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        findMatchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMatchBtnActionPerformed(evt);
            }
        });
        add(findMatchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 260, 60));

        recipientDetailTbl.setBackground(java.awt.SystemColor.info);
        recipientDetailTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        recipientDetailTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Recipient Name", "Network", "Organ", "Severity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recipientDetailTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 399, 980, 170));

        informOrganMatchBtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        informOrganMatchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/icons8-new-message-32.png"))); // NOI18N
        informOrganMatchBtn.setText("Click To Inform Match");
        informOrganMatchBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        informOrganMatchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informOrganMatchBtnActionPerformed(evt);
            }
        });
        add(informOrganMatchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 290, 60));

        backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Images/left-arrow-in-circular-button-black-symbol-2.png"))); // NOI18N
        backbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backbtn.setFocusTraversalPolicyProvider(true);
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 22, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void findMatchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMatchBtnActionPerformed

        int selectedRow = donorInfoTbl.getSelectedRow();

        if (selectedRow >= 0) {
            Donor donorInfo = (Donor) donorInfoTbl.getValueAt(selectedRow, 0);
            String network = (String) donorInfoTbl.getValueAt(selectedRow, 1);
            donor = donorInfo;
            List<String> organsList = donor.getOrganList();
            populateRecipientToTable(network, organsList);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_findMatchBtnActionPerformed

    void populateDonortabel() {
        DefaultTableModel dtm = (DefaultTableModel) donorInfoTbl.getModel();
        dtm.setRowCount(0);
        for (Donor donor : donorL) {
            Object[] row = new Object[4];
            row[0] = donor;
            row[1] = donor.getNetwork();
            row[2] = donor.getOrganList();
            row[3] = donor.isIsOrganAvailable();
            dtm.addRow(row);
        }
    }

    private void populateDonorTable() {

        DefaultTableModel model = (DefaultTableModel) donorInfoTbl.getModel();

        model.setRowCount(0);

        for (Donor donor : donorL) {
            Object[] row = new Object[4];
            row[0] = donor;
            row[1] = donor.getNetwork();
            row[2] = donor.getOrganList();
            row[3] = donor.isIsOrganAvailable();

            model.addRow(row);
        }
    }

    private void populateRecipientToTable(String network, List<String> organList) {
        System.out.println("Populate receipient table");
        DefaultTableModel dtm = (DefaultTableModel) recipientDetailTbl.getModel();
        List<Recipient> recipientL = new ArrayList<Recipient>();
        dtm.setRowCount(0);

        for (Network n : ecoSystem.getNetworks()) {
            for (Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof HospitalEnterprise) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization.getName().equalsIgnoreCase("Applicant Org")) {
                            for (Recipient rec : organization.getRecipientDirectory().getRecipientRecords()) {
                                int priorityNo = rec.getPriorityNo();
                                if ((organList.contains(rec.getOrganType())) && (priorityNo > 0)) {
                                    rec.setNetwork(network);
                                    recipientL.add(rec);
                                }
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(recipientL, new Comparator<Recipient>() {

            @Override
            public int compare(Recipient rec1, Recipient rec2) {
                return rec2.compareTo(rec1);
            }
        });

        for (Recipient recipient1 : recipientL) {
            Object[] row = new Object[4];
            row[0] = recipient1;
            row[1] = recipient1.getNetwork();
            row[2] = recipient1.getOrganType();
            row[3] = recipient1.getPriorityNo();
            dtm.addRow(row);
        }

    }

    private void informOrganMatchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informOrganMatchBtnActionPerformed

        int selectedRow = recipientDetailTbl.getSelectedRow();
        if (selectedRow >= 0) {
            recipient = (Recipient) recipientDetailTbl.getValueAt(selectedRow, 0);

            try {
                //System.out.println("Recipienttttttt"+recipient.getPersonEmailId());
                //            sendOutEmail(recipient.getPersonEmailId());
//            sendOutEmail(donor.getPersonEmailId());
                emailApproved("amit3012yadav@gmail.com");
                JOptionPane.showMessageDialog(null, "Email has been sent successfully regarding Organ match");

            } catch (Exception ex) {
                Logger.getLogger(OrganMatchByDonorPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_informOrganMatchBtnActionPerformed

     public static void emailApproved (String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties ();
        properties.put ("mail.smtp.auth","true");
        properties.put ("mail.smtp.starttls.enable","true");
        properties.put ("mail.smtp.host" , "smtp.gmail.com");
        properties.put ("mail.smtp.port","587");
        String myAccountEmail = "derrickrose3012@gmail.com";
        String password = "vbfknvllsxyfxcrq";

        Session session = Session.getInstance (properties, new Authenticator () {
        @Override
            protected PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication (myAccountEmail, password);
            }
            });
        Message message = prepareMessage (session, myAccountEmail, recepient);
        Transport.send (message);
        //System.out.println("Message sent successfully");
    }
    private static Message prepareMessage (Session session, String myAccountEmail, String recepient) {
        try{
            Message message = new MimeMessage (session);
            message.setFrom(new InternetAddress (myAccountEmail));
            message. setRecipient (Message.RecipientType.TO, new InternetAddress (recepient));
            message.setSubject("Match organ donation");
            message. setText ("You have found a match, contact hospital receptionist for info");
        return message;
        } catch (Exception ex) {
//        Logger.getLogger(Emailcode.class.getName ()). log (Level.SEVERE, null, ex);
        }
        return null;
        }
        

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed

        ManageOrganMatchInitialRoute manageNetworksJPanel = new ManageOrganMatchInitialRoute(ecoSystem, panel);
        panel.add("manageCitiesJPanel", manageNetworksJPanel);
        CardLayout layout = (CardLayout) panel.getLayout();
        layout.next(panel);
    }//GEN-LAST:event_backbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JTable donorInfoTbl;
    private javax.swing.JButton findMatchBtn;
    private javax.swing.JButton informOrganMatchBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipientDetailTbl;
    // End of variables declaration//GEN-END:variables
}