/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Entity.Donor;

/**
 *
 * @author amityadav
 */
public class DonorValidationWorkRequest extends WorkRequest{
    
    private String donorName;
    private int donorAge;
    private boolean physicalInjury;
    private boolean drinkingHistory;
    private boolean smokingHistory;
    private boolean diabetic;
    private boolean heartDisease;
    private String receiverName;
    private String patientId;
    private String patientName;
    private String testResult;
    private String testUploaded;
    private String patientType;
    Donor donorObj;

    public Donor getDonorObj() {
        return donorObj;
    }

    public void setDonorObj(Donor donorObj) {
        this.donorObj = donorObj;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestUploaded() {
        return testUploaded;
    }

    public void setTestUploaded(String testUploaded) {
        this.testUploaded = testUploaded;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String isReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public int getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(int donorAge) {
        this.donorAge = donorAge;
    }

    public boolean isPhysicalInjury() {
        return physicalInjury;
    }

    public void setPhysicalInjury(boolean physicalInjury) {
        this.physicalInjury = physicalInjury;
    }

    public boolean isDrinkingHistory() {
        return drinkingHistory;
    }

    public void setDrinkingHistory(boolean drinkingHistory) {
        this.drinkingHistory = drinkingHistory;
    }

    public boolean isSmokingHistory() {
        return smokingHistory;
    }

    public void setSmokingHistory(boolean smokingHistory) {
        this.smokingHistory = smokingHistory;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public boolean isHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(boolean heartDisease) {
        this.heartDisease = heartDisease;
    }
    
    
    
}
