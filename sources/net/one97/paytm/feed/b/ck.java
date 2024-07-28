package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

public abstract class ck extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f34057a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f34058b;

    /* renamed from: c  reason: collision with root package name */
    public final Toolbar f34059c;

    protected ck(Object obj, View view, LinearLayout linearLayout, RelativeLayout relativeLayout, Toolbar toolbar) {
        super(obj, view, 0);
        this.f34057a = linearLayout;
        this.f34058b = relativeLayout;
        this.f34059c = toolbar;
    }
}
