package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class as extends ViewDataBinding {
    public final RoboTextView A;
    public final RoboTextView B;
    public final RoboTextView C;
    public final ImageView D;
    public final View E;
    public final RoboTextView F;
    public final LinearLayout G;
    public final RoboTextView H;
    public final RoboTextView I;
    public final RoboTextView J;
    protected SRPSharedViewModel K;
    protected SRPModifyViewModel L;

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f23627a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23628b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23629c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23630d;

    /* renamed from: e  reason: collision with root package name */
    public final RoboTextView f23631e;

    /* renamed from: f  reason: collision with root package name */
    public final RoboTextView f23632f;

    /* renamed from: g  reason: collision with root package name */
    public final RoboTextView f23633g;

    /* renamed from: h  reason: collision with root package name */
    public final RoboTextView f23634h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f23635i;
    public final RoboTextView j;
    public final RoboTextView k;
    public final RoboTextView l;
    public final CheckBox m;
    public final ImageView n;
    public final ImageView o;
    public final RoboTextView p;
    public final RoboTextView q;
    public final RoboTextView r;
    public final RoboTextView s;
    public final LinearLayout t;
    public final LinearLayout u;
    public final RoboTextView v;
    public final Button w;
    public final LinearLayout x;
    public final RoboTextView y;
    public final RelativeLayout z;

    public abstract void a(SRPModifyViewModel sRPModifyViewModel);

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected as(Object obj, View view, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, LinearLayout linearLayout3, RoboTextView roboTextView6, RoboTextView roboTextView7, RoboTextView roboTextView8, CheckBox checkBox, ImageView imageView2, ImageView imageView3, RoboTextView roboTextView9, RoboTextView roboTextView10, RoboTextView roboTextView11, RoboTextView roboTextView12, LinearLayout linearLayout4, LinearLayout linearLayout5, RoboTextView roboTextView13, Button button, LinearLayout linearLayout6, RoboTextView roboTextView14, RelativeLayout relativeLayout, RoboTextView roboTextView15, RoboTextView roboTextView16, RoboTextView roboTextView17, ImageView imageView4, View view2, RoboTextView roboTextView18, LinearLayout linearLayout7, RoboTextView roboTextView19, RoboTextView roboTextView20, RoboTextView roboTextView21) {
        super(obj, view, 1);
        Object obj2 = obj;
        View view3 = view;
        this.f23627a = linearLayout;
        this.f23628b = imageView;
        this.f23629c = linearLayout2;
        this.f23630d = roboTextView;
        this.f23631e = roboTextView2;
        this.f23632f = roboTextView3;
        this.f23633g = roboTextView4;
        this.f23634h = roboTextView5;
        this.f23635i = linearLayout3;
        this.j = roboTextView6;
        this.k = roboTextView7;
        this.l = roboTextView8;
        this.m = checkBox;
        this.n = imageView2;
        this.o = imageView3;
        this.p = roboTextView9;
        this.q = roboTextView10;
        this.r = roboTextView11;
        this.s = roboTextView12;
        this.t = linearLayout4;
        this.u = linearLayout5;
        this.v = roboTextView13;
        this.w = button;
        this.x = linearLayout6;
        this.y = roboTextView14;
        this.z = relativeLayout;
        this.A = roboTextView15;
        this.B = roboTextView16;
        this.C = roboTextView17;
        this.D = imageView4;
        this.E = view2;
        this.F = roboTextView18;
        this.G = linearLayout7;
        this.H = roboTextView19;
        this.I = roboTextView20;
        this.J = roboTextView21;
    }

    public static as a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (as) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_srp_modify, viewGroup, false, f.a());
    }
}
