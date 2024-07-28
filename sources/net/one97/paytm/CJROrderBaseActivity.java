package net.one97.paytm;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.marketplace.a;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.d.c;
import net.one97.paytm.wallet.f.f;

public class CJROrderBaseActivity extends CJRActionBarBaseActivity implements f {
    protected int C = 0;
    c D;

    public void a() {
    }

    public void onAddMoneyRequestComplete() {
    }

    public void onAddMoneyRequestStart() {
    }

    public void onAddMoneyVerifyResponse(String str) {
    }

    public void onStart() {
        super.onStart();
        if (this.D == null) {
            this.D = new c();
        }
        this.D.a((Activity) this, (f) this);
    }

    public void onStop() {
        c cVar = this.D;
        if (cVar != null) {
            cVar.a();
        }
        super.onStop();
    }

    public final void n() {
        super.n();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac A[Catch:{ Exception -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(net.one97.paytm.common.entity.shopping.CJROrderedCart r17) {
        /*
            r16 = this;
            r11 = r16
            r1 = 0
            if (r17 == 0) goto L_0x0029
            if (r17 != 0) goto L_0x000b
            r16.m()
            return
        L_0x000b:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r17.getProductDetail()
            if (r0 == 0) goto L_0x001e
            long r2 = r0.getId()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.util.Map r2 = r17.getRechargeConfiguration()
            goto L_0x0020
        L_0x001e:
            r0 = r1
            r2 = r0
        L_0x0020:
            double r3 = r17.getPrice()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            goto L_0x002c
        L_0x0029:
            r0 = r1
            r2 = r0
            r3 = r2
        L_0x002c:
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            r14 = 0
            r15 = 2131959563(0x7f131f0b, float:1.955577E38)
            r10 = 2131959561(0x7f131f09, float:1.9555766E38)
            java.lang.String r6 = "product_id"
            r5.put(r6, r0)     // Catch:{ Exception -> 0x0159 }
            java.lang.String r0 = "qty"
            r6 = 1
            r5.put(r0, r6)     // Catch:{ Exception -> 0x0159 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0159 }
            r6.<init>()     // Catch:{ Exception -> 0x0159 }
            java.lang.String r0 = "price"
            if (r2 == 0) goto L_0x0095
            java.lang.String r7 = r17.getRechargeNumber()     // Catch:{ Exception -> 0x0159 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0159 }
            if (r7 == 0) goto L_0x006a
            java.lang.String r7 = r17.getRechargePrice()     // Catch:{ Exception -> 0x0159 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0159 }
            if (r7 != 0) goto L_0x0095
        L_0x006a:
            java.util.Set r7 = r2.keySet()     // Catch:{ Exception -> 0x0159 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0159 }
        L_0x0072:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0159 }
            if (r8 == 0) goto L_0x009d
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0159 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0159 }
            boolean r9 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0159 }
            if (r9 == 0) goto L_0x008d
            float r8 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x0159 }
            double r8 = (double) r8     // Catch:{ Exception -> 0x0159 }
            r6.put(r0, r8)     // Catch:{ Exception -> 0x0159 }
            goto L_0x0072
        L_0x008d:
            java.lang.Object r9 = r2.get(r8)     // Catch:{ Exception -> 0x0159 }
            r6.put(r8, r9)     // Catch:{ Exception -> 0x0159 }
            goto L_0x0072
        L_0x0095:
            float r2 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x0159 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0159 }
            r6.put(r0, r2)     // Catch:{ Exception -> 0x0159 }
        L_0x009d:
            java.lang.Object r0 = r17.getMetaDataResponse()     // Catch:{ Exception -> 0x00b7 }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00b7 }
            r2.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r0 = r2.a((java.lang.Object) r0)     // Catch:{ Exception -> 0x00b7 }
            if (r0 == 0) goto L_0x00bf
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b7 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r0 = "meta_data"
            r5.put(r0, r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00bf
        L_0x00b7:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0159 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0159 }
        L_0x00bf:
            java.lang.String r0 = "configuration"
            r5.put(r0, r6)     // Catch:{ Exception -> 0x0159 }
            r4.put(r5)     // Catch:{ Exception -> 0x0159 }
            java.lang.String r0 = "cart_items"
            r12.put(r0, r4)     // Catch:{ Exception -> 0x0159 }
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/json"
            r0.put(r2, r3)
            java.util.HashMap r4 = com.paytm.utility.a.a((java.util.HashMap<java.lang.String, java.lang.String>) r0, (android.content.Context) r11)
            net.one97.paytm.j.c.a()
            java.lang.String r0 = "cartVerify"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r2 = com.paytm.utility.c.b((java.lang.String) r0, (android.content.Context) r11)
            r5 = 0
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.POST
            java.lang.String r7 = r12.toString()
            net.one97.paytm.common.entity.CJRRechargeCart r8 = new net.one97.paytm.common.entity.CJRRechargeCart
            r8.<init>()
            com.paytm.network.a$c r9 = com.paytm.network.a.c.HOME
            com.paytm.network.a$b r0 = com.paytm.network.a.b.USER_FACING
            r1 = r16
            r3 = r16
            r13 = 2131959561(0x7f131f09, float:1.9555766E38)
            r10 = r0
            com.paytm.network.a r0 = net.one97.paytm.common.b.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r1 = r12.toString()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0120
            boolean r1 = com.paytm.utility.a.m(r16)
            if (r1 == 0) goto L_0x0119
            r0.a()
            return
        L_0x0119:
            net.one97.paytm.utils.r.a((com.paytm.network.a) r0, (android.content.Context) r11, (android.content.DialogInterface.OnCancelListener) r11)
            r16.m()
            return
        L_0x0120:
            r16.m()
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r11)
            android.content.res.Resources r1 = r16.getResources()
            java.lang.String r1 = r1.getString(r13)
            android.app.AlertDialog$Builder r1 = r0.setTitle(r1)
            android.content.res.Resources r2 = r16.getResources()
            java.lang.String r2 = r2.getString(r15)
            r1.setMessage(r2)
            r0.setCancelable(r14)
            android.content.res.Resources r1 = r16.getResources()
            r2 = 2131959943(0x7f132087, float:1.955654E38)
            java.lang.String r1 = r1.getString(r2)
            net.one97.paytm.CJROrderBaseActivity$2 r2 = new net.one97.paytm.CJROrderBaseActivity$2
            r2.<init>()
            r0.setPositiveButton(r1, r2)
            r0.show()
            return
        L_0x0159:
            r0 = move-exception
            r13 = 2131959561(0x7f131f09, float:1.9555766E38)
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r11)
            android.content.res.Resources r1 = r16.getResources()
            java.lang.String r1 = r1.getString(r13)
            android.app.AlertDialog$Builder r1 = r0.setTitle(r1)
            android.content.res.Resources r2 = r16.getResources()
            java.lang.String r2 = r2.getString(r15)
            r1.setMessage(r2)
            r0.setCancelable(r14)
            android.content.res.Resources r1 = r16.getResources()
            r2 = 2131959943(0x7f132087, float:1.955654E38)
            java.lang.String r1 = r1.getString(r2)
            net.one97.paytm.CJROrderBaseActivity$1 r2 = new net.one97.paytm.CJROrderBaseActivity$1
            r2.<init>()
            r0.setPositiveButton(r1, r2)
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.CJROrderBaseActivity.b(net.one97.paytm.common.entity.shopping.CJROrderedCart):void");
    }

    public final void a(CJROrderedCart cJROrderedCart) {
        b(cJROrderedCart);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onApiSuccess(iJRPaytmDataModel);
    }

    public void onAddMoneyInvalidAmountEntered(String str) {
        if (!TextUtils.isEmpty(str) && !isFinishing()) {
            b.b((Context) this, getResources().getString(R.string.error), str);
        }
    }

    static /* synthetic */ void a(CJROrderBaseActivity cJROrderBaseActivity) {
        cJROrderBaseActivity.m();
        cJROrderBaseActivity.C = 0;
        a.i();
    }
}
