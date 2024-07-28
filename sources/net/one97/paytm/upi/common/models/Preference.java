package net.one97.paytm.upi.common.models;

import kotlin.g.b.k;

public final class Preference {
    private final boolean isDefault;
    private final String key;
    private final String value;

    public static /* synthetic */ Preference copy$default(Preference preference, boolean z, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = preference.isDefault;
        }
        if ((i2 & 2) != 0) {
            str = preference.key;
        }
        if ((i2 & 4) != 0) {
            str2 = preference.value;
        }
        return preference.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.isDefault;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.value;
    }

    public final Preference copy(boolean z, String str, String str2) {
        k.c(str, "key");
        k.c(str2, "value");
        return new Preference(z, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return this.isDefault == preference.isDefault && k.a((Object) this.key, (Object) preference.key) && k.a((Object) this.value, (Object) preference.value);
    }

    public final int hashCode() {
        boolean z = this.isDefault;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.key;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "Preference(isDefault=" + this.isDefault + ", key=" + this.key + ", value=" + this.value + ")";
    }

    public Preference(boolean z, String str, String str2) {
        k.c(str, "key");
        k.c(str2, "value");
        this.isDefault = z;
        this.key = str;
        this.value = str2;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }
}
