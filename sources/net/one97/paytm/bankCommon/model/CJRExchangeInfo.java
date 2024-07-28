package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRExchangeInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "brnd")
    private String brand;
    @b(a = "e_dt")
    private String e_dt;
    @b(a = "e_amt")
    private String exchangeAmount;
    @b(a = "e_id")
    private String exchangeId;
    @b(a = "imei")
    private String imei;
    @b(a = "m_amt")
    private String markupAmount;
    @b(a = "mdl")
    private String model;
    @b(a = "q_id")
    private String q_id;
    @b(a = "t_amt")
    private String totalAmount;

    public String getQ_id() {
        return this.q_id;
    }

    public void setQ_id(String str) {
        this.q_id = str;
    }

    public String getE_dt() {
        return this.e_dt;
    }

    public void setE_dt(String str) {
        this.e_dt = str;
    }

    public String getExchangeAmount() {
        return this.exchangeAmount;
    }

    public void setExchangeAmount(String str) {
        this.exchangeAmount = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String getMarkupAmount() {
        return this.markupAmount;
    }

    public void setMarkupAmount(String str) {
        this.markupAmount = str;
    }

    public String getExchangeId() {
        return this.exchangeId;
    }

    public void setExchangeId(String str) {
        this.exchangeId = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }
}
