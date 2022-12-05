/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
// recipient dir
public class RecipientDirectory {
    
     private List<Recipient> recipientRecords;

    public RecipientDirectory() {
        this.recipientRecords = new ArrayList();
    }

    public List<Recipient> getRecipientRecords() {
        return recipientRecords;
    }

    public void setRecipientRecords(List<Recipient> recipientRecords) {
        this.recipientRecords = recipientRecords;
    }
    
    //Create new recipient
    public Recipient createRecipient(String personName, int personAge, String personAddress, String personPhoneNo, 
            String personEmailId, String personBloodType, String personSex, String signature, String organType){
        
        Recipient r1 = new Recipient();
        r1.setPersonName(personName);
        r1.setPersonAge(personAge);
        r1.setPersonAddress(personAddress);
        r1.setPersonPhoneNo(personPhoneNo);
        r1.setPersonEmailId(personEmailId);
        r1.setPersonBloodType(personBloodType);
        r1.setPersonSex(personSex);
        r1.setSignature(signature);       
        r1.setOrganType(organType);
        recipientRecords.add(r1);
        return r1; 
    }   
    
    
}
