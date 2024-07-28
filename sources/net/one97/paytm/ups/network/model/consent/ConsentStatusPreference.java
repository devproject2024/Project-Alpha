package net.one97.paytm.ups.network.model.consent;

import kotlin.g.b.k;

public final class ConsentStatusPreference {
    private final boolean isDefault;
    private final String key;
    private final boolean value;

    public static /* synthetic */ ConsentStatusPreference copy$default(ConsentStatusPreference consentStatusPreference, boolean z, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = consentStatusPreference.isDefault;
        }
        if ((i2 & 2) != 0) {
            str = consentStatusPreference.key;
        }
        if ((i2 & 4) != 0) {
            z2 = consentStatusPreference.value;
        }
        return consentStatusPreference.copy(z, str, z2);
    }

    public final boolean component1() {
        return this.isDefault;
    }

    public final String component2() {
        return this.key;
    }

    public final boolean component3() {
        return this.value;
    }

    public final ConsentStatusPreference copy(boolean z, String str, boolean z2) {
        k.c(str, "key");
        return new ConsentStatusPreference(z, str, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentStatusPreference)) {
            return false;
        }
        ConsentStatusPreference consentStatusPreference = (ConsentStatusPreference) obj;
        return this.isDefault == consentStatusPreference.isDefault && k.a((Object) this.key, (Object) consentStatusPreference.key) && this.value == consentStatusPreference.value;
    }

    public final int hashCode() {
        boolean z = this.isDefault;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.key;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.value;
        if (!z3) {
            z2 = z3;
        }
        return hashCode + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "ConsentStatusPreference(isDefault=" + this.isDefault + ", key=" + this.key + ", value=" + this.value + ")";
    }

    public ConsentStatusPreference(boolean z, String str, boolean z2) {
        k.c(str, "key");
        this.isDefault = z;
        this.key = str;
        this.value = z2;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getValue() {
        return this.value;
    }
}
