package net.one97.paytm.appManager.beans;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ResponseData extends IJRPaytmDataModel {
    @b(a = "response")
    private Data data;
    @b(a = "status")
    private Integer status;

    public ResponseData() {
        this((Integer) null, (Data) null, 3, (g) null);
    }

    public static /* synthetic */ ResponseData copy$default(ResponseData responseData, Integer num, Data data2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = responseData.status;
        }
        if ((i2 & 2) != 0) {
            data2 = responseData.data;
        }
        return responseData.copy(num, data2);
    }

    public final Integer component1() {
        return this.status;
    }

    public final Data component2() {
        return this.data;
    }

    public final ResponseData copy(Integer num, Data data2) {
        return new ResponseData(num, data2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseData)) {
            return false;
        }
        ResponseData responseData = (ResponseData) obj;
        return k.a((Object) this.status, (Object) responseData.status) && k.a((Object) this.data, (Object) responseData.data);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Data data2 = this.data;
        if (data2 != null) {
            i2 = data2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ResponseData(status=" + this.status + ", data=" + this.data + ")";
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public ResponseData(Integer num, Data data2) {
        this.status = num;
        this.data = data2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseData(Integer num, Data data2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : data2);
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }
}
