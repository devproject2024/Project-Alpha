package com.google.android.exoplayer2.e.d;

import com.business.merchant_payments.utility.StringUtility;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.m;
import com.google.android.exoplayer2.g.r;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f31525c = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");

    /* renamed from: d  reason: collision with root package name */
    private final boolean f31526d;

    /* renamed from: e  reason: collision with root package name */
    private int f31527e;

    /* renamed from: f  reason: collision with root package name */
    private int f31528f;

    /* renamed from: g  reason: collision with root package name */
    private int f31529g;

    /* renamed from: h  reason: collision with root package name */
    private int f31530h;

    public a() {
        this((List<byte[]>) null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.f31526d = false;
            return;
        }
        this.f31526d = true;
        String a2 = ae.a(list.get(0));
        com.google.android.exoplayer2.g.a.a(a2.startsWith("Format: "));
        a(a2);
        a(new r(list.get(1)));
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private static void a(com.google.android.exoplayer2.g.r r2) {
        /*
        L_0x0000:
            java.lang.String r0 = r2.r()
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "[Events]"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.a.a(com.google.android.exoplayer2.g.r):void");
    }

    private void a(r rVar, List<b> list, m mVar) {
        long j;
        while (true) {
            String r = rVar.r();
            if (r == null) {
                return;
            }
            if (!this.f31526d && r.startsWith("Format: ")) {
                a(r);
            } else if (r.startsWith("Dialogue: ")) {
                if (this.f31527e == 0) {
                    "Skipping dialogue line before complete format: ".concat(String.valueOf(r));
                    l.c();
                } else {
                    String[] split = r.substring(10).split(AppConstants.COMMA, this.f31527e);
                    if (split.length != this.f31527e) {
                        "Skipping dialogue line with fewer columns than format: ".concat(String.valueOf(r));
                        l.c();
                    } else {
                        long b2 = b(split[this.f31528f]);
                        if (b2 == -9223372036854775807L) {
                            "Skipping invalid timing: ".concat(String.valueOf(r));
                            l.c();
                        } else {
                            String str = split[this.f31529g];
                            if (!str.trim().isEmpty()) {
                                j = b(str);
                                if (j == -9223372036854775807L) {
                                    "Skipping invalid timing: ".concat(String.valueOf(r));
                                    l.c();
                                }
                            } else {
                                j = -9223372036854775807L;
                            }
                            list.add(new b(split[this.f31530h].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", StringUtility.NEW_LINE).replaceAll("\\\\n", StringUtility.NEW_LINE)));
                            mVar.a(b2);
                            if (j != -9223372036854775807L) {
                                list.add(b.f31445a);
                                mVar.a(j);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 8
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r9 = android.text.TextUtils.split(r9, r0)
            int r0 = r9.length
            r8.f31527e = r0
            r0 = -1
            r8.f31528f = r0
            r8.f31529g = r0
            r8.f31530h = r0
            r1 = 0
            r2 = 0
        L_0x0018:
            int r3 = r8.f31527e
            if (r2 >= r3) goto L_0x006f
            r3 = r9[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r3)
            int r4 = r3.hashCode()
            r5 = 100571(0x188db, float:1.4093E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L_0x0052
            r5 = 3556653(0x36452d, float:4.983932E-39)
            if (r4 == r5) goto L_0x0047
            r5 = 109757538(0x68ac462, float:5.219839E-35)
            if (r4 == r5) goto L_0x003c
            goto L_0x005c
        L_0x003c:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x005c
            r3 = 0
            goto L_0x005d
        L_0x0047:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x005c
            r3 = 2
            goto L_0x005d
        L_0x0052:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x005c
            r3 = 1
            goto L_0x005d
        L_0x005c:
            r3 = -1
        L_0x005d:
            if (r3 == 0) goto L_0x006a
            if (r3 == r7) goto L_0x0067
            if (r3 == r6) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            r8.f31530h = r2
            goto L_0x006c
        L_0x0067:
            r8.f31529g = r2
            goto L_0x006c
        L_0x006a:
            r8.f31528f = r2
        L_0x006c:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x006f:
            int r9 = r8.f31528f
            if (r9 == r0) goto L_0x007b
            int r9 = r8.f31529g
            if (r9 == r0) goto L_0x007b
            int r9 = r8.f31530h
            if (r9 != r0) goto L_0x007d
        L_0x007b:
            r8.f31527e = r1
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.a.a(java.lang.String):void");
    }

    private static long b(String str) {
        Matcher matcher = f31525c.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    public final /* synthetic */ e a(byte[] bArr, int i2, boolean z) throws g {
        ArrayList arrayList = new ArrayList();
        m mVar = new m();
        r rVar = new r(bArr, i2);
        if (!this.f31526d) {
            a(rVar);
        }
        a(rVar, (List<b>) arrayList, mVar);
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, mVar.a());
    }
}
