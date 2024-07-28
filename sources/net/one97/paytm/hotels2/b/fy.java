package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class fy extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29781a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29782b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29783c;

    /* renamed from: d  reason: collision with root package name */
    protected String f29784d;

    public abstract void a(String str);

    public abstract void b(String str);

    protected fy(Object obj, View view, ImageView imageView, TextView textView) {
        super(obj, view, 0);
        this.f29781a = imageView;
        this.f29782b = textView;
    }
}
