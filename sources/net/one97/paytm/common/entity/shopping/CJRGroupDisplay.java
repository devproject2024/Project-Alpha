package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;

public class CJRGroupDisplay extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "bills")
    private List<CJRBillDetails> mBillDetails;
    @b(a = "placement")
    private String mPlacement;
    @b(a = "type")
    private String mType;
    private Map<String, String> valuesMap = new HashMap();

    public List<CJRBillDetails> getmBillDetails() {
        return this.mBillDetails;
    }

    public void setmBillDetails(List<CJRBillDetails> list) {
        this.mBillDetails = list;
    }

    public String getType() {
        return this.mType;
    }

    public String getPlacement() {
        return this.mPlacement;
    }

    public Map<String, String> getValuesMap() {
        return this.valuesMap;
    }

    public void addToMap(String str, String str2) {
        this.valuesMap.put(str, str2);
    }
}
