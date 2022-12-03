/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class ApplicantDirectory {
    
    private ArrayList<Applicant> applicantRecords;

    public ApplicantDirectory(ArrayList<Applicant> applicantRecords) {
        applicantRecords = new ArrayList();
    }

    public ApplicantDirectory() {
        applicantRecords = new ArrayList();
    } 

    public ArrayList<Applicant> getApplicantRecords() {
        return applicantRecords;
    }

    public void setApplicantRecords(ArrayList<Applicant> applicantRecords) {
        this.applicantRecords = applicantRecords;
    }
    
    //Create new Applicant
    public Applicant createApplicant (boolean choice, String emailID){        
        Applicant applicant = new Applicant();
        applicant.setApplicantEmailId(emailID);
        applicant.setChoice(choice);
        applicantRecords.add(applicant);
        return applicant;
    }
    
}
