package com.travel.bus.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.paytm.utility.q;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f21498a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21499b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21500c;

    /* renamed from: d  reason: collision with root package name */
    protected IJRPaytmDataModel f21501d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f21502e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21503f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21504g;

    /* renamed from: h  reason: collision with root package name */
    private final C0429a f21505h;

    /* renamed from: i  reason: collision with root package name */
    private String f21506i;
    private String j;
    private HashMap<String, String> k;
    private HashMap<String, String> l;
    private HashMap<String, String> m;
    private String n;
    private d o;
    private c p;

    /* renamed from: com.travel.bus.a.a$a  reason: collision with other inner class name */
    public enum C0429a {
        GET,
        POST
    }

    public a(Context context, C0429a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel, d dVar) {
        this.f21502e = context;
        this.f21505h = aVar;
        this.j = str;
        this.f21506i = null;
        this.k = null;
        this.o = dVar;
        this.f21501d = iJRPaytmDataModel;
        this.p = new c();
        this.f21498a = false;
        b();
    }

    public a(Context context, C0429a aVar, String str, HashMap hashMap, HashMap hashMap2, IJRPaytmDataModel iJRPaytmDataModel, d dVar) {
        this.f21502e = context;
        this.f21505h = aVar;
        this.j = str;
        this.f21506i = null;
        this.m = hashMap;
        this.k = hashMap2;
        this.o = dVar;
        this.f21501d = iJRPaytmDataModel;
        this.p = new c();
        this.f21498a = true;
        b();
    }

    private void b() {
        d dVar = this.o;
        if (dVar == null) {
            throw new IllegalArgumentException("Invalid Params : No Listener registered for this api call");
        } else if (this.f21502e == null) {
            new c("Invalid Params", "Context can not be null");
            dVar.a();
        } else if (this.j == null) {
            new c("Invalid Params", "Url cannot be null");
            dVar.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r8 = this;
            java.lang.String r0 = r8.j
            java.lang.String r1 = r8.f21506i
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r8.k
            java.lang.String r0 = a(r0, r1, r2)
            com.travel.bus.a.a$a r1 = r8.f21505h
            com.travel.bus.a.a$a r2 = com.travel.bus.a.a.C0429a.GET
            r3 = 0
            r4 = 1
            r5 = 0
            if (r1 != r2) goto L_0x0052
            boolean r1 = r8.f21500c
            if (r1 != 0) goto L_0x0052
            androidx.a.e<java.lang.String, com.paytm.network.model.IJRPaytmDataModel> r1 = com.travel.bus.a.b.f21508a
            if (r1 == 0) goto L_0x0031
            if (r0 == 0) goto L_0x0031
            androidx.a.e<java.lang.String, com.paytm.network.model.IJRPaytmDataModel> r1 = com.travel.bus.a.b.f21508a
            if (r1 != 0) goto L_0x0023
            r0 = r5
            goto L_0x002b
        L_0x0023:
            androidx.a.e<java.lang.String, com.paytm.network.model.IJRPaytmDataModel> r1 = com.travel.bus.a.b.f21508a
            java.lang.Object r0 = r1.get(r0)
            com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0
        L_0x002b:
            if (r0 == 0) goto L_0x0031
            r8.f21501d = r0
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x0052
            com.travel.bus.a.l r0 = new com.travel.bus.a.l
            com.travel.bus.a.g r1 = new com.travel.bus.a.g
            com.travel.bus.a.d r2 = r8.o
            com.paytm.network.model.IJRPaytmDataModel r6 = r8.f21501d
            r1.<init>(r2, r6)
            r0.<init>(r1)
            android.os.Handler r1 = com.travel.bus.a.k.f21518a
            if (r1 == 0) goto L_0x004d
            android.os.Handler r1 = com.travel.bus.a.k.f21518a
            r6 = 500(0x1f4, double:2.47E-321)
            r1.postDelayed(r0, r6)
        L_0x004d:
            boolean r0 = r8.f21504g
            if (r0 != 0) goto L_0x0052
            return
        L_0x0052:
            java.lang.String r0 = r8.c()
            if (r0 == 0) goto L_0x0108
            boolean r1 = android.webkit.URLUtil.isValidUrl(r0)
            if (r1 != 0) goto L_0x0060
            goto L_0x0108
        L_0x0060:
            boolean r1 = r8.f21503f
            if (r1 == 0) goto L_0x006a
            java.lang.String r1 = "POST"
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r1)
        L_0x006a:
            java.lang.String r0 = com.paytm.utility.b.O((java.lang.String) r0)
            java.lang.String r0 = com.travel.bus.busticket.i.o.d((java.lang.String) r0)
            int[] r1 = com.travel.bus.a.a.AnonymousClass1.f21507a
            com.travel.bus.a.a$a r2 = r8.f21505h
            int r2 = r2.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "bus-order-summary-page"
            if (r1 == r4) goto L_0x00d1
            r3 = 2
            if (r1 == r3) goto L_0x0084
            goto L_0x00d0
        L_0x0084:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r8.m
            if (r1 != 0) goto L_0x008f
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r8.m = r1
        L_0x008f:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r8.m
            java.lang.String r3 = "Content-Type"
            java.lang.String r6 = "application/json"
            r1.put(r3, r6)
            com.paytm.network.b r1 = new com.paytm.network.b
            r1.<init>()
            android.content.Context r3 = r8.f21502e
            r1.f42877a = r3
            com.paytm.network.a$c r3 = com.paytm.network.a.c.BUS
            r1.f42878b = r3
            com.paytm.network.a$a r3 = com.paytm.network.a.C0715a.POST
            r1.f42879c = r3
            r1.f42880d = r0
            r1.f42881e = r5
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r8.m
            r1.f42882f = r0
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r8.l
            r1.f42883g = r0
            java.lang.String r0 = r8.n
            r1.f42884h = r0
            com.paytm.network.model.IJRPaytmDataModel r0 = r8.f21501d
            r1.f42885i = r0
            r1.j = r8
            r1.t = r5
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT
            r1.n = r0
            r1.o = r2
            com.paytm.network.a r0 = r1.l()
            r0.f42860d = r4
            r0.a()
        L_0x00d0:
            return
        L_0x00d1:
            com.paytm.network.b r1 = new com.paytm.network.b
            r1.<init>()
            android.content.Context r6 = r8.f21502e
            r1.f42877a = r6
            com.paytm.network.a$c r6 = com.paytm.network.a.c.BUS
            r1.f42878b = r6
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET
            r1.f42879c = r6
            r1.f42880d = r0
            r1.f42881e = r5
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r8.m
            r1.f42882f = r0
            r1.f42883g = r5
            r1.f42884h = r5
            com.paytm.network.model.IJRPaytmDataModel r0 = r8.f21501d
            r1.f42885i = r0
            r1.j = r8
            r1.t = r5
            r1.k = r3
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT
            r1.n = r0
            r1.o = r2
            com.paytm.network.a r0 = r1.l()
            r0.f42860d = r4
            r0.a()
            return
        L_0x0108:
            com.travel.bus.a.c r1 = new com.travel.bus.a.c
            r1.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Invalid Url :- "
            java.lang.String r0 = r2.concat(r0)
            r1.f21512d = r0
            java.lang.String r0 = "Url Invalid"
            r1.f21510b = r0
            com.travel.bus.a.h r0 = new com.travel.bus.a.h
            com.travel.bus.a.e r2 = new com.travel.bus.a.e
            com.travel.bus.a.d r3 = r8.o
            r2.<init>(r3, r1)
            r0.<init>(r2)
            android.os.Handler r1 = com.travel.bus.a.k.f21518a
            if (r1 == 0) goto L_0x0132
            android.os.Handler r1 = com.travel.bus.a.k.f21518a
            r1.post(r0)
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.a.a.a():void");
    }

    /* renamed from: com.travel.bus.a.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21507a = new int[C0429a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.travel.bus.a.a$a[] r0 = com.travel.bus.a.a.C0429a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21507a = r0
                int[] r0 = f21507a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.bus.a.a$a r1 = com.travel.bus.a.a.C0429a.GET     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f21507a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.bus.a.a$a r1 = com.travel.bus.a.a.C0429a.POST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    private String c() {
        try {
            Uri.Builder buildUpon = Uri.parse(this.j).buildUpon();
            Map<String, String> b2 = c.b(this.f21502e, true);
            if (this.f21506i != null) {
                buildUpon.appendEncodedPath(this.f21506i);
            }
            a(buildUpon, (Map<String, String>) this.k);
            if (this.f21498a) {
                a(buildUpon, b2);
            }
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    private void a(Uri.Builder builder, Map<String, String> map) {
        if (builder != null && map != null) {
            Set<String> keySet = map.keySet();
            Set<String> queryParameterNames = Uri.parse(this.j).getQueryParameterNames();
            for (String next : keySet) {
                if ((!this.f21499b || TextUtils.isEmpty(next) || !next.equalsIgnoreCase(AppConstants.SSO_TOKEN)) && (queryParameterNames == null || !queryParameterNames.contains(next))) {
                    builder.appendQueryParameter(next, URLEncoder.encode(map.get(next)));
                }
            }
        }
    }

    public final void a(String str, HashMap hashMap) {
        this.j = str;
        this.f21506i = null;
        this.k = hashMap;
    }

    private static String a(String str, String str2, HashMap<String, String> hashMap) {
        if (str == null) {
            return null;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            if (str2 != null) {
                buildUpon.appendEncodedPath(str2);
            }
            if (hashMap != null && hashMap.size() > 0) {
                for (String next : hashMap.keySet()) {
                    buildUpon.appendQueryParameter(next, hashMap.get(next));
                }
            }
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String a2;
        if (!(this.f21505h != C0429a.GET || (str = this.j) == null || iJRPaytmDataModel == null || (a2 = a(str, this.f21506i, this.k)) == null || iJRPaytmDataModel == null || b.f21508a == null)) {
            b.f21508a.put(a2, iJRPaytmDataModel);
        }
        this.f21501d = iJRPaytmDataModel;
        d dVar = this.o;
        if (dVar != null) {
            dVar.a(iJRPaytmDataModel);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c cVar;
        d dVar;
        if (networkCustomError != null) {
            cVar = new c();
            if (networkCustomError.getAlertMessage() != null) {
                cVar.f21511c = networkCustomError.getAlertMessage();
            }
            if (networkCustomError.getAlertTitle() != null) {
                cVar.f21510b = networkCustomError.getAlertTitle();
            }
            if (networkCustomError.networkResponse != null) {
                cVar.f21509a = networkCustomError.networkResponse.statusCode;
            }
            if (networkCustomError.getMessage() != null) {
                cVar.f21512d = networkCustomError.getMessage();
            }
            if (networkCustomError.getUrl() != null) {
                cVar.f21513e = networkCustomError.getFullUrl();
            }
        } else {
            cVar = null;
        }
        this.p = cVar;
        if (this.p != null && (dVar = this.o) != null) {
            dVar.a();
        }
    }
}
