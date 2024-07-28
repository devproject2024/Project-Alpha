package net.one97.paytm.paymentsBank.chequebook.model;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SectionDivider implements IJRDataModel {
    private final String title;

    public static /* synthetic */ SectionDivider copy$default(SectionDivider sectionDivider, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sectionDivider.title;
        }
        return sectionDivider.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final SectionDivider copy(String str) {
        k.c(str, "title");
        return new SectionDivider(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SectionDivider) && k.a((Object) this.title, (Object) ((SectionDivider) obj).title);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.title;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SectionDivider(title=" + this.title + ")";
    }

    public SectionDivider(String str) {
        k.c(str, "title");
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }
}
