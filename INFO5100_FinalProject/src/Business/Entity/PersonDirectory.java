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
public class PersonDirectory {
    
    //List to store Person Records
    
    List<Person> personRecord;

    public PersonDirectory() {
        personRecord = new ArrayList<Person>();
    }

    public List<Person> getPersonRecord() {
        return personRecord;
    }

    public void setPersonRecord(List<Person> personRecord) {
        this.personRecord = personRecord;
    }
    
}
