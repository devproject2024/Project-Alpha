package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.ui.feed.livetv.channel.a;

public abstract class am extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f33854a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f33855b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33856c;

    /* renamed from: d  reason: collision with root package name */
    protected Channel f33857d;

    /* renamed from: e  reason: collision with root package name */
    protected a f33858e;

    protected am(Object obj, View view, ImageView imageView, FrameLayout frameLayout, TextView textView) {
        super(obj, view, 0);
        this.f33854a = imageView;
        this.f33855b = frameLayout;
        this.f33856c = textView;
    }
}
