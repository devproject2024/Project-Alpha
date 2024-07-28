package net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBUserGroupsResponse extends CJRWalletDataModel {
    @c(a = "groupDetailsList")
    @a
    private ArrayList<SBGroupDetailsDtoList> groupDetailsList = null;

    public ArrayList<SBGroupDetailsDtoList> getGroupDetailsDtoList() {
        return this.groupDetailsList;
    }

    public void setGroupDetailsDtoList(ArrayList<SBGroupDetailsDtoList> arrayList) {
        this.groupDetailsList = arrayList;
    }
}
