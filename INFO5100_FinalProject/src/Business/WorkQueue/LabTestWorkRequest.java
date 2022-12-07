/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author amityadav
 */
public class LabTestWorkRequest extends WorkRequest{
    
    private String patientId;
    private String patientName;
    private String testResult;
    private String testUploaded;
    private String patientType;

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
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
}
