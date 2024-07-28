package net.one97.paytm.acceptPayment.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRMerchantRoles extends IJRPaytmDataModel {
    @b(a = "permissions")
    private ArrayList<String> mPermissions;
    @b(a = "role")
    private String mRole;

    public String getMerchantRole() {
        return this.mRole;
    }

    public void setMerchantRole(String str) {
        this.mRole = str;
    }

    public ArrayList<String> getMerchantPermission() {
        return this.mPermissions;
    }

    public void setMerchantPermission(ArrayList<String> arrayList) {
        this.mPermissions = arrayList;
    }
}
