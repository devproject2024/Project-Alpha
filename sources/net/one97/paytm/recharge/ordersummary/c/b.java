package net.one97.paytm.recharge.ordersummary.c;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class b extends f {

    /* renamed from: c  reason: collision with root package name */
    public static final a f64032c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f64033d;

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.recharge.ordersummary.b.a f64034a;

    /* renamed from: b  reason: collision with root package name */
    public DialogInterface.OnDismissListener f64035b;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f64036e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = b.class.getSimpleName();
        k.a((Object) simpleName, "CJRPaymentDetailBottomSh…V8::class.java.simpleName");
        f64033d = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f64034a == null) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog(net.one97.paytm.recharge.ordersummary.b.a.class.getSimpleName() + " is must required, use setter method to achieve");
            dismissAllowingStateLoss();
            return;
        }
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_dialog_order_payment_details_v8, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r5 = "view"
            kotlin.g.b.k.c(r4, r5)
            net.one97.paytm.recharge.ordersummary.b.a r5 = r3.f64034a
            if (r5 != 0) goto L_0x000a
            return
        L_0x000a:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderPaymentDetailsViewV8 r5 = new net.one97.paytm.recharge.ordersummary.widget.CJROrderPaymentDetailsViewV8
            android.content.Context r0 = r3.getContext()
            if (r0 != 0) goto L_0x0015
            kotlin.g.b.k.a()
        L_0x0015:
            java.lang.String r1 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r3.f64034a
            if (r1 != 0) goto L_0x0021
            kotlin.g.b.k.a()
        L_0x0021:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r3.f64034a
            if (r2 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r2.u()
            if (r2 != 0) goto L_0x0031
            kotlin.g.b.k.a()
        L_0x0031:
            r5.<init>(r0, r1, r2)
            int r0 = net.one97.paytm.recharge.R.id.header_payment_details
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0043
            r1 = 8
            r0.setVisibility(r1)
        L_0x0043:
            int r0 = net.one97.paytm.recharge.R.id.lyt_payment_details
            java.util.HashMap r1 = r3.f64036e
            if (r1 != 0) goto L_0x0050
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.f64036e = r1
        L_0x0050:
            java.util.HashMap r1 = r3.f64036e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r1.get(r2)
            android.view.View r1 = (android.view.View) r1
            if (r1 != 0) goto L_0x0073
            android.view.View r1 = r3.getView()
            if (r1 != 0) goto L_0x0066
            r0 = 0
            goto L_0x0074
        L_0x0066:
            android.view.View r1 = r1.findViewById(r0)
            java.util.HashMap r2 = r3.f64036e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r0, r1)
        L_0x0073:
            r0 = r1
        L_0x0074:
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L_0x007d
            android.view.View r5 = (android.view.View) r5
            r0.addView(r5)
        L_0x007d:
            int r5 = net.one97.paytm.recharge.R.id.close_button
            android.view.View r4 = r4.findViewById(r5)
            if (r4 == 0) goto L_0x008f
            net.one97.paytm.recharge.ordersummary.c.b$b r5 = new net.one97.paytm.recharge.ordersummary.c.b$b
            r5.<init>(r3)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.c.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.c.b$b  reason: collision with other inner class name */
    static final class C1257b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64037a;

        C1257b(b bVar) {
            this.f64037a = bVar;
        }

        public final void onClick(View view) {
            this.f64037a.dismiss();
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f64035b;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64036e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
