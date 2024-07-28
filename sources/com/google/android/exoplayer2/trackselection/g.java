package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f33504a;

    /* renamed from: b  reason: collision with root package name */
    public final f[] f33505b;

    /* renamed from: c  reason: collision with root package name */
    private int f33506c;

    public g(f... fVarArr) {
        this.f33505b = fVarArr;
        this.f33504a = fVarArr.length;
    }

    public final f[] a() {
        return (f[]) this.f33505b.clone();
    }

    public final int hashCode() {
        if (this.f33506c == 0) {
            this.f33506c = Arrays.hashCode(this.f33505b) + 527;
        }
        return this.f33506c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f33505b, ((g) obj).f33505b);
    }
}
