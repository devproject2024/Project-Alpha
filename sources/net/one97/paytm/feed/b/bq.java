package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.ui.feed.l.d;

public abstract class bq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f33984a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f33985b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33986c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f33987d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f33988e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33989f;

    /* renamed from: g  reason: collision with root package name */
    protected RecommendedApps f33990g;

    /* renamed from: h  reason: collision with root package name */
    protected d f33991h;

    protected bq(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f33984a = imageView;
        this.f33985b = imageView2;
        this.f33986c = textView;
        this.f33987d = imageView3;
        this.f33988e = textView2;
        this.f33989f = textView3;
    }
}
