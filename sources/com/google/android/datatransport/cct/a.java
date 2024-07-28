package com.google.android.datatransport.cct;

import com.google.android.datatransport.b;
import com.google.android.datatransport.runtime.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    static final String f7638a = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: b  reason: collision with root package name */
    static final String f7639b = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");

    /* renamed from: c  reason: collision with root package name */
    public static final Set<b> f7640c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new b[]{b.a("proto"), b.a("json")})));

    /* renamed from: d  reason: collision with root package name */
    public static final a f7641d = new a(f7638a, (String) null);

    /* renamed from: e  reason: collision with root package name */
    public static final a f7642e = new a(f7639b, f7643h);

    /* renamed from: h  reason: collision with root package name */
    private static final String f7643h = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");

    /* renamed from: f  reason: collision with root package name */
    final String f7644f;

    /* renamed from: g  reason: collision with root package name */
    final String f7645g;

    public a(String str, String str2) {
        this.f7644f = str;
        this.f7645g = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName(AppConstants.UTF_8));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public final String a() {
        return "cct";
    }

    public final Set<b> c() {
        return f7640c;
    }

    public final byte[] b() {
        if (this.f7645g == null && this.f7644f == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f7644f;
        objArr[2] = "\\";
        String str = this.f7645g;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(AppConstants.UTF_8));
    }
}
