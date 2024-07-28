package com.google.android.gms.internal.clearcut;

public final class eu implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final ev f9346c = new ev();

    /* renamed from: a  reason: collision with root package name */
    ev[] f9347a;

    /* renamed from: b  reason: collision with root package name */
    int f9348b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9349d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f9350e;

    eu() {
        this(10);
    }

    private eu(int i2) {
        this.f9349d = false;
        int i3 = i2 << 2;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (i3 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 4;
        this.f9350e = new int[i6];
        this.f9347a = new ev[i6];
        this.f9348b = 0;
    }

    public final boolean a() {
        return this.f9348b == 0;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i2 = this.f9348b;
        eu euVar = new eu(i2);
        System.arraycopy(this.f9350e, 0, euVar.f9350e, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            ev[] evVarArr = this.f9347a;
            if (evVarArr[i3] != null) {
                euVar.f9347a[i3] = (ev) evVarArr[i3].clone();
            }
        }
        euVar.f9348b = i2;
        return euVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eu)) {
            return false;
        }
        eu euVar = (eu) obj;
        int i2 = this.f9348b;
        if (i2 != euVar.f9348b) {
            return false;
        }
        int[] iArr = this.f9350e;
        int[] iArr2 = euVar.f9350e;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                z = true;
                break;
            } else if (iArr[i3] != iArr2[i3]) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            ev[] evVarArr = this.f9347a;
            ev[] evVarArr2 = euVar.f9347a;
            int i4 = this.f9348b;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    z2 = true;
                    break;
                } else if (!evVarArr[i5].equals(evVarArr2[i5])) {
                    z2 = false;
                    break;
                } else {
                    i5++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        for (int i3 = 0; i3 < this.f9348b; i3++) {
            i2 = (((i2 * 31) + this.f9350e[i3]) * 31) + this.f9347a[i3].hashCode();
        }
        return i2;
    }
}
