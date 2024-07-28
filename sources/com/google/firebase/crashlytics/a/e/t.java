package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class t extends v.d.e {

    /* renamed from: a  reason: collision with root package name */
    private final int f38562a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38563b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38564c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38565d;

    /* synthetic */ t(int i2, String str, String str2, boolean z, byte b2) {
        this(i2, str, str2, z);
    }

    private t(int i2, String str, String str2, boolean z) {
        this.f38562a = i2;
        this.f38563b = str;
        this.f38564c = str2;
        this.f38565d = z;
    }

    public final int a() {
        return this.f38562a;
    }

    public final String b() {
        return this.f38563b;
    }

    public final String c() {
        return this.f38564c;
    }

    public final boolean d() {
        return this.f38565d;
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f38562a + ", version=" + this.f38563b + ", buildVersion=" + this.f38564c + ", jailbroken=" + this.f38565d + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.e) {
            v.d.e eVar = (v.d.e) obj;
            return this.f38562a == eVar.a() && this.f38563b.equals(eVar.b()) && this.f38564c.equals(eVar.c()) && this.f38565d == eVar.d();
        }
    }

    public final int hashCode() {
        return ((((((this.f38562a ^ 1000003) * 1000003) ^ this.f38563b.hashCode()) * 1000003) ^ this.f38564c.hashCode()) * 1000003) ^ (this.f38565d ? 1231 : 1237);
    }

    static final class a extends v.d.e.a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f38566a;

        /* renamed from: b  reason: collision with root package name */
        private String f38567b;

        /* renamed from: c  reason: collision with root package name */
        private String f38568c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f38569d;

        a() {
        }

        public final v.d.e.a a(int i2) {
            this.f38566a = Integer.valueOf(i2);
            return this;
        }

        public final v.d.e.a a(String str) {
            if (str != null) {
                this.f38567b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        public final v.d.e.a b(String str) {
            if (str != null) {
                this.f38568c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public final v.d.e.a a(boolean z) {
            this.f38569d = Boolean.valueOf(z);
            return this;
        }

        public final v.d.e a() {
            String str = "";
            if (this.f38566a == null) {
                str = str + " platform";
            }
            if (this.f38567b == null) {
                str = str + " version";
            }
            if (this.f38568c == null) {
                str = str + " buildVersion";
            }
            if (this.f38569d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new t(this.f38566a.intValue(), this.f38567b, this.f38568c, this.f38569d.booleanValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
