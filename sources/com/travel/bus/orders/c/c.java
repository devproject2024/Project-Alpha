package com.travel.bus.orders.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.i.o;
import com.travel.bus.orders.a.d;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.d.a;
import com.travel.bus.orders.f.f;
import com.travel.bus.orders.f.i;
import com.travel.bus.orders.f.j;
import com.travel.bus.pojo.busticket.CJRBusFrontBanners;
import com.travel.bus.pojo.busticket.CJRBusNpsTrackingResponse;
import com.travel.bus.pojo.busticket.CJRBusOperatorDetails;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryRating;
import com.travel.bus.pojo.busticket.CJRBusRefundDetails;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends h implements com.paytm.network.listener.b, i {

    /* renamed from: a  reason: collision with root package name */
    private static long f22593a;
    protected ArrayList<CJRHomePageLayoutV2> A;
    private CJRHomePageDetailV2 B;
    /* access modifiers changed from: private */
    public Fragment C;
    private long D;
    private com.travel.g.b E = new com.travel.g.b() {
    };

    /* renamed from: b  reason: collision with root package name */
    private List<a> f22594b;

    /* renamed from: c  reason: collision with root package name */
    private int f22595c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f22596d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22597e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22598f = false;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f22599g;

    /* renamed from: h  reason: collision with root package name */
    public com.travel.bus.orders.d.a f22600h;

    /* renamed from: i  reason: collision with root package name */
    protected RecyclerView f22601i;
    protected d j;
    protected BusOrderSummary.a k;
    j l;
    /* access modifiers changed from: package-private */
    public com.travel.bus.orders.f.h m;
    List<a> n;
    /* access modifiers changed from: package-private */
    public String o;
    public f p;
    b q;
    protected TextView r;
    protected Toolbar s;
    protected AppCompatImageView t;
    protected TextView u;
    protected NestedScrollView v;
    protected boolean w = false;
    protected boolean x = false;
    protected String y = "";
    /* access modifiers changed from: package-private */
    public Handler z = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!c.this.isDetached()) {
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2) {
                        c cVar = c.this;
                        cVar.c(cVar.g());
                        if (c.this.f22596d && c.this.z != null) {
                            c.this.z.postDelayed(new Runnable() {
                                public final void run() {
                                    if (!c.e(c.this)) {
                                        c.this.b();
                                        c.this.h();
                                        if (c.this.j != null) {
                                            c.this.j.notifyDataSetChanged();
                                        }
                                        c.this.f();
                                    }
                                }
                            }, 1000);
                        }
                    }
                } else if (c.this.m != null && !TextUtils.isEmpty(c.this.o)) {
                    c.this.m.a(c.this.o);
                }
            }
        }
    };

    public enum a {
        HEADER,
        PASSENGER_DESC_CARD_ONGOING,
        PAYMENT_DETAILS,
        CASHBACK_DETAILS,
        REFUND_SUMMARY,
        HOTEL_OPTIONS,
        FOOTER,
        CANCEL_PROTECT,
        BUS_NPS_WIDGET,
        BUS_RATING_WIDGET,
        TRAVEL_BUDDY_BANNER,
        PASSENER_CARD_LIST,
        ENDLESS_THIN_BANNER,
        THIN_BANNER
    }

    public enum b {
        PAYMENT_SUCCESS,
        PAYMENT_FAILED,
        PAYMENT_PENDING,
        BOOKING_PENDING,
        BOOKING_SUCCESSFUL,
        BOOKING_FAILED,
        NO_OP
    }

    /* access modifiers changed from: protected */
    public NestedScrollView.b a() {
        return null;
    }

    public void a(CJRBusFrontBanners cJRBusFrontBanners) {
    }

    public void a(CJRBusOperatorDetails cJRBusOperatorDetails) {
    }

    public void a(CJRBusOrderSummaryRating cJRBusOrderSummaryRating) {
    }

    public void a(CJRBusRefundDetails cJRBusRefundDetails) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bus_new_order_summary, (ViewGroup) null);
        this.s = (Toolbar) inflate.findViewById(R.id.toolbar);
        this.t = (AppCompatImageView) inflate.findViewById(R.id.background_image_view);
        this.r = (TextView) inflate.findViewById(R.id.bus_booking_id);
        this.f22601i = (RecyclerView) inflate.findViewById(R.id.recycler_view_order_summary);
        this.f22601i.setNestedScrollingEnabled(false);
        this.f22599g = (RelativeLayout) inflate.findViewById(R.id.lyt_progress_bar);
        this.u = (TextView) inflate.findViewById(R.id.traveller_booked_info);
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT >= 21) {
            getActivity().getWindow().setStatusBarColor(0);
            getActivity().getWindow().getDecorView().setSystemUiVisibility(1280);
            Toolbar toolbar = this.s;
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            toolbar.setPadding(0, identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0, 0, 0);
        }
        this.v = (NestedScrollView) inflate.findViewById(R.id.nestedScrollView);
        ResourceUtils.loadBusImagesFromCDN(this.t, "order_summary_header_image.png", false, false, n.a.V1);
        this.v.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (c.this.v.getChildAt(c.this.v.getChildCount() - 1).getBottom() - (c.this.v.getHeight() + c.this.v.getScrollY()) == 0 && c.this.C != null && c.i(c.this)) {
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a(c.this.C);
                }
            }
        });
        ((ImageView) inflate.findViewById(R.id.toolbar_btn_layout)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
        NestedScrollView.b a2 = a();
        if (a2 != null) {
            this.v.setOnScrollChangeListener(a2);
        }
        this.k = (BusOrderSummary.a) getArguments().getSerializable("VERTICAL");
        this.f22600h = new com.travel.bus.orders.d.a(getActivity(), this);
        this.m = new com.travel.bus.orders.g.a(getActivity());
        this.m.a((i) this);
        this.f22595c = 0;
        if (getArguments() != null) {
            this.o = getArguments().getString("order_id", (String) null);
            this.f22596d = getArguments().getBoolean("is_from_pg_page", false);
        }
        if (TextUtils.isEmpty(this.o)) {
            ((BusOrderSummary) getActivity()).showErrorMessage();
        } else {
            this.m.a(this.o);
        }
        this.n = new ArrayList();
        this.f22594b = new ArrayList();
        this.D = System.currentTimeMillis();
        f22593a = 10000;
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2> r0 = r6.A
            if (r0 == 0) goto L_0x005e
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x005e
            java.util.List<com.travel.bus.orders.c.c$a> r0 = r6.n
            boolean r1 = r6.f22596d
            r2 = 0
            if (r1 == 0) goto L_0x0033
            if (r0 == 0) goto L_0x0055
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0055
            java.util.List<com.travel.bus.orders.c.c$a> r1 = r6.n
            java.util.Iterator r1 = r1.iterator()
            r3 = 0
        L_0x0020:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r1.next()
            com.travel.bus.orders.c.c$a r4 = (com.travel.bus.orders.c.c.a) r4
            com.travel.bus.orders.c.c$a r5 = com.travel.bus.orders.c.c.a.PASSENGER_DESC_CARD_ONGOING
            if (r4 == r5) goto L_0x0056
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0033:
            if (r0 == 0) goto L_0x0055
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0055
            java.util.List<com.travel.bus.orders.c.c$a> r1 = r6.n
            java.util.Iterator r1 = r1.iterator()
            r3 = 0
        L_0x0042:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r1.next()
            com.travel.bus.orders.c.c$a r4 = (com.travel.bus.orders.c.c.a) r4
            com.travel.bus.orders.c.c$a r5 = com.travel.bus.orders.c.c.a.PAYMENT_DETAILS
            if (r4 == r5) goto L_0x0056
            int r3 = r3 + 1
            goto L_0x0042
        L_0x0055:
            r3 = 0
        L_0x0056:
            if (r3 <= 0) goto L_0x0059
            r2 = r3
        L_0x0059:
            com.travel.bus.orders.c.c$a r1 = com.travel.bus.orders.c.c.a.THIN_BANNER
            r0.add(r2, r1)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.c.c.b():void");
    }

    private void c() {
        if (this.C == null) {
            com.travel.bus.a.a();
            String a2 = com.travel.bus.a.b().a("busStoreFrontUrlOrderSummary", "");
            Bundle bundle = new Bundle();
            com.travel.bus.a.a();
            this.C = com.travel.bus.a.b().a(this.E);
            bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle.putString("origin", "bus");
            bundle.putString("EXTRA_STORE_FRONT_ALTERNATE_URL", a2);
            bundle.putString("store_front_url_key", "bus");
            this.C.setArguments(bundle);
            getChildFragmentManager();
            getChildFragmentManager().a().a(R.id.framelayout_storefront, this.C, "endLessScroll").c();
        }
    }

    private boolean d() {
        CJRHomePageDetailV2 cJRHomePageDetailV2 = this.B;
        return (cJRHomePageDetailV2 == null || cJRHomePageDetailV2.getHomePageLayoutList() == null || this.B.getHomePageLayoutList().size() <= 0) ? false : true;
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.travel.bus.orders.f.h hVar = this.m;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.l == null) {
            throw new IllegalStateException("Event Listener Not Registered. Please register Event Listener first");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().onBackPressed();
    }

    public final void b(CJRBusOrderSummary cJRBusOrderSummary) {
        boolean z2 = false;
        if (cJRBusOrderSummary != null) {
            try {
                if (cJRBusOrderSummary.getCreatedAt() != null) {
                    String b2 = o.b(cJRBusOrderSummary.getCreatedAt());
                    if (this.u != null) {
                        this.u.setText(getString(R.string.bus_order_summary_booked_date, b2));
                    }
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
                return;
            }
        }
        if (this.l != null) {
            if (cJRBusOrderSummary != null) {
                Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
                while (it2.hasNext()) {
                    CJRBusOrderedCart next = it2.next();
                    if (!(next == null || next.getTapAction() == null)) {
                        this.m.a(next.getTapAction());
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                c();
            }
            c(cJRBusOrderSummary);
            if (this.p != null) {
                this.p.onViewCreated();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(CJRBusOrderSummary cJRBusOrderSummary) {
        String isRoundTrip;
        f();
        this.q = this.l.a(this.f22596d);
        if (!(this.f22595c >= 3 || this.q == b.PAYMENT_FAILED || this.q == b.PAYMENT_SUCCESS || this.q == b.BOOKING_SUCCESSFUL || this.q == b.BOOKING_FAILED)) {
            this.z.sendEmptyMessageDelayed(1, f22593a);
            this.f22595c++;
        }
        this.n.clear();
        this.f22594b.clear();
        this.x = false;
        if (this.k == BusOrderSummary.a.BUS) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next)) {
                    Object metaDataResponse = next.getMetaDataResponse();
                    com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                    CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse = (CJRBusOrderSummaryMetaDataResponse) fVar.a(fVar.a(metaDataResponse), CJRBusOrderSummaryMetaDataResponse.class);
                    if (!(cJRBusOrderSummaryMetaDataResponse == null || (isRoundTrip = cJRBusOrderSummaryMetaDataResponse.getIsRoundTrip()) == null || !isRoundTrip.equals("1.0"))) {
                        z2 = true;
                    }
                }
            }
            if (!z2 || this.f22598f) {
                this.l.a(cJRBusOrderSummary);
            } else {
                Intent intent = new Intent();
                intent.putExtra(UpiConstants.FROM, "Order_history");
                intent.putExtra("order_id", this.o);
                this.f22598f = true;
                com.travel.bus.a.a();
                com.travel.bus.a.b().b((Context) getActivity(), intent);
                getActivity().finish();
            }
        } else {
            this.l.a(cJRBusOrderSummary);
        }
        if (!this.f22596d && this.B != null && d()) {
            this.A = this.B.pageRowItems(false, true);
            b();
        }
        if (d(g())) {
            List<a> list = this.n;
            if (list != null && list.size() > 0 && this.n.contains(a.HOTEL_OPTIONS)) {
                this.n.remove(a.HOTEL_OPTIONS);
            }
            a(this.n);
        }
        h();
        if (getActivity() != null) {
            this.j = new d(this.n, this);
            this.f22601i.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.f22601i.setAdapter(this.j);
        }
    }

    public static boolean d(CJRBusOrderSummary cJRBusOrderSummary) {
        if (!(cJRBusOrderSummary == null || cJRBusOrderSummary.getOrderedCartList() == null || cJRBusOrderSummary.getOrderedCartList().size() <= 0)) {
            Iterator<CJRBusOrderedCart> it2 = cJRBusOrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (com.travel.bus.orders.h.b.b(next) && Integer.parseInt(next.getItemStatus()) != 18) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(CJRActionResponse cJRActionResponse) {
        boolean z2 = false;
        if (!(cJRActionResponse == null || cJRActionResponse.getActions() == null || cJRActionResponse.getActions().size() <= 0 || g() == null)) {
            Iterator<CJRBusOrderedCart> it2 = g().getOrderedCartList().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                CJRBusOrderedCart next = it2.next();
                if (!(next == null || next.getTapAction() == null)) {
                    CJROrderSummaryAction tapAction = next.getTapAction();
                    if (tapAction.getUrlParams() != null && !TextUtils.isEmpty(tapAction.getUrlParams().getUrl()) && tapAction.getUrlParams().getUrl().equalsIgnoreCase(cJRActionResponse.getRequestUrl())) {
                        ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                        if (this.k == BusOrderSummary.a.BUS) {
                            for (CJROrderSummaryAction orderLevel : actions) {
                                orderLevel.setOrderLevel(Boolean.TRUE);
                            }
                        }
                        CJROrderSummaryAction cJROrderSummaryAction = null;
                        for (CJROrderSummaryAction next2 : actions) {
                            if (next2.getLabel().equalsIgnoreCase("Download Tickets")) {
                                actions.remove(next2);
                                cJROrderSummaryAction = next2;
                            }
                        }
                        if (cJROrderSummaryAction != null) {
                            actions.add(0, cJROrderSummaryAction);
                        }
                        next.setAction(new ArrayList(actions));
                        z3 = true;
                    }
                }
            }
            z2 = z3;
        }
        if (z2) {
            this.z.sendEmptyMessageDelayed(2, 1000);
        }
        c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        String string;
        super.onActivityResult(i2, i3, intent);
        if (intent != null && (extras = intent.getExtras()) != null && (string = extras.getString("title")) != null && string.equalsIgnoreCase("Cancel Tickets")) {
            this.m.a(this.o);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        HashSet hashSet = new HashSet(this.n);
        for (a next : this.n) {
            if (hashSet.contains(next)) {
                this.f22594b.add(next);
            }
        }
    }

    public final void e() {
        RelativeLayout relativeLayout = this.f22599g;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    public final void f() {
        RelativeLayout relativeLayout = this.f22599g;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public final void a(List<a> list) {
        this.n = list;
        h();
        d dVar = this.j;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    public final int a(int i2) {
        List<a> list;
        if (this.f22594b == null || (list = this.n) == null || list.size() <= i2) {
            return -1;
        }
        return this.f22594b.indexOf(this.n.get(i2));
    }

    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        return this.l.a(viewGroup, this.f22594b.get(i2));
    }

    public void a(RecyclerView.v vVar) {
        if (vVar instanceof com.travel.bus.orders.e.a) {
            ((com.travel.bus.orders.e.a) vVar).a(this.q);
        }
    }

    public final CJRBusOrderSummary g() {
        com.travel.bus.orders.f.h hVar = this.m;
        if (hVar == null) {
            return null;
        }
        return hVar.c();
    }

    public final void a(String str, Map<String, String> map, String str2, IJRPaytmDataModel iJRPaytmDataModel, a.C0715a aVar) {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = getActivity();
        bVar.f42878b = a.c.BUS;
        bVar.f42879c = aVar;
        bVar.f42880d = str;
        bVar.f42884h = str2;
        bVar.f42881e = null;
        bVar.f42882f = map;
        bVar.f42883g = null;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.j = this;
        bVar.t = i();
        bVar.n = a.b.SILENT;
        bVar.o = "bus-order-summary-page";
        bVar.l().a();
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusOrderSummaryScreen");
            if (!(g() == null || g().getId() == null)) {
                jSONObject.put("order_id", g().getId());
            }
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    private void a(String str) {
        if (getActivity() != null && !isDetached() && !getActivity().isFinishing() && isAdded() && str != null) {
            Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.setContentView(R.layout.pre_b_train_sellar_rating_custom_toast);
            ResourceUtils.loadBusImagesFromCDN((ImageView) dialog.findViewById(R.id.success_icon), "success.png", false, true, n.a.V1);
            ((TextView) dialog.findViewById(R.id.toast_dec_message)).setText(str);
            dialog.show();
            Handler handler = new Handler();
            $$Lambda$c$26xTKdpIIEEy0ZQpf1UGHQRSqyg r1 = new Runnable(dialog) {
                private final /* synthetic */ Dialog f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    c.a(this.f$0);
                }
            };
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener(handler, r1) {
                private final /* synthetic */ Handler f$0;
                private final /* synthetic */ Runnable f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.removeCallbacks(this.f$1);
                }
            });
            handler.postDelayed(r1, 6000);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Dialog dialog) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.travel.bus.orders.c.c$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22606a = new int[BusOrderSummary.a.values().length];

        static {
            try {
                f22606a[BusOrderSummary.a.BUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onPause() {
        com.travel.bus.orders.d.a aVar = this.f22600h;
        if (!(aVar == null || aVar.f22608a == null)) {
            aVar.f22608a.isFinishing();
        }
        super.onPause();
    }

    private void b(String str) {
        this.w = false;
        f();
        if (!this.f22597e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    c.this.a(dialogInterface, i2);
                }
            });
            builder.show();
            this.f22597e = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        this.f22597e = false;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusFrontBanners) {
            a((CJRBusFrontBanners) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRBusNpsTrackingResponse) {
            a(((CJRBusNpsTrackingResponse) iJRPaytmDataModel).getMessage());
        } else if (iJRPaytmDataModel instanceof CJRBusRefundDetails) {
            a((CJRBusRefundDetails) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRBusOperatorDetails) {
            a((CJRBusOperatorDetails) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRBusOrderSummaryRating) {
            a((CJRBusOrderSummaryRating) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
            CJRActionResponse cJRActionResponse = (CJRActionResponse) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(cJRActionResponse.getMessage())) {
                b(cJRActionResponse.getMessage());
            } else if (cJRActionResponse.getActions() != null) {
                ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                if (actions.size() > 0) {
                    CJROrderSummaryAction cJROrderSummaryAction = actions.get(0);
                    if (cJROrderSummaryAction.getUiControl().equalsIgnoreCase("browser") && cJROrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
                        this.w = false;
                        f();
                        if (AnonymousClass4.f22606a[this.k.ordinal()] == 1) {
                            com.travel.bus.orders.d.a aVar = this.f22600h;
                            String id = g().getId();
                            aVar.f22611d = "";
                            aVar.f22610c = id;
                            String str = com.travel.bus.orders.d.a.f22607g;
                            q.d("handle response - " + cJROrderSummaryAction.getUrlParams().getUrl());
                            String url = cJROrderSummaryAction.getUrlParams().getUrl();
                            String title = cJRActionResponse.getTitle();
                            String str2 = com.travel.bus.orders.d.a.f22607g;
                            q.d("new FileLoader - with title - ".concat(String.valueOf(title)));
                            new a.C0441a(url, title).execute(new Void[0]);
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(cJRActionResponse.getError())) {
                b(cJRActionResponse.getError());
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.w = false;
        f();
        if (networkCustomError != null && (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403)) {
            com.travel.bus.a.a();
            com.travel.bus.a.b().a((Activity) getActivity());
        } else if (iJRPaytmDataModel instanceof CJRBusRefundDetails) {
            com.paytm.utility.b.a((Context) getActivity(), "We are unable to get cancellation policy for the operator. Plesae try again later.", false);
        } else if (iJRPaytmDataModel instanceof CJRBusNpsTrackingResponse) {
            a(getString(R.string.sumbit_feedback_error));
        } else if (!(iJRPaytmDataModel instanceof CJRBusOrderSummaryRating) && networkCustomError != null && networkCustomError.getMessage() != null) {
            if (networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401) || networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401) {
                com.travel.bus.a.a();
                com.travel.g.a b2 = com.travel.bus.a.b();
                FragmentActivity activity = getActivity();
                com.travel.bus.a.a();
                com.travel.bus.a.b().b();
                b2.a((Activity) activity, networkCustomError);
            } else if (networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                com.paytm.utility.b.d((Context) getActivity(), networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
            } else if (getActivity() != null && isAdded()) {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean e(com.travel.bus.orders.c.c r4) {
        /*
            java.util.List<com.travel.bus.orders.c.c$a> r0 = r4.n
            r1 = 0
            if (r0 == 0) goto L_0x0023
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0023
            java.util.List<com.travel.bus.orders.c.c$a> r0 = r4.n
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r0.next()
            com.travel.bus.orders.c.c$a r2 = (com.travel.bus.orders.c.c.a) r2
            com.travel.bus.orders.c.c$a r3 = com.travel.bus.orders.c.c.a.THIN_BANNER
            if (r2 != r3) goto L_0x0011
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2> r4 = r4.A
            if (r4 == 0) goto L_0x002f
            int r4 = r4.size()
            if (r4 > 0) goto L_0x002f
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.c.c.e(com.travel.bus.orders.c.c):boolean");
    }

    static /* synthetic */ boolean i(c cVar) {
        if (System.currentTimeMillis() - cVar.D <= 1000) {
            return false;
        }
        cVar.D = System.currentTimeMillis();
        return true;
    }
}
