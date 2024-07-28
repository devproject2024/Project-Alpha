package net.one97.paytm.o2o.movies.common.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSummaryFoodVoucherResponse implements IJRDataModel {
    @b(a = "data")
    private ArrayList<CJRSummaryFoodVoucherData> data;

    public static /* synthetic */ CJRSummaryFoodVoucherResponse copy$default(CJRSummaryFoodVoucherResponse cJRSummaryFoodVoucherResponse, ArrayList<CJRSummaryFoodVoucherData> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRSummaryFoodVoucherResponse.data;
        }
        return cJRSummaryFoodVoucherResponse.copy(arrayList);
    }

    public final ArrayList<CJRSummaryFoodVoucherData> component1() {
        return this.data;
    }

    public final CJRSummaryFoodVoucherResponse copy(ArrayList<CJRSummaryFoodVoucherData> arrayList) {
        return new CJRSummaryFoodVoucherResponse(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRSummaryFoodVoucherResponse) && k.a((Object) this.data, (Object) ((CJRSummaryFoodVoucherResponse) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJRSummaryFoodVoucherData> arrayList = this.data;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRSummaryFoodVoucherResponse(data=" + this.data + ")";
    }

    public CJRSummaryFoodVoucherResponse(ArrayList<CJRSummaryFoodVoucherData> arrayList) {
        this.data = arrayList;
    }

    public final ArrayList<CJRSummaryFoodVoucherData> getData() {
        return this.data;
    }

    public final void setData(ArrayList<CJRSummaryFoodVoucherData> arrayList) {
        this.data = arrayList;
    }
}
