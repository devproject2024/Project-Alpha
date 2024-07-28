package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoundedImageView f34154a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f34155b;

    /* renamed from: c  reason: collision with root package name */
    protected FeedGeneric f34156c;

    /* renamed from: d  reason: collision with root package name */
    protected net.one97.paytm.feed.ui.feed.m.e f34157d;

    /* renamed from: e  reason: collision with root package name */
    protected NestedFeed f34158e;

    protected e(Object obj, View view, RoundedImageView roundedImageView, ImageView imageView) {
        super(obj, view, 0);
        this.f34154a = roundedImageView;
        this.f34155b = imageView;
    }
}
