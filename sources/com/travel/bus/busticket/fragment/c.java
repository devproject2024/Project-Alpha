package com.travel.bus.busticket.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.bus.busticket.a.g;
import com.travel.bus.busticket.a.k;
import com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity;
import com.travel.bus.busticket.d.b;
import com.travel.bus.busticket.f.e;
import com.travel.bus.busticket.f.f;
import com.travel.bus.busticket.g.a;
import com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import net.one97.paytm.i.h;

public class c extends h implements e, f {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f22226a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f22227b;

    /* renamed from: c  reason: collision with root package name */
    public RoboTextView f22228c;

    /* renamed from: d  reason: collision with root package name */
    public k f22229d;

    /* renamed from: e  reason: collision with root package name */
    private g f22230e;

    /* renamed from: f  reason: collision with root package name */
    private k f22231f;

    /* renamed from: g  reason: collision with root package name */
    private CJRBusSearchItem f22232g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRBusSearchCancellationPolicy> f22233h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<CJRBusCancellationPolicy> f22234i;
    private ArrayList<TripBusDetailsItem> j;
    private TripBusDetail k;
    private String l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private a q;
    private View r;
    private String s = "";
    private b t;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.getSerializable("intent_extra_bus_search_result_item") != null) {
                this.f22232g = (CJRBusSearchItem) arguments.getSerializable("intent_extra_bus_search_result_item");
            }
            if (!(arguments == null || arguments.getString("intent_extra_bus_search") == null)) {
                this.s = arguments.getString("intent_extra_bus_search");
            }
        }
        this.t = new b(getContext(), this);
        this.q = new a();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.r = layoutInflater.inflate(R.layout.pre_b_bus_cancellation_fragment, viewGroup, false);
        View view = this.r;
        this.p = (ImageView) view.findViewById(R.id.error_image_view);
        this.m = (LinearLayout) view.findViewById(R.id.bus_error_container);
        this.n = (TextView) view.findViewById(R.id.bus_seat_error_title);
        this.o = (TextView) view.findViewById(R.id.bus_seat_error_message);
        this.f22227b = (RelativeLayout) view.findViewById(R.id.lyt_progress_bar);
        this.f22226a = (RecyclerView) view.findViewById(R.id.cancellation_recyclerview);
        this.f22228c = (RoboTextView) view.findViewById(R.id.cancellation_terms);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(1);
        this.f22226a.setLayoutManager(linearLayoutManager);
        a();
        b();
        return this.r;
    }

    private void a() {
        CJRBusSearchItem cJRBusSearchItem = this.f22232g;
        if (cJRBusSearchItem == null) {
            return;
        }
        if (cJRBusSearchItem.getCancellationPolicy() == null || this.f22232g.getCancellationPolicy().size() <= 0) {
            this.f22233h = a.a(this.f22232g);
        } else {
            this.f22234i = this.f22232g.getCancellationPolicy();
        }
    }

    private void a(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        c();
        if (iJRPaytmDataModel instanceof TripBusDetail) {
            TripBusDetail tripBusDetail = (TripBusDetail) iJRPaytmDataModel;
            if (tripBusDetail != null && tripBusDetail.getBody() != null && tripBusDetail.getBody().size() > 0) {
                this.k = tripBusDetail;
                this.j = this.k.getBody();
                this.l = com.paytm.utility.b.a(a.a(this.j), "###,###,###.##");
                if (getActivity() != null) {
                    ArrayList<CJRBusCancellationPolicy> arrayList = this.f22234i;
                    if (arrayList == null || arrayList.size() <= 0) {
                        ArrayList<CJRBusSearchCancellationPolicy> arrayList2 = this.f22233h;
                        if (arrayList2 != null && arrayList2.size() > 0 && (str = this.l) != null && !TextUtils.isEmpty(str)) {
                            this.f22230e = new g(getContext(), this.f22233h, a.a(this.j));
                            this.f22226a.setAdapter(this.f22230e);
                            this.f22228c.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    this.f22231f = new k(this.f22234i);
                    this.f22226a.setAdapter(this.f22231f);
                    this.f22228c.setVisibility(0);
                }
            } else if (tripBusDetail == null || TextUtils.isEmpty((String) tripBusDetail.getError())) {
                b(getResources().getString(R.string.error), getResources().getString(R.string.error));
            } else {
                b(getResources().getString(R.string.error), (String) tripBusDetail.getError());
            }
        }
    }

    private void b(String str, String str2) {
        if (!isRemoving() && getActivity() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(str).setMessage(str2).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), $$Lambda$c$AM3E5Wf_qKujX2bxn0vcPnCY68.INSTANCE);
            builder.show();
        }
    }

    private void b() {
        RelativeLayout relativeLayout = this.f22227b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private void c() {
        RelativeLayout relativeLayout = this.f22227b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public final void a(boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    public final void a(TripBusDetail tripBusDetail) {
        if (getActivity() != null && isAdded()) {
            a();
            a((IJRPaytmDataModel) tripBusDetail);
        }
    }

    public final void a(CJRBusSearchItem cJRBusSearchItem) {
        this.f22232g = cJRBusSearchItem;
    }

    public final void a(String str, String str2) {
        if (str == null || !str.toLowerCase().contains("housefull")) {
            this.m.setVisibility(0);
            this.n.setText(getString(R.string.bus_error_title_revamp));
            this.o.setText(getString(R.string.bus_cancellation_message));
            ResourceUtils.loadBusImagesFromCDN(this.p, "no_routes_image_revamp.png", false, false, n.a.V1);
            return;
        }
        this.m.setVisibility(0);
        this.n.setText(str);
        this.o.setText(str2);
        ResourceUtils.loadBusImagesFromCDN(this.p, "sold_out_image_revamp.png", false, false, n.a.V1);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public final void a(CJRBusBPDPCancellationPolicyItem cJRBusBPDPCancellationPolicyItem) {
        if (getActivity() != null) {
            this.f22227b.setVisibility(4);
            ((AJRBusSelectSeatsActivity) getActivity()).a(cJRBusBPDPCancellationPolicyItem);
        }
    }
}
