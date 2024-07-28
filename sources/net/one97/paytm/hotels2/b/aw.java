package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;

public abstract class aw extends ViewDataBinding {
    protected ReviewViewModel A;

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f29202a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29203b;

    /* renamed from: c  reason: collision with root package name */
    public final View f29204c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f29205d;

    /* renamed from: e  reason: collision with root package name */
    public final RoboTextView f29206e;

    /* renamed from: f  reason: collision with root package name */
    public final RoboTextView f29207f;

    /* renamed from: g  reason: collision with root package name */
    public final EditText f29208g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f29209h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f29210i;
    public final RelativeLayout j;
    public final RecyclerView k;
    public final RelativeLayout l;
    public final ImageView m;
    public final RoboTextView n;
    public final LinearLayout o;
    public final RelativeLayout p;
    public final RelativeLayout q;
    public final View r;
    public final RoboTextView s;
    public final RoboTextView t;
    public final ImageView u;
    public final View v;
    public final Toolbar w;
    public final LottieAnimationView x;
    public final View y;
    public final RoboTextView z;

    public abstract void a(ReviewViewModel reviewViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected aw(Object obj, View view, RelativeLayout relativeLayout, ImageView imageView, View view2, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, EditText editText, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, RelativeLayout relativeLayout4, ImageView imageView2, RoboTextView roboTextView4, LinearLayout linearLayout2, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, View view3, RoboTextView roboTextView5, RoboTextView roboTextView6, ImageView imageView3, View view4, Toolbar toolbar, LottieAnimationView lottieAnimationView, View view5, RoboTextView roboTextView7) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view6 = view;
        this.f29202a = relativeLayout;
        this.f29203b = imageView;
        this.f29204c = view2;
        this.f29205d = roboTextView;
        this.f29206e = roboTextView2;
        this.f29207f = roboTextView3;
        this.f29208g = editText;
        this.f29209h = linearLayout;
        this.f29210i = relativeLayout2;
        this.j = relativeLayout3;
        this.k = recyclerView;
        this.l = relativeLayout4;
        this.m = imageView2;
        this.n = roboTextView4;
        this.o = linearLayout2;
        this.p = relativeLayout5;
        this.q = relativeLayout6;
        this.r = view3;
        this.s = roboTextView5;
        this.t = roboTextView6;
        this.u = imageView3;
        this.v = view4;
        this.w = toolbar;
        this.x = lottieAnimationView;
        this.y = view5;
        this.z = roboTextView7;
    }

    public static aw a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (aw) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_fragment_hotel_offers, viewGroup, false, f.a());
    }
}
