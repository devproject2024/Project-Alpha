package com.google.android.material.k;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.q;

public final class i {
    public static void a(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            ((h) background).r(f2);
        }
    }

    public static void a(View view) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            a(view, (h) background);
        }
    }

    public static void a(View view, h hVar) {
        if (hVar.i()) {
            hVar.q(q.c(view));
        }
    }

    public static d a(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? new l() : new e();
        }
        return new l();
    }
}
