package com.travel.flight.flightSRPV2.view.ui.b;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.b.as;
import com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class h extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    private as f24319a;

    /* renamed from: b  reason: collision with root package name */
    private SRPSharedViewModel f24320b;

    /* renamed from: c  reason: collision with root package name */
    private SRPModifyViewModel f24321c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f24322d;

    public final View a(int i2) {
        if (this.f24322d == null) {
            this.f24322d = new HashMap();
        }
        View view = (View) this.f24322d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f24322d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Window window = activity.getWindow();
        k.a((Object) window, "activity!!.window");
        View decorView = window.getDecorView();
        k.a((Object) decorView, "activity!!.window.decorView");
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            k.a();
        }
        decorView.setBackground(androidx.core.content.b.a((Context) activity2, R.color.lyt_passenger_details));
        as a2 = as.a(layoutInflater, viewGroup);
        k.a((Object) a2, "FragmentSrpModifyBinding…flater, container, false)");
        this.f24319a = a2;
        FragmentActivity activity3 = getActivity();
        if (activity3 == null) {
            k.a();
        }
        ai a3 = am.a(activity3).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24320b = (SRPSharedViewModel) a3;
        Fragment fragment = this;
        SRPSharedViewModel sRPSharedViewModel = this.f24320b;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        com.travel.flight.flightticket.d.b bVar = null;
        ai a4 = am.a(fragment, (al.b) new SRPViewModelFactory(sRPSharedViewModel, false, 2, (g) null)).a(SRPModifyViewModel.class);
        k.a((Object) a4, "ViewModelProviders.of(th…ifyViewModel::class.java)");
        this.f24321c = (SRPModifyViewModel) a4;
        as asVar = this.f24319a;
        if (asVar == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel2 = this.f24320b;
        if (sRPSharedViewModel2 == null) {
            k.a("parentViewModel");
        }
        asVar.a(sRPSharedViewModel2);
        as asVar2 = this.f24319a;
        if (asVar2 == null) {
            k.a("dataBinding");
        }
        SRPModifyViewModel sRPModifyViewModel = this.f24321c;
        if (sRPModifyViewModel == null) {
            k.a("viewModel");
        }
        asVar2.a(sRPModifyViewModel);
        as asVar3 = this.f24319a;
        if (asVar3 == null) {
            k.a("dataBinding");
        }
        asVar3.setLifecycleOwner(getViewLifecycleOwner());
        as asVar4 = this.f24319a;
        if (asVar4 == null) {
            k.a("dataBinding");
        }
        View root = asVar4.getRoot();
        k.a((Object) root, "this.dataBinding.root");
        SRPSharedViewModel sRPSharedViewModel3 = this.f24320b;
        if (sRPSharedViewModel3 == null) {
            k.a("parentViewModel");
        }
        CJRFlightSearchInput value = sRPSharedViewModel3.getCopiedSearchInput().getValue();
        if (value != null) {
            bVar = value.getBookingSegment();
        }
        if (bVar != com.travel.flight.flightticket.d.b.Modify) {
            ((ImageView) root.findViewById(R.id.sep_route)).setOnClickListener(new a(this, root));
        }
        as asVar5 = this.f24319a;
        if (asVar5 == null) {
            k.a("dataBinding");
        }
        return asVar5.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        as asVar = this.f24319a;
        if (asVar == null) {
            k.a("dataBinding");
        }
        asVar.o.setImageResource(com.travel.common.R.drawable.travel_res_common_arrow_left);
        as asVar2 = this.f24319a;
        if (asVar2 == null) {
            k.a("dataBinding");
        }
        ImageView imageView = asVar2.o;
        k.a((Object) imageView, "this.dataBinding.journeyModificationArrow");
        imageView.setRotation(90.0f);
        as asVar3 = this.f24319a;
        if (asVar3 == null) {
            k.a("dataBinding");
        }
        asVar3.f23628b.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        as asVar4 = this.f24319a;
        if (asVar4 == null) {
            k.a("dataBinding");
        }
        asVar4.D.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
    }

    public final Animator onCreateAnimator(int i2, boolean z, int i3) {
        Animator loadAnimator = AnimatorInflater.loadAnimator(getActivity(), z ? R.anim.enter_anim_slide_from_top_to_bottom : R.anim.exit_anim_slide_from_bottom_to_top);
        loadAnimator.addListener(new b(this, z));
        k.a((Object) loadAnimator, "anim");
        return loadAnimator;
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f24325a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f24326b;

        b(h hVar, boolean z) {
            this.f24325a = hVar;
            this.f24326b = z;
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f24326b && this.f24325a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f24325a.a(R.id.lyt_parent);
                FragmentActivity activity = this.f24325a.getActivity();
                if (activity == null) {
                    k.a();
                }
                linearLayout.setBackgroundColor(androidx.core.content.b.c(activity, R.color.flight_translucent_black));
            }
        }

        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (!this.f24326b && this.f24325a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f24325a.a(R.id.lyt_parent);
                FragmentActivity activity = this.f24325a.getActivity();
                if (activity == null) {
                    k.a();
                }
                linearLayout.setBackgroundColor(androidx.core.content.b.c(activity, R.color.flight_transparent_bg));
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f24323a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f24324b;

        a(h hVar, View view) {
            this.f24323a = hVar;
            this.f24324b = view;
        }

        public final void onClick(View view) {
            h.a(this.f24323a, this.f24324b);
        }
    }

    public static final /* synthetic */ void a(h hVar, View view) {
        RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.source);
        k.a((Object) roboTextView, "root.source");
        String obj = roboTextView.getText().toString();
        RoboTextView roboTextView2 = (RoboTextView) view.findViewById(R.id.destination);
        k.a((Object) roboTextView2, "root.destination");
        String obj2 = roboTextView2.getText().toString();
        RoboTextView roboTextView3 = (RoboTextView) view.findViewById(R.id.source_city_code);
        k.a((Object) roboTextView3, "root.source_city_code");
        String obj3 = roboTextView3.getText().toString();
        RoboTextView roboTextView4 = (RoboTextView) view.findViewById(R.id.dest_city_code);
        k.a((Object) roboTextView4, "root.dest_city_code");
        String obj4 = roboTextView4.getText().toString();
        if (!p.a(obj, hVar.getResources().getString(R.string.enter_origin_city), true) && !p.a(obj2, hVar.getResources().getString(R.string.enter_destination_city), true)) {
            SRPModifyViewModel sRPModifyViewModel = hVar.f24321c;
            if (sRPModifyViewModel == null) {
                k.a("viewModel");
            }
            sRPModifyViewModel.exchangeSourceAndDestination(obj3, obj4);
            Animation loadAnimation = AnimationUtils.loadAnimation(hVar.getActivity(), R.anim.move_left);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(hVar.getActivity(), R.anim.move_right);
            Animation loadAnimation3 = AnimationUtils.loadAnimation(hVar.getActivity(), R.anim.rotate360);
            k.a((Object) loadAnimation3, "mRotateAnimationful");
            loadAnimation3.setRepeatCount(1);
            ((RoboTextView) view.findViewById(R.id.source)).startAnimation(loadAnimation);
            ((RoboTextView) view.findViewById(R.id.source_city_code)).startAnimation(loadAnimation);
            ((RoboTextView) view.findViewById(R.id.destination)).startAnimation(loadAnimation2);
            ((RoboTextView) view.findViewById(R.id.dest_city_code)).startAnimation(loadAnimation2);
            ((ImageView) view.findViewById(R.id.sep_route)).startAnimation(loadAnimation3);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24322d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
