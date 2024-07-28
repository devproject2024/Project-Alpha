package com.google.firebase.ml.vision.objects;

import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f39163a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39164b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39165c;

    /* renamed from: com.google.firebase.ml.vision.objects.a$a  reason: collision with other inner class name */
    public static class C0657a {

        /* renamed from: a  reason: collision with root package name */
        public int f39166a = 1;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39167b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39168c = false;
    }

    private a(int i2, boolean z, boolean z2) {
        this.f39163a = i2;
        this.f39164b = z;
        this.f39165c = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.f39163a == this.f39163a && aVar.f39165c == this.f39165c && aVar.f39164b == this.f39164b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f39163a), Boolean.valueOf(this.f39165c), Boolean.valueOf(this.f39164b)});
    }

    public /* synthetic */ a(int i2, boolean z, boolean z2, byte b2) {
        this(i2, z, z2);
    }
}
