package com.alipay.imobile.network.quake.h.a;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f14842c = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f14843d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f14844e = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f14845f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    final String f14846a;

    /* renamed from: b  reason: collision with root package name */
    final String f14847b;

    /* renamed from: g  reason: collision with root package name */
    private final long f14848g;

    /* renamed from: h  reason: collision with root package name */
    private final String f14849h;

    /* renamed from: i  reason: collision with root package name */
    private final String f14850i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f14851a;

        /* renamed from: b  reason: collision with root package name */
        String f14852b;

        /* renamed from: c  reason: collision with root package name */
        long f14853c = 253402300799999L;

        /* renamed from: d  reason: collision with root package name */
        String f14854d;

        /* renamed from: e  reason: collision with root package name */
        String f14855e = "/";

        /* renamed from: f  reason: collision with root package name */
        boolean f14856f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14857g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14858h;

        /* renamed from: i  reason: collision with root package name */
        boolean f14859i;
    }

    private b(a aVar) {
        if (aVar.f14851a == null) {
            throw new IllegalArgumentException("builder.name == null");
        } else if (aVar.f14852b == null) {
            throw new IllegalArgumentException("builder.value == null");
        } else if (aVar.f14854d != null) {
            this.f14846a = aVar.f14851a;
            this.f14847b = aVar.f14852b;
            this.f14848g = aVar.f14853c;
            this.f14849h = aVar.f14854d;
            this.f14850i = aVar.f14855e;
            this.j = aVar.f14856f;
            this.k = aVar.f14857g;
            this.l = aVar.f14858h;
            this.m = aVar.f14859i;
        } else {
            throw new IllegalArgumentException("builder.domain == null");
        }
    }

    /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    private b(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f14846a = str;
        this.f14847b = str2;
        this.f14848g = j2;
        this.f14849h = str3;
        this.f14850i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.f14846a.equals(this.f14846a) && bVar.f14847b.equals(this.f14847b) && bVar.f14849h.equals(this.f14849h) && bVar.f14850i.equals(this.f14850i) && bVar.f14848g == this.f14848g && bVar.j == this.j && bVar.k == this.k && bVar.l == this.l && bVar.m == this.m;
    }

    public final int hashCode() {
        long j2 = this.f14848g;
        return ((((((((((((((((this.f14846a.hashCode() + 527) * 31) + this.f14847b.hashCode()) * 31) + this.f14849h.hashCode()) * 31) + this.f14850i.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.j ^ true ? 1 : 0)) * 31) + (this.k ^ true ? 1 : 0)) * 31) + (this.l ^ true ? 1 : 0)) * 31) + (this.m ^ true ? 1 : 0);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14846a);
        sb.append('=');
        sb.append(this.f14847b);
        if (this.l) {
            if (this.f14848g == Long.MIN_VALUE) {
                str = "; max-age=0";
            } else {
                sb.append("; expires=");
                str = com.alipay.imobile.network.quake.h.a.a(new Date(this.f14848g));
            }
            sb.append(str);
        }
        if (!this.m) {
            sb.append("; domain=");
            sb.append(this.f14849h);
        }
        sb.append("; path=");
        sb.append(this.f14850i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x024c, code lost:
        if (r0 > 253402300799999L) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0289, code lost:
        if (com.alipay.imobile.network.quake.i.d.a(r0) == false) goto L_0x028d;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.alipay.imobile.network.quake.h.a.b a(long r28, java.net.URL r30, java.lang.String r31) {
        /*
            r0 = r31
            java.lang.String r1 = "."
            int r2 = r31.length()
            r3 = 59
            r4 = 0
            int r5 = com.alipay.imobile.network.quake.i.g.a((java.lang.String) r0, (int) r4, (int) r2, (char) r3)
            r6 = 61
            int r7 = com.alipay.imobile.network.quake.i.g.a((java.lang.String) r0, (int) r4, (int) r5, (char) r6)
            r8 = 0
            if (r7 != r5) goto L_0x0019
            return r8
        L_0x0019:
            java.lang.String r10 = com.alipay.imobile.network.quake.i.g.a(r0, r4, r7)
            boolean r9 = r10.isEmpty()
            if (r9 == 0) goto L_0x0024
            return r8
        L_0x0024:
            r9 = 1
            int r7 = r7 + r9
            java.lang.String r11 = com.alipay.imobile.network.quake.i.g.a(r0, r7, r5)
            int r5 = r5 + r9
            r7 = r8
            r20 = r7
            r16 = -1
            r18 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r21 = 0
            r22 = 0
            r23 = 1
            r24 = 0
        L_0x003d:
            if (r5 >= r2) goto L_0x021e
            int r8 = com.alipay.imobile.network.quake.i.g.a((java.lang.String) r0, (int) r5, (int) r2, (char) r3)
            int r14 = com.alipay.imobile.network.quake.i.g.a((java.lang.String) r0, (int) r5, (int) r8, (char) r6)
            java.lang.String r5 = com.alipay.imobile.network.quake.i.g.a(r0, r5, r14)
            if (r14 >= r8) goto L_0x0054
            int r14 = r14 + 1
            java.lang.String r14 = com.alipay.imobile.network.quake.i.g.a(r0, r14, r8)
            goto L_0x0056
        L_0x0054:
            java.lang.String r14 = ""
        L_0x0056:
            java.lang.String r15 = "expires"
            boolean r15 = r5.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x01b0
            int r5 = r14.length()     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r15 = a(r14, r4, r5, r4)     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Pattern r6 = f14845f     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Matcher r6 = r6.matcher(r14)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r3 = -1
            r4 = -1
            r13 = -1
            r25 = -1
            r26 = -1
            r27 = -1
        L_0x0075:
            if (r15 >= r5) goto L_0x0117
            int r12 = r15 + 1
            int r12 = a(r14, r12, r5, r9)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r6.region(r15, r12)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r15 = -1
            if (r3 != r15) goto L_0x00b2
            java.util.regex.Pattern r15 = f14845f     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Matcher r15 = r6.usePattern(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            boolean r15 = r15.matches()     // Catch:{ IllegalArgumentException -> 0x01ad }
            if (r15 == 0) goto L_0x00ae
            java.lang.String r3 = r6.group(r9)     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r15 = 2
            java.lang.String r15 = r6.group(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r9 = 3
            java.lang.String r9 = r6.group(r9)     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r27 = r9
            r26 = r15
            goto L_0x010d
        L_0x00ae:
            r9 = r25
            r15 = -1
            goto L_0x00b4
        L_0x00b2:
            r9 = r25
        L_0x00b4:
            if (r9 != r15) goto L_0x00cd
            java.util.regex.Pattern r15 = f14844e     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Matcher r15 = r6.usePattern(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            boolean r15 = r15.matches()     // Catch:{ IllegalArgumentException -> 0x01ad }
            if (r15 == 0) goto L_0x00cc
            r15 = 1
            java.lang.String r9 = r6.group(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IllegalArgumentException -> 0x01ad }
            goto L_0x010b
        L_0x00cc:
            r15 = -1
        L_0x00cd:
            if (r4 != r15) goto L_0x00f4
            java.util.regex.Pattern r15 = f14843d     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Matcher r15 = r6.usePattern(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            boolean r15 = r15.matches()     // Catch:{ IllegalArgumentException -> 0x01ad }
            if (r15 == 0) goto L_0x00f3
            r15 = 1
            java.lang.String r4 = r6.group(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.Locale r15 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.lang.String r4 = r4.toLowerCase(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Pattern r15 = f14843d     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.lang.String r15 = r15.pattern()     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r4 = r15.indexOf(r4)     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r4 = r4 / 4
            goto L_0x010b
        L_0x00f3:
            r15 = -1
        L_0x00f4:
            if (r13 != r15) goto L_0x010b
            java.util.regex.Pattern r15 = f14842c     // Catch:{ IllegalArgumentException -> 0x01ad }
            java.util.regex.Matcher r15 = r6.usePattern(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            boolean r15 = r15.matches()     // Catch:{ IllegalArgumentException -> 0x01ad }
            if (r15 == 0) goto L_0x010b
            r15 = 1
            java.lang.String r13 = r6.group(r15)     // Catch:{ IllegalArgumentException -> 0x01ad }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ IllegalArgumentException -> 0x01ad }
        L_0x010b:
            r25 = r9
        L_0x010d:
            int r12 = r12 + 1
            r9 = 0
            int r15 = a(r14, r12, r5, r9)     // Catch:{ IllegalArgumentException -> 0x01ad }
            r9 = 1
            goto L_0x0075
        L_0x0117:
            r9 = r25
            r5 = 70
            if (r13 < r5) goto L_0x0123
            r5 = 99
            if (r13 > r5) goto L_0x0123
            int r13 = r13 + 1900
        L_0x0123:
            if (r13 < 0) goto L_0x012b
            r5 = 69
            if (r13 > r5) goto L_0x012b
            int r13 = r13 + 2000
        L_0x012b:
            r5 = 1601(0x641, float:2.243E-42)
            if (r13 < r5) goto L_0x01a5
            r5 = -1
            if (r4 == r5) goto L_0x019d
            if (r9 <= 0) goto L_0x0195
            r5 = 31
            if (r9 > r5) goto L_0x0195
            if (r3 < 0) goto L_0x018d
            r5 = 23
            if (r3 > r5) goto L_0x018d
            r12 = r26
            r6 = 59
            if (r12 < 0) goto L_0x0187
            if (r12 > r6) goto L_0x0187
            r5 = r27
            if (r5 < 0) goto L_0x0181
            if (r5 > r6) goto L_0x0181
            java.util.GregorianCalendar r14 = new java.util.GregorianCalendar     // Catch:{ IllegalArgumentException -> 0x0213 }
            java.util.TimeZone r15 = com.alipay.imobile.network.quake.i.g.f14903a     // Catch:{ IllegalArgumentException -> 0x0213 }
            r14.<init>(r15)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r15 = 0
            r14.setLenient(r15)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r15 = 1
            r14.set(r15, r13)     // Catch:{ IllegalArgumentException -> 0x0213 }
            int r4 = r4 + -1
            r13 = 2
            r14.set(r13, r4)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r4 = 5
            r14.set(r4, r9)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r4 = 11
            r14.set(r4, r3)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3 = 12
            r14.set(r3, r12)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3 = 13
            r14.set(r3, r5)     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3 = 14
            r4 = 0
            r14.set(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0213 }
            long r3 = r14.getTimeInMillis()     // Catch:{ IllegalArgumentException -> 0x0213 }
            r18 = r3
            goto L_0x01c0
        L_0x0181:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x0187:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x018d:
            r6 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x0195:
            r6 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x019d:
            r6 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x01a5:
            r6 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x01ad:
            r6 = 59
            goto L_0x0213
        L_0x01b0:
            r6 = 59
            java.lang.String r3 = "max-age"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01c3
            long r3 = a(r14)     // Catch:{  }
            r16 = r3
        L_0x01c0:
            r24 = 1
            goto L_0x0213
        L_0x01c3:
            java.lang.String r3 = "domain"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01f2
            boolean r3 = r14.endsWith(r1)     // Catch:{ IllegalArgumentException -> 0x0213 }
            if (r3 != 0) goto L_0x01ec
            boolean r3 = r14.startsWith(r1)     // Catch:{ IllegalArgumentException -> 0x0213 }
            if (r3 == 0) goto L_0x01dc
            r3 = 1
            java.lang.String r14 = r14.substring(r3)     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x01dc:
            java.lang.String r3 = com.alipay.imobile.network.quake.i.g.a((java.lang.String) r14)     // Catch:{ IllegalArgumentException -> 0x0213 }
            if (r3 == 0) goto L_0x01e6
            r7 = r3
            r23 = 0
            goto L_0x0213
        L_0x01e6:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x01ec:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0213 }
        L_0x01f2:
            java.lang.String r3 = "path"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01fd
            r20 = r14
            goto L_0x0213
        L_0x01fd:
            java.lang.String r3 = "secure"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0209
            r21 = 1
            goto L_0x0213
        L_0x0209:
            java.lang.String r3 = "httponly"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0213
            r22 = 1
        L_0x0213:
            int r5 = r8 + 1
            r3 = 59
            r4 = 0
            r6 = 61
            r8 = 0
            r9 = 1
            goto L_0x003d
        L_0x021e:
            r0 = -9223372036854775808
            int r2 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0226
        L_0x0224:
            r12 = r0
            goto L_0x0258
        L_0x0226:
            r0 = -1
            int r2 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0256
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r2 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x023a
            r0 = 1000(0x3e8, double:4.94E-321)
            long r16 = r16 * r0
            goto L_0x023f
        L_0x023a:
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x023f:
            long r0 = r28 + r16
            int r2 = (r0 > r28 ? 1 : (r0 == r28 ? 0 : -1))
            if (r2 < 0) goto L_0x024f
            r2 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0224
            goto L_0x0254
        L_0x024f:
            r2 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
        L_0x0254:
            r12 = r2
            goto L_0x0258
        L_0x0256:
            r12 = r18
        L_0x0258:
            if (r7 != 0) goto L_0x0260
            java.lang.String r0 = r30.getHost()
            r14 = r0
            goto L_0x0292
        L_0x0260:
            java.lang.String r0 = r30.getHost()
            boolean r1 = r0.equals(r7)
            if (r1 == 0) goto L_0x026c
            r15 = 1
            goto L_0x028d
        L_0x026c:
            boolean r1 = r0.endsWith(r7)
            if (r1 == 0) goto L_0x028c
            int r1 = r0.length()
            int r2 = r7.length()
            int r1 = r1 - r2
            r15 = 1
            int r1 = r1 - r15
            char r1 = r0.charAt(r1)
            r2 = 46
            if (r1 != r2) goto L_0x028c
            boolean r0 = com.alipay.imobile.network.quake.i.d.a(r0)
            if (r0 != 0) goto L_0x028c
            goto L_0x028d
        L_0x028c:
            r15 = 0
        L_0x028d:
            if (r15 != 0) goto L_0x0291
            r0 = 0
            return r0
        L_0x0291:
            r14 = r7
        L_0x0292:
            java.lang.String r0 = "/"
            r8 = r20
            if (r8 == 0) goto L_0x02a1
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x029f
            goto L_0x02a1
        L_0x029f:
            r15 = r8
            goto L_0x02b3
        L_0x02a1:
            java.lang.String r1 = r30.getPath()
            r2 = 47
            int r2 = r1.lastIndexOf(r2)
            if (r2 == 0) goto L_0x02b2
            r3 = 0
            java.lang.String r0 = r1.substring(r3, r2)
        L_0x02b2:
            r15 = r0
        L_0x02b3:
            com.alipay.imobile.network.quake.h.a.b r0 = new com.alipay.imobile.network.quake.h.a.b
            r9 = r0
            r16 = r21
            r17 = r22
            r18 = r23
            r19 = r24
            r9.<init>(r10, r11, r12, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.h.a.b.a(long, java.net.URL, java.lang.String):com.alipay.imobile.network.quake.h.a.b");
    }

    public static List<b> a(URL url, List<String> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            b a2 = a(System.currentTimeMillis(), url, list.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }
}
