package net.one97.paytm.h5paytmsdk.b;

import android.os.Bundle;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Event;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.u;

public final class v extends ad {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17055a = new a((byte) 0);

    public v() {
        super("paytmNavigateTo");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: net.one97.paytm.h5paytmsdk.c.z} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: net.one97.paytm.h5paytmsdk.c.z} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: net.one97.paytm.h5paytmsdk.c.z} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r18, com.alipay.mobile.h5container.api.H5BridgeContext r19) {
        /*
            r17 = this;
            r8 = r17
            super.handleEvent(r18, r19)
            boolean r0 = r17.b(r18)
            if (r0 == 0) goto L_0x00f3
            if (r18 != 0) goto L_0x0010
            kotlin.g.b.k.a()
        L_0x0010:
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            com.alibaba.a.e r0 = r18.getParam()
            java.lang.String r11 = "navigateTo"
            java.lang.String r12 = r0.getString(r11)
            java.lang.String r1 = "clearBackStack"
            java.lang.Boolean r1 = r0.getBoolean(r1)
            r2 = 0
            if (r1 == 0) goto L_0x002e
            boolean r1 = r1.booleanValue()
            r13 = r1
            goto L_0x002f
        L_0x002e:
            r13 = 0
        L_0x002f:
            java.lang.String r1 = "finishThis"
            java.lang.Boolean r1 = r0.getBoolean(r1)
            if (r1 == 0) goto L_0x003d
            boolean r1 = r1.booleanValue()
            r14 = r1
            goto L_0x003e
        L_0x003d:
            r14 = 0
        L_0x003e:
            java.lang.String r1 = "expectingResultBack"
            java.lang.Boolean r1 = r0.getBoolean(r1)
            if (r1 == 0) goto L_0x004c
            boolean r1 = r1.booleanValue()
            r3 = r1
            goto L_0x004d
        L_0x004c:
            r3 = 1
        L_0x004d:
            java.lang.String r1 = "data"
            com.alibaba.a.e r0 = r0.getJSONObject(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.h5paytmsdk.b.v.a.a(r10, r0)
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x006b
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            java.lang.String r1 = "invalid params"
            r8.a((com.alipay.mobile.h5container.api.H5Event.Error) r0, (java.lang.String) r1)
            goto L_0x00f3
        L_0x006b:
            com.alipay.mobile.nebula.provider.H5ProviderManager r0 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            if (r0 == 0) goto L_0x007c
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.z> r1 = net.one97.paytm.h5paytmsdk.c.z.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r0 = r0.getProvider(r1)
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            r15 = r0
            net.one97.paytm.h5paytmsdk.c.z r15 = (net.one97.paytm.h5paytmsdk.c.z) r15
            if (r15 != 0) goto L_0x0089
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'PaytmH5NavigationClassProvider'"
            r8.a((com.alipay.mobile.h5container.api.H5Event.Error) r0, (java.lang.String) r1)
        L_0x0089:
            if (r15 == 0) goto L_0x00f3
            android.app.Activity r0 = r18.getActivity()
            boolean r0 = r0 instanceof net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity
            if (r0 == 0) goto L_0x00d7
            android.app.Activity r0 = r18.getActivity()
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity"
            if (r0 == 0) goto L_0x00d1
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r0 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r0
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$j r0 = r0.f17108f
            java.util.Observable r0 = (java.util.Observable) r0
            r0.deleteObservers()
            if (r3 == 0) goto L_0x00d7
            android.app.Activity r0 = r18.getActivity()
            if (r0 == 0) goto L_0x00cb
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r0 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r0
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$j r0 = r0.f17108f
            r7 = r0
            java.util.Observable r7 = (java.util.Observable) r7
            net.one97.paytm.h5paytmsdk.b.v$b r16 = new net.one97.paytm.h5paytmsdk.b.v$b
            r0 = r16
            r1 = r17
            r2 = r18
            r4 = r12
            r5 = r10
            r6 = r13
            r9 = r7
            r7 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            java.util.Observer r0 = (java.util.Observer) r0
            r9.addObserver(r0)
            goto L_0x00d7
        L_0x00cb:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x00d1:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x00d7:
            android.app.Activity r1 = r18.getActivity()
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)
            r0 = r15
            r2 = r12
            r3 = r10
            r4 = r13
            r5 = r14
            boolean r0 = r0.a(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x00f3
            com.alipay.iap.android.common.b.c.i()
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.NOT_FOUND
            java.lang.String r1 = "cannot navigate"
            r8.a((com.alipay.mobile.h5container.api.H5Event.Error) r0, (java.lang.String) r1)
        L_0x00f3:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.v.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f17056a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f17057b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17058c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17059d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Bundle f17060e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f17061f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f17062g;

        b(v vVar, H5Event h5Event, boolean z, String str, Bundle bundle, boolean z2, boolean z3) {
            this.f17056a = vVar;
            this.f17057b = h5Event;
            this.f17058c = z;
            this.f17059d = str;
            this.f17060e = bundle;
            this.f17061f = z2;
            this.f17062g = z3;
        }

        public final void update(Observable observable, Object obj) {
            this.f17056a.a(obj);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Bundle bundle, e eVar) {
            k.c(bundle, "bundle");
            k.c(eVar, "data");
            for (Map.Entry next : eVar.entrySet()) {
                if (next.getValue() instanceof Boolean) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != null) {
                        bundle.putBoolean(str, ((Boolean) value).booleanValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Boolean");
                    }
                } else if (next.getValue() instanceof Byte) {
                    String str2 = (String) next.getKey();
                    Object value2 = next.getValue();
                    if (value2 != null) {
                        bundle.putByte(str2, ((Byte) value2).byteValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Byte");
                    }
                } else if (next.getValue() instanceof Character) {
                    String str3 = (String) next.getKey();
                    Object value3 = next.getValue();
                    if (value3 != null) {
                        bundle.putChar(str3, ((Character) value3).charValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Char");
                    }
                } else if (next.getValue() instanceof Short) {
                    String str4 = (String) next.getKey();
                    Object value4 = next.getValue();
                    if (value4 != null) {
                        bundle.putShort(str4, ((Short) value4).shortValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Short");
                    }
                } else if (next.getValue() instanceof Integer) {
                    String str5 = (String) next.getKey();
                    Object value5 = next.getValue();
                    if (value5 != null) {
                        bundle.putInt(str5, ((Integer) value5).intValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Int");
                    }
                } else if (next.getValue() instanceof Long) {
                    String str6 = (String) next.getKey();
                    Object value6 = next.getValue();
                    if (value6 != null) {
                        bundle.putLong(str6, ((Long) value6).longValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Long");
                    }
                } else if (next.getValue() instanceof Float) {
                    String str7 = (String) next.getKey();
                    Object value7 = next.getValue();
                    if (value7 != null) {
                        bundle.putFloat(str7, ((Float) value7).floatValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Float");
                    }
                } else if (next.getValue() instanceof Double) {
                    String str8 = (String) next.getKey();
                    Object value8 = next.getValue();
                    if (value8 != null) {
                        bundle.putDouble(str8, ((Double) value8).doubleValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Double");
                    }
                } else if (next.getValue() instanceof BigDecimal) {
                    String str9 = (String) next.getKey();
                    Object value9 = next.getValue();
                    if (value9 != null) {
                        bundle.putDouble(str9, ((BigDecimal) value9).doubleValue());
                    } else {
                        throw new u("null cannot be cast to non-null type java.math.BigDecimal");
                    }
                } else if (next.getValue() instanceof String) {
                    String str10 = (String) next.getKey();
                    Object value10 = next.getValue();
                    if (value10 != null) {
                        bundle.putString(str10, (String) value10);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (next.getValue() instanceof CharSequence) {
                    String str11 = (String) next.getKey();
                    Object value11 = next.getValue();
                    if (value11 != null) {
                        bundle.putCharSequence(str11, (CharSequence) value11);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else if (next.getValue() instanceof com.alibaba.a.b) {
                    String str12 = (String) next.getKey();
                    Object value12 = next.getValue();
                    if (value12 != null) {
                        bundle.putSerializable(str12, (com.alibaba.a.b) value12);
                    } else {
                        throw new u("null cannot be cast to non-null type com.alibaba.fastjson.JSONArray");
                    }
                } else if (next.getValue() instanceof e) {
                    String str13 = (String) next.getKey();
                    Object value13 = next.getValue();
                    if (value13 != null) {
                        bundle.putSerializable(str13, (e) value13);
                    } else {
                        throw new u("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
