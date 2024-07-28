package net.one97.paytm.common.entity.recharge;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCircle implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRRechargeProduct> mConfigList;
    private String mName;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public ArrayList<CJRRechargeProduct> getCongigList() {
        return this.mConfigList;
    }

    public void setCongigList(ArrayList<CJRRechargeProduct> arrayList) {
        this.mConfigList = arrayList;
    }
}
