package net.one97.paytm.nativesdk.common.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Data<T> {
    private final T data;
    private final CustomError error;
    private final boolean loading;

    public static /* synthetic */ Data copy$default(Data data2, boolean z, T t, CustomError customError, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = data2.loading;
        }
        if ((i2 & 2) != 0) {
            t = data2.data;
        }
        if ((i2 & 4) != 0) {
            customError = data2.error;
        }
        return data2.copy(z, t, customError);
    }

    public final boolean component1() {
        return this.loading;
    }

    public final T component2() {
        return this.data;
    }

    public final CustomError component3() {
        return this.error;
    }

    public final Data<T> copy(boolean z, T t, CustomError customError) {
        return new Data<>(z, t, customError);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data2 = (Data) obj;
        return this.loading == data2.loading && k.a((Object) this.data, (Object) data2.data) && k.a((Object) this.error, (Object) data2.error);
    }

    public final int hashCode() {
        boolean z = this.loading;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        T t = this.data;
        int i3 = 0;
        int hashCode = (i2 + (t != null ? t.hashCode() : 0)) * 31;
        CustomError customError = this.error;
        if (customError != null) {
            i3 = customError.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "Data(loading=" + this.loading + ", data=" + this.data + ", error=" + this.error + ")";
    }

    public Data(boolean z, T t, CustomError customError) {
        this.loading = z;
        this.data = t;
        this.error = customError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Data(boolean z, Object obj, CustomError customError, int i2, g gVar) {
        this(z, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : customError);
    }

    public final T getData() {
        return this.data;
    }

    public final CustomError getError() {
        return this.error;
    }

    public final boolean getLoading() {
        return this.loading;
    }
}
