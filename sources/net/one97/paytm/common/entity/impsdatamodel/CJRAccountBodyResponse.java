package net.one97.paytm.common.entity.impsdatamodel;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAccountBodyResponse implements IJRDataModel {
    @b(a = "assetId")
    private String mAssetId;
    @b(a = "refundAccounts")
    private List<CJRRefundAccountDetail> refundAccounts;
    @b(a = "resultInfo")
    private HashMap<String, String> resultInfo = new HashMap<>();

    public HashMap<String, String> getResultInfo() {
        return this.resultInfo;
    }

    public List<CJRRefundAccountDetail> getRefundAccounts() {
        return this.refundAccounts;
    }

    public void setRefundAccounts(List<CJRRefundAccountDetail> list) {
        this.refundAccounts = list;
    }

    public String getAssetId() {
        return this.mAssetId;
    }

    public void setAssetId(String str) {
        this.mAssetId = str;
    }
}
