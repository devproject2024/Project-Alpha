package net.one97.paytm.recharge.legacy.ordersummary.a;

import android.text.SpannableString;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;

public final class a extends b {
    private HashMap j;

    public final View a(int i2) {
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

    public final void b() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final String c(CJROrderedCart cJROrderedCart) {
        return null;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r6 = r6.getOrderedCartList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r5, r0)
            super.a((android.view.View) r5, (android.os.Bundle) r6)
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r4.n
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L_0x0020
            java.util.ArrayList r6 = r6.getOrderedCartList()
            if (r6 == 0) goto L_0x0020
            java.lang.Object r6 = r6.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            goto L_0x0021
        L_0x0020:
            r6 = r1
        L_0x0021:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r4.n
            if (r2 == 0) goto L_0x002a
            java.lang.String r2 = r2.getId()
            goto L_0x002b
        L_0x002a:
            r2 = r1
        L_0x002b:
            java.lang.String r3 = "order_id"
            r5.putString(r3, r2)
            android.os.Bundle r2 = r4.getArguments()
            java.lang.String r3 = "From"
            if (r2 == 0) goto L_0x003c
            java.lang.String r1 = r2.getString(r3)
        L_0x003c:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0047
            java.lang.String r1 = ""
        L_0x0047:
            r5.putString(r3, r1)
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r1 = "cart_product"
            r5.putSerializable(r1, r6)
            android.content.Context r6 = r4.getContext()
            if (r6 == 0) goto L_0x00a0
            android.content.Context r6 = r4.getContext()
            if (r6 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            java.lang.Class<net.one97.paytm.recharge.metro.c.b> r1 = net.one97.paytm.recharge.metro.c.b.class
            java.lang.String r1 = r1.getName()
            androidx.fragment.app.Fragment r5 = androidx.fragment.app.Fragment.instantiate(r6, r1, r5)
            java.lang.String r6 = "Fragment.instantiate(con…t::class.java.name, args)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            int r6 = net.one97.paytm.recharge.R.id.container_frame
            android.view.View r6 = r4.a((int) r6)
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            r6.setBackgroundColor(r0)
            java.lang.Class<net.one97.paytm.recharge.metro.c.b> r6 = net.one97.paytm.recharge.metro.c.b.class
            java.lang.String r6 = r6.getName()
            java.lang.String r0 = "FJRActiveMetroTicketsFragment::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            androidx.fragment.app.j r0 = r4.getChildFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r6)
            if (r0 != 0) goto L_0x00a0
            androidx.fragment.app.j r0 = r4.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            int r1 = net.one97.paytm.recharge.R.id.container_frame
            androidx.fragment.app.q r5 = r0.b(r1, r5, r6)
            r5.c()
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.a.a(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public final String a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        String str;
        CJRAttributes attributes;
        int i2 = R.string.metro_order_status_success;
        Object[] objArr = new Object[1];
        if (cJROrderSummaryProductDetail == null || (attributes = cJROrderSummaryProductDetail.getAttributes()) == null || (str = attributes.getPayTypeDisplayLabel()) == null) {
            str = "";
        }
        objArr[0] = str;
        String string = getString(i2, objArr);
        k.a((Object) string, "getString(R.string.metro…ayTypeDisplayLabel ?: \"\")");
        return string;
    }

    /* access modifiers changed from: protected */
    public final SpannableString a(CJROrderedCart cJROrderedCart) {
        String str;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        if (cJROrderedCart == null || (productDetail = cJROrderedCart.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getOperatorDisplayLabel()) == null) {
            str = "";
        }
        return new SpannableString(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r1 = (r1 = (r1 = r1.getProductDetail()).getAttributes()).getOperatorDisplayLabel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(net.one97.paytm.common.entity.shopping.CJROrderedCart r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = r1.getOperatorDisplayLabel()
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            java.lang.String r1 = ""
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.a.b(net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }
}
