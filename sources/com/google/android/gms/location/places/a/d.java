package com.google.android.gms.location.places.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected final Intent f11413a;

    public d(String str) {
        this.f11413a = new Intent(str);
        this.f11413a.setPackage("com.google.android.gms");
    }

    /* access modifiers changed from: protected */
    public Intent a(Activity activity) throws f, e {
        Resources.Theme theme = activity.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        if (theme.resolveAttribute(16843827, typedValue, true) && !this.f11413a.hasExtra("primary_color")) {
            this.f11413a.putExtra("primary_color", typedValue.data);
        }
        if (theme.resolveAttribute(16843828, typedValue2, true) && !this.f11413a.hasExtra("primary_color_dark")) {
            this.f11413a.putExtra("primary_color_dark", typedValue2.data);
        }
        c.a();
        c.b((Context) activity);
        return this.f11413a;
    }
}
