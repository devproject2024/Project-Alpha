package net.one97.paytm.wallet.splitbill.model.AddBillAPI;

import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBCreateGroupAPIRequest extends CJRWalletDataModel {
    private String client;
    private String name;
    private ArrayList<SBContact> userList;

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ArrayList<SBContact> getUserList() {
        return this.userList;
    }

    public void setUserList(ArrayList<SBContact> arrayList) {
        this.userList = arrayList;
    }
}
