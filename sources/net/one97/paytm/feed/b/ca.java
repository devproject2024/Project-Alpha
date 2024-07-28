package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

public abstract class ca extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f34025a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f34026b;

    /* renamed from: c  reason: collision with root package name */
    public final Toolbar f34027c;

    protected ca(Object obj, View view, LinearLayout linearLayout, RelativeLayout relativeLayout, Toolbar toolbar) {
        super(obj, view, 0);
        this.f34025a = linearLayout;
        this.f34026b = relativeLayout;
        this.f34027c = toolbar;
    }
}
