package com.appsflyer.internal;

public final class w {

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean f302;

    /* renamed from: ι  reason: contains not printable characters */
    public String f303;

    w(String str, boolean z) {
        this.f303 = str;
        this.f302 = z;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final boolean m205() {
        return this.f302;
    }

    public final String toString() {
        return String.format("%s,%s", new Object[]{this.f303, Boolean.valueOf(this.f302)});
    }

    enum e {
        GOOGLE(0),
        AMAZON(1);
        

        /* renamed from: Ι  reason: contains not printable characters */
        private int f307;

        private e(int i2) {
            this.f307 = i2;
        }

        public final String toString() {
            return String.valueOf(this.f307);
        }
    }
}
