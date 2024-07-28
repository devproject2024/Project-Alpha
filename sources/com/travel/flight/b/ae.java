package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;

public abstract class ae extends ViewDataBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final View M;
    public final View N;
    public final View O;
    public final View P;
    public final View Q;
    public final View R;
    public final View S;
    protected FlightFilterViewModel T;
    protected FlightFilterHomeViewModel U;

    /* renamed from: a  reason: collision with root package name */
    public final CheckBox f23563a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f23564b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23565c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23566d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f23567e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f23568f;

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f23569g;

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f23570h;

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f23571i;
    public final LinearLayout j;
    public final ConstraintLayout k;
    public final FrameLayout l;
    public final RadioButton m;
    public final RadioButton n;
    public final RadioButton o;
    public final RecyclerView p;
    public final RoboTextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public abstract void a(FlightFilterHomeViewModel flightFilterHomeViewModel);

    public abstract void a(FlightFilterViewModel flightFilterViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ae(Object obj, View view, CheckBox checkBox, EditText editText, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, FrameLayout frameLayout4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RecyclerView recyclerView, RoboTextView roboTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        super(obj, view, 14);
        Object obj2 = obj;
        View view9 = view;
        this.f23563a = checkBox;
        this.f23564b = editText;
        this.f23565c = imageView;
        this.f23566d = imageView2;
        this.f23567e = constraintLayout;
        this.f23568f = frameLayout;
        this.f23569g = frameLayout2;
        this.f23570h = frameLayout3;
        this.f23571i = constraintLayout2;
        this.j = linearLayout;
        this.k = constraintLayout3;
        this.l = frameLayout4;
        this.m = radioButton;
        this.n = radioButton2;
        this.o = radioButton3;
        this.p = recyclerView;
        this.q = roboTextView;
        this.r = textView;
        this.s = textView2;
        this.t = textView3;
        this.u = textView4;
        this.v = textView5;
        this.w = textView6;
        this.x = textView7;
        this.y = textView8;
        this.z = textView9;
        this.A = textView10;
        this.B = textView11;
        this.C = textView12;
        this.D = textView13;
        this.E = textView14;
        this.F = textView15;
        this.G = textView16;
        this.H = textView17;
        this.I = textView18;
        this.J = textView19;
        this.K = textView20;
        this.L = textView21;
        this.M = view2;
        this.N = view3;
        this.O = view4;
        this.P = view5;
        this.Q = view6;
        this.R = view7;
        this.S = view8;
    }

    public static ae a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ae) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_flight_filter_page, viewGroup, false, f.a());
    }
}
