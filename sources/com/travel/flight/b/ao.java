package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class ao extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoboTextView f23609a;

    /* renamed from: b  reason: collision with root package name */
    public final RoboTextView f23610b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23611c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23612d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f23613e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f23614f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f23615g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f23616h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f23617i;
    public final RoboTextView j;
    public final LinearLayout k;
    public final RelativeLayout l;
    public final RoboTextView m;
    public final RoboTextView n;
    public final RoboTextView o;
    public final View p;
    public final View q;
    public final View r;
    protected SRPSharedViewModel s;
    protected IRTSplitViewModel t;
    protected String u;
    protected String v;

    public abstract void a(IRTSplitViewModel iRTSplitViewModel);

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    public abstract void a(String str);

    public abstract void b(String str);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ao(Object obj, View view, RoboTextView roboTextView, RoboTextView roboTextView2, RelativeLayout relativeLayout, RoboTextView roboTextView3, RecyclerView recyclerView, RecyclerView recyclerView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RoboTextView roboTextView4, LinearLayout linearLayout4, RelativeLayout relativeLayout2, RoboTextView roboTextView5, RoboTextView roboTextView6, RoboTextView roboTextView7, View view2, View view3, View view4) {
        super(obj, view, 2);
        Object obj2 = obj;
        View view5 = view;
        this.f23609a = roboTextView;
        this.f23610b = roboTextView2;
        this.f23611c = relativeLayout;
        this.f23612d = roboTextView3;
        this.f23613e = recyclerView;
        this.f23614f = recyclerView2;
        this.f23615g = linearLayout;
        this.f23616h = linearLayout2;
        this.f23617i = linearLayout3;
        this.j = roboTextView4;
        this.k = linearLayout4;
        this.l = relativeLayout2;
        this.m = roboTextView5;
        this.n = roboTextView6;
        this.o = roboTextView7;
        this.p = view2;
        this.q = view3;
        this.r = view4;
    }

    public static ao a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ao) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_irt_split_view, viewGroup, false, f.a());
    }
}
