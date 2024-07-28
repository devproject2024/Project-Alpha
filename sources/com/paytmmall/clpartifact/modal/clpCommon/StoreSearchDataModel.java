package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class StoreSearchDataModel {
    @c(a = "data")
    private final Data data;

    public static /* synthetic */ StoreSearchDataModel copy$default(StoreSearchDataModel storeSearchDataModel, Data data2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            data2 = storeSearchDataModel.data;
        }
        return storeSearchDataModel.copy(data2);
    }

    public final Data component1() {
        return this.data;
    }

    public final StoreSearchDataModel copy(Data data2) {
        return new StoreSearchDataModel(data2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StoreSearchDataModel) && k.a((Object) this.data, (Object) ((StoreSearchDataModel) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        Data data2 = this.data;
        if (data2 != null) {
            return data2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "StoreSearchDataModel(data=" + this.data + ")";
    }

    public StoreSearchDataModel(Data data2) {
        this.data = data2;
    }

    public final Data getData() {
        return this.data;
    }
}
