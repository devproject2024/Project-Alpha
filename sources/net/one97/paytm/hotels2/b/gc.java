package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;

public abstract class gc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29805a;

    /* renamed from: b  reason: collision with root package name */
    protected String f29806b;

    /* renamed from: c  reason: collision with root package name */
    protected SRPViewModel f29807c;

    public abstract void a(String str);

    public abstract void a(SRPViewModel sRPViewModel);

    protected gc(Object obj, View view, TextView textView) {
        super(obj, view, 0);
        this.f29805a = textView;
    }
}
