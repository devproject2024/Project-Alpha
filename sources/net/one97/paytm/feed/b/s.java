package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.ui.feed.actions.b;
import net.one97.paytm.feed.utility.FlowLayout;

public abstract class s extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f34215a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f34216b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f34217c;

    /* renamed from: d  reason: collision with root package name */
    public final FlowLayout f34218d;

    /* renamed from: e  reason: collision with root package name */
    public final NestedScrollView f34219e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f34220f;

    /* renamed from: g  reason: collision with root package name */
    protected b f34221g;

    protected s(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, FlowLayout flowLayout, NestedScrollView nestedScrollView, TextView textView3) {
        super(obj, view, 0);
        this.f34215a = imageView;
        this.f34216b = textView;
        this.f34217c = textView2;
        this.f34218d = flowLayout;
        this.f34219e = nestedScrollView;
        this.f34220f = textView3;
    }
}
