package com.alipay.mobile.framework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.framework.app.d;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.b.a;
import com.alipay.mobile.h5container.service.H5Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d> f14960a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, f> f14961b = new ConcurrentHashMap();

    public static <T> T a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.a().a(str);
    }

    public final void a(String str, String str2, Bundle bundle) {
        d dVar;
        Map<String, d> map = this.f14960a;
        if (map != null && (dVar = map.get(H5Service.H5APP_ENGINE_TYPE)) != null) {
            com.alipay.mobile.framework.app.c.a(dVar.createApplication(), str, str2, bundle);
        }
    }

    public final void a(f fVar, Intent intent) {
        Context context = com.alipay.mobile.c.a.f14949b;
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (fVar != null) {
            intent.putExtra("app_id", fVar.getAppId());
            this.f14961b.put(fVar.getAppId(), fVar);
        }
        context.startActivity(intent);
    }
}
