package com.google.firebase.crashlytics.a.j;

import com.google.android.datatransport.e;
import com.google.firebase.crashlytics.a.e.a.a;
import com.google.firebase.crashlytics.a.e.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;

final /* synthetic */ class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final c f38650a = new c();

    private c() {
    }

    public static e a() {
        return f38650a;
    }

    public final Object a(Object obj) {
        return a.a((v) obj).getBytes(Charset.forName(AppConstants.UTF_8));
    }
}
