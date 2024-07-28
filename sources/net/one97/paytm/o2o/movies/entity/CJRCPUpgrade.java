package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.k;

public final class CJRCPUpgrade {
    @b(a = "default")

    /* renamed from: default  reason: not valid java name */
    private String f669default;
    @b(a = "options")
    private List<CJRCPSelectionItem> options;

    public static /* synthetic */ CJRCPUpgrade copy$default(CJRCPUpgrade cJRCPUpgrade, String str, List<CJRCPSelectionItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCPUpgrade.f669default;
        }
        if ((i2 & 2) != 0) {
            list = cJRCPUpgrade.options;
        }
        return cJRCPUpgrade.copy(str, list);
    }

    public final String component1() {
        return this.f669default;
    }

    public final List<CJRCPSelectionItem> component2() {
        return this.options;
    }

    public final CJRCPUpgrade copy(String str, List<CJRCPSelectionItem> list) {
        return new CJRCPUpgrade(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPUpgrade)) {
            return false;
        }
        CJRCPUpgrade cJRCPUpgrade = (CJRCPUpgrade) obj;
        return k.a((Object) this.f669default, (Object) cJRCPUpgrade.f669default) && k.a((Object) this.options, (Object) cJRCPUpgrade.options);
    }

    public final int hashCode() {
        String str = this.f669default;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<CJRCPSelectionItem> list = this.options;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCPUpgrade(default=" + this.f669default + ", options=" + this.options + ")";
    }

    public CJRCPUpgrade(String str, List<CJRCPSelectionItem> list) {
        this.f669default = str;
        this.options = list;
    }

    public final String getDefault() {
        return this.f669default;
    }

    public final void setDefault(String str) {
        this.f669default = str;
    }

    public final List<CJRCPSelectionItem> getOptions() {
        return this.options;
    }

    public final void setOptions(List<CJRCPSelectionItem> list) {
        this.options = list;
    }
}
