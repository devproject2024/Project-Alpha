package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.b.a;

public final class CJRBBPSWidget extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final a f64348a;

    /* renamed from: b  reason: collision with root package name */
    private final CJROSActionResponseV2 f64349b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f64350c;

    private View a(int i2) {
        if (this.f64350c == null) {
            this.f64350c = new HashMap();
        }
        View view = (View) this.f64350c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64350c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRBBPSWidget(Context context, a aVar, CJROSActionResponseV2 cJROSActionResponseV2) {
        super(context);
        k.c(context, "context");
        k.c(aVar, "viewModel");
        this.f64348a = aVar;
        this.f64349b = cJROSActionResponseV2;
        LayoutInflater.from(context).inflate(R.layout.lyt_bbps_widget, this, true);
        a();
    }

    public final CJROSActionResponseV2 getTapActionRes() {
        return this.f64349b;
    }

    public final a getViewModel() {
        return this.f64348a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r3 = this;
            net.one97.paytm.recharge.ordersummary.b.a r0 = r3.f64348a
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x001a
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.getBbpsLogoIconUrl()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x010d
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = r3.f64349b
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = r0.getItemLevelActions()
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = r0.getOperatorReferenceNumber()
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x010d
            net.one97.paytm.recharge.ordersummary.b.a r0 = r3.f64348a
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            if (r0 == 0) goto L_0x0054
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x0054
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = r0.getBbpsLabel()
            goto L_0x0055
        L_0x0054:
            r0 = r1
        L_0x0055:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005f
            goto L_0x010d
        L_0x005f:
            net.one97.paytm.recharge.ordersummary.b.a r0 = r3.f64348a
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            if (r0 == 0) goto L_0x0078
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x0078
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = r0.getBbpsLogoIconUrl()
            goto L_0x0079
        L_0x0078:
            r0 = r1
        L_0x0079:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ae
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.ordersummary.b.a r2 = r3.f64348a
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r2.u()
            if (r2 == 0) goto L_0x009e
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()
            if (r2 == 0) goto L_0x009e
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x009e
            java.lang.String r2 = r2.getBbpsLogoIconUrl()
            goto L_0x009f
        L_0x009e:
            r2 = r1
        L_0x009f:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r2)
            int r2 = net.one97.paytm.recharge.R.id.ic_bbps_logo
            android.view.View r2 = r3.a(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.a((android.widget.ImageView) r2)
        L_0x00ae:
            int r0 = net.one97.paytm.recharge.R.id.txt_bbps_label
            android.view.View r0 = r3.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00d7
            net.one97.paytm.recharge.ordersummary.b.a r2 = r3.f64348a
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r2.u()
            if (r2 == 0) goto L_0x00d1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()
            if (r2 == 0) goto L_0x00d1
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = r2.getBbpsLabel()
            goto L_0x00d2
        L_0x00d1:
            r2 = r1
        L_0x00d2:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x00d7:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = r3.f64349b
            if (r0 == 0) goto L_0x00e6
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = r0.getItemLevelActions()
            if (r0 == 0) goto L_0x00e6
            java.lang.String r0 = r0.getOperatorReferenceNumber()
            goto L_0x00e7
        L_0x00e6:
            r0 = r1
        L_0x00e7:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x010c
            int r0 = net.one97.paytm.recharge.R.id.txt_bbps_ref_no
            android.view.View r0 = r3.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x010c
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r2 = r3.f64349b
            if (r2 == 0) goto L_0x0107
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r2 = r2.getItemLevelActions()
            if (r2 == 0) goto L_0x0107
            java.lang.String r1 = r2.getOperatorReferenceNumber()
        L_0x0107:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x010c:
            return
        L_0x010d:
            net.one97.paytm.recharge.common.utils.ai.b(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBBPSWidget.a():void");
    }
}
