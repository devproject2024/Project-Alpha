package net.one97.paytm.recharge.ordersummary.d;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.n;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.i.h;
import net.one97.paytm.m;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.c.d;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.c.a;
import net.one97.paytm.recharge.ordersummary.c.b;
import net.one97.paytm.recharge.ordersummary.c.g;
import net.one97.paytm.recharge.ordersummary.c.i;
import net.one97.paytm.recharge.ordersummary.f.e;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.h.a;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class a extends h implements net.one97.paytm.common.widgets.a.a, net.one97.paytm.recharge.ordersummary.f.b, e, a.C1266a, b.d {

    /* renamed from: i  reason: collision with root package name */
    private static final String f64088i;
    public static final C1258a o = new C1258a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    private C1258a.C1259a f64089a;

    /* renamed from: b  reason: collision with root package name */
    private String f64090b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.h.b f64091c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.c.b f64092d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.c.a f64093e;

    /* renamed from: f  reason: collision with root package name */
    private d f64094f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f64095g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.common.widgets.c f64096h;
    private HashMap j;
    public AJRechargeOrderSummaryActivity l;
    i m;
    public CJROrderSummary n;

    public View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
    }

    public void a(DialogInterface dialogInterface, CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener) {
        k.c(cJROrderSummaryAction, "action");
    }

    public void a(String str, String str2) {
        k.c(str, "actionType");
    }

    public void a(CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener) {
        k.c(cJROrderSummaryAction, "action");
    }

    public boolean a(String str, io.reactivex.rxjava3.j.e<String> eVar, io.reactivex.rxjava3.j.e<String> eVar2) {
        k.c(str, "type");
        k.c(eVar, "enableActionObservable");
        k.c(eVar2, "disableActionObservable");
        return true;
    }

    public final void av_() {
    }

    public void b() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public CJROrderActionsListView getOrderActionClickListener() {
        return null;
    }

    public void p() {
    }

    public void setBillConsent(CJROrderSummaryAction cJROrderSummaryAction) {
        k.c(cJROrderSummaryAction, "action");
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.d.a$a  reason: collision with other inner class name */
    public static final class C1258a {
        private C1258a() {
        }

        public /* synthetic */ C1258a(byte b2) {
            this();
        }

        /* renamed from: net.one97.paytm.recharge.ordersummary.d.a$a$a  reason: collision with other inner class name */
        public enum C1259a {
            SUCCESS("SUCCESS"),
            PENDING("PENDING"),
            FAILED("FAILED"),
            PROCESSING("PROCESSING"),
            CANCELLED(TxNotifyData.UPI_STATUS_CANCELLED);

            private C1259a(String str) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
            if (r0.equals("235") == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
            if (r0.equals("34") != false) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
            if (r0.equals("18") != false) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
            if (r0.equals("6") != false) goto L_0x0061;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a a(net.one97.paytm.common.entity.shopping.CJROrderSummary r3, net.one97.paytm.common.entity.shopping.CJROrderedCart r4) {
            /*
                java.lang.String r0 = "orderSummary"
                kotlin.g.b.k.c(r3, r0)
                int r0 = r3.getOrderStatus()
                r1 = 2
                if (r1 != r0) goto L_0x00a1
                java.lang.String r3 = ""
                if (r4 == 0) goto L_0x0016
                java.lang.String r0 = r4.getItemStatus()
                if (r0 != 0) goto L_0x0017
            L_0x0016:
                r0 = r3
            L_0x0017:
                int r1 = r0.hashCode()
                r2 = 54
                if (r1 == r2) goto L_0x0059
                r2 = 55
                if (r1 == r2) goto L_0x004e
                r2 = 1575(0x627, float:2.207E-42)
                if (r1 == r2) goto L_0x0043
                r2 = 1633(0x661, float:2.288E-42)
                if (r1 == r2) goto L_0x003a
                r2 = 49684(0xc214, float:6.9622E-41)
                if (r1 == r2) goto L_0x0031
                goto L_0x0064
            L_0x0031:
                java.lang.String r1 = "235"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0064
                goto L_0x004b
            L_0x003a:
                java.lang.String r1 = "34"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0064
                goto L_0x0061
            L_0x0043:
                java.lang.String r1 = "18"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0064
            L_0x004b:
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.CANCELLED
                return r3
            L_0x004e:
                java.lang.String r1 = "7"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0064
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.SUCCESS
                return r3
            L_0x0059:
                java.lang.String r1 = "6"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0064
            L_0x0061:
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.FAILED
                return r3
            L_0x0064:
                r0 = 0
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x008b }
                if (r4 == 0) goto L_0x0077
                net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()     // Catch:{ Exception -> 0x008b }
                if (r4 == 0) goto L_0x0077
                java.lang.String r4 = r4.getFulfillmentResponse()     // Catch:{ Exception -> 0x008b }
                if (r4 != 0) goto L_0x0076
                goto L_0x0077
            L_0x0076:
                r3 = r4
            L_0x0077:
                r1.<init>(r3)     // Catch:{ Exception -> 0x008b }
                java.lang.String r3 = "in_code"
                java.lang.String r4 = "0"
                java.lang.String r3 = r1.optString(r3, r4)     // Catch:{ Exception -> 0x008b }
                java.lang.String r4 = "fulfillmentJson.optString(\"in_code\", \"0\")"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x008b }
                int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x008b }
            L_0x008b:
                r3 = 10
                if (r0 == r3) goto L_0x009e
                r3 = 17
                if (r0 == r3) goto L_0x009e
                r3 = 2000(0x7d0, float:2.803E-42)
                if (r0 == r3) goto L_0x009e
                r3 = 3000(0xbb8, float:4.204E-42)
                if (r0 == r3) goto L_0x009e
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.PENDING
                return r3
            L_0x009e:
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.CANCELLED
                return r3
            L_0x00a1:
                r4 = 4
                int r0 = r3.getOrderStatus()
                if (r4 == r0) goto L_0x00b4
                r4 = 8
                int r3 = r3.getOrderStatus()
                if (r4 != r3) goto L_0x00b1
                goto L_0x00b4
            L_0x00b1:
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.PENDING
                return r3
            L_0x00b4:
                net.one97.paytm.recharge.ordersummary.d.a$a$a r3 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.FAILED
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.a.C1258a.a(net.one97.paytm.common.entity.shopping.CJROrderSummary, net.one97.paytm.common.entity.shopping.CJROrderedCart):net.one97.paytm.recharge.ordersummary.d.a$a$a");
        }
    }

    static {
        String simpleName = a.class.getSimpleName();
        k.a((Object) simpleName, "FJRBaseOrderStatusFragment::class.java.simpleName");
        f64088i = simpleName;
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof AJRechargeOrderSummaryActivity) {
            this.l = (AJRechargeOrderSummaryActivity) context;
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb = new StringBuilder("FJRBaseOrderStatusFragment onCreate ");
        sb.append(bundle == null ? "" : "recreated");
        sb.append(" start");
        cJRRechargeUtilities.debugLog(sb.toString());
        super.onCreate(bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle("extra_params")) == null)) {
            setArguments(bundle2);
        }
        if (getArguments() == null) {
            CJRRechargeUtilities.INSTANCE.debugLog("Unable to show order-status screen as arguments is null : due activity re-create");
            AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
            if (aJRechargeOrderSummaryActivity != null) {
                aJRechargeOrderSummaryActivity.c(true);
                return;
            }
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        if (!arguments.containsKey(UpiConstants.FROM)) {
            CJRRechargeUtilities.INSTANCE.debugLog("Unable to show order-status screen as mFrom is null");
            AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity2 = this.l;
            if (aJRechargeOrderSummaryActivity2 != null) {
                aJRechargeOrderSummaryActivity2.c(true);
                return;
            }
            return;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            k.a();
        }
        if (arguments2.containsKey("ordered_item")) {
            Bundle arguments3 = getArguments();
            Serializable serializable = arguments3 != null ? arguments3.getSerializable("ordered_item") : null;
            if (!(serializable instanceof CJROrderSummary)) {
                serializable = null;
            }
            CJROrderSummary cJROrderSummary = (CJROrderSummary) serializable;
            if (cJROrderSummary != null) {
                a(cJROrderSummary, (CJROrderedCart) null);
            } else {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
        CJRRechargeUtilities.INSTANCE.debugLog("FJRBaseOrderStatusFragment onCreate end");
    }

    public void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        if (getArguments() != null) {
            bundle.putBundle("extra_params", getArguments());
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r0 = (r0 = r1.get(0)).getUrlParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.shopping.CJROrderSummary r5, net.one97.paytm.common.entity.shopping.CJROrderedCart r6) {
        /*
            r4 = this;
            java.lang.String r0 = "mOrderSummary"
            kotlin.g.b.k.c(r5, r0)
            r4.n = r5
            r0 = 0
            if (r6 != 0) goto L_0x0019
            java.util.ArrayList r6 = r5.getOrderedCartList()
            java.lang.Object r6 = r6.get(r0)
            if (r6 != 0) goto L_0x0017
            kotlin.g.b.k.a()
        L_0x0017:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
        L_0x0019:
            net.one97.paytm.recharge.ordersummary.d.a$a$a r1 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.a(r5, r6)
            r4.f64089a = r1
            java.util.ArrayList r1 = r6.getAction()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r0 = r1.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r0
            if (r0 == 0) goto L_0x0038
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r0 = r0.getUrlParams()
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = r0.getUrl()
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            r4.f64090b = r0
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Order Summary Status: "
            r1.<init>(r2)
            int r5 = r5.getOrderStatus()
            r1.append(r5)
            r5 = 47
            r1.append(r5)
            java.lang.String r2 = r6.getItemStatus()
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x005e
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x005f
        L_0x005e:
            r2 = r3
        L_0x005f:
            r1.append(r2)
            r1.append(r5)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r6.getProductDetail()
            if (r5 == 0) goto L_0x0077
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x0077
            java.lang.String r5 = r5.getServiceLabel()
            if (r5 != 0) goto L_0x0078
        L_0x0077:
            r5 = r3
        L_0x0078:
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.debugLog(r5)
            net.one97.paytm.recharge.ordersummary.c.i$a r5 = net.one97.paytm.recharge.ordersummary.c.i.f64074d     // Catch:{ all -> 0x0097 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r4.k()     // Catch:{ all -> 0x0097 }
            java.lang.String r6 = "orderSummary"
            kotlin.g.b.k.c(r5, r6)     // Catch:{ all -> 0x0097 }
            net.one97.paytm.recharge.ordersummary.c.i r6 = new net.one97.paytm.recharge.ordersummary.c.i     // Catch:{ all -> 0x0097 }
            r6.<init>()     // Catch:{ all -> 0x0097 }
            r6.f64078e = r5     // Catch:{ all -> 0x0097 }
            r4.m = r6     // Catch:{ all -> 0x0097 }
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.a.a(net.one97.paytm.common.entity.shopping.CJROrderSummary, net.one97.paytm.common.entity.shopping.CJROrderedCart):void");
    }

    public void onResume() {
        net.one97.paytm.common.widgets.c cVar;
        super.onResume();
        net.one97.paytm.common.widgets.c cVar2 = this.f64096h;
        if (cVar2 != null) {
            if (cVar2 == null) {
                k.a();
            }
            if (cVar2.getFragmentManager() == null) {
                net.one97.paytm.common.widgets.c cVar3 = this.f64096h;
                if (cVar3 == null) {
                    k.a();
                }
                if (!cVar3.isAdded()) {
                    net.one97.paytm.common.widgets.c cVar4 = this.f64096h;
                    if (cVar4 == null) {
                        k.a();
                    }
                    if (!cVar4.isVisible()) {
                        net.one97.paytm.recharge.di.helper.c cVar5 = net.one97.paytm.recharge.di.helper.c.f62654a;
                        if (net.one97.paytm.recharge.di.helper.c.bk() && getSupportFragmentManager() != null) {
                            Context context = getContext();
                            net.one97.paytm.recharge.di.helper.c cVar6 = net.one97.paytm.recharge.di.helper.c.f62654a;
                            long bg = net.one97.paytm.recharge.di.helper.c.bg();
                            net.one97.paytm.recharge.di.helper.c cVar7 = net.one97.paytm.recharge.di.helper.c.f62654a;
                            long bh = net.one97.paytm.recharge.di.helper.c.bh();
                            net.one97.paytm.recharge.di.helper.c cVar8 = net.one97.paytm.recharge.di.helper.c.f62654a;
                            if (com.paytm.utility.b.a(context, bg, bh, net.one97.paytm.recharge.di.helper.c.bi()) && (cVar = this.f64096h) != null) {
                                j supportFragmentManager = getSupportFragmentManager();
                                if (supportFragmentManager == null) {
                                    k.a();
                                }
                                cVar.show(supportFragmentManager, (String) null);
                            }
                        }
                    }
                }
            }
        }
    }

    public void onDestroyView() {
        this.f64096h = null;
        super.onDestroyView();
        b();
    }

    public j getSupportFragmentManager() {
        if (isAdded()) {
            return getChildFragmentManager();
        }
        return null;
    }

    public final CJROrderSummary k() {
        CJROrderSummary cJROrderSummary = this.n;
        if (cJROrderSummary == null) {
            k.a();
        }
        return cJROrderSummary;
    }

    public final void at_() {
        this.f64095g = true;
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.a(getContext(), getString(R.string.please_wait_re));
        }
    }

    public final void o() {
        this.f64095g = false;
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r4, java.lang.String[] r5, int[] r6) {
        /*
            r3 = this;
            java.lang.String r0 = "permissions"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r1 = "grantResults"
            kotlin.g.b.k.c(r6, r1)
            net.one97.paytm.recharge.ordersummary.h.b r2 = r3.f64091c
            if (r2 == 0) goto L_0x0086
            kotlin.g.b.k.c(r5, r0)
            kotlin.g.b.k.c(r6, r1)
            r0 = 56
            if (r4 != r0) goto L_0x0086
            boolean r4 = com.paytm.utility.s.a((int[]) r6)
            if (r4 == 0) goto L_0x0031
            java.lang.String r4 = r2.f64313a
            if (r4 == 0) goto L_0x0086
            net.one97.paytm.recharge.ordersummary.h.b$c r4 = r2.f64314b
            if (r4 == 0) goto L_0x0030
            java.lang.String r5 = r2.f64313a
            if (r5 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            r4.a((java.lang.String) r5)
        L_0x0030:
            return
        L_0x0031:
            r4 = 0
            net.one97.paytm.recharge.ordersummary.h.b$d r0 = r2.f64317e
            boolean r0 = r0 instanceof androidx.fragment.app.Fragment
            if (r0 == 0) goto L_0x004b
            net.one97.paytm.recharge.ordersummary.h.b$d r4 = r2.f64317e
            if (r4 == 0) goto L_0x0043
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
            goto L_0x006a
        L_0x0043:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type androidx.fragment.app.Fragment"
            r4.<init>(r5)
            throw r4
        L_0x004b:
            net.one97.paytm.recharge.ordersummary.h.b$d r0 = r2.f64317e
            boolean r0 = r0 instanceof android.app.Activity
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            if (r0 == 0) goto L_0x0060
            net.one97.paytm.recharge.ordersummary.h.b$d r4 = r2.f64317e
            if (r4 == 0) goto L_0x005a
            android.app.Activity r4 = (android.app.Activity) r4
            goto L_0x0073
        L_0x005a:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x0060:
            android.content.Context r0 = r2.f64316d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0073
            android.content.Context r4 = r2.f64316d
            if (r4 == 0) goto L_0x006d
        L_0x006a:
            android.app.Activity r4 = (android.app.Activity) r4
            goto L_0x0073
        L_0x006d:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r1)
            throw r4
        L_0x0073:
            r0 = -1
            if (r4 == 0) goto L_0x007c
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r0 = com.paytm.utility.s.a(r5, r6, r0, r4)
        L_0x007c:
            r4 = 1
            if (r0 == r4) goto L_0x0086
            net.one97.paytm.recharge.ordersummary.h.b$c r5 = r2.f64314b
            if (r5 == 0) goto L_0x0086
            r5.a((boolean) r4)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.a.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public void a(View view, CJROrderedCart cJROrderedCart) {
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity;
        k.c(view, "v");
        view.setEnabled(false);
        view.postDelayed(new b(view), 200);
        int id = view.getId();
        if (id == R.drawable.ic_book_again || id == R.drawable.ic_recharge_another_recharge) {
            if (cJROrderedCart != null && (aJRechargeOrderSummaryActivity = this.l) != null) {
                aJRechargeOrderSummaryActivity.a(cJROrderedCart, true, true);
            }
        } else if (id == R.drawable.ic_recharge_download_invoice) {
            ArrayList<CJROrderSummaryAction> arrayList = null;
            ArrayList<CJROrderSummaryAction> action = cJROrderedCart != null ? cJROrderedCart.getAction() : null;
            if (action instanceof List) {
                arrayList = action;
            }
            List<CJROrderSummaryAction> list = arrayList;
            if (list != null && (!list.isEmpty())) {
                for (CJROrderSummaryAction cJROrderSummaryAction : list) {
                    if (p.a("Invoice", cJROrderSummaryAction.getActionName(), true)) {
                        a(cJROrderSummaryAction);
                    }
                }
            }
        } else if (id == R.id.txt_help || id == R.drawable.ic_help || id == R.id.need_help) {
            CJROrderedCart cJROrderedCart2 = k().getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart2, "orderedSummary.orderedCartList[0]");
            f(cJROrderedCart2);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f64097a;

        b(View view) {
            this.f64097a = view;
        }

        public final void run() {
            this.f64097a.setEnabled(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r2 = r2.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(net.one97.paytm.common.entity.shopping.CJROrderedCart r6) {
        /*
            r5 = this;
            java.lang.String r0 = "orderedItem"
            kotlin.g.b.k.c(r6, r0)
            android.content.Context r0 = r5.getContext()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            android.content.Context r0 = r5.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 != 0) goto L_0x004b
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r6 = r5.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_HELP
            android.content.Context r2 = r5.getContext()
            r3 = 0
            if (r2 == 0) goto L_0x0034
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x0034
            int r4 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r2 = r2.getString(r4)
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            android.content.Context r4 = r5.getContext()
            if (r4 == 0) goto L_0x0047
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x0047
            int r3 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r3 = r4.getString(r3)
        L_0x0047:
            net.one97.paytm.recharge.common.utils.az.a(r6, r0, r1, r2, r3)
            return
        L_0x004b:
            net.one97.paytm.recharge.ordersummary.c.i r0 = r5.m
            if (r0 == 0) goto L_0x0056
            java.lang.String r1 = "orderedCart"
            kotlin.g.b.k.c(r6, r1)
            r0.f64076b = r6
        L_0x0056:
            net.one97.paytm.recharge.ordersummary.c.i r6 = r5.m
            if (r6 == 0) goto L_0x007c
            android.content.Context r0 = r5.getContext()
            androidx.fragment.app.j r1 = r5.getChildFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.ordersummary.c.i> r2 = net.one97.paytm.recharge.ordersummary.c.i.class
            java.lang.String r2 = r2.getSimpleName()
            androidx.fragment.app.FragmentActivity r3 = r5.getActivity()
            if (r3 == 0) goto L_0x0074
            net.one97.paytm.m r3 = (net.one97.paytm.m) r3
            r6.a(r0, r1, r2, r3)
            return
        L_0x0074:
            kotlin.u r6 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.IJRCSTProgressBarHandler"
            r6.<init>(r0)
            throw r6
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.a.f(net.one97.paytm.common.entity.shopping.CJROrderedCart):void");
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        k.c(cJROrderSummaryAction, "action");
        at_();
        if (this.f64091c == null) {
            b.a aVar = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.f64091c = b.a.a(context, this, this);
        }
        net.one97.paytm.recharge.ordersummary.h.b bVar = this.f64091c;
        if (bVar == null) {
            k.a();
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        bVar.a("tab_action_download", cJROrderSummaryAction, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
    }

    public final void l() {
        o();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        android.widget.Toast.makeText(r1.f64316d, r1.f64316d.getResources().getString(net.one97.paytm.recharge.R.string.no_pdf_view_msg), 0).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006e, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.io.File r7) {
        /*
            r6 = this;
            java.lang.String r0 = "file"
            kotlin.g.b.k.c(r7, r0)
            r6.o()
            android.content.Context r1 = r6.getContext()
            if (r1 == 0) goto L_0x0077
            net.one97.paytm.recharge.ordersummary.h.b r1 = r6.f64091c
            if (r1 == 0) goto L_0x0077
            kotlin.g.b.k.c(r7, r0)
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x006f }
            java.lang.String r2 = "android.intent.action.VIEW"
            r0.<init>(r2)     // Catch:{ Exception -> 0x006f }
            r2 = 335544320(0x14000000, float:6.4623485E-27)
            r0.setFlags(r2)     // Catch:{ Exception -> 0x006f }
            android.content.Context r2 = r1.f64316d     // Catch:{ Exception -> 0x006f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r3.<init>()     // Catch:{ Exception -> 0x006f }
            android.content.Context r4 = r1.f64316d     // Catch:{ Exception -> 0x006f }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x006f }
            java.lang.String r5 = "mContext.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x006f }
            r3.append(r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = ".provider"
            r3.append(r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006f }
            android.net.Uri r7 = androidx.core.content.FileProvider.getUriForFile(r2, r3, r7)     // Catch:{ Exception -> 0x006f }
            java.lang.String r2 = "application/pdf"
            r0.setDataAndType(r7, r2)     // Catch:{ Exception -> 0x006f }
            r7 = 1
            r0.setFlags(r7)     // Catch:{ Exception -> 0x006f }
            android.content.Context r7 = r1.f64316d     // Catch:{ ActivityNotFoundException -> 0x0056 }
            r7.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0056 }
            return
        L_0x0056:
            android.content.Context r7 = r1.f64316d     // Catch:{ Exception -> 0x006f }
            android.content.Context r0 = r1.f64316d     // Catch:{ Exception -> 0x006f }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x006f }
            int r1 = net.one97.paytm.recharge.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x006f }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x006f }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x006f }
            r1 = 0
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r0, r1)     // Catch:{ Exception -> 0x006f }
            r7.show()     // Catch:{ Exception -> 0x006f }
            return
        L_0x006f:
            r7 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r0.debugLogExceptions(r7)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.a.a(java.io.File):void");
    }

    public final void m() {
        o();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String str = null;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setActionType(ACTION_TYPE.OS_DOWNLOAD.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        a2.setErrorMsg("Error while invoice downloading");
        az azVar = az.f61525a;
        az.a(a2);
        if (getActivity() != null) {
            Context activity = getActivity();
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.v8_os_invoice_download_failed);
            }
            Toast.makeText(activity, str, 0).show();
        }
    }

    public final void n() {
        if (this.f64096h == null) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (net.one97.paytm.recharge.di.helper.c.bk()) {
                Context context = getContext();
                net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                long bg = net.one97.paytm.recharge.di.helper.c.bg();
                net.one97.paytm.recharge.di.helper.c cVar3 = net.one97.paytm.recharge.di.helper.c.f62654a;
                long bh = net.one97.paytm.recharge.di.helper.c.bh();
                net.one97.paytm.recharge.di.helper.c cVar4 = net.one97.paytm.recharge.di.helper.c.f62654a;
                if (com.paytm.utility.b.a(context, bg, bh, net.one97.paytm.recharge.di.helper.c.bi())) {
                    this.f64096h = new net.one97.paytm.common.widgets.c();
                    net.one97.paytm.common.widgets.c cVar5 = this.f64096h;
                    if (cVar5 != null) {
                        cVar5.a((net.one97.paytm.common.widgets.a.a) this);
                    }
                }
            }
        }
    }

    public final void a(float f2) {
        net.one97.paytm.common.widgets.c cVar;
        View view;
        AppCompatRatingBar appCompatRatingBar;
        View view2;
        ImageView imageView;
        View view3;
        TextView textView;
        View view4;
        TextView textView2;
        if (getContext() != null) {
            com.paytm.utility.b.x(getContext(), "is_app_rated");
            try {
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.di.helper.b.a(context, "app_rating", String.valueOf(Math.round(f2)), "recharges_utilities", "", "recharges_utilities");
            } catch (Throwable unused) {
            }
            if (f2 < 5.0f) {
                com.paytm.utility.b.a(getContext(), "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
                com.paytm.utility.b.a(getContext(), "app_rating_5_star_timestamp", 0);
                net.one97.paytm.common.widgets.c cVar2 = this.f64096h;
                if (!(cVar2 == null || (view4 = cVar2.getView()) == null || (textView2 = (TextView) view4.findViewById(R.id.tv_msg)) == null)) {
                    textView2.setText(getString(net.one97.paytm.common.widgets.R.string.feedback_thanks_msg));
                }
                net.one97.paytm.common.widgets.c cVar3 = this.f64096h;
                if (!(cVar3 == null || (view3 = cVar3.getView()) == null || (textView = (TextView) view3.findViewById(R.id.tv_sub_msg)) == null)) {
                    textView.setVisibility(8);
                }
                net.one97.paytm.common.widgets.c cVar4 = this.f64096h;
                if (!(cVar4 == null || (view2 = cVar4.getView()) == null || (imageView = (ImageView) view2.findViewById(R.id.iv_close_icon)) == null)) {
                    imageView.setVisibility(8);
                }
                net.one97.paytm.common.widgets.c cVar5 = this.f64096h;
                if (!(cVar5 == null || (view = cVar5.getView()) == null || (appCompatRatingBar = (AppCompatRatingBar) view.findViewById(R.id.ratingBar)) == null)) {
                    appCompatRatingBar.setRating(f2);
                }
                net.one97.paytm.recharge.di.helper.c cVar6 = net.one97.paytm.recharge.di.helper.c.f62654a;
                new Handler().postDelayed(new c(this), net.one97.paytm.recharge.di.helper.c.bj());
            } else {
                com.paytm.utility.b.a(getContext(), "app_rating_5_star_timestamp", System.currentTimeMillis());
                com.paytm.utility.b.a(getContext(), "app_rating_less_than_5_star_timestamp", 0);
                if (isAdded() && isVisible() && (cVar = this.f64096h) != null) {
                    cVar.dismiss();
                }
                com.paytm.utility.b.ai(getContext());
            }
            com.paytm.utility.b.a(getContext(), "app_rating_not_now_timestamp", 0);
        }
    }

    public final void a() {
        net.one97.paytm.common.widgets.c cVar;
        if (getContext() != null) {
            com.paytm.utility.b.a(getContext(), "app_rating_not_now_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(getContext(), "app_rating_5_star_timestamp", 0);
            com.paytm.utility.b.a(getContext(), "app_rating_less_than_5_star_timestamp", 0);
            try {
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.di.helper.b.a(context, "app_rating", "cross_button_clicked", "recharges_utilities", "", "recharges_utilities");
            } catch (Throwable unused) {
            }
            net.one97.paytm.common.widgets.c cVar2 = this.f64096h;
            Boolean bool = null;
            Boolean valueOf = cVar2 != null ? Boolean.valueOf(cVar2.isAdded()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                net.one97.paytm.common.widgets.c cVar3 = this.f64096h;
                if (cVar3 != null) {
                    bool = Boolean.valueOf(cVar3.isVisible());
                }
                if (bool == null) {
                    k.a();
                }
                if (bool.booleanValue() && (cVar = this.f64096h) != null) {
                    cVar.dismiss();
                }
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64098a;

        c(a aVar) {
            this.f64098a = aVar;
        }

        public final void run() {
            net.one97.paytm.common.widgets.c a2 = this.f64098a.f64096h;
            if (a2 != null) {
                a2.dismiss();
            }
        }
    }

    public void b(l lVar) {
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        k.c(aVar, "viewModel");
        if (this.f64092d == null) {
            this.f64092d = new net.one97.paytm.recharge.ordersummary.c.b();
            net.one97.paytm.recharge.ordersummary.c.b bVar = this.f64092d;
            if (bVar == null) {
                k.a();
            }
            k.c(aVar, "viewModel");
            bVar.f64034a = aVar;
            net.one97.paytm.recharge.ordersummary.c.b bVar2 = this.f64092d;
            if (bVar2 == null) {
                k.a();
            }
            bVar2.f64035b = onDismissListener;
        }
        aVar.c("payment_details_clicked", (String) null);
        if (getSupportFragmentManager() != null) {
            net.one97.paytm.recharge.ordersummary.c.b bVar3 = this.f64092d;
            if (bVar3 == null) {
                k.a();
            }
            if (bVar3.getFragmentManager() == null) {
                net.one97.paytm.recharge.ordersummary.c.b bVar4 = this.f64092d;
                if (bVar4 == null) {
                    k.a();
                }
                j supportFragmentManager = getSupportFragmentManager();
                if (supportFragmentManager == null) {
                    k.a();
                }
                b.a aVar2 = net.one97.paytm.recharge.ordersummary.c.b.f64032c;
                bVar4.show(supportFragmentManager, net.one97.paytm.recharge.ordersummary.c.b.f64033d);
            }
        }
    }

    public final androidx.fragment.app.b a(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, int i2, View.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "insuranceItem");
        k.c(onClickListener, "tapActionHandler");
        if (this.f64093e == null) {
            this.f64093e = new net.one97.paytm.recharge.ordersummary.c.a();
            net.one97.paytm.recharge.ordersummary.c.a aVar2 = this.f64093e;
            if (aVar2 == null) {
                k.a();
            }
            aVar2.f64022c = onDismissListener;
            net.one97.paytm.recharge.ordersummary.c.a aVar3 = this.f64093e;
            if (aVar3 == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.f.b bVar = this;
            k.c(bVar, "actionListener");
            aVar3.f64021b = bVar;
            net.one97.paytm.recharge.ordersummary.c.a aVar4 = this.f64093e;
            if (aVar4 == null) {
                k.a();
            }
            k.c(onClickListener, "listener");
            aVar4.f64020a = onClickListener;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("layoutType", i2);
        bundle.putSerializable("recharge_item", cJROrderedCart);
        net.one97.paytm.recharge.ordersummary.c.a aVar5 = this.f64093e;
        if (aVar5 == null) {
            k.a();
        }
        aVar5.setArguments(bundle);
        c.a aVar6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        net.one97.paytm.recharge.ordersummary.h.c.f64335e.put(String.valueOf(cJROrderedCart.getId()), aVar);
        if (getSupportFragmentManager() != null) {
            net.one97.paytm.recharge.ordersummary.c.a aVar7 = this.f64093e;
            if (aVar7 == null) {
                k.a();
            }
            if (aVar7.getFragmentManager() == null) {
                net.one97.paytm.recharge.ordersummary.c.a aVar8 = this.f64093e;
                if (aVar8 == null) {
                    k.a();
                }
                j supportFragmentManager = getSupportFragmentManager();
                if (supportFragmentManager == null) {
                    k.a();
                }
                a.C1256a aVar9 = net.one97.paytm.recharge.ordersummary.c.a.f64019d;
                aVar8.show(supportFragmentManager, net.one97.paytm.recharge.ordersummary.c.a.k);
            }
        }
        net.one97.paytm.recharge.ordersummary.c.a aVar10 = this.f64093e;
        if (aVar10 == null) {
            k.a();
        }
        return aVar10;
    }

    public final void a(String str, String str2, String str3) {
        if (getContext() instanceof net.one97.paytm.recharge.ordersummary.f.n) {
            if (getContext() instanceof m) {
                Context context = getContext();
                if (context != null) {
                    ((m) context).show();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.IJRCSTProgressBarHandler");
                }
            }
            Context context2 = getContext();
            if (context2 != null) {
                net.one97.paytm.recharge.ordersummary.f.n nVar = (net.one97.paytm.recharge.ordersummary.f.n) context2;
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                nVar.a(str, str2, str3);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        r2 = r2.getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.shopping.CJROrderedCart r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "orderedItem"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "action"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r0 = r4.l
            if (r0 == 0) goto L_0x0017
            net.one97.paytm.recharge.ordersummary.h.a r0 = r0.f63981d
            if (r0 == 0) goto L_0x0017
            r1 = r4
            net.one97.paytm.recharge.ordersummary.h.a$a r1 = (net.one97.paytm.recharge.ordersummary.h.a.C1266a) r1
            r0.f64307a = r1
        L_0x0017:
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r0 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r0 = r0.getACTION_TYPE_REDIRECT_TO_CATEGORY()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)
            r1 = 1
            r0 = r0 ^ r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r5.getProductDetail()
            if (r2 == 0) goto L_0x0034
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = r2.getPaytype()
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            java.lang.String r3 = "prepaid"
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x004d
            if (r2 != 0) goto L_0x004d
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r2 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r2 = r2.getACTION_TYPE_REPEAT_WITHOUT_AMOUNT()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r2)
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r6 = r4.l
            if (r6 == 0) goto L_0x0055
            r6.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5, (boolean) r0, (boolean) r1)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.a.a(net.one97.paytm.common.entity.shopping.CJROrderedCart, java.lang.String):void");
    }

    public final void a(String str) {
        net.one97.paytm.recharge.ordersummary.h.a aVar;
        k.c(str, "deeplink");
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
        if (!(aJRechargeOrderSummaryActivity == null || (aVar = aJRechargeOrderSummaryActivity.f63981d) == null)) {
            aVar.f64307a = this;
        }
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity2 = this.l;
        if (aJRechargeOrderSummaryActivity2 != null) {
            k.c(str, "deeplink");
            net.one97.paytm.recharge.ordersummary.h.a aVar2 = aJRechargeOrderSummaryActivity2.f63981d;
            if (aVar2 != null) {
                k.c(str, "deeplink");
                CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                cJRHomePageItem.setDeeplink(str);
                Uri parse = Uri.parse(str);
                k.a((Object) parse, "Uri.parse(deeplink)");
                String host = parse.getHost();
                cJRHomePageItem.setUrlType(host);
                cJRHomePageItem.setUrl(str);
                aVar2.a(host, cJRHomePageItem);
            }
        }
    }

    public void a(HashMap<String, View> hashMap) {
        k.c(hashMap, "sharedElementsMap");
        CJRRechargeUtilities.INSTANCE.debugLog("showOrderDetails : called");
        if (getActivity() instanceof AJRechargeOrderSummaryActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRechargeOrderSummaryActivity) activity).a(this.n, false, (Map<String, ? extends View>) hashMap);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
    }

    public final void b(String str, String str2) {
        d dVar;
        k.c(str, "tncTitle");
        if (isAdded() && !isRemoving()) {
            if (this.f64094f == null) {
                this.f64094f = new d();
            }
            Bundle bundle = new Bundle();
            bundle.putString("tnc_title", str);
            bundle.putString("tnc_text", str2);
            d dVar2 = this.f64094f;
            if (dVar2 == null) {
                k.a();
            }
            dVar2.setArguments(bundle);
            d dVar3 = this.f64094f;
            if (dVar3 == null) {
                k.a();
            }
            if (!dVar3.isAdded() && getSupportFragmentManager() != null) {
                d dVar4 = this.f64094f;
                if (dVar4 == null) {
                    k.a();
                }
                if (dVar4.getFragmentManager() == null && (dVar = this.f64094f) != null) {
                    j supportFragmentManager = getSupportFragmentManager();
                    if (supportFragmentManager == null) {
                        k.a();
                    }
                    dVar.show(supportFragmentManager, f64088i);
                }
            }
        }
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, Bundle bundle) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        k.c(bundle, "itemArgs");
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
        if (aJRechargeOrderSummaryActivity != null) {
            if (aJRechargeOrderSummaryActivity == null) {
                k.a();
            }
            if (!aJRechargeOrderSummaryActivity.isDestroyed()) {
                String string = bundle.getString("recharge.component.name");
                bundle.putSerializable("recharge.show.item.details", Boolean.TRUE);
                bundle.putSerializable("recharge_item", cJROrderedCart);
                c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                net.one97.paytm.recharge.ordersummary.h.c.f64335e.put(String.valueOf(cJROrderedCart.getId()), aVar);
                Intent intent = new Intent(this.l, AJRechargeOrderSummaryActivity.class);
                AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity2 = this.l;
                if (aJRechargeOrderSummaryActivity2 == null) {
                    k.a();
                }
                if (aJRechargeOrderSummaryActivity2.f63980c) {
                    intent.setFlags(603979776);
                }
                intent.putExtra("recharge.component.name", string);
                intent.putExtra("recharge.component.args", bundle);
                intent.putExtra("item_id", String.valueOf(cJROrderedCart.getId()));
                CJROrderSummary cJROrderSummary = aVar.f63998b;
                if (cJROrderSummary == null) {
                    k.a();
                }
                intent.putExtra("order_id", cJROrderSummary.getId());
                AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity3 = this.l;
                if (aJRechargeOrderSummaryActivity3 == null) {
                    k.a();
                }
                intent.putExtra(UpiConstants.FROM, aJRechargeOrderSummaryActivity3.getIntent().getStringExtra(UpiConstants.FROM));
                startActivityForResult(intent, 2020);
            }
        }
    }

    public void setupAutoPay(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, CJROrderSummaryAction cJROrderSummaryAction) {
        String str;
        String str2;
        String thumbnail;
        String str3;
        String str4;
        String str5;
        CJRAttributes attributes;
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedCart");
        k.c(cJROrderSummaryAction, "action");
        if (getContext() != null && isAdded()) {
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            try {
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                if (productDetail == null || (str3 = productDetail.getVertical()) == null) {
                    str3 = "";
                }
                map.put("recharge_utilities_autopayment_vertical", str3);
                Map map2 = hashMap;
                if (productDetail == null || (str4 = productDetail.getBrandName()) == null) {
                    str4 = "";
                }
                map2.put("recharge_utilities_autopayment_operator", str4);
                hashMap.put("recharge_utilities_autopayment_amount", Double.valueOf(cJROrderedCart.getTotalPrice()));
                hashMap.put("user_id", com.paytm.utility.b.n(getContext()));
                Map map3 = hashMap;
                if (productDetail == null || (attributes = productDetail.getAttributes()) == null || (str5 = attributes.getService()) == null) {
                    str5 = "";
                }
                map3.put("recharge_utilities_service_type", str5);
                Map map4 = hashMap;
                Object obj = hashMap.get("recharge_utilities_service_type");
                if (obj == null) {
                    obj = "";
                }
                map4.put("service_type", obj);
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.di.helper.b.a("automatic_payment_summary_screen_automatic_clicked", (HashMap<String, Object>) hashMap, context);
            } catch (Throwable unused) {
            }
            if (az.c(getContext())) {
                Context context2 = getContext();
                if (context2 != null) {
                    k.a((Object) context2, "it");
                    String rechargeNumber = cJROrderedCart.getRechargeNumber();
                    k.a((Object) rechargeNumber, "orderedCart.rechargeNumber");
                    az.g(context2, rechargeNumber);
                    return;
                }
                return;
            }
            Intent intent = new Intent(getContext(), AJRAutomaticSetupActivity.class);
            intent.putExtra("recharge_number", cJROrderedCart.getRechargeNumber());
            HashMap hashMap2 = new HashMap();
            if (cJROrderedCart.getRechargeConfiguration() != null) {
                Map<String, String> rechargeConfiguration = cJROrderedCart.getRechargeConfiguration();
                k.a((Object) rechargeConfiguration, "orderedCart.rechargeConfiguration");
                if (!rechargeConfiguration.isEmpty()) {
                    hashMap2.putAll(cJROrderedCart.getRechargeConfiguration());
                }
            }
            intent.putExtra("configuraton", hashMap2);
            if (productDetail == null || (thumbnail = productDetail.getThumbnail()) == null || (str = p.a(thumbnail, " ", "%20", false)) == null) {
                str = "";
            }
            intent.putExtra("operator_logo", str);
            k.a((Object) productDetail, "productDetail");
            intent.putExtra(CLPConstants.PRODUCT_ID, String.valueOf(productDetail.getId()));
            CJRAttributes attributes2 = productDetail.getAttributes();
            if (attributes2 == null || (str2 = attributes2.getService()) == null) {
                str2 = "";
            }
            intent.putExtra("service_type", str2);
            intent.putExtra("from", "from_summary");
            CJRAttributes attributes3 = productDetail.getAttributes();
            intent.putExtra("is_bank_mandate_enabled", attributes3 != null ? Boolean.valueOf(attributes3.isBankMandateEnable()) : null);
            startActivityForResult(intent, 203);
        }
    }

    public final void au_() {
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.c(true);
        }
    }

    public final void b(String str) {
        if (g.c(str)) {
            g.a aVar = net.one97.paytm.recharge.ordersummary.c.g.f64067a;
            net.one97.paytm.recharge.ordersummary.c.g gVar = new net.one97.paytm.recharge.ordersummary.c.g();
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_HTML_MESSAGE", true);
            bundle.putString(StringSet.messages, str);
            gVar.setArguments(bundle);
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                gVar.show(supportFragmentManager, net.one97.paytm.recharge.ordersummary.c.d.class.getSimpleName());
            }
        }
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart) {
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        try {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            ClipData newPlainText = ClipData.newPlainText(r0, aVar.e(context, cJROrderedCart).getFirst());
            Context context2 = getContext();
            Object systemService = context2 != null ? context2.getSystemService("clipboard") : null;
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            Context context3 = getContext();
            Context context4 = getContext();
            if (context4 == null) {
                k.a();
            }
            Toast.makeText(context3, context4.getString(R.string.v8_os_action_copy_voucher_code), 0).show();
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        net.one97.paytm.common.widgets.c cVar = this.f64096h;
        if (cVar != null) {
            if (cVar == null) {
                k.a();
            }
            if (cVar.isAdded()) {
                net.one97.paytm.common.widgets.c cVar2 = this.f64096h;
                if (cVar2 == null) {
                    k.a();
                }
                if (cVar2.isVisible()) {
                    net.one97.paytm.common.widgets.c cVar3 = this.f64096h;
                    if (cVar3 == null) {
                        k.a();
                    }
                    cVar3.dismiss();
                }
            }
        }
        super.onPause();
    }
}
