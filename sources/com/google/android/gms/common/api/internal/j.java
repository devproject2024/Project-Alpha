package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

public interface j {
    Activity a();

    <T extends LifecycleCallback> T a(String str, Class<T> cls);

    void a(String str, LifecycleCallback lifecycleCallback);

    void startActivityForResult(Intent intent, int i2);
}
