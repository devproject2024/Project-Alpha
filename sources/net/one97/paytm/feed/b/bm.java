package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.feed.m.e;
import net.one97.paytm.feed.utility.RoundCornersImageView;

public abstract class bm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33966a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f33967b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundCornersImageView f33968c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33969d;

    /* renamed from: e  reason: collision with root package name */
    public final RoundCornersImageView f33970e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f33971f;

    /* renamed from: g  reason: collision with root package name */
    protected FeedGeneric f33972g;

    /* renamed from: h  reason: collision with root package name */
    protected NestedFeed f33973h;

    /* renamed from: i  reason: collision with root package name */
    protected e f33974i;

    protected bm(Object obj, View view, TextView textView, TextView textView2, RoundCornersImageView roundCornersImageView, TextView textView3, RoundCornersImageView roundCornersImageView2, ImageView imageView) {
        super(obj, view, 0);
        this.f33966a = textView;
        this.f33967b = textView2;
        this.f33968c = roundCornersImageView;
        this.f33969d = textView3;
        this.f33970e = roundCornersImageView2;
        this.f33971f = imageView;
    }
}
