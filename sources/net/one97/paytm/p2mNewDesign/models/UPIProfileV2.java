package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class UPIProfileV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "priority")
    private String priority;
    @b(a = "respDetails")
    private RespDetailsV2 respDetails;
    @b(a = "upiOnboarding")
    private Boolean upiOnboarding;

    public UPIProfileV2() {
        this((Boolean) null, (RespDetailsV2) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ UPIProfileV2 copy$default(UPIProfileV2 uPIProfileV2, Boolean bool, RespDetailsV2 respDetailsV2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = uPIProfileV2.upiOnboarding;
        }
        if ((i2 & 2) != 0) {
            respDetailsV2 = uPIProfileV2.respDetails;
        }
        if ((i2 & 4) != 0) {
            str = uPIProfileV2.priority;
        }
        return uPIProfileV2.copy(bool, respDetailsV2, str);
    }

    public final Boolean component1() {
        return this.upiOnboarding;
    }

    public final RespDetailsV2 component2() {
        return this.respDetails;
    }

    public final String component3() {
        return this.priority;
    }

    public final UPIProfileV2 copy(Boolean bool, RespDetailsV2 respDetailsV2, String str) {
        return new UPIProfileV2(bool, respDetailsV2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UPIProfileV2)) {
            return false;
        }
        UPIProfileV2 uPIProfileV2 = (UPIProfileV2) obj;
        return k.a((Object) this.upiOnboarding, (Object) uPIProfileV2.upiOnboarding) && k.a((Object) this.respDetails, (Object) uPIProfileV2.respDetails) && k.a((Object) this.priority, (Object) uPIProfileV2.priority);
    }

    public final int hashCode() {
        Boolean bool = this.upiOnboarding;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        RespDetailsV2 respDetailsV2 = this.respDetails;
        int hashCode2 = (hashCode + (respDetailsV2 != null ? respDetailsV2.hashCode() : 0)) * 31;
        String str = this.priority;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UPIProfileV2(upiOnboarding=" + this.upiOnboarding + ", respDetails=" + this.respDetails + ", priority=" + this.priority + ")";
    }

    public UPIProfileV2(Boolean bool, RespDetailsV2 respDetailsV2, String str) {
        this.upiOnboarding = bool;
        this.respDetails = respDetailsV2;
        this.priority = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UPIProfileV2(Boolean bool, RespDetailsV2 respDetailsV2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? null : respDetailsV2, (i2 & 4) != 0 ? null : str);
    }

    public final String getPriority() {
        return this.priority;
    }

    public final RespDetailsV2 getRespDetails() {
        return this.respDetails;
    }

    public final Boolean getUpiOnboarding() {
        return this.upiOnboarding;
    }

    public final void setPriority(String str) {
        this.priority = str;
    }

    public final void setRespDetails(RespDetailsV2 respDetailsV2) {
        this.respDetails = respDetailsV2;
    }

    public final void setUpiOnboarding(Boolean bool) {
        this.upiOnboarding = bool;
    }
}
