package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.travelpass.R;
import net.one97.travelpass.b.bc;
import net.one97.travelpass.b.e;
import net.one97.travelpass.b.y;
import net.one97.travelpass.e.b;
import net.one97.travelpass.e.d;
import net.one97.travelpass.e.g;
import net.one97.travelpass.model.InternalOfferData;
import net.one97.travelpass.model.PartnersOfferData;
import net.one97.travelpass.model.TPAboutResponse;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.ui.TravelPassDetailsActivity;
import net.one97.travelpass.ui.c.j;

public final class h extends g implements com.one97.travelpass.a.c {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.travelpass.a.c f30721a;

    /* renamed from: b  reason: collision with root package name */
    TPAboutResponse f30722b;

    /* renamed from: c  reason: collision with root package name */
    private e f30723c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.travelpass.g.a f30724d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<j> f30725e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private g f30726f = new g();

    /* renamed from: g  reason: collision with root package name */
    private HashMap f30727g;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f30727g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    static final class c<T> implements z<TPAboutResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f30730a;

        c(h hVar) {
            this.f30730a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String status;
            TPAboutResponse tPAboutResponse = (TPAboutResponse) obj;
            if (tPAboutResponse != null) {
                TPAboutResponse.TPResponseBody tpAboutData = tPAboutResponse.getTpAboutData();
                Boolean bool = null;
                if ((tpAboutData != null ? tpAboutData.getStatus() : null) != null) {
                    TPAboutResponse.TPResponseBody tpAboutData2 = tPAboutResponse.getTpAboutData();
                    if (!(tpAboutData2 == null || (status = tpAboutData2.getStatus()) == null)) {
                        bool = Boolean.valueOf(p.a(status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true));
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        g.handleErrorCode$default(this.f30730a, (Integer) null, tPAboutResponse, (NetworkCustomError) null, 5, (Object) null);
                    }
                }
                h hVar = this.f30730a;
                hVar.f30722b = tPAboutResponse;
                h.a(hVar);
            }
            this.f30730a.c();
        }
    }

    static final class d<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f30731a;

        d(h hVar) {
            this.f30731a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            this.f30731a.c();
            h hVar = this.f30731a;
            NetworkCustomError networkCustomError = null;
            if (aVar != null) {
                num = Integer.valueOf(aVar.f30319a);
            } else {
                num = null;
            }
            IJRPaytmDataModel iJRPaytmDataModel = aVar != null ? aVar.f30320b : null;
            if (aVar != null) {
                networkCustomError = aVar.f30321c;
            }
            o<String, String> processErrorState = hVar.processErrorState(num, iJRPaytmDataModel, networkCustomError);
            h hVar2 = this.f30731a;
            k.c(processErrorState, "errorDetails");
            hVar2.a(processErrorState.getFirst(), processErrorState.getSecond());
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        q.a(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f30723c = (e) f.a(layoutInflater, R.layout.fragment_travel_pass_details, viewGroup, false);
        e eVar = this.f30723c;
        if (eVar == null) {
            k.a();
        }
        return eVar.getRoot();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f30728a;

        a(h hVar) {
            this.f30728a = hVar;
        }

        public final void onClick(View view) {
            if (this.f30728a.getContext() != null) {
                b.a aVar = net.one97.travelpass.e.b.f30322a;
                Context context = this.f30728a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                k.c(context, "context");
                b.a.a(context, net.one97.travelpass.e.b.f30330i, net.one97.travelpass.e.b.p, (String) null, (String) null, (String) null, (String) null, net.one97.travelpass.e.b.f30325d, (String) null, 376);
            }
            this.f30728a.b();
        }
    }

    public final void a() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            g();
            f();
            d();
            return;
        }
        e();
    }

    private void d() {
        net.one97.travelpass.g.a aVar = this.f30724d;
        if (aVar != null) {
            aVar.c(getContext());
        }
    }

    public final void b() {
        Intent intent = new Intent(getActivity(), TravelPassDetailsActivity.class);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final void onItemClickedItem(j jVar, Integer num, Integer num2) {
        int a2;
        if (jVar != null) {
            boolean z = false;
            ArrayList<TravelPassMetaData.TncData> arrayList = null;
            if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS_ITEM) {
                IJRPaytmDataModel b2 = jVar.b();
                if (!(b2 instanceof PartnersOfferData)) {
                    b2 = null;
                }
                PartnersOfferData partnersOfferData = (PartnersOfferData) b2;
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                int c2 = net.one97.travelpass.ui.a.c();
                if (num2 != null && num2.intValue() == c2) {
                    d.a aVar2 = net.one97.travelpass.e.d.f30331a;
                    d.a.a("custom-event", "/travel-pass/about", "travel_pass_about", "partneroffer_scrolled", (String) null, (String) null, 112);
                }
                net.one97.travelpass.ui.a aVar3 = net.one97.travelpass.ui.a.f30575a;
                int b3 = net.one97.travelpass.ui.a.b();
                if (num2 != null && num2.intValue() == b3) {
                    if (!(getContext() == null || partnersOfferData == null)) {
                        b.a aVar4 = net.one97.travelpass.e.b.f30322a;
                        Context context = getContext();
                        if (context == null) {
                            k.a();
                        }
                        k.a((Object) context, "context!!");
                        String partnerOfferId = partnersOfferData.getPartnerOfferId();
                        k.a((Object) partnerOfferId, "partnerOfferData.partnerOfferId");
                        k.c(context, "context");
                        k.c(partnerOfferId, "offerId");
                        b.a.a(context, net.one97.travelpass.e.b.f30330i, net.one97.travelpass.e.b.o, partnerOfferId, (String) null, (String) null, (String) null, net.one97.travelpass.e.b.f30325d, (String) null, 368);
                    }
                    IJRPaytmDataModel b4 = jVar != null ? jVar.b() : null;
                    if (!(b4 instanceof PartnersOfferData)) {
                        b4 = null;
                    }
                    PartnersOfferData partnersOfferData2 = (PartnersOfferData) b4;
                    TPAboutResponse tPAboutResponse = this.f30722b;
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    if (tPAboutResponse != null && partnersOfferData2 != null) {
                        TPAboutResponse.TPResponseBody tpAboutData = tPAboutResponse.getTpAboutData();
                        if (tpAboutData != null) {
                            arrayList = tpAboutData.getTnc();
                        }
                        Collection collection = arrayList;
                        if (!(collection == null || collection.isEmpty()) && (a2 = kotlin.a.k.a(arrayList)) >= 0) {
                            int i2 = 0;
                            while (true) {
                                TravelPassMetaData.TncData tncData = arrayList.get(i2);
                                k.a((Object) tncData, "offersTncList.get(i)");
                                TravelPassMetaData.TncData tncData2 = tncData;
                                if (tncData2 == null || !tncData2.getTncId().equals(partnersOfferData2.getTncId())) {
                                    if (i2 == a2) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    arrayList2 = tncData2.getTncContent();
                                    break;
                                }
                            }
                        }
                    }
                    Collection collection2 = arrayList2;
                    if (collection2 == null || collection2.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        c cVar = new c();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("dataList", arrayList2);
                        cVar.setArguments(bundle);
                        if (getActivity() != null) {
                            FragmentActivity activity = getActivity();
                            if (activity == null) {
                                k.a();
                            }
                            k.a((Object) activity, "activity!!");
                            cVar.show(activity.getSupportFragmentManager(), cVar.getTag());
                        }
                    }
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_KNOW_MORE_ITEMS) {
                net.one97.travelpass.ui.a aVar5 = net.one97.travelpass.ui.a.f30575a;
                int d2 = net.one97.travelpass.ui.a.d();
                if (num2 != null && num2.intValue() == d2) {
                    b();
                }
            } else if (jVar.c() == net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS_ITEM) {
                IJRPaytmDataModel b5 = jVar.b();
                if (!(b5 instanceof InternalOfferData)) {
                    b5 = null;
                }
                InternalOfferData internalOfferData = (InternalOfferData) b5;
                if (!(getContext() == null || internalOfferData == null)) {
                    b.a aVar6 = net.one97.travelpass.e.b.f30322a;
                    Context context2 = getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    k.a((Object) context2, "context!!");
                    String internalOfferId = internalOfferData.getInternalOfferId();
                    k.a((Object) internalOfferId, "internalOfferData.internalOfferId");
                    b.a.a(context2, internalOfferId);
                }
                d.a aVar7 = net.one97.travelpass.e.d.f30331a;
                d.a.a("custom-event", "/travel-pass/about", "travel_pass_about", "internaloffer_clicked", (String) null, (String) null, 112);
                IJRPaytmDataModel b6 = jVar != null ? jVar.b() : null;
                if (!(b6 instanceof InternalOfferData)) {
                    b6 = null;
                }
                ArrayList<String> a3 = g.a((InternalOfferData) b6, this.f30722b);
                Collection collection3 = a3;
                if (collection3 == null || collection3.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    c cVar2 = new c();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("dataList", a3);
                    cVar2.setArguments(bundle2);
                    if (getActivity() != null) {
                        FragmentActivity activity2 = getActivity();
                        if (activity2 == null) {
                            k.a();
                        }
                        k.a((Object) activity2, "activity!!");
                        cVar2.show(activity2.getSupportFragmentManager(), cVar2.getTag());
                    }
                }
            }
        }
    }

    private void e() {
        String string = getString(R.string.tp_cant_connect);
        k.a((Object) string, "getString(R.string.tp_cant_connect)");
        String string2 = getString(R.string.tp_check_your_network);
        k.a((Object) string2, "getString(R.string.tp_check_your_network)");
        a(string, string2);
    }

    private void f() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        e eVar = this.f30723c;
        if (!(eVar == null || (relativeLayout = eVar.f30230c) == null)) {
            relativeLayout.setVisibility(0);
        }
        e eVar2 = this.f30723c;
        if (eVar2 != null && (progressBar = eVar2.f30231d) != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void c() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        e eVar = this.f30723c;
        if (!(eVar == null || (relativeLayout = eVar.f30230c) == null)) {
            relativeLayout.setVisibility(8);
        }
        e eVar2 = this.f30723c;
        if (eVar2 != null && (progressBar = eVar2.f30231d) != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void a(String str, String str2) {
        y yVar;
        Button button;
        y yVar2;
        RoboTextView roboTextView;
        y yVar3;
        RoboTextView roboTextView2;
        y yVar4;
        LinearLayout linearLayout;
        k.c(str, "title");
        k.c(str2, "message");
        e eVar = this.f30723c;
        if (!(eVar == null || (yVar4 = eVar.f30229b) == null || (linearLayout = yVar4.f30306b) == null)) {
            linearLayout.setVisibility(0);
        }
        e eVar2 = this.f30723c;
        if (!(eVar2 == null || (yVar3 = eVar2.f30229b) == null || (roboTextView2 = yVar3.f30308d) == null)) {
            roboTextView2.setText(str);
        }
        e eVar3 = this.f30723c;
        if (!(eVar3 == null || (yVar2 = eVar3.f30229b) == null || (roboTextView = yVar2.f30307c) == null)) {
            roboTextView.setText(str2);
        }
        e eVar4 = this.f30723c;
        if (eVar4 != null && (yVar = eVar4.f30229b) != null && (button = yVar.f30305a) != null) {
            button.setOnClickListener(new b(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f30729a;

        b(h hVar) {
            this.f30729a = hVar;
        }

        public final void onClick(View view) {
            this.f30729a.a();
        }
    }

    private void g() {
        y yVar;
        LinearLayout linearLayout;
        e eVar = this.f30723c;
        if (eVar != null && (yVar = eVar.f30229b) != null && (linearLayout = yVar.f30306b) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 3) {
            a();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        bc bcVar;
        Button button;
        bc bcVar2;
        Button button2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        LiveData liveData;
        LiveData liveData2;
        k.c(view, "view");
        this.f30724d = (net.one97.travelpass.g.a) am.a((Fragment) this).a(net.one97.travelpass.g.a.class);
        net.one97.travelpass.g.a aVar = this.f30724d;
        if (!(aVar == null || (liveData2 = aVar.m) == null)) {
            liveData2.observe(getViewLifecycleOwner(), new c(this));
        }
        net.one97.travelpass.g.a aVar2 = this.f30724d;
        if (!(aVar2 == null || (liveData = aVar2.n) == null)) {
            liveData.observe(getViewLifecycleOwner(), new d(this));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        e eVar = this.f30723c;
        if (!(eVar == null || (recyclerView2 = eVar.f30232e) == null)) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        if (this.f30725e != null) {
            this.f30721a = new net.one97.travelpass.a.c(getActivity(), this.f30725e, this);
            e eVar2 = this.f30723c;
            if (!(eVar2 == null || (recyclerView = eVar2.f30232e) == null)) {
                net.one97.travelpass.a.c cVar = this.f30721a;
                if (cVar == null) {
                    k.a("recyclerAdapter");
                }
                recyclerView.setAdapter(cVar);
            }
        }
        e eVar3 = this.f30723c;
        if (!(eVar3 == null || (bcVar2 = eVar3.f30233f) == null || (button2 = bcVar2.f30157a) == null)) {
            button2.setText(R.string.view_passes);
        }
        e eVar4 = this.f30723c;
        if (!(eVar4 == null || (bcVar = eVar4.f30233f) == null || (button = bcVar.f30157a) == null)) {
            button.setOnClickListener(new a(this));
        }
        a();
        super.onViewCreated(view, bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.travelpass.ui.fragment.h r8) {
        /*
            net.one97.travelpass.model.TPAboutResponse r0 = r8.f30722b
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.travelpass.ui.c.j r2 = new net.one97.travelpass.ui.c.j
            r2.<init>()
            net.one97.travelpass.ui.b.b r3 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_ABOUT_INFO
            r2.a((net.one97.travelpass.ui.b.b) r3)
            r3 = 0
            if (r0 == 0) goto L_0x0033
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r4 = r0.getTpAboutData()
            if (r4 == 0) goto L_0x001f
            net.one97.travelpass.model.TravelPassMetaData$PassAboutInfo r4 = r4.getKnowMore()
            goto L_0x0020
        L_0x001f:
            r4 = r3
        L_0x0020:
            if (r4 == 0) goto L_0x0033
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r4 = r0.getTpAboutData()
            if (r4 == 0) goto L_0x002d
            net.one97.travelpass.model.TravelPassMetaData$PassAboutInfo r4 = r4.getKnowMore()
            goto L_0x002e
        L_0x002d:
            r4 = r3
        L_0x002e:
            com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4
            r2.a((com.paytm.network.model.IJRPaytmDataModel) r4)
        L_0x0033:
            com.paytm.network.model.IJRPaytmDataModel r4 = r2.b()
            if (r4 == 0) goto L_0x003c
            r1.add(r2)
        L_0x003c:
            net.one97.travelpass.ui.c.j r2 = new net.one97.travelpass.ui.c.j
            r2.<init>()
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x008c
            net.one97.travelpass.ui.b.b r6 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS
            r2.a((net.one97.travelpass.ui.b.b) r6)
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r6 = r0.getTpAboutData()
            if (r6 == 0) goto L_0x0055
            java.lang.String r6 = r6.getCardLevelPartnerOfferHeading()
            goto L_0x0056
        L_0x0055:
            r6 = r3
        L_0x0056:
            r2.a((java.lang.String) r6)
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r6 = r0.getTpAboutData()
            if (r6 == 0) goto L_0x0064
            java.lang.String r6 = r6.getSelectedPassesHeading()
            goto L_0x0065
        L_0x0064:
            r6 = r3
        L_0x0065:
            r2.b((java.lang.String) r6)
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r6 = r0.getTpAboutData()
            if (r6 == 0) goto L_0x0073
            java.util.List r6 = r6.getPartnerOffers()
            goto L_0x0074
        L_0x0073:
            r6 = r3
        L_0x0074:
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x0082
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r7 = 0
            goto L_0x0083
        L_0x0082:
            r7 = 1
        L_0x0083:
            if (r7 != 0) goto L_0x008c
            java.util.ArrayList r6 = net.one97.travelpass.e.g.a((java.util.List<? extends net.one97.travelpass.model.PartnersOfferData>) r6)
            r2.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r6)
        L_0x008c:
            java.util.ArrayList r6 = r2.a()
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x009d
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r6 = 0
            goto L_0x009e
        L_0x009d:
            r6 = 1
        L_0x009e:
            if (r6 != 0) goto L_0x00a3
            r1.add(r2)
        L_0x00a3:
            net.one97.travelpass.ui.c.j r2 = new net.one97.travelpass.ui.c.j
            r2.<init>()
            net.one97.travelpass.ui.b.b r6 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS
            r2.a((net.one97.travelpass.ui.b.b) r6)
            if (r0 == 0) goto L_0x00ba
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r6 = r0.getTpAboutData()
            if (r6 == 0) goto L_0x00ba
            java.util.List r6 = r6.getInternalOffers()
            goto L_0x00bb
        L_0x00ba:
            r6 = r3
        L_0x00bb:
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x00c9
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r7 = 0
            goto L_0x00ca
        L_0x00c9:
            r7 = 1
        L_0x00ca:
            if (r7 != 0) goto L_0x00d3
            java.util.ArrayList r6 = net.one97.travelpass.e.g.b((java.util.List<? extends net.one97.travelpass.model.InternalOfferData>) r6)
            r2.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r6)
        L_0x00d3:
            java.util.ArrayList r6 = r2.a()
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x00e4
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00e2
            goto L_0x00e4
        L_0x00e2:
            r6 = 0
            goto L_0x00e5
        L_0x00e4:
            r6 = 1
        L_0x00e5:
            if (r6 != 0) goto L_0x00ea
            r1.add(r2)
        L_0x00ea:
            if (r0 == 0) goto L_0x010c
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r2 = r0.getTpAboutData()
            if (r2 == 0) goto L_0x0103
            net.one97.travelpass.model.TravelPassMetaData$HowToData r2 = r2.getHowtos()
            if (r2 == 0) goto L_0x0103
            net.one97.travelpass.model.TravelPassMetaData$HowToBuy r2 = r2.getHowtobuy()
            if (r2 == 0) goto L_0x0103
            java.util.List r2 = r2.getKnowmore()
            goto L_0x0104
        L_0x0103:
            r2 = r3
        L_0x0104:
            boolean r6 = r2 instanceof java.util.ArrayList
            if (r6 != 0) goto L_0x0109
            r2 = r3
        L_0x0109:
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            goto L_0x010d
        L_0x010c:
            r2 = r3
        L_0x010d:
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x011b
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0119
            goto L_0x011b
        L_0x0119:
            r6 = 0
            goto L_0x011c
        L_0x011b:
            r6 = 1
        L_0x011c:
            if (r6 != 0) goto L_0x013e
            java.util.ArrayList r2 = net.one97.travelpass.e.g.c((java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.KnowMore>) r2)
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x013e
            net.one97.travelpass.ui.c.j r6 = new net.one97.travelpass.ui.c.j
            r6.<init>()
            r6.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r2)
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_KNOW_MORE
            r6.a((net.one97.travelpass.ui.b.b) r2)
            net.one97.travelpass.ui.b.a r2 = net.one97.travelpass.ui.b.a.TRAVEL_PASS_ABOUT_HOW_TO_BUY
            r6.a((net.one97.travelpass.ui.b.a) r2)
            goto L_0x013f
        L_0x013e:
            r6 = r3
        L_0x013f:
            if (r6 == 0) goto L_0x0158
            java.util.ArrayList r2 = r6.a()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0152
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r2 = 0
            goto L_0x0153
        L_0x0152:
            r2 = 1
        L_0x0153:
            if (r2 != 0) goto L_0x0158
            r1.add(r6)
        L_0x0158:
            if (r0 == 0) goto L_0x017a
            net.one97.travelpass.model.TPAboutResponse$TPResponseBody r0 = r0.getTpAboutData()
            if (r0 == 0) goto L_0x0171
            net.one97.travelpass.model.TravelPassMetaData$HowToData r0 = r0.getHowtos()
            if (r0 == 0) goto L_0x0171
            net.one97.travelpass.model.TravelPassMetaData$HowToUse r0 = r0.getHowtouse()
            if (r0 == 0) goto L_0x0171
            java.util.List r0 = r0.getKnowmore()
            goto L_0x0172
        L_0x0171:
            r0 = r3
        L_0x0172:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 != 0) goto L_0x0177
            r0 = r3
        L_0x0177:
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L_0x017b
        L_0x017a:
            r0 = r3
        L_0x017b:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0189
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0187
            goto L_0x0189
        L_0x0187:
            r2 = 0
            goto L_0x018a
        L_0x0189:
            r2 = 1
        L_0x018a:
            if (r2 != 0) goto L_0x01ab
            java.util.ArrayList r0 = net.one97.travelpass.e.g.b((java.util.ArrayList<net.one97.travelpass.model.TravelPassMetaData.KnowMore>) r0)
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x01ab
            net.one97.travelpass.ui.c.j r3 = new net.one97.travelpass.ui.c.j
            r3.<init>()
            r3.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r0)
            net.one97.travelpass.ui.b.b r0 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_KNOW_MORE
            r3.a((net.one97.travelpass.ui.b.b) r0)
            net.one97.travelpass.ui.b.a r0 = net.one97.travelpass.ui.b.a.TRAVEL_PASS_ABOUT_HOW_TO_USE
            r3.a((net.one97.travelpass.ui.b.a) r0)
        L_0x01ab:
            if (r3 == 0) goto L_0x01c1
            java.util.ArrayList r0 = r3.a()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x01bb
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01bc
        L_0x01bb:
            r4 = 1
        L_0x01bc:
            if (r4 != 0) goto L_0x01c1
            r1.add(r3)
        L_0x01c1:
            r8.f30725e = r1
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r0 = r8.f30725e
            r8.f30725e = r0
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r0 = r8.f30725e
            net.one97.travelpass.a.c r1 = r8.f30721a
            java.lang.String r2 = "recyclerAdapter"
            if (r1 != 0) goto L_0x01d2
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01d2:
            if (r1 == 0) goto L_0x01f5
            if (r0 == 0) goto L_0x01f5
            net.one97.travelpass.b.e r1 = r8.f30723c
            if (r1 == 0) goto L_0x01e1
            androidx.recyclerview.widget.RecyclerView r1 = r1.f30232e
            if (r1 == 0) goto L_0x01e1
            r1.removeAllViewsInLayout()
        L_0x01e1:
            net.one97.travelpass.a.c r1 = r8.f30721a
            if (r1 != 0) goto L_0x01e8
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01e8:
            r1.a(r0)
            net.one97.travelpass.a.c r8 = r8.f30721a
            if (r8 != 0) goto L_0x01f2
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01f2:
            r8.notifyDataSetChanged()
        L_0x01f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.h.a(net.one97.travelpass.ui.fragment.h):void");
    }
}
