package io.branch.referral;

import java.util.Collection;
import org.json.JSONObject;

final class g extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    Collection<String> f46481a;

    /* renamed from: b  reason: collision with root package name */
    String f46482b;

    /* renamed from: c  reason: collision with root package name */
    int f46483c;

    /* renamed from: d  reason: collision with root package name */
    String f46484d;

    /* renamed from: e  reason: collision with root package name */
    String f46485e;

    /* renamed from: f  reason: collision with root package name */
    String f46486f;

    /* renamed from: g  reason: collision with root package name */
    String f46487g;

    /* renamed from: h  reason: collision with root package name */
    JSONObject f46488h;

    /* renamed from: i  reason: collision with root package name */
    int f46489i;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        String str = this.f46482b;
        if (str == null) {
            if (gVar.f46482b != null) {
                return false;
            }
        } else if (!str.equals(gVar.f46482b)) {
            return false;
        }
        String str2 = this.f46484d;
        if (str2 == null) {
            if (gVar.f46484d != null) {
                return false;
            }
        } else if (!str2.equals(gVar.f46484d)) {
            return false;
        }
        String str3 = this.f46485e;
        if (str3 == null) {
            if (gVar.f46485e != null) {
                return false;
            }
        } else if (!str3.equals(gVar.f46485e)) {
            return false;
        }
        JSONObject jSONObject = this.f46488h;
        if (jSONObject == null) {
            if (gVar.f46488h != null) {
                return false;
            }
        } else if (!jSONObject.equals(gVar.f46488h)) {
            return false;
        }
        String str4 = this.f46486f;
        if (str4 == null) {
            if (gVar.f46486f != null) {
                return false;
            }
        } else if (!str4.equals(gVar.f46486f)) {
            return false;
        }
        String str5 = this.f46487g;
        if (str5 == null) {
            if (gVar.f46487g != null) {
                return false;
            }
        } else if (!str5.equals(gVar.f46487g)) {
            return false;
        }
        if (this.f46483c != gVar.f46483c || this.f46489i != gVar.f46489i) {
            return false;
        }
        Collection<String> collection = this.f46481a;
        if (collection == null) {
            if (gVar.f46481a != null) {
                return false;
            }
        } else if (!collection.toString().equals(gVar.f46481a.toString())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = (this.f46483c + 19) * 19;
        String str = this.f46482b;
        int i8 = 0;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.toLowerCase().hashCode();
        }
        int i9 = (i7 + i2) * 19;
        String str2 = this.f46484d;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = str2.toLowerCase().hashCode();
        }
        int i10 = (i9 + i3) * 19;
        String str3 = this.f46485e;
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = str3.toLowerCase().hashCode();
        }
        int i11 = (i10 + i4) * 19;
        String str4 = this.f46486f;
        if (str4 == null) {
            i5 = 0;
        } else {
            i5 = str4.toLowerCase().hashCode();
        }
        int i12 = (i11 + i5) * 19;
        String str5 = this.f46487g;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.toLowerCase().hashCode();
        }
        int i13 = (i12 + i6) * 19;
        JSONObject jSONObject = this.f46488h;
        if (jSONObject != null) {
            i8 = jSONObject.toString().toLowerCase().hashCode();
        }
        int i14 = ((i13 + i8) * 19) + this.f46489i;
        Collection<String> collection = this.f46481a;
        if (collection != null) {
            for (String lowerCase : collection) {
                i14 = (i14 * 19) + lowerCase.toLowerCase().hashCode();
            }
        }
        return i14;
    }
}
