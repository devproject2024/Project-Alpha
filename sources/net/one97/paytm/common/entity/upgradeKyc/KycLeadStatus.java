package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class KycLeadStatus extends IJRPaytmDataModel {
    @b(a = "kycType")
    private String kycType;
    @b(a = "screenId")
    private int screenId;
    @b(a = "statusCode")
    private int statusCode;
    @b(a = "timelineSRO")
    private List<SubStage> timlineSRO;

    public KycLeadStatus() {
        this((String) null, 0, 0, (List) null, 15, (g) null);
    }

    public static /* synthetic */ KycLeadStatus copy$default(KycLeadStatus kycLeadStatus, String str, int i2, int i3, List<SubStage> list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = kycLeadStatus.kycType;
        }
        if ((i4 & 2) != 0) {
            i2 = kycLeadStatus.statusCode;
        }
        if ((i4 & 4) != 0) {
            i3 = kycLeadStatus.screenId;
        }
        if ((i4 & 8) != 0) {
            list = kycLeadStatus.timlineSRO;
        }
        return kycLeadStatus.copy(str, i2, i3, list);
    }

    public final String component1() {
        return this.kycType;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final int component3() {
        return this.screenId;
    }

    public final List<SubStage> component4() {
        return this.timlineSRO;
    }

    public final KycLeadStatus copy(String str, int i2, int i3, List<SubStage> list) {
        k.c(str, "kycType");
        return new KycLeadStatus(str, i2, i3, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof KycLeadStatus) {
                KycLeadStatus kycLeadStatus = (KycLeadStatus) obj;
                if (k.a((Object) this.kycType, (Object) kycLeadStatus.kycType)) {
                    if (this.statusCode == kycLeadStatus.statusCode) {
                        if (!(this.screenId == kycLeadStatus.screenId) || !k.a((Object) this.timlineSRO, (Object) kycLeadStatus.timlineSRO)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.kycType;
        int i2 = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.statusCode) * 31) + this.screenId) * 31;
        List<SubStage> list = this.timlineSRO;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "KycLeadStatus(kycType=" + this.kycType + ", statusCode=" + this.statusCode + ", screenId=" + this.screenId + ", timlineSRO=" + this.timlineSRO + ")";
    }

    public final String getKycType() {
        return this.kycType;
    }

    public final void setKycType(String str) {
        k.c(str, "<set-?>");
        this.kycType = str;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public final int getScreenId() {
        return this.screenId;
    }

    public final void setScreenId(int i2) {
        this.screenId = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KycLeadStatus(String str, int i2, int i3, List list, int i4, g gVar) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? null : list);
    }

    public final List<SubStage> getTimlineSRO() {
        return this.timlineSRO;
    }

    public final void setTimlineSRO(List<SubStage> list) {
        this.timlineSRO = list;
    }

    public KycLeadStatus(String str, int i2, int i3, List<SubStage> list) {
        k.c(str, "kycType");
        this.kycType = str;
        this.statusCode = i2;
        this.screenId = i3;
        this.timlineSRO = list;
    }
}
