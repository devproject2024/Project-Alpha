package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.plugin.H5ShareDataPlugin;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.a.f;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.c.ad;
import net.one97.paytm.h5paytmsdk.c.ae;
import net.one97.paytm.h5paytmsdk.d.e;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class ac extends ad {

    static final class d extends l implements kotlin.g.a.b<Byte, String> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).byteValue());
        }

        public final String invoke(byte b2) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            k.a((Object) format, "java.lang.String.format(this, *args)");
            return format;
        }
    }

    public ac() {
        super("paytmSaveData", "paytmGetData", "paytmRemoveData");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event) || h5Event == null || (action = h5Event.getAction()) == null) {
            return true;
        }
        int hashCode = action.hashCode();
        if (hashCode != -26278136) {
            if (hashCode != 128967615) {
                if (hashCode == 991581775 && action.equals("paytmRemoveData")) {
                    ThreadPoolExecutor executor = H5Utils.getExecutor(H5ThreadType.URGENT);
                    if (executor == null) {
                        return true;
                    }
                    executor.execute(new c(this, h5Event));
                    return true;
                }
            } else if (action.equals("paytmGetData")) {
                ThreadPoolExecutor executor2 = H5Utils.getExecutor(H5ThreadType.URGENT);
                if (executor2 == null) {
                    return true;
                }
                executor2.execute(new a(this, h5Event));
                return true;
            }
        } else if (action.equals("paytmSaveData")) {
            ThreadPoolExecutor executor3 = H5Utils.getExecutor(H5ThreadType.URGENT);
            if (executor3 == null) {
                return true;
            }
            executor3.execute(new b(this, h5Event));
            return true;
        }
        a(H5Event.Error.INVALID_PARAM, "invalid params");
        return true;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f16970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16971b;

        a(ac acVar, H5Event h5Event) {
            this.f16970a = acVar;
            this.f16971b = h5Event;
        }

        public final void run() {
            ac.a(this.f16970a, this.f16971b);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f16972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16973b;

        b(ac acVar, H5Event h5Event) {
            this.f16972a = acVar;
            this.f16973b = h5Event;
        }

        public final void run() {
            ac.b(this.f16972a, this.f16973b);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f16974a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16975b;

        c(ac acVar, H5Event h5Event) {
            this.f16974a = acVar;
            this.f16975b = h5Event;
        }

        public final void run() {
            ac.c(this.f16974a, this.f16975b);
        }
    }

    private final void a(String str, e eVar) {
        boolean z;
        if (!TextUtils.isEmpty(str) && eVar != null && !eVar.isEmpty()) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (((ad) (providerManager != null ? providerManager.getProvider(ad.class.getName()) : null)) != null) {
                Iterator<Map.Entry<String, Object>> it2 = eVar.entrySet().iterator();
                loop0:
                while (true) {
                    z = false;
                    while (true) {
                        if (!it2.hasNext()) {
                            break loop0;
                        }
                        Map.Entry next = it2.next();
                        String str2 = (String) next.getKey();
                        Object value = next.getValue();
                        if (!TextUtils.isEmpty(str2)) {
                            z = true;
                            if (value instanceof Integer) {
                                k.a((Object) str2, "key");
                                ad.a(str2, ((Number) value).intValue(), str);
                            } else if (value instanceof Float) {
                                k.a((Object) str2, "key");
                                ad.a(str2, ((Number) value).floatValue(), str);
                            } else if (value instanceof Long) {
                                k.a((Object) str2, "key");
                                ad.a(str2, ((Number) value).longValue(), str);
                            } else if (value instanceof Boolean) {
                                k.a((Object) str2, "key");
                                ad.a(str2, ((Boolean) value).booleanValue(), str);
                            } else if (value instanceof String) {
                                k.a((Object) str2, "key");
                                ad.a(str2, (String) value, str);
                            }
                        }
                    }
                }
            } else {
                H5Log.e(H5ShareDataPlugin.TAG, " not set H5CacheProvider can not use shareData");
                a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5SharedPreferenceProvider'");
                return;
            }
        } else {
            z = false;
        }
        if (z) {
            a("success", (Object) Boolean.TRUE);
            a((Object) null);
            return;
        }
        a(H5Event.Error.UNKNOWN_ERROR, "cannot handle this data type");
    }

    private final void a(String str, com.alibaba.a.b bVar) {
        int i2 = 0;
        if (!TextUtils.isEmpty(str)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (((ad) (providerManager != null ? providerManager.getProvider(ad.class.getName()) : null)) == null) {
                H5Log.e(H5ShareDataPlugin.TAG, " not set H5CacheProvider can not use shareData");
                a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5SharedPreferenceProvider'");
                return;
            }
            if (bVar != null && !bVar.isEmpty()) {
                int size = bVar.size();
                while (i2 < size) {
                    Object obj = bVar.get(i2);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        Object a2 = ad.a(str2, str);
                        if (a2 == null) {
                            a2 = "";
                        }
                        a(str2, a2);
                    }
                    i2++;
                }
            }
            i2 = 1;
        }
        if (i2 == 0) {
            a(H5Event.Error.UNKNOWN_ERROR, "cannot get data");
        } else {
            a((Object) null);
        }
    }

    private final void b(String str, com.alibaba.a.b bVar) {
        int i2 = 0;
        if (!TextUtils.isEmpty(str)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (((ad) (providerManager != null ? providerManager.getProvider(ad.class.getName()) : null)) == null) {
                H5Log.e(H5ShareDataPlugin.TAG, " not set H5CacheProvider can not use shareDate");
                a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5SharedPreferenceProvider'");
                return;
            } else if (bVar != null && !bVar.isEmpty()) {
                int size = bVar.size();
                int i3 = 0;
                while (i2 < size) {
                    Object obj = bVar.get(i2);
                    if (obj instanceof String) {
                        ad.b((String) obj, str);
                        i3 = 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
        }
        if (i2 != 0) {
            a("success", (Object) Boolean.TRUE);
            a((Object) null);
            return;
        }
        a(H5Event.Error.UNKNOWN_ERROR, "cannot remove data");
    }

    private static String a(String str) {
        String str2 = "fljarvis_" + str + "_flfriday";
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        Charset charset = kotlin.m.d.f47971a;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = instance.digest(bytes);
            k.a((Object) digest, "bytes");
            return f.a(digest, "", d.INSTANCE) + "_flh5";
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final /* synthetic */ void a(ac acVar, H5Event h5Event) {
        Object obj = null;
        com.alibaba.a.b jSONArray = H5Utils.getJSONArray(h5Event.getParam(), "keys", (com.alibaba.a.b) null);
        Activity activity = h5Event.getActivity();
        if (activity != null && (activity instanceof PaytmH5Activity)) {
            String a2 = ((PaytmH5Activity) activity).a();
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (providerManager != null) {
                obj = providerManager.getProvider(ae.class.getName());
            }
            ae aeVar = (ae) obj;
            if (aeVar == null) {
                acVar.a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5WhitelistAppDataProvider'");
                return;
            }
            String a3 = aeVar.a(a2);
            if (a3 == null) {
                e.a aVar = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                a3 = e.a.b(a2);
            }
            if (a3 == null) {
                a3 = "";
            }
            String a4 = a(a2);
            e.a aVar2 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            if (e.a.d(a4)) {
                k.a((Object) jSONArray, "keys");
                acVar.a(a4, jSONArray);
                return;
            }
            e.a aVar3 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            if (e.a.d(a3)) {
                e.a aVar4 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                e.a.c(a3, a4);
                e.a aVar5 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                e.a.c(a3);
            }
            e.a aVar6 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            e.a aVar7 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            e.a.a(net.one97.paytm.h5paytmsdk.d.e.f17101b).edit().putBoolean(a4, true).apply();
            k.a((Object) jSONArray, "keys");
            acVar.a(a4, jSONArray);
        }
    }

    public static final /* synthetic */ void b(ac acVar, H5Event h5Event) {
        Object obj = null;
        com.alibaba.a.e jSONObject = H5Utils.getJSONObject(h5Event.getParam(), "data", (com.alibaba.a.e) null);
        Activity activity = h5Event.getActivity();
        if (activity != null && (activity instanceof PaytmH5Activity)) {
            String a2 = ((PaytmH5Activity) activity).a();
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (providerManager != null) {
                obj = providerManager.getProvider(ae.class.getName());
            }
            ae aeVar = (ae) obj;
            if (aeVar == null) {
                acVar.a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5WhitelistAppDataProvider'");
                return;
            }
            String a3 = aeVar.a(a2);
            if (a3 == null) {
                e.a aVar = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                a3 = e.a.b(a2);
            }
            if (a3 == null) {
                a3 = "";
            }
            String a4 = a(a2);
            e.a aVar2 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            if (e.a.d(a4)) {
                k.a((Object) jSONObject, "data");
                acVar.a(a4, jSONObject);
                return;
            }
            e.a aVar3 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            if (e.a.d(a3)) {
                e.a aVar4 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                e.a.c(a3, a4);
                e.a aVar5 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                e.a.c(a3);
            }
            e.a aVar6 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            e.a aVar7 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            e.a.a(net.one97.paytm.h5paytmsdk.d.e.f17101b).edit().putBoolean(a4, true).apply();
            k.a((Object) jSONObject, "data");
            acVar.a(a4, jSONObject);
        }
    }

    public static final /* synthetic */ void c(ac acVar, H5Event h5Event) {
        Object obj = null;
        com.alibaba.a.b jSONArray = H5Utils.getJSONArray(h5Event.getParam(), "keys", (com.alibaba.a.b) null);
        Activity activity = h5Event.getActivity();
        if (activity != null && (activity instanceof PaytmH5Activity)) {
            String a2 = ((PaytmH5Activity) activity).a();
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (providerManager != null) {
                obj = providerManager.getProvider(ae.class.getName());
            }
            ae aeVar = (ae) obj;
            if (aeVar == null) {
                acVar.a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5WhitelistAppDataProvider'");
                return;
            }
            String a3 = aeVar.a(a2);
            if (a3 == null) {
                e.a aVar = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                a3 = e.a.b(a2);
            }
            if (a3 == null) {
                a3 = "";
            }
            String a4 = a(a2);
            e.a aVar2 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            if (e.a.d(a4)) {
                k.a((Object) jSONArray, "keys");
                acVar.b(a4, jSONArray);
                return;
            }
            e.a aVar3 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            if (e.a.d(a3)) {
                e.a aVar4 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                e.a.c(a3, a4);
                e.a aVar5 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
                e.a.c(a3);
            }
            e.a aVar6 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            e.a aVar7 = net.one97.paytm.h5paytmsdk.d.e.f17100a;
            e.a.a(net.one97.paytm.h5paytmsdk.d.e.f17101b).edit().putBoolean(a4, true).apply();
            k.a((Object) jSONArray, "keys");
            acVar.b(a4, jSONArray);
        }
    }
}
