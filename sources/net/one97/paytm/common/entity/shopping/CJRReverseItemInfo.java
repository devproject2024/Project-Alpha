package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRReverseItemInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "info")
    private CJRExchangeInfo exchangeInfo;
    @b(a = "exchangeSubtitle")
    private String exchangeSubtitle;
    @b(a = "exchangeText")
    private String exchangeText;
    @b(a = "exchangeTitle")
    private String exchangeTitle;
    @b(a = "status")
    private String status;

    public CJRExchangeInfo getExchangeInfo() {
        return this.exchangeInfo;
    }

    public void setExchangeInfo(CJRExchangeInfo cJRExchangeInfo) {
        this.exchangeInfo = cJRExchangeInfo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getExchangeTitle() {
        return this.exchangeTitle;
    }

    public void setExchangeTitle(String str) {
        this.exchangeTitle = str;
    }

    public String getExchangeText() {
        return this.exchangeText;
    }

    public void setExchangeText(String str) {
        this.exchangeText = str;
    }

    public String getExchangeSubtitle() {
        return this.exchangeSubtitle;
    }

    public void setExchangeSubtitle(String str) {
        this.exchangeSubtitle = str;
    }
}
