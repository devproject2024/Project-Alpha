package net.one97.paytm.hotel4.service.model.details;

import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Facilities {
    private Basic basic;
    private ArrayList<String> more;

    public Facilities() {
        this((Basic) null, (ArrayList) null, 3, (g) null);
    }

    public static /* synthetic */ Facilities copy$default(Facilities facilities, Basic basic2, ArrayList<String> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            basic2 = facilities.basic;
        }
        if ((i2 & 2) != 0) {
            arrayList = facilities.more;
        }
        return facilities.copy(basic2, arrayList);
    }

    public final Basic component1() {
        return this.basic;
    }

    public final ArrayList<String> component2() {
        return this.more;
    }

    public final Facilities copy(Basic basic2, ArrayList<String> arrayList) {
        return new Facilities(basic2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Facilities)) {
            return false;
        }
        Facilities facilities = (Facilities) obj;
        return k.a((Object) this.basic, (Object) facilities.basic) && k.a((Object) this.more, (Object) facilities.more);
    }

    public final int hashCode() {
        Basic basic2 = this.basic;
        int i2 = 0;
        int hashCode = (basic2 != null ? basic2.hashCode() : 0) * 31;
        ArrayList<String> arrayList = this.more;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Facilities(basic=" + this.basic + ", more=" + this.more + ")";
    }

    public Facilities(Basic basic2, ArrayList<String> arrayList) {
        this.basic = basic2;
        this.more = arrayList;
    }

    public final Basic getBasic() {
        return this.basic;
    }

    public final void setBasic(Basic basic2) {
        this.basic = basic2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Facilities(Basic basic2, ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : basic2, (i2 & 2) != 0 ? null : arrayList);
    }

    public final ArrayList<String> getMore() {
        return this.more;
    }

    public final void setMore(ArrayList<String> arrayList) {
        this.more = arrayList;
    }
}
