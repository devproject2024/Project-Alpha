package net.one97.paytm.recharge.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.recharge.legacy.catalog.model.CJRRichMessage;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f60315a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f60316b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f60317c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f60318d;

    /* renamed from: e  reason: collision with root package name */
    protected CJRRichMessage f60319e;

    public abstract void a(CJRRichMessage cJRRichMessage);

    protected c(Object obj, View view, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2) {
        super(obj, view, 0);
        this.f60315a = textView;
        this.f60316b = imageView;
        this.f60317c = constraintLayout;
        this.f60318d = textView2;
    }
}
