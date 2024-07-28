package com.airbnb.lottie.a;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

public final class a extends Paint {
    public final void setTextLocales(LocaleList localeList) {
    }

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    public a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public a(PorterDuff.Mode mode, byte b2) {
        super(1);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
