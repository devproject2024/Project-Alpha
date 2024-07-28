package com.business.common_module.zxingutils;

import com.google.zxing.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<a> f7418a = EnumSet.of(a.UPC_A, new a[]{a.UPC_E, a.EAN_13, a.EAN_8, a.RSS_14, a.RSS_EXPANDED});

    /* renamed from: b  reason: collision with root package name */
    public static final Set<a> f7419b = EnumSet.of(a.CODE_39, a.CODE_93, a.CODE_128, a.ITF, a.CODABAR);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<a> f7420c = EnumSet.of(a.QR_CODE);

    /* renamed from: d  reason: collision with root package name */
    public static final Set<a> f7421d = EnumSet.of(a.DATA_MATRIX);

    /* renamed from: e  reason: collision with root package name */
    public static final Set<a> f7422e = EnumSet.of(a.AZTEC);

    /* renamed from: f  reason: collision with root package name */
    public static final Set<a> f7423f = EnumSet.of(a.PDF_417);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f7424g = Pattern.compile(AppConstants.COMMA);

    /* renamed from: h  reason: collision with root package name */
    private static final Set<a> f7425h;

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Set<a>> f7426i;

    static {
        EnumSet<a> copyOf = EnumSet.copyOf(f7418a);
        f7425h = copyOf;
        copyOf.addAll(f7419b);
        HashMap hashMap = new HashMap();
        f7426i = hashMap;
        hashMap.put("ONE_D_MODE", f7425h);
        f7426i.put("PRODUCT_MODE", f7418a);
        f7426i.put("QR_CODE_MODE", f7420c);
        f7426i.put("DATA_MATRIX_MODE", f7421d);
        f7426i.put("AZTEC_MODE", f7422e);
        f7426i.put("PDF417_MODE", f7423f);
    }
}
