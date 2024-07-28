package net.one97.paytm.smssdk.model;

import kotlin.g.b.k;

public final class ConsentUpdatePreference {
    private String key;
    private boolean value;

    public static /* synthetic */ ConsentUpdatePreference copy$default(ConsentUpdatePreference consentUpdatePreference, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consentUpdatePreference.key;
        }
        if ((i2 & 2) != 0) {
            z = consentUpdatePreference.value;
        }
        return consentUpdatePreference.copy(str, z);
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component2() {
        return this.value;
    }

    public final ConsentUpdatePreference copy(String str, boolean z) {
        k.c(str, "key");
        return new ConsentUpdatePreference(str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentUpdatePreference)) {
            return false;
        }
        ConsentUpdatePreference consentUpdatePreference = (ConsentUpdatePreference) obj;
        return k.a((Object) this.key, (Object) consentUpdatePreference.key) && this.value == consentUpdatePreference.value;
    }

    public final int hashCode() {
        String str = this.key;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.value;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "ConsentUpdatePreference(key=" + this.key + ", value=" + this.value + ")";
    }

    public ConsentUpdatePreference(String str, boolean z) {
        k.c(str, "key");
        this.key = str;
        this.value = z;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        k.c(str, "<set-?>");
        this.key = str;
    }

    public final boolean getValue() {
        return this.value;
    }

    public final void setValue(boolean z) {
        this.value = z;
    }
}
