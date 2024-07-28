package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SubStage implements IJRDataModel {
    @b(a = "subStage")
    private String subStage;
    @b(a = "successTime")
    private String successTime;

    public SubStage() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ SubStage copy$default(SubStage subStage2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subStage2.subStage;
        }
        if ((i2 & 2) != 0) {
            str2 = subStage2.successTime;
        }
        return subStage2.copy(str, str2);
    }

    public final String component1() {
        return this.subStage;
    }

    public final String component2() {
        return this.successTime;
    }

    public final SubStage copy(String str, String str2) {
        return new SubStage(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubStage)) {
            return false;
        }
        SubStage subStage2 = (SubStage) obj;
        return k.a((Object) this.subStage, (Object) subStage2.subStage) && k.a((Object) this.successTime, (Object) subStage2.successTime);
    }

    public final int hashCode() {
        String str = this.subStage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.successTime;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SubStage(subStage=" + this.subStage + ", successTime=" + this.successTime + ")";
    }

    public SubStage(String str, String str2) {
        this.subStage = str;
        this.successTime = str2;
    }

    public final String getSubStage() {
        return this.subStage;
    }

    public final void setSubStage(String str) {
        this.subStage = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubStage(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getSuccessTime() {
        return this.successTime;
    }

    public final void setSuccessTime(String str) {
        this.successTime = str;
    }
}
