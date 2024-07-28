package com.google.android.gms.internal.firebase_ml;

import java.util.List;

final class au extends as<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ as zzalr;

    au(as asVar, int i2, int i3) {
        this.zzalr = asVar;
        this.offset = i2;
        this.length = i3;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzjo() {
        return true;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzjl() {
        return this.zzalr.zzjl();
    }

    /* access modifiers changed from: package-private */
    public final int zzjm() {
        return this.zzalr.zzjm() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzjn() {
        return this.zzalr.zzjm() + this.offset + this.length;
    }

    public final E get(int i2) {
        ap.a(i2, this.length);
        return this.zzalr.get(i2 + this.offset);
    }

    public final as<E> zzd(int i2, int i3) {
        ap.a(i2, i3, this.length);
        as asVar = this.zzalr;
        int i4 = this.offset;
        return (as) asVar.subList(i2 + i4, i3 + i4);
    }

    public final /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }
}
