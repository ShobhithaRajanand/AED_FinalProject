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
public class FundingWorkRequest extends WorkRequest{
    
    private String network;
    private String eventType;
    private String eventDate;
    private String campaign;
    private String approval;
    private float amount;
    private String fundStatus;
    private String fundType;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }   

    public String getNetwork() {
        return network;
    }

    public String getEventName() {
        return eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getCampaign() {
        return campaign;
    }

    public String getApproval() {
        return approval;
    }

    public String getFundStatus() {
        return fundStatus;
    }

    public float getAmount() {
        return amount;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void setEventName(String eventType) {
        this.eventType = eventType;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public void setFundStatus(String fundStatus) {
        this.fundStatus = fundStatus;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
}
