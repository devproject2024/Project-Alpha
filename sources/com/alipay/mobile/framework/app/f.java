package com.alipay.mobile.framework.app;

import android.os.Bundle;
import com.alipay.mobile.framework.c;

public abstract class f {
    public static final String KEY_APP_CLEAR_TOP = "appClearTop";
    public static final String KEY_APP_SCENE_ID = "startFromExternal";
    public static final String KEY_APP_START_FROM_EXTERNAL = "startFromExternal";
    private String mAppId;
    private c mContext;
    protected boolean mIsPrevent = false;
    private String mParentAppClassName;
    private String mSourceId;

    public abstract String getEntryClassName();

    /* access modifiers changed from: protected */
    public abstract void onCreate(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onDestroy(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onRestart(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onStart();

    /* access modifiers changed from: protected */
    public abstract void onStop();

    public abstract void restart(Bundle bundle);

    public abstract void stop();

    public final void setIsPrevent(boolean z) {
        this.mIsPrevent = z;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void destroy(Bundle bundle) {
        onDestroy(bundle);
    }

    public void attachContext(c cVar) {
        this.mContext = cVar;
    }

    public c getMicroApplicationContext() {
        return this.mContext;
    }

    public String getSourceId() {
        return this.mSourceId;
    }

    public void setSourceId(String str) {
        this.mSourceId = str;
    }
}
