package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPSortListItemViewModel;

public abstract class ek extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29608a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29609b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29610c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29611d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPSortListItemViewModel f29612e;

    public abstract void a(SRPSortListItemViewModel sRPSortListItemViewModel);

    protected ek(Object obj, View view, View view2, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f29608a = view2;
        this.f29609b = imageView;
        this.f29610c = textView;
        this.f29611d = textView2;
    }

    public final SRPSortListItemViewModel a() {
        return this.f29612e;
    }
}
