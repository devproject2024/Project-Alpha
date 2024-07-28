package net.one97.paytm.nativesdk.orflow.promo.model;

import java.io.Serializable;
import java.util.List;

public class CJRPromoData implements Serializable {
    private String freebieList;
    private String freebieListUrl;
    private List<GroupPId> groupPids = null;
    private String promocode;

    public String getFreebieList() {
        return this.freebieList;
    }

    public void setFreebieList(String str) {
        this.freebieList = str;
    }

    public String getFreebieListUrl() {
        return this.freebieListUrl;
    }

    public void setFreebieListUrl(String str) {
        this.freebieListUrl = str;
    }

    public List<GroupPId> getGroupPids() {
        return this.groupPids;
    }

    public void setGroupPids(List<GroupPId> list) {
        this.groupPids = list;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }
}
