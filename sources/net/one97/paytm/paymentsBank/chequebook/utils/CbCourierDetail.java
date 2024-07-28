package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbCourierDetail extends IJRPaytmDataModel {
    @b(a = "courier_name")
    private final String courier_name;
    @b(a = "shipper_id")
    private final String shipper_id;
    @b(a = "tracking_number")
    private final Integer tracking_number;

    public static /* synthetic */ CbCourierDetail copy$default(CbCourierDetail cbCourierDetail, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cbCourierDetail.tracking_number;
        }
        if ((i2 & 2) != 0) {
            str = cbCourierDetail.shipper_id;
        }
        if ((i2 & 4) != 0) {
            str2 = cbCourierDetail.courier_name;
        }
        return cbCourierDetail.copy(num, str, str2);
    }

    public final Integer component1() {
        return this.tracking_number;
    }

    public final String component2() {
        return this.shipper_id;
    }

    public final String component3() {
        return this.courier_name;
    }

    public final CbCourierDetail copy(Integer num, String str, String str2) {
        return new CbCourierDetail(num, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbCourierDetail)) {
            return false;
        }
        CbCourierDetail cbCourierDetail = (CbCourierDetail) obj;
        return k.a((Object) this.tracking_number, (Object) cbCourierDetail.tracking_number) && k.a((Object) this.shipper_id, (Object) cbCourierDetail.shipper_id) && k.a((Object) this.courier_name, (Object) cbCourierDetail.courier_name);
    }

    public final int hashCode() {
        Integer num = this.tracking_number;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.shipper_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.courier_name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CbCourierDetail(tracking_number=" + this.tracking_number + ", shipper_id=" + this.shipper_id + ", courier_name=" + this.courier_name + ")";
    }

    public final Integer getTracking_number() {
        return this.tracking_number;
    }

    public final String getShipper_id() {
        return this.shipper_id;
    }

    public CbCourierDetail(Integer num, String str, String str2) {
        this.tracking_number = num;
        this.shipper_id = str;
        this.courier_name = str2;
    }

    public final String getCourier_name() {
        return this.courier_name;
    }
}
