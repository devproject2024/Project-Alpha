package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.flexbox.FlexboxLayout;

public abstract class aq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FlexboxLayout f29177a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29178b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29179c;

    public abstract void a(String str);

    protected aq(Object obj, View view, FlexboxLayout flexboxLayout, TextView textView) {
        super(obj, view, 0);
        this.f29177a = flexboxLayout;
        this.f29178b = textView;
    }
}
