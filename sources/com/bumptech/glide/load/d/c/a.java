package com.bumptech.glide.load.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.d;
import androidx.core.content.b;
import androidx.core.content.b.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f7201a = true;

    public static Drawable a(Context context, Context context2, int i2) {
        return a(context, context2, i2, (Resources.Theme) null);
    }

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        return a(context, context, i2, theme);
    }

    private static Drawable a(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (f7201a) {
                return androidx.appcompat.a.a.a.b(theme != null ? new d(context2, theme) : context2, i2);
            }
        } catch (NoClassDefFoundError unused) {
            f7201a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return b.a(context2, i2);
            }
            throw e2;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return f.a(context2.getResources(), i2, theme);
    }
}
