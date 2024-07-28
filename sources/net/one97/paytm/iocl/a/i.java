package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f14119a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f14120b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f14121c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f14122d;

    protected i(Object obj, View view, Button button, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f14119a = button;
        this.f14120b = imageView;
        this.f14121c = textView;
        this.f14122d = textView2;
    }
}
