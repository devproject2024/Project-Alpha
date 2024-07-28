package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;

public abstract class aa extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f29104a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29105b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f29106c;

    /* renamed from: d  reason: collision with root package name */
    public final CollapsingToolbarLayout f29107d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29108e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f29109f;

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f29110g;

    /* renamed from: h  reason: collision with root package name */
    public final NestedScrollView f29111h;

    /* renamed from: i  reason: collision with root package name */
    public final ShimmerFrameLayout f29112i;
    public final Toolbar j;
    public final TextView k;
    public final m l;
    public final o m;
    public final q n;
    public final s o;
    public final u p;
    public final w q;
    public final y r;
    public final ca s;
    protected DetailsViewModel t;

    public abstract void a(DetailsViewModel detailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected aa(Object obj, View view, AppBarLayout appBarLayout, ImageView imageView, Button button, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, ImageView imageView2, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, ShimmerFrameLayout shimmerFrameLayout, Toolbar toolbar, TextView textView2, m mVar, o oVar, q qVar, s sVar, u uVar, w wVar, y yVar, ca caVar) {
        super(obj, view, 9);
        Object obj2 = obj;
        View view2 = view;
        this.f29104a = appBarLayout;
        this.f29105b = imageView;
        this.f29106c = button;
        this.f29107d = collapsingToolbarLayout;
        this.f29108e = textView;
        this.f29109f = imageView2;
        this.f29110g = constraintLayout;
        this.f29111h = nestedScrollView;
        this.f29112i = shimmerFrameLayout;
        this.j = toolbar;
        this.k = textView2;
        this.l = mVar;
        setContainedBinding(this.l);
        this.m = oVar;
        setContainedBinding(this.m);
        this.n = qVar;
        setContainedBinding(this.n);
        this.o = sVar;
        setContainedBinding(this.o);
        this.p = uVar;
        setContainedBinding(this.p);
        this.q = wVar;
        setContainedBinding(this.q);
        this.r = yVar;
        setContainedBinding(this.r);
        this.s = caVar;
        setContainedBinding(this.s);
    }

    public static aa a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (aa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_details_screen, viewGroup, false, f.a());
    }
}
