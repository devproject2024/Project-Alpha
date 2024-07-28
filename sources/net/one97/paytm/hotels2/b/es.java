package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;

public abstract class es extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ag f29644a;

    /* renamed from: b  reason: collision with root package name */
    public final eq f29645b;

    /* renamed from: c  reason: collision with root package name */
    public final ai f29646c;

    /* renamed from: d  reason: collision with root package name */
    public final ao f29647d;

    /* renamed from: e  reason: collision with root package name */
    public final ak f29648e;

    /* renamed from: f  reason: collision with root package name */
    public final ag f29649f;

    /* renamed from: g  reason: collision with root package name */
    public final aq f29650g;

    /* renamed from: h  reason: collision with root package name */
    public final aq f29651h;

    /* renamed from: i  reason: collision with root package name */
    protected SRPFilterViewModel f29652i;

    public abstract void a(SRPFilterViewModel sRPFilterViewModel);

    protected es(Object obj, View view, ag agVar, eq eqVar, ai aiVar, ao aoVar, ak akVar, ag agVar2, aq aqVar, aq aqVar2) {
        super(obj, view, 16);
        this.f29644a = agVar;
        setContainedBinding(this.f29644a);
        this.f29645b = eqVar;
        setContainedBinding(this.f29645b);
        this.f29646c = aiVar;
        setContainedBinding(this.f29646c);
        this.f29647d = aoVar;
        setContainedBinding(this.f29647d);
        this.f29648e = akVar;
        setContainedBinding(this.f29648e);
        this.f29649f = agVar2;
        setContainedBinding(this.f29649f);
        this.f29650g = aqVar;
        setContainedBinding(this.f29650g);
        this.f29651h = aqVar2;
        setContainedBinding(this.f29651h);
    }

    public static es a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (es) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_srp_filter_layout, viewGroup, false, f.a());
    }
}
