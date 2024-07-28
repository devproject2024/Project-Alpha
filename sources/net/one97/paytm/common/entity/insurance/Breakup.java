package net.one97.paytm.common.entity.insurance;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Breakup implements IJRDataModel {
    private String gender;
    private String title;
    private String value;

    public static /* synthetic */ Breakup copy$default(Breakup breakup, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = breakup.title;
        }
        if ((i2 & 2) != 0) {
            str2 = breakup.value;
        }
        if ((i2 & 4) != 0) {
            str3 = breakup.gender;
        }
        return breakup.copy(str, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.gender;
    }

    public final Breakup copy(String str, String str2, String str3) {
        return new Breakup(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Breakup)) {
            return false;
        }
        Breakup breakup = (Breakup) obj;
        return k.a((Object) this.title, (Object) breakup.title) && k.a((Object) this.value, (Object) breakup.value) && k.a((Object) this.gender, (Object) breakup.gender);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.gender;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Breakup(title=" + this.title + ", value=" + this.value + ", gender=" + this.gender + ")";
    }

    public Breakup(String str, String str2, String str3) {
        this.title = str;
        this.value = str2;
        this.gender = str3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String str) {
        this.gender = str;
    }
}
