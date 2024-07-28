package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class di extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29474a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29475b;

    /* renamed from: c  reason: collision with root package name */
    protected ReviewViewModel f29476c;

    public abstract void a(ReviewViewModel reviewViewModel);

    protected di(Object obj, View view, TextView textView, TextView textView2) {
        super(obj, view, 4);
        this.f29474a = textView;
        this.f29475b = textView2;
    }
}
