package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotels2.R;

public abstract class ba extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29220a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29221b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29222c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29223d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29224e;

    /* renamed from: f  reason: collision with root package name */
    protected DataViewModel f29225f;

    public abstract void a(DataViewModel dataViewModel);

    protected ba(Object obj, View view, View view2, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29220a = view2;
        this.f29221b = imageView;
        this.f29222c = recyclerView;
        this.f29223d = textView;
        this.f29224e = textView2;
    }

    public static ba a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ba) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_fragment_show_data, viewGroup, false, f.a());
    }
}
