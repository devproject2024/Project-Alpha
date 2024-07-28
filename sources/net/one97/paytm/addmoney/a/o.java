package net.one97.paytm.addmoney.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.newaddmoney.c.a;

public abstract class o extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f48081a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f48082b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f48083c;

    /* renamed from: d  reason: collision with root package name */
    public final ScrollView f48084d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f48085e;

    /* renamed from: f  reason: collision with root package name */
    protected a f48086f;

    protected o(e eVar, View view, RelativeLayout relativeLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, ScrollView scrollView, TextView textView) {
        super(eVar, view, 0);
        this.f48081a = relativeLayout;
        this.f48082b = linearLayout;
        this.f48083c = relativeLayout2;
        this.f48084d = scrollView;
        this.f48085e = textView;
    }
}
