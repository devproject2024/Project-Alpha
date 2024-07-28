package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class dk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29483a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f29484b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29485c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29486d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29487e;

    /* renamed from: f  reason: collision with root package name */
    public final View f29488f;

    /* renamed from: g  reason: collision with root package name */
    public final di f29489g;

    /* renamed from: h  reason: collision with root package name */
    protected ReviewViewModel f29490h;

    public abstract void a(ReviewViewModel reviewViewModel);

    protected dk(Object obj, View view, View view2, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, TextView textView, TextView textView2, View view3, di diVar) {
        super(obj, view, 3);
        this.f29483a = view2;
        this.f29484b = lottieAnimationView;
        this.f29485c = recyclerView;
        this.f29486d = textView;
        this.f29487e = textView2;
        this.f29488f = view3;
        this.f29489g = diVar;
        setContainedBinding(this.f29489g);
    }
}
