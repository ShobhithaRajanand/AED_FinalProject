/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Message;
import javax.mail.Transport;

/**
 *
 * @author shobhitha
 */
public class Utils {

    public boolean notNullOrEmpty(String value) {
        return (value != null && !value.isEmpty());
    }

    public boolean isAlphaNumericFieldValid(String alphaNumericField) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(alphaNumericField);
        return m.matches();
    }

    public boolean isAlphabetFieldValid(String alphaNumericField) {
        String regex = "^[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(alphaNumericField);
        return m.matches();
    }
    
    public boolean isWordFieldValid(String sentence) {
        String regex = "^[A-Z][a-z]*\\s+[A-Z][a-z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sentence);
        return m.matches();
    }   
    
    public boolean isEmaildIdvalid(String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    
      public boolean isPasswordValid(String password) {
         String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(password);
         return m.matches();
    }
    
    public boolean isValidName(String name) {
         String regex = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(name);
         return m.matches();
    }
     
     public boolean isValidCampaign(String campaign){
         String regex = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(campaign);
         return m.matches();
     }
     
     public boolean isValidSign(String signature){
         String regex = "^[a-zA-Z]*$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(signature);
         return m.matches();
     }
     
     public boolean isValidPhoneNo(String number){
         String regex = "^[1-9]{1}+[0-9]{9}$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(number);
         return m.matches();
     }
     
     //Specific to one class only, do not use
     public boolean isValidPhoneNum(String campaign){
        
     }
             
     public void sendEmail(String emailID, String campaignName, String campaignDate, String city){         
         final String recipient = emailID;         
         String sender = "organdonationaed@gmail.com"; 
         String host = "smtp.gmail.com";
         String userEmail = "organdonationaed@gmail.com";
         String pswd = "Pass@1234";
         Properties prop = System.getProperties();  
         prop.setProperty("mail.smtp.host", host); 
         prop.put("mail.smtp.starttls.required", "true");
         prop.put("mail.smtp.starttls.enable", "true");
         prop.put("mail.smtp.host",host);  
         prop.put("mail.smtp.port", "587");  
         prop.put("mail.smtp.auth", "true"); 
         
         java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
         
         Session session;
         session = Session.getDefaultInstance(prop, null);
         //session.setDebug(sessionDebug);
         try{
            MimeMessage msg = new MimeMessage(session);  
            msg.setFrom(new InternetAddress(sender));  
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));  
            InternetAddress address;
            address = new InternetAddress(recipient);
            msg.setSubject("Campaign Event Awarness");  
            msg.setText("Kindly visit the campaign awarness event: " + campaignName + 
                    "on " + campaignDate + "in " + city +
                    " to know the importance of Organ Donation in today's world.");  
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userEmail, pswd);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error encountered while sending email!");
            }
    }
}
