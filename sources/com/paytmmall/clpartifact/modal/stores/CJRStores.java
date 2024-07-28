package com.paytmmall.clpartifact.modal.stores;

import java.io.Serializable;

public class CJRStores implements Serializable {
    private CJRStoreData data;
    private CJRStoreMetaData meta;

    public CJRStoreData getData() {
        return this.data;
    }

    public void setData(CJRStoreData cJRStoreData) {
        this.data = cJRStoreData;
    }

    public CJRStoreMetaData getMeta() {
        return this.meta;
    }

    public void setMeta(CJRStoreMetaData cJRStoreMetaData) {
        this.meta = cJRStoreMetaData;
    }

    public String toString() {
        return "ClassPojo [data = " + this.data + ", meta = " + this.meta + "]";
    }
}
