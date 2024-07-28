package com.paytm.utility.a;

import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f43683a;

    /* renamed from: b  reason: collision with root package name */
    public String f43684b;

    /* renamed from: c  reason: collision with root package name */
    public String f43685c;

    /* renamed from: d  reason: collision with root package name */
    public String f43686d;

    /* renamed from: e  reason: collision with root package name */
    public String f43687e;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (!(this.f43683a == cVar.f43683a) || !k.a((Object) this.f43684b, (Object) cVar.f43684b) || !k.a((Object) this.f43685c, (Object) cVar.f43685c) || !k.a((Object) this.f43686d, (Object) cVar.f43686d) || !k.a((Object) this.f43687e, (Object) cVar.f43687e)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f43683a * 31;
        String str = this.f43684b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f43685c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f43686d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f43687e;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return hashCode3 + i3;
    }

    public final String toString() {
        return "ImgLibHawkeyeEvents(responseCode=" + this.f43683a + ", exception=" + this.f43684b + ", uri=" + this.f43685c + ", verticalName=" + this.f43686d + ", screenName=" + this.f43687e + ")";
    }

    private c() {
        this.f43683a = 0;
        this.f43684b = null;
        this.f43685c = null;
        this.f43686d = null;
        this.f43687e = null;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }
}
