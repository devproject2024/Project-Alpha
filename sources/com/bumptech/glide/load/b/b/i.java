package com.bumptech.glide.load.b.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alipay.mobile.nebula.util.tar.TarConstants;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f6789a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6790b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6791c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f6792d;

    interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        int i2;
        this.f6792d = aVar.f6794b;
        if (a(aVar.f6795c)) {
            i2 = aVar.f6801i / 2;
        } else {
            i2 = aVar.f6801i;
        }
        this.f6791c = i2;
        ActivityManager activityManager = aVar.f6795c;
        int round = Math.round(((float) (activityManager.getMemoryClass() * TarConstants.EOF_BLOCK * TarConstants.EOF_BLOCK)) * (a(activityManager) ? aVar.f6800h : aVar.f6799g));
        float a2 = (float) (aVar.f6796d.a() * aVar.f6796d.b() * 4);
        int round2 = Math.round(aVar.f6798f * a2);
        int round3 = Math.round(a2 * aVar.f6797e);
        int i3 = round - this.f6791c;
        int i4 = round3 + round2;
        if (i4 <= i3) {
            this.f6790b = round3;
            this.f6789a = round2;
        } else {
            float f2 = ((float) i3) / (aVar.f6798f + aVar.f6797e);
            this.f6790b = Math.round(aVar.f6797e * f2);
            this.f6789a = Math.round(f2 * aVar.f6798f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f6790b));
            sb.append(", pool size: ");
            sb.append(a(this.f6789a));
            sb.append(", byte array size: ");
            sb.append(a(this.f6791c));
            sb.append(", memory class limited? ");
            sb.append(i4 > round);
            sb.append(", max size: ");
            sb.append(a(round));
            sb.append(", memoryClass: ");
            sb.append(aVar.f6795c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f6795c));
        }
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f6792d, (long) i2);
    }

    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f6793a = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: b  reason: collision with root package name */
        final Context f6794b;

        /* renamed from: c  reason: collision with root package name */
        ActivityManager f6795c;

        /* renamed from: d  reason: collision with root package name */
        c f6796d;

        /* renamed from: e  reason: collision with root package name */
        float f6797e = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        float f6798f = ((float) f6793a);

        /* renamed from: g  reason: collision with root package name */
        float f6799g = 0.4f;

        /* renamed from: h  reason: collision with root package name */
        float f6800h = 0.33f;

        /* renamed from: i  reason: collision with root package name */
        int f6801i = 4194304;

        public a(Context context) {
            this.f6794b = context;
            this.f6795c = (ActivityManager) context.getSystemService("activity");
            this.f6796d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.a(this.f6795c)) {
                this.f6798f = 0.0f;
            }
        }
    }

    static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f6802a;

        b(DisplayMetrics displayMetrics) {
            this.f6802a = displayMetrics;
        }

        public final int a() {
            return this.f6802a.widthPixels;
        }

        public final int b() {
            return this.f6802a.heightPixels;
        }
    }
}
