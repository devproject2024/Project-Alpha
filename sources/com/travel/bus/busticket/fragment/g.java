package com.travel.bus.busticket.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.r;
import com.travel.bus.busticket.b.b;
import com.travel.bus.busticket.c.a;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.c;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class g extends h implements a.C0438a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f22255a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f22256b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public r f22257c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRBusSearchItem f22258d;

    /* renamed from: e  reason: collision with root package name */
    private String f22259e = "";

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, CJRBusSearchAmenitiesInfo> f22260f;

    /* renamed from: g  reason: collision with root package name */
    private b f22261g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public com.travel.bus.busticket.g.b f22262h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f22263i;
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    private RecyclerView.l n = new RecyclerView.l() {
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i3 > 0) {
                g gVar = g.this;
                int unused = gVar.l = gVar.f22263i.getChildCount();
                g gVar2 = g.this;
                int unused2 = gVar2.m = gVar2.f22263i.getItemCount();
                g gVar3 = g.this;
                int unused3 = gVar3.k = gVar3.f22263i.findFirstVisibleItemPosition();
                if (!g.this.j && g.this.l + g.this.k >= g.this.m && g.this.f22257c.b() < g.this.f22257c.f21747b.getBusRating().getReview_count()) {
                    boolean unused4 = g.this.j = true;
                    r f2 = g.this.f22257c;
                    r.a aVar = new r.a(f2, (byte) 0);
                    aVar.f21752a = "reviewloading";
                    f2.f21748c.add(aVar);
                    f2.notifyDataSetChanged();
                    g.this.f22262h.a(g.this.f22257c.b(), g.this.f22258d);
                }
            }
        }
    };

    public g(String str) {
        this.f22259e = str;
    }

    public g() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
        if (context instanceof b) {
            this.f22261g = (b) context;
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getSerializable("intent_extra_bus_search_result_item") == null)) {
            this.f22258d = (CJRBusSearchItem) arguments.getSerializable("intent_extra_bus_search_result_item");
        }
        if (!(arguments == null || arguments.getSerializable("amenity") == null)) {
            this.f22260f = (HashMap) arguments.getSerializable("amenity");
        }
        this.f22262h = new com.travel.bus.busticket.g.b(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_b_bus_reviews_fragment, viewGroup, false);
        this.f22255a = (RecyclerView) inflate.findViewById(R.id.review_recyclerview);
        this.f22256b = (LottieAnimationView) inflate.findViewById(R.id.bus_review_loading);
        this.f22263i = new LinearLayoutManager(getActivity());
        this.f22263i.setOrientation(1);
        this.f22255a.setLayoutManager(this.f22263i);
        this.f22257c = new r();
        this.f22255a.setAdapter(this.f22257c);
        this.f22255a.addOnScrollListener(this.n);
        com.travel.bus.busticket.g.b bVar = this.f22262h;
        CJRBusSearchItem cJRBusSearchItem = this.f22258d;
        String str = this.f22259e;
        bVar.f22358d = cJRBusSearchItem;
        bVar.f22355a = str;
        bVar.a(1, cJRBusSearchItem);
        return inflate;
    }

    public final void a(boolean z) {
        LottieAnimationView lottieAnimationView;
        if (getActivity() != null && !getActivity().isFinishing() && (lottieAnimationView = this.f22256b) != null) {
            if (z) {
                lottieAnimationView.setVisibility(0);
            } else {
                lottieAnimationView.setVisibility(8);
            }
        }
    }

    public final void b(boolean z) {
        RecyclerView recyclerView = this.f22255a;
        if (recyclerView == null) {
            return;
        }
        if (z) {
            recyclerView.setVisibility(0);
        } else {
            recyclerView.setVisibility(8);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.f22257c = new r(getActivity(), cVar, this.f22258d, this.f22260f, this.f22261g);
            this.f22255a.setAdapter(this.f22257c);
        }
    }

    public final void b(c cVar) {
        this.j = false;
        r rVar = this.f22257c;
        if (rVar != null && cVar != null) {
            rVar.f21746a = cVar;
            rVar.f21748c.clear();
            rVar.a();
            rVar.notifyDataSetChanged();
        }
    }

    public final void a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getActivity().getResources().getString(R.string.no_connection));
        builder.setMessage(getActivity().getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getActivity().getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                g.this.a(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        this.f22262h.a(1, this.f22258d);
    }

    public void setUserVisibleHint(boolean z) {
        com.travel.bus.busticket.g.b bVar;
        super.setUserVisibleHint(z);
        if (z && (bVar = this.f22262h) != null && bVar.f22357c.booleanValue()) {
            com.travel.bus.busticket.g.b bVar2 = this.f22262h;
            bVar2.a(bVar2.f22356b, this.f22258d, true);
        }
    }

    public final void a(int i2, NetworkCustomError networkCustomError) {
        if (networkCustomError != null && networkCustomError.getAlertMessage() != null && getActivity() != null && !getActivity().isFinishing()) {
            com.travel.bus.a.a();
            com.travel.g.a b2 = com.travel.bus.a.b();
            String alertMessage = networkCustomError.getAlertMessage();
            Context applicationContext = getActivity().getApplicationContext();
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_review");
            hashMap.put("event_action", "error_popup");
            hashMap.put("event_label", alertMessage);
            hashMap.put("event_label2", Integer.valueOf(i2));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-review");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n(applicationContext));
            com.travel.bus.a.a();
            b2.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, com.travel.bus.a.b().D());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        a(false);
        if (this.f22260f != null) {
            this.f22260f = null;
        }
    }
}
