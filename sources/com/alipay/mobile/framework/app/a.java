package com.alipay.mobile.framework.app;

import android.os.Bundle;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;

public abstract class a extends f {
    private String mAppId;

    public boolean canRestart(Bundle bundle) {
        return false;
    }

    public abstract String getEntryClassName();

    public String getParams() {
        return "";
    }

    public String getSceneId() {
        return "";
    }

    public String getSourceId() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract void onCreate(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onDestroy(Bundle bundle);

    public void restart(Bundle bundle) {
    }

    public void stop() {
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public c getMicroApplicationContext() {
        return b.a().f14954a;
    }
}
