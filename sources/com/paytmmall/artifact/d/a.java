package com.paytmmall.artifact.d;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity;
import com.paytmmall.artifact.clp.activity.AJRSecondaryHome;
import com.paytmmall.artifact.common.activity.AJRWebViewActivity;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.flyout.AJRWeexFullPageFlyoutActivity;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a {

    /* renamed from: g  reason: collision with root package name */
    private static a f15664g;

    /* renamed from: a  reason: collision with root package name */
    Set<String> f15665a = Collections.unmodifiableSet(this.f15669e);

    /* renamed from: b  reason: collision with root package name */
    Set<String> f15666b = Collections.unmodifiableSet(this.f15670f);

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f15667c = Collections.unmodifiableMap(this.f15668d);

    /* renamed from: d  reason: collision with root package name */
    Map<String, String> f15668d = new HashMap<String, String>() {
        {
            put("homepage_secondary", AJRSecondaryHome.class.getName());
            put("cart", AJRShoppingCartActivity.class.getName());
            put(CLPConstants.WISHLIST, AJRShoppingCartActivity.class.getName());
            put("expresscart", AJRShoppingCartActivity.class.getName());
            put("checkout", AJRShoppingCartActivity.class.getName());
            put("search", t.e().getSearchActivity().getName());
            put("flyout", AJRWeexFullPageFlyoutActivity.class.getName());
            put("manage_fastag", "H5Page");
            put(CLPConstants.URL_TYPE_EMBED, AJRWebViewActivity.class.getName());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    HashSet<String> f15669e = new HashSet<String>() {
        {
            add(CLPConstants.CONFIG_KEY_MY_ORDERS);
            add("profile");
            add("myprofile");
            add("flyout");
            add("product");
            add("homepage_secondary");
            add("itemdetails");
            add(CLPConstants.DEFAULT_GRID_VIEW_TYPE);
            add("smart_list");
            add("list");
            add(CLPConstants.URL_TYPE_EMBED);
            add("mpordersummary");
            add("cart");
            add("expresscart");
            add("servify");
            add("checkout");
            add("share_earn");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    HashSet<String> f15670f = new HashSet<String>() {
        {
            add(CLPConstants.CONFIG_KEY_MY_ORDERS);
            add("profile");
            add("myprofile");
            add(CLPConstants.URL_TYPE_EMBED);
            add("search");
        }
    };

    public static a a() {
        if (f15664g == null) {
            synchronized (a.class) {
                if (f15664g == null) {
                    f15664g = new a();
                }
            }
        }
        return f15664g;
    }

    private a() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0100, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0102, code lost:
        a(r9, r7);
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0348 A[SYNTHETIC, Splitter:B:171:0x0348] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r17, java.lang.String r18, java.util.HashMap<java.lang.String, java.io.Serializable> r19) {
        /*
            r16 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            java.lang.String r3 = "mall"
            java.lang.String r4 = "/detail"
            java.lang.String r5 = "myOrders/"
            java.lang.String r6 = "extra_home_data"
            java.lang.Object r7 = r2.get(r6)
            java.lang.Class<com.paytmmall.artifact.common.entity.CJRHomePageItem> r8 = com.paytmmall.artifact.common.entity.CJRHomePageItem.class
            java.lang.Object r7 = com.paytmmall.artifact.e.a.a((java.lang.Object) r7, r8)
            com.paytmmall.artifact.common.entity.CJRHomePageItem r7 = (com.paytmmall.artifact.common.entity.CJRHomePageItem) r7
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x002c
            java.lang.String r9 = r7.getDeeplink()
            com.paytmmall.artifact.common.entity.CJRHomePageItem r9 = com.paytmmall.artifact.d.o.a((android.content.Context) r1, (java.lang.String) r9)
            if (r9 == 0) goto L_0x002c
            java.lang.String r8 = r9.getURL()
        L_0x002c:
            if (r7 == 0) goto L_0x003a
            java.lang.String r9 = r7.getURL()
            if (r9 != 0) goto L_0x003a
            r7.setUrl(r8)
            r2.put(r6, r7)
        L_0x003a:
            java.lang.String r9 = "deals"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0046
            java.lang.String r0 = com.paytmmall.artifact.d.o.a((java.lang.String) r8, (java.lang.String) r0)
        L_0x0046:
            r9 = r0
            r0 = -1
            int r10 = r9.hashCode()
            java.lang.String r13 = "grid"
            java.lang.String r14 = "wishlist"
            switch(r10) {
                case -1612654376: goto L_0x00de;
                case -1271338501: goto L_0x00d3;
                case -968641083: goto L_0x00cb;
                case -640848945: goto L_0x00c1;
                case -404972101: goto L_0x00b7;
                case -309474065: goto L_0x00ac;
                case -90394212: goto L_0x00a1;
                case 3046176: goto L_0x0097;
                case 3181382: goto L_0x008e;
                case 120898265: goto L_0x0083;
                case 175362704: goto L_0x0078;
                case 1536904518: goto L_0x006d;
                case 1825776990: goto L_0x0062;
                case 1984153382: goto L_0x0056;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x00e7
        L_0x0056:
            java.lang.String r10 = "servify"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 10
            goto L_0x00e7
        L_0x0062:
            java.lang.String r10 = "nearbuy"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 2
            goto L_0x00e7
        L_0x006d:
            java.lang.String r10 = "checkout"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 4
            goto L_0x00e7
        L_0x0078:
            java.lang.String r10 = "expresscart"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 7
            goto L_0x00e7
        L_0x0083:
            java.lang.String r10 = "paytmbang"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 13
            goto L_0x00e7
        L_0x008e:
            boolean r10 = r9.equals(r13)
            if (r10 == 0) goto L_0x00e7
            r0 = 12
            goto L_0x00e7
        L_0x0097:
            java.lang.String r10 = "cart"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 3
            goto L_0x00e7
        L_0x00a1:
            java.lang.String r10 = "manage_fastag"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 8
            goto L_0x00e7
        L_0x00ac:
            java.lang.String r10 = "product"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 11
            goto L_0x00e7
        L_0x00b7:
            java.lang.String r10 = "mpordersummary"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 1
            goto L_0x00e7
        L_0x00c1:
            java.lang.String r10 = "itemdetails"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 5
            goto L_0x00e7
        L_0x00cb:
            boolean r10 = r9.equals(r14)
            if (r10 == 0) goto L_0x00e7
            r0 = 6
            goto L_0x00e7
        L_0x00d3:
            java.lang.String r10 = "flyout"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 9
            goto L_0x00e7
        L_0x00de:
            java.lang.String r10 = "my_orders"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x00e7
            r0 = 0
        L_0x00e7:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r11 = "Account"
            java.lang.String r15 = "wishlist_source"
            java.lang.String r12 = "need_wishlist_open"
            switch(r0) {
                case 0: goto L_0x0281;
                case 1: goto L_0x027d;
                case 2: goto L_0x026f;
                case 3: goto L_0x026f;
                case 4: goto L_0x026f;
                case 5: goto L_0x0227;
                case 6: goto L_0x01c6;
                case 7: goto L_0x01c5;
                case 8: goto L_0x018d;
                case 9: goto L_0x0136;
                case 10: goto L_0x010c;
                case 11: goto L_0x0106;
                case 12: goto L_0x00f7;
                case 13: goto L_0x0100;
                default: goto L_0x00f3;
            }
        L_0x00f3:
            r4 = r16
            goto L_0x0285
        L_0x00f7:
            if (r7 == 0) goto L_0x0100
            boolean r0 = a((java.lang.String) r9, (com.paytmmall.artifact.common.entity.CJRHomePageItem) r7)
            if (r0 == 0) goto L_0x0100
            return
        L_0x0100:
            if (r7 == 0) goto L_0x0105
            a((java.lang.String) r9, (com.paytmmall.artifact.common.entity.CJRHomePageItem) r7)
        L_0x0105:
            return
        L_0x0106:
            if (r7 == 0) goto L_0x010b
            a((java.lang.String) r9, (com.paytmmall.artifact.common.entity.CJRHomePageItem) r7)
        L_0x010b:
            return
        L_0x010c:
            com.paytmmall.artifact.common.a r0 = com.paytmmall.artifact.d.t.e()
            boolean r0 = r0.isServifyEnabled()
            if (r0 == 0) goto L_0x0120
            com.paytmmall.artifact.common.a r0 = com.paytmmall.artifact.d.t.e()
            boolean r0 = r0.isMallApp()
            if (r0 != 0) goto L_0x0135
        L_0x0120:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r2 = r1 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0135
            com.paytmmall.artifact.common.a r2 = com.paytmmall.artifact.d.t.e()
            android.app.Activity r1 = (android.app.Activity) r1
            java.lang.String r3 = "update_message"
            r2.resolveIntentByMainApp(r1, r0, r3, r10)
        L_0x0135:
            return
        L_0x0136:
            boolean r0 = com.paytmmall.artifact.d.d.a((android.content.Context) r17)
            if (r0 != 0) goto L_0x014e
            boolean r0 = r1 instanceof android.app.Activity
            if (r0 == 0) goto L_0x014e
            r0 = r1
            android.app.Activity r0 = (android.app.Activity) r0
            int r1 = com.paytmmall.artifact.R.string.No_internet_error
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            return
        L_0x014e:
            if (r7 == 0) goto L_0x00f3
            java.lang.String r0 = r7.getDeeplink()     // Catch:{ Exception -> 0x0187 }
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = r7.getDeeplink()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r4 = "targetPage=home"
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x0187 }
            if (r0 == 0) goto L_0x00f3
            com.paytmmall.artifact.common.a r0 = com.paytmmall.artifact.d.t.e()     // Catch:{ Exception -> 0x0187 }
            boolean r0 = r0.isMallApp()     // Catch:{ Exception -> 0x0187 }
            if (r0 != 0) goto L_0x016e
            goto L_0x00f3
        L_0x016e:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0187 }
            r0.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r4 = "ACTION"
            java.lang.String r5 = "OPEN_DRAWER"
            r0.putExtra(r4, r5)     // Catch:{ Exception -> 0x0187 }
            com.paytmmall.artifact.common.a r4 = com.paytmmall.artifact.d.t.e()     // Catch:{ Exception -> 0x0187 }
            r5 = r1
            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ Exception -> 0x0187 }
            java.lang.String r8 = "mainActivity"
            r4.resolveIntentByMainApp(r5, r0, r8, r10)     // Catch:{ Exception -> 0x0187 }
            return
        L_0x0187:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00f3
        L_0x018d:
            if (r7 == 0) goto L_0x01ad
            java.lang.String r0 = r7.getURL()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ad
            java.lang.String r0 = r7.getURL()
            java.lang.String r1 = "http"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x01ad
            java.lang.String r0 = r7.getURL()
            com.paytmmall.a.a.b(r0)
            return
        L_0x01ad:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.paytmmall.a.a.e()
            r0.append(r1)
            java.lang.String r1 = "manage-fastag"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.paytmmall.a.a.b(r0)
        L_0x01c5:
            return
        L_0x01c6:
            java.lang.String r0 = com.paytmmall.artifact.d.l.a((android.content.Context) r17)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ee
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity> r3 = com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity.class
            r0.<init>(r1, r3)
            r3 = 1
            r0.putExtra(r12, r3)
            r0.putExtra(r15, r11)
            a((android.content.Intent) r0, (java.util.HashMap<java.lang.String, java.io.Serializable>) r2)
            boolean r2 = r1 instanceof android.app.Activity
            if (r2 != 0) goto L_0x01ea
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r0.setFlags(r2)
        L_0x01ea:
            r1.startActivity(r0)
            return
        L_0x01ee:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.Class<com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity> r3 = com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "resultant activity"
            r0.putExtra(r4, r3)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r4 = 1
            r3.putBoolean(r12, r4)
            r3.putString(r15, r11)
            java.lang.String r5 = "is_bundle_required"
            r0.putExtra(r5, r4)
            java.lang.String r4 = "resultant activity_bundle"
            r0.putExtra(r4, r3)
            a((android.content.Intent) r0, (java.util.HashMap<java.lang.String, java.io.Serializable>) r2)
            boolean r2 = r1 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0226
            com.paytmmall.artifact.common.a r2 = com.paytmmall.artifact.d.t.e()
            android.app.Activity r1 = (android.app.Activity) r1
            java.lang.String r3 = "authActivity"
            r2.resolveIntentByMainApp(r1, r0, r3, r10)
        L_0x0226:
            return
        L_0x0227:
            java.lang.String r0 = com.paytmmall.artifact.d.l.a((android.content.Context) r17)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x026e
            if (r7 == 0) goto L_0x026e
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x025f }
            java.lang.String r1 = "item_id"
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch:{ Exception -> 0x025f }
            r7.setCstItemId(r0)     // Catch:{ Exception -> 0x025f }
            boolean r0 = r8.contains(r5)     // Catch:{ Exception -> 0x025f }
            if (r0 == 0) goto L_0x0263
            boolean r0 = r8.contains(r4)     // Catch:{ Exception -> 0x025f }
            if (r0 == 0) goto L_0x0263
            int r0 = r8.indexOf(r5)     // Catch:{ Exception -> 0x025f }
            int r1 = r8.indexOf(r4)     // Catch:{ Exception -> 0x025f }
            r2 = 9
            int r0 = r0 + r2
            java.lang.String r0 = r8.substring(r0, r1)     // Catch:{ Exception -> 0x025f }
            r7.setCstOrderId(r0)     // Catch:{ Exception -> 0x025f }
            goto L_0x0263
        L_0x025f:
            r0 = move-exception
            com.paytmmall.artifact.d.s.a(r0)
        L_0x0263:
            java.lang.String r0 = r7.getCstOrderId()
            java.lang.String r1 = r7.getCstItemId()
            com.paytmmall.a.a.a((java.lang.String) r0, (java.lang.String) r1)
        L_0x026e:
            return
        L_0x026f:
            boolean r0 = com.paytmmall.a.a.d(r8)
            if (r0 != 0) goto L_0x027c
            java.lang.String r0 = com.paytmmall.artifact.d.l.a((android.content.Context) r17)
            android.text.TextUtils.isEmpty(r0)
        L_0x027c:
            return
        L_0x027d:
            com.paytmmall.a.a.b(r8, r9)
            return
        L_0x0281:
            com.paytmmall.a.a.c()
            return
        L_0x0285:
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.f15667c
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x03c0
            java.lang.String r5 = "external"
            boolean r5 = r5.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x03c0 }
            if (r5 == 0) goto L_0x02c8
            if (r7 == 0) goto L_0x02c8
            java.lang.String r0 = r7.getURL()     // Catch:{ Exception -> 0x03c0 }
            boolean r2 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x02c7
            java.lang.String r2 = "browser"
            java.lang.String r3 = "1"
            java.lang.String r0 = com.paytmmall.artifact.d.g.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x03c0 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r3 = "android.intent.action.VIEW"
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x03c0 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x03c0 }
            android.content.pm.PackageManager r0 = r17.getPackageManager()     // Catch:{ Exception -> 0x03c0 }
            android.content.ComponentName r0 = r2.resolveActivity(r0)     // Catch:{ Exception -> 0x03c0 }
            if (r0 == 0) goto L_0x02c7
            r1.startActivity(r2)     // Catch:{ Exception -> 0x03c0 }
        L_0x02c7:
            return
        L_0x02c8:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x03c0 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x03c0 }
            r5.<init>(r1, r0)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = "From"
            java.lang.Object r0 = r2.get(r0)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x03c0 }
            a((android.content.Intent) r5, (java.util.HashMap<java.lang.String, java.io.Serializable>) r2)     // Catch:{ Exception -> 0x03c0 }
            boolean r8 = r13.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x03c0 }
            if (r8 != 0) goto L_0x02f5
            java.lang.String r8 = "smart_list"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x03c0 }
            if (r8 != 0) goto L_0x02f5
            java.lang.String r8 = "list"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x03c0 }
            if (r8 == 0) goto L_0x0311
        L_0x02f5:
            a((android.content.Intent) r5, (java.util.HashMap<java.lang.String, java.io.Serializable>) r2)     // Catch:{ Exception -> 0x03c0 }
            if (r7 == 0) goto L_0x0311
            boolean r2 = r7.isFromReqDelivery()     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x0306
            java.lang.String r2 = "is_from_req_delivery"
            r8 = 1
            r5.putExtra(r2, r8)     // Catch:{ Exception -> 0x03c0 }
        L_0x0306:
            com.paytm.network.model.IJRPaytmDataModel r2 = r7.getBuilderModel()     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x0311
            java.lang.String r8 = "intent_builder_model"
            r5.putExtra(r8, r2)     // Catch:{ Exception -> 0x03c0 }
        L_0x0311:
            java.lang.String r2 = "search"
            boolean r2 = r2.equals(r9)     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x0331
            java.lang.String r2 = "deeplinking"
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x03c0 }
            if (r2 != 0) goto L_0x0328
            if (r7 == 0) goto L_0x0328
            r2 = 0
            r7.setCategoryId(r2)     // Catch:{ Exception -> 0x03c0 }
            goto L_0x032b
        L_0x0328:
            r5.putExtra(r6, r7)     // Catch:{ Exception -> 0x03c0 }
        L_0x032b:
            java.lang.String r2 = "is_from_search"
            r6 = 1
            r5.putExtra(r2, r6)     // Catch:{ Exception -> 0x03c0 }
        L_0x0331:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ UnsupportedEncodingException -> 0x0343 }
            if (r2 != 0) goto L_0x0344
            java.lang.String r2 = "origin"
            java.lang.String r6 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r6)     // Catch:{ UnsupportedEncodingException -> 0x0343 }
            r5.putExtra(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x0343 }
            goto L_0x0344
        L_0x0343:
        L_0x0344:
            java.lang.String r0 = "resultant fragment type"
            if (r9 == 0) goto L_0x0351
            boolean r2 = r9.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x0351
            r5.putExtra(r0, r3)     // Catch:{ Exception -> 0x03c0 }
        L_0x0351:
            if (r9 == 0) goto L_0x0362
            java.lang.String r2 = "updates"
            boolean r2 = r9.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x0362
            java.lang.String r2 = "updates"
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x03c0 }
        L_0x0362:
            if (r9 == 0) goto L_0x0385
            java.lang.String r2 = "vibe"
            boolean r2 = r9.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x03c0 }
            if (r2 == 0) goto L_0x0385
            java.lang.String r2 = "vibe"
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = "category"
            java.lang.String r2 = r7.getmVibeCategory()     // Catch:{ Exception -> 0x03c0 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = "article_id"
            java.lang.String r2 = r7.getmVibeArticleId()     // Catch:{ Exception -> 0x03c0 }
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x03c0 }
        L_0x0385:
            if (r9 == 0) goto L_0x0394
            boolean r0 = r9.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x03c0 }
            if (r0 == 0) goto L_0x0394
            r2 = 1
            r5.putExtra(r12, r2)     // Catch:{ Exception -> 0x03c0 }
            r5.putExtra(r15, r11)     // Catch:{ Exception -> 0x03c0 }
        L_0x0394:
            if (r9 == 0) goto L_0x03bd
            java.lang.String r0 = "signin_profile"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x03c0 }
            if (r0 == 0) goto L_0x03bd
            java.lang.String r0 = "redirectVertical"
            java.lang.String r2 = "login_signup"
            r5.putExtra(r0, r2)     // Catch:{ Exception -> 0x03c0 }
            r0 = 0
            if (r7 == 0) goto L_0x03b7
            java.lang.String r2 = r7.getUtmSource()     // Catch:{ Exception -> 0x03c0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x03c0 }
            if (r2 != 0) goto L_0x03b7
            java.lang.String r0 = r7.getUtmSource()     // Catch:{ Exception -> 0x03c0 }
        L_0x03b7:
            java.lang.String r2 = "utmsource"
            r5.putExtra(r2, r0)     // Catch:{ Exception -> 0x03c0 }
        L_0x03bd:
            r1.startActivity(r5)     // Catch:{ Exception -> 0x03c0 }
        L_0x03c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.d.a.a(android.content.Context, java.lang.String, java.util.HashMap):void");
    }

    private static boolean a(String str, CJRHomePageItem cJRHomePageItem) {
        if (cJRHomePageItem != null && cJRHomePageItem.getURL().startsWith("ACTIVATE_FASTAG")) {
            return false;
        }
        String url = cJRHomePageItem.getURL();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        return com.paytmmall.a.a.b(url, str);
    }

    private static void a(Intent intent, HashMap<String, Serializable> hashMap) {
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                intent.putExtra(next, hashMap.get(next));
            }
        }
    }

    public final void a(Activity activity, String str) {
        CJRHomePageItem a2 = o.a(activity, str, "");
        HashMap hashMap = new HashMap();
        if (a2 == null || !t.a(a2.getURLType())) {
            t.e().checkDeepLinking(activity, str);
            return;
        }
        a2.getDeeplink();
        hashMap.put("extra_home_data", a2);
        hashMap.put("origin", "deeplinking");
        a(a2, (HashMap<String, Serializable>) hashMap);
        a(activity, a2.getURLType(), hashMap);
    }

    private static void a(CJRHomePageItem cJRHomePageItem, HashMap<String, Serializable> hashMap) {
        cJRHomePageItem.setSearchType(cJRHomePageItem.getSearchType());
        cJRHomePageItem.setSearchResultType(cJRHomePageItem.getSearchResultType());
        cJRHomePageItem.setAutoSuggestMetaData(cJRHomePageItem.getAutoSuggestMetaData());
        String searchKey = cJRHomePageItem.getSearchKey();
        if (searchKey != null) {
            cJRHomePageItem.setSearchTerm(searchKey);
            cJRHomePageItem.setSearcKey(searchKey);
            cJRHomePageItem.setTitle(searchKey);
        }
        String searchCategory = cJRHomePageItem.getSearchCategory();
        if (searchCategory != null) {
            cJRHomePageItem.setSearchCategory(searchCategory);
        }
        cJRHomePageItem.setSearchUrl(cJRHomePageItem.getURL());
        hashMap.put("is_deep_linking_data", Boolean.valueOf(cJRHomePageItem.isDeepLinking()));
        if (!TextUtils.isEmpty(cJRHomePageItem.getSearchType()) && !cJRHomePageItem.getSearchType().equalsIgnoreCase("popularsearch")) {
            hashMap.put("is_normal_search", Boolean.TRUE);
        }
        if (cJRHomePageItem.isFromFromSearch()) {
            hashMap.put("is_from_search", Boolean.TRUE);
        }
    }
}
