package net.one97.paytm.acceptPayment.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MerchantInfo {
    private Boolean hasPaymentLinkPermission;
    private Boolean isSDMerchant;
    private String mId;

    public MerchantInfo() {
        this((String) null, (Boolean) null, (Boolean) null, 7, (g) null);
    }

    public MerchantInfo(String str) {
        this(str, (Boolean) null, (Boolean) null, 6, (g) null);
    }

    public MerchantInfo(String str, Boolean bool) {
        this(str, bool, (Boolean) null, 4, (g) null);
    }

    public static /* synthetic */ MerchantInfo copy$default(MerchantInfo merchantInfo, String str, Boolean bool, Boolean bool2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantInfo.mId;
        }
        if ((i2 & 2) != 0) {
            bool = merchantInfo.isSDMerchant;
        }
        if ((i2 & 4) != 0) {
            bool2 = merchantInfo.hasPaymentLinkPermission;
        }
        return merchantInfo.copy(str, bool, bool2);
    }

    public final String component1() {
        return this.mId;
    }

    public final Boolean component2() {
        return this.isSDMerchant;
    }

    public final Boolean component3() {
        return this.hasPaymentLinkPermission;
    }

    public final MerchantInfo copy(String str, Boolean bool, Boolean bool2) {
        return new MerchantInfo(str, bool, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantInfo)) {
            return false;
        }
        MerchantInfo merchantInfo = (MerchantInfo) obj;
        return k.a((Object) this.mId, (Object) merchantInfo.mId) && k.a((Object) this.isSDMerchant, (Object) merchantInfo.isSDMerchant) && k.a((Object) this.hasPaymentLinkPermission, (Object) merchantInfo.hasPaymentLinkPermission);
    }

    public final int hashCode() {
        String str = this.mId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.isSDMerchant;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasPaymentLinkPermission;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "MerchantInfo(mId=" + this.mId + ", isSDMerchant=" + this.isSDMerchant + ", hasPaymentLinkPermission=" + this.hasPaymentLinkPermission + ")";
    }

    public MerchantInfo(String str, Boolean bool, Boolean bool2) {
        this.mId = str;
        this.isSDMerchant = bool;
        this.hasPaymentLinkPermission = bool2;
    }

    public final String getMId() {
        return this.mId;
    }

    public final void setMId(String str) {
        this.mId = str;
    }

    public final Boolean isSDMerchant() {
        return this.isSDMerchant;
    }

    public final void setSDMerchant(Boolean bool) {
        this.isSDMerchant = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantInfo(String str, Boolean bool, Boolean bool2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : bool, (i2 & 4) != 0 ? null : bool2);
    }

    public final Boolean getHasPaymentLinkPermission() {
        return this.hasPaymentLinkPermission;
    }

    public final void setHasPaymentLinkPermission(Boolean bool) {
        this.hasPaymentLinkPermission = bool;
    }
}
