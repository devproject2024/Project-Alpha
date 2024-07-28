package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.g.f;
import java.lang.reflect.Constructor;

final class h {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f36471f;

    /* renamed from: g  reason: collision with root package name */
    private static Constructor<StaticLayout> f36472g;

    /* renamed from: h  reason: collision with root package name */
    private static Object f36473h;

    /* renamed from: a  reason: collision with root package name */
    Layout.Alignment f36474a;

    /* renamed from: b  reason: collision with root package name */
    int f36475b;

    /* renamed from: c  reason: collision with root package name */
    boolean f36476c;

    /* renamed from: d  reason: collision with root package name */
    boolean f36477d;

    /* renamed from: e  reason: collision with root package name */
    TextUtils.TruncateAt f36478e;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f36479i;
    private final TextPaint j;
    private final int k;
    private int l = 0;
    private int m;

    private h(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f36479i = charSequence;
        this.j = textPaint;
        this.k = i2;
        this.m = charSequence.length();
        this.f36474a = Layout.Alignment.ALIGN_NORMAL;
        this.f36475b = Integer.MAX_VALUE;
        this.f36476c = true;
        this.f36478e = null;
    }

    public static h a(CharSequence charSequence, TextPaint textPaint, int i2) {
        return new h(charSequence, textPaint, i2);
    }

    public final StaticLayout a() throws a {
        Class cls;
        if (this.f36479i == null) {
            this.f36479i = "";
        }
        int max = Math.max(0, this.k);
        CharSequence charSequence = this.f36479i;
        if (this.f36475b == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.j, (float) max, this.f36478e);
        }
        this.m = Math.min(charSequence.length(), this.m);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f36477d) {
                this.f36474a = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.l, this.m, this.j, max);
            obtain.setAlignment(this.f36474a);
            obtain.setIncludePad(this.f36476c);
            obtain.setTextDirection(this.f36477d ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f36478e;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f36475b);
            return obtain.build();
        }
        if (!f36471f) {
            try {
                boolean z = this.f36477d && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    f36473h = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = h.class.getClassLoader();
                    String str = this.f36477d ? "RTL" : "LTR";
                    Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                    Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                    f36473h = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});
                f36472g = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f36471f = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        try {
            return (StaticLayout) ((Constructor) f.a(f36472g)).newInstance(new Object[]{charSequence, Integer.valueOf(this.l), Integer.valueOf(this.m), this.j, Integer.valueOf(max), this.f36474a, f.a(f36473h), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f36476c), null, Integer.valueOf(max), Integer.valueOf(this.f36475b)});
        } catch (Exception e3) {
            throw new a(e3);
        }
    }

    static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }
}
