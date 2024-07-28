package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.feed.m.e;
import net.one97.paytm.feed.utility.RoundCornersImageView;

public abstract class bo extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f33975a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f33976b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33977c;

    /* renamed from: d  reason: collision with root package name */
    public final RoundCornersImageView f33978d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f33979e;

    /* renamed from: f  reason: collision with root package name */
    public final RoundedImageView f33980f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f33981g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f33982h;

    /* renamed from: i  reason: collision with root package name */
    protected FeedGeneric f33983i;
    protected e j;
    protected NestedFeed k;

    protected bo(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, RoundCornersImageView roundCornersImageView, TextView textView3, RoundedImageView roundedImageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, 0);
        this.f33975a = imageView;
        this.f33976b = textView;
        this.f33977c = textView2;
        this.f33978d = roundCornersImageView;
        this.f33979e = textView3;
        this.f33980f = roundedImageView;
        this.f33981g = imageView2;
        this.f33982h = imageView3;
    }
}
