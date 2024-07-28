package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel;
import net.one97.paytm.hotels2.R;

public abstract class ga extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29796a;

    /* renamed from: b  reason: collision with root package name */
    public final View f29797b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f29798c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageButton f29799d;

    /* renamed from: e  reason: collision with root package name */
    public final gm f29800e;

    /* renamed from: f  reason: collision with root package name */
    public final LottieAnimationView f29801f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f29802g;

    /* renamed from: h  reason: collision with root package name */
    public final RecyclerView f29803h;

    /* renamed from: i  reason: collision with root package name */
    public final RecyclerView f29804i;
    protected HotelSearchViewModel j;

    public abstract void a(HotelSearchViewModel hotelSearchViewModel);

    protected ga(Object obj, View view, View view2, View view3, EditText editText, ImageButton imageButton, gm gmVar, LottieAnimationView lottieAnimationView, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(obj, view, 3);
        this.f29796a = view2;
        this.f29797b = view3;
        this.f29798c = editText;
        this.f29799d = imageButton;
        this.f29800e = gmVar;
        setContainedBinding(this.f29800e);
        this.f29801f = lottieAnimationView;
        this.f29802g = linearLayout;
        this.f29803h = recyclerView;
        this.f29804i = recyclerView2;
    }

    public static ga a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ga) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hotel4_search_fragment, viewGroup, false, f.a());
    }
}
