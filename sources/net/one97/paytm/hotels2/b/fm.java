package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPListItemViewModel;

public abstract class fm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29730a;

    /* renamed from: b  reason: collision with root package name */
    protected String f29731b;

    /* renamed from: c  reason: collision with root package name */
    protected SRPListItemViewModel f29732c;

    public abstract void a(String str);

    public abstract void a(SRPListItemViewModel sRPListItemViewModel);

    protected fm(Object obj, View view, ImageView imageView) {
        super(obj, view, 0);
        this.f29730a = imageView;
    }
}
