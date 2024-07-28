package net.one97.paytm.recharge.legacy.ordersummary.a;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.f;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class c extends b implements net.one97.paytm.recharge.ordersummary.f.a {
    LinearLayout j;
    StoreFrontGAHandler k = new a(this);
    private LinearLayout p;
    private String q;
    private ProgressBar r;
    private ImageView s;
    /* access modifiers changed from: private */
    public String t = "";
    private HashMap u;

    public View a(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void b() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_success_recharge_store_front, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r4 = r4.getOrderedCartList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r3, r0)
            if (r4 == 0) goto L_0x000e
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r4 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r0 = "storefront : screen re-created"
            r4.debugLog(r0)
        L_0x000e:
            android.os.Bundle r4 = r2.getArguments()
            if (r4 != 0) goto L_0x001c
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r3 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r4 = "storefront : argument is null"
            r3.debugLog(r4)
            return
        L_0x001c:
            net.one97.paytm.recharge.ordersummary.b.a r4 = r2.d()
            net.one97.paytm.recharge.ordersummary.b.a r0 = r2.d()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r0.f63998b
            r4.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r2.n
            r0 = 0
            if (r4 == 0) goto L_0x003c
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x003c
            r1 = 0
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            if (r4 == 0) goto L_0x004a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r2.n
            if (r1 == 0) goto L_0x0047
            java.lang.String r0 = r1.getId()
        L_0x0047:
            r4.setOrderId(r0)
        L_0x004a:
            int r0 = net.one97.paytm.recharge.R.id.container_details_data
            android.view.View r0 = r3.findViewById(r0)
            if (r0 == 0) goto L_0x0092
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r2.j = r0
            int r0 = net.one97.paytm.recharge.R.id.status_progress_bar
            android.view.View r0 = r3.findViewById(r0)
            if (r0 == 0) goto L_0x008a
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r2.r = r0
            int r0 = net.one97.paytm.recharge.R.id.img_success
            android.view.View r0 = r3.findViewById(r0)
            if (r0 == 0) goto L_0x0082
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2.s = r0
            int r0 = net.one97.paytm.recharge.R.id.container_details_data
            r2.i()
            r2.c(r3)
            if (r4 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            r2.e(r4)
            r2.n()
            return
        L_0x0082:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type android.widget.ImageView"
            r3.<init>(r4)
            throw r3
        L_0x008a:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type android.widget.ProgressBar"
            r3.<init>(r4)
            throw r3
        L_0x0092:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type android.widget.LinearLayout"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.c.a(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (getContext() instanceof AJRechargeOrderSummaryActivity) {
            Context context = getContext();
            if (context != null) {
                ((AJRechargeOrderSummaryActivity) context).a(0);
                Context context2 = getContext();
                if (context2 != null) {
                    ((AJRechargeOrderSummaryActivity) context2).b();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.containsKey("store_url")) {
                Bundle arguments2 = getArguments();
                this.q = arguments2 != null ? arguments2.getString("store_url") : null;
            }
            if (!TextUtils.isEmpty(this.q)) {
                d dVar = d.f64967a;
                a("update_store_front_weex_page", (Object) d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
            }
        }
    }

    public final void e(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedCart");
        if ("7".equals(cJROrderedCart.getItemStatus())) {
            ImageView imageView = this.s;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ProgressBar progressBar = this.r;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } else if ("6".equals(cJROrderedCart.getItemStatus()) || "34".equals(cJROrderedCart.getItemStatus())) {
            ImageView imageView2 = this.s;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.s;
            if (imageView3 != null) {
                f b2 = f.b();
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                imageView3.setImageDrawable(b2.a(context, R.drawable.ic_recharge_order_summary_failed));
            }
            ProgressBar progressBar2 = this.r;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        } else {
            ImageView imageView4 = this.s;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
            ProgressBar progressBar3 = this.r;
            if (progressBar3 != null) {
                progressBar3.setVisibility(0);
            }
        }
    }

    public void a(String str, Object obj) {
        k.c(str, "tag");
        this.q = k.a(this.q, (Object) com.paytm.utility.c.a(getContext(), true));
        String postRequestBodyForV2 = CJRRechargeUtilities.INSTANCE.postRequestBodyForV2(getContext(), "PG page", "Summary Page");
        HashMap<String, String> n = com.paytm.utility.b.n();
        if (com.paytm.utility.b.c(getContext())) {
            new net.one97.paytm.recharge.common.f.c(str, this.q, (ai) new b(this), (IJRPaytmDataModel) new CJRHomePageV2(), (Map<String, String>) null, (Map<String, String>) n, postRequestBodyForV2, obj).a();
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63057a;

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
        }

        b(c cVar) {
            this.f63057a = cVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel != null) {
                try {
                    if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                        Context context = null;
                        View inflate = LayoutInflater.from(this.f63057a.getContext()).inflate(R.layout.banner_custom_widget, (ViewGroup) null);
                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.dummy_sticky_header);
                        View findViewById = inflate.findViewById(R.id.infinite_border);
                        CJRCustomRecyclerView cJRCustomRecyclerView = (CJRCustomRecyclerView) inflate.findViewById(R.id.home_list);
                        FragmentActivity activity = this.f63057a.getActivity();
                        if (activity != null) {
                            context = activity.getBaseContext();
                        }
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        k.a((Object) cJRCustomRecyclerView, "mMarketPlaceList");
                        cJRCustomRecyclerView.setLayoutManager(linearLayoutManager);
                        if (this.f63057a.getActivity() != null) {
                            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                            net.one97.paytm.recharge.ordersummary.f.a aVar = this.f63057a;
                            FragmentActivity activity2 = this.f63057a.getActivity();
                            if (activity2 == null) {
                                k.a();
                            }
                            k.a((Object) activity2, "activity!!");
                            k.a((Object) recyclerView, "fixedInfiniteGridHeader");
                            k.a((Object) findViewById, "infiniteTabBorder");
                            cJRRechargeUtilities.getHomeFragmentWidgetAdapter(aVar, activity2, (CJRHomePageV2) iJRPaytmDataModel, "scds", recyclerView, (CJRItem) null, findViewById, new a(this, cJRCustomRecyclerView, inflate), this.f63057a.k);
                        }
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
            }
        }

        public static final class a implements net.one97.paytm.recharge.ordersummary.f.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f63058a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRCustomRecyclerView f63059b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f63060c;

            a(b bVar, CJRCustomRecyclerView cJRCustomRecyclerView, View view) {
                this.f63058a = bVar;
                this.f63059b = cJRCustomRecyclerView;
                this.f63060c = view;
            }

            public final void a(RecyclerView.a<RecyclerView.v> aVar, List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list) {
                k.c(list, "viewList");
                if (aVar != null) {
                    CJRCustomRecyclerView cJRCustomRecyclerView = this.f63059b;
                    k.a((Object) cJRCustomRecyclerView, "mMarketPlaceList");
                    cJRCustomRecyclerView.setNestedScrollingEnabled(false);
                    CJRCustomRecyclerView cJRCustomRecyclerView2 = this.f63059b;
                    k.a((Object) cJRCustomRecyclerView2, "mMarketPlaceList");
                    cJRCustomRecyclerView2.setAdapter(aVar);
                    LinearLayout linearLayout = this.f63058a.f63057a.j;
                    if (linearLayout != null) {
                        linearLayout.addView(this.f63060c);
                    }
                    LinearLayout linearLayout2 = this.f63058a.f63057a.j;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                }
            }
        }
    }

    public static final class a extends StoreFrontGAHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63056a;

        public final int getClient() {
            return 1004;
        }

        a(c cVar) {
            this.f63056a = cVar;
        }

        public final String getScreenName() {
            return this.f63056a.d().r();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
            r0 = java.lang.String.valueOf((r0 = r0.getProductDetail()).getVerticalId());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getVerticalID() {
            /*
                r2 = this;
                net.one97.paytm.recharge.legacy.ordersummary.a.c r0 = r2.f63056a
                net.one97.paytm.recharge.ordersummary.b.a r0 = r0.d()
                net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
                if (r0 == 0) goto L_0x001c
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
                if (r0 == 0) goto L_0x001c
                long r0 = r0.getVerticalId()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                if (r0 != 0) goto L_0x001e
            L_0x001c:
                java.lang.String r0 = ""
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.c.a.getVerticalID():java.lang.String");
        }

        public final String getClientRequestID() {
            return this.f63056a.t;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r13 = r13.getOrderedCartList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.view.View r13) {
        /*
            r12 = this;
            java.lang.String r0 = "rootView"
            kotlin.g.b.k.c(r13, r0)
            int r0 = net.one97.paytm.recharge.R.id.container_main
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.LinearLayout"
            if (r0 == 0) goto L_0x00f3
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r12.p = r0
            int r0 = net.one97.paytm.recharge.R.id.container_recharge
            android.view.View r0 = r13.findViewById(r0)
            if (r0 == 0) goto L_0x00ed
            int r0 = net.one97.paytm.recharge.R.id.footer_strip
            android.view.View r0 = r13.findViewById(r0)
            if (r0 == 0) goto L_0x00e5
            int r1 = net.one97.paytm.recharge.R.id.txt_recharge_status
            android.view.View r1 = r13.findViewById(r1)
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TextView"
            if (r1 == 0) goto L_0x00df
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r3 = net.one97.paytm.recharge.R.id.txt_recharge_amount
            android.view.View r3 = r13.findViewById(r3)
            if (r3 == 0) goto L_0x00d9
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.recharge.R.id.txt_recharge_number
            android.view.View r4 = r13.findViewById(r4)
            if (r4 == 0) goto L_0x00d3
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = net.one97.paytm.recharge.R.id.view_detail
            android.view.View r13 = r13.findViewById(r5)
            if (r13 == 0) goto L_0x00cd
            android.widget.TextView r13 = (android.widget.TextView) r13
            r2 = r12
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r13.setOnClickListener(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r13 = r12.n
            r2 = 0
            r5 = 0
            if (r13 == 0) goto L_0x0067
            java.util.ArrayList r13 = r13.getOrderedCartList()
            if (r13 == 0) goto L_0x0067
            java.lang.Object r13 = r13.get(r5)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r13 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r13
            r7 = r13
            goto L_0x0068
        L_0x0067:
            r7 = r2
        L_0x0068:
            if (r7 == 0) goto L_0x006e
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r7.getProductDetail()
        L_0x006e:
            java.lang.String r13 = r12.a((net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail) r2)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r1.setText(r13)
            int r13 = net.one97.paytm.recharge.R.string.rupee_re
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r12.k()
            java.util.ArrayList r2 = r2.getOrderedCartList()
            if (r2 == 0) goto L_0x0094
            java.lang.Object r2 = r2.get(r5)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2
            if (r2 == 0) goto L_0x0094
            java.lang.String r2 = r2.getAggregateItemPrice()
            if (r2 != 0) goto L_0x0096
        L_0x0094:
            java.lang.String r2 = ""
        L_0x0096:
            java.lang.String r2 = com.paytm.utility.b.x((java.lang.String) r2)
            r1[r5] = r2
            java.lang.String r13 = r12.getString(r13, r1)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r3.setText(r13)
            android.text.SpannableString r13 = r12.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r7)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r4.setText(r13)
            android.widget.LinearLayout r13 = r12.p
            if (r13 != 0) goto L_0x00b5
            kotlin.g.b.k.a()
        L_0x00b5:
            int r8 = r13.indexOfChild(r0)
            android.widget.LinearLayout r13 = r12.p
            if (r13 != 0) goto L_0x00c0
            kotlin.g.b.k.a()
        L_0x00c0:
            r9 = r13
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            android.widget.LinearLayout$LayoutParams r10 = r12.j()
            r11 = 0
            r6 = r12
            r6.a(r7, r8, r9, r10, r11)
            return
        L_0x00cd:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x00d3:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x00d9:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x00df:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x00e5:
            kotlin.u r13 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.view.View"
            r13.<init>(r0)
            throw r13
        L_0x00ed:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r1)
            throw r13
        L_0x00f3:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r1)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.c.c(android.view.View):void");
    }

    public LinearLayout.LayoutParams j() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public final SpannableString a(CJROrderedCart cJROrderedCart) {
        String str;
        String str2;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        String str3 = "";
        if (cJROrderedCart == null || (productDetail = cJROrderedCart.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getOperatorDisplayLabel()) == null) {
            str = str3;
        }
        if (cJROrderedCart == null || (str2 = cJROrderedCart.getRechargeNumber()) == null) {
            str2 = str3;
        }
        int i2 = R.string.store_front_os_recharge_number;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(str)) {
            str3 = " ";
        }
        sb.append(str3);
        sb.append(str2);
        objArr[0] = sb.toString();
        String string = getString(i2, objArr);
        k.a((Object) string, "getString(R.string.store…chargeNumber).toString())");
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        int a2 = p.a(charSequence, str2, 0, false, 6);
        if (!TextUtils.isEmpty(str2) && a2 != -1) {
            spannableString.setSpan(new StyleSpan(1), a2, string.length(), 33);
        }
        return spannableString;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (getContext() instanceof AJRechargeOrderSummaryActivity) {
            Context context = getContext();
            if (context != null) {
                ((AJRechargeOrderSummaryActivity) context).a(0);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
            }
        }
        b();
    }

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.view_detail;
        if (valueOf == null || valueOf.intValue() != i2) {
            super.onClick(view);
        } else if (getActivity() instanceof AJRechargeOrderSummaryActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRechargeOrderSummaryActivity) activity).a(this.n, false, (Map<String, ? extends View>) null);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
    }
}
