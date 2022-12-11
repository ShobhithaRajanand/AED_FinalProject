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
public class Recipient extends Person implements Comparable<Recipient>{
    
    private int priorityNo;
    private String organType;
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
  
    public void setPriorityNo(int priorityNo) {
        this.priorityNo = priorityNo;
    }
    
    public int getPriorityNo() {
        return priorityNo;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }
    
        public String getOrganType() {
        return organType;
    }
        
    @Override
    public String toString() {
        return this.getPersonEmailId().trim();
    }

    
    public int compareTo(Recipient o) {
		return Integer.compare(o.getPriorityNo(), this.getPriorityNo());
	}
    
}
