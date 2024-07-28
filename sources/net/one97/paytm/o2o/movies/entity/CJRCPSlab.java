package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;

public final class CJRCPSlab implements Serializable {
    @b(a = "heading")
    private String heading;
    @b(a = "slabs_content")
    private List<CJRCPSlabItem> slabs_content;

    public static /* synthetic */ CJRCPSlab copy$default(CJRCPSlab cJRCPSlab, String str, List<CJRCPSlabItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCPSlab.heading;
        }
        if ((i2 & 2) != 0) {
            list = cJRCPSlab.slabs_content;
        }
        return cJRCPSlab.copy(str, list);
    }

    public final String component1() {
        return this.heading;
    }

    public final List<CJRCPSlabItem> component2() {
        return this.slabs_content;
    }

    public final CJRCPSlab copy(String str, List<CJRCPSlabItem> list) {
        return new CJRCPSlab(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPSlab)) {
            return false;
        }
        CJRCPSlab cJRCPSlab = (CJRCPSlab) obj;
        return k.a((Object) this.heading, (Object) cJRCPSlab.heading) && k.a((Object) this.slabs_content, (Object) cJRCPSlab.slabs_content);
    }

    public final int hashCode() {
        String str = this.heading;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<CJRCPSlabItem> list = this.slabs_content;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCPSlab(heading=" + this.heading + ", slabs_content=" + this.slabs_content + ")";
    }

    public CJRCPSlab(String str, List<CJRCPSlabItem> list) {
        this.heading = str;
        this.slabs_content = list;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final List<CJRCPSlabItem> getSlabs_content() {
        return this.slabs_content;
    }

    public final void setSlabs_content(List<CJRCPSlabItem> list) {
        this.slabs_content = list;
    }
}
