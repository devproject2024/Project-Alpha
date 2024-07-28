package net.one97.paytm.wifi.background.wifi.filters;

import android.app.Application;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    final String f21131a = "PaytmSSIDFilterImpl";

    /* renamed from: b  reason: collision with root package name */
    boolean f21132b;

    /* renamed from: c  reason: collision with root package name */
    final Application f21133c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Integer> f21134d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<Integer, String> f21135e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<Integer, String> f21136f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f21137g = new HashMap<>();

    public b(Application application) {
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f21133c = application;
    }

    /* access modifiers changed from: package-private */
    public final void a(AllSSIDJsonModel allSSIDJsonModel) {
        List<WifiProvider> wifiProviders = allSSIDJsonModel.getWifiProviders();
        if (wifiProviders == null) {
            k.a();
        }
        for (WifiProvider next : wifiProviders) {
            String name = next.getName();
            String str = "";
            if (name == null) {
                name = str;
            }
            String pid = next.getPID();
            if (pid == null) {
                pid = str;
            }
            String vendorIcon = next.getVendorIcon();
            if (vendorIcon != null) {
                str = vendorIcon;
            }
            int size = this.f21135e.size();
            Integer valueOf = Integer.valueOf(size);
            this.f21135e.put(valueOf, name + "::" + pid);
            if (next.getSsids() != null) {
                List<String> ssids = next.getSsids();
                if (ssids == null) {
                    k.a();
                }
                if (!ssids.isEmpty()) {
                    List<String> ssids2 = next.getSsids();
                    if (ssids2 == null) {
                        k.a();
                    }
                    Iterator<String> it2 = ssids2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            Map map = this.f21134d;
                            if (next2 != null) {
                                String lowerCase = next2.toLowerCase();
                                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                map.put(lowerCase, Integer.valueOf(size));
                                Map map2 = this.f21137g;
                                if (next2 != null) {
                                    String lowerCase2 = next2.toLowerCase();
                                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                    map2.put(lowerCase2, str);
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean d(String str) {
        k.c(str, "ssid");
        HashMap<String, Integer> hashMap = this.f21134d;
        String lowerCase = str.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        return hashMap.containsKey(lowerCase);
    }

    public final String a(String str) {
        k.c(str, "ssid");
        Integer num = this.f21134d.get(str);
        if (num == null) {
            return null;
        }
        return this.f21135e.get(num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r0 = kotlin.m.p.a(r3, "::");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "ssid"
            kotlin.g.b.k.c(r3, r0)
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r2.f21134d
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            java.lang.Object r3 = r0.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 != 0) goto L_0x001a
            r3 = 0
            return r3
        L_0x001a:
            java.util.HashMap<java.lang.Integer, java.lang.String> r0 = r2.f21135e
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x002e
            java.lang.String r0 = "::"
            java.lang.String r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r3 = r0
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.background.wifi.filters.b.b(java.lang.String):java.lang.String");
    }

    public final String c(String str) {
        k.c(str, "ssid");
        HashMap<String, String> hashMap = this.f21137g;
        String lowerCase = str.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        return hashMap.get(lowerCase);
    }
}
