/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

import java.util.List;

/**
 *
 * @author aditi
 */
public class Donor extends Person{
    
    private String referenceName;
    private String referenceNo;
    private boolean isOrganAvailable;
    private boolean isDonorFitForTransplant;
    List<String> organList;
    boolean isDocAssigned;
    String docAssignedEmaild;

    public String getDocAssignedEmaild() {
        return docAssignedEmaild;
    }

    public void setDocAssignedEmaild(String docAssignedEmaild) {
        this.docAssignedEmaild = docAssignedEmaild;
    }
    
    public boolean isIsDocAssigned() {
        return isDocAssigned;
    }

    public void setIsDocAssigned(boolean isDocAssigned) {
        this.isDocAssigned = isDocAssigned;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public boolean isIsOrganAvailable() {
        return isOrganAvailable;
    }

    public void setIsOrganAvailable(boolean isOrganAvailable) {
        this.isOrganAvailable = isOrganAvailable;
    }

    public List<String> getOrganList() {
        return organList;
    }

    public void setOrganList(List<String> organList) {
        this.organList = organList;
    }
    
    public boolean isIsDonorFitForTransplant() {
        return isDonorFitForTransplant;
    }

    public void setIsDonorFitForTransplant(boolean isDonorFitForTransplant) {
        this.isDonorFitForTransplant = isDonorFitForTransplant;
    }
    

    @Override
    public String toString() {
        return this.getPersonEmailId().trim();
    }

}
