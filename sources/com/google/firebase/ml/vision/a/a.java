package com.google.firebase.ml.vision.a;

import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f39078a = new C0652a().a();

    /* renamed from: b  reason: collision with root package name */
    private final int f39079b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39080c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39081d;

    private a(int i2, int i3, boolean z) {
        this.f39079b = i2;
        this.f39080c = i3;
        this.f39081d = z;
    }

    /* renamed from: com.google.firebase.ml.vision.a.a$a  reason: collision with other inner class name */
    public static class C0652a {

        /* renamed from: a  reason: collision with root package name */
        private int f39082a = 10;

        /* renamed from: b  reason: collision with root package name */
        private int f39083b = 1;

        /* renamed from: c  reason: collision with root package name */
        private boolean f39084c = false;

        public final a a() {
            return new a(this.f39082a, this.f39083b, this.f39084c, (byte) 0);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f39079b == aVar.f39079b && this.f39080c == aVar.f39080c && this.f39081d == aVar.f39081d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f39079b), Integer.valueOf(this.f39080c), Boolean.valueOf(this.f39081d)});
    }

    /* synthetic */ a(int i2, int i3, boolean z, byte b2) {
        this(i2, i3, z);
    }
}
