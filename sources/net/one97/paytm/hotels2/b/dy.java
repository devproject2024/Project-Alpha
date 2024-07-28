package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;

public abstract class dy extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f29546a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f29547b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29548c;

    /* renamed from: d  reason: collision with root package name */
    public final ds f29549d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29550e;

    /* renamed from: f  reason: collision with root package name */
    public final du f29551f;

    /* renamed from: g  reason: collision with root package name */
    public final dw f29552g;

    /* renamed from: h  reason: collision with root package name */
    protected RoomSelectionViewModel f29553h;

    /* renamed from: i  reason: collision with root package name */
    protected Boolean f29554i;

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected dy(Object obj, View view, LinearLayout linearLayout, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, ds dsVar, TextView textView, du duVar, dw dwVar) {
        super(obj, view, 6);
        this.f29546a = linearLayout;
        this.f29547b = lottieAnimationView;
        this.f29548c = recyclerView;
        this.f29549d = dsVar;
        setContainedBinding(this.f29549d);
        this.f29550e = textView;
        this.f29551f = duVar;
        setContainedBinding(this.f29551f);
        this.f29552g = dwVar;
        setContainedBinding(this.f29552g);
    }

    public static dy a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (dy) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_room_selection_vpager, viewGroup, false, f.a());
    }
}
