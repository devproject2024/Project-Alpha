package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.viewmodel.ErrorViewModel;
import net.one97.paytm.hotels2.R;

public abstract class gq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29868a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29869b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29870c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29871d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29872e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29873f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29874g;

    /* renamed from: h  reason: collision with root package name */
    protected ErrorViewModel f29875h;

    public abstract void a(ErrorViewModel errorViewModel);

    protected gq(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, 7);
        this.f29868a = imageView;
        this.f29869b = imageView2;
        this.f29870c = textView;
        this.f29871d = textView2;
        this.f29872e = textView3;
        this.f29873f = textView4;
        this.f29874g = textView5;
    }

    public static gq a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (gq) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_error_fragment, viewGroup, false, f.a());
    }
}
