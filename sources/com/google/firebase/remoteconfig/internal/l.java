package com.google.firebase.remoteconfig.internal;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f39397a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f39398b = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f39399c = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public final a f39400d;

    /* renamed from: e  reason: collision with root package name */
    public final a f39401e;

    public l(a aVar, a aVar2) {
        this.f39400d = aVar;
        this.f39401e = aVar2;
    }

    public final String a(String str) {
        String a2 = a(this.f39400d, str);
        if (a2 != null) {
            return a2;
        }
        String a3 = a(this.f39401e, str);
        if (a3 != null) {
            return a3;
        }
        a(str, "String");
        return "";
    }

    public static Set<String> a(a aVar) {
        HashSet hashSet = new HashSet();
        f a2 = aVar.a();
        if (a2 == null) {
            return hashSet;
        }
        Iterator<String> keys = a2.f39368a.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    public static void a(String str, String str2) {
        String.format("No value of type '%s' exists for parameter key '%s'.", new Object[]{str2, str});
    }

    public static String a(a aVar, String str) {
        f a2 = aVar.a();
        if (a2 == null) {
            return null;
        }
        try {
            return a2.f39368a.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Long b(a aVar, String str) {
        f a2 = aVar.a();
        if (a2 == null) {
            return null;
        }
        try {
            return Long.valueOf(a2.f39368a.getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }
}
