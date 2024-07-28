package com.paytm.contactsSdk.models.requests;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class Phones {
    private final String primaryMobile;
    private final ArrayList<String> secondaryMobile;

    public static /* synthetic */ Phones copy$default(Phones phones, String str, ArrayList<String> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = phones.primaryMobile;
        }
        if ((i2 & 2) != 0) {
            arrayList = phones.secondaryMobile;
        }
        return phones.copy(str, arrayList);
    }

    public final String component1() {
        return this.primaryMobile;
    }

    public final ArrayList<String> component2() {
        return this.secondaryMobile;
    }

    public final Phones copy(String str, ArrayList<String> arrayList) {
        k.c(arrayList, "secondaryMobile");
        return new Phones(str, arrayList);
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
        ArrayList<String> arrayList = this.secondaryMobile;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Phones(primaryMobile=" + this.primaryMobile + ", secondaryMobile=" + this.secondaryMobile + ")";
    }

    public Phones(String str, ArrayList<String> arrayList) {
        k.c(arrayList, "secondaryMobile");
        this.primaryMobile = str;
        this.secondaryMobile = arrayList;
    }

    public final String getPrimaryMobile() {
        return this.primaryMobile;
    }

    public final ArrayList<String> getSecondaryMobile() {
        return this.secondaryMobile;
    }
}
