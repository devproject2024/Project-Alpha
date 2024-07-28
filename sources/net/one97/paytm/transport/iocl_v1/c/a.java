package net.one97.paytm.transport.iocl_v1.c;

import android.app.Application;
import android.graphics.Typeface;
import android.widget.RadioButton;
import androidx.databinding.i;
import androidx.lifecycle.y;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public i<Boolean> f14429a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    public i<Boolean> f14430b = new i<>();

    /* renamed from: c  reason: collision with root package name */
    public i<Boolean> f14431c = new i<>();

    /* renamed from: d  reason: collision with root package name */
    public y<String> f14432d = new y<>();

    public a(Application application) {
        super(application);
    }

    public static void a(RadioButton radioButton, int i2) {
        radioButton.setTypeface((Typeface) null, i2);
    }
}
