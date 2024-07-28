package net.one97.paytm.recharge.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.recharge.automatic.widgets.CJRAutomaticDisabledView;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public abstract class u extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CJRAutomaticDisabledView f60382a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f60383b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f60384c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f60385d;

    /* renamed from: e  reason: collision with root package name */
    protected CJRAutomaticSubscriptionItemModel f60386e;

    public abstract void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel);

    protected u(Object obj, View view, CJRAutomaticDisabledView cJRAutomaticDisabledView, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f60382a = cJRAutomaticDisabledView;
        this.f60383b = imageView;
        this.f60384c = textView;
        this.f60385d = textView2;
    }
}
