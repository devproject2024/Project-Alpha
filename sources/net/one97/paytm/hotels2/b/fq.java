package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotels2.R;

public abstract class fq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29746a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29747b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29748c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29749d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29750e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29751f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29752g;

    /* renamed from: h  reason: collision with root package name */
    protected SRPHeaderViewModel f29753h;

    /* renamed from: i  reason: collision with root package name */
    protected String f29754i;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    protected fq(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, 0);
        this.f29746a = imageView;
        this.f29747b = imageView2;
        this.f29748c = textView;
        this.f29749d = textView2;
        this.f29750e = textView3;
        this.f29751f = textView4;
        this.f29752g = textView5;
    }

    public static fq a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (fq) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hotel4_loader, viewGroup, false, f.a());
    }
}
