package com.google.android.gms.internal.p001firebaseperf;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.hr  reason: invalid package */
final class hr extends hm<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ hm zzw;

    hr(hm hmVar, int i2, int i3) {
        this.zzw = hmVar;
        this.offset = i2;
        this.length = i3;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzc() {
        return this.zzw.zzc();
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return this.zzw.zzd() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzw.zzd() + this.offset + this.length;
    }

    public final E get(int i2) {
        cc.a(i2, this.length);
        return this.zzw.get(i2 + this.offset);
    }

    public final hm<E> zzc(int i2, int i3) {
        cc.a(i2, i3, this.length);
        hm hmVar = this.zzw;
        int i4 = this.offset;
        return (hm) hmVar.subList(i2 + i4, i3 + i4);
    }

    public final /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }
}
