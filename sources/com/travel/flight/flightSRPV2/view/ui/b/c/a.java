package com.travel.flight.flightSRPV2.view.ui.b.c;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.travel.flight.R;
import com.travel.flight.b.ak;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private ak f24296a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f24297b;

    public final View a(int i2) {
        if (this.f24297b == null) {
            this.f24297b = new HashMap();
        }
        View view = (View) this.f24297b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f24297b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ak a2 = ak.a(getLayoutInflater(), viewGroup);
        k.a((Object) a2, "FragmentFlightOneWaySort…flater, container, false)");
        this.f24296a = a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…redViewModel::class.java)");
        SRPSharedViewModel sRPSharedViewModel = (SRPSharedViewModel) a3;
        ak akVar = this.f24296a;
        if (akVar == null) {
            k.a("dataBinding");
        }
        akVar.a(sRPSharedViewModel);
        ak akVar2 = this.f24296a;
        if (akVar2 == null) {
            k.a("dataBinding");
        }
        akVar2.setLifecycleOwner(getViewLifecycleOwner());
        ak akVar3 = this.f24296a;
        if (akVar3 == null) {
            k.a("dataBinding");
        }
        return akVar3.getRoot();
    }

    public final Animator onCreateAnimator(int i2, boolean z, int i3) {
        Animator loadAnimator = AnimatorInflater.loadAnimator(getActivity(), z ? R.anim.enter_anim_slide_from_bottom_to_top : R.anim.exit_anim_slide_from_top_to_bottom);
        loadAnimator.addListener(new C0465a(this, z));
        k.a((Object) loadAnimator, "anim");
        return loadAnimator;
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.c.a$a  reason: collision with other inner class name */
    public static final class C0465a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f24299b;

        C0465a(a aVar, boolean z) {
            this.f24298a = aVar;
            this.f24299b = z;
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f24299b && this.f24298a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f24298a.a(R.id.lyt_background);
                FragmentActivity activity = this.f24298a.getActivity();
                if (activity == null) {
                    k.a();
                }
                linearLayout.setBackgroundColor(b.c(activity, R.color.flight_translucent_black));
            }
        }

        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (!this.f24299b && this.f24298a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f24298a.a(R.id.lyt_background);
                FragmentActivity activity = this.f24298a.getActivity();
                if (activity == null) {
                    k.a();
                }
                linearLayout.setBackgroundColor(b.c(activity, R.color.flight_transparent_bg));
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24297b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
