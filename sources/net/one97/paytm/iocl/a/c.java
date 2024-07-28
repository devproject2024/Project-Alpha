package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.transport.iocl_v1.c.e;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f14092a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f14093b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f14094c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f14095d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f14096e;

    /* renamed from: f  reason: collision with root package name */
    protected e f14097f;

    public abstract void a(e eVar);

    protected c(Object obj, View view, Button button, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f14092a = button;
        this.f14093b = imageView;
        this.f14094c = textView;
        this.f14095d = textView2;
        this.f14096e = textView3;
    }
}
