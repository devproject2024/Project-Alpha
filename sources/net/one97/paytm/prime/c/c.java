package net.one97.paytm.prime.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.prime.g.b;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f59754a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f59755b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f59756c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f59757d;

    /* renamed from: e  reason: collision with root package name */
    protected b f59758e;

    public abstract void a(b bVar);

    protected c(Object obj, View view, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, 5);
        this.f59754a = textView;
        this.f59755b = imageView;
        this.f59756c = linearLayout;
        this.f59757d = textView2;
    }
}
