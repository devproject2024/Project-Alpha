package com.paytmmall.clpartifact.modal.stores;

import java.io.Serializable;
import java.util.List;

public class CJRStoreData implements Serializable {
    private List<CJRStoreList> stores;

    public List<CJRStoreList> getStores() {
        return this.stores;
    }

    public void setStores(List<CJRStoreList> list) {
        this.stores = list;
    }

    public String toString() {
        return "ClassPojo [stores = " + this.stores + "]";
    }
}
