/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

/**
 *
 * @author aditi
 */
public class Applicant {
    
    private String applicantName;
    private String applicantEmailId;
    private boolean choice;
    private String applicantPwd;

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantEmailId() {
        return applicantEmailId;
    }

    public void setApplicantEmailId(String applicantEmailId) {
        this.applicantEmailId = applicantEmailId;
    }

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public String getApplicantPwd() {
        return applicantPwd;
    }

    public void setApplicantPwd(String applicantPwd) {
        this.applicantPwd = applicantPwd;
    }
 
}
