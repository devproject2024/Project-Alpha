package com.travel.flight.flightorder.d;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.flight.R;
import com.travel.flight.d;
import com.travel.flight.flightorder.a.c;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.e.a;
import com.travel.flight.flightorder.g.e;
import com.travel.flight.flightorder.g.f;
import com.travel.flight.flightorder.g.g;
import com.travel.flight.pojo.flightticket.CJRActionResponse;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends h implements com.paytm.network.listener.b, f {
    private static long y;
    private String A;
    /* access modifiers changed from: private */
    public Fragment B;
    private long C;
    /* access modifiers changed from: private */
    public NestedScrollView D;
    private com.travel.g.b E = new com.travel.g.b() {
    };

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f24365a;

    /* renamed from: b  reason: collision with root package name */
    g f24366b;

    /* renamed from: c  reason: collision with root package name */
    List<a> f24367c;

    /* renamed from: d  reason: collision with root package name */
    CJROrderSummaryOrigin f24368d = null;

    /* renamed from: e  reason: collision with root package name */
    CJROrderSummaryDestination f24369e = null;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public String f24370f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24371g;

    /* renamed from: h  reason: collision with root package name */
    protected FlightOrderSummary.a f24372h;

    /* renamed from: i  reason: collision with root package name */
    protected ProgressDialog f24373i;
    public com.travel.flight.flightorder.e.a j;
    public String k;
    Handler l = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!b.this.isDetached()) {
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2) {
                        b bVar = b.this;
                        bVar.a(bVar.j());
                    } else if (i2 == 3) {
                        b.c(b.this);
                    } else if (i2 == 4) {
                        b.this.g();
                    }
                } else if (b.this.q != null && !TextUtils.isEmpty(b.this.f24370f)) {
                    b.this.q.a(b.this.f24370f, b.this.f24371g);
                    b.this.f();
                }
            }
        }
    };
    public C0467b m;
    boolean n = false;
    CJRHomePageDetailV2 o;
    protected List<CJRHomePageLayoutV2> p;
    /* access modifiers changed from: private */
    public e q;
    private ProgressBar r;
    private String s;
    private String t;
    private String u;
    private List<a> v;
    private c w;
    private d x;
    /* access modifiers changed from: private */
    public boolean z;

    public enum a {
        HEADER,
        TICKET_VARIOUS_OPTIONS,
        TICKET_CANCELLATION,
        PASSENGER_DESC_CARD_ONGOING,
        PASSENGER_DESC_CARD_RETURN,
        INSURANCE_DETAILS,
        PAYMENT_DETAILS,
        CASHBACK_DETAILS,
        REFUND_SUMMARY,
        FOOTER,
        FLIGHT_LIFAFA,
        CANCEL_PROTECT,
        FLIGHT_ANCILLARY,
        FLIGHT_MEAL_ANCILLARY,
        FLIGHT_VIP_CASHBACK,
        REVIEW_RATING_WIDGET,
        HOTEL_OPTIONS,
        FLIGHT_BUNDLE_COUPON,
        THIN_BANNER,
        REFUND_DETAILS,
        MODIFY,
        ITEM_VIEW_HTML_BOX
    }

    /* renamed from: com.travel.flight.flightorder.d.b$b  reason: collision with other inner class name */
    public enum C0467b {
        PAYMENT_SUCCESS,
        PAYMENT_FAILED,
        PAYMENT_PENDING,
        PAYMENT_PENDING_DELAYED,
        BOOKING_PENDING,
        BOOKING_PENDING_DELAYED,
        BOOKING_SUCCESSFUL,
        BOOKING_MODIFIED,
        BOOKING_FAILED,
        BOOKING_FULLY_CANCELLED,
        NO_OP,
        BOOKING_PARTIALLY_CANCELLED,
        BOOKING_CANCELLATION_INPROGRESS
    }

    /* access modifiers changed from: protected */
    public NestedScrollView.b c() {
        return null;
    }

    private boolean a() {
        CJRHomePageDetailV2 cJRHomePageDetailV2 = this.o;
        boolean z2 = (cJRHomePageDetailV2 == null || cJRHomePageDetailV2.getHomePageLayoutList() == null || this.o.getHomePageLayoutList().size() <= 0) ? false : true;
        List<CJRHomePageLayoutV2> list = this.p;
        if (list == null || list.size() > 0) {
            return z2;
        }
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_flight_new_order_summary, (ViewGroup) null);
        this.f24365a = (RecyclerView) inflate.findViewById(R.id.recycler_view_order_summary);
        this.f24365a.setNestedScrollingEnabled(false);
        this.D = (NestedScrollView) inflate.findViewById(R.id.nested_scroll_view);
        this.D.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (b.this.D.getChildAt(b.this.D.getChildCount() - 1).getBottom() - (b.this.D.getHeight() + b.this.D.getScrollY()) == 0 && b.this.B != null && b.f(b.this)) {
                    com.travel.flight.b.a();
                    com.travel.flight.b.b().a(b.this.B);
                }
            }
        });
        this.C = System.currentTimeMillis();
        this.r = (ProgressBar) inflate.findViewById(R.id.lyt_progress_bar);
        this.r.setVisibility(8);
        NestedScrollView.b c2 = c();
        if (c2 != null) {
            this.D.setOnScrollChangeListener(c2);
        }
        this.j = new com.travel.flight.flightorder.e.a(getActivity(), this);
        this.q = new com.travel.flight.flightorder.h.b(getActivity());
        this.q.a((f) this);
        if (getArguments() != null) {
            this.f24370f = getArguments().getString("order_id", (String) null);
            this.f24371g = getArguments().getBoolean("is_from_pg_page", false);
        }
        if (TextUtils.isEmpty(this.f24370f)) {
            ((FlightOrderSummary) getActivity()).showErrorMessage();
        } else {
            this.q.a(this.f24370f, this.f24371g);
            f();
        }
        this.f24367c = new ArrayList();
        this.v = new ArrayList();
        this.f24372h = (FlightOrderSummary.a) getArguments().getSerializable("VERTICAL");
        y = 10000;
        return inflate;
    }

    private void b() {
        if (this.B == null) {
            Bundle bundle = new Bundle();
            com.travel.flight.b.a();
            this.B = com.travel.flight.b.b().a(this.E);
            com.travel.flight.b.a();
            String a2 = com.travel.flight.b.b().a("flightStoreFrontUrlOrderSummary", "");
            bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle.putString("origin", "flight");
            bundle.putString("EXTRA_STORE_FRONT_ALTERNATE_URL", a2);
            bundle.putString("store_front_url_key", "flight");
            this.B.setArguments(bundle);
            getChildFragmentManager().a().a(R.id.framelayout_storefront_order_summary, this.B, "endLessScroll").c();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        e eVar = this.q;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f24366b == null) {
            throw new IllegalStateException("Event Listener Not Registered. Please register Event Listener first");
        }
    }

    public final void i() {
        a(j());
    }

    public final void b(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        try {
            if (this.l != null && cJRFlightOrderSummaryResponse.getBody().isRefresh_flag()) {
                this.l.sendEmptyMessageDelayed(1, (long) (cJRFlightOrderSummaryResponse.getBody().getRefresh_time_sec() * 1000));
            }
            if (this.f24366b != null) {
                if (j().getBody().getAll_states().getBooking() == cJRFlightOrderSummaryResponse.getBody().getAll_states().getBooking()) {
                    boolean z2 = false;
                    if (cJRFlightOrderSummaryResponse != null) {
                        Iterator<CJROrderSummaryItems> it2 = cJRFlightOrderSummaryResponse.getBody().getItems().iterator();
                        while (it2.hasNext()) {
                            CJROrderSummaryItems next = it2.next();
                            if (!(next == null || next.getTap_action() == null)) {
                                this.q.a(next.getTap_action());
                                z2 = true;
                            }
                            CJROrderSummaryAction cJROrderSummaryAction = null;
                            if (next.getAction() != null && next.getAction().size() > 0) {
                                Iterator<CJROrderSummaryAction> it3 = next.getAction().iterator();
                                while (it3.hasNext()) {
                                    CJROrderSummaryAction next2 = it3.next();
                                    if (TextUtils.isEmpty(next2.getLabel()) || !next2.getLabel().equalsIgnoreCase("invoice")) {
                                        next2.setImage_url("http://assets.paytm.com/travel/flights-backend/icons/v1/order_actions/small/share_ios.png");
                                    } else {
                                        cJROrderSummaryAction = new CJROrderSummaryAction();
                                        cJROrderSummaryAction.setLabel("Share Ticket");
                                        cJROrderSummaryAction.setName("Share Ticket");
                                        cJROrderSummaryAction.setUi_control(next2.getUi_control());
                                        cJROrderSummaryAction.setmUrlParams(next2.getUrlParams());
                                        cJROrderSummaryAction.setOrderLevel(true);
                                        cJROrderSummaryAction.setImage_url("http://assets.paytm.com/travel/flights-backend/icons/v1/order_actions/small/share_android.png");
                                        next2.setImage_url("http://assets.paytm.com/travel/flights-backend/icons/v1/order_actions/small/download_ticket.png");
                                    }
                                    next2.setOrderLevel(true);
                                }
                            }
                            if (cJROrderSummaryAction != null) {
                                next.getAction().add(cJROrderSummaryAction);
                            }
                        }
                    }
                    if (!z2) {
                        b();
                    }
                    a(cJRFlightOrderSummaryResponse);
                }
                if (getActivity().getIntent().hasExtra("intent_extra_wallet_paytm_assist_gtmevents")) {
                    this.x = (d) getActivity().getIntent().getSerializableExtra("intent_extra_wallet_paytm_assist_gtmevents");
                }
            }
            a(j().getBody().getItems());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        g();
        this.m = this.f24366b.a(this.f24371g);
        this.f24367c.clear();
        this.v.clear();
        this.f24366b.a(cJRFlightOrderSummaryResponse);
        if (a()) {
            this.p = this.o.pageRowItems(false, true);
            this.f24367c.add(d(), a.THIN_BANNER);
        }
        h();
        this.w = new c(this.f24367c, this);
        this.f24365a.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f24365a.setAdapter(this.w);
    }

    private int d() {
        int i2;
        List<a> list = this.f24367c;
        if (list != null && list.size() > 0) {
            i2 = 0;
            for (a aVar : this.f24367c) {
                i2++;
                if (aVar == a.TICKET_VARIOUS_OPTIONS) {
                    break;
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            return e() ? i2 + 1 : i2;
        }
        return 0;
    }

    private boolean e() {
        for (a aVar : this.f24367c) {
            if (aVar == a.ITEM_VIEW_HTML_BOX) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        this.v.clear();
        HashSet hashSet = new HashSet(this.f24367c);
        for (a next : this.f24367c) {
            if (hashSet.contains(next)) {
                this.v.add(next);
            }
        }
    }

    public void f() {
        ProgressBar progressBar = this.r;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void g() {
        ProgressBar progressBar = this.r;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public final int a(int i2) {
        List<a> list;
        if (this.v == null || (list = this.f24367c) == null || list.size() <= i2) {
            return -1;
        }
        return this.v.indexOf(this.f24367c.get(i2));
    }

    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        return this.f24366b.a(viewGroup, this.v.get(i2));
    }

    public void a(RecyclerView.v vVar) {
        if (vVar instanceof com.travel.flight.flightorder.f.a) {
            ((com.travel.flight.flightorder.f.a) vVar).a(this.m);
        }
    }

    public final CJRFlightOrderSummaryResponse j() {
        e eVar = this.q;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public final void a(Context context, String str) {
        if (context != null) {
            ProgressDialog progressDialog = this.f24373i;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f24373i = new ProgressDialog(context);
                try {
                    this.f24373i.setProgressStyle(0);
                    this.f24373i.setMessage(str);
                    this.f24373i.setCancelable(false);
                    this.f24373i.setCanceledOnTouchOutside(true);
                    this.f24373i.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    public final void k() {
        ProgressDialog progressDialog = this.f24373i;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f24373i.dismiss();
            this.f24373i = null;
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        g gVar;
        if (iJRPaytmDataModel instanceof CJRActionResponse) {
            CJRActionResponse cJRActionResponse = (CJRActionResponse) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(cJRActionResponse.getMessage())) {
                a(cJRActionResponse.getMessage());
            } else if (cJRActionResponse.getActions() != null) {
                ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                if (actions.size() > 0) {
                    CJROrderSummaryAction cJROrderSummaryAction = actions.get(0);
                    if (!cJROrderSummaryAction.getUi_control().equalsIgnoreCase("browser") || cJROrderSummaryAction.getUrlParams() == null || TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
                        k();
                    } else if (AnonymousClass7.f24383a[this.f24372h.ordinal()] == 1) {
                        if (cJROrderSummaryAction.getLabel().equalsIgnoreCase(TransactionType.CANCEL) && (gVar = this.f24366b) != null) {
                            gVar.h();
                        }
                        a(j().getBody().getItems());
                        com.travel.flight.flightorder.e.a aVar = this.j;
                        String order_id = j().getBody().getOrder_id();
                        aVar.f24388d = this.A;
                        aVar.f24387c = order_id;
                        String str = com.travel.flight.flightorder.e.a.f24384g;
                        q.d("handle response - " + cJROrderSummaryAction.getUrlParams().getUrl());
                        String url = cJROrderSummaryAction.getUrlParams().getUrl();
                        String title = cJRActionResponse.getTitle();
                        String str2 = com.travel.flight.flightorder.e.a.f24384g;
                        q.d("new FileLoader - with title - ".concat(String.valueOf(title)));
                        new a.C0468a(url, title).execute(new Void[0]);
                    }
                } else {
                    k();
                }
            } else if (!TextUtils.isEmpty(cJRActionResponse.getError())) {
                a(cJRActionResponse.getError());
            }
        } else if (iJRPaytmDataModel instanceof CJRNpsTrackingResponse) {
            k();
            String message = ((CJRNpsTrackingResponse) iJRPaytmDataModel).getMessage();
            if (message != null && getActivity() != null) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(1);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                dialog.setContentView(R.layout.pre_f_train_sellar_rating_custom_toast);
                ((TextView) dialog.findViewById(R.id.toast_dec_message)).setText(message);
                dialog.show();
                final Handler handler = new Handler();
                final AnonymousClass4 r1 = new Runnable() {
                    public final void run() {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                };
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        handler.removeCallbacks(r1);
                    }
                });
                handler.postDelayed(r1, 6000);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k();
        if (this.f24372h != FlightOrderSummary.a.FLIGHT) {
            return;
        }
        if (TextUtils.isEmpty(networkCustomError.getMessage()) || (!networkCustomError.getMessage().equalsIgnoreCase("410") && !networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
            if (networkCustomError.getMessage() != null && !net.one97.paytmflight.a.b.a((Context) getActivity(), (Exception) networkCustomError, "error.flights@paytm.com")) {
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message));
                    return;
                }
                FragmentActivity activity = getActivity();
                String url = networkCustomError.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(networkCustomError.getStatusCode());
                com.paytm.utility.b.d((Context) activity, url, sb.toString());
            }
        } else if (getActivity() != null && !getActivity().isFinishing()) {
            net.one97.paytmflight.a.b.a(getActivity(), networkCustomError);
        }
    }

    /* renamed from: com.travel.flight.flightorder.d.b$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24383a = new int[FlightOrderSummary.a.values().length];

        static {
            try {
                f24383a[FlightOrderSummary.a.FLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(ArrayList<CJROrderSummaryItems> arrayList) {
        Iterator<CJROrderSummaryItems> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJROrderSummaryItems next = it2.next();
            if (next != null && ("Flights".equalsIgnoreCase(next.getType()) || "Flights".equalsIgnoreCase(next.getItem_type()))) {
                a(next);
                String g2 = com.paytm.utility.b.g(next.getTravel_date(), "yyyy-MM-dd", "dd MMM");
                if (TextUtils.isEmpty(this.u)) {
                    this.A = this.f24368d.getCity() + "-" + this.f24369e.getCity() + "_" + g2;
                } else {
                    this.A = this.f24368d.getCity() + "-" + this.f24369e.getCity() + "-" + this.f24368d.getCity() + "_" + this.t + "_" + this.u;
                }
            }
        }
        com.travel.flight.flightorder.e.a aVar = this.j;
        if (aVar != null) {
            aVar.f24388d = this.A;
        }
    }

    private void a(CJROrderSummaryItems cJROrderSummaryItems) {
        CJROrderSummaryJourneyDetails journey_details;
        if (this.f24368d == null || this.f24369e == null) {
            Pair<CJROrderSummaryOrigin, CJROrderSummaryDestination> b2 = b(cJROrderSummaryItems);
            this.f24368d = (CJROrderSummaryOrigin) b2.first;
            this.f24369e = (CJROrderSummaryDestination) b2.second;
            if (cJROrderSummaryItems != null && cJROrderSummaryItems.getJourney_details() != null && (journey_details = cJROrderSummaryItems.getJourney_details()) != null && journey_details.getFlights() != null) {
                ArrayList<CJROrderSummaryFlights> flights = journey_details.getFlights();
                String f_Dir = cJROrderSummaryItems.getF_Dir();
                if (TextUtils.isEmpty(f_Dir) || (!f_Dir.equalsIgnoreCase("R") && !f_Dir.equalsIgnoreCase("OR"))) {
                    this.s = "one_way";
                } else {
                    this.s = "round_trip";
                }
                if (flights != null && flights.size() > 0) {
                    for (int i2 = 0; i2 < flights.size(); i2++) {
                        CJROrderSummaryFlights cJROrderSummaryFlights = flights.get(i2);
                        if (!(cJROrderSummaryFlights == null || cJROrderSummaryFlights.getDeparture_time_local() == null)) {
                            this.t = com.travel.flight.utils.c.c(cJROrderSummaryFlights.getDeparture_time_local());
                        }
                        if (!(cJROrderSummaryFlights == null || cJROrderSummaryFlights.getArrival_time_local() == null || !"round_trip".equalsIgnoreCase(this.s))) {
                            this.u = com.travel.flight.utils.c.c(cJROrderSummaryFlights.getArrival_time_local());
                        }
                    }
                }
            }
        }
    }

    private static Pair<CJROrderSummaryOrigin, CJROrderSummaryDestination> b(CJROrderSummaryItems cJROrderSummaryItems) {
        CJROrderSummaryDestination cJROrderSummaryDestination;
        CJROrderSummaryJourneyDetails journey_details;
        CJROrderSummaryOrigin cJROrderSummaryOrigin = null;
        if (cJROrderSummaryItems != null) {
            String f_Dir = cJROrderSummaryItems.getF_Dir();
            if (!TextUtils.isEmpty(f_Dir) && ((f_Dir.equalsIgnoreCase("O") || f_Dir.equalsIgnoreCase("OR")) && (journey_details = cJROrderSummaryItems.getJourney_details()) != null && journey_details.getFlights() != null && journey_details.getFlights().size() > 0)) {
                cJROrderSummaryOrigin = journey_details.getFlights().get(0).getOrigin();
                cJROrderSummaryDestination = journey_details.getFlights().get(journey_details.getFlights().size() - 1).getDestination();
                return new Pair<>(cJROrderSummaryOrigin, cJROrderSummaryDestination);
            }
        }
        cJROrderSummaryDestination = null;
        return new Pair<>(cJROrderSummaryOrigin, cJROrderSummaryDestination);
    }

    private void a(String str) {
        k();
        if (!this.z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    boolean unused = b.this.z = false;
                }
            });
            builder.show();
            this.z = true;
        }
    }

    public final void a(CJRActionResponse cJRActionResponse) {
        boolean z2 = false;
        if (!(cJRActionResponse == null || cJRActionResponse.getActions() == null || cJRActionResponse.getActions().size() <= 0 || j() == null)) {
            Iterator<CJROrderSummaryItems> it2 = j().getBody().getItems().iterator();
            while (it2.hasNext()) {
                CJROrderSummaryItems next = it2.next();
                if (!(next == null || next.getTap_action() == null)) {
                    CJROrderSummaryAction tap_action = next.getTap_action();
                    tap_action.setOrderLevel(true);
                    if (tap_action.getUrlParams() != null && !TextUtils.isEmpty(tap_action.getUrlParams().getUrl()) && tap_action.getUrlParams().getUrl().equalsIgnoreCase(cJRActionResponse.getRequestUrl())) {
                        ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                        if (next.getAction() == null) {
                            next.setAction(new ArrayList(actions));
                        } else {
                            next.getAction().addAll(actions);
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            f();
            Handler handler = this.l;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(2, 1000);
            }
            a(j());
        }
        b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.travel.utils.q.a(getActivity());
        com.travel.utils.q.c(getActivity());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(com.travel.flight.flightorder.d.b r4) {
        /*
            java.util.List<com.travel.flight.flightorder.d.b$a> r0 = r4.f24367c
            r1 = 0
            if (r0 == 0) goto L_0x0023
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0023
            java.util.List<com.travel.flight.flightorder.d.b$a> r0 = r4.f24367c
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r0.next()
            com.travel.flight.flightorder.d.b$a r2 = (com.travel.flight.flightorder.d.b.a) r2
            com.travel.flight.flightorder.d.b$a r3 = com.travel.flight.flightorder.d.b.a.THIN_BANNER
            if (r2 != r3) goto L_0x0011
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            java.util.List<net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2> r2 = r4.p
            if (r2 == 0) goto L_0x002f
            int r2 = r2.size()
            if (r2 > 0) goto L_0x002f
            r0 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x004e
            r4.f()
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r0 = r4.j()
            r4.a((com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse) r0)
            android.os.Handler r0 = r4.l
            if (r0 == 0) goto L_0x004e
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            r1 = 4
            r0.what = r1
            android.os.Handler r4 = r4.l
            r1 = 1000(0x3e8, double:4.94E-321)
            r4.sendMessageDelayed(r0, r1)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.d.b.c(com.travel.flight.flightorder.d.b):void");
    }

    static /* synthetic */ boolean f(b bVar) {
        if (System.currentTimeMillis() - bVar.C <= 1000) {
            return false;
        }
        bVar.C = System.currentTimeMillis();
        return true;
    }
}
