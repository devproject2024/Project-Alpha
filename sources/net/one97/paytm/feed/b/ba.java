package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.feed.m.e;

public abstract class ba extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33916a;

    /* renamed from: b  reason: collision with root package name */
    public final RoundedImageView f33917b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33918c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f33919d;

    /* renamed from: e  reason: collision with root package name */
    public final View f33920e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33921f;

    /* renamed from: g  reason: collision with root package name */
    protected FeedGeneric f33922g;

    /* renamed from: h  reason: collision with root package name */
    protected e f33923h;

    /* renamed from: i  reason: collision with root package name */
    protected NestedFeed f33924i;

    protected ba(Object obj, View view, TextView textView, RoundedImageView roundedImageView, TextView textView2, ImageView imageView, View view2, TextView textView3) {
        super(obj, view, 0);
        this.f33916a = textView;
        this.f33917b = roundedImageView;
        this.f33918c = textView2;
        this.f33919d = imageView;
        this.f33920e = view2;
        this.f33921f = textView3;
    }
}
