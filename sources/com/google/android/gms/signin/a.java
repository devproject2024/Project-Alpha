package com.google.android.gms.signin;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.q;
import java.util.Arrays;

public final class a implements a.d.e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12429a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final boolean f12430b = false;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f12431c = false;

    /* renamed from: d  reason: collision with root package name */
    public final String f12432d = null;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f12433e = false;

    /* renamed from: f  reason: collision with root package name */
    public final String f12434f = null;

    /* renamed from: g  reason: collision with root package name */
    public final String f12435g = null;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f12436h = false;

    /* renamed from: i  reason: collision with root package name */
    public final Long f12437i = null;
    public final Long j = null;

    /* renamed from: com.google.android.gms.signin.a$a  reason: collision with other inner class name */
    public static final class C0161a {
    }

    private a() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12430b == aVar.f12430b && this.f12431c == aVar.f12431c && q.a(this.f12432d, aVar.f12432d) && this.f12433e == aVar.f12433e && this.f12436h == aVar.f12436h && q.a(this.f12434f, aVar.f12434f) && q.a(this.f12435g, aVar.f12435g) && q.a(this.f12437i, aVar.f12437i) && q.a(this.j, aVar.j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f12430b), Boolean.valueOf(this.f12431c), this.f12432d, Boolean.valueOf(this.f12433e), Boolean.valueOf(this.f12436h), this.f12434f, this.f12435g, this.f12437i, this.j});
    }

    static {
        new C0161a();
    }
}
