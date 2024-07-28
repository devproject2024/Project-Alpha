package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.feed.m.e;
import net.one97.paytm.feed.utility.RoundCornersImageView;

public abstract class cm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f34063a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f34064b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundCornersImageView f34065c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f34066d;

    /* renamed from: e  reason: collision with root package name */
    protected FeedGeneric f34067e;

    /* renamed from: f  reason: collision with root package name */
    protected e f34068f;

    /* renamed from: g  reason: collision with root package name */
    protected NestedFeed f34069g;

    protected cm(Object obj, View view, TextView textView, TextView textView2, RoundCornersImageView roundCornersImageView, TextView textView3) {
        super(obj, view, 0);
        this.f34063a = textView;
        this.f34064b = textView2;
        this.f34065c = roundCornersImageView;
        this.f34066d = textView3;
    }
}
