package net.one97.paytm.common.entity.gold.jeweller;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.gold.CJRGoldTransaction;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRGoldInitiate extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "code")
    private String code;
    @b(a = "error")
    private String error;
    private String jewellerName;
    private String logoImage;
    @b(a = "message")
    private String message;
    @b(a = "status")
    private Integer status;
    @b(a = "status_check_url")
    private String statusCheckUrl;
    @b(a = "transactions")
    private List<CJRGoldTransaction> transactions = null;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStatusCheckUrl() {
        return this.statusCheckUrl;
    }

    public void setStatusCheckUrl(String str) {
        this.statusCheckUrl = str;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getJewellerName() {
        return this.jewellerName;
    }

    public void setJewellerName(String str) {
        this.jewellerName = str;
    }

    public void setLogoImage(String str) {
        this.logoImage = str;
    }

    public String getLogoImage() {
        return this.logoImage;
    }

    public List<CJRGoldTransaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<CJRGoldTransaction> list) {
        this.transactions = list;
    }
}
