package com.google.firebase.installations.b;

import com.google.firebase.installations.b.d;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f38941a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38942b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38943c;

    /* renamed from: d  reason: collision with root package name */
    private final e f38944d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b f38945e;

    /* synthetic */ a(String str, String str2, String str3, e eVar, d.b bVar, byte b2) {
        this(str, str2, str3, eVar, bVar);
    }

    private a(String str, String str2, String str3, e eVar, d.b bVar) {
        this.f38941a = str;
        this.f38942b = str2;
        this.f38943c = str3;
        this.f38944d = eVar;
        this.f38945e = bVar;
    }

    public final String a() {
        return this.f38941a;
    }

    public final String b() {
        return this.f38942b;
    }

    public final String c() {
        return this.f38943c;
    }

    public final e d() {
        return this.f38944d;
    }

    public final d.b e() {
        return this.f38945e;
    }

    public final String toString() {
        return "InstallationResponse{uri=" + this.f38941a + ", fid=" + this.f38942b + ", refreshToken=" + this.f38943c + ", authToken=" + this.f38944d + ", responseCode=" + this.f38945e + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.f38941a;
            if (str != null ? str.equals(dVar.a()) : dVar.a() == null) {
                String str2 = this.f38942b;
                if (str2 != null ? str2.equals(dVar.b()) : dVar.b() == null) {
                    String str3 = this.f38943c;
                    if (str3 != null ? str3.equals(dVar.c()) : dVar.c() == null) {
                        e eVar = this.f38944d;
                        if (eVar != null ? eVar.equals(dVar.d()) : dVar.d() == null) {
                            d.b bVar = this.f38945e;
                            return bVar != null ? bVar.equals(dVar.e()) : dVar.e() == null;
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.f38941a;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f38942b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f38943c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        e eVar = this.f38944d;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        d.b bVar = this.f38945e;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode4 ^ i2;
    }

    /* renamed from: com.google.firebase.installations.b.a$a  reason: collision with other inner class name */
    static final class C0650a extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38946a;

        /* renamed from: b  reason: collision with root package name */
        private String f38947b;

        /* renamed from: c  reason: collision with root package name */
        private String f38948c;

        /* renamed from: d  reason: collision with root package name */
        private e f38949d;

        /* renamed from: e  reason: collision with root package name */
        private d.b f38950e;

        C0650a() {
        }

        public final d.a a(String str) {
            this.f38946a = str;
            return this;
        }

        public final d.a b(String str) {
            this.f38947b = str;
            return this;
        }

        public final d.a c(String str) {
            this.f38948c = str;
            return this;
        }

        public final d.a a(e eVar) {
            this.f38949d = eVar;
            return this;
        }

        public final d.a a(d.b bVar) {
            this.f38950e = bVar;
            return this;
        }

        public final d a() {
            return new a(this.f38946a, this.f38947b, this.f38948c, this.f38949d, this.f38950e, (byte) 0);
        }
    }
}
