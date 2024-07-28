package com.paytm.analytics.models;

import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CustomDimension {
    private Map<String, String> customDimension;

    public CustomDimension() {
        this((Map) null, 1, (g) null);
    }

    public static /* synthetic */ CustomDimension copy$default(CustomDimension customDimension2, Map<String, String> map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = customDimension2.customDimension;
        }
        return customDimension2.copy(map);
    }

    public final Map<String, String> component1$paytmanalytics_release() {
        return this.customDimension;
    }

    public final CustomDimension copy(Map<String, String> map) {
        return new CustomDimension(map);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CustomDimension) && k.a((Object) this.customDimension, (Object) ((CustomDimension) obj).customDimension);
        }
        return true;
    }

    public final int hashCode() {
        Map<String, String> map = this.customDimension;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CustomDimension(customDimension=" + this.customDimension + ")";
    }

    public CustomDimension(Map<String, String> map) {
        this.customDimension = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomDimension(Map map, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : map);
    }

    public final Map<String, String> getCustomDimension$paytmanalytics_release() {
        return this.customDimension;
    }

    public final void setCustomDimension$paytmanalytics_release(Map<String, String> map) {
        this.customDimension = map;
    }
}
