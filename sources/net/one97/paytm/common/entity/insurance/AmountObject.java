package net.one97.paytm.common.entity.insurance;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class AmountObject implements IJRDataModel {
    private List<Breakup> breakup;
    private String title;
    private String value;

    public static /* synthetic */ AmountObject copy$default(AmountObject amountObject, String str, String str2, List<Breakup> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = amountObject.title;
        }
        if ((i2 & 2) != 0) {
            str2 = amountObject.value;
        }
        if ((i2 & 4) != 0) {
            list = amountObject.breakup;
        }
        return amountObject.copy(str, str2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.value;
    }

    public final List<Breakup> component3() {
        return this.breakup;
    }

    public final AmountObject copy(String str, String str2, List<Breakup> list) {
        return new AmountObject(str, str2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AmountObject)) {
            return false;
        }
        AmountObject amountObject = (AmountObject) obj;
        return k.a((Object) this.title, (Object) amountObject.title) && k.a((Object) this.value, (Object) amountObject.value) && k.a((Object) this.breakup, (Object) amountObject.breakup);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Breakup> list = this.breakup;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AmountObject(title=" + this.title + ", value=" + this.value + ", breakup=" + this.breakup + ")";
    }

    public AmountObject(String str, String str2, List<Breakup> list) {
        this.title = str;
        this.value = str2;
        this.breakup = list;
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

    public final List<Breakup> getBreakup() {
        return this.breakup;
    }

    public final void setBreakup(List<Breakup> list) {
        this.breakup = list;
    }
}
