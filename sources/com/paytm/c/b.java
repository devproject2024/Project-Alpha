package com.paytm.c;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.c;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.paytm.c.b;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f42675a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f42676b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f42677c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f42678d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static List<WeakReference<a>> f42679e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private static a f42680f = null;

    /* renamed from: g  reason: collision with root package name */
    private static long f42681g;

    /* renamed from: h  reason: collision with root package name */
    private static long f42682h;

    /* renamed from: i  reason: collision with root package name */
    private static long f42683i = -1;

    public interface a extends C0711b {
        void a(boolean z);
    }

    /* renamed from: com.paytm.c.b$b  reason: collision with other inner class name */
    interface C0711b {
        void a();

        void a(Exception exc);
    }

    public static void a(a aVar) {
        f42680f = aVar;
    }

    public static void a(Context context, String str, a aVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("context,deviceRootedListener and apiKey should not be null or empty");
        } else if (f42676b) {
            aVar.a(f42675a);
        } else {
            if (!(c.a().a(context) == 0)) {
                aVar.a();
                return;
            }
            f42679e.add(new WeakReference(aVar));
            if (!f42677c) {
                f42681g = System.currentTimeMillis();
                f42677c = true;
                SafetyNetClient client = SafetyNet.getClient(context);
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                client.attest(bArr, str).a(new OnSuccessListener() {
                    public final void onSuccess(Object obj) {
                        b.a(b.a.this, (SafetyNetApi.AttestationResponse) obj);
                    }
                }).a((OnFailureListener) new OnFailureListener() {
                    public final void onFailure(Exception exc) {
                        b.a(b.a.this, exc);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ad A[Catch:{ JSONException -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d4 A[Catch:{ JSONException -> 0x00e8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.paytm.c.b.a r8, com.google.android.gms.safetynet.SafetyNetApi.AttestationResponse r9) {
        /*
            r0 = 0
            f42677c = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "addOnSuccessListener start : "
            r1.<init>(r2)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.paytm.utility.q.d(r1)
            java.lang.String r9 = r9.getJwsResult()
            r1 = 1
            if (r9 == 0) goto L_0x0035
            java.lang.String r2 = "\\."
            java.lang.String[] r9 = r9.split(r2)
            int r2 = r9.length
            r3 = 3
            if (r2 != r3) goto L_0x0035
            java.lang.String r2 = new java.lang.String
            r9 = r9[r1]
            byte[] r9 = android.util.Base64.decode(r9, r0)
            r2.<init>(r9)
            goto L_0x0036
        L_0x0035:
            r2 = 0
        L_0x0036:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e8 }
            r9.<init>(r2)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r2 = "ctsProfileMatch"
            boolean r2 = r9.getBoolean(r2)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r3 = "basicIntegrity"
            boolean r9 = r9.getBoolean(r3)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r3 = "ctsProfileMatch : "
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ JSONException -> 0x00e8 }
            com.paytm.utility.q.d(r3)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r3 = "basicIntegrity : "
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ JSONException -> 0x00e8 }
            com.paytm.utility.q.d(r3)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r3 = "addOnSuccessListener end : "
            if (r2 == 0) goto L_0x0085
            if (r9 != 0) goto L_0x0068
            goto L_0x0085
        L_0x0068:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00e8 }
            r9.<init>(r3)     // Catch:{ JSONException -> 0x00e8 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00e8 }
            r9.append(r2)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x00e8 }
            com.paytm.utility.q.d(r9)     // Catch:{ JSONException -> 0x00e8 }
            f42675a = r0     // Catch:{ JSONException -> 0x00e8 }
            f42678d = r0     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r9 = "rooted/tempered device : false"
            com.paytm.utility.q.d(r9)     // Catch:{ JSONException -> 0x00e8 }
            goto L_0x00a1
        L_0x0085:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00e8 }
            r9.<init>(r3)     // Catch:{ JSONException -> 0x00e8 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00e8 }
            r9.append(r2)     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x00e8 }
            com.paytm.utility.q.d(r9)     // Catch:{ JSONException -> 0x00e8 }
            f42675a = r1     // Catch:{ JSONException -> 0x00e8 }
            f42678d = r1     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r9 = "rooted/tempered device : true"
            com.paytm.utility.q.d(r9)     // Catch:{ JSONException -> 0x00e8 }
        L_0x00a1:
            java.util.List<java.lang.ref.WeakReference<com.paytm.c.b$a>> r9 = f42679e     // Catch:{ JSONException -> 0x00e8 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ JSONException -> 0x00e8 }
        L_0x00a7:
            boolean r0 = r9.hasNext()     // Catch:{ JSONException -> 0x00e8 }
            if (r0 == 0) goto L_0x00c5
            java.lang.Object r0 = r9.next()     // Catch:{ JSONException -> 0x00e8 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ JSONException -> 0x00e8 }
            java.lang.Object r2 = r0.get()     // Catch:{ JSONException -> 0x00e8 }
            if (r2 == 0) goto L_0x00a7
            java.lang.Object r0 = r0.get()     // Catch:{ JSONException -> 0x00e8 }
            com.paytm.c.b$a r0 = (com.paytm.c.b.a) r0     // Catch:{ JSONException -> 0x00e8 }
            boolean r2 = f42675a     // Catch:{ JSONException -> 0x00e8 }
            r0.a(r2)     // Catch:{ JSONException -> 0x00e8 }
            goto L_0x00a7
        L_0x00c5:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00e8 }
            f42682h = r2     // Catch:{ JSONException -> 0x00e8 }
            long r4 = f42681g     // Catch:{ JSONException -> 0x00e8 }
            long r2 = r2 - r4
            f42683i = r2     // Catch:{ JSONException -> 0x00e8 }
            com.paytm.c.a r9 = f42680f     // Catch:{ JSONException -> 0x00e8 }
            if (r9 == 0) goto L_0x00e0
            com.paytm.c.a r2 = f42680f     // Catch:{ JSONException -> 0x00e8 }
            long r3 = f42683i     // Catch:{ JSONException -> 0x00e8 }
            r5 = 1
            boolean r6 = f42675a     // Catch:{ JSONException -> 0x00e8 }
            java.lang.String r7 = ""
            r2.a(r3, r5, r6, r7)     // Catch:{ JSONException -> 0x00e8 }
        L_0x00e0:
            java.util.List<java.lang.ref.WeakReference<com.paytm.c.b$a>> r9 = f42679e     // Catch:{ JSONException -> 0x00e8 }
            r9.clear()     // Catch:{ JSONException -> 0x00e8 }
            f42676b = r1     // Catch:{ JSONException -> 0x00e8 }
            return
        L_0x00e8:
            r9 = move-exception
            r8.a(r9)
            long r0 = java.lang.System.currentTimeMillis()
            f42682h = r0
            long r2 = f42681g
            long r0 = r0 - r2
            f42683i = r0
            com.paytm.c.a r2 = f42680f
            if (r2 == 0) goto L_0x0107
            long r3 = f42683i
            r5 = 1
            boolean r6 = f42675a
            java.lang.String r7 = r9.getMessage()
            r2.a(r3, r5, r6, r7)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.c.b.a(com.paytm.c.b$a, com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, Exception exc) {
        f42677c = false;
        f42679e.clear();
        long currentTimeMillis = System.currentTimeMillis();
        f42682h = currentTimeMillis;
        f42683i = currentTimeMillis - f42681g;
        a aVar2 = f42680f;
        if (aVar2 != null) {
            aVar2.a(f42683i, false, false, "");
        }
        aVar.a(exc);
    }

    public static int a() {
        return f42678d;
    }
}
