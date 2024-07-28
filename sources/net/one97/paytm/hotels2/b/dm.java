package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class dm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29492a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f29493b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29494c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29495d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29496e;

    /* renamed from: f  reason: collision with root package name */
    protected PromocodeDataItem f29497f;

    /* renamed from: g  reason: collision with root package name */
    protected Boolean f29498g;

    /* renamed from: h  reason: collision with root package name */
    protected ReviewViewModel f29499h;

    public abstract void a(Boolean bool);

    public abstract void a(PromocodeDataItem promocodeDataItem);

    public abstract void a(ReviewViewModel reviewViewModel);

    protected dm(Object obj, View view, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f29492a = imageView;
        this.f29493b = constraintLayout;
        this.f29494c = textView;
        this.f29495d = textView2;
        this.f29496e = textView3;
    }
}
