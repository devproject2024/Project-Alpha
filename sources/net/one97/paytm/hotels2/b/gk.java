package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;

public abstract class gk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final em f29841a;

    /* renamed from: b  reason: collision with root package name */
    public final ge f29842b;

    /* renamed from: c  reason: collision with root package name */
    public final ey f29843c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f29844d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f29845e;

    /* renamed from: f  reason: collision with root package name */
    public final ShimmerFrameLayout f29846f;

    /* renamed from: g  reason: collision with root package name */
    public final bq f29847g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29848h;

    /* renamed from: i  reason: collision with root package name */
    protected SRPViewModel f29849i;
    protected SRPHeaderViewModel j;
    protected HotelSearchResponse k;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    public abstract void a(SRPViewModel sRPViewModel);

    protected gk(Object obj, View view, em emVar, ge geVar, ey eyVar, RecyclerView recyclerView, RecyclerView recyclerView2, ShimmerFrameLayout shimmerFrameLayout, bq bqVar, TextView textView) {
        super(obj, view, 8);
        this.f29841a = emVar;
        setContainedBinding(this.f29841a);
        this.f29842b = geVar;
        setContainedBinding(this.f29842b);
        this.f29843c = eyVar;
        setContainedBinding(this.f29843c);
        this.f29844d = recyclerView;
        this.f29845e = recyclerView2;
        this.f29846f = shimmerFrameLayout;
        this.f29847g = bqVar;
        setContainedBinding(this.f29847g);
        this.f29848h = textView;
    }

    public static gk a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (gk) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hotel4_srp_view, viewGroup, false, f.a());
    }
}
