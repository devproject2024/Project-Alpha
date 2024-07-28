package net.one97.paytm.phoenix.d;

import android.os.Bundle;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ao extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f59520a = new a((byte) 0);

    public ao() {
        super("paytmNavigateTo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r11, net.one97.paytm.phoenix.api.b r12) {
        /*
            r10 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r12, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.b) r12)
            boolean r12 = r10.a((net.one97.paytm.phoenix.api.H5Event) r11)
            r0 = 1
            if (r12 == 0) goto L_0x0120
            net.one97.paytm.phoenix.core.c r12 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r12 = r12.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixNavigationClassProvider> r1 = net.one97.paytm.phoenix.provider.PhoenixNavigationClassProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "PhoenixNavigationClassProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r12 = r12.a(r1)
            r1 = r12
            net.one97.paytm.phoenix.provider.PhoenixNavigationClassProvider r1 = (net.one97.paytm.phoenix.provider.PhoenixNavigationClassProvider) r1
            if (r1 != 0) goto L_0x0035
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r2 = "No implementation for 'NavigationProvider'"
            r10.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r2)
        L_0x0035:
            android.app.Activity r12 = r11.getActivity()
            r2 = 0
            if (r12 == 0) goto L_0x005a
            android.app.Activity r12 = r11.getActivity()
            if (r12 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            boolean r12 = r12 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r12 == 0) goto L_0x005a
            android.app.Activity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x0052
            net.one97.paytm.phoenix.ui.PhoenixActivity r12 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r12
            goto L_0x005b
        L_0x0052:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r11.<init>(r12)
            throw r11
        L_0x005a:
            r12 = r2
        L_0x005b:
            r3 = 0
            if (r12 != 0) goto L_0x005f
            return r3
        L_0x005f:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            org.json.JSONObject r5 = r11.getParams()
            if (r5 == 0) goto L_0x0071
            java.lang.String r6 = "navigateTo"
            java.lang.String r6 = r5.optString(r6)
            goto L_0x0072
        L_0x0071:
            r6 = r2
        L_0x0072:
            if (r5 == 0) goto L_0x007b
            java.lang.String r7 = "clearBackStack"
            java.lang.Object r7 = r5.opt(r7)
            goto L_0x007c
        L_0x007b:
            r7 = r2
        L_0x007c:
            boolean r8 = r7 instanceof java.lang.Boolean
            if (r8 != 0) goto L_0x0081
            r7 = r2
        L_0x0081:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L_0x008a
            boolean r7 = r7.booleanValue()
            goto L_0x008b
        L_0x008a:
            r7 = 0
        L_0x008b:
            if (r5 == 0) goto L_0x0094
            java.lang.String r8 = "finishThis"
            java.lang.Object r8 = r5.opt(r8)
            goto L_0x0095
        L_0x0094:
            r8 = r2
        L_0x0095:
            boolean r9 = r8 instanceof java.lang.Boolean
            if (r9 != 0) goto L_0x009a
            r8 = r2
        L_0x009a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L_0x00a4
            boolean r3 = r8.booleanValue()
            r8 = r3
            goto L_0x00a5
        L_0x00a4:
            r8 = 0
        L_0x00a5:
            if (r5 == 0) goto L_0x00ae
            java.lang.String r3 = "expectingResultBack"
            java.lang.Object r3 = r5.opt(r3)
            goto L_0x00af
        L_0x00ae:
            r3 = r2
        L_0x00af:
            boolean r9 = r3 instanceof java.lang.Boolean
            if (r9 != 0) goto L_0x00b4
            r3 = r2
        L_0x00b4:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x00bd
            boolean r3 = r3.booleanValue()
            goto L_0x00be
        L_0x00bd:
            r3 = 1
        L_0x00be:
            if (r5 == 0) goto L_0x00c7
            java.lang.String r9 = "data"
            org.json.JSONObject r5 = r5.optJSONObject(r9)
            goto L_0x00c8
        L_0x00c7:
            r5 = r2
        L_0x00c8:
            net.one97.paytm.phoenix.d.ao.a.a(r4, r5)
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00dc
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r1 = "invalid params"
            r10.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r1)
            goto L_0x0120
        L_0x00dc:
            if (r1 == 0) goto L_0x00f5
            net.one97.paytm.phoenix.ui.PhoenixActivity$j r5 = r12.u
            java.util.Observable r5 = (java.util.Observable) r5
            r5.deleteObservers()
            if (r3 == 0) goto L_0x00f5
            net.one97.paytm.phoenix.ui.PhoenixActivity$j r5 = r12.u
            java.util.Observable r5 = (java.util.Observable) r5
            net.one97.paytm.phoenix.d.ao$b r9 = new net.one97.paytm.phoenix.d.ao$b
            r9.<init>(r10, r12, r3, r11)
            java.util.Observer r9 = (java.util.Observer) r9
            r5.addObserver(r9)
        L_0x00f5:
            if (r1 == 0) goto L_0x0105
            r2 = r12
            android.app.Activity r2 = (android.app.Activity) r2
            r3 = r6
            r5 = r7
            r6 = r8
            boolean r12 = r1.navigateTo(r2, r3, r4, r5, r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
        L_0x0105:
            if (r2 != 0) goto L_0x010a
            kotlin.g.b.k.a()
        L_0x010a:
            boolean r12 = r2.booleanValue()
            if (r12 != 0) goto L_0x0120
            net.one97.paytm.phoenix.util.j r12 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r12 = "PaytmH5"
            java.lang.String r1 = "navigation class cannot be null"
            net.one97.paytm.phoenix.util.j.c(r12, r1)
            net.one97.paytm.phoenix.api.a r12 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            java.lang.String r1 = "cannot navigate"
            r10.a((net.one97.paytm.phoenix.api.H5Event) r11, (net.one97.paytm.phoenix.api.a) r12, (java.lang.String) r1)
        L_0x0120:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ao.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ao f59521a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59522b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f59523c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f59524d;

        b(ao aoVar, PhoenixActivity phoenixActivity, boolean z, H5Event h5Event) {
            this.f59521a = aoVar;
            this.f59522b = phoenixActivity;
            this.f59523c = z;
            this.f59524d = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            net.one97.paytm.phoenix.core.a.a(this.f59521a, this.f59524d, obj, false, 4);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Bundle bundle, JSONObject jSONObject) {
            k.c(bundle, "bundle");
            if (jSONObject != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    k.a((Object) keys, "it.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        if (opt instanceof Boolean) {
                            bundle.putBoolean(next, ((Boolean) opt).booleanValue());
                        } else if (opt instanceof Byte) {
                            bundle.putByte(next, ((Number) opt).byteValue());
                        } else if (opt instanceof Character) {
                            bundle.putChar(next, ((Character) opt).charValue());
                        } else if (opt instanceof Short) {
                            bundle.putShort(next, ((Number) opt).shortValue());
                        } else if (opt instanceof Integer) {
                            bundle.putInt(next, ((Number) opt).intValue());
                        } else if (opt instanceof Long) {
                            bundle.putLong(next, ((Number) opt).longValue());
                        } else if (opt instanceof Float) {
                            bundle.putFloat(next, ((Number) opt).floatValue());
                        } else if (opt instanceof Double) {
                            bundle.putDouble(next, ((Number) opt).doubleValue());
                        } else if (opt instanceof BigDecimal) {
                            bundle.putDouble(next, ((BigDecimal) opt).doubleValue());
                        } else if (opt instanceof String) {
                            bundle.putString(next, (String) opt);
                        } else if (opt instanceof CharSequence) {
                            bundle.putCharSequence(next, (CharSequence) opt);
                        } else if (opt instanceof JSONArray) {
                            bundle.putString(next, opt.toString());
                        } else if (opt instanceof JSONObject) {
                            bundle.putString(next, opt.toString());
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j jVar = j.f59646a;
                    j.b("PhoenixNavigationPlugin", "Exception in addJsonDataInBundle: " + e2.getMessage());
                }
            }
        }
    }
}
