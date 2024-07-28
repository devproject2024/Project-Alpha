package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.ui.PlayerView;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.feed.a;

public abstract class cw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoundedImageView f34106a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f34107b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f34108c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f34109d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f34110e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f34111f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f34112g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f34113h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f34114i;
    public final PlayerView j;
    public final ProgressBar k;
    public final ConstraintLayout l;
    public final ImageView m;
    public final TextView n;
    public final RoundedImageView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    protected FeedGeneric s;
    protected Integer t;
    protected a u;
    protected net.one97.paytm.feed.ui.feed.d.a v;
    protected Integer w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected cw(Object obj, View view, RoundedImageView roundedImageView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ImageView imageView3, TextView textView3, ImageView imageView4, ImageView imageView5, PlayerView playerView, ProgressBar progressBar, ConstraintLayout constraintLayout, ImageView imageView6, TextView textView4, RoundedImageView roundedImageView2, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, 1);
        Object obj2 = obj;
        View view2 = view;
        this.f34106a = roundedImageView;
        this.f34107b = imageView;
        this.f34108c = imageView2;
        this.f34109d = textView;
        this.f34110e = textView2;
        this.f34111f = imageView3;
        this.f34112g = textView3;
        this.f34113h = imageView4;
        this.f34114i = imageView5;
        this.j = playerView;
        this.k = progressBar;
        this.l = constraintLayout;
        this.m = imageView6;
        this.n = textView4;
        this.o = roundedImageView2;
        this.p = textView5;
        this.q = textView6;
        this.r = textView7;
    }
}
