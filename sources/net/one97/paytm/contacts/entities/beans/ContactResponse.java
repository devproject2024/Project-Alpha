package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactResponse extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<ContactHealthResponseActions> contacts;

    public ArrayList<ContactHealthResponseActions> getContacts() {
        return this.contacts;
    }

    public void setContacts(ArrayList<ContactHealthResponseActions> arrayList) {
        this.contacts = arrayList;
    }

    public String toString() {
        return "ClassPojo [contacts = " + this.contacts + "]";
    }
}
