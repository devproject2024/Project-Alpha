package net.one97.paytm.recharge.legacy.catalog.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.f.b;
import net.one97.paytm.recharge.common.a.j;
import net.one97.paytm.recharge.common.a.u;
import net.one97.paytm.recharge.common.e.ag;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.am;
import net.one97.paytm.recharge.common.e.l;
import net.one97.paytm.recharge.common.e.v;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.common.widget.CJRCustomTabLayout;
import net.one97.paytm.recharge.common.widget.CJRUnScrollableViewPager;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.CJRMerchantLoanAccounts;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends h implements View.OnClickListener, TabLayout.b, b, ai, v {

    /* renamed from: h  reason: collision with root package name */
    private static final String f62901h = d.class.getSimpleName();
    private boolean A;
    private boolean B;
    private String C = null;
    private a D;
    private String E;
    private String F;
    private boolean G;
    private Map<String, CJROffers> H = new HashMap();
    private String I;
    private boolean J = false;
    private boolean K = false;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.ordersummary.h.d L = null;
    private boolean M = false;
    /* access modifiers changed from: private */
    public long N;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public CJRCustomTabLayout f62902a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f62903b;

    /* renamed from: c  reason: collision with root package name */
    List<CJRFrequentOrder> f62904c = new ArrayList();
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public u f62905d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public String f62906e;

    /* renamed from: f  reason: collision with root package name */
    CJRMerchantLoanAccounts f62907f;

    /* renamed from: g  reason: collision with root package name */
    protected final AdapterView.OnItemClickListener f62908g = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            try {
                ba.a(d.this.getContext(), view);
                if (SystemClock.elapsedRealtime() - d.this.N >= 500) {
                    long unused = d.this.N = SystemClock.elapsedRealtime();
                    CJRFrequentOrder a2 = ((j) adapterView.getAdapter()).getItem(i2);
                    if (d.this.s != null) {
                        d.this.s.a(a2);
                    }
                }
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private am f62909i;
    /* access modifiers changed from: private */
    public RelativeLayout j;
    /* access modifiers changed from: private */
    public CJRUnScrollableViewPager k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public CJRItem n;
    private List<CJRFrequentOrder> o = new ArrayList();
    private CJRFrequentOrderList p;
    private List<CJROfferCode> q = new ArrayList();
    private List<CJRAutomaticSubscriptionItemModel> r = new ArrayList();
    /* access modifiers changed from: private */
    public ag s;
    private l t;
    private boolean u;
    private net.one97.paytm.recharge.automatic.f.a v;
    private TopLevelCategoryHeader w;
    private b x;
    private boolean y;
    private boolean z;

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public final void a(CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
    }

    public void onTabReselected(TabLayout.f fVar) {
    }

    public void onTabUnselected(TabLayout.f fVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.l = getArguments().getString("help_section_key", "");
            this.u = getArguments().getBoolean("is_help_section_enabled", false);
            this.m = getArguments().getString("recents_service_name_key", "");
            this.n = (CJRItem) getArguments().getSerializable("recharge_item");
            this.w = (TopLevelCategoryHeader) getArguments().getSerializable("top_level_header_automatic_catalog");
            this.z = getArguments().getBoolean("show_recents", true);
            this.A = getArguments().getBoolean("show_offers", true);
            this.y = getArguments().getBoolean("show_automatic", true);
            this.B = getArguments().getBoolean("should_append_metro_qr_tickets", false);
            this.F = getArguments().getString("utility_rc_service_name", (String) null);
            this.f62906e = getArguments().getString("utility_ga_event_category", (String) null);
            this.I = getArguments().getString("vertical_id", "");
        }
        if (!(getContext() == null || getContext().getApplicationContext() == null)) {
            this.L = new net.one97.paytm.recharge.ordersummary.h.d(getContext().getApplicationContext());
        }
        az azVar = az.f61525a;
        this.M = az.c(getContext(), this.n.getCategoryId());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.recharge_tab_layout, (ViewGroup) null, false);
        this.j = (RelativeLayout) inflate.findViewById(R.id.bottom_layout_view);
        this.f62902a = (CJRCustomTabLayout) inflate.findViewById(R.id.tabs_recharge_titles);
        this.k = (CJRUnScrollableViewPager) inflate.findViewById(R.id.recharge_item_view);
        this.f62903b = (RelativeLayout) inflate.findViewById(R.id.delete_options_view);
        this.f62903b.setVisibility(8);
        inflate.findViewById(R.id.clear_option).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d dVar = d.this;
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DELETE_RECENT, ERROR_TYPE.UNDEFINED);
                if (dVar.f62903b != null && dVar.f62903b.getVisibility() == 0) {
                    dVar.f62903b.setVisibility(8);
                }
                if (dVar.f62902a != null && dVar.f62902a.getVisibility() == 8) {
                    dVar.f62902a.setVisibility(0);
                }
                if (dVar.getActivity() != null && dVar.f62904c != null && dVar.f62904c.size() > 0) {
                    c cVar = c.f62654a;
                    String u = c.u();
                    String a3 = com.paytm.utility.c.a((Context) dVar.getActivity(), true);
                    CJRFrequentOrderList cJRFrequentOrderList = new CJRFrequentOrderList();
                    if (com.paytm.utility.b.c((Context) dVar.getActivity())) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        String b2 = dVar.b();
                        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(u)) {
                            dVar.getActivity();
                            net.one97.paytm.recharge.common.f.d.a();
                            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("delete_recents", u + a3, (ai) new ai() {
                                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                                }

                                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                                    d.this.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                                }
                            }, (IJRPaytmDataModel) cJRFrequentOrderList, (Map<String, String>) null, (Map<String, String>) hashMap, b2, (Object) a2));
                        }
                    }
                    dVar.c();
                }
            }
        });
        inflate.findViewById(R.id.cancel_option).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a();
            }
        });
        CJRItem cJRItem = this.n;
        AdapterView.OnItemClickListener onItemClickListener = this.f62908g;
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        List<CJRFrequentOrder> list = this.o;
        List<CJROfferCode> list2 = this.q;
        Context context = getContext();
        am amVar = this.f62909i;
        String str = this.l;
        List<CJRAutomaticSubscriptionItemModel> list3 = this.r;
        CJRCustomTabLayout cJRCustomTabLayout = this.f62902a;
        CJRCustomTabLayout cJRCustomTabLayout2 = cJRCustomTabLayout;
        u uVar = r0;
        CJRCustomTabLayout cJRCustomTabLayout3 = cJRCustomTabLayout2;
        View view = inflate;
        u uVar2 = new u(cJRItem, this, onItemClickListener, childFragmentManager, list, list2, context, amVar, str, list3, cJRCustomTabLayout3, this.f62906e, this.I);
        this.f62905d = uVar;
        u uVar3 = this.f62905d;
        uVar3.k = this;
        uVar3.l = this.M;
        this.k.setAdapter(uVar3);
        this.f62902a.setupWithViewPager(this.k);
        this.f62902a.a((TabLayout.b) this);
        this.k.setOffscreenPageLimit(3);
        this.k.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
                String str = "bottom_tab_" + d.this.f62902a.a(i2).f36763c.toString() + "_clicked";
                if (e.z.equals(d.this.n.getCategoryId())) {
                    str = "bottom_nav_" + d.this.f62902a.a(i2).f36763c.toString() + "_clicked";
                }
                String str2 = str;
                if (d.this.L != null) {
                    d.this.L.a(d.this.f62906e == null ? "" : d.this.f62906e, str2, "", "", ab.f61496a, "", "");
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        ba.a(d.this.getContext(), (View) d.this.k);
                    }
                }, 500);
                d.this.k.requestFocus();
                if (d.this.f62905d != null) {
                    u f2 = d.this.f62905d;
                    if (f2.f60691d != null && f2.f60691d.size() > i2 && i2 > 0) {
                        f2.f60691d.get(i2).intValue();
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        d.this.a();
                    }
                }, 100);
            }
        });
        a((String) null);
        CJRItem cJRItem2 = this.n;
        if (cJRItem2 != null && !TextUtils.isEmpty(cJRItem2.getCategoryId())) {
            String categoryId = this.n.getCategoryId();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            a("load_offers", categoryId, (CJROffers) null, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.FETCH_PROMOS, ERROR_TYPE.UNDEFINED));
        }
        boolean z2 = this.u;
        this.u = z2;
        c cVar = c.f62654a;
        String aw = c.aw();
        if (z2 && this.f62905d != null && !TextUtils.isEmpty(aw)) {
            this.j.setVisibility(0);
            u uVar4 = this.f62905d;
            if (!uVar4.f60690c.contains(uVar4.f60688a.getString(R.string.help_title_str))) {
                uVar4.f60690c.add(uVar4.f60688a.getString(R.string.help_title_str));
                uVar4.f60691d.add(Integer.valueOf(R.string.help_title_str));
            }
            if (uVar4.f60696i != null) {
                uVar4.f60696i.setNumberOfTabs(uVar4.f60690c.size());
            }
            uVar4.notifyDataSetChanged();
        }
        TopLevelCategoryHeader topLevelCategoryHeader = this.w;
        if (this.y) {
            if (topLevelCategoryHeader != null) {
                this.w = topLevelCategoryHeader;
            }
            if (this.v == null) {
                this.v = new net.one97.paytm.recharge.automatic.f.a(this, this.w);
                net.one97.paytm.recharge.automatic.f.a aVar = this.v;
                Context context2 = getContext();
                String str2 = this.m;
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aVar.a("show_paytm_automatic", context2, str2, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.PAYMENT_AUTOMATIC, ERROR_TYPE.UNDEFINED));
            }
        }
        return view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
            CJRFrequentOrderList cJRFrequentOrderList = (CJRFrequentOrderList) iJRPaytmDataModel;
            if (getActivity() != null && getActivity().getApplication() != null) {
                try {
                    if (!(getActivity() == null || getActivity().getApplicationContext() == null)) {
                        CJRRechargeUtilities.INSTANCE.setFrequentOrderList(cJRFrequentOrderList);
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
                if (!getActivity().isDestroyed() && isAdded() && !isDetached()) {
                    a(cJRFrequentOrderList);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJROffers) {
            CJROffers cJROffers = (CJROffers) iJRPaytmDataModel;
            this.H.put(this.E, cJROffers);
            if (cJROffers.getOfferCodes() != null && cJROffers.getOfferCodes().size() > 0) {
                a(cJROffers);
            }
        } else if (iJRPaytmDataModel instanceof CJRMetroQRFrequentOrderList) {
            CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList = (CJRMetroQRFrequentOrderList) iJRPaytmDataModel;
            b((List<CJRFrequentOrder>) new ArrayList(cJRMetroQRFrequentOrderList.getmOrderList()));
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            c.a.a(this.C, cJRMetroQRFrequentOrderList);
        }
    }

    public void onClick(View view) {
        Object tag;
        net.one97.paytm.recharge.automatic.f.a aVar;
        if (view != null && (tag = view.getTag()) != null) {
            if ((tag == net.one97.paytm.recharge.automatic.b.a.j.DELETED || tag == net.one97.paytm.recharge.automatic.b.a.j.ENABLED) && (aVar = this.v) != null) {
                Context context = getContext();
                String str = this.m;
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aVar.a("show_paytm_automatic", context, str, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.PAYMENT_AUTOMATIC, ERROR_TYPE.UNDEFINED));
            }
        }
    }

    public final void a(String str) {
        if (this.z) {
            if (!TextUtils.isEmpty((CharSequence) null)) {
                this.m = null;
            }
            if (!TextUtils.isEmpty(str)) {
                this.F = str;
            }
            q.d("loadFrequentOrders Called");
            if (CJRRechargeUtilities.INSTANCE.getSSOToken(getActivity()) != null) {
                CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
                if (frequentOrderList != null) {
                    a(frequentOrderList);
                } else {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    a("frequent_api", (Object) net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.FETCH_RECENTS, ERROR_TYPE.UNDEFINED));
                }
            }
            if (this.B) {
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                b("frequent_api", net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.FETCH_RECENTS, ERROR_TYPE.UNDEFINED));
            }
        }
    }

    private void a(String str, Object obj) {
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String b2 = net.one97.paytm.recharge.di.helper.c.b();
        if (b2 != null && z.a(getContext()) && URLUtil.isValidUrl(b2)) {
            new HashMap().put(AppConstants.SSO_TOKEN, CJRRechargeUtilities.INSTANCE.getSSOToken(getActivity()));
            getActivity();
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, b2 + com.paytm.utility.c.a((Context) getActivity(), false), this, new CJRFrequentOrderList(), com.paytm.utility.b.ah(getActivity()), obj));
        }
    }

    private void b(String str, Object obj) {
        if (!(getContext() == null) && !(true ^ com.paytm.utility.d.c(getContext()))) {
            this.C = TextUtils.isEmpty(this.C) ? "Mumbai_Metro_All_recents" : this.C;
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            CJRMetroQRFrequentOrderList d2 = c.a.d(this.C);
            if (d2 == null) {
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                String aO = net.one97.paytm.recharge.di.helper.c.aO();
                if (!TextUtils.isEmpty(aO)) {
                    String str2 = aO + "?customer_id=" + com.paytm.utility.b.n(getContext());
                    if (!"Mumbai_Metro_All_recents".equals(this.C)) {
                        str2 = str2 + "&reqtype=" + this.C;
                    }
                    getActivity();
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, str2, this, new CJRMetroQRFrequentOrderList(), obj));
                    return;
                }
                return;
            }
            b((List<CJRFrequentOrder>) new ArrayList(d2.getmOrderList()));
        }
    }

    public static boolean a(CJRFrequentOrderList cJRFrequentOrderList, String str) {
        net.one97.paytm.recharge.common.utils.q qVar = net.one97.paytm.recharge.common.utils.q.f61722a;
        return net.one97.paytm.recharge.common.utils.q.a(cJRFrequentOrderList, str, (String) null).size() > 0;
    }

    private void a(CJRFrequentOrderList cJRFrequentOrderList) {
        String str;
        String str2;
        this.p = cJRFrequentOrderList;
        net.one97.paytm.recharge.common.utils.q qVar = net.one97.paytm.recharge.common.utils.q.f61722a;
        List<CJRFrequentOrder> a2 = net.one97.paytm.recharge.common.utils.q.a(cJRFrequentOrderList, this.m, (String) null);
        if (!TextUtils.isEmpty(this.F)) {
            net.one97.paytm.recharge.common.utils.q qVar2 = net.one97.paytm.recharge.common.utils.q.f61722a;
            a2.addAll(net.one97.paytm.recharge.common.utils.q.a(cJRFrequentOrderList, this.F, (String) null));
        }
        CJRMerchantLoanAccounts cJRMerchantLoanAccounts = this.f62907f;
        if (!(cJRMerchantLoanAccounts == null || cJRMerchantLoanAccounts.getAccounts() == null || this.f62907f.getAccounts().size() <= 0)) {
            ba.a(this.f62907f.getAccounts(), a2, this.m);
        }
        this.o = a2;
        if (a2 != null && a2.size() > 0) {
            a aVar = this.D;
            if (aVar == null || aVar.isCancelled()) {
                this.D = new a(this.o);
                this.D.execute(new Void[0]);
            }
            if (!this.J) {
                net.one97.paytm.recharge.ordersummary.h.d dVar = this.L;
                if (dVar != null) {
                    String str3 = this.f62906e;
                    if (str3 == null) {
                        str2 = "";
                    } else {
                        str2 = str3;
                    }
                    dVar.a(str2, "recents_shown", "", Integer.valueOf(a2.size()), ab.f61496a, "", "");
                }
                this.J = true;
            }
        } else if (!this.K) {
            net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(getContext());
            String str4 = this.f62906e;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            dVar2.a(str, "recents_not_shown", "", "", ab.f61496a, "", "");
            this.K = true;
        }
    }

    public final void a(CJRMerchantLoanAccounts cJRMerchantLoanAccounts) {
        this.f62907f = cJRMerchantLoanAccounts;
    }

    public void onTabSelected(TabLayout.f fVar) {
        try {
            if (getContext() == null || !isAdded() || fVar.f36763c == null || !getString(R.string.recents_title_str).equalsIgnoreCase(fVar.f36763c.toString()) || this.G) {
                this.G = false;
            } else {
                this.G = true;
            }
        } catch (Exception unused) {
        }
    }

    class a extends AsyncTask<Void, Void, List<CJRFrequentOrder>> {

        /* renamed from: a  reason: collision with root package name */
        List<CJRFrequentOrder> f62917a;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            List<CJRFrequentOrder> list = (List) obj;
            if (d.this.getActivity() != null && !isCancelled() && list != null && list.size() > 0) {
                d.this.j.setVisibility(0);
                this.f62917a = list;
                if (d.this.f62905d != null) {
                    u f2 = d.this.f62905d;
                    if (f2.f60692e != null) {
                        f2.f60692e.clear();
                    }
                    d.this.f62905d.a(list);
                }
            }
        }

        a(List<CJRFrequentOrder> list) {
            this.f62917a = list;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            net.one97.paytm.recharge.common.utils.q qVar = net.one97.paytm.recharge.common.utils.q.f61722a;
            return net.one97.paytm.recharge.common.utils.q.b(this.f62917a, ab.f61496a);
        }
    }

    private void b(List<CJRFrequentOrder> list) {
        if (list.size() > 0 && this.f62905d != null) {
            this.j.setVisibility(0);
            this.f62905d.a(list);
        }
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        if (cJRFrequentOrder != null) {
            RelativeLayout relativeLayout = this.f62903b;
            if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
                this.f62903b.setVisibility(0);
            }
            CJRCustomTabLayout cJRCustomTabLayout = this.f62902a;
            if (cJRCustomTabLayout != null && cJRCustomTabLayout.getVisibility() == 0) {
                this.f62902a.setVisibility(8);
            }
        }
        l lVar = this.t;
        if (lVar != null) {
            lVar.a(true);
        }
        List<CJRFrequentOrder> list = this.f62904c;
        if (list == null || (list != null && !list.contains(cJRFrequentOrder))) {
            this.f62904c.add(cJRFrequentOrder);
        } else {
            this.f62904c.remove(cJRFrequentOrder);
        }
        List<CJRFrequentOrder> list2 = this.f62904c;
        if (list2 != null && list2.size() == 0) {
            a();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof am) {
            this.f62909i = (am) context;
        }
        if (context instanceof ag) {
            this.s = (ag) context;
        } else if (getParentFragment() instanceof ag) {
            this.s = (ag) getParentFragment();
        }
        if (context instanceof b) {
            this.x = (b) context;
        } else if (getParentFragment() instanceof b) {
            this.x = (b) getParentFragment();
        }
        if (context instanceof l) {
            this.t = (l) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f62909i = null;
        this.s = null;
        this.t = null;
        this.x = null;
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r5 = this;
            android.widget.RelativeLayout r0 = r5.f62903b
            r1 = 8
            if (r0 == 0) goto L_0x0011
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0011
            android.widget.RelativeLayout r0 = r5.f62903b
            r0.setVisibility(r1)
        L_0x0011:
            net.one97.paytm.recharge.common.widget.CJRCustomTabLayout r0 = r5.f62902a
            r2 = 0
            if (r0 == 0) goto L_0x0021
            int r0 = r0.getVisibility()
            if (r0 != r1) goto L_0x0021
            net.one97.paytm.recharge.common.widget.CJRCustomTabLayout r0 = r5.f62902a
            r0.setVisibility(r2)
        L_0x0021:
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r0 = r5.f62904c
            if (r0 == 0) goto L_0x0030
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0030
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r0 = r5.f62904c
            r0.clear()
        L_0x0030:
            r0 = 0
            boolean r1 = r5.isAdded()
            if (r1 == 0) goto L_0x0062
            androidx.fragment.app.j r1 = r5.getChildFragmentManager()
            if (r1 == 0) goto L_0x0062
            androidx.fragment.app.p r3 = r1.f3424a
            java.util.List r3 = r3.d()
            if (r3 == 0) goto L_0x0062
            androidx.fragment.app.p r1 = r1.f3424a
            java.util.List r1 = r1.d()
            java.util.Iterator r1 = r1.iterator()
        L_0x004f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0062
            java.lang.Object r3 = r1.next()
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            boolean r4 = r3 instanceof net.one97.paytm.recharge.common.fragment.m
            if (r4 == 0) goto L_0x004f
            r0 = r3
            net.one97.paytm.recharge.common.fragment.m r0 = (net.one97.paytm.recharge.common.fragment.m) r0
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.a()
        L_0x0067:
            net.one97.paytm.recharge.common.e.l r0 = r5.t
            if (r0 == 0) goto L_0x006e
            r0.a(r2)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.fragment.d.a():void");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        JSONArray jSONArray = new JSONArray();
        if (this.f62904c != null) {
            for (int i2 = 0; i2 < this.f62904c.size(); i2++) {
                try {
                    if (this.f62904c.get(i2) != null) {
                        jSONArray.put(i2, this.f62904c.get(i2).getFavOrderId());
                    }
                } catch (JSONException e2) {
                    q.d(e2.getMessage());
                }
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("favLabelId", jSONArray);
            jSONObject.put("channel", "android");
            jSONObject.put("version", 2);
            return jSONObject.toString();
        } catch (JSONException e3) {
            q.d(e3.getMessage());
            return "";
        }
    }

    public final void c() {
        List<CJRFrequentOrder> list = this.o;
        if (list != null && list.size() > 0) {
            for (CJRFrequentOrder next : this.f62904c) {
                List<CJRFrequentOrder> list2 = this.o;
                if (list2 != null && list2.contains(next)) {
                    this.o.remove(next);
                    this.p.getOrderList().remove(next);
                }
            }
            CJRRechargeUtilities.INSTANCE.setFrequentOrderList(this.p);
            a();
            u uVar = this.f62905d;
            if (uVar != null) {
                List<CJRFrequentOrder> list3 = this.o;
                if (uVar.f60693f != null) {
                    uVar.f60692e = list3;
                    if (uVar.f60690c.contains(uVar.f60688a.getString(R.string.recents_title_str))) {
                        uVar.f60690c.remove(uVar.f60688a.getString(R.string.recents_title_str));
                        uVar.notifyDataSetChanged();
                    }
                    uVar.f60690c.add(0, uVar.f60688a.getString(R.string.recents_title_str));
                    uVar.f60691d.add(0, Integer.valueOf(R.string.recents_title_str));
                    uVar.notifyDataSetChanged();
                }
            }
        }
    }

    private void a(String str, String str2, CJROffers cJROffers, Object obj) {
        if (this.A && getActivity() != null) {
            this.E = str2;
            if (this.M) {
                u uVar = this.f62905d;
                if (uVar != null) {
                    uVar.a();
                    this.f62905d.a(str2);
                }
                u uVar2 = this.f62905d;
                if (uVar2 != null && !uVar2.b()) {
                    this.j.setVisibility(0);
                    this.f62905d.b((List<CJROfferCode>) null);
                }
            } else if (cJROffers == null) {
                u uVar3 = this.f62905d;
                if (uVar3 != null) {
                    uVar3.a();
                }
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                sb.append(net.one97.paytm.recharge.di.helper.c.v());
                sb.append(this.E);
                net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                sb.append(net.one97.paytm.recharge.di.helper.c.w());
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    if (sb2.contains("?")) {
                        String a2 = com.paytm.utility.c.a((Context) getActivity(), false);
                        if (a2.contains("?")) {
                            a2 = a2.replace("?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                        }
                        sb2 = sb2 + a2;
                    } else {
                        sb2 = sb2 + com.paytm.utility.c.a((Context) getActivity(), false);
                    }
                }
                if (getActivity() != null) {
                    az azVar = az.f61525a;
                    if (az.f(getActivity())) {
                        sb2 = sb2 + "&isReseller=true";
                    }
                }
                String str3 = sb2 + "&sortType=2";
                String q2 = com.paytm.utility.a.q(getContext());
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, q2);
                if (URLUtil.isValidUrl(str3)) {
                    getActivity();
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, str3, this, new CJROffers(), hashMap, obj));
                }
            } else {
                a(cJROffers);
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        az azVar = az.f61525a;
        this.M = az.c(getContext(), str);
        u uVar = this.f62905d;
        if (uVar != null) {
            uVar.l = this.M;
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                u uVar2 = this.f62905d;
                uVar2.j = str2;
                uVar2.m = str3;
            }
        }
        if (this.H.containsKey(str)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            a("load_offers", str, this.H.get(str), net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.FETCH_PROMOS, ERROR_TYPE.UNDEFINED));
            return;
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        a("load_offers", str, (CJROffers) null, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.FETCH_PROMOS, ERROR_TYPE.UNDEFINED));
    }

    private void a(CJROffers cJROffers) {
        List<CJROfferCode> list;
        this.q = cJROffers.getOfferCodes();
        if (this.f62905d != null && (list = this.q) != null && list.size() > 0) {
            if (!this.f62905d.b()) {
                this.j.setVisibility(0);
                this.f62905d.b(this.q);
                return;
            }
            this.f62905d.a(this.k, this.q);
        }
    }

    public final boolean d() {
        u uVar = this.f62905d;
        if (uVar != null) {
            return uVar.c();
        }
        return false;
    }

    public static CJRFrequentOrder a(Activity activity, String str) {
        if (activity != null) {
            CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
            net.one97.paytm.recharge.common.utils.q qVar = net.one97.paytm.recharge.common.utils.q.f61722a;
            List<CJRFrequentOrder> a2 = net.one97.paytm.recharge.common.utils.q.a(frequentOrderList, str, (String) null);
            if (a2 != null && a2.size() > 0 && a2.size() == 1) {
                return a2.get(0);
            }
        }
        return null;
    }

    public final void a(boolean z2) {
        b bVar = this.x;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public final void e() {
        b bVar = this.x;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void onStop() {
        super.onStop();
        a aVar = this.D;
        if (aVar != null && aVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.D.cancel(true);
        }
    }

    public static d a(String str, String str2, String str3, CJRItem cJRItem, boolean z2, TopLevelCategoryHeader topLevelCategoryHeader, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("help_section_key", str);
        bundle.putString("recents_service_name_key", str2);
        bundle.putSerializable("recharge_item", cJRItem);
        bundle.putBoolean("is_help_section_enabled", z2);
        bundle.putBoolean("show_recents", true);
        bundle.putBoolean("show_offers", true);
        bundle.putBoolean("show_automatic", true);
        bundle.putBoolean("should_append_metro_qr_tickets", false);
        bundle.putSerializable("top_level_header_automatic_catalog", topLevelCategoryHeader);
        bundle.putString("utility_rc_service_name", str3);
        bundle.putString("utility_ga_event_category", str4);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    public static d a(String str, String str2, String str3, CJRItem cJRItem, boolean z2, TopLevelCategoryHeader topLevelCategoryHeader, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putString("help_section_key", str);
        bundle.putString("recents_service_name_key", str2);
        bundle.putSerializable("recharge_item", cJRItem);
        bundle.putBoolean("is_help_section_enabled", z2);
        bundle.putBoolean("show_recents", true);
        bundle.putBoolean("show_offers", true);
        bundle.putBoolean("show_automatic", true);
        bundle.putBoolean("should_append_metro_qr_tickets", false);
        bundle.putSerializable("top_level_header_automatic_catalog", topLevelCategoryHeader);
        bundle.putString("utility_rc_service_name", str3);
        bundle.putString("utility_ga_event_category", str4);
        bundle.putString("vertical_id", str5);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    public final void a(List<CJRAutomaticSubscriptionItemModel> list) {
        List<CJRFrequentOrder> list2;
        if (!(this.f62905d == null || list == null || list.size() <= 0)) {
            this.j.setVisibility(0);
            u uVar = this.f62905d;
            uVar.f60689b = list;
            if (uVar.f60690c != null && !uVar.f60690c.contains(uVar.f60688a.getString(R.string.automatic))) {
                int i2 = (uVar.f60690c.size() <= 0 || uVar.f60690c.indexOf(uVar.f60688a.getString(R.string.recents_title_str)) == -1) ? 0 : 1;
                uVar.f60690c.add(i2, uVar.f60688a.getString(R.string.automatic));
                uVar.f60691d.add(i2, Integer.valueOf(R.string.automatic));
            }
            if (uVar.f60696i != null) {
                uVar.f60696i.setNumberOfTabs(uVar.f60690c.size());
            }
            uVar.notifyDataSetChanged();
        }
        if (this.f62905d != null && (list2 = this.o) != null && list2.size() > 0) {
            new a(this.o).execute(new Void[0]);
        }
    }
}
