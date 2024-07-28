package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import dagger.a.g;

public abstract class DaggerActivity extends Activity implements c {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        g.a(this, "activity");
        Application application = getApplication();
        if (application instanceof c) {
            c cVar = (c) application;
            a<Object> b2 = cVar.b();
            g.a(b2, "%s.androidInjector() returned null", cVar.getClass());
            b2.a(this);
            super.onCreate(bundle);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), c.class.getCanonicalName()}));
    }
}
