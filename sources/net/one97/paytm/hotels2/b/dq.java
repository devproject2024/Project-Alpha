package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;

public abstract class dq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final dg f29510a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f29511b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f29512c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f29513d;

    /* renamed from: e  reason: collision with root package name */
    public final de f29514e;

    /* renamed from: f  reason: collision with root package name */
    public final cs f29515f;

    /* renamed from: g  reason: collision with root package name */
    public final cu f29516g;

    /* renamed from: h  reason: collision with root package name */
    public final cy f29517h;

    /* renamed from: i  reason: collision with root package name */
    public final da f29518i;
    public final dc j;
    public final dk k;
    public final Cdo l;
    protected ReviewViewModel m;
    protected DetailsViewModel n;
    protected RoomSelectionViewModel o;

    public abstract void a(DetailsViewModel detailsViewModel);

    public abstract void a(ReviewViewModel reviewViewModel);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected dq(Object obj, View view, dg dgVar, LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout, NestedScrollView nestedScrollView, de deVar, cs csVar, cu cuVar, cy cyVar, da daVar, dc dcVar, dk dkVar, Cdo doVar) {
        super(obj, view, 10);
        this.f29510a = dgVar;
        setContainedBinding(this.f29510a);
        this.f29511b = lottieAnimationView;
        this.f29512c = relativeLayout;
        this.f29513d = nestedScrollView;
        this.f29514e = deVar;
        setContainedBinding(this.f29514e);
        this.f29515f = csVar;
        setContainedBinding(this.f29515f);
        this.f29516g = cuVar;
        setContainedBinding(this.f29516g);
        this.f29517h = cyVar;
        setContainedBinding(this.f29517h);
        this.f29518i = daVar;
        setContainedBinding(this.f29518i);
        this.j = dcVar;
        setContainedBinding(this.j);
        this.k = dkVar;
        setContainedBinding(this.k);
        this.l = doVar;
        setContainedBinding(this.l);
    }

    public static dq a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (dq) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_review_screen, viewGroup, false, f.a());
    }
}
