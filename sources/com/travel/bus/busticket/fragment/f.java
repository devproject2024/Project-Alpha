package com.travel.bus.busticket.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.play.core.splitcompat.a;
import com.travel.bus.R;
import com.travel.bus.busticket.a.o;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.photos.CJRBusPhoto;
import java.util.ArrayList;
import net.one97.paytm.i.h;

public class f extends h implements com.travel.bus.busticket.f.f {

    /* renamed from: a  reason: collision with root package name */
    private View f22250a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f22251b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f22252c;

    /* renamed from: d  reason: collision with root package name */
    private o f22253d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRBusPhoto> f22254e;

    public final void a(CJRBusSearchItem cJRBusSearchItem) {
    }

    public final void a(TripBusDetail tripBusDetail) {
    }

    public final void a(String str, String str2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getSerializable("extra_photos") != null) {
            this.f22254e = (ArrayList) arguments.getSerializable("extra_photos");
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f22250a = layoutInflater.inflate(R.layout.pre_b_bus_photos, viewGroup, false);
        View view = this.f22250a;
        this.f22251b = (RecyclerView) view.findViewById(R.id.bus_photos);
        this.f22252c = (LottieAnimationView) view.findViewById(R.id.bus_review_loading);
        this.f22251b.setLayoutManager(new LinearLayoutManager(getActivity()));
        LottieAnimationView lottieAnimationView = this.f22252c;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            this.f22251b.setVisibility(0);
        }
        this.f22253d = new o(getContext(), this.f22254e);
        this.f22251b.setAdapter(this.f22253d);
        return this.f22250a;
    }

    public final void a(boolean z) {
        LottieAnimationView lottieAnimationView = this.f22252c;
        if (lottieAnimationView == null) {
            return;
        }
        if (z) {
            lottieAnimationView.setVisibility(0);
        } else {
            lottieAnimationView.setVisibility(8);
        }
    }
}
