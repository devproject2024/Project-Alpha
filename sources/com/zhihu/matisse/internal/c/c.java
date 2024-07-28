package com.zhihu.matisse.internal.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.zhihu.matisse.internal.entity.a;
import java.lang.ref.WeakReference;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Activity> f45741a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Fragment> f45742b = null;

    /* renamed from: c  reason: collision with root package name */
    public a f45743c;

    /* renamed from: d  reason: collision with root package name */
    public Uri f45744d;

    /* renamed from: e  reason: collision with root package name */
    public String f45745e;

    public c(Activity activity) {
        this.f45741a = new WeakReference<>(activity);
    }

    public static boolean a(Context context) {
        return context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera");
    }
}
