package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.metro.a.c;
import net.one97.paytm.recharge.metro.a.i;
import net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity;
import net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.metro.widget.CustomHeightWrappingViewPager;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class g extends f implements View.OnClickListener, c.a {

    /* renamed from: a  reason: collision with root package name */
    private d f63335a;

    /* renamed from: b  reason: collision with root package name */
    private Context f63336b;

    /* renamed from: c  reason: collision with root package name */
    private String f63337c;

    /* renamed from: d  reason: collision with root package name */
    private CustomHeightWrappingViewPager f63338d;

    /* renamed from: e  reason: collision with root package name */
    private TabLayout f63339e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f63340f;

    /* renamed from: g  reason: collision with root package name */
    private View f63341g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.recharge.metro.a.c f63342h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f63343i;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    private boolean m;
    private boolean n;
    private Handler o;
    private String p;
    private String q;
    private d r;
    private int s = net.one97.paytm.recharge.metro.f.c.f63581f;
    private boolean t;
    private String u = "";
    private HashMap v;

    public g() {
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
    }

    public static final /* synthetic */ Handler d(g gVar) {
        Handler handler = gVar.o;
        if (handler == null) {
            k.a("mHandler");
        }
        return handler;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        boolean z = false;
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.r = new d(context);
        }
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), "mumbai metro qr", "qr_popup", "", "", "", "utility");
        } catch (Throwable unused) {
        }
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.getSerializable("activeMetroTickets") != null) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                this.f63337c = arguments2.getString(StringSet.operator);
                if (!TextUtils.isEmpty(this.f63337c)) {
                    Bundle arguments3 = getArguments();
                    if (arguments3 == null) {
                        k.a();
                    }
                    arguments3.getBoolean("show_single_tickets");
                    Bundle arguments4 = getArguments();
                    if (arguments4 == null || (str = arguments4.getString("vertical_name")) == null) {
                        str = "";
                    }
                    this.u = str;
                    Bundle arguments5 = getArguments();
                    if (arguments5 == null) {
                        k.a();
                    }
                    if (arguments5.containsKey("is_cancellable")) {
                        Bundle arguments6 = getArguments();
                        if (arguments6 != null) {
                            z = arguments6.getBoolean("is_cancellable");
                        }
                        this.t = z;
                    }
                    Bundle arguments7 = getArguments();
                    if (arguments7 == null) {
                        k.a();
                    }
                    this.p = arguments7.getString("metroTicketVariant");
                    Bundle arguments8 = getArguments();
                    if (arguments8 == null) {
                        k.a();
                    }
                    this.q = arguments8.getString("metro_request_type");
                    Bundle arguments9 = getArguments();
                    if (arguments9 == null) {
                        k.a();
                    }
                    this.m = arguments9.getBoolean("show_single_tickets");
                    Bundle arguments10 = getArguments();
                    if (arguments10 == null) {
                        k.a();
                    }
                    this.n = arguments10.getBoolean("has_Penalty_tickets");
                    return;
                }
                throw new RuntimeException("Ticket-QR-Codes title expected");
            }
            throw new RuntimeException("Ticket expected");
        }
        throw new RuntimeException("Argument expected");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f63341g = layoutInflater.inflate(R.layout.bottom_sheet_mm_qr_ticket, viewGroup, false);
        return this.f63341g;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2 = view;
        k.c(view2, "rootView");
        View findViewById = view2.findViewById(R.id.txt_journey_type);
        if (findViewById != null) {
            this.f63343i = (TextView) findViewById;
            View findViewById2 = view2.findViewById(R.id.multi_ticket_journey_layout);
            if (findViewById2 != null) {
                this.j = (LinearLayout) findViewById2;
                View findViewById3 = view2.findViewById(R.id.qr_forward_journey);
                if (findViewById3 != null) {
                    this.k = (TextView) findViewById3;
                    View findViewById4 = view2.findViewById(R.id.qr_return_journey);
                    if (findViewById4 != null) {
                        this.l = (TextView) findViewById4;
                        this.o = new Handler();
                        Bundle arguments = getArguments();
                        if (arguments == null) {
                            k.a();
                        }
                        Serializable serializable = arguments.getSerializable("activeMetroTickets");
                        x.c cVar = new x.c();
                        cVar.element = 0;
                        this.f63336b = getContext();
                        if (serializable instanceof List) {
                            List<CJRActiveMetroTicketModel> list = (List) serializable;
                            Iterable iterable = list;
                            Collection arrayList = new ArrayList();
                            Iterator it2 = iterable.iterator();
                            while (true) {
                                boolean z = true;
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next = it2.next();
                                CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) next;
                                if (!c.e.OUTWARD.getValue().equals(cJRActiveMetroTicketModel.getType()) && !c.e.SJT.getValue().equals(cJRActiveMetroTicketModel.getType()) && !c.e.OUTWARD.getValue().equals(cJRActiveMetroTicketModel.getSubType()) && !c.e.SJT.getValue().equals(cJRActiveMetroTicketModel.getSubType())) {
                                    z = false;
                                }
                                if (z) {
                                    arrayList.add(next);
                                }
                            }
                            List<CJRActiveMetroTicketModel> list2 = (List) arrayList;
                            Collection arrayList2 = new ArrayList();
                            for (Object next2 : iterable) {
                                CJRActiveMetroTicketModel cJRActiveMetroTicketModel2 = (CJRActiveMetroTicketModel) next2;
                                if (c.e.RETURN.getValue().equals(cJRActiveMetroTicketModel2.getType()) || c.e.RJT.getValue().equals(cJRActiveMetroTicketModel2.getType()) || c.e.RETURN.getValue().equals(cJRActiveMetroTicketModel2.getSubType()) || c.e.RJT.getValue().equals(cJRActiveMetroTicketModel2.getSubType())) {
                                    arrayList2.add(next2);
                                }
                            }
                            List list3 = (List) arrayList2;
                            if (!this.n && (list2.size() > 0 || list3.size() > 0)) {
                                Collection arrayList3 = new ArrayList();
                                for (Object next3 : iterable) {
                                    if (c.e.PENALTY.getValue().equals(((CJRActiveMetroTicketModel) next3).getType())) {
                                        arrayList3.add(next3);
                                    }
                                }
                                this.n = ((List) arrayList3).size() > 0;
                            }
                            if (list.size() <= 1 || list2.size() <= 0 || list3.size() <= 0) {
                                for (CJRActiveMetroTicketModel qrCodes : list) {
                                    cVar.element += qrCodes.getQrCodes().size();
                                }
                                this.f63342h = new net.one97.paytm.recharge.metro.a.d(getContext(), list, this.f63337c, this.n, this.p, this.t, this);
                                b((CJRActiveMetroTicketModel) list.get(0));
                            } else {
                                for (CJRActiveMetroTicketModel qrCodes2 : list2) {
                                    cVar.element += qrCodes2.getQrCodes().size();
                                }
                                this.f63342h = new net.one97.paytm.recharge.metro.a.d(getContext(), list2, this.f63337c, this.n, this.p, this.t, this);
                                TextView textView = this.f63343i;
                                if (textView != null) {
                                    textView.setVisibility(8);
                                }
                                LinearLayout linearLayout = this.j;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
                                }
                                TextView textView2 = this.k;
                                if (textView2 != null) {
                                    textView2.setSelected(true);
                                }
                                TextView textView3 = this.k;
                                if (textView3 != null) {
                                    textView3.setOnClickListener(new b(this, cVar, list2, view2));
                                }
                                TextView textView4 = this.l;
                                if (textView4 != null) {
                                    textView4.setOnClickListener(new c(this, cVar, list3, view2));
                                }
                            }
                            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                            this.s = c.a.a((CJRActiveMetroTicketModel) list.get(0));
                        } else if (serializable != null) {
                            CJRActiveMetroTicketModel cJRActiveMetroTicketModel3 = (CJRActiveMetroTicketModel) serializable;
                            this.f63342h = new net.one97.paytm.recharge.metro.a.c(getContext(), cJRActiveMetroTicketModel3, this.f63337c, this.n, this.p, this.t, this);
                            cVar.element = cJRActiveMetroTicketModel3.getQrCodes().size();
                            b(cJRActiveMetroTicketModel3);
                            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                            this.s = c.a.a(cJRActiveMetroTicketModel3);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel");
                        }
                        ((ImageView) view2.findViewById(R.id.iv_close_bottom_sheet)).setOnClickListener(this);
                        a(view2, cVar.element);
                        d dVar = this.r;
                        if (dVar != null) {
                            c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
                            String a2 = c.a.a(this.q);
                            c.a aVar4 = net.one97.paytm.recharge.metro.f.c.f63576a;
                            String a3 = c.a.a(this.s);
                            String str = ab.f61496a;
                            k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
                            d.a(dVar, a2, "view_ticket_popup_loaded", (Object) null, a3, str, (Object) null, (Object) null, 100);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f63345a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.c f63346b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63347c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f63348d;

        b(g gVar, x.c cVar, List list, View view) {
            this.f63345a = gVar;
            this.f63346b = cVar;
            this.f63347c = list;
            this.f63348d = view;
        }

        public final void onClick(View view) {
            TextView a2 = this.f63345a.l;
            if (a2 != null) {
                a2.setSelected(false);
            }
            TextView b2 = this.f63345a.k;
            if (b2 != null) {
                b2.setSelected(true);
            }
            this.f63346b.element = 0;
            for (CJRActiveMetroTicketModel qrCodes : this.f63347c) {
                this.f63346b.element += qrCodes.getQrCodes().size();
            }
            net.one97.paytm.recharge.metro.a.c c2 = this.f63345a.f63342h;
            if (c2 != null) {
                ((net.one97.paytm.recharge.metro.a.d) c2).a((List<CJRActiveMetroTicketModel>) this.f63347c);
                g.d(this.f63345a).postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f63349a;

                    {
                        this.f63349a = r1;
                    }

                    public final void run() {
                        g gVar = this.f63349a.f63345a;
                        View view = this.f63349a.f63348d;
                        if (view == null) {
                            k.a();
                        }
                        gVar.a(view, this.f63349a.f63346b.element);
                    }
                }, 100);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.adapter.CJRMetroQrCodeTicketAdapter");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f63350a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.c f63351b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63352c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f63353d;

        c(g gVar, x.c cVar, List list, View view) {
            this.f63350a = gVar;
            this.f63351b = cVar;
            this.f63352c = list;
            this.f63353d = view;
        }

        public final void onClick(View view) {
            TextView b2 = this.f63350a.k;
            if (b2 != null) {
                b2.setSelected(false);
            }
            TextView a2 = this.f63350a.l;
            if (a2 != null) {
                a2.setSelected(true);
            }
            this.f63351b.element = 0;
            for (CJRActiveMetroTicketModel qrCodes : this.f63352c) {
                this.f63351b.element += qrCodes.getQrCodes().size();
            }
            net.one97.paytm.recharge.metro.a.c c2 = this.f63350a.f63342h;
            if (c2 != null) {
                ((net.one97.paytm.recharge.metro.a.d) c2).a((List<CJRActiveMetroTicketModel>) this.f63352c);
                g.d(this.f63350a).postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f63354a;

                    {
                        this.f63354a = r1;
                    }

                    public final void run() {
                        g gVar = this.f63354a.f63350a;
                        View view = this.f63354a.f63353d;
                        if (view == null) {
                            k.a();
                        }
                        gVar.a(view, this.f63354a.f63351b.element);
                    }
                }, 100);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.adapter.CJRMetroQrCodeTicketAdapter");
        }
    }

    private final void b(CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        if (p.a(c.e.STORE_VALUE.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.e.SVP.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.e.STORE_VALUE.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.e.SVP.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.e.TRIP_PASS.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.e.TP.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.e.TRIP_PASS.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.e.TP.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.b.TRIPPASS.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.b.TRIPPASS_10.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.b.TRIPPASS_30.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.b.TRIPPASS_45.getValue(), cJRActiveMetroTicketModel.getSubType(), true) || p.a(c.b.TRIPPASS.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.b.TRIPPASS_10.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.b.TRIPPASS_30.getValue(), cJRActiveMetroTicketModel.getProductType(), true) || p.a(c.b.TRIPPASS_45.getValue(), cJRActiveMetroTicketModel.getProductType(), true)) {
            TextView textView = this.f63343i;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView2 = this.f63343i;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (!c.e.OUTWARD.getValue().equals(cJRActiveMetroTicketModel.getProductType()) && !c.e.SJT.getValue().equals(cJRActiveMetroTicketModel.getProductType()) && !c.e.OUTWARD.getValue().equals(cJRActiveMetroTicketModel.getSubType()) && !c.e.SJT.getValue().equals(cJRActiveMetroTicketModel.getSubType())) {
            TextView textView3 = this.f63343i;
            if (textView3 != null) {
                textView3.setText(getString(R.string.mm_qr_return_ticket));
            }
        } else if (this.m) {
            TextView textView4 = this.f63343i;
            if (textView4 != null) {
                textView4.setText(getString(R.string.fwd_journey_ticket));
            }
        } else {
            TextView textView5 = this.f63343i;
            if (textView5 != null) {
                textView5.setText(getString(R.string.mm_qr_forward_ticket));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(View view, int i2) {
        if (view == null) {
            k.a();
        }
        View findViewById = view.findViewById(R.id.tabs);
        if (findViewById != null) {
            this.f63339e = (TabLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.viewPager);
            if (findViewById2 != null) {
                this.f63338d = (CustomHeightWrappingViewPager) findViewById2;
                CustomHeightWrappingViewPager customHeightWrappingViewPager = this.f63338d;
                if (customHeightWrappingViewPager == null) {
                    k.a();
                }
                customHeightWrappingViewPager.setAdapter(this.f63342h);
                CustomHeightWrappingViewPager customHeightWrappingViewPager2 = this.f63338d;
                if (customHeightWrappingViewPager2 == null) {
                    k.a();
                }
                customHeightWrappingViewPager2.setPageTransformer(true, new i());
                CustomHeightWrappingViewPager customHeightWrappingViewPager3 = this.f63338d;
                if (customHeightWrappingViewPager3 == null) {
                    k.a();
                }
                customHeightWrappingViewPager3.setCurrentItem(0);
                CustomHeightWrappingViewPager customHeightWrappingViewPager4 = this.f63338d;
                if (customHeightWrappingViewPager4 == null) {
                    k.a();
                }
                customHeightWrappingViewPager4.setOffscreenPageLimit(Math.min(3, i2));
                if (i2 > 1) {
                    TabLayout tabLayout = this.f63339e;
                    if (tabLayout == null) {
                        k.a();
                    }
                    tabLayout.setVisibility(0);
                    TabLayout tabLayout2 = this.f63339e;
                    if (tabLayout2 == null) {
                        k.a();
                    }
                    tabLayout2.setupWithViewPager(this.f63338d);
                } else {
                    TabLayout tabLayout3 = this.f63339e;
                    if (tabLayout3 == null) {
                        k.a();
                    }
                    tabLayout3.setVisibility(8);
                }
                this.f63340f = new Bundle();
                Bundle bundle = this.f63340f;
                if (bundle == null) {
                    k.a();
                }
                bundle.putString(StringSet.operator, this.f63337c);
                if (getContext() != null) {
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    Fragment instantiate = Fragment.instantiate(context, d.class.getName(), this.f63340f);
                    if (instantiate != null) {
                        this.f63335a = (d) instantiate;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMetroCancelPassBottomSheetFragment");
                    }
                }
                TabLayout tabLayout4 = this.f63339e;
                if (tabLayout4 != null) {
                    tabLayout4.a((TabLayout.b) new a(this));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.widget.CustomHeightWrappingViewPager");
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
    }

    public static final class a implements TabLayout.b<TabLayout.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f63344a;

        public final void onTabReselected(TabLayout.f fVar) {
            k.c(fVar, "tab");
        }

        public final void onTabUnselected(TabLayout.f fVar) {
            k.c(fVar, "tab");
        }

        a(g gVar) {
            this.f63344a = gVar;
        }

        public final void onTabSelected(TabLayout.f fVar) {
            k.c(fVar, "tab");
            g gVar = this.f63344a;
            String valueOf = String.valueOf(fVar.b() + 1);
            k.c("/mumbai-metro-qr-ticket", "screen_name");
            k.c("mumbai_metro_qr_ticket", "category");
            k.c("passenger_changed", "event_action");
            k.c(valueOf, "label");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "mumbai_metro_qr_ticket");
                hashMap.put("event_action", "passenger_changed");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/mumbai-metro-qr-ticket");
                hashMap.put("event_label", valueOf);
                hashMap.put("vertical_name", "recharges_utilities");
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                Context context = gVar.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
            } catch (Throwable unused) {
            }
        }
    }

    public final void onClick(View view) {
        k.c(view, "v");
        if (view.getId() == R.id.iv_close_bottom_sheet) {
            dismiss();
        }
    }

    public final void a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        k.c(cJRActiveMetroTicketModel, "ticket");
        Bundle bundle = this.f63340f;
        if (bundle != null) {
            bundle.putString("order_id", cJRActiveMetroTicketModel.getOrderId());
        }
        Bundle bundle2 = this.f63340f;
        if (bundle2 != null) {
            bundle2.putLong(CLPConstants.PRODUCT_ID, cJRActiveMetroTicketModel.getProductId());
        }
        Bundle bundle3 = this.f63340f;
        if (bundle3 != null) {
            CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = cJRActiveMetroTicketModel.getQrCodes().get(0);
            k.a((Object) cJRActiveMetroTicketQRItemModel, "ticket.qrCodes[0]");
            bundle3.putString("reference_id", cJRActiveMetroTicketQRItemModel.getOperatorRefId());
        }
        Bundle bundle4 = this.f63340f;
        if (bundle4 != null) {
            bundle4.putString("product-type", cJRActiveMetroTicketModel.getProductType());
        }
        Bundle bundle5 = this.f63340f;
        if (bundle5 != null) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            bundle5.putString("metro_event_label", c.a.a(c.a.a(cJRActiveMetroTicketModel)));
        }
        Bundle bundle6 = this.f63340f;
        if (bundle6 != null) {
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            bundle6.putString("metro_event_category", c.a.a(this.p));
        }
        Bundle bundle7 = this.f63340f;
        if (bundle7 != null) {
            bundle7.putString("metro_operator", this.p);
        }
        d dVar = this.f63335a;
        if (dVar != null) {
            dVar.setArguments(this.f63340f);
        }
        d dVar2 = this.f63335a;
        if (dVar2 != null) {
            dVar2.a(getContext(), getChildFragmentManager());
        }
        String productType = cJRActiveMetroTicketModel.getProductType();
        if (productType == null) {
            return;
        }
        if (p.a(productType, "MUMBAI_METRO_QR", false)) {
            a("/mumbai-metro-qr-ticket", "mumbai_metro_qr_ticket", "cancel_ticket_clicked");
        } else if (p.a(productType, "MUMBAI_METRO_TP", false)) {
            a("/mumbai-metro-trip-pass", "mumbai_metro_trip_pass", "cancel_ticket_clicked");
        } else if (p.a(productType, "MUMBAI_METRO_SVP", false)) {
            a("/mumbai-metro-store-value-pass", "mumbai_metro_store_value_pass", "cancel_ticket_clicked");
        }
    }

    public final void a(View view, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        k.c(view, "view");
        k.c(cJRActiveMetroTicketModel, "ticket");
        d dVar = this.r;
        if (dVar != null) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            String a2 = c.a.a(this.q);
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            String a3 = c.a.a(this.s);
            String str = ab.f61496a;
            k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
            d.a(dVar, a2, "view_ticket_popup_Need help_clicked", (Object) null, a3, str, (Object) null, (Object) null, 100);
        }
        Intent putExtra = new Intent(getContext(), AJRMetroTicketSupportActivity.class).putExtra("activeMetroTickets", cJRActiveMetroTicketModel);
        CustomHeightWrappingViewPager customHeightWrappingViewPager = this.f63338d;
        if (customHeightWrappingViewPager == null) {
            k.a();
        }
        Intent putExtra2 = putExtra.putExtra("list_position", customHeightWrappingViewPager.getCurrentItem()).putExtra("metroTicketVariant", this.p);
        c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
        startActivity(putExtra2.putExtra("metro_event_label", c.a.a(c.a.a(cJRActiveMetroTicketModel))).putExtra("metro_request_type", this.q).putExtra("vertical_name", this.u).putExtra("layoutType", 0));
    }

    public final void a(View view, String str) {
        k.c(view, "view");
        k.c(str, "sharedMessage");
        d dVar = this.r;
        if (dVar != null) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            String a2 = c.a.a(this.q);
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            String a3 = c.a.a(this.s);
            String str2 = ab.f61496a;
            k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            d.a(dVar, a2, "view_ticket_popup_Share Ticket_clicked", (Object) null, a3, str2, (Object) null, (Object) null, 100);
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (activity instanceof AJRechargeOrderSummaryActivity) {
            ((AJRechargeOrderSummaryActivity) activity).a(this.f63337c, this.f63341g);
        } else if (activity instanceof AJRTicketOptionsActivity) {
            ((AJRTicketOptionsActivity) activity).a(this.f63337c, this.f63341g);
        }
    }

    public final void a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel, CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel, String str) {
        String str2;
        String str3;
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel2 = cJRActiveMetroTicketModel;
        CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel2 = cJRActiveMetroTicketQRItemModel;
        String str4 = str;
        k.c(cJRActiveMetroTicketQRItemModel2, "qrCode");
        k.c(str4, "balanceAmount");
        d dVar = this.r;
        if (dVar != null) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            String a2 = c.a.a(this.q);
            c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
            String a3 = c.a.a(this.s);
            String str5 = ab.f61496a;
            k.a((Object) str5, "CJRRechargeUtilityConstant.UTILITY");
            d.a(dVar, a2, "view_ticket_popup_View Ticket Details_clicked", (Object) null, a3, str5, (Object) null, (Object) null, 100);
        }
        if (this.f63336b != null) {
            c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
            Context context = this.f63336b;
            if (context == null) {
                k.a();
            }
            if (cJRActiveMetroTicketModel2 == null || (str2 = cJRActiveMetroTicketModel.getSubType()) == null) {
                str2 = cJRActiveMetroTicketModel2 != null ? cJRActiveMetroTicketModel.getProductType() : null;
            }
            k.c(context, "context");
            HashMap hashMap = new HashMap();
            c.d.a aVar4 = c.d.Companion;
            int a4 = c.d.a.a(str2);
            if (a4 == c.d.MUMBAI_METRO_SVP.getValue()) {
                Map map = hashMap;
                String string = context.getString(R.string.mm_qr_detail_balance_left);
                k.a((Object) string, "context.getString(R.stri…m_qr_detail_balance_left)");
                map.put(0, string);
                String string2 = context.getString(R.string.mm_qr_detail_expire_on);
                k.a((Object) string2, "context.getString(R.string.mm_qr_detail_expire_on)");
                map.put(1, string2);
                String string3 = context.getString(R.string.mm_qr_detail_reference_id);
                k.a((Object) string3, "context.getString(R.stri…m_qr_detail_reference_id)");
                map.put(2, string3);
                String string4 = context.getString(R.string.mm_qr_detail_trip_id);
                k.a((Object) string4, "context.getString(R.string.mm_qr_detail_trip_id)");
                map.put(3, string4);
            } else if (a4 == c.d.MUMBAI_METRO_TP.getValue()) {
                Map map2 = hashMap;
                String string5 = context.getString(R.string.mm_qr_detail_trip_remaining);
                k.a((Object) string5, "context.getString(R.stri…qr_detail_trip_remaining)");
                map2.put(0, string5);
                String string6 = context.getString(R.string.mm_qr_detail_expire_on);
                k.a((Object) string6, "context.getString(R.string.mm_qr_detail_expire_on)");
                map2.put(1, string6);
                String string7 = context.getString(R.string.mm_qr_detail_amount_paid);
                k.a((Object) string7, "context.getString(R.stri…mm_qr_detail_amount_paid)");
                map2.put(2, string7);
                String string8 = context.getString(R.string.mm_qr_detail_reference_id);
                k.a((Object) string8, "context.getString(R.stri…m_qr_detail_reference_id)");
                map2.put(3, string8);
                String string9 = context.getString(R.string.mm_qr_detail_trip_id);
                k.a((Object) string9, "context.getString(R.string.mm_qr_detail_trip_id)");
                map2.put(4, string9);
            } else {
                Map map3 = hashMap;
                String string10 = context.getString(R.string.mm_qr_detail_issued_on);
                k.a((Object) string10, "context.getString(R.string.mm_qr_detail_issued_on)");
                map3.put(0, string10);
                String string11 = context.getString(R.string.mm_qr_detail_reference_id);
                k.a((Object) string11, "context.getString(R.stri…m_qr_detail_reference_id)");
                map3.put(1, string11);
                String string12 = context.getString(R.string.mm_qr_detail_trip_id);
                k.a((Object) string12, "context.getString(R.string.mm_qr_detail_trip_id)");
                map3.put(2, string12);
            }
            c.a aVar5 = net.one97.paytm.recharge.metro.f.c.f63576a;
            Context context2 = this.f63336b;
            if (context2 == null) {
                k.a();
            }
            if (cJRActiveMetroTicketModel2 == null || (str3 = cJRActiveMetroTicketModel.getSubType()) == null) {
                str3 = cJRActiveMetroTicketModel2 != null ? cJRActiveMetroTicketModel.getProductType() : null;
            }
            if (cJRActiveMetroTicketModel2 == null) {
                k.a();
            }
            HashMap<Integer, String> a5 = c.a.a(context2, str3, cJRActiveMetroTicketModel2, cJRActiveMetroTicketQRItemModel2, str4);
            Bundle bundle = new Bundle();
            bundle.putString(StringSet.operator, this.f63337c);
            bundle.putSerializable("EXTRA_MAP_KEY", hashMap);
            bundle.putSerializable("EXTRA_MAP_VALUE", a5);
            Context context3 = this.f63336b;
            if (context3 != null) {
                if (context3 == null) {
                    k.a();
                }
                Fragment instantiate = Fragment.instantiate(context3, h.class.getName(), bundle);
                if (instantiate != null) {
                    h hVar = (h) instantiate;
                    if (hVar != null) {
                        hVar.show(getChildFragmentManager(), hVar.getClass().getName());
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMetroQRTicketDetailBottomSheet");
            }
        }
    }

    private final void a(boolean z) {
        try {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Window window = activity.getWindow();
            k.a((Object) window, "activity!!.window");
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.screenBrightness = 1.0f;
            } else {
                attributes.screenBrightness = -1.0f;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            k.a((Object) activity2, "activity!!");
            Window window2 = activity2.getWindow();
            k.a((Object) window2, "activity!!.window");
            window2.setAttributes(attributes);
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public final void onStop() {
        super.onStop();
        a(false);
    }

    public final void onResume() {
        super.onResume();
        a(true);
    }

    public final void onDestroy() {
        a(false);
        super.onDestroy();
    }

    private void a(String str, String str2, String str3) {
        k.c(str, "screen_name");
        k.c(str2, "category");
        k.c(str3, "event_action");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str2);
            hashMap.put("event_action", str3);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        androidx.fragment.app.q a2 = jVar.a();
        k.a((Object) a2, "manager.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
