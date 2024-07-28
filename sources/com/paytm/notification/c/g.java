package com.paytm.notification.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.g.b.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43031a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static float a(Context context, float f2) {
            k.c(context, "context");
            Resources resources = context.getResources();
            k.a((Object) resources, "r");
            return TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
        }
    }
}
