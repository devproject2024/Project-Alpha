package net.one97.paytm.recharge.common.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.e;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescriptions;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes;
import net.one97.paytm.recharge.model.mobile.CJRBrowsePlansRichDesc;

public class g extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final String f61175e = g.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static int f61176f = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f61177a;

    /* renamed from: b  reason: collision with root package name */
    public int f61178b;

    /* renamed from: c  reason: collision with root package name */
    public int f61179c;

    /* renamed from: d  reason: collision with root package name */
    public a f61180d;

    /* renamed from: g  reason: collision with root package name */
    private String f61181g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f61182h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<CJRBrowsePlanDescription> f61183i;
    /* access modifiers changed from: private */
    public int j;
    private ListView k;
    private ProgressBar l;
    private TextView m;
    /* access modifiers changed from: private */
    public e n;
    private RelativeLayout o;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.coupons.c.a p;
    private b q;
    /* access modifiers changed from: private */
    public String r;
    /* access modifiers changed from: private */
    public boolean s;
    private Handler t = new Handler();

    public static g a(String str, int i2, boolean z) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putString("extra_data", str);
        bundle.putBoolean("isdynamic", z);
        gVar.setArguments(bundle);
        f61176f = i2;
        return gVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getString("extra_data");
            this.s = arguments.getBoolean("isdynamic");
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof e) {
            this.p = (net.one97.paytm.recharge.coupons.c.a) activity;
            this.n = (e) activity;
        }
    }

    public final void a(IJRDataModel iJRDataModel, boolean z) {
        if (getActivity() != null) {
            this.f61183i = ((CJRBrowsePlanDescriptions) iJRDataModel).getDescription();
            ArrayList<CJRBrowsePlanDescription> arrayList = this.f61183i;
            if (arrayList == null || arrayList.size() <= 0) {
                this.k.setVisibility(8);
                this.m.setVisibility(0);
                this.o.setVisibility(0);
            } else {
                this.k.setVisibility(0);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                a aVar = (a) this.k.getAdapter();
                if (aVar != null) {
                    aVar.a(this.f61183i, z);
                }
            }
            this.l.setVisibility(8);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("CJRIndicativePlansFragments:Content", this.f61181g);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.browse_plans_item_layout, viewGroup, false);
        this.k = (ListView) inflate.findViewById(R.id.indicative_plans_list_view);
        this.q = new b();
        this.k.setOnScrollListener(this.q);
        com.paytm.utility.b.g((Context) getActivity());
        this.j = com.paytm.utility.b.f((Context) getActivity()) / 2;
        this.l = (ProgressBar) inflate.findViewById(R.id.loading);
        this.o = (RelativeLayout) inflate.findViewById(R.id.layout_progress_bar);
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.k.setAdapter(new a(getActivity(), R.layout.browser_plan_list, new ArrayList(), this.f61182h));
        this.m = (TextView) inflate.findViewById(R.id.plans_not_available);
        this.f61180d = (a) this.k.getAdapter();
        return inflate;
    }

    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<CJRBrowsePlanDescription> f61184a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61185b;

        /* renamed from: d  reason: collision with root package name */
        private LayoutInflater f61187d;

        /* renamed from: e  reason: collision with root package name */
        private int f61188e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Context f61189f;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public a(Context context, int i2, ArrayList<CJRBrowsePlanDescription> arrayList, boolean z) {
            this.f61187d = LayoutInflater.from(context);
            this.f61188e = i2;
            this.f61185b = z;
            this.f61184a = arrayList;
            this.f61189f = context;
        }

        public final void a(ArrayList<CJRBrowsePlanDescription> arrayList, boolean z) {
            this.f61184a = arrayList;
            this.f61185b = z;
            notifyDataSetChanged();
        }

        public final int getItemViewType(int i2) {
            ArrayList<CJRBrowsePlanDescription> arrayList = this.f61184a;
            if (arrayList == null || i2 < arrayList.size()) {
                return 0;
            }
            return 1;
        }

        public final int getCount() {
            ArrayList<CJRBrowsePlanDescription> arrayList = this.f61184a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        public final Object getItem(int i2) {
            if (this.f61184a.size() > 0) {
                return this.f61184a.get(i2);
            }
            return null;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1184a aVar = null;
            if (getItemViewType(i2) == 0) {
                View inflate = this.f61187d.inflate(this.f61188e, (ViewGroup) null);
                if (this.f61188e == R.layout.browser_plan_list) {
                    aVar = new C1184a(this, (byte) 0);
                    aVar.f61201b = (TextView) inflate.findViewById(R.id.validity_value);
                    aVar.f61202c = (TextView) inflate.findViewById(R.id.price_text);
                    aVar.f61203d = (TextView) inflate.findViewById(R.id.description_text);
                    aVar.f61204e = (TextView) inflate.findViewById(R.id.plan_description_value);
                    aVar.f61200a = (RoboTextView) inflate.findViewById(R.id.talktime_text);
                    aVar.f61205f = (TextView) inflate.findViewById(R.id.more_details_tv);
                    aVar.f61202c.setPadding(net.one97.paytm.common.utility.a.a(5, g.this.getContext()), g.this.j / 2, 0, g.this.j / 2);
                    inflate.setPadding(0, (g.this.j * 3) / 2, g.this.j, (g.this.j * 3) / 2);
                }
                inflate.setTag(aVar);
                if (this.f61188e != R.layout.browser_plan_list) {
                    return inflate;
                }
                final C1184a aVar2 = (C1184a) inflate.getTag();
                final CJRBrowsePlanDescription cJRBrowsePlanDescription = this.f61184a.get(i2);
                if (cJRBrowsePlanDescription.getLongRichDesc() == null || cJRBrowsePlanDescription.getLongRichDesc().get(0) == null) {
                    aVar2.f61201b.setVisibility(8);
                    aVar2.f61200a.setVisibility(8);
                    aVar2.f61203d.setVisibility(8);
                } else {
                    CJRBrowsePlansRichDesc cJRBrowsePlansRichDesc = cJRBrowsePlanDescription.getLongRichDesc().get(0);
                    CJRBrowsePlansDescAttributes attributes = cJRBrowsePlansRichDesc.getAttributes();
                    if (attributes != null) {
                        String talkTimeDisplayString = attributes.getTalkTimeDisplayString(g.this.getActivity());
                        if (!this.f61185b || TextUtils.isEmpty(talkTimeDisplayString)) {
                            aVar2.f61200a.setVisibility(8);
                        } else {
                            aVar2.f61200a.setText(talkTimeDisplayString);
                            aVar2.f61200a.setVisibility(0);
                        }
                        if (!TextUtils.isEmpty(attributes.getValidity())) {
                            aVar2.f61201b.setText(attributes.getValidityDisplayString(g.this.getActivity()));
                            aVar2.f61201b.setVisibility(0);
                        } else {
                            aVar2.f61201b.setVisibility(8);
                        }
                    } else {
                        aVar2.f61201b.setVisibility(8);
                        aVar2.f61200a.setVisibility(8);
                    }
                    String description = cJRBrowsePlansRichDesc.getDescription();
                    if (!TextUtils.isEmpty(description)) {
                        if (description.contains("•")) {
                            description = description.replaceAll("•", "");
                        }
                        aVar2.f61203d.setText(description);
                        aVar2.f61203d.setVisibility(0);
                        aVar2.f61203d.setMaxLines(2);
                        aVar2.f61203d.post(new Runnable() {
                            public final void run() {
                                if (aVar2.f61203d.getLineCount() > 2) {
                                    aVar2.f61205f.setVisibility(0);
                                    aVar2.f61203d.setMaxLines(2);
                                    aVar2.f61203d.setEllipsize(TextUtils.TruncateAt.END);
                                    return;
                                }
                                aVar2.f61205f.setVisibility(8);
                                aVar2.f61203d.setMaxLines(10);
                            }
                        });
                    } else {
                        aVar2.f61203d.setVisibility(8);
                    }
                }
                final String offerPrice = cJRBrowsePlanDescription.getOfferPrice();
                String str = cJRBrowsePlanDescription.getmPlanDescription();
                if (!TextUtils.isEmpty(str)) {
                    aVar2.f61204e.setText(str);
                    aVar2.f61204e.setVisibility(0);
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanDescription.getmPlanValidity())) {
                    aVar2.f61201b.setText(cJRBrowsePlanDescription.getPlanValidityDisplayString(this.f61189f));
                    aVar2.f61201b.setVisibility(0);
                }
                if (com.paytm.utility.b.K(offerPrice).booleanValue()) {
                    aVar2.f61202c.setText(g.this.getResources().getString(R.string.recharge_rs_without_space, new Object[]{offerPrice}));
                } else if (com.paytm.utility.b.a(Double.valueOf(Double.parseDouble(offerPrice)))) {
                    String valueOf = String.valueOf((int) Double.parseDouble(offerPrice));
                    aVar2.f61202c.setText(g.this.getResources().getString(R.string.recharge_rs_without_space, new Object[]{valueOf}));
                } else {
                    String valueOf2 = String.valueOf(com.paytm.utility.b.b(Double.parseDouble(offerPrice)));
                    aVar2.f61202c.setText(g.this.getResources().getString(R.string.recharge_rs_without_space, new Object[]{valueOf2}));
                }
                final String str2 = cJRBrowsePlanDescription.getmPlanGuiId();
                final String str3 = cJRBrowsePlanDescription.getmPlanName();
                final int i3 = i2;
                final CJRBrowsePlanDescription cJRBrowsePlanDescription2 = cJRBrowsePlanDescription;
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b2  */
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x00be  */
                    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onClick(android.view.View r22) {
                        /*
                            r21 = this;
                            r1 = r21
                            net.one97.paytm.recharge.common.fragment.g$a r0 = net.one97.paytm.recharge.common.fragment.g.a.this
                            net.one97.paytm.recharge.common.fragment.g r0 = net.one97.paytm.recharge.common.fragment.g.this
                            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                            if (r0 == 0) goto L_0x0102
                            java.util.HashMap r0 = new java.util.HashMap
                            r0.<init>()
                            r2 = 0
                            net.one97.paytm.recharge.common.fragment.g$a r3 = net.one97.paytm.recharge.common.fragment.g.a.this
                            net.one97.paytm.recharge.common.fragment.g r3 = net.one97.paytm.recharge.common.fragment.g.this
                            boolean r3 = r3.s
                            r4 = 0
                            if (r3 == 0) goto L_0x004f
                            net.one97.paytm.recharge.common.fragment.g$a r3 = net.one97.paytm.recharge.common.fragment.g.a.this
                            java.util.ArrayList r3 = r3.f61184a
                            if (r3 == 0) goto L_0x00a6
                            net.one97.paytm.recharge.common.fragment.g$a r3 = net.one97.paytm.recharge.common.fragment.g.a.this
                            java.util.ArrayList r3 = r3.f61184a
                            int r5 = r6
                            java.lang.Object r3 = r3.get(r5)
                            if (r3 == 0) goto L_0x00a6
                            net.one97.paytm.recharge.common.fragment.g$a r0 = net.one97.paytm.recharge.common.fragment.g.a.this
                            java.util.ArrayList r0 = r0.f61184a
                            int r3 = r6
                            java.lang.Object r0 = r0.get(r3)
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription r0 = (net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription) r0
                            java.lang.String r3 = r0.getTransactionType()
                            java.util.HashMap r0 = r0.getmDynamicDataObject()
                            java.lang.String r5 = "TransactionType"
                            r0.put(r5, r3)
                            goto L_0x00a6
                        L_0x004f:
                            net.one97.paytm.recharge.common.fragment.g$a r3 = net.one97.paytm.recharge.common.fragment.g.a.this
                            java.util.ArrayList r3 = r3.f61184a
                            if (r3 == 0) goto L_0x00a6
                            net.one97.paytm.recharge.common.fragment.g$a r3 = net.one97.paytm.recharge.common.fragment.g.a.this
                            java.util.ArrayList r3 = r3.f61184a
                            int r5 = r6
                            java.lang.Object r3 = r3.get(r5)
                            if (r3 == 0) goto L_0x00a6
                            net.one97.paytm.recharge.common.fragment.g$a r3 = net.one97.paytm.recharge.common.fragment.g.a.this
                            java.util.ArrayList r3 = r3.f61184a
                            int r5 = r6
                            java.lang.Object r3 = r3.get(r5)
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription r3 = (net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription) r3
                            java.util.ArrayList r5 = r3.getLongRichDesc()
                            if (r5 == 0) goto L_0x00a6
                            java.util.ArrayList r5 = r3.getLongRichDesc()
                            java.lang.Object r5 = r5.get(r4)
                            if (r5 == 0) goto L_0x00a6
                            java.util.ArrayList r2 = r3.getLongRichDesc()
                            java.lang.Object r2 = r2.get(r4)
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlansRichDesc r2 = (net.one97.paytm.recharge.model.mobile.CJRBrowsePlansRichDesc) r2
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlansDescAttributes r3 = r2.getAttributes()
                            net.one97.paytm.recharge.common.fragment.g$a r5 = net.one97.paytm.recharge.common.fragment.g.a.this
                            net.one97.paytm.recharge.common.fragment.g r5 = net.one97.paytm.recharge.common.fragment.g.this
                            java.lang.String r5 = r5.r
                            r3.setPlanType(r5)
                            java.lang.String r2 = r2.getDescription()
                            r3.setPlanDescription(r2)
                            r8 = r0
                            r11 = r3
                            goto L_0x00a8
                        L_0x00a6:
                            r8 = r0
                            r11 = r2
                        L_0x00a8:
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription r0 = r7
                            if (r0 == 0) goto L_0x00be
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription$AttributesObject r0 = r0.getAttributes()
                            if (r0 == 0) goto L_0x00be
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription r0 = r7
                            net.one97.paytm.recharge.model.mobile.CJRBrowsePlanDescription$AttributesObject r0 = r0.getAttributes()
                            boolean r4 = r0.isTopUp()
                            r7 = r4
                            goto L_0x00bf
                        L_0x00be:
                            r7 = 0
                        L_0x00bf:
                            net.one97.paytm.recharge.common.fragment.g$a r0 = net.one97.paytm.recharge.common.fragment.g.a.this
                            net.one97.paytm.recharge.common.fragment.g r0 = net.one97.paytm.recharge.common.fragment.g.this
                            net.one97.paytm.recharge.common.e.e r0 = r0.n
                            if (r0 == 0) goto L_0x00db
                            net.one97.paytm.recharge.common.fragment.g$a r0 = net.one97.paytm.recharge.common.fragment.g.a.this
                            net.one97.paytm.recharge.common.fragment.g r0 = net.one97.paytm.recharge.common.fragment.g.this
                            net.one97.paytm.recharge.common.e.e r5 = r0.n
                            java.lang.String r6 = r8
                            java.lang.String r9 = r9
                            java.lang.String r10 = r10
                            r12 = 0
                            r5.a(r6, r7, r8, r9, r10, r11, r12)
                        L_0x00db:
                            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ Exception -> 0x00fa }
                            net.one97.paytm.recharge.common.fragment.g$a r0 = net.one97.paytm.recharge.common.fragment.g.a.this     // Catch:{ Exception -> 0x00fa }
                            android.content.Context r0 = r0.f61189f     // Catch:{ Exception -> 0x00fa }
                            r13.<init>(r0)     // Catch:{ Exception -> 0x00fa }
                            java.lang.String r14 = "DTH (new)"
                            java.lang.String r15 = "plan_selected"
                            java.lang.String r16 = ""
                            java.lang.String r0 = r8     // Catch:{ Exception -> 0x00fa }
                            java.lang.String r18 = ""
                            java.lang.String r19 = ""
                            java.lang.String r20 = ""
                            r17 = r0
                            r13.a(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x00fa }
                            return
                        L_0x00fa:
                            r0 = move-exception
                            java.lang.String r0 = r0.getMessage()
                            com.paytm.utility.q.d(r0)
                        L_0x0102:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.g.a.AnonymousClass2.onClick(android.view.View):void");
                    }
                });
                aVar2.f61205f.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        g.this.n.a(cJRBrowsePlanDescription, g.this.r);
                    }
                });
                return inflate;
            }
            View inflate2 = this.f61187d.inflate(R.layout.recharge_empty_view, (ViewGroup) null);
            inflate2.setMinimumHeight(g.f61176f);
            return inflate2;
        }

        /* renamed from: net.one97.paytm.recharge.common.fragment.g$a$a  reason: collision with other inner class name */
        class C1184a {

            /* renamed from: a  reason: collision with root package name */
            RoboTextView f61200a;

            /* renamed from: b  reason: collision with root package name */
            TextView f61201b;

            /* renamed from: c  reason: collision with root package name */
            TextView f61202c;

            /* renamed from: d  reason: collision with root package name */
            TextView f61203d;

            /* renamed from: e  reason: collision with root package name */
            TextView f61204e;

            /* renamed from: f  reason: collision with root package name */
            TextView f61205f;

            private C1184a() {
            }

            /* synthetic */ C1184a(a aVar, byte b2) {
                this();
            }
        }
    }

    class b implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        private int f61208b = 10;

        /* renamed from: c  reason: collision with root package name */
        private int f61209c = 0;

        /* renamed from: d  reason: collision with root package name */
        private boolean f61210d = true;

        public b() {
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (this.f61210d && i4 > this.f61209c) {
                this.f61210d = false;
                this.f61209c = i4;
            }
            if (!this.f61210d && i4 - i3 <= this.f61208b + i2 && g.this.p != null) {
                g.this.p.b();
                this.f61210d = true;
            }
            g gVar = g.this;
            gVar.f61177a = i2;
            gVar.f61178b = i3;
            gVar.f61179c = i4;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 0) {
                net.one97.paytm.recharge.coupons.c.a unused = g.this.p;
                if (g.this.f61177a + g.this.f61178b >= g.this.f61179c && g.this.p != null) {
                    g.this.p.b();
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.coupons.c.a unused2 = g.this.p;
        }
    }
}
