package net.one97.paytm.recharge.ordersummary.c;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public final class a extends f implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final C1256a f64019d = new C1256a((byte) 0);
    /* access modifiers changed from: private */
    public static final String k;

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f64020a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.recharge.ordersummary.f.b f64021b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnDismissListener f64022c;

    /* renamed from: e  reason: collision with root package name */
    private CJROrderedCart f64023e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.b.a f64024f;

    /* renamed from: g  reason: collision with root package name */
    private CJROSActionResponseV2 f64025g;

    /* renamed from: h  reason: collision with root package name */
    private String f64026h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f64027i;
    private int j = CJROtherRechargeItemsWidget.k;
    private HashMap l;

    static final class d extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (!TextUtils.isEmpty(str) && this.this$0.f64027i) {
                net.one97.paytm.recharge.ordersummary.f.b c2 = this.this$0.f64021b;
                if (c2 != null) {
                    c2.o();
                }
                this.this$0.f64027i = false;
                net.one97.paytm.recharge.ordersummary.f.b c3 = this.this$0.f64021b;
                if (c3 != null) {
                    String string = this.this$0.getString(R.string.terms_and_conditions_title);
                    k.a((Object) string, "getString(R.string.terms_and_conditions_title)");
                    c3.b(string, str);
                }
            }
        }
    }

    public a() {
        CJROtherRechargeItemsWidget.b bVar = CJROtherRechargeItemsWidget.f64459b;
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.c.a$a  reason: collision with other inner class name */
    public static final class C1256a {
        private C1256a() {
        }

        public /* synthetic */ C1256a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = a.class.getSimpleName();
        k.a((Object) simpleName, "CJRInsuranceDetailBottom…V8::class.java.simpleName");
        k = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("recharge_item") : null;
        if (!(serializable instanceof CJROrderedCart)) {
            serializable = null;
        }
        this.f64023e = (CJROrderedCart) serializable;
        if (this.f64023e == null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Insurance Ordered Item is must required, use setter method to achieve");
            dismissAllowingStateLoss();
            return;
        }
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        HashMap d2 = net.one97.paytm.recharge.ordersummary.h.c.f64335e;
        CJROrderedCart cJROrderedCart = this.f64023e;
        if (cJROrderedCart == null) {
            k.a();
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = (net.one97.paytm.recharge.ordersummary.b.a) d2.get(String.valueOf(cJROrderedCart.getId()));
        if (aVar2 == null) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a(net.one97.paytm.recharge.ordersummary.b.a.class.getSimpleName() + " is must required, use setter method to achieve");
            dismissAllowingStateLoss();
            return;
        }
        this.f64024f = aVar2;
        HashMap<Long, CJROSActionResponseV2> hashMap = aVar2.m;
        CJROrderedCart cJROrderedCart2 = this.f64023e;
        if (cJROrderedCart2 == null) {
            k.a();
        }
        this.f64025g = hashMap.get(Long.valueOf(cJROrderedCart2.getId()));
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            CJROtherRechargeItemsWidget.b bVar = CJROtherRechargeItemsWidget.f64459b;
            i2 = arguments2.getInt("layoutType", CJROtherRechargeItemsWidget.k);
        } else {
            CJROtherRechargeItemsWidget.b bVar2 = CJROtherRechargeItemsWidget.f64459b;
            i2 = CJROtherRechargeItemsWidget.k;
        }
        this.j = i2;
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_dialog_order_insurance_details_v8, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CJROrderSummaryAction cJROrderSummaryAction;
        CJROSActionItemV2 cJROSActionItemV2;
        y<String> yVar;
        String str;
        String merchantName;
        boolean z;
        String merchantName2;
        List<CJROSActionItemV2> actions;
        ArrayList<CJROrderSummaryAction> action;
        View view2 = view;
        k.c(view2, "view");
        TextView textView = (TextView) view2.findViewById(R.id.btn_download_policy);
        TextView textView2 = (TextView) view2.findViewById(R.id.btn_view_tnc);
        TextView textView3 = (TextView) view2.findViewById(R.id.btn_cancel);
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            CJROrderedCart cJROrderedCart = this.f64023e;
            String b2 = fVar.b(cJROrderedCart != null ? cJROrderedCart.getMetaDataResponse() : null);
            if (!TextUtils.isEmpty(b2)) {
                JSONObject jSONObject = new JSONObject(b2);
                if (jSONObject.has("insurance_url")) {
                    this.f64026h = jSONObject.getString("insurance_url");
                }
            }
        } catch (Exception unused) {
        }
        String str2 = "";
        if (!TextUtils.isEmpty(this.f64026h)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.FETCH_INSURANCE_POLICY_AUTO.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setOtherDetails("From Order Summary");
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64024f;
            if (aVar != null) {
                String str3 = this.f64026h;
                if (str3 == null) {
                    str3 = str2;
                }
                aVar.a("fetch_insurance_data", str3, (Object) a2);
            }
        }
        if (!TextUtils.isEmpty(this.f64026h)) {
            textView2.setOnClickListener(this);
            k.a((Object) textView2, "btnViewTnC");
            textView2.setVisibility(0);
        }
        CJROrderedCart cJROrderedCart2 = this.f64023e;
        if (cJROrderedCart2 == null || (action = cJROrderedCart2.getAction()) == null) {
            cJROrderSummaryAction = null;
        } else {
            cJROrderSummaryAction = null;
            for (CJROrderSummaryAction cJROrderSummaryAction2 : action) {
                k.a((Object) cJROrderSummaryAction2, "it");
                if (p.a("Invoice", cJROrderSummaryAction2.getActionName(), true) || p.a(CJROSActionItemV2.Companion.getACTION_TYPE_DOWNLOAD_INVOICE(), cJROrderSummaryAction2.getmType(), true)) {
                    cJROrderSummaryAction = cJROrderSummaryAction2;
                }
            }
        }
        if (cJROrderSummaryAction != null) {
            k.a((Object) textView, "btnDownloadPolicy");
            textView.setTag(cJROrderSummaryAction);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        CJROSActionResponseV2 cJROSActionResponseV2 = this.f64025g;
        if (cJROSActionResponseV2 == null || (actions = cJROSActionResponseV2.getActions()) == null) {
            cJROSActionItemV2 = null;
        } else {
            cJROSActionItemV2 = null;
            for (CJROSActionItemV2 cJROSActionItemV22 : actions) {
                if (p.a("button", cJROSActionItemV22.getUiControl(), true) && p.a(CJROSActionItemV2.Companion.getACTION_TYPE_CANCEL(), cJROSActionItemV22.getLabel(), true)) {
                    cJROSActionItemV2 = cJROSActionItemV22;
                }
            }
        }
        if (cJROSActionItemV2 != null) {
            k.a((Object) textView3, "btnCancel");
            textView3.setTag(cJROSActionItemV2);
            textView3.setOnClickListener(this);
            textView3.setVisibility(0);
        }
        View findViewById = view2.findViewById(R.id.close_button);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64024f;
        if (aVar2 != null) {
            yVar = aVar2.p;
        } else {
            yVar = null;
        }
        g.a(this, yVar, new d(this));
        int i2 = this.j;
        CJROtherRechargeItemsWidget.b bVar = CJROtherRechargeItemsWidget.f64459b;
        if (i2 == CJROtherRechargeItemsWidget.m) {
            TextView textView4 = (TextView) view2.findViewById(R.id.txt_title);
            TextView textView5 = (TextView) view2.findViewById(R.id.insurer);
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_insurance_details);
            TextView textView6 = (TextView) view2.findViewById(R.id.txt_tnc);
            TextView textView7 = (TextView) view2.findViewById(R.id.btn_download_policy);
            TextView textView8 = (TextView) view2.findViewById(R.id.btn_cancel);
            k.a((Object) textView4, "dialogTitle");
            textView4.setText(view.getContext().getString(R.string.v8_os_other_items_insurance_title_dialog));
            CJROrderedCart cJROrderedCart3 = this.f64023e;
            if (cJROrderedCart3 == null) {
                k.a();
            }
            CJROrderSummaryProductDetail productDetail = cJROrderedCart3.getProductDetail();
            k.a((Object) textView5, "insurer");
            c.a aVar3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            if (!(productDetail == null || (merchantName2 = productDetail.getMerchantName()) == null)) {
                str2 = merchantName2;
            }
            textView5.setText(c.a.a(str2));
            if (!TextUtils.isEmpty(productDetail != null ? productDetail.getReturnPolicyText() : null)) {
                k.a((Object) textView6, "tnc");
                textView6.setText(productDetail != null ? productDetail.getReturnPolicyText() : null);
                z = false;
                textView6.setVisibility(0);
            } else {
                z = false;
            }
            CJROrderedCart cJROrderedCart4 = this.f64023e;
            if (cJROrderedCart4 == null) {
                k.a();
            }
            List<o<String, String>> a3 = a(cJROrderedCart4);
            k.a((Object) recyclerView, "recycler");
            recyclerView.setNestedScrollingEnabled(z);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new c(a3));
            k.a((Object) textView7, "btnDownloadPolicy");
            textView7.setText(view.getContext().getString(R.string.v8_os_other_items_insurance_download_policy));
            k.a((Object) textView8, "btnCancel");
            textView8.setText(view.getContext().getString(R.string.v8_os_other_items_insurance_cancel_insurance));
            return;
        }
        CJROtherRechargeItemsWidget.b bVar2 = CJROtherRechargeItemsWidget.f64459b;
        if (i2 == CJROtherRechargeItemsWidget.k) {
            TextView textView9 = (TextView) view2.findViewById(R.id.txt_title);
            TextView textView10 = (TextView) view2.findViewById(R.id.insurer);
            RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.recycler_insurance_details);
            TextView textView11 = (TextView) view2.findViewById(R.id.txt_tnc);
            TextView textView12 = (TextView) view2.findViewById(R.id.title_insurer);
            TextView textView13 = (TextView) view2.findViewById(R.id.amount_label);
            TextView textView14 = (TextView) view2.findViewById(R.id.amount);
            String str4 = str2;
            TextView textView15 = (TextView) view2.findViewById(R.id.btn_download_policy);
            String str5 = "btnCancel";
            TextView textView16 = (TextView) view2.findViewById(R.id.btn_cancel);
            k.a((Object) textView12, "operatorTitle");
            textView12.setVisibility(8);
            k.a((Object) recyclerView2, "recycler");
            recyclerView2.setVisibility(8);
            c.a aVar4 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            CJROrderedCart cJROrderedCart5 = this.f64023e;
            if (cJROrderedCart5 == null) {
                k.a();
            }
            CJROrderSummaryProductDetail productDetail2 = cJROrderedCart5.getProductDetail();
            if (!(productDetail2 == null || (merchantName = productDetail2.getMerchantName()) == null)) {
                str4 = merchantName;
            }
            CharSequence a4 = c.a.a(str4);
            if (!TextUtils.isEmpty(a4)) {
                k.a((Object) textView10, "insurer");
                textView10.setText(a4);
            } else {
                k.a((Object) textView10, "insurer");
                textView10.setVisibility(8);
            }
            CJROrderedCart cJROrderedCart6 = this.f64023e;
            if (cJROrderedCart6 == null) {
                k.a();
            }
            CJROrderSummaryProductDetail productDetail3 = cJROrderedCart6.getProductDetail();
            CJRAttributes attributes = productDetail3 != null ? productDetail3.getAttributes() : null;
            c.a aVar5 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            if (attributes == null || (str = attributes.getPayTypeLabel()) == null) {
                str = attributes != null ? attributes.getServiceLabel() : null;
            }
            String a5 = c.a.a(str);
            CharSequence charSequence = a5;
            if (!TextUtils.isEmpty(charSequence)) {
                k.a((Object) textView9, "dialogTitle");
                textView9.setText(view.getContext().getString(R.string.multi_item_bottom_sheet_title, new Object[]{a5}));
            } else {
                k.a((Object) textView9, "dialogTitle");
                textView9.setText(view.getContext().getString(R.string.v8_os_order_details_header_2));
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (textView13 != null) {
                    textView13.setText(view.getContext().getString(R.string.multi_item_paytype_amount, new Object[]{a5}));
                }
            } else if (textView13 != null) {
                textView13.setText(view.getContext().getString(R.string.amount_re));
            }
            k.a((Object) textView13, "amountLabel");
            textView13.setVisibility(0);
            k.a((Object) textView14, "amount");
            net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.f64024f;
            if (aVar6 == null) {
                k.a();
            }
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            CJROrderedCart cJROrderedCart7 = this.f64023e;
            if (cJROrderedCart7 == null) {
                k.a();
            }
            textView14.setText(aVar6.g(context, cJROrderedCart7));
            textView14.setVisibility(0);
            net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.f64024f;
            if (aVar7 == null) {
                k.a();
            }
            HashMap<Long, CJROSActionResponseV2> hashMap = aVar7.m;
            CJROrderedCart cJROrderedCart8 = this.f64023e;
            if (cJROrderedCart8 == null) {
                k.a();
            }
            CJROSActionResponseV2 cJROSActionResponseV22 = hashMap.get(Long.valueOf(cJROrderedCart8.getId()));
            if (!TextUtils.isEmpty(cJROSActionResponseV22 != null ? cJROSActionResponseV22.getMessage() : null)) {
                k.a((Object) textView11, "tnc");
                textView11.setText(cJROSActionResponseV22 != null ? cJROSActionResponseV22.getMessage() : null);
                textView11.setVisibility(0);
            }
            k.a((Object) textView15, "btnDownloadPolicy");
            textView15.setText(view.getContext().getString(R.string.extra_option_download_invoice));
            if (!TextUtils.isEmpty(charSequence)) {
                k.a((Object) textView16, str5);
                textView16.setText(view.getContext().getString(R.string.cancel_paytype, new Object[]{a5}));
                return;
            }
            k.a((Object) textView16, str5);
            textView16.setText(view.getContext().getString(R.string.cancel_option_str));
        }
    }

    public static final class c extends RecyclerView.a<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f64031a;

        c(List list) {
            this.f64031a = list;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b bVar = (b) vVar;
            k.c(bVar, "holder");
            o oVar = (o) this.f64031a.get(i2);
            boolean z = true;
            int i3 = 0;
            if (i2 != getItemCount() - 1) {
                z = false;
            }
            k.c(oVar, "pair");
            TextView textView = bVar.f64028a;
            k.a((Object) textView, "itemName");
            textView.setText((CharSequence) oVar.getFirst());
            TextView textView2 = bVar.f64029b;
            k.a((Object) textView2, "itemAmount");
            textView2.setText((CharSequence) oVar.getSecond());
            View view = bVar.f64030c;
            k.a((Object) view, "divider");
            if (z) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_insurance_policy_details_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…ails_item, parent, false)");
            return new b(inflate);
        }

        public final int getItemCount() {
            return this.f64031a.size();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<kotlin.o<java.lang.String, java.lang.String>> a(net.one97.paytm.common.entity.shopping.CJROrderedCart r10) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "insuranceItem"
            kotlin.g.b.k.c(r10, r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r10.getProductDetail()
            r2 = 0
            if (r1 == 0) goto L_0x0013
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0046 }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r10 = r10.getFullFillmentOject()     // Catch:{ Exception -> 0x0046 }
            if (r10 == 0) goto L_0x0027
            java.lang.String r10 = r10.getFulfillmentResponse()     // Catch:{ Exception -> 0x0046 }
            if (r10 != 0) goto L_0x0028
        L_0x0027:
            r10 = r0
        L_0x0028:
            r4.<init>(r10)     // Catch:{ Exception -> 0x0046 }
            net.one97.paytm.recharge.ordersummary.h.c$a r10 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0046 }
            java.lang.String r5 = "endDate"
            java.lang.String r10 = r10.a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0046 }
            net.one97.paytm.recharge.ordersummary.h.c$a r5 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = "policyId"
            java.lang.String r5 = r5.a((org.json.JSONObject) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x0044 }
            net.one97.paytm.recharge.ordersummary.h.c$a r6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0048 }
            java.lang.String r7 = "insuredAmt"
            java.lang.String r4 = r6.a((org.json.JSONObject) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0049
        L_0x0044:
            r5 = r0
            goto L_0x0048
        L_0x0046:
            r10 = r0
            r5 = r10
        L_0x0048:
            r4 = r0
        L_0x0049:
            if (r1 == 0) goto L_0x004f
            java.lang.String r2 = r1.getSumInsured()
        L_0x004f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0063
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = r1.getSumInsured()
            if (r1 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r4 = r1
            goto L_0x0063
        L_0x0062:
            r4 = r0
        L_0x0063:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x008a
            kotlin.o r0 = new kotlin.o
            int r1 = net.one97.paytm.recharge.R.string.v8_os_insurance_policy_sum_assured
            java.lang.String r1 = r9.getString(r1)
            int r2 = net.one97.paytm.recharge.R.string.rupee
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r8 = 0
            java.lang.String r4 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r4, (boolean) r6)
            r7[r8] = r4
            java.lang.String r2 = r9.getString(r2, r7)
            r0.<init>(r1, r2)
            r3.add(r0)
        L_0x008a:
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ae
            java.lang.String r0 = "dd MMM yyyy"
            java.lang.String r1 = "yyyy-MM-dd"
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ab.a(r10, r1, r0)
            java.lang.String r0 = "CJRRechargeUtilityConsta…nputFormat, outputFormat)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            kotlin.o r0 = new kotlin.o
            int r1 = net.one97.paytm.recharge.R.string.v8_os_insurance_policy_valid_until
            java.lang.String r1 = r9.getString(r1)
            r0.<init>(r1, r10)
            r3.add(r0)
        L_0x00ae:
            r10 = r5
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00c5
            kotlin.o r10 = new kotlin.o
            int r0 = net.one97.paytm.recharge.R.string.v8_os_insurance_policy_policy_id
            java.lang.String r0 = r9.getString(r0)
            r10.<init>(r0, r5)
            r3.add(r10)
        L_0x00c5:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.c.a.a(net.one97.paytm.common.entity.shopping.CJROrderedCart):java.util.List");
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f64022c;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        HashMap d2 = net.one97.paytm.recharge.ordersummary.h.c.f64335e;
        CJROrderedCart cJROrderedCart = this.f64023e;
        if (cJROrderedCart == null) {
            k.a();
        }
        d2.remove(String.valueOf(cJROrderedCart.getId()));
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener;
        y<String> yVar;
        y<String> yVar2;
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.close_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            return;
        }
        int i3 = R.id.btn_download_policy;
        if (valueOf != null && valueOf.intValue() == i3) {
            Object tag = view.getTag();
            if (tag != null) {
                CJROrderSummaryAction cJROrderSummaryAction = (CJROrderSummaryAction) tag;
                net.one97.paytm.recharge.ordersummary.f.b bVar = this.f64021b;
                if (bVar != null) {
                    bVar.a(cJROrderSummaryAction);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummaryAction");
        }
        int i4 = R.id.btn_view_tnc;
        if (valueOf != null && valueOf.intValue() == i4) {
            this.f64027i = true;
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64024f;
            if (!TextUtils.isEmpty((aVar == null || (yVar2 = aVar.p) == null) ? null : yVar2.getValue())) {
                this.f64027i = false;
                net.one97.paytm.recharge.ordersummary.f.b bVar2 = this.f64021b;
                if (bVar2 != null) {
                    String string = getString(R.string.terms_and_conditions_title);
                    k.a((Object) string, "getString(R.string.terms_and_conditions_title)");
                    net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64024f;
                    if (!(aVar2 == null || (yVar = aVar2.p) == null)) {
                        str = yVar.getValue();
                    }
                    bVar2.b(string, str);
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.ordersummary.f.b bVar3 = this.f64021b;
            if (bVar3 != null) {
                bVar3.at_();
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f64024f;
            if (aVar3 != null && !aVar3.q) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.FETCH_INSURANCE_POLICY_MANUAL.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    flowName3.setOtherDetails("From Order Summary");
                }
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f64024f;
                if (aVar4 != null) {
                    String str2 = this.f64026h;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar4.a("fetch_insurance_data", str2, (Object) a2);
                    return;
                }
                return;
            }
            return;
        }
        int i5 = R.id.btn_cancel;
        if (valueOf != null && valueOf.intValue() == i5 && (onClickListener = this.f64020a) != null) {
            onClickListener.onClick(view);
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f64028a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f64029b;

        /* renamed from: c  reason: collision with root package name */
        final View f64030c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f64028a = (TextView) view.findViewById(R.id.policy_detail_item_name);
            this.f64029b = (TextView) view.findViewById(R.id.policy_detail_item_amount);
            this.f64030c = view.findViewById(R.id.divider);
        }
    }
}
