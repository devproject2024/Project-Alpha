package net.one97.paytm.addmoney.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.autoaddmoney.c.a;

public abstract class g extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f48043a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f48044b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f48045c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f48046d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f48047e;

    /* renamed from: f  reason: collision with root package name */
    public final EditText f48048f;

    /* renamed from: g  reason: collision with root package name */
    public final EditText f48049g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f48050h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f48051i;
    public final ImageView j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final RelativeLayout m;
    public final NestedScrollView n;
    public final RelativeLayout o;
    public final TextView p;
    public final ImageView q;
    public final RecyclerView r;
    public final RoboTextView s;
    public final RoboTextView t;
    public final RoboTextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    protected a z;

    public abstract void a(a aVar);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected g(e eVar, View view, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout2, EditText editText, EditText editText2, EditText editText3, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout3, LinearLayout linearLayout4, RelativeLayout relativeLayout3, NestedScrollView nestedScrollView, RelativeLayout relativeLayout4, TextView textView, ImageView imageView4, RecyclerView recyclerView, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(eVar, view, 0);
        e eVar2 = eVar;
        View view2 = view;
        this.f48043a = linearLayout;
        this.f48044b = relativeLayout;
        this.f48045c = relativeLayout2;
        this.f48046d = linearLayout2;
        this.f48047e = editText;
        this.f48048f = editText2;
        this.f48049g = editText3;
        this.f48050h = imageView;
        this.f48051i = imageView2;
        this.j = imageView3;
        this.k = linearLayout3;
        this.l = linearLayout4;
        this.m = relativeLayout3;
        this.n = nestedScrollView;
        this.o = relativeLayout4;
        this.p = textView;
        this.q = imageView4;
        this.r = recyclerView;
        this.s = roboTextView;
        this.t = roboTextView2;
        this.u = roboTextView3;
        this.v = textView2;
        this.w = textView3;
        this.x = textView4;
        this.y = textView5;
    }

    public static g a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (g) f.a(layoutInflater, R.layout.am_layout_select_payoptions_bottomsheet, viewGroup, false, f.a());
    }
}
