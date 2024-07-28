package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class CFSMerchantDataModel implements Serializable {
    @c(a = "following")
    private final Boolean following;
    @c(a = "isFollowing")
    private Boolean isFollowing;
    @c(a = "merchantId")
    private final String merchantId;
    @c(a = "name")
    private final String name;
    @c(a = "partnerId")
    private final String partnerId;
    @c(a = "rating")
    private final Integer rating;
    @c(a = "ratingCount")
    private final Integer ratingCount;
    @c(a = "rnrStatus")
    private final String rnrStatus;
    @c(a = "type")
    private final String type;

    public static /* synthetic */ CFSMerchantDataModel copy$default(CFSMerchantDataModel cFSMerchantDataModel, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Boolean bool, Boolean bool2, int i2, Object obj) {
        CFSMerchantDataModel cFSMerchantDataModel2 = cFSMerchantDataModel;
        int i3 = i2;
        return cFSMerchantDataModel.copy((i3 & 1) != 0 ? cFSMerchantDataModel2.name : str, (i3 & 2) != 0 ? cFSMerchantDataModel2.merchantId : str2, (i3 & 4) != 0 ? cFSMerchantDataModel2.type : str3, (i3 & 8) != 0 ? cFSMerchantDataModel2.rating : num, (i3 & 16) != 0 ? cFSMerchantDataModel2.ratingCount : num2, (i3 & 32) != 0 ? cFSMerchantDataModel2.rnrStatus : str4, (i3 & 64) != 0 ? cFSMerchantDataModel2.partnerId : str5, (i3 & 128) != 0 ? cFSMerchantDataModel2.following : bool, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cFSMerchantDataModel2.isFollowing : bool2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.merchantId;
    }

    public final String component3() {
        return this.type;
    }

    public final Integer component4() {
        return this.rating;
    }

    public final Integer component5() {
        return this.ratingCount;
    }

    public final String component6() {
        return this.rnrStatus;
    }

    public final String component7() {
        return this.partnerId;
    }

    public final Boolean component8() {
        return this.following;
    }

    public final Boolean component9() {
        return this.isFollowing;
    }

    public final CFSMerchantDataModel copy(String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Boolean bool, Boolean bool2) {
        return new CFSMerchantDataModel(str, str2, str3, num, num2, str4, str5, bool, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CFSMerchantDataModel)) {
            return false;
        }
        CFSMerchantDataModel cFSMerchantDataModel = (CFSMerchantDataModel) obj;
        return k.a((Object) this.name, (Object) cFSMerchantDataModel.name) && k.a((Object) this.merchantId, (Object) cFSMerchantDataModel.merchantId) && k.a((Object) this.type, (Object) cFSMerchantDataModel.type) && k.a((Object) this.rating, (Object) cFSMerchantDataModel.rating) && k.a((Object) this.ratingCount, (Object) cFSMerchantDataModel.ratingCount) && k.a((Object) this.rnrStatus, (Object) cFSMerchantDataModel.rnrStatus) && k.a((Object) this.partnerId, (Object) cFSMerchantDataModel.partnerId) && k.a((Object) this.following, (Object) cFSMerchantDataModel.following) && k.a((Object) this.isFollowing, (Object) cFSMerchantDataModel.isFollowing);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.rating;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.ratingCount;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str4 = this.rnrStatus;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.partnerId;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Boolean bool = this.following;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isFollowing;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "CFSMerchantDataModel(name=" + this.name + ", merchantId=" + this.merchantId + ", type=" + this.type + ", rating=" + this.rating + ", ratingCount=" + this.ratingCount + ", rnrStatus=" + this.rnrStatus + ", partnerId=" + this.partnerId + ", following=" + this.following + ", isFollowing=" + this.isFollowing + ")";
    }

    public CFSMerchantDataModel(String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Boolean bool, Boolean bool2) {
        this.name = str;
        this.merchantId = str2;
        this.type = str3;
        this.rating = num;
        this.ratingCount = num2;
        this.rnrStatus = str4;
        this.partnerId = str5;
        this.following = bool;
        this.isFollowing = bool2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getRating() {
        return this.rating;
    }

    public final Integer getRatingCount() {
        return this.ratingCount;
    }

    public final String getRnrStatus() {
        return this.rnrStatus;
    }

    public final String getPartnerId() {
        return this.partnerId;
    }

    public final Boolean getFollowing() {
        return this.following;
    }

    public final Boolean isFollowing() {
        return this.isFollowing;
    }

    public final void setFollowing(Boolean bool) {
        this.isFollowing = bool;
    }
}
