package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.feed.a;

public abstract class w extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f34233a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f34234b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f34235c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f34236d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f34237e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f34238f;

    /* renamed from: g  reason: collision with root package name */
    public final SimpleExoPlayerView f34239g;

    /* renamed from: h  reason: collision with root package name */
    public final ProgressBar f34240h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f34241i;
    public final TextView j;
    public final RelativeLayout k;
    public final RoundedImageView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    protected FeedGeneric p;
    protected a q;
    protected net.one97.paytm.feed.ui.feed.d.a r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected w(Object obj, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, FrameLayout frameLayout, SimpleExoPlayerView simpleExoPlayerView, ProgressBar progressBar, TextView textView, TextView textView2, RelativeLayout relativeLayout, RoundedImageView roundedImageView, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, 1);
        Object obj2 = obj;
        View view2 = view;
        this.f34233a = imageView;
        this.f34234b = imageView2;
        this.f34235c = imageView3;
        this.f34236d = imageView4;
        this.f34237e = linearLayout;
        this.f34238f = frameLayout;
        this.f34239g = simpleExoPlayerView;
        this.f34240h = progressBar;
        this.f34241i = textView;
        this.j = textView2;
        this.k = relativeLayout;
        this.l = roundedImageView;
        this.m = textView3;
        this.n = textView4;
        this.o = textView5;
    }
}
