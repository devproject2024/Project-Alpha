package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRCourierContacts extends IJRPaytmDataModel {
    @b(a = "contacts")
    private ArrayList<CJRContact> contacts = new ArrayList<>();

    public ArrayList<CJRContact> getContacts() {
        return this.contacts;
    }
}
