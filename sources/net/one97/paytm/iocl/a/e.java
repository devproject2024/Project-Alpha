package net.one97.paytm.iocl.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.transport.iocl.c.b;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f14101a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f14102b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f14103c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f14104d;

    /* renamed from: e  reason: collision with root package name */
    protected b f14105e;

    protected e(Object obj, View view, ImageView imageView, FrameLayout frameLayout, ProgressBar progressBar, LinearLayout linearLayout) {
        super(obj, view, 3);
        this.f14101a = imageView;
        this.f14102b = frameLayout;
        this.f14103c = progressBar;
        this.f14104d = linearLayout;
    }
}
