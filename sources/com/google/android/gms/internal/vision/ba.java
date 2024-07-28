package com.google.android.gms.internal.vision;

import java.util.List;

final class ba extends ay<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ ay zzlw;

    ba(ay ayVar, int i2, int i3) {
        this.zzlw = ayVar;
        this.offset = i2;
        this.length = i3;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbz() {
        return this.zzlw.zzbz();
    }

    /* access modifiers changed from: package-private */
    public final int zzca() {
        return this.zzlw.zzca() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzcb() {
        return this.zzlw.zzca() + this.offset + this.length;
    }

    public final E get(int i2) {
        al.a(i2, this.length);
        return this.zzlw.get(i2 + this.offset);
    }

    public final ay<E> zze(int i2, int i3) {
        al.a(i2, i3, this.length);
        ay ayVar = this.zzlw;
        int i4 = this.offset;
        return (ay) ayVar.subList(i2 + i4, i3 + i4);
    }

    public final /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }
}
