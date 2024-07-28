package net.one97.paytm.v2.features.cashbacklanding.model;

import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f20288a;

    /* renamed from: b  reason: collision with root package name */
    public String f20289b;

    /* renamed from: c  reason: collision with root package name */
    public String f20290c;

    /* renamed from: d  reason: collision with root package name */
    public String f20291d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20292e;

    /* renamed from: f  reason: collision with root package name */
    public int f20293f;

    /* renamed from: g  reason: collision with root package name */
    public String f20294g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20296i;
    public boolean j;
    public String k;
    public String l;
    public Long m;
    public String n;
    public String o;
    public String p;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, String str2, String str3, String str4, int i2, int i3) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? 0 : i2, false);
    }

    public a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f20288a = str;
        this.f20289b = str2;
        this.f20290c = str3;
        this.f20291d = str4;
        this.f20292e = z;
        this.f20293f = i2;
    }

    public /* synthetic */ a(String str, String str2, String str3, int i2, byte b2) {
        this(str, str2, str3, i2);
    }

    private a(String str, String str2, String str3, int i2) {
        k.c(str, "id");
        this.f20288a = str2;
        this.f20289b = null;
        this.f20290c = str3;
        this.f20291d = null;
        this.f20292e = false;
        this.f20293f = i2;
        this.f20294g = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        String str = ((a) obj).f20294g;
        if (str != null) {
            return str.equals(this.f20294g);
        }
        return false;
    }
}
