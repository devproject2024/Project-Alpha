package net.one97.paytm.recharge.common.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.e;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final String f61271d = k.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private static int f61272e = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f61273a;

    /* renamed from: b  reason: collision with root package name */
    public int f61274b;

    /* renamed from: c  reason: collision with root package name */
    public int f61275c;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f61276f;

    /* renamed from: g  reason: collision with root package name */
    private ListView f61277g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f61278h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f61279i;
    /* access modifiers changed from: private */
    public e j;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.coupons.c.a k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public CJRMadeForYouResponse m;
    private b n;
    private String o;
    private long p;

    public static k a(String str, int i2, CJRMadeForYouResponse cJRMadeForYouResponse, String str2, long j2) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putString("extra_data", str);
        bundle.putSerializable("made_for_you", cJRMadeForYouResponse);
        bundle.putString("recharge_number", str2);
        bundle.putLong(CLPConstants.PRODUCT_ID, j2);
        kVar.setArguments(bundle);
        f61272e = i2;
        return kVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.l = arguments.getString("extra_data");
            this.m = (CJRMadeForYouResponse) arguments.getSerializable("made_for_you");
            this.o = arguments.getString("recharge_number");
            this.p = arguments.getLong(CLPConstants.PRODUCT_ID);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof e) {
            this.k = (net.one97.paytm.recharge.coupons.c.a) activity;
            this.j = (e) activity;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.indicative_plans_item_layout, viewGroup, false);
        this.f61277g = (ListView) inflate.findViewById(R.id.indicative_plans_list_view);
        this.f61277g.setVisibility(0);
        this.f61278h = (ProgressBar) inflate.findViewById(R.id.loading);
        this.f61279i = (TextView) inflate.findViewById(R.id.plans_not_available);
        this.n = new b();
        this.f61277g.setOnScrollListener(this.n);
        com.paytm.utility.b.g((Context) getActivity());
        this.f61276f = com.paytm.utility.b.f((Context) getActivity()) / 2;
        CJRMadeForYouResponse cJRMadeForYouResponse = this.m;
        if (cJRMadeForYouResponse == null || cJRMadeForYouResponse.getPlansData() == null || this.m.getPlansData().size() == 0) {
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.BROWSE_PLAN, ERROR_TYPE.UNDEFINED);
            if (!TextUtils.isEmpty(this.o)) {
                c cVar = c.f62654a;
                if (c.W()) {
                    this.f61278h.setVisibility(0);
                    c cVar2 = c.f62654a;
                    String G = c.G();
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(CLPConstants.PRODUCT_ID, this.p);
                        jSONObject.put("recharge_number", this.o);
                    } catch (JSONException e2) {
                        q.d(e2.getMessage());
                    }
                    if (!TextUtils.isEmpty(G) && com.paytm.utility.b.c((Context) getActivity())) {
                        getActivity();
                        net.one97.paytm.recharge.common.f.d.a();
                        net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("load_made_for_you_offers", G, (ai) new ai() {
                            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                                k.this.f61278h.setVisibility(8);
                                CJRMadeForYouResponse unused = k.this.m = (CJRMadeForYouResponse) iJRPaytmDataModel;
                                if (k.this.m == null || k.this.m.getPlansData().size() <= 0) {
                                    k.this.f61279i.setVisibility(0);
                                } else {
                                    k.this.a();
                                }
                            }

                            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                                k.this.f61278h.setVisibility(8);
                                k.this.f61279i.setVisibility(0);
                            }
                        }, (IJRPaytmDataModel) new CJRMadeForYouResponse(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (Object) a2));
                    }
                }
            }
            this.f61279i.setVisibility(0);
        } else {
            a();
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f61277g.setAdapter(new a(getActivity(), R.layout.browser_plan_list, this.m.getPlansData()));
    }

    class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private List<CJRMadeForYouPlanData> f61282b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutInflater f61283c;

        /* renamed from: d  reason: collision with root package name */
        private int f61284d;

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getItemViewType(int i2) {
            return 0;
        }

        public a(Context context, int i2, List<CJRMadeForYouPlanData> list) {
            if (context != null) {
                this.f61283c = LayoutInflater.from(context);
                this.f61284d = i2;
                this.f61282b = list;
            }
        }

        public final int getCount() {
            List<CJRMadeForYouPlanData> list = this.f61282b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final Object getItem(int i2) {
            if (this.f61282b.size() > 0) {
                return this.f61282b.get(i2);
            }
            return null;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1187a aVar = null;
            if (getItemViewType(i2) != 0) {
                return null;
            }
            View inflate = this.f61283c.inflate(this.f61284d, (ViewGroup) null);
            if (this.f61284d == R.layout.browser_plan_list) {
                aVar = new C1187a(this, (byte) 0);
                aVar.f61293b = (TextView) inflate.findViewById(R.id.validity_value);
                aVar.f61294c = (TextView) inflate.findViewById(R.id.price_text);
                aVar.f61295d = (TextView) inflate.findViewById(R.id.description_text);
                aVar.f61296e = (TextView) inflate.findViewById(R.id.plan_description_value);
                aVar.f61292a = (RoboTextView) inflate.findViewById(R.id.talktime_text);
                aVar.f61297f = (TextView) inflate.findViewById(R.id.more_details_tv);
                aVar.f61294c.setPadding(net.one97.paytm.common.utility.a.a(5, k.this.getContext()), k.this.f61276f / 2, 0, k.this.f61276f / 2);
                inflate.setPadding(0, (k.this.f61276f * 3) / 2, k.this.f61276f, (k.this.f61276f * 3) / 2);
            }
            inflate.setTag(aVar);
            if (this.f61284d != R.layout.browser_plan_list) {
                return inflate;
            }
            final C1187a aVar2 = (C1187a) inflate.getTag();
            final CJRMadeForYouPlanData cJRMadeForYouPlanData = this.f61282b.get(i2);
            String talkTimeDisplayString = cJRMadeForYouPlanData.getTalkTimeDisplayString(k.this.getActivity());
            if (!TextUtils.isEmpty(talkTimeDisplayString)) {
                aVar2.f61292a.setText(talkTimeDisplayString);
                aVar2.f61292a.setVisibility(0);
            } else {
                aVar2.f61292a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cJRMadeForYouPlanData.getValidity())) {
                aVar2.f61293b.setText(cJRMadeForYouPlanData.getValidityDisplayString(k.this.getActivity()));
                aVar2.f61293b.setVisibility(0);
            } else {
                aVar2.f61293b.setVisibility(8);
            }
            if (TextUtils.isEmpty(cJRMadeForYouPlanData.getName())) {
                aVar2.f61295d.setVisibility(8);
            } else {
                aVar2.f61295d.setVisibility(0);
                aVar2.f61295d.setText(cJRMadeForYouPlanData.getName());
                aVar2.f61295d.setMaxLines(2);
                aVar2.f61295d.post(new Runnable() {
                    public final void run() {
                        if (aVar2.f61295d.getLineCount() > 2) {
                            aVar2.f61297f.setVisibility(0);
                            aVar2.f61295d.setMaxLines(2);
                            aVar2.f61295d.setEllipsize(TextUtils.TruncateAt.END);
                            return;
                        }
                        aVar2.f61297f.setVisibility(8);
                        aVar2.f61295d.setMaxLines(10);
                    }
                });
            }
            final String actualPrice = cJRMadeForYouPlanData.getActualPrice();
            if (com.paytm.utility.b.K(actualPrice).booleanValue()) {
                aVar2.f61294c.setText(k.this.getResources().getString(R.string.recharge_rs_without_space, new Object[]{actualPrice}));
            } else if (com.paytm.utility.b.a(Double.valueOf(Double.parseDouble(actualPrice)))) {
                String valueOf = String.valueOf((int) Double.parseDouble(actualPrice));
                aVar2.f61294c.setText(k.this.getResources().getString(R.string.recharge_rs_without_space, new Object[]{valueOf}));
            } else {
                String valueOf2 = String.valueOf(com.paytm.utility.b.b(Double.parseDouble(actualPrice)));
                aVar2.f61294c.setText(k.this.getResources().getString(R.string.recharge_rs_without_space, new Object[]{valueOf2}));
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (k.this.getActivity() != null && k.this.j != null) {
                        k.this.j.a(actualPrice, false, (HashMap<String, String>) null, (String) null, cJRMadeForYouPlanData.getName(), (CJRBrowsePlansDescAttributes) null, true);
                    }
                }
            });
            aVar2.f61297f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.j.a(cJRMadeForYouPlanData, k.this.l);
                }
            });
            return inflate;
        }

        /* renamed from: net.one97.paytm.recharge.common.fragment.k$a$a  reason: collision with other inner class name */
        class C1187a {

            /* renamed from: a  reason: collision with root package name */
            RoboTextView f61292a;

            /* renamed from: b  reason: collision with root package name */
            TextView f61293b;

            /* renamed from: c  reason: collision with root package name */
            TextView f61294c;

            /* renamed from: d  reason: collision with root package name */
            TextView f61295d;

            /* renamed from: e  reason: collision with root package name */
            TextView f61296e;

            /* renamed from: f  reason: collision with root package name */
            TextView f61297f;

            private C1187a() {
            }

            /* synthetic */ C1187a(a aVar, byte b2) {
                this();
            }
        }
    }

    class b implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        private int f61300b = 10;

        /* renamed from: c  reason: collision with root package name */
        private int f61301c = 0;

        /* renamed from: d  reason: collision with root package name */
        private boolean f61302d = true;

        public b() {
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (this.f61302d && i4 > this.f61301c) {
                this.f61302d = false;
                this.f61301c = i4;
            }
            if (!this.f61302d && i4 - i3 <= this.f61300b + i2 && k.this.k != null) {
                k.this.k.b();
                this.f61302d = true;
            }
            k kVar = k.this;
            kVar.f61273a = i2;
            kVar.f61274b = i3;
            kVar.f61275c = i4;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 0) {
                net.one97.paytm.recharge.coupons.c.a unused = k.this.k;
                if (k.this.f61273a + k.this.f61274b >= k.this.f61275c && k.this.k != null) {
                    k.this.k.b();
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.coupons.c.a unused2 = k.this.k;
        }
    }
}
