package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class be extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f33930a;

    /* renamed from: b  reason: collision with root package name */
    public final RoundedImageView f33931b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f33932c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33933d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f33934e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33935f;

    protected be(Object obj, View view, ImageView imageView, RoundedImageView roundedImageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f33930a = imageView;
        this.f33931b = roundedImageView;
        this.f33932c = constraintLayout;
        this.f33933d = textView;
        this.f33934e = textView2;
        this.f33935f = textView3;
    }
}
