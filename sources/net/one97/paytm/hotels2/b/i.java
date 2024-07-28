package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f29888a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29889b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29890c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29891d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29892e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29893f;

    /* renamed from: g  reason: collision with root package name */
    protected MetaData f29894g;

    public abstract void a(MetaData metaData);

    protected i(Object obj, View view, CardView cardView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f29888a = cardView;
        this.f29889b = imageView;
        this.f29890c = imageView2;
        this.f29891d = textView;
        this.f29892e = textView2;
        this.f29893f = textView3;
    }
}
