package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;

public final class CJRCPTerm implements Serializable {
    @b(a = "heading")
    private String heading;
    @b(a = "terms_content")
    private List<String> terms_content;

    public static /* synthetic */ CJRCPTerm copy$default(CJRCPTerm cJRCPTerm, String str, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCPTerm.heading;
        }
        if ((i2 & 2) != 0) {
            list = cJRCPTerm.terms_content;
        }
        return cJRCPTerm.copy(str, list);
    }

    public final String component1() {
        return this.heading;
    }

    public final List<String> component2() {
        return this.terms_content;
    }

    public final CJRCPTerm copy(String str, List<String> list) {
        return new CJRCPTerm(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPTerm)) {
            return false;
        }
        CJRCPTerm cJRCPTerm = (CJRCPTerm) obj;
        return k.a((Object) this.heading, (Object) cJRCPTerm.heading) && k.a((Object) this.terms_content, (Object) cJRCPTerm.terms_content);
    }

    public final int hashCode() {
        String str = this.heading;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.terms_content;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCPTerm(heading=" + this.heading + ", terms_content=" + this.terms_content + ")";
    }

    public CJRCPTerm(String str, List<String> list) {
        this.heading = str;
        this.terms_content = list;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final List<String> getTerms_content() {
        return this.terms_content;
    }

    public final void setTerms_content(List<String> list) {
        this.terms_content = list;
    }
}
