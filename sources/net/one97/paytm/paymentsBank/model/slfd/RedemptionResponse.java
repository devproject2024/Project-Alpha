package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RedemptionResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "status")
    private final Integer masterStatus;
    @b(a = "message")
    private final String message;
    @b(a = "redemption_response_list")
    private final List<RedemptionResponseListItem> redemptionList;

    public static /* synthetic */ RedemptionResponse copy$default(RedemptionResponse redemptionResponse, String str, Integer num, List<RedemptionResponseListItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = redemptionResponse.message;
        }
        if ((i2 & 2) != 0) {
            num = redemptionResponse.masterStatus;
        }
        if ((i2 & 4) != 0) {
            list = redemptionResponse.redemptionList;
        }
        return redemptionResponse.copy(str, num, list);
    }

    public final String component1() {
        return this.message;
    }

    public final Integer component2() {
        return this.masterStatus;
    }

    public final List<RedemptionResponseListItem> component3() {
        return this.redemptionList;
    }

    public final RedemptionResponse copy(String str, Integer num, List<RedemptionResponseListItem> list) {
        return new RedemptionResponse(str, num, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedemptionResponse)) {
            return false;
        }
        RedemptionResponse redemptionResponse = (RedemptionResponse) obj;
        return k.a((Object) this.message, (Object) redemptionResponse.message) && k.a((Object) this.masterStatus, (Object) redemptionResponse.masterStatus) && k.a((Object) this.redemptionList, (Object) redemptionResponse.redemptionList);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.masterStatus;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List<RedemptionResponseListItem> list = this.redemptionList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "RedemptionResponse(message=" + this.message + ", masterStatus=" + this.masterStatus + ", redemptionList=" + this.redemptionList + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getMasterStatus() {
        return this.masterStatus;
    }

    public RedemptionResponse(String str, Integer num, List<RedemptionResponseListItem> list) {
        this.message = str;
        this.masterStatus = num;
        this.redemptionList = list;
    }

    public final List<RedemptionResponseListItem> getRedemptionList() {
        return this.redemptionList;
    }
}
