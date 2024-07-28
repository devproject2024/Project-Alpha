package com.paytmmall.a;

import android.content.Context;
import android.os.Bundle;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytmmall.a.a.c;
import com.paytmmall.a.a.d;
import com.paytmmall.a.a.e;
import com.paytmmall.a.a.f;
import com.paytmmall.a.a.h;
import com.paytmmall.a.a.k;
import com.paytmmall.a.a.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.one97.paytm.phoenix.core.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Bundle f15383a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15384b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f15385c = new b();

    /* renamed from: d  reason: collision with root package name */
    private static String f15386d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final HashSet<String> f15387e = new HashSet<>();

    private b() {
    }

    public static List<a> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c());
        arrayList.add(new com.paytmmall.a.a.a());
        arrayList.add(new com.paytmmall.a.a.b());
        arrayList.add(new e());
        arrayList.add(new d());
        arrayList.add(new f());
        arrayList.add(new l());
        arrayList.add(new k());
        arrayList.add(new h());
        return arrayList;
    }

    public static List<Object> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.paytmmall.a.b.d());
        arrayList.add(new com.paytmmall.a.b.e());
        arrayList.add(new com.paytmmall.a.b.b());
        arrayList.add(new com.paytmmall.a.b.a());
        arrayList.add(new com.paytmmall.a.b.c());
        return arrayList;
    }

    public static Bundle a(Context context) {
        kotlin.g.b.k.c(context, "context");
        Bundle bundle = new Bundle();
        try {
            bundle.putString("pullRefresh", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("deviceName", com.paytm.utility.b.b());
            bundle.putString("appVersion", com.paytm.utility.b.Q(context));
            bundle.putString("osVersion", String.valueOf(com.paytm.utility.b.d()));
            bundle.putString("deviceId", com.paytm.utility.b.A(context));
            bundle.putString("applicationName", "Paytm");
            bundle.putString("applicationId", "com.paytmmall.artifact");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bundle;
    }
}
