package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.android.a.a.a;
import com.android.billingclient.api.a;
import com.android.billingclient.api.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    int f30914a = 0;

    /* renamed from: b  reason: collision with root package name */
    final a f30915b;

    /* renamed from: c  reason: collision with root package name */
    final Context f30916c;

    /* renamed from: d  reason: collision with root package name */
    com.android.a.a.a f30917d;

    /* renamed from: e  reason: collision with root package name */
    boolean f30918e;

    /* renamed from: f  reason: collision with root package name */
    boolean f30919f;

    /* renamed from: g  reason: collision with root package name */
    boolean f30920g;

    /* renamed from: h  reason: collision with root package name */
    boolean f30921h;

    /* renamed from: i  reason: collision with root package name */
    private int f30922i = 0;
    private final Handler j = new Handler();
    private ServiceConnection k;
    private ExecutorService l;
    private final ResultReceiver m = new BillingClientImpl$1(this, new Handler());

    public c(Context context, h hVar) {
        this.f30916c = context.getApplicationContext();
        this.f30915b = new a(this.f30916c, hVar);
    }

    public final int a(String str) {
        char c2 = 65535;
        if (!a()) {
            return -1;
        }
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    c2 = 1;
                    break;
                }
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    c2 = 4;
                    break;
                }
                break;
            case 292218239:
                if (str.equals("inAppItemsOnVr")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1219490065:
                if (str.equals("subscriptionsOnVr")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1987365622:
                if (str.equals("subscriptions")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return this.f30918e ? 0 : -2;
        }
        if (c2 == 1) {
            return this.f30919f ? 0 : -2;
        }
        if (c2 == 2) {
            return c("inapp");
        }
        if (c2 == 3) {
            return c("subs");
        }
        if (c2 == 4) {
            return this.f30921h ? 0 : -2;
        }
        "Unsupported feature: ".concat(String.valueOf(str));
        com.android.billingclient.a.a.b("BillingClient");
        return 5;
    }

    public final boolean a() {
        return (this.f30914a != 2 || this.f30917d == null || this.k == null) ? false : true;
    }

    public final void a(d dVar) {
        if (a()) {
            com.android.billingclient.a.a.a("BillingClient");
            dVar.a(0);
            return;
        }
        int i2 = this.f30914a;
        if (i2 == 1) {
            com.android.billingclient.a.a.b("BillingClient");
            dVar.a(5);
        } else if (i2 == 3) {
            com.android.billingclient.a.a.b("BillingClient");
            dVar.a(5);
        } else {
            this.f30914a = 1;
            a aVar = this.f30915b;
            a.C0526a aVar2 = aVar.f30908b;
            Context context = aVar.f30907a;
            IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
            if (!aVar2.f30909a) {
                context.registerReceiver(a.this.f30908b, intentFilter);
                aVar2.f30909a = true;
            }
            com.android.billingclient.a.a.a("BillingClient");
            this.k = new a(this, dVar, (byte) 0);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.f30916c.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null) {
                        com.android.billingclient.a.a.b("BillingClient");
                    } else {
                        ComponentName componentName = new ComponentName(str, str2);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        intent2.putExtra("libraryVersion", "1.2");
                        if (this.f30916c.bindService(intent2, this.k, 1)) {
                            com.android.billingclient.a.a.a("BillingClient");
                            return;
                        }
                        com.android.billingclient.a.a.b("BillingClient");
                    }
                }
            }
            this.f30914a = 0;
            com.android.billingclient.a.a.a("BillingClient");
            dVar.a(3);
        }
    }

    public final void b() {
        try {
            a aVar = this.f30915b;
            a.C0526a aVar2 = aVar.f30908b;
            Context context = aVar.f30907a;
            if (aVar2.f30909a) {
                context.unregisterReceiver(a.this.f30908b);
                aVar2.f30909a = false;
            } else {
                com.android.billingclient.a.a.b("BillingBroadcastManager");
            }
            if (!(this.k == null || this.f30917d == null)) {
                com.android.billingclient.a.a.a("BillingClient");
                this.f30916c.unbindService(this.k);
                this.k = null;
            }
            this.f30917d = null;
            if (this.l != null) {
                this.l.shutdownNow();
                this.l = null;
            }
        } catch (Exception e2) {
            "There was an exception while ending connection: ".concat(String.valueOf(e2));
            com.android.billingclient.a.a.b("BillingClient");
        } finally {
            this.f30914a = 3;
        }
    }

    public final int a(Activity activity, e eVar) {
        String str;
        Bundle bundle;
        Activity activity2 = activity;
        e eVar2 = eVar;
        if (!a()) {
            return a(-1);
        }
        String optString = eVar2.f30942c != null ? eVar2.f30942c.f30959a.optString("type") : eVar2.f30941b;
        String optString2 = eVar2.f30942c != null ? eVar2.f30942c.f30959a.optString("productId") : eVar2.f30940a;
        i iVar = eVar2.f30942c;
        boolean z = iVar != null && iVar.f30959a.has("rewardToken");
        if (optString2 == null) {
            com.android.billingclient.a.a.b("BillingClient");
            return a(5);
        } else if (optString == null) {
            com.android.billingclient.a.a.b("BillingClient");
            return a(5);
        } else if (!optString.equals("subs") || this.f30918e) {
            boolean z2 = eVar2.f30943d != null;
            if (!z2 || this.f30919f) {
                if (((!eVar2.f30945f && eVar2.f30944e == null && eVar2.f30946g == 0) ? false : true) && !this.f30920g) {
                    com.android.billingclient.a.a.b("BillingClient");
                    return a(-2);
                } else if (!z || this.f30920g) {
                    try {
                        StringBuilder sb = new StringBuilder("Constructing buy intent for ");
                        sb.append(optString2);
                        sb.append(", item type: ");
                        sb.append(optString);
                        com.android.billingclient.a.a.a("BillingClient");
                        if (this.f30920g) {
                            Bundle bundle2 = new Bundle();
                            if (eVar2.f30946g != 0) {
                                bundle2.putInt("prorationMode", eVar2.f30946g);
                            }
                            if (eVar2.f30944e != null) {
                                bundle2.putString("accountId", eVar2.f30944e);
                            }
                            if (eVar2.f30945f) {
                                bundle2.putBoolean("vr", true);
                            }
                            if (eVar2.f30943d != null) {
                                bundle2.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[]{eVar2.f30943d})));
                            }
                            bundle2.putString("libraryVersion", "1.2");
                            if (z) {
                                bundle2.putString("rewardToken", iVar.f30959a.optString("rewardToken"));
                                if (this.f30922i == 1 || this.f30922i == 2) {
                                    bundle2.putInt("childDirected", this.f30922i);
                                }
                            }
                            bundle = this.f30917d.a(eVar2.f30945f ? 7 : 6, this.f30916c.getPackageName(), optString2, optString, (String) null, bundle2);
                            str = "BillingClient";
                        } else if (z2) {
                            com.android.a.a.a aVar = this.f30917d;
                            String packageName = this.f30916c.getPackageName();
                            String[] strArr = {eVar2.f30943d};
                            str = "BillingClient";
                            try {
                                bundle = aVar.a(5, packageName, (List<String>) Arrays.asList(strArr), optString2, "subs", (String) null);
                            } catch (RemoteException unused) {
                                StringBuilder sb2 = new StringBuilder("RemoteException while launching launching replace subscriptions flow: ; for sku: ");
                                sb2.append(optString2);
                                sb2.append("; try to reconnect");
                                com.android.billingclient.a.a.b(str);
                                return a(-1);
                            }
                        } else {
                            str = "BillingClient";
                            bundle = this.f30917d.a(3, this.f30916c.getPackageName(), optString2, optString, (String) null);
                        }
                        int a2 = com.android.billingclient.a.a.a(bundle, str);
                        if (a2 != 0) {
                            "Unable to buy item, Error response code: ".concat(String.valueOf(a2));
                            com.android.billingclient.a.a.b(str);
                            return a(a2);
                        }
                        Intent intent = new Intent(activity2, ProxyBillingActivity.class);
                        intent.putExtra("result_receiver", this.m);
                        intent.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                        activity2.startActivity(intent);
                        return 0;
                    } catch (RemoteException unused2) {
                        str = "BillingClient";
                        StringBuilder sb22 = new StringBuilder("RemoteException while launching launching replace subscriptions flow: ; for sku: ");
                        sb22.append(optString2);
                        sb22.append("; try to reconnect");
                        com.android.billingclient.a.a.b(str);
                        return a(-1);
                    }
                } else {
                    com.android.billingclient.a.a.b("BillingClient");
                    return a(-2);
                }
            } else {
                com.android.billingclient.a.a.b("BillingClient");
                return a(-2);
            }
        } else {
            com.android.billingclient.a.a.b("BillingClient");
            return a(-2);
        }
    }

    private int a(int i2) {
        this.f30915b.f30908b.f30911c.a(i2, (List<g>) null);
        return i2;
    }

    public final g.a b(String str) {
        if (!a()) {
            return new g.a(-1, (List<g>) null);
        }
        if (!TextUtils.isEmpty(str)) {
            return d(str);
        }
        com.android.billingclient.a.a.b("BillingClient");
        return new g.a(5, (List<g>) null);
    }

    public final void a(final String str, final f fVar) {
        if (!a()) {
            fVar.a(-1, (String) null);
        } else if (TextUtils.isEmpty(str)) {
            com.android.billingclient.a.a.b("BillingClient");
            fVar.a(5, str);
        } else {
            AnonymousClass1 r0 = new Runnable() {
                public final void run() {
                    c cVar = c.this;
                    String str = str;
                    f fVar = fVar;
                    try {
                        "Consuming purchase with token: ".concat(String.valueOf(str));
                        com.android.billingclient.a.a.a("BillingClient");
                        int b2 = cVar.f30917d.b(3, cVar.f30916c.getPackageName(), str);
                        if (b2 == 0) {
                            com.android.billingclient.a.a.a("BillingClient");
                            if (fVar != null) {
                                cVar.a((Runnable) new Runnable(fVar, b2, str) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ f f30926a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ int f30927b;

                                    /* renamed from: c  reason: collision with root package name */
                                    final /* synthetic */ String f30928c;

                                    {
                                        this.f30926a = r2;
                                        this.f30927b = r3;
                                        this.f30928c = r4;
                                    }

                                    public final void run() {
                                        this.f30926a.a(this.f30927b, this.f30928c);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        "Error consuming purchase with token. Response code: ".concat(String.valueOf(b2));
                        com.android.billingclient.a.a.b("BillingClient");
                        cVar.a((Runnable) new Runnable(fVar, b2, str) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ f f30930a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ int f30931b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ String f30932c;

                            {
                                this.f30930a = r2;
                                this.f30931b = r3;
                                this.f30932c = r4;
                            }

                            public final void run() {
                                com.android.billingclient.a.a.b("BillingClient");
                                this.f30930a.a(this.f30931b, this.f30932c);
                            }
                        });
                    } catch (RemoteException e2) {
                        cVar.a((Runnable) new Runnable(e2, fVar, str) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ RemoteException f30934a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ f f30935b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ String f30936c;

                            {
                                this.f30934a = r2;
                                this.f30935b = r3;
                                this.f30936c = r4;
                            }

                            public final void run() {
                                new StringBuilder("Error consuming purchase; ex: ").append(this.f30934a);
                                com.android.billingclient.a.a.b("BillingClient");
                                this.f30935b.a(-1, this.f30936c);
                            }
                        });
                    }
                }
            };
            if (this.l == null) {
                this.l = Executors.newFixedThreadPool(com.android.billingclient.a.a.f30904a);
            }
            this.l.submit(r0);
        }
    }

    private int c(String str) {
        try {
            com.android.a.a.a aVar = this.f30917d;
            String packageName = this.f30916c.getPackageName();
            Bundle bundle = new Bundle();
            bundle.putBoolean("vr", true);
            return aVar.b(7, packageName, str, bundle) == 0 ? 0 : -2;
        } catch (RemoteException unused) {
            com.android.billingclient.a.a.b("BillingClient");
            return -1;
        }
    }

    private g.a d(String str) {
        StringBuilder sb = new StringBuilder("Querying owned items, item type: ");
        sb.append(str);
        sb.append("; history: false");
        com.android.billingclient.a.a.a("BillingClient");
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        do {
            try {
                Bundle a2 = this.f30917d.a(3, this.f30916c.getPackageName(), str, str2);
                if (a2 == null) {
                    com.android.billingclient.a.a.b("BillingClient");
                    return new g.a(6, (List<g>) null);
                }
                int a3 = com.android.billingclient.a.a.a(a2, "BillingClient");
                if (a3 != 0) {
                    "getPurchases() failed. Response code: ".concat(String.valueOf(a3));
                    com.android.billingclient.a.a.b("BillingClient");
                    return new g.a(a3, (List<g>) null);
                } else if (!a2.containsKey("INAPP_PURCHASE_ITEM_LIST") || !a2.containsKey("INAPP_PURCHASE_DATA_LIST") || !a2.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                    com.android.billingclient.a.a.b("BillingClient");
                    return new g.a(6, (List<g>) null);
                } else {
                    ArrayList<String> stringArrayList = a2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = a2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = a2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    if (stringArrayList == null) {
                        com.android.billingclient.a.a.b("BillingClient");
                        return new g.a(6, (List<g>) null);
                    } else if (stringArrayList2 == null) {
                        com.android.billingclient.a.a.b("BillingClient");
                        return new g.a(6, (List<g>) null);
                    } else if (stringArrayList3 == null) {
                        com.android.billingclient.a.a.b("BillingClient");
                        return new g.a(6, (List<g>) null);
                    } else {
                        int i2 = 0;
                        while (i2 < stringArrayList2.size()) {
                            String str3 = stringArrayList2.get(i2);
                            String str4 = stringArrayList3.get(i2);
                            "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2)));
                            com.android.billingclient.a.a.a("BillingClient");
                            try {
                                g gVar = new g(str3, str4);
                                if (TextUtils.isEmpty(gVar.b())) {
                                    com.android.billingclient.a.a.b("BillingClient");
                                }
                                arrayList.add(gVar);
                                i2++;
                            } catch (JSONException e2) {
                                "Got an exception trying to decode the purchase: ".concat(String.valueOf(e2));
                                com.android.billingclient.a.a.b("BillingClient");
                                return new g.a(6, (List<g>) null);
                            }
                        }
                        str2 = a2.getString("INAPP_CONTINUATION_TOKEN");
                        "Continuation token: ".concat(String.valueOf(str2));
                        com.android.billingclient.a.a.a("BillingClient");
                    }
                }
            } catch (RemoteException e3) {
                StringBuilder sb2 = new StringBuilder("Got exception trying to get purchases: ");
                sb2.append(e3);
                sb2.append("; try to reconnect");
                com.android.billingclient.a.a.b("BillingClient");
                return new g.a(-1, (List<g>) null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new g.a(0, arrayList);
    }

    /* access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        this.j.post(runnable);
    }

    final class a implements ServiceConnection {

        /* renamed from: b  reason: collision with root package name */
        private final d f30939b;

        /* synthetic */ a(c cVar, d dVar, byte b2) {
            this(dVar);
        }

        private a(d dVar) {
            if (dVar != null) {
                this.f30939b = dVar;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when init is done.");
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.android.billingclient.a.a.b("BillingClient");
            c cVar = c.this;
            cVar.f30917d = null;
            cVar.f30914a = 0;
            this.f30939b.a();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.android.billingclient.a.a.a("BillingClient");
            c.this.f30917d = a.C0524a.a(iBinder);
            String packageName = c.this.f30916c.getPackageName();
            int i2 = 8;
            int i3 = 3;
            while (true) {
                if (i2 < 3) {
                    i2 = 0;
                    break;
                }
                try {
                    i3 = c.this.f30917d.a(i2, packageName, "subs");
                    if (i3 == 0) {
                        break;
                    }
                    i2--;
                } catch (RemoteException e2) {
                    "RemoteException while setting up in-app billing".concat(String.valueOf(e2));
                    com.android.billingclient.a.a.b("BillingClient");
                    c cVar = c.this;
                    cVar.f30914a = 0;
                    cVar.f30917d = null;
                    this.f30939b.a(-1);
                    return;
                }
            }
            boolean z = true;
            c.this.f30919f = i2 >= 5;
            c.this.f30918e = i2 >= 3;
            if (i2 < 3) {
                com.android.billingclient.a.a.a("BillingClient");
            }
            int i4 = 8;
            while (true) {
                if (i4 < 3) {
                    i4 = 0;
                    break;
                }
                i3 = c.this.f30917d.a(i4, packageName, "inapp");
                if (i3 == 0) {
                    break;
                }
                i4--;
            }
            c.this.f30921h = i4 >= 8;
            c cVar2 = c.this;
            if (i4 < 6) {
                z = false;
            }
            cVar2.f30920g = z;
            if (i4 < 3) {
                com.android.billingclient.a.a.b("BillingClient");
            }
            if (i3 == 0) {
                c.this.f30914a = 2;
            } else {
                c.this.f30914a = 0;
                c.this.f30917d = null;
            }
            this.f30939b.a(i3);
        }
    }
}
