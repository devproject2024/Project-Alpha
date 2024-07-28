package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.transport.iocl_v1.c.c;

public abstract class g extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f14110a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f14111b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f14112c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f14113d;

    /* renamed from: e  reason: collision with root package name */
    protected c f14114e;

    public abstract void a(c cVar);

    protected g(Object obj, View view, ImageView imageView, FrameLayout frameLayout, ProgressBar progressBar, LinearLayout linearLayout) {
        super(obj, view, 3);
        this.f14110a = imageView;
        this.f14111b = frameLayout;
        this.f14112c = progressBar;
        this.f14113d = linearLayout;
    }
}
