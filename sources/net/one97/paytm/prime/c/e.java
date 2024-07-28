package net.one97.paytm.prime.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.prime.g.c;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f59765a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f59766b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f59767c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f59768d;

    /* renamed from: e  reason: collision with root package name */
    protected c f59769e;

    public abstract void a(c cVar);

    protected e(Object obj, View view, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, 5);
        this.f59765a = textView;
        this.f59766b = imageView;
        this.f59767c = linearLayout;
        this.f59768d = textView2;
    }
}
