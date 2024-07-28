package com.travel.utils;

import android.view.View;
import kotlin.g.b.k;

public final class j {
    public static final boolean a(View view) {
        k.c(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }
}
