package com.google.zxing.e.a.a;

import com.google.zxing.e.a.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final com.google.zxing.e.a.b f40339a;

    /* renamed from: b  reason: collision with root package name */
    final com.google.zxing.e.a.b f40340b;

    /* renamed from: c  reason: collision with root package name */
    final c f40341c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f40342d = true;

    b(com.google.zxing.e.a.b bVar, com.google.zxing.e.a.b bVar2, c cVar) {
        this.f40339a = bVar;
        this.f40340b = bVar2;
        this.f40341c = cVar;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f40339a);
        sb.append(" , ");
        sb.append(this.f40340b);
        sb.append(" : ");
        c cVar = this.f40341c;
        if (cVar == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(cVar.f40351a);
        }
        sb.append(obj);
        sb.append(" ]");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!a(this.f40339a, bVar.f40339a) || !a(this.f40340b, bVar.f40340b) || !a(this.f40341c, bVar.f40341c)) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final int hashCode() {
        return (a(this.f40339a) ^ a(this.f40340b)) ^ a(this.f40341c);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
