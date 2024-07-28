package net.one97.paytm.smssdk.model;

import kotlin.g.b.k;

public final class Preference {
    private final String prefCat;
    private final String prefKeys;
    private final String prefSubCat;

    public static /* synthetic */ Preference copy$default(Preference preference, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preference.prefCat;
        }
        if ((i2 & 2) != 0) {
            str2 = preference.prefKeys;
        }
        if ((i2 & 4) != 0) {
            str3 = preference.prefSubCat;
        }
        return preference.copy(str, str2, str3);
    }

    public final String component1() {
        return this.prefCat;
    }

    public final String component2() {
        return this.prefKeys;
    }

    public final String component3() {
        return this.prefSubCat;
    }

    public final Preference copy(String str, String str2, String str3) {
        k.c(str, "prefCat");
        k.c(str2, "prefKeys");
        k.c(str3, "prefSubCat");
        return new Preference(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return k.a((Object) this.prefCat, (Object) preference.prefCat) && k.a((Object) this.prefKeys, (Object) preference.prefKeys) && k.a((Object) this.prefSubCat, (Object) preference.prefSubCat);
    }

    public final int hashCode() {
        String str = this.prefCat;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.prefKeys;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.prefSubCat;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Preference(prefCat=" + this.prefCat + ", prefKeys=" + this.prefKeys + ", prefSubCat=" + this.prefSubCat + ")";
    }

    public Preference(String str, String str2, String str3) {
        k.c(str, "prefCat");
        k.c(str2, "prefKeys");
        k.c(str3, "prefSubCat");
        this.prefCat = str;
        this.prefKeys = str2;
        this.prefSubCat = str3;
    }

    public final String getPrefCat() {
        return this.prefCat;
    }

    public final String getPrefKeys() {
        return this.prefKeys;
    }

    public final String getPrefSubCat() {
        return this.prefSubCat;
    }
}
