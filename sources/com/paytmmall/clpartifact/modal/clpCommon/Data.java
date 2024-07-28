package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.k;

public final class Data {
    @c(a = "has_more")
    private final Boolean has_more;
    @c(a = "items")
    private final List<StoresDataModel> items;

    public static /* synthetic */ Data copy$default(Data data, Boolean bool, List<StoresDataModel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = data.has_more;
        }
        if ((i2 & 2) != 0) {
            list = data.items;
        }
        return data.copy(bool, list);
    }

    public final Boolean component1() {
        return this.has_more;
    }

    public final List<StoresDataModel> component2() {
        return this.items;
    }

    public final Data copy(Boolean bool, List<StoresDataModel> list) {
        return new Data(bool, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return k.a((Object) this.has_more, (Object) data.has_more) && k.a((Object) this.items, (Object) data.items);
    }

    public final int hashCode() {
        Boolean bool = this.has_more;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<StoresDataModel> list = this.items;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Data(has_more=" + this.has_more + ", items=" + this.items + ")";
    }

    public Data(Boolean bool, List<StoresDataModel> list) {
        this.has_more = bool;
        this.items = list;
    }

    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final List<StoresDataModel> getItems() {
        return this.items;
    }
}
