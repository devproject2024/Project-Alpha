package net.one97.paytm.upi.common.models;

import java.util.List;
import kotlin.g.b.k;

public final class SmartTransferFeature {
    private final String deviceId;
    private final List<FeatureActionMapping> featureActionMapping;
    private final String mobile;

    public static /* synthetic */ SmartTransferFeature copy$default(SmartTransferFeature smartTransferFeature, String str, List<FeatureActionMapping> list, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smartTransferFeature.deviceId;
        }
        if ((i2 & 2) != 0) {
            list = smartTransferFeature.featureActionMapping;
        }
        if ((i2 & 4) != 0) {
            str2 = smartTransferFeature.mobile;
        }
        return smartTransferFeature.copy(str, list, str2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final List<FeatureActionMapping> component2() {
        return this.featureActionMapping;
    }

    public final String component3() {
        return this.mobile;
    }

    public final SmartTransferFeature copy(String str, List<FeatureActionMapping> list, String str2) {
        k.c(str, "deviceId");
        k.c(list, "featureActionMapping");
        k.c(str2, "mobile");
        return new SmartTransferFeature(str, list, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartTransferFeature)) {
            return false;
        }
        SmartTransferFeature smartTransferFeature = (SmartTransferFeature) obj;
        return k.a((Object) this.deviceId, (Object) smartTransferFeature.deviceId) && k.a((Object) this.featureActionMapping, (Object) smartTransferFeature.featureActionMapping) && k.a((Object) this.mobile, (Object) smartTransferFeature.mobile);
    }

    public final int hashCode() {
        String str = this.deviceId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FeatureActionMapping> list = this.featureActionMapping;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.mobile;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SmartTransferFeature(deviceId=" + this.deviceId + ", featureActionMapping=" + this.featureActionMapping + ", mobile=" + this.mobile + ")";
    }

    public SmartTransferFeature(String str, List<FeatureActionMapping> list, String str2) {
        k.c(str, "deviceId");
        k.c(list, "featureActionMapping");
        k.c(str2, "mobile");
        this.deviceId = str;
        this.featureActionMapping = list;
        this.mobile = str2;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final List<FeatureActionMapping> getFeatureActionMapping() {
        return this.featureActionMapping;
    }

    public final String getMobile() {
        return this.mobile;
    }
}
