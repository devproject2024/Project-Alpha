package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.network.CJRWalletDataModel;

public final class RespDetailsV2 extends CJRWalletDataModel {
    @b(a = "metaDetails")
    private MetaDetailsV2 metaDetails;
    @b(a = "profileDetail")
    private ProfileDetailV2 profileDetail;

    public RespDetailsV2() {
        this((MetaDetailsV2) null, (ProfileDetailV2) null, 3, (g) null);
    }

    public static /* synthetic */ RespDetailsV2 copy$default(RespDetailsV2 respDetailsV2, MetaDetailsV2 metaDetailsV2, ProfileDetailV2 profileDetailV2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            metaDetailsV2 = respDetailsV2.metaDetails;
        }
        if ((i2 & 2) != 0) {
            profileDetailV2 = respDetailsV2.profileDetail;
        }
        return respDetailsV2.copy(metaDetailsV2, profileDetailV2);
    }

    public final MetaDetailsV2 component1() {
        return this.metaDetails;
    }

    public final ProfileDetailV2 component2() {
        return this.profileDetail;
    }

    public final RespDetailsV2 copy(MetaDetailsV2 metaDetailsV2, ProfileDetailV2 profileDetailV2) {
        return new RespDetailsV2(metaDetailsV2, profileDetailV2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RespDetailsV2)) {
            return false;
        }
        RespDetailsV2 respDetailsV2 = (RespDetailsV2) obj;
        return k.a((Object) this.metaDetails, (Object) respDetailsV2.metaDetails) && k.a((Object) this.profileDetail, (Object) respDetailsV2.profileDetail);
    }

    public final int hashCode() {
        MetaDetailsV2 metaDetailsV2 = this.metaDetails;
        int i2 = 0;
        int hashCode = (metaDetailsV2 != null ? metaDetailsV2.hashCode() : 0) * 31;
        ProfileDetailV2 profileDetailV2 = this.profileDetail;
        if (profileDetailV2 != null) {
            i2 = profileDetailV2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "RespDetailsV2(metaDetails=" + this.metaDetails + ", profileDetail=" + this.profileDetail + ")";
    }

    public RespDetailsV2(MetaDetailsV2 metaDetailsV2, ProfileDetailV2 profileDetailV2) {
        this.metaDetails = metaDetailsV2;
        this.profileDetail = profileDetailV2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RespDetailsV2(MetaDetailsV2 metaDetailsV2, ProfileDetailV2 profileDetailV2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : metaDetailsV2, (i2 & 2) != 0 ? null : profileDetailV2);
    }

    public final MetaDetailsV2 getMetaDetails() {
        return this.metaDetails;
    }

    public final ProfileDetailV2 getProfileDetail() {
        return this.profileDetail;
    }

    public final void setMetaDetails(MetaDetailsV2 metaDetailsV2) {
        this.metaDetails = metaDetailsV2;
    }

    public final void setProfileDetail(ProfileDetailV2 profileDetailV2) {
        this.profileDetail = profileDetailV2;
    }
}
