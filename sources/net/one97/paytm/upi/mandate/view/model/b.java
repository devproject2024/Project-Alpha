package net.one97.paytm.upi.mandate.view.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class b {
    @c(a = "isPolling")

    /* renamed from: a  reason: collision with root package name */
    public final boolean f67597a;
    @c(a = "status")

    /* renamed from: b  reason: collision with root package name */
    public final String f67598b;
    @c(a = "respMessage")

    /* renamed from: c  reason: collision with root package name */
    public final String f67599c;
    @c(a = "amount")

    /* renamed from: d  reason: collision with root package name */
    public final String f67600d;
    @c(a = "payeeAccountVpa")

    /* renamed from: e  reason: collision with root package name */
    public final String f67601e;
    @c(a = "payeeAccountName")

    /* renamed from: f  reason: collision with root package name */
    public final String f67602f;
    @c(a = "payerBankName")

    /* renamed from: g  reason: collision with root package name */
    public final String f67603g;
    @c(a = "payerBankAccNum")

    /* renamed from: h  reason: collision with root package name */
    public final String f67604h;
    @c(a = "seqNo")

    /* renamed from: i  reason: collision with root package name */
    public final String f67605i;
    @c(a = "rrn")
    public final String j;
    @c(a = "note")
    public final String k;
    @c(a = "showRetry")
    public final boolean l;
    @c(a = "category")
    public final String m;
    @c(a = "respCode")
    private final String n;
    @c(a = "impMsg")
    private final String o;
    @c(a = "startDate")
    private final String p;
    @c(a = "endDate")
    private final String q;

    public b() {
        this(false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 131071);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f67597a == bVar.f67597a && k.a((Object) this.f67598b, (Object) bVar.f67598b) && k.a((Object) this.n, (Object) bVar.n) && k.a((Object) this.f67599c, (Object) bVar.f67599c) && k.a((Object) this.f67600d, (Object) bVar.f67600d) && k.a((Object) this.f67601e, (Object) bVar.f67601e) && k.a((Object) this.f67602f, (Object) bVar.f67602f) && k.a((Object) this.f67603g, (Object) bVar.f67603g) && k.a((Object) this.f67604h, (Object) bVar.f67604h) && k.a((Object) this.f67605i, (Object) bVar.f67605i) && k.a((Object) this.j, (Object) bVar.j) && k.a((Object) this.o, (Object) bVar.o) && k.a((Object) this.k, (Object) bVar.k) && k.a((Object) this.p, (Object) bVar.p) && k.a((Object) this.q, (Object) bVar.q) && this.l == bVar.l && k.a((Object) this.m, (Object) bVar.m);
    }

    public final int hashCode() {
        boolean z = this.f67597a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.f67598b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.n;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f67599c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f67600d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f67601e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f67602f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f67603g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f67604h;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f67605i;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.j;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.o;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.k;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.p;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.q;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        boolean z3 = this.l;
        if (!z3) {
            z2 = z3;
        }
        int i4 = (hashCode14 + (z2 ? 1 : 0)) * 31;
        String str15 = this.m;
        if (str15 != null) {
            i3 = str15.hashCode();
        }
        return i4 + i3;
    }

    public final String toString() {
        return "PostTransactionUiModel(isPolling=" + this.f67597a + ", status=" + this.f67598b + ", respCode=" + this.n + ", respMessage=" + this.f67599c + ", amount=" + this.f67600d + ", payeeAccountVpa=" + this.f67601e + ", payeeAccountName=" + this.f67602f + ", payerBankName=" + this.f67603g + ", payerBankAccNum=" + this.f67604h + ", seqNo=" + this.f67605i + ", rrn=" + this.j + ", impMsg=" + this.o + ", note=" + this.k + ", startDate=" + this.p + ", endDate=" + this.q + ", showRetry=" + this.l + ", category=" + this.m + ")";
    }

    private b(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z2, String str15) {
        this.f67597a = z;
        this.f67598b = str;
        this.n = str2;
        this.f67599c = str3;
        this.f67600d = str4;
        this.f67601e = str5;
        this.f67602f = str6;
        this.f67603g = str7;
        this.f67604h = str8;
        this.f67605i = str9;
        this.j = str10;
        this.o = str11;
        this.k = str12;
        this.p = str13;
        this.q = str14;
        this.l = z2;
        this.m = str15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(boolean r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r3 = 0
            goto L_0x000b
        L_0x0009:
            r3 = r21
        L_0x000b:
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0013
            r4 = r2
            goto L_0x0015
        L_0x0013:
            r4 = r22
        L_0x0015:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001b
            r5 = r2
            goto L_0x001d
        L_0x001b:
            r5 = r23
        L_0x001d:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0023
            r6 = r2
            goto L_0x0025
        L_0x0023:
            r6 = r24
        L_0x0025:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002b
            r7 = r2
            goto L_0x002d
        L_0x002b:
            r7 = r25
        L_0x002d:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r26
        L_0x0035:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003b
            r9 = r2
            goto L_0x003d
        L_0x003b:
            r9 = r27
        L_0x003d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0043
            r10 = r2
            goto L_0x0045
        L_0x0043:
            r10 = r28
        L_0x0045:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004b
            r11 = r2
            goto L_0x004d
        L_0x004b:
            r11 = r29
        L_0x004d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0053
            r12 = r2
            goto L_0x0055
        L_0x0053:
            r12 = r30
        L_0x0055:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005b
            r13 = r2
            goto L_0x005d
        L_0x005b:
            r13 = r31
        L_0x005d:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0063
            r14 = r2
            goto L_0x0065
        L_0x0063:
            r14 = r32
        L_0x0065:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x006b
            r15 = r2
            goto L_0x006d
        L_0x006b:
            r15 = r33
        L_0x006d:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0074
            r16 = r2
            goto L_0x0076
        L_0x0074:
            r16 = r34
        L_0x0076:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x007d
            r17 = r2
            goto L_0x007f
        L_0x007d:
            r17 = r35
        L_0x007f:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0087
            r19 = r2
            goto L_0x0089
        L_0x0087:
            r19 = r36
        L_0x0089:
            r18 = 0
            r2 = r20
            r2.<init>((boolean) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (boolean) r18, (java.lang.String) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.view.model.b.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    public static /* synthetic */ b a(b bVar, boolean z, String str, String str2, String str3, String str4, boolean z2) {
        b bVar2 = bVar;
        return new b(z, str, bVar2.n, str2, bVar2.f67600d, bVar2.f67601e, bVar2.f67602f, bVar2.f67603g, bVar2.f67604h, bVar2.f67605i, str3, str4, bVar2.k, bVar2.p, bVar2.q, z2, bVar2.m);
    }
}
