package com.google.android.gms.internal.clearcut;

final class dd {

    /* renamed from: a  reason: collision with root package name */
    private final String f9280a;

    /* renamed from: b  reason: collision with root package name */
    private int f9281b = 0;

    dd(String str) {
        this.f9280a = str;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f9281b < this.f9280a.length();
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        String str = this.f9280a;
        int i2 = this.f9281b;
        this.f9281b = i2 + 1;
        char charAt = str.charAt(i2);
        if (charAt < 55296) {
            return charAt;
        }
        char c2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.f9280a;
            int i4 = this.f9281b;
            this.f9281b = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 < 55296) {
                return c2 | (charAt2 << i3);
            }
            c2 |= (charAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}
