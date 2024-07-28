package com.paytmmall.artifact.cart.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.artifact.cart.entity.WishList;
import com.paytmmall.artifact.common.a.a;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.g;
import com.paytmmall.b.a;
import com.paytmmall.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import org.json.JSONObject;

public final class c {
    public static void a(Context context, b bVar) {
        a.a();
        String a2 = a.a("wishList", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            Context context2 = context;
            com.paytmmall.b.a.a(context2, a.C0216a.GET, g.b(a2, context), (String) null, d.a((HashMap<String, String>) new HashMap(), context), new WishList(), bVar);
        }
    }

    public static void a(final Context context, final b bVar, final String str, final String str2) {
        com.paytmmall.artifact.common.a.a.a();
        String a2 = com.paytmmall.artifact.common.a.a.a("wishList", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            String b2 = g.b(a2, context);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            HashMap<String, String> a3 = d.a((HashMap<String, String>) hashMap, context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CLPConstants.PRODUCT_ID, str);
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    jSONObject.put("source", (Object) null);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("current_product_id", str2);
                }
            } catch (Exception unused) {
            }
            com.paytmmall.b.a aVar = com.paytmmall.b.a.f16033a;
            com.paytmmall.b.a.a(context, a.C0216a.POST, b2, jSONObject.toString(), a3, new WishList(), new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    a.b(context, str);
                    com.paytmmall.a.a.c.a(context, "wishlistResponse");
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.onApiSuccess(iJRPaytmDataModel);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        androidx.localbroadcastmanager.a.a.a(context).a(new Intent("ACTION_UPDATE_WISHLIST"));
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                    }
                }
            });
        }
    }

    public static void a(final Context context, final b bVar, final String str) {
        if (!TextUtils.isEmpty(str) && d.d(context)) {
            a(context, new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                /* JADX WARNING: Removed duplicated region for block: B:19:0x0098  */
                /* JADX WARNING: Removed duplicated region for block: B:21:0x009b  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r10) {
                    /*
                        r9 = this;
                        if (r10 == 0) goto L_0x0095
                        com.paytmmall.artifact.cart.entity.WishList r10 = (com.paytmmall.artifact.cart.entity.WishList) r10
                        android.content.Context r0 = r1
                        androidx.localbroadcastmanager.a.a r0 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r0)
                        android.content.Intent r1 = new android.content.Intent
                        java.lang.String r2 = "ACTION_UPDATE_WISHLIST"
                        r1.<init>(r2)
                        r0.a((android.content.Intent) r1)
                        java.util.ArrayList r10 = r10.getmProduct()
                        if (r10 == 0) goto L_0x0095
                        int r0 = r10.size()
                        if (r0 <= 0) goto L_0x0095
                        java.util.Iterator r10 = r10.iterator()
                    L_0x0024:
                        boolean r0 = r10.hasNext()
                        if (r0 == 0) goto L_0x0095
                        java.lang.Object r0 = r10.next()
                        com.paytmmall.artifact.cart.entity.WishListProduct r0 = (com.paytmmall.artifact.cart.entity.WishListProduct) r0
                        if (r0 == 0) goto L_0x0024
                        java.lang.String r1 = r3
                        java.lang.String r0 = r0.getProductId()
                        boolean r0 = r1.equalsIgnoreCase(r0)
                        if (r0 == 0) goto L_0x0024
                        r10 = 1
                        com.paytmmall.artifact.common.a.a.a()
                        r0 = 0
                        java.lang.String r1 = "wishList"
                        java.lang.String r0 = com.paytmmall.artifact.common.a.a.a((java.lang.String) r1, (java.lang.String) r0)
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        r1.append(r0)
                        java.lang.String r0 = "/remove"
                        r1.append(r0)
                        java.lang.String r0 = r1.toString()
                        android.content.Context r1 = r1
                        java.lang.String r4 = com.paytmmall.artifact.d.g.b(r0, r1)
                        java.util.HashMap r0 = new java.util.HashMap
                        r0.<init>()
                        java.lang.String r1 = "Content-Type"
                        java.lang.String r2 = "application/json"
                        r0.put(r1, r2)
                        android.content.Context r1 = r1
                        java.util.HashMap r6 = com.paytmmall.artifact.d.d.a((java.util.HashMap<java.lang.String, java.lang.String>) r0, (android.content.Context) r1)
                        org.json.JSONObject r0 = new org.json.JSONObject
                        r0.<init>()
                        java.lang.String r1 = "product_id"
                        java.lang.String r2 = r3     // Catch:{ Exception -> 0x007f }
                        r0.put(r1, r2)     // Catch:{ Exception -> 0x007f }
                    L_0x007f:
                        android.content.Context r2 = r1
                        com.paytmmall.b.a$a r3 = com.paytmmall.b.a.C0216a.POST
                        java.lang.String r5 = r0.toString()
                        com.paytmmall.artifact.cart.entity.WishList r7 = new com.paytmmall.artifact.cart.entity.WishList
                        r7.<init>()
                        com.paytmmall.artifact.cart.d.c$2$1 r8 = new com.paytmmall.artifact.cart.d.c$2$1
                        r8.<init>()
                        com.paytmmall.b.a.a(r2, r3, r4, r5, r6, r7, r8)
                        goto L_0x0096
                    L_0x0095:
                        r10 = 0
                    L_0x0096:
                        if (r10 == 0) goto L_0x009b
                        boolean r10 = com.paytmmall.artifact.d.c.f15691a
                        return
                    L_0x009b:
                        android.content.Context r10 = r1
                        java.lang.String r0 = r3
                        com.paytmmall.artifact.cart.d.a.c(r10, r0)
                        boolean r10 = com.paytmmall.artifact.d.c.f15691a
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.cart.d.c.AnonymousClass2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
                }
            });
        }
    }
}
