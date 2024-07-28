package net.one97.paytm.upi.common.models;

import kotlin.g.b.k;

public final class FeatureActionMapping {
    private final String action;
    private final String feature;

    public static /* synthetic */ FeatureActionMapping copy$default(FeatureActionMapping featureActionMapping, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = featureActionMapping.feature;
        }
        if ((i2 & 2) != 0) {
            str2 = featureActionMapping.action;
        }
        return featureActionMapping.copy(str, str2);
    }

    public final String component1() {
        return this.feature;
    }

    public final String component2() {
        return this.action;
    }

    public final FeatureActionMapping copy(String str, String str2) {
        k.c(str, "feature");
        k.c(str2, "action");
        return new FeatureActionMapping(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureActionMapping)) {
            return false;
        }
        FeatureActionMapping featureActionMapping = (FeatureActionMapping) obj;
        return k.a((Object) this.feature, (Object) featureActionMapping.feature) && k.a((Object) this.action, (Object) featureActionMapping.action);
    }

    public final int hashCode() {
        String str = this.feature;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeatureActionMapping(feature=" + this.feature + ", action=" + this.action + ")";
    }

    public FeatureActionMapping(String str, String str2) {
        k.c(str, "feature");
        k.c(str2, "action");
        this.feature = str;
        this.action = str2;
    }

    public final String getFeature() {
        return this.feature;
    }

    public final String getAction() {
        return this.action;
    }
}
