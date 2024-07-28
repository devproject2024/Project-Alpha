package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeUtilRemoveProduct implements IJRDataModel {
    @b(a = "androidapp")
    private Map<String, ArrayList<String>> mRemoveProductIdList;

    public Map<String, ArrayList<String>> getRemoveProductIdList() {
        return this.mRemoveProductIdList;
    }

    public void setRemoveProductIdList(Map<String, ArrayList<String>> map) {
        this.mRemoveProductIdList = map;
    }

    public Map<String, ArrayList<String>> getmRemoveProductIdList() {
        return this.mRemoveProductIdList;
    }

    public void setmRemoveProductIdList(Map<String, ArrayList<String>> map) {
        this.mRemoveProductIdList = map;
    }
}
