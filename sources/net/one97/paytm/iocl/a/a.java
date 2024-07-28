package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.transport.iocl.c.e;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f14083a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f14084b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f14085c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f14086d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f14087e;

    /* renamed from: f  reason: collision with root package name */
    protected e f14088f;

    public abstract void a(e eVar);

    protected a(Object obj, View view, Button button, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f14083a = button;
        this.f14084b = imageView;
        this.f14085c = textView;
        this.f14086d = textView2;
        this.f14087e = textView3;
    }
}
