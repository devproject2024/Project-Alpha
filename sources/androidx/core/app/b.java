package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class b {
    public Bundle a() {
        return null;
    }

    public static b a(Activity activity, View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new a(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
        }
        return new b();
    }

    static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityOptions f2667a;

        a(ActivityOptions activityOptions) {
            this.f2667a = activityOptions;
        }

        public final Bundle a() {
            return this.f2667a.toBundle();
        }
    }

    protected b() {
    }
}
