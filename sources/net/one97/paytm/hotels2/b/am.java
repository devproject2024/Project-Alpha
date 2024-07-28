package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainViewModel;
import net.one97.paytm.hotels2.R;

public abstract class am extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f29158a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29159b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f29160c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f29161d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29162e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f29163f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29164g;

    /* renamed from: h  reason: collision with root package name */
    protected SRPFilterLocalityAndHotelChainViewModel f29165h;

    public abstract void a(SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel);

    protected am(Object obj, View view, LinearLayout linearLayout, TextView textView, Button button, RecyclerView recyclerView, TextView textView2, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, 1);
        this.f29158a = linearLayout;
        this.f29159b = textView;
        this.f29160c = button;
        this.f29161d = recyclerView;
        this.f29162e = textView2;
        this.f29163f = linearLayout2;
        this.f29164g = textView3;
    }

    public static am a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (am) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_filter_locality_hotel_chain_bottom_sheet, viewGroup, false, f.a());
    }
}
