package com.paytm.contactsSdk.models.responses.Search;

import java.util.List;
import kotlin.g.b.k;

public final class Phones {
    private final String primaryMobile;
    private final List<String> secondaryMobile;

    public static /* synthetic */ Phones copy$default(Phones phones, String str, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = phones.primaryMobile;
        }
        if ((i2 & 2) != 0) {
            list = phones.secondaryMobile;
        }
        return phones.copy(str, list);
    }

    public final String component1() {
        return this.primaryMobile;
    }

    public final List<String> component2() {
        return this.secondaryMobile;
    }

    public final Phones copy(String str, List<String> list) {
        k.c(str, "primaryMobile");
        k.c(list, "secondaryMobile");
        return new Phones(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Phones)) {
            return false;
        }
        Phones phones = (Phones) obj;
        return k.a((Object) this.primaryMobile, (Object) phones.primaryMobile) && k.a((Object) this.secondaryMobile, (Object) phones.secondaryMobile);
    }

    public final int hashCode() {
        String str = this.primaryMobile;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.secondaryMobile;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Phones(primaryMobile=" + this.primaryMobile + ", secondaryMobile=" + this.secondaryMobile + ")";
    }

    public Phones(String str, List<String> list) {
        k.c(str, "primaryMobile");
        k.c(list, "secondaryMobile");
        this.primaryMobile = str;
        this.secondaryMobile = list;
    }

    public final String getPrimaryMobile() {
        return this.primaryMobile;
    }

    public final List<String> getSecondaryMobile() {
        return this.secondaryMobile;
    }
}
