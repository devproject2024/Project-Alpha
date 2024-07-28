package com.google.zxing.client.android.c;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.zxing.client.a.d;
import com.google.zxing.client.a.q;
import com.google.zxing.r;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.Locale;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f40174a = {ViewHolderFactory.CLASS_HOME, "work", "mobile"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f40175b = {ViewHolderFactory.CLASS_HOME, "work", "mobile", "fax", "pager", "main"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f40176c = {ViewHolderFactory.CLASS_HOME, "work"};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f40177d = {1, 2, 4};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f40178e = {1, 3, 2, 4, 6, 12};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f40179f = {1, 2};

    /* renamed from: i  reason: collision with root package name */
    private static final String f40180i = g.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    final q f40181g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f40182h;
    private final r j;
    private final String k;

    public boolean b() {
        return false;
    }

    public g(Activity activity, q qVar) {
        this(activity, qVar, (r) null);
    }

    g(Activity activity, q qVar, r rVar) {
        this.f40181g = qVar;
        this.f40182h = activity;
        this.j = rVar;
        String string = PreferenceManager.getDefaultSharedPreferences(this.f40182h).getString("preferences_custom_product_search", (String) null);
        if (string != null && string.trim().isEmpty()) {
            string = null;
        }
        this.k = string;
    }

    public CharSequence a() {
        return this.f40181g.a().replace("\r", "");
    }

    public static int a(String str, String[] strArr, int[] iArr) {
        if (str == null) {
            return -1;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str2 = strArr[i2];
            if (str.startsWith(str2) || str.startsWith(str2.toUpperCase(Locale.ENGLISH))) {
                return iArr[i2];
            }
        }
        return -1;
    }

    public static void a(Intent intent, String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra(str, str2);
        }
    }

    public final String c() {
        d dVar = (d) this.f40181g;
        String[] strArr = dVar.f40034d;
        String[] strArr2 = dVar.f40035e;
        int min = Math.min(strArr != null ? strArr.length : 0, com.google.zxing.client.android.d.f40189a.length);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        for (int i2 = 0; i2 < min; i2++) {
            if (strArr2 != null && i2 < strArr2.length) {
                if (strArr2[i2].toLowerCase().startsWith("mobile")) {
                    str2 = strArr[i2];
                } else if (strArr2[i2].toLowerCase().startsWith("work")) {
                    str3 = strArr[i2];
                } else if (strArr2[i2].toLowerCase().startsWith(ViewHolderFactory.CLASS_HOME)) {
                    str4 = strArr[i2];
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        } else if (!TextUtils.isEmpty(str3)) {
            str = str3;
        } else if (!TextUtils.isEmpty(str4)) {
            str = str4;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("+") || str.length() != 13) {
            return str.length() == 12 ? str.substring(2) : str;
        }
        return str.substring(3);
    }
}
