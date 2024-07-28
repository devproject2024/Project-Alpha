package com.travel.train.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainPassengerDetailActivity;
import com.travel.train.activity.AJRTrainReviewItineraryActivity;
import com.travel.train.activity.AJRTrainViewRoute;
import com.travel.train.b.ap;
import com.travel.train.fragment.m;
import com.travel.train.helper.f;
import com.travel.train.i.ak;
import com.travel.train.j.b;
import com.travel.train.j.m;
import com.travel.train.j.n;
import com.travel.train.k.c;
import com.travel.train.k.g;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.e;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.trainticket.CJRBoardingStationDetails;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainDetails;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainFilterModel;
import com.travel.train.model.trainticket.CJRTrainQuota;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.i;
import com.travel.train.widget.CJRCenterLayoutManager;
import com.travel.utils.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class ac extends am implements m.a, ak, b.C0491b {
    private b A;
    private Intent B;
    private j C;
    private String D;
    private boolean E;
    private boolean F;
    private int G;
    private a H;
    private k I;
    private c J;
    private CJRSearchByTrainNumberModel K;

    /* renamed from: a  reason: collision with root package name */
    String f26747a = "FJRTrainSearchListFragment";

    /* renamed from: b  reason: collision with root package name */
    private CJRTrainSearchInput f26748b;

    /* renamed from: c  reason: collision with root package name */
    private View f26749c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f26750d;

    /* renamed from: e  reason: collision with root package name */
    private CJRCenterLayoutManager f26751e;

    /* renamed from: f  reason: collision with root package name */
    private ap f26752f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f26753g;

    /* renamed from: h  reason: collision with root package name */
    private CJRTrainSearchResults f26754h;

    /* renamed from: i  reason: collision with root package name */
    private List<CJRTrainSearchResultsTrain> f26755i;
    private String j;
    private ArrayList<CJRTrainQuota> k;
    private HashMap<String, Object> l;
    private String m;
    private List<CJRTrainSearchResultsTrain> n;
    private CJRTrainFilterModel o;
    private i p;
    private int q;
    /* access modifiers changed from: private */
    public CJRTrainSearchResultsAlternateStationData r;
    private CJRTrainSearchResultsTrain s;
    private String t;
    private String u;
    /* access modifiers changed from: private */
    public boolean v = false;
    /* access modifiers changed from: private */
    public CJRTrainDetailsBody w;
    /* access modifiers changed from: private */
    public ArrayList<CJRTrainAvailability> x;
    private boolean y;
    private boolean z = false;

    public interface a {
        void a(boolean z);

        void b();
    }

    public final void a() {
    }

    public static ac a(Bundle bundle) {
        ac acVar = new ac();
        acVar.setArguments(bundle);
        return acVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i();
    }

    public final void b(Bundle bundle) {
        setArguments(bundle);
        i();
        k();
        i iVar = this.p;
        if (iVar != null) {
            a(iVar);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f26749c = layoutInflater.inflate(R.layout.pre_t_fragment_train_search_results, (ViewGroup) null);
        this.f26750d = (RecyclerView) this.f26749c.findViewById(R.id.recycler_view_train_searchlist);
        this.f26750d.scrollToPosition(0);
        this.f26751e = new CJRCenterLayoutManager(getActivity());
        this.f26750d.setLayoutManager(this.f26751e);
        this.f26750d.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ac.this.a(view, motionEvent);
            }
        });
        k();
        i iVar = this.p;
        if (iVar != null) {
            a(iVar);
        }
        this.C = getFragmentManager();
        return this.f26749c;
    }

    private void i() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("search_by_train_result")) {
                this.K = (CJRSearchByTrainNumberModel) arguments.getSerializable("search_by_train_result");
                getActivity();
                this.f26754h = com.travel.train.helper.b.a(this.K);
                this.o = new CJRTrainFilterModel();
            }
            if (arguments.containsKey("intent_extra_train_search_input")) {
                this.f26748b = (CJRTrainSearchInput) arguments.getSerializable("intent_extra_train_search_input");
            }
            if (arguments.containsKey("intent_extra_train_list")) {
                this.f26754h = (CJRTrainSearchResults) arguments.getSerializable("intent_extra_train_list");
            }
            if (arguments.containsKey("intent_filter_result")) {
                this.o = (CJRTrainFilterModel) arguments.getSerializable("intent_filter_result");
            }
            if (arguments.containsKey("alreadyFilterApplied")) {
                this.m = arguments.getString("alreadyFilterApplied");
            }
            if (arguments.containsKey("intent_default_sort")) {
                this.p = (i) arguments.getSerializable("intent_default_sort");
            }
            CJRTrainSearchResults cJRTrainSearchResults = this.f26754h;
            if (cJRTrainSearchResults != null && cJRTrainSearchResults.getBody() != null && this.f26754h.getBody().getTrains() != null && this.f26754h.getBody().getTrains().size() > 0) {
                i iVar = new i();
                iVar.setTitle(getActivity().getString(R.string.train_departure_tab));
                iVar.setSortByTrain("departure");
                iVar.setOrderByTrain("forward");
                j();
            }
        }
    }

    private void j() {
        this.f26755i = this.f26754h.getBody().getTrains();
        try {
            this.n = new ArrayList();
            for (int i2 = 0; i2 < this.f26755i.size(); i2++) {
                this.n.add(this.f26755i.get(i2).clone());
            }
        } catch (CloneNotSupportedException e2) {
            q.c(e2.getMessage());
        }
        HashMap<String, String> quota = this.f26754h.getMeta().getQuota();
        if (quota != null) {
            this.k = new ArrayList<>();
            List<String> quota2 = this.f26754h.getBody().getQuota();
            if (quota2 != null && quota2.size() > 0) {
                for (int i3 = 0; i3 < quota2.size(); i3++) {
                    CJRTrainQuota cJRTrainQuota = new CJRTrainQuota();
                    if (quota2.get(i3).equalsIgnoreCase("GN")) {
                        cJRTrainQuota.setIsSelected(true);
                    } else {
                        cJRTrainQuota.setIsSelected(false);
                    }
                    cJRTrainQuota.setQuotaName(quota.get(quota2.get(i3)));
                    cJRTrainQuota.setQuotaCode(quota2.get(i3));
                    this.k.add(cJRTrainQuota);
                }
            }
            if (!(this.f26754h.getMeta() == null || this.f26754h.getMeta().getClasses() == null)) {
                this.l = this.f26754h.getMeta().getClasses();
            }
            if (this.f26754h.getMeta() != null && this.f26754h.getMeta().getRequestid() != null) {
                this.j = this.f26754h.getMeta().getRequestid();
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g.a a2 = new g.a(g.b.BOOKING).a(com.travel.train.a.a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(getActivity())));
        a2.f27667b = true;
        this.J = (c) am.a((Fragment) this, (al.b) new g(a2)).a(c.class);
        this.J.k.observe(this, new z<CJRTrainDetails>() {
            public final /* synthetic */ void onChanged(Object obj) {
                CJRTrainDetailsBody unused = ac.this.w = ((CJRTrainDetails) obj).getmTrainDetailsBody();
                ac acVar = ac.this;
                ArrayList unused2 = acVar.x = acVar.w.getmTrainAvailability();
                if (!ac.this.x.isEmpty()) {
                    ac.c(ac.this);
                    ac.d(ac.this);
                }
            }
        });
        this.J.m.observe(this, new z<Boolean>() {
            public final /* synthetic */ void onChanged(Object obj) {
                ac.a(ac.this, ((Boolean) obj).booleanValue());
            }
        });
        this.J.n.observe(this, new z<e>() {
            public final /* synthetic */ void onChanged(Object obj) {
                e eVar = (e) obj;
                if (eVar != null) {
                    ac acVar = ac.this;
                    int i2 = eVar.f27696a;
                    NetworkCustomError networkCustomError = eVar.f27698c;
                    if (i2 == 410 || i2 == 401) {
                        com.travel.train.b.a();
                        com.travel.train.b.b().a((Activity) acVar.getActivity(), networkCustomError);
                        return;
                    }
                    try {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && !TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.f((Context) acVar.getActivity(), networkCustomError.getUrl());
                        } else if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("failure_error")) {
                            acVar.showErrorDialog(networkCustomError.getAlertMessage(), networkCustomError.getAlertTitle());
                        } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                            com.paytm.utility.b.b((Context) acVar.getActivity(), acVar.getResources().getString(R.string.network_error_heading), acVar.getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                        } else {
                            acVar.showErrorDialog(networkCustomError.getAlertMessage(), networkCustomError.getAlertTitle());
                        }
                    } catch (Exception e2) {
                        q.c(e2.getMessage());
                    }
                }
            }
        });
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof a)) {
            this.H = (a) parentFragment;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        a aVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return false;
        }
        if ((actionMasked != 1 && (actionMasked == 2 || actionMasked != 3)) || (aVar = this.H) == null) {
            return false;
        }
        aVar.b();
        return false;
    }

    public final boolean d() {
        CJRCenterLayoutManager cJRCenterLayoutManager = this.f26751e;
        if (cJRCenterLayoutManager != null && cJRCenterLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 && this.f26751e.findFirstCompletelyVisibleItemPosition() == 0) {
            return true;
        }
        return false;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f26753g = activity;
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    private static Object a(Serializable serializable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void b() {
        CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData;
        CJRTrainDetailsBody cJRTrainDetailsBody;
        this.z = false;
        if (this.f26748b != null && (cJRTrainSearchResultsAlternateStationData = this.r) != null && this.s != null) {
            if (!TextUtils.isEmpty(cJRTrainSearchResultsAlternateStationData.getNewSource()) && !TextUtils.isEmpty(this.r.getNewDestination())) {
                int i2 = -1;
                CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.s;
                if (cJRTrainSearchResultsTrain != null && !TextUtils.isEmpty(cJRTrainSearchResultsTrain.getSource()) && (cJRTrainDetailsBody = this.w) != null && cJRTrainDetailsBody.getBoardingDetail() != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < this.w.getBoardingDetail().size()) {
                            CJRBoardingStationDetails cJRBoardingStationDetails = this.w.getBoardingDetail().get(i3);
                            if (cJRBoardingStationDetails != null && this.s.getSource().equalsIgnoreCase(cJRBoardingStationDetails.getmStationCode())) {
                                i2 = i3;
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                }
                this.G = i2;
                this.s.setSource(this.r.getNewSource());
                this.s.setDestination(this.r.getNewDestination());
                this.s.setSourceName(this.r.getNewSourceName());
                this.s.setDestinationName(this.r.getNewDestinationName());
            }
            this.s.setMirctcuserid(com.paytm.utility.b.W((Context) getActivity()));
            Intent intent = new Intent(getActivity(), AJRTrainPassengerDetailActivity.class);
            intent.putExtra("train_class_code", this.t);
            intent.putExtra("train_class_details", this.u);
            this.w.setMiSelectedPosition(0);
            intent.putExtra("quota", "GN");
            intent.putExtra("quota_name", "GENERAL");
            intent.putExtra("waiting_list", this.y);
            intent.putExtra("train_detail_body", this.w);
            intent.putExtra("train_detail", this.s);
            intent.putExtra("intent_extra_train_search_input", this.f26748b);
            intent.putExtra("is_from_alternative_click", true);
            intent.putExtra("alternate_boarding_station_position", this.G);
            intent.putExtra("chosenDate", this.D);
            CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData2 = this.r;
            if (cJRTrainSearchResultsAlternateStationData2 != null) {
                intent.putExtra("source", cJRTrainSearchResultsAlternateStationData2.getNewSource());
                intent.putExtra("destination", this.r.getNewDestination());
            }
            intent.putExtra("request_id", this.j);
            intent.putExtra("minsuranceAlwaysTrue", this.E);
            intent.putExtra("minsuranceOption", this.F);
            getActivity().startActivityForResult(intent, 989);
        }
    }

    private void k() {
        List<CJRTrainSearchResultsTrain> list = this.f26755i;
        if (list != null && list.size() > 0) {
            this.f26752f = new ap(getActivity(), this.f26754h, this.f26755i, this.k, this.l, this.m, getChildFragmentManager(), this.f26748b, this.o);
            ap apVar = this.f26752f;
            apVar.f26257b = this;
            this.f26750d.setAdapter(apVar);
        }
    }

    private List<CJRTrainSearchResultsTrain> a(List<CJRTrainSearchResultsTrain> list, i iVar) {
        if (iVar.getSortByTrain().equalsIgnoreCase("departure")) {
            Collections.sort(list, new f.b());
            if (iVar.getOrderByTrain().equalsIgnoreCase("forward")) {
                Collections.sort(list, Collections.reverseOrder(new f.b()));
            }
        } else if (iVar.getSortByTrain().equalsIgnoreCase("arrival")) {
            Collections.sort(list, new f.a());
            if (iVar.getOrderByTrain().equalsIgnoreCase("forward")) {
                Collections.sort(list, Collections.reverseOrder(new f.a()));
            }
        } else if (iVar.getSortByTrain().equalsIgnoreCase(AppConstants.DURATION)) {
            Collections.sort(list, new f.c());
            if (iVar.getOrderByTrain().equalsIgnoreCase("forward")) {
                Collections.sort(list, Collections.reverseOrder(new f.c()));
            }
        } else if (iVar.getSortByTrain().equalsIgnoreCase("recommended")) {
            list.clear();
            list.addAll(this.n);
        }
        return list;
    }

    public final void a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        CJRTrainSearchResults cJRTrainSearchResults;
        if (!(cJRTrainSearchResultsTrain != null || (cJRTrainSearchResults = this.f26754h) == null || cJRTrainSearchResults.getBody() == null || this.f26754h.getBody().getTrains() == null || this.f26754h.getBody().getTrains().size() <= 0)) {
            cJRTrainSearchResultsTrain = this.f26754h.getBody().getTrains().get(0);
        }
        String n2 = com.paytm.utility.b.n((Context) getActivity());
        HashMap hashMap = new HashMap();
        if (cJRTrainSearchResultsTrain != null) {
            hashMap.put("train_name", cJRTrainSearchResultsTrain.getTrainName() + " " + cJRTrainSearchResultsTrain.getTrainNumber());
        }
        if (n2 != null && !TextUtils.isEmpty(n2)) {
            hashMap.put(d.f49600g, n2);
        }
        if (this.f26748b != null) {
            hashMap.put(d.f49601h, this.f26748b.getmSourceCityName());
            hashMap.put(d.f49602i, this.f26748b.getmDestCityName());
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
        com.travel.train.b.a();
        com.travel.train.b.b().a("train_search_results_train_route_clicked", (Map<String, Object>) hashMap, (Context) getActivity());
        Intent intent = new Intent(getActivity(), AJRTrainViewRoute.class);
        intent.putExtra("extra_home_data", cJRTrainSearchResultsTrain);
        intent.putExtra("extra_selected_train_detail", this.f26748b);
        startActivity(intent);
    }

    public final void a(final int i2) {
        ap apVar;
        if (this.f26750d != null && (apVar = this.f26752f) != null && i2 < apVar.getItemCount()) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    ac.this.f26750d.smoothScrollToPosition(i2);
                }
            }, 300);
        }
    }

    public final void a(int i2, CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        k kVar = this.I;
        if (kVar == null || !kVar.isVisible()) {
            if (this.I == null) {
                this.I = new k();
            }
            if (!this.I.isVisible()) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("alternate_station", cJRTrainSearchResultsAlternateStationData);
                bundle.putSerializable("train_detail", cJRTrainSearchResultsTrain);
                bundle.putInt("clicked_position", i2);
                bundle.putSerializable("class_map", this.l);
                this.I.setArguments(bundle);
                this.I.show(getChildFragmentManager(), k.class.getSimpleName());
            }
        }
    }

    public final void b(int i2, CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        this.v = true;
        this.q = i2;
        this.r = cJRTrainSearchResultsAlternateStationData;
        this.s = (CJRTrainSearchResultsTrain) a((Serializable) cJRTrainSearchResultsTrain);
        if (this.r.getMAvailability() != null && this.r.getMAvailability().size() > 0) {
            Iterator<CJRTrainSearchResultsAvailibiltyObject> it2 = this.r.getMAvailability().iterator();
            while (it2.hasNext()) {
                this.t = it2.next().getClassType();
                this.u = n.a(this.t, this.l);
            }
        }
        c cVar = this.J;
        HashMap<String, String> b2 = n.b(this.f26753g);
        HashMap hashMap = new HashMap();
        hashMap.put("requestid", this.f26754h.getMeta().getRequestid());
        hashMap.put("trainNumber", this.s.getTrainNumber());
        hashMap.put("departureDate", this.r.getNewDepartureDate());
        hashMap.put("source", this.r.getNewSource());
        hashMap.put("destination", this.r.getNewDestination());
        if (!(com.travel.train.j.g.f27551a == null || com.travel.train.j.g.f27551a.getTestId() == null)) {
            hashMap.put("test_id", com.travel.train.j.g.f27551a.getTestId().toString());
        }
        hashMap.put("quota", "GN");
        hashMap.put(Item.KEY_CLASS, this.t);
        hashMap.put("alternate_stations", "true");
        cVar.b(b2, hashMap);
    }

    public final void e() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                boolean unused = ac.this.v = false;
            }
        }, 100);
    }

    public final void a(i iVar) {
        ap apVar = this.f26752f;
        if (apVar != null && apVar.f26258c != null) {
            this.f26752f.a();
            a(this.f26752f.f26258c, iVar);
            this.f26752f.notifyDataSetChanged();
        }
    }

    public final boolean f() {
        ap apVar = this.f26752f;
        if (apVar == null || !apVar.o) {
            return false;
        }
        this.f26752f.a();
        return true;
    }

    public final void g() {
        m a2;
        m.a aVar = com.travel.train.j.m.f27577a;
        FragmentActivity activity = getActivity();
        k.c("train_most_visited", "keyName");
        if (activity != null) {
            String string = activity.getSharedPreferences("train_most_visited", 0).getString((String) null, (String) null);
            if (!TextUtils.isEmpty(string)) {
                Object a3 = new com.google.gsonhtcfix.f().a(string, new m.a.b().getType());
                k.a(a3, "Gson().fromJson(stations…ntsItemModel>>() {}.type)");
                m.a.a((CJRTrainRecentsItemModel) ((List) a3).get(0), "train_most_visited", 5, activity);
            }
        }
        if (!this.v) {
            ap apVar = this.f26752f;
            if (apVar != null && apVar.f26260e != null && (a2 = apVar.f26260e.a()) != null) {
                a2.d();
                return;
            }
            return;
        }
        l();
    }

    public final void a(Intent intent) {
        m a2;
        if (!this.v) {
            ap apVar = this.f26752f;
            if (apVar.f26260e != null && (a2 = apVar.f26260e.a()) != null) {
                a2.r = true;
                a2.s = intent;
                a2.d();
                return;
            }
            return;
        }
        this.z = true;
        this.B = intent;
        l();
    }

    public final void h() {
        ArrayList<CJRTrainAvailability> arrayList = this.x;
        if (arrayList != null && arrayList.get(0) != null) {
            CJRTrainAvailability cJRTrainAvailability = this.x.get(0);
            this.D = com.paytm.utility.b.d(cJRTrainAvailability.getmDate(), "yyyy-MM-dd", "EEE, dd MMM");
            if (cJRTrainAvailability.isMinsuranceOption()) {
                this.E = cJRTrainAvailability.isMinsuranceAlwaysTrue();
                this.F = true;
            } else {
                this.F = false;
            }
            l();
        }
    }

    private void l() {
        ArrayList<CJRTrainAvailability> arrayList = this.x;
        if (arrayList != null && arrayList.get(0) != null) {
            final CJRTrainAvailability cJRTrainAvailability = this.x.get(0);
            if (this.z) {
                m();
            } else if (cJRTrainAvailability.isBookingAllowed()) {
                if (cJRTrainAvailability.isMessageEnable()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(cJRTrainAvailability.getMessage());
                    builder.setPositiveButton(this.f26753g.getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                            if (ac.this.w == null || ac.this.w.getMessage() == null || !ac.this.w.getMessage().isEnable()) {
                                if (!(ac.this.r == null || ac.this.r.getNewDuration() == null)) {
                                    ac acVar = ac.this;
                                    acVar.a(acVar.r, cJRTrainAvailability);
                                }
                                ac.this.m();
                                return;
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(ac.this.getActivity());
                            builder.setMessage(ac.this.w.getMessage().getMessage());
                            builder.setPositiveButton(ac.this.f26753g.getString(R.string.ok), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    ac.this.m();
                                    if (!(ac.this.r == null || ac.this.r.getNewDuration() == null)) {
                                        ac.this.a(ac.this.r, cJRTrainAvailability);
                                    }
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.show();
                        }
                    });
                    builder.show();
                    return;
                }
                CJRTrainDetailsBody cJRTrainDetailsBody = this.w;
                if (cJRTrainDetailsBody == null || cJRTrainDetailsBody.getMessage() == null || !this.w.getMessage().isEnable()) {
                    CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData = this.r;
                    if (!(cJRTrainSearchResultsAlternateStationData == null || cJRTrainSearchResultsAlternateStationData.getNewDuration() == null)) {
                        a(this.r, cJRTrainAvailability);
                    }
                    m();
                    return;
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setMessage(this.w.getMessage().getMessage());
                builder2.setPositiveButton(this.f26753g.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        ac.this.m();
                        if (!(ac.this.r == null || ac.this.r.getNewDuration() == null)) {
                            ac acVar = ac.this;
                            acVar.a(acVar.r, cJRTrainAvailability);
                        }
                        dialogInterface.dismiss();
                    }
                });
                builder2.show();
            } else if (cJRTrainAvailability.isMessageEnable()) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
                builder3.setMessage(cJRTrainAvailability.getMessage());
                builder3.setPositiveButton(this.f26753g.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder3.show();
            }
        }
    }

    public final void a(CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainAvailability cJRTrainAvailability) {
        String f2 = com.travel.train.j.i.f(cJRTrainSearchResultsAlternateStationData.getNewDeparture());
        a(com.travel.train.j.i.b(com.travel.train.j.i.d(cJRTrainAvailability.getmDate() + f2), cJRTrainSearchResultsAlternateStationData.getNewDuration()), cJRTrainAvailability);
    }

    private void a(String str, CJRTrainAvailability cJRTrainAvailability) {
        CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData = this.r;
        if (cJRTrainSearchResultsAlternateStationData != null && this.s != null) {
            String f2 = com.travel.train.j.i.f(cJRTrainSearchResultsAlternateStationData.getNewDeparture());
            this.s.setMSearchedTrainArrivalTime(str);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.s;
            cJRTrainSearchResultsTrain.setMSearchedTrainDepartureTime(com.travel.train.j.i.d(cJRTrainAvailability.getmDate() + f2));
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (com.paytm.utility.b.r((Context) getActivity())) {
            String W = com.paytm.utility.b.W((Context) getActivity());
            if (W == null || TextUtils.isEmpty(W)) {
                this.A = new b(getActivity(), this, false, (String) null, (String) null, this.f26748b, this.C, this.z, this.q, false, true);
                this.A.a();
                this.z = false;
                return;
            }
            this.A = new b(getActivity(), this, false, (String) null, W, this.f26748b, this.C, this.z, this.q, false, true);
            this.A.a(W);
            this.z = false;
            return;
        }
        n();
    }

    private void n() {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) getActivity(), intent, 4);
    }

    public final void a(boolean z2) {
        a aVar = this.H;
        if (aVar != null) {
            aVar.a(z2);
        }
    }

    public final void c() {
        Intent intent = new Intent(this.f26753g, AJRTrainReviewItineraryActivity.class);
        Intent intent2 = this.B;
        if (intent2 != null) {
            String str = null;
            CJRTrainDetailsBody cJRTrainDetailsBody = (!intent2.hasExtra("train_detail_body") || this.B.getSerializableExtra("train_detail_body") == null) ? null : (CJRTrainDetailsBody) this.B.getSerializableExtra("train_detail_body");
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = (!this.B.hasExtra("train_detail") || this.B.getSerializableExtra("train_detail") == null) ? null : (CJRTrainSearchResultsTrain) this.B.getSerializableExtra("train_detail");
            CJRTrainSearchInput cJRTrainSearchInput = this.B.hasExtra("intent_extra_train_search_input") ? (CJRTrainSearchInput) this.B.getSerializableExtra("intent_extra_train_search_input") : null;
            String stringExtra = this.B.hasExtra("request_id") ? this.B.getStringExtra("request_id") : null;
            if (this.B.hasExtra("train_class_code")) {
                str = this.B.getStringExtra("train_class_code");
            }
            intent.putExtra("train_detail_body", cJRTrainDetailsBody);
            intent.putExtra("train_detail", cJRTrainSearchResultsTrain);
            intent.putExtra("intent_extra_train_search_input", cJRTrainSearchInput);
            intent.putExtra("request_id", stringExtra);
            intent.putExtra("train_class_code", str);
        }
        this.f26753g.startActivity(intent);
    }

    static /* synthetic */ void c(ac acVar) {
        HashMap<String, String> typeMap = acVar.x.get(0).getTypeMap();
        if (typeMap != null) {
            for (Map.Entry<String, String> value : typeMap.entrySet()) {
                acVar.y = !value.getValue().equals("1");
            }
        }
    }

    static /* synthetic */ void d(ac acVar) {
        if (acVar.y) {
            final Dialog dialog = new Dialog(acVar.f26753g);
            dialog.requestWindowFeature(1);
            View inflate = acVar.getActivity().getLayoutInflater().inflate(R.layout.pre_t_activity_alternate_waitlist, (ViewGroup) null);
            dialog.setContentView(inflate);
            dialog.show();
            Window window = dialog.getWindow();
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setBackgroundDrawable((Drawable) null);
            ResourceUtils.loadTrainImagesFromCDN((ImageView) inflate.findViewById(R.id.waitlist_icon), "group_20.png", false, false, n.a.V1);
            ((TextView) inflate.findViewById(R.id.another_selection_txt)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((RoboButton) inflate.findViewById(R.id.confirm_btn)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ac.this.h();
                    dialog.dismiss();
                }
            });
            ((RelativeLayout) inflate.findViewById(R.id.lyt_option_close_view)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            return;
        }
        acVar.h();
    }

    static /* synthetic */ void a(ac acVar, boolean z2) {
        if (acVar.getActivity().isFinishing()) {
            return;
        }
        if (z2) {
            acVar.showProgressDialog(acVar.f26753g, "");
        } else {
            acVar.removeProgressDialog();
        }
    }
}
