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
public class DonorDirectory {
    
    private ArrayList<Donor> donorRecords;

    public DonorDirectory() {
        donorRecords = new ArrayList();
    }

    public ArrayList<Donor> getDonorRecords() {
        return donorRecords;
    }
    
    //Create a new Donor
    public Donor createDonor(String personName, int personAge,String personAddress , String personBloodType, String personPhoneNo,
                    String personSex, String signature, String personEmailId,String referenceName, String referenceNo, boolean isOrganAvailable, List organList)
          {
        
        Donor donor = new Donor();
        donor.setPersonName(personName);
        donor.setPersonAge(personAge);
        donor.setPersonAddress(personAddress);
        donor.setPersonPhoneNo(personPhoneNo);
        donor.setPersonEmailId(personEmailId);
        donor.setPersonBloodType(personBloodType);
        donor.setPersonSex(personSex);
        donor.setSignature(signature);       
        donor.setReferenceName(referenceName);
        donor.setReferenceNo(referenceNo);
        donor.setIsOrganAvailable(isOrganAvailable);
        donor.setOrganList(organList);
        donor.setIsDonorFitForTransplant(false);
        donorRecords.add(donor);
        return donor;
    }

    public Iterable<Donor> getDonorList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
