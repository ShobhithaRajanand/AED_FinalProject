/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Entity.CampaignEvent;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shobhitha
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<CampaignEvent> campaignList;
    List <Network> networks = new ArrayList<Network>();

    public EcoSystem() {
        super(null);
        networks = new ArrayList<Network>();
        campaignList = new ArrayList<CampaignEvent>();
    }
    
    public CampaignEvent createCampaign(){
        
        CampaignEvent campaign = new CampaignEvent();
        campaignList.add(campaign);
        return campaign;
    }
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAddNetwork(){
        Network networkObj = new Network();
        // add newly created network object to network list
        networks.add(networkObj);
        return networkObj;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public ArrayList<CampaignEvent> getCampaignList() {
        return campaignList;
    }

    public void deleteNetwork (Network network){
       networks.remove(network);
    }
    
}
