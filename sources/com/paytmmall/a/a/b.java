package com.paytmmall.a.a;

import android.app.Activity;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.w;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f15365a = "PROGRESS_DIALOG";

    public b() {
        super("mpCartAction", "OPEN_PAYMENT", "OPEN_PROMO_SELECT", "MANUAL_PROMO_APPLY", "IS_NATIVE_INTENT_PRESENT", "FLUSH_NATIVE_INTENT");
    }

    public final boolean a(final H5Event h5Event, final net.one97.paytm.phoenix.api.b bVar) {
        if (!(h5Event == null || h5Event.getParams() == null || h5Event.getParams().optString("action") == null || bVar == null)) {
            String valueOf = String.valueOf(h5Event.getParams().optString("action"));
            Activity activity = h5Event.getActivity();
            AnonymousClass1 r2 = new w() {
                public final void a(Object obj) {
                    b.a(h5Event, obj, bVar, false);
                }

                public final void b(Object obj) {
                    b.a(h5Event, obj, bVar, true);
                }
            };
            JSONObject optJSONObject = h5Event.getParams().optJSONObject("data");
            HashMap hashMap = new HashMap();
            if (optJSONObject != null && optJSONObject.length() > 0) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, optJSONObject.optString(next));
                }
            }
            char c2 = 65535;
            switch (valueOf.hashCode()) {
                case -1363107415:
                    if (valueOf.equals("FLUSH_NATIVE_INTENT")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1183268405:
                    if (valueOf.equals("IS_NATIVE_INTENT_PRESENT")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -299249403:
                    if (valueOf.equals("MANUAL_PROMO_APPLY")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1138396705:
                    if (valueOf.equals("OPEN_PROMO_SELECT")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1952880881:
                    if (valueOf.equals("OPEN_PAYMENT")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                com.paytmmall.artifact.cart.b.b.a(activity, hashMap, r2);
            } else if (c2 == 1) {
                t.e().openPromoListActivity(activity, hashMap, r2);
            } else if (c2 == 2) {
                t.e().applyManualPromo(activity, hashMap, r2);
            } else if (c2 == 3) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("payment_intent_present", Boolean.valueOf(t.e().isNativeIntentPresent()));
                r2.a(hashMap2);
            } else if (c2 == 4) {
                t.e().resetNativeIntent();
            }
        }
        return super.a(h5Event, bVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r4.b(r2, new org.json.JSONObject(r3.toString()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        r4.b(r2, new org.json.JSONObject());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(net.one97.paytm.phoenix.api.H5Event r2, java.lang.Object r3, net.one97.paytm.phoenix.api.b r4) {
        /*
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0012 }
            r0.<init>()     // Catch:{ Exception -> 0x0012 }
            java.lang.String r0 = r0.a((java.lang.Object) r3)     // Catch:{ Exception -> 0x0012 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0012 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0012 }
            r4.b(r2, r1)     // Catch:{ Exception -> 0x0012 }
            return
        L_0x0012:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x001f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x001f }
            r0.<init>(r3)     // Catch:{ Exception -> 0x001f }
            r4.b(r2, r0)     // Catch:{ Exception -> 0x001f }
            return
        L_0x001f:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4.b(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.a.a.b.a(net.one97.paytm.phoenix.api.H5Event, java.lang.Object, net.one97.paytm.phoenix.api.b):void");
    }

    static /* synthetic */ void a(H5Event h5Event, Object obj, net.one97.paytm.phoenix.api.b bVar, boolean z) {
        if (!z) {
            a(h5Event, obj, bVar);
        } else if (obj instanceof HashMap) {
            HashMap hashMap = (HashMap) obj;
            Activity activity = h5Event.getActivity();
            if (hashMap.containsKey("PROGRESS_DIALOG") && activity != null && !activity.isFinishing()) {
                if (Boolean.parseBoolean(String.valueOf(hashMap.get("PROGRESS_DIALOG")))) {
                    d.a(activity, activity.getString(R.string.please_wait_progress_msg));
                } else {
                    d.h();
                }
            }
            a(h5Event, obj, bVar);
        }
    }
}
