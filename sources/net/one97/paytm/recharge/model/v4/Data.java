package net.one97.paytm.recharge.model.v4;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Data<T> {
    private final T data;
    private final DataState dataState;
    private final String message;

    public static /* synthetic */ Data copy$default(Data data2, DataState dataState2, T t, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dataState2 = data2.dataState;
        }
        if ((i2 & 2) != 0) {
            t = data2.data;
        }
        if ((i2 & 4) != 0) {
            str = data2.message;
        }
        return data2.copy(dataState2, t, str);
    }

    public final DataState component1() {
        return this.dataState;
    }

    public final T component2() {
        return this.data;
    }

    public final String component3() {
        return this.message;
    }

    public final Data<T> copy(DataState dataState2, T t, String str) {
        k.c(dataState2, "dataState");
        return new Data<>(dataState2, t, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data2 = (Data) obj;
        return k.a((Object) this.dataState, (Object) data2.dataState) && k.a((Object) this.data, (Object) data2.data) && k.a((Object) this.message, (Object) data2.message);
    }

    public final int hashCode() {
        DataState dataState2 = this.dataState;
        int i2 = 0;
        int hashCode = (dataState2 != null ? dataState2.hashCode() : 0) * 31;
        T t = this.data;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        String str = this.message;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Data(dataState=" + this.dataState + ", data=" + this.data + ", message=" + this.message + ")";
    }

    public Data(DataState dataState2, T t, String str) {
        k.c(dataState2, "dataState");
        this.dataState = dataState2;
        this.data = t;
        this.message = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Data(DataState dataState2, Object obj, String str, int i2, g gVar) {
        this(dataState2, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : str);
    }

    public final T getData() {
        return this.data;
    }

    public final DataState getDataState() {
        return this.dataState;
    }

    public final String getMessage() {
        return this.message;
    }
}
