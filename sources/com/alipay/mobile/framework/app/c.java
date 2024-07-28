package com.alipay.mobile.framework.app;

import android.os.Bundle;

public final class c {
    public static void a(f fVar, String str, String str2, Bundle bundle) {
        if (fVar != null) {
            fVar.setAppId(str2);
            fVar.attachContext(fVar.getMicroApplicationContext());
            fVar.setSourceId(str);
            fVar.onCreate(bundle);
            fVar.onStart();
        }
    }
}
