package net.one97.paytm.recharge.ordersummary.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.f.q;
import net.one97.paytm.recharge.ordersummary.f.t;
import net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget;

public final class f extends net.one97.paytm.i.f implements CJRInstantRefundWidget.b, CJRInstantRefundWidget.d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f64058b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static String f64059f = "refund_modal_key";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static String f64060g = "is_revamp_ordersummary";

    /* renamed from: a  reason: collision with root package name */
    public q f64061a;

    /* renamed from: c  reason: collision with root package name */
    private CJRImpsRefundConsultViewV8 f64062c;

    /* renamed from: d  reason: collision with root package name */
    private t.b f64063d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f64064e;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64065h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f a(IJRPaytmDataModel iJRPaytmDataModel, Boolean bool) {
            f fVar = new f();
            Bundle bundle = new Bundle();
            bundle.putSerializable(f.f64059f, iJRPaytmDataModel);
            String c2 = f.f64060g;
            if (bool == null) {
                k.a();
            }
            bundle.putBoolean(c2, bool.booleanValue());
            fVar.setArguments(bundle);
            return fVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomImpsBottomSheetDialogTheme);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        Boolean bool = null;
        Serializable serializable = arguments != null ? arguments.getSerializable(f64059f) : null;
        if (!(serializable instanceof CJRImpsRefundConsultViewV8)) {
            serializable = null;
        }
        this.f64062c = (CJRImpsRefundConsultViewV8) serializable;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool = Boolean.valueOf(arguments2.getBoolean(f64060g));
        }
        if (bool == null) {
            k.a();
        }
        this.f64064e = bool.booleanValue();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        CJRInstantRefundWidget cJRInstantRefundWidget = new CJRInstantRefundWidget(getContext(), this.f64062c, Integer.valueOf(R.layout.return_imps_widget_layout_v8), this, this.f64064e ? this : null, this.f64061a);
        this.f64063d = cJRInstantRefundWidget;
        return cJRInstantRefundWidget;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r2, r0)
            super.onViewCreated(r2, r3)
            int r2 = net.one97.paytm.recharge.R.id.img_cross_view
            java.util.HashMap r3 = r1.f64065h
            if (r3 != 0) goto L_0x0015
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r1.f64065h = r3
        L_0x0015:
            java.util.HashMap r3 = r1.f64065h
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r3.get(r0)
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x0038
            android.view.View r3 = r1.getView()
            if (r3 != 0) goto L_0x002b
            r2 = 0
            goto L_0x0039
        L_0x002b:
            android.view.View r3 = r3.findViewById(r2)
            java.util.HashMap r0 = r1.f64065h
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r2, r3)
        L_0x0038:
            r2 = r3
        L_0x0039:
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r2 == 0) goto L_0x0047
            net.one97.paytm.recharge.ordersummary.c.f$b r3 = new net.one97.paytm.recharge.ordersummary.c.f$b
            r3.<init>(r1)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.c.f.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64066a;

        b(f fVar) {
            this.f64066a = fVar;
        }

        public final void onClick(View view) {
            this.f64066a.dismiss();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        t.b bVar = this.f64063d;
        if (bVar != null) {
            bVar.a(i2, i3);
        }
    }

    public final void a() {
        try {
            dismissAllowingStateLoss();
        } catch (Throwable unused) {
        }
    }

    public final void v() {
        if (this.f64064e) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof AJRechargeOrderSummaryActivity)) {
                activity = null;
            }
            AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) activity;
            if (aJRechargeOrderSummaryActivity != null) {
                aJRechargeOrderSummaryActivity.v();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64065h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
