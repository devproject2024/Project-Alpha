package com.travel.flight.flightSRPV2.view.ui.b.b;

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
import com.travel.flight.b.ag;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private ag f24276a;

    /* renamed from: b  reason: collision with root package name */
    private SRPSharedViewModel f24277b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f24278c;

    public final View a(int i2) {
        if (this.f24278c == null) {
            this.f24278c = new HashMap();
        }
        View view = (View) this.f24278c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f24278c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a2 = am.a(activity).a(SRPSharedViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…redViewModel::class.java)");
        this.f24277b = (SRPSharedViewModel) a2;
        ag a3 = ag.a(layoutInflater, viewGroup);
        k.a((Object) a3, "FragmentFlightIrtSortHom…flater, container, false)");
        this.f24276a = a3;
        ag agVar = this.f24276a;
        if (agVar == null) {
            k.a("dataBinding");
        }
        SRPSharedViewModel sRPSharedViewModel = this.f24277b;
        if (sRPSharedViewModel == null) {
            k.a("parentViewModel");
        }
        agVar.a(sRPSharedViewModel);
        ag agVar2 = this.f24276a;
        if (agVar2 == null) {
            k.a("dataBinding");
        }
        agVar2.setLifecycleOwner(getViewLifecycleOwner());
        ag agVar3 = this.f24276a;
        if (agVar3 == null) {
            k.a("dataBinding");
        }
        return agVar3.getRoot();
    }

    public final Animator onCreateAnimator(int i2, boolean z, int i3) {
        Animator loadAnimator = AnimatorInflater.loadAnimator(getActivity(), z ? R.anim.enter_anim_slide_from_bottom_to_top : R.anim.exit_anim_slide_from_top_to_bottom);
        loadAnimator.addListener(new C0462a(this, z));
        k.a((Object) loadAnimator, "anim");
        return loadAnimator;
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.b.a$a  reason: collision with other inner class name */
    public static final class C0462a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24279a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f24280b;

        C0462a(a aVar, boolean z) {
            this.f24279a = aVar;
            this.f24280b = z;
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f24280b && this.f24279a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f24279a.a(R.id.lyt_background);
                FragmentActivity activity = this.f24279a.getActivity();
                if (activity == null) {
                    k.a();
                }
                linearLayout.setBackgroundColor(b.c(activity, R.color.flight_translucent_black));
            }
        }

        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (!this.f24280b && this.f24279a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f24279a.a(R.id.lyt_background);
                FragmentActivity activity = this.f24279a.getActivity();
                if (activity == null) {
                    k.a();
                }
                linearLayout.setBackgroundColor(b.c(activity, R.color.flight_transparent_bg));
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24278c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
