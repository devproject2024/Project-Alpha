package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.feed.m.e;

public abstract class bk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33957a;

    /* renamed from: b  reason: collision with root package name */
    public final RoundedImageView f33958b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33959c;

    /* renamed from: d  reason: collision with root package name */
    protected FeedGeneric f33960d;

    /* renamed from: e  reason: collision with root package name */
    protected e f33961e;

    /* renamed from: f  reason: collision with root package name */
    protected NestedFeed f33962f;

    protected bk(Object obj, View view, TextView textView, RoundedImageView roundedImageView, TextView textView2) {
        super(obj, view, 0);
        this.f33957a = textView;
        this.f33958b = roundedImageView;
        this.f33959c = textView2;
    }
}
