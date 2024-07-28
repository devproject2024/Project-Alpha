package com.google.zxing.client.android;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<a> f40193a = EnumSet.of(a.UPC_A, new a[]{a.UPC_E, a.EAN_13, a.EAN_8, a.RSS_14, a.RSS_EXPANDED});

    /* renamed from: b  reason: collision with root package name */
    public static final Set<a> f40194b = EnumSet.of(a.CODE_39, a.CODE_93, a.CODE_128, a.ITF, a.CODABAR);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<a> f40195c = EnumSet.of(a.QR_CODE);

    /* renamed from: d  reason: collision with root package name */
    public static final Set<a> f40196d = EnumSet.of(a.DATA_MATRIX);

    /* renamed from: e  reason: collision with root package name */
    public static final Set<a> f40197e = EnumSet.of(a.AZTEC);

    /* renamed from: f  reason: collision with root package name */
    public static final Set<a> f40198f = EnumSet.of(a.PDF_417);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f40199g = Pattern.compile(AppConstants.COMMA);

    /* renamed from: h  reason: collision with root package name */
    private static final Set<a> f40200h;

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Set<a>> f40201i;

    static {
        EnumSet<a> copyOf = EnumSet.copyOf(f40193a);
        f40200h = copyOf;
        copyOf.addAll(f40194b);
        HashMap hashMap = new HashMap();
        f40201i = hashMap;
        hashMap.put("ONE_D_MODE", f40200h);
        f40201i.put("PRODUCT_MODE", f40193a);
        f40201i.put("QR_CODE_MODE", f40195c);
        f40201i.put("DATA_MATRIX_MODE", f40196d);
        f40201i.put("AZTEC_MODE", f40197e);
        f40201i.put("PDF417_MODE", f40198f);
    }

    static Set<a> a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return a(stringExtra != null ? Arrays.asList(f40199g.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    public static Set<a> a(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters("SCAN_FORMATS");
        if (!(queryParameters == null || queryParameters.size() != 1 || queryParameters.get(0) == null)) {
            queryParameters = Arrays.asList(f40199g.split(queryParameters.get(0)));
        }
        return a(queryParameters, uri.getQueryParameter("SCAN_MODE"));
    }

    private static Set<a> a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet<E> noneOf = EnumSet.noneOf(a.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(a.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f40201i.get(str);
        }
        return null;
    }
}
