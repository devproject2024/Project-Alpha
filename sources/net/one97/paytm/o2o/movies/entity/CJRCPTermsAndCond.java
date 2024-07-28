package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.k;

public final class CJRCPTermsAndCond implements Serializable {
    @b(a = "slabs")
    private CJRCPSlab slabs;
    @b(a = "terms")
    private CJRCPTerm terms;

    public static /* synthetic */ CJRCPTermsAndCond copy$default(CJRCPTermsAndCond cJRCPTermsAndCond, CJRCPTerm cJRCPTerm, CJRCPSlab cJRCPSlab, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRCPTerm = cJRCPTermsAndCond.terms;
        }
        if ((i2 & 2) != 0) {
            cJRCPSlab = cJRCPTermsAndCond.slabs;
        }
        return cJRCPTermsAndCond.copy(cJRCPTerm, cJRCPSlab);
    }

    public final CJRCPTerm component1() {
        return this.terms;
    }

    public final CJRCPSlab component2() {
        return this.slabs;
    }

    public final CJRCPTermsAndCond copy(CJRCPTerm cJRCPTerm, CJRCPSlab cJRCPSlab) {
        return new CJRCPTermsAndCond(cJRCPTerm, cJRCPSlab);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPTermsAndCond)) {
            return false;
        }
        CJRCPTermsAndCond cJRCPTermsAndCond = (CJRCPTermsAndCond) obj;
        return k.a((Object) this.terms, (Object) cJRCPTermsAndCond.terms) && k.a((Object) this.slabs, (Object) cJRCPTermsAndCond.slabs);
    }

    public final int hashCode() {
        CJRCPTerm cJRCPTerm = this.terms;
        int i2 = 0;
        int hashCode = (cJRCPTerm != null ? cJRCPTerm.hashCode() : 0) * 31;
        CJRCPSlab cJRCPSlab = this.slabs;
        if (cJRCPSlab != null) {
            i2 = cJRCPSlab.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCPTermsAndCond(terms=" + this.terms + ", slabs=" + this.slabs + ")";
    }

    public CJRCPTermsAndCond(CJRCPTerm cJRCPTerm, CJRCPSlab cJRCPSlab) {
        this.terms = cJRCPTerm;
        this.slabs = cJRCPSlab;
    }

    public final CJRCPTerm getTerms() {
        return this.terms;
    }

    public final void setTerms(CJRCPTerm cJRCPTerm) {
        this.terms = cJRCPTerm;
    }

    public final CJRCPSlab getSlabs() {
        return this.slabs;
    }

    public final void setSlabs(CJRCPSlab cJRCPSlab) {
        this.slabs = cJRCPSlab;
    }
}
