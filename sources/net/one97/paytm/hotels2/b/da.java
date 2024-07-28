package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class da extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29439a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29440b;

    /* renamed from: c  reason: collision with root package name */
    protected ReviewViewModel f29441c;

    public abstract void a(ReviewViewModel reviewViewModel);

    protected da(Object obj, View view, ImageView imageView, TextView textView) {
        super(obj, view, 0);
        this.f29439a = imageView;
        this.f29440b = textView;
    }
}
