package com.business.merchant_payments.ups;

import kotlin.g.b.k;

public final class Preferences {
    public final Boolean isDefault;
    public String key;
    public final String value;

    public static /* synthetic */ Preferences copy$default(Preferences preferences, String str, String str2, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preferences.key;
        }
        if ((i2 & 2) != 0) {
            str2 = preferences.value;
        }
        if ((i2 & 4) != 0) {
            bool = preferences.isDefault;
        }
        return preferences.copy(str, str2, bool);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final Preferences copy(String str, String str2, Boolean bool) {
        return new Preferences(str, str2, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preferences)) {
            return false;
        }
        Preferences preferences = (Preferences) obj;
        return k.a((Object) this.key, (Object) preferences.key) && k.a((Object) this.value, (Object) preferences.value) && k.a((Object) this.isDefault, (Object) preferences.isDefault);
    }

    public final int hashCode() {
        String str = this.key;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.isDefault;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Preferences(key=" + this.key + ", value=" + this.value + ", isDefault=" + this.isDefault + ")";
    }

    public Preferences(String str, String str2, Boolean bool) {
        this.key = str;
        this.value = str2;
        this.isDefault = bool;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }
}
