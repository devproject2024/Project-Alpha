package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.ui.feed.h.b.d;
import net.one97.paytm.feed.ui.feed.h.b.g;
import net.one97.paytm.feed.utility.RoundCornersImageView;

public abstract class au extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoundCornersImageView f33889a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f33890b;

    /* renamed from: c  reason: collision with root package name */
    protected Brand f33891c;

    /* renamed from: d  reason: collision with root package name */
    protected d f33892d;

    /* renamed from: e  reason: collision with root package name */
    protected g f33893e;

    protected au(Object obj, View view, RoundCornersImageView roundCornersImageView, TextView textView) {
        super(obj, view, 1);
        this.f33889a = roundCornersImageView;
        this.f33890b = textView;
    }
}
