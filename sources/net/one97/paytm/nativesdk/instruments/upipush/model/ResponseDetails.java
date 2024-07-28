package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class ResponseDetails implements BaseDataModel {
    private MetaData metaDetails;
    private ProfileData profileDetail;

    public static /* synthetic */ ResponseDetails copy$default(ResponseDetails responseDetails, ProfileData profileData, MetaData metaData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            profileData = responseDetails.profileDetail;
        }
        if ((i2 & 2) != 0) {
            metaData = responseDetails.metaDetails;
        }
        return responseDetails.copy(profileData, metaData);
    }

    public final ProfileData component1() {
        return this.profileDetail;
    }

    public final MetaData component2() {
        return this.metaDetails;
    }

    public final ResponseDetails copy(ProfileData profileData, MetaData metaData) {
        return new ResponseDetails(profileData, metaData);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseDetails)) {
            return false;
        }
        ResponseDetails responseDetails = (ResponseDetails) obj;
        return k.a((Object) this.profileDetail, (Object) responseDetails.profileDetail) && k.a((Object) this.metaDetails, (Object) responseDetails.metaDetails);
    }

    public final int hashCode() {
        ProfileData profileData = this.profileDetail;
        int i2 = 0;
        int hashCode = (profileData != null ? profileData.hashCode() : 0) * 31;
        MetaData metaData = this.metaDetails;
        if (metaData != null) {
            i2 = metaData.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ResponseDetails(profileDetail=" + this.profileDetail + ", metaDetails=" + this.metaDetails + ")";
    }

    public ResponseDetails(ProfileData profileData, MetaData metaData) {
        this.profileDetail = profileData;
        this.metaDetails = metaData;
    }

    public final ProfileData getProfileDetail() {
        return this.profileDetail;
    }

    public final void setProfileDetail(ProfileData profileData) {
        this.profileDetail = profileData;
    }

    public final MetaData getMetaDetails() {
        return this.metaDetails;
    }

    public final void setMetaDetails(MetaData metaData) {
        this.metaDetails = metaData;
    }
}
