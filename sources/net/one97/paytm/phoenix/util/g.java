package net.one97.paytm.phoenix.util;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.c;
import com.alipay.mobile.h5container.api.H5Param;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f59641a = new g();

    private g() {
    }

    public static void a(JSONObject jSONObject, Bundle bundle) {
        k.c(jSONObject, "data");
        k.c(bundle, "bundle");
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Bundle bundle, JSONObject jSONObject) {
        k.c(bundle, "bundle");
        k.c(jSONObject, "json");
        try {
            Set<String> keySet = bundle.keySet();
            if (keySet != null && (r0 = keySet.iterator()) != null) {
                for (String str : keySet) {
                    jSONObject.put(str, bundle.get(str));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "message");
        c a2 = new c.a(context).b((CharSequence) str).a(17039370, (DialogInterface.OnClickListener) a.f59642a).a();
        k.a((Object) a2, "AlertDialog.Builder(cont…  }\n            .create()");
        if (TextUtils.isEmpty((CharSequence) null)) {
            a2.requestWindowFeature(1);
        } else {
            a2.setTitle((CharSequence) null);
        }
        a2.show();
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f59642a = new a();

        a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public static Map<String, Object> a() {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(H5Param.LONG_DEFAULT_TITLE, "");
        linkedHashMap.put(H5Param.LONG_SHOW_TITLEBAR, Boolean.TRUE);
        linkedHashMap.put("showLoading", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        linkedHashMap.put(H5Param.LONG_BACK_BEHAVIOR, H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
        linkedHashMap.put(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        linkedHashMap.put(H5Param.LONG_LANDSCAPE, "");
        linkedHashMap.put(H5Param.LONG_TITLE_COLOR, -16777216);
        linkedHashMap.put(H5Param.LONG_TITLE_BAR_COLOR, 0);
        linkedHashMap.put("pullRefresh", Boolean.FALSE);
        linkedHashMap.put("canPullDown", Boolean.TRUE);
        linkedHashMap.put("paytmShowTitleBar", Boolean.TRUE);
        linkedHashMap.put("paytmChangeStatusBarColor", "#808080");
        linkedHashMap.put("paytmChangeBackButtonColor", "#007bff");
        linkedHashMap.put("showLoadingView", Boolean.FALSE);
        linkedHashMap.put(H5Param.LONG_BACKBTN_TEXTCOLOR, "#007bff");
        linkedHashMap.put("overrideDefaultLoadingCancelBehaviour", Boolean.FALSE);
        linkedHashMap.put("showCrossButton", Boolean.TRUE);
        linkedHashMap.put("renderWithinSafeArea", Boolean.FALSE);
        linkedHashMap.put("statusBarStyle", 0);
        linkedHashMap.put("showMenuButton", Boolean.TRUE);
        linkedHashMap.put("showStatusBar", Boolean.TRUE);
        linkedHashMap.put("overrideCrossToBack", Boolean.FALSE);
        linkedHashMap.put("showTitleLoading", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        return linkedHashMap;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            }
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            String message = e2.getMessage();
            if (message == null) {
                return false;
            }
            j jVar = j.f59646a;
            j.c("PhoenixCommonUtils", message);
            return false;
        }
    }

    public static boolean b(String str) {
        k.c(str, "value");
        if (p.a(str, H5Param.DEFAULT_LONG_PRESSO_LOGIN, true) || p.a(str, "true", true)) {
            return true;
        }
        if (p.a(str, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO, true) || p.a(str, "false", true)) {
            return false;
        }
        return true;
    }

    public static Map<String, Object> a(String str, String str2) {
        k.c(str, "appName");
        k.c(str2, H5Param.AID);
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("event_category", str);
        linkedHashMap.put("event_action", "Mini App Title Analytics");
        linkedHashMap.put("event_label2", "1.0.0-9.1.0-CA-83248-RC2");
        linkedHashMap.put("event_label3", str2);
        return linkedHashMap;
    }

    public static String a(String str) throws URISyntaxException {
        k.c(str, "url");
        if (p.b(str, "www.", false)) {
            str = "http://".concat(String.valueOf(str));
        }
        j jVar = j.f59646a;
        j.b("PhoenixCommonUtils:URL:", str);
        String host = new URI(str).getHost();
        j jVar2 = j.f59646a;
        j.b("PhoenixCommonUtils:Domain:".concat(String.valueOf(host)), "");
        if (host == null) {
            return null;
        }
        if (!p.b(host, "www.", false)) {
            return host;
        }
        if (host != null) {
            String substring = host.substring(4);
            k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.o<java.lang.String, java.lang.String> a(net.one97.paytm.phoenix.ui.PhoenixActivity r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r5, r0)
            android.os.Bundle r0 = r5.J
            org.json.JSONObject r5 = r5.a((android.os.Bundle) r0)
            java.lang.String r0 = r5.optString(r6)
            java.lang.String r5 = r5.optString(r7)
            net.one97.paytm.phoenix.PhoenixManager r1 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            android.os.Bundle r1 = r1.getSParamsBundle()
            if (r1 == 0) goto L_0x00af
            boolean r2 = r1.containsKey(r6)
            java.lang.String r3 = "#"
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x005b
            boolean r2 = r1.containsKey(r7)
            if (r2 == 0) goto L_0x005b
            java.lang.Object r5 = r1.get(r6)
            boolean r6 = r5 instanceof java.lang.Integer
            if (r6 == 0) goto L_0x004a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            goto L_0x0051
        L_0x004a:
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x0051
            r4 = r5
            java.lang.String r4 = (java.lang.String) r4
        L_0x0051:
            java.lang.String r5 = r1.getString(r7)
            kotlin.o r6 = new kotlin.o
            r6.<init>(r4, r5)
            return r6
        L_0x005b:
            boolean r2 = r1.containsKey(r6)
            if (r2 == 0) goto L_0x0093
            boolean r2 = r1.containsKey(r7)
            if (r2 != 0) goto L_0x0093
            java.lang.Object r5 = r1.get(r6)
            boolean r6 = r5 instanceof java.lang.Integer
            if (r6 == 0) goto L_0x0086
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            goto L_0x008d
        L_0x0086:
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x008d
            r4 = r5
            java.lang.String r4 = (java.lang.String) r4
        L_0x008d:
            kotlin.o r5 = new kotlin.o
            r5.<init>(r4, r4)
            return r5
        L_0x0093:
            boolean r6 = r1.containsKey(r6)
            if (r6 != 0) goto L_0x00a9
            boolean r6 = r1.containsKey(r7)
            if (r6 == 0) goto L_0x00a9
            java.lang.String r5 = r1.getString(r7)
            kotlin.o r6 = new kotlin.o
            r6.<init>(r0, r5)
            return r6
        L_0x00a9:
            kotlin.o r6 = new kotlin.o
            r6.<init>(r0, r5)
            return r6
        L_0x00af:
            kotlin.o r6 = new kotlin.o
            r6.<init>(r0, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.util.g.a(net.one97.paytm.phoenix.ui.PhoenixActivity, java.lang.String, java.lang.String):kotlin.o");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.o<java.lang.String, java.lang.Integer> b(net.one97.paytm.phoenix.ui.PhoenixActivity r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r5, r0)
            android.os.Bundle r0 = r5.J
            org.json.JSONObject r5 = r5.a((android.os.Bundle) r0)
            java.lang.String r0 = r5.optString(r6)
            int r5 = r5.optInt(r7)
            net.one97.paytm.phoenix.PhoenixManager r1 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            android.os.Bundle r1 = r1.getSParamsBundle()
            if (r1 == 0) goto L_0x00d0
            boolean r2 = r1.containsKey(r6)
            java.lang.String r3 = "#"
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x005f
            boolean r2 = r1.containsKey(r7)
            if (r2 == 0) goto L_0x005f
            java.lang.Object r5 = r1.get(r6)
            boolean r6 = r5 instanceof java.lang.Integer
            if (r6 == 0) goto L_0x004a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            goto L_0x0051
        L_0x004a:
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x0051
            r4 = r5
            java.lang.String r4 = (java.lang.String) r4
        L_0x0051:
            int r5 = r1.getInt(r7)
            kotlin.o r6 = new kotlin.o
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r4, r5)
            return r6
        L_0x005f:
            boolean r2 = r1.containsKey(r6)
            if (r2 == 0) goto L_0x009b
            boolean r2 = r1.containsKey(r7)
            if (r2 != 0) goto L_0x009b
            java.lang.Object r6 = r1.get(r6)
            boolean r7 = r6 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x008a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r3)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            java.lang.String r6 = java.lang.Integer.toHexString(r6)
            r7.append(r6)
            java.lang.String r4 = r7.toString()
            goto L_0x0091
        L_0x008a:
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x0091
            r4 = r6
            java.lang.String r4 = (java.lang.String) r4
        L_0x0091:
            kotlin.o r6 = new kotlin.o
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r4, r5)
            return r6
        L_0x009b:
            boolean r6 = r1.containsKey(r6)
            if (r6 != 0) goto L_0x00c6
            boolean r6 = r1.containsKey(r7)
            if (r6 == 0) goto L_0x00c6
            int r5 = r1.getInt(r7)
            r6 = 1
            if (r5 != r6) goto L_0x00ba
            kotlin.o r6 = new kotlin.o
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "#000000"
            r6.<init>(r7, r5)
            return r6
        L_0x00ba:
            kotlin.o r6 = new kotlin.o
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "#FFFFFE"
            r6.<init>(r7, r5)
            return r6
        L_0x00c6:
            kotlin.o r6 = new kotlin.o
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r0, r5)
            return r6
        L_0x00d0:
            kotlin.o r6 = new kotlin.o
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r0, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.util.g.b(net.one97.paytm.phoenix.ui.PhoenixActivity, java.lang.String, java.lang.String):kotlin.o");
    }
}
