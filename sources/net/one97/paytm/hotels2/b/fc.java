package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class fc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29689a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29690b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29691c;

    /* renamed from: d  reason: collision with root package name */
    protected String f29692d;

    public abstract void a(String str);

    public abstract void b(String str);

    protected fc(Object obj, View view, ImageView imageView, TextView textView) {
        super(obj, view, 0);
        this.f29689a = imageView;
        this.f29690b = textView;
    }
}
