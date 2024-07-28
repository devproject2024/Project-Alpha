package com.paytm.utility.c.a;

import java.util.Arrays;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    String[] f43778a;

    /* renamed from: b  reason: collision with root package name */
    boolean f43779b;

    /* renamed from: c  reason: collision with root package name */
    boolean f43780c;

    /* renamed from: d  reason: collision with root package name */
    String f43781d;

    /* renamed from: e  reason: collision with root package name */
    b<? super c, x> f43782e;

    /* renamed from: f  reason: collision with root package name */
    b<? super c, x> f43783f;

    /* renamed from: g  reason: collision with root package name */
    private a f43784g;

    /* renamed from: h  reason: collision with root package name */
    private String f43785h;

    /* renamed from: i  reason: collision with root package name */
    private b<? super c, x> f43786i;
    private String[] j;
    private String[] k;

    public final String toString() {
        return "QuickPermissionsRequest(target=" + this.f43784g + ", permissions=" + Arrays.toString(this.f43778a) + ", handleRationale=" + this.f43779b + ", rationaleMessage=" + this.f43785h + ", handlePermanentlyDenied=" + this.f43780c + ", permanentlyDeniedMessage=" + this.f43781d + ", rationaleMethod=" + this.f43782e + ", permanentDeniedMethod=" + this.f43783f + ", permissionsDeniedMethod=" + this.f43786i + ", deniedPermissions=" + Arrays.toString(this.j) + ", permanentlyDeniedPermissions=" + Arrays.toString(this.k) + ")";
    }

    public final void a(String[] strArr) {
        k.c(strArr, "<set-?>");
        this.j = strArr;
    }

    public final void b(String[] strArr) {
        k.c(strArr, "<set-?>");
        this.k = strArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            c cVar = (c) obj;
            if (Arrays.equals(this.f43778a, cVar.f43778a) && Arrays.equals(this.j, cVar.j) && Arrays.equals(this.k, cVar.k)) {
                return true;
            }
            return false;
        }
        throw new u("null cannot be cast to non-null type com.paytm.utility.quickpermissions.util.QuickPermissionsRequest");
    }

    public final int hashCode() {
        return (((Arrays.hashCode(this.f43778a) * 31) + Arrays.hashCode(this.j)) * 31) + Arrays.hashCode(this.k);
    }
}
