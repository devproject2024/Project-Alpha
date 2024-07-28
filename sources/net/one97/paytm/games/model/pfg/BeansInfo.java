package net.one97.paytm.games.model.pfg;

import java.util.ArrayList;
import net.one97.paytm.games.model.GpCommonBaseResponse;

public final class BeansInfo extends GpCommonBaseResponse {
    private String balance;
    private ArrayList<Bean> items;
    private String mobile;
    private String moreEntries;
    private String totalCount;

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        this.balance = str;
    }

    public final String getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(String str) {
        this.totalCount = str;
    }

    public final String getMoreEntries() {
        return this.moreEntries;
    }

    public final void setMoreEntries(String str) {
        this.moreEntries = str;
    }

    public final ArrayList<Bean> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<Bean> arrayList) {
        this.items = arrayList;
    }
}
