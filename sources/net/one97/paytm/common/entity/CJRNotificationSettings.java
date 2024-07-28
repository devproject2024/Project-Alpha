package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRNotificationSettings extends IJRPaytmDataModel {
    @b(a = "preferences")
    ArrayList<CJRNotificationItem> mNotificationItems;

    public ArrayList<CJRNotificationItem> getNotificationItems() {
        return this.mNotificationItems;
    }

    public void setNotificationItems(ArrayList<CJRNotificationItem> arrayList) {
        this.mNotificationItems = arrayList;
    }
}
