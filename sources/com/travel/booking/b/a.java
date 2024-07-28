package com.travel.booking.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.travel.booking.datamodel.CJRTravelBookingData;
import com.travel.c.k;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.i.h;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final C0425a f21468a = new C0425a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private k f21469b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.booking.e.a f21470c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f21471d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f21472e;

    static final class b<T> implements z<List<? extends CJRTravelBookingData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21473a;

        b(a aVar) {
            this.f21473a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRTravelBookingData cJRTravelBookingData;
            List list = (List) obj;
            if ((list != null ? list.size() : 0) > this.f21473a.f21471d) {
                if (list == null) {
                    kotlin.g.b.k.a();
                }
                cJRTravelBookingData = (CJRTravelBookingData) list.get(this.f21473a.f21471d);
            } else {
                cJRTravelBookingData = null;
            }
            a.b(this.f21473a).a(cJRTravelBookingData);
        }
    }

    public static final /* synthetic */ k b(a aVar) {
        k kVar = aVar.f21469b;
        if (kVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return kVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        k a2 = k.a(getLayoutInflater(), viewGroup);
        kotlin.g.b.k.a((Object) a2, "FragmentTravelBookingLis…flater, container, false)");
        this.f21469b = a2;
        Bundle arguments = getArguments();
        int i2 = 0;
        if (arguments != null) {
            i2 = arguments.getInt("ARG_TRIP_LIST_INDEX", 0);
        }
        this.f21471d = i2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        ai a3 = am.a(activity).a(com.travel.booking.e.a.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(ac…istViewModel::class.java)");
        this.f21470c = (com.travel.booking.e.a) a3;
        com.travel.booking.e.a aVar = this.f21470c;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar.b().observe(this, new b(this));
        k kVar = this.f21469b;
        if (kVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        com.travel.booking.e.a aVar2 = this.f21470c;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        kVar.a(aVar2);
        k kVar2 = this.f21469b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return kVar2.getRoot();
    }

    /* renamed from: com.travel.booking.b.a$a  reason: collision with other inner class name */
    public static final class C0425a {
        private C0425a() {
        }

        public /* synthetic */ C0425a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f21472e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
