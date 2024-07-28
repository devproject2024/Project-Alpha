package com.alipay.imobile.network.quake.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.a.c.bb;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.imobile.network.quake.c;
import com.alipay.imobile.network.quake.d.a.b;
import com.alipay.imobile.network.quake.e;
import com.alipay.imobile.network.quake.i.b;
import com.alipay.imobile.network.quake.m;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class a extends com.alipay.imobile.network.quake.e.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private b f14781a;

    public a(Context context) {
        this.f14781a = b.a(context);
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = AppConstants.UTF_8;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final Map<String, String> b() {
        m a2 = m.a();
        HashMap hashMap = new HashMap();
        String a3 = this.f14781a.a();
        if (!TextUtils.isEmpty(a3)) {
            hashMap.put("did", a3);
        }
        String str = this.f14781a.f14764e;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("clientId", str);
        }
        hashMap.put("uuid", UUID.randomUUID().toString());
        String str2 = a2.f14930d;
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("AppId", str2);
        }
        String str3 = a2.j;
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("version", str3);
        }
        String str4 = a2.k;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("workspaceId", str4);
        }
        String str5 = a2.l;
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("tenantId", str5);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bf, code lost:
        r12 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c0, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c2, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
        r13 = new com.alipay.imobile.network.quake.c.a((java.lang.Integer) 10, (java.lang.Throwable) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f9, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        r13 = new com.alipay.imobile.network.quake.c.a((java.lang.Integer) 10, (java.lang.Throwable) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0104, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0109, code lost:
        return com.alipay.imobile.network.quake.g.a(r12);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2 A[ExcHandler: Exception (r12v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f9 A[ExcHandler: UnsupportedEncodingException (r12v3 'e' java.io.UnsupportedEncodingException A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104 A[ExcHandler: a (r12v1 'e' com.alipay.mobile.b.b.a A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.alipay.imobile.network.quake.g<java.lang.Object> a(com.alipay.imobile.network.quake.e r12, com.alipay.imobile.network.quake.b r13) throws com.alipay.mobile.b.b.a {
        /*
            r11 = this;
            java.lang.String r0 = ""
            r1 = 10
            java.util.Map<java.lang.String, java.lang.String> r2 = r13.extData     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            java.lang.String r3 = "UTF-8"
            r4 = 0
            if (r2 == 0) goto L_0x0040
            java.lang.String r5 = "Content-Type"
            java.lang.Object r2 = r2.get(r5)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            if (r2 == 0) goto L_0x0040
            java.lang.String r5 = ";"
            java.lang.String[] r2 = r2.split(r5)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            int r5 = r2.length     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            r6 = 1
            r7 = 1
        L_0x001e:
            if (r7 >= r5) goto L_0x0040
            r8 = r2[r7]     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            java.lang.String r8 = r8.trim()     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            java.lang.String r9 = "="
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            int r9 = r8.length     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            r10 = 2
            if (r9 != r10) goto L_0x003d
            java.lang.String r9 = "charset"
            r10 = r8[r4]     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            boolean r9 = r9.equals(r10)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            if (r9 == 0) goto L_0x003d
            r3 = r8[r6]     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            goto L_0x0040
        L_0x003d:
            int r7 = r7 + 1
            goto L_0x001e
        L_0x0040:
            java.lang.String r2 = new java.lang.String     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            byte[] r5 = r13.data     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            r2.<init>(r5, r3)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            java.lang.String r0 = "the response to be deserialized is "
            r0.concat(r2)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            com.alibaba.a.e r0 = com.alibaba.a.a.parseObject(r2)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            java.lang.String r3 = "resultStatus"
            int r3 = r0.getIntValue(r3)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r5) goto L_0x008f
            java.lang.reflect.Type r12 = r12.c()     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            if (r12 == 0) goto L_0x008d
            java.lang.Class r3 = java.lang.Void.TYPE     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            if (r3 != r12) goto L_0x006b
            goto L_0x008d
        L_0x006b:
            java.lang.String r3 = "result"
            java.lang.String r0 = r0.getString(r3)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            if (r2 != r12) goto L_0x007e
            com.alipay.imobile.network.quake.b.a$a r12 = a((com.alipay.imobile.network.quake.b) r13)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            com.alipay.imobile.network.quake.g r12 = com.alipay.imobile.network.quake.g.a(r0, r12)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            return r12
        L_0x007e:
            com.alibaba.a.b.c[] r2 = new com.alibaba.a.b.c[r4]     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            java.lang.Object r12 = com.alibaba.a.a.parseObject((java.lang.String) r0, (java.lang.reflect.Type) r12, (com.alibaba.a.b.c[]) r2)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            com.alipay.imobile.network.quake.b.a$a r13 = a((com.alipay.imobile.network.quake.b) r13)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            com.alipay.imobile.network.quake.g r12 = com.alipay.imobile.network.quake.g.a(r12, r13)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00d1, Exception -> 0x00c2 }
            return r12
        L_0x008d:
            r12 = 0
            return r12
        L_0x008f:
            java.lang.String r12 = "Memo"
            java.lang.String r12 = r0.getString(r12)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            java.lang.String r13 = "Tips"
            java.lang.String r13 = r0.getString(r13)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            boolean r4 = android.text.TextUtils.isEmpty(r13)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            if (r4 != 0) goto L_0x00a2
            r12 = r13
        L_0x00a2:
            com.alipay.imobile.network.quake.c.c r13 = new com.alipay.imobile.network.quake.c.c     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            r13.<init>((java.lang.Integer) r4, (java.lang.String) r12)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            r12 = 1002(0x3ea, float:1.404E-42)
            if (r3 != r12) goto L_0x00be
            java.lang.String r12 = "Control"
            com.alibaba.a.e r12 = r0.getJSONObject(r12)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            if (r12 == 0) goto L_0x00be
            java.lang.String r12 = r12.toJSONString()     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
            r13.setControl(r12)     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
        L_0x00be:
            throw r13     // Catch:{ a -> 0x0104, UnsupportedEncodingException -> 0x00f9, d -> 0x00bf, Exception -> 0x00c2 }
        L_0x00bf:
            r12 = move-exception
            r0 = r2
            goto L_0x00d2
        L_0x00c2:
            r12 = move-exception
            com.alipay.imobile.network.quake.c.a r13 = new com.alipay.imobile.network.quake.c.a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r13.<init>((java.lang.Integer) r0, (java.lang.Throwable) r12)
        L_0x00cc:
            com.alipay.imobile.network.quake.g r12 = com.alipay.imobile.network.quake.g.a(r13)
            return r12
        L_0x00d1:
            r12 = move-exception
        L_0x00d2:
            com.alipay.imobile.network.quake.c.a r13 = new com.alipay.imobile.network.quake.c.a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "response  ="
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = ":"
            r2.append(r0)
            java.lang.String r0 = r12.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r13.<init>((java.lang.Integer) r1, (java.lang.String) r0)
            r13.initCause(r12)
            goto L_0x00cc
        L_0x00f9:
            r12 = move-exception
            com.alipay.imobile.network.quake.c.a r13 = new com.alipay.imobile.network.quake.c.a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r13.<init>((java.lang.Integer) r0, (java.lang.Throwable) r12)
            goto L_0x00cc
        L_0x0104:
            r12 = move-exception
            com.alipay.imobile.network.quake.g r12 = com.alipay.imobile.network.quake.g.a(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.e.a.a.a(com.alipay.imobile.network.quake.e, com.alipay.imobile.network.quake.b):com.alipay.imobile.network.quake.g");
    }

    public final byte[] a(e eVar) throws com.alipay.mobile.b.b.a {
        if (eVar == null) {
            return new byte[0];
        }
        b.a aVar = null;
        if (eVar instanceof com.alipay.imobile.network.quake.g.e) {
            aVar = eVar.v;
        }
        if (aVar == null) {
            m a2 = m.a();
            aVar = new b.a(a2.f14929c, a2.f14931e);
        }
        ArrayList arrayList = new ArrayList();
        String a3 = eVar.a();
        if (!TextUtils.isEmpty(a3)) {
            arrayList.add(new com.alipay.imobile.network.quake.a.a(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, a3));
        }
        if (eVar.f14776h != null) {
            arrayList.add(new com.alipay.imobile.network.quake.a.a("id", String.valueOf(eVar.f14776h.intValue())));
            arrayList.add(new com.alipay.imobile.network.quake.a.a(H5RpcPlugin.RpcRequest.RpcParam.REQUEST_DATA, c(eVar)));
            String str = eVar.t.get(StringSet.ts);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new com.alipay.imobile.network.quake.a.a(StringSet.ts, String.valueOf(str)));
            }
            String a4 = a(arrayList, eVar.d(), aVar);
            if (!TextUtils.isEmpty(a4)) {
                arrayList.add(new com.alipay.imobile.network.quake.a.a("sign", a4));
            }
            return a((List<? extends com.alipay.imobile.network.quake.a.a>) arrayList, AppConstants.UTF_8).getBytes();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public final String b(e eVar) {
        String str = eVar.u;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = eVar.f14769a + "#" + eVar.a();
        if (eVar.p != null) {
            str2 = str2 + "#" + c(eVar);
        }
        eVar.u = str2;
        return str2;
    }

    /* access modifiers changed from: protected */
    public String c(e eVar) {
        Object obj = eVar.p;
        if (obj == null) {
            return "[]";
        }
        String jSONString = com.alibaba.a.a.toJSONString(obj, bb.DisableCircularReferenceDetect);
        if (!jSONString.startsWith("[")) {
            jSONString = "[".concat(String.valueOf(jSONString));
        }
        if (jSONString.endsWith("]")) {
            return jSONString;
        }
        return jSONString + "]";
    }

    private String a(List<com.alipay.imobile.network.quake.a.a> list, String str, b.a aVar) {
        Collections.sort(list, new Comparator<com.alipay.imobile.network.quake.a.a>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return a((com.alipay.imobile.network.quake.a.a) obj, (com.alipay.imobile.network.quake.a.a) obj2);
            }

            private static int a(com.alipay.imobile.network.quake.a.a aVar, com.alipay.imobile.network.quake.a.a aVar2) {
                try {
                    return aVar.f14714a.compareTo(aVar2.f14714a);
                } catch (Exception unused) {
                    String str = c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                    return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (com.alipay.imobile.network.quake.a.a next : list) {
            sb.append(next.f14714a);
            sb.append("=");
            sb.append(next.f14715b);
            sb.append(AppConstants.AND_SIGN);
        }
        String str2 = c.f14737a;
        com.alipay.iap.android.common.b.c.b();
        return com.alipay.imobile.network.quake.i.b.a(m.a().f14928b, aVar, str, sb.deleteCharAt(sb.length() - 1).toString());
    }

    private static String a(List<? extends com.alipay.imobile.network.quake.a.a> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (com.alipay.imobile.network.quake.a.a aVar : list) {
            String a2 = a(aVar.f14714a, str);
            String str2 = aVar.f14715b;
            String a3 = str2 != null ? a(str2, str) : "";
            if (sb.length() > 0) {
                sb.append(AppConstants.AND_SIGN);
            }
            sb.append(a2);
            sb.append("=");
            sb.append(a3);
        }
        return sb.toString();
    }
}
