package net.one97.paytm.nativesdk.common.model;

import java.util.List;
import kotlin.g.b.k;

public final class EnabledPaymentMode {
    private final List<String> channels;
    private final String mode;

    public static /* synthetic */ EnabledPaymentMode copy$default(EnabledPaymentMode enabledPaymentMode, List<String> list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = enabledPaymentMode.channels;
        }
        if ((i2 & 2) != 0) {
            str = enabledPaymentMode.mode;
        }
        return enabledPaymentMode.copy(list, str);
    }

    public final List<String> component1() {
        return this.channels;
    }

    public final String component2() {
        return this.mode;
    }

    public final EnabledPaymentMode copy(List<String> list, String str) {
        k.c(list, "channels");
        k.c(str, "mode");
        return new EnabledPaymentMode(list, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnabledPaymentMode)) {
            return false;
        }
        EnabledPaymentMode enabledPaymentMode = (EnabledPaymentMode) obj;
        return k.a((Object) this.channels, (Object) enabledPaymentMode.channels) && k.a((Object) this.mode, (Object) enabledPaymentMode.mode);
    }

    public final int hashCode() {
        List<String> list = this.channels;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.mode;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "EnabledPaymentMode(channels=" + this.channels + ", mode=" + this.mode + ")";
    }

    public EnabledPaymentMode(List<String> list, String str) {
        k.c(list, "channels");
        k.c(str, "mode");
        this.channels = list;
        this.mode = str;
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final String getMode() {
        return this.mode;
    }
}
