package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.marketplace.b;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.util.UpiConstants;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f50379a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f50380b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f50381c = f50381c;

    /* renamed from: d  reason: collision with root package name */
    private static DeepLinkData f50382d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final String f50383e = f50383e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f50384f = f50384f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f50385g = f50385g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f50386h = f50386h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f50387i = f50387i;
    private static WeakReference<Object> j;
    private static final a k = new a();

    static {
        w wVar = new w();
        f50379a = wVar;
        String name = wVar.getClass().getName();
        k.a((Object) name, "MallDeeplinkHandler.javaClass.name");
        f50380b = name;
    }

    private w() {
    }

    public static final class a extends HashSet<String> {
        a() {
            c cVar = c.f50324a;
            add(c.a());
            c cVar2 = c.f50324a;
            add(c.b());
            c cVar3 = c.f50324a;
            add(c.c());
            c cVar4 = c.f50324a;
            add(c.d());
            c cVar5 = c.f50324a;
            add(c.e());
            c cVar6 = c.f50324a;
            add(c.f());
            c cVar7 = c.f50324a;
            add(c.g());
            c cVar8 = c.f50324a;
            add(c.h());
            c cVar9 = c.f50324a;
            add(c.i());
            c cVar10 = c.f50324a;
            add(c.j());
            c cVar11 = c.f50324a;
            add(c.k());
            c cVar12 = c.f50324a;
            add(c.l());
            c cVar13 = c.f50324a;
            add(c.n());
            c cVar14 = c.f50324a;
            add(c.m());
            c cVar15 = c.f50324a;
            add(c.o());
            c cVar16 = c.f50324a;
            add(c.p());
            add(Utility.VERTICAL_NAME_MALL);
            c cVar17 = c.f50324a;
            add(c.q());
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return contains((String) obj);
        }

        public final /* bridge */ boolean contains(String str) {
            return super.contains(str);
        }

        public final int getSize() {
            return super.size();
        }

        public final /* bridge */ boolean remove(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return remove((String) obj);
        }

        public final /* bridge */ boolean remove(String str) {
            return super.remove(str);
        }

        public final int size() {
            return getSize();
        }
    }

    public static boolean a(String str) {
        k.c(str, "urlType");
        return k.contains((Object) str);
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        f50382d = deepLinkData;
        if (DynamicModuleManager.getInstance().isInstalled(f50381c)) {
            a(context);
            return;
        }
        Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, f50383e);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, f50381c);
        intent.putExtra("identifier", deepLinkData.f50284b);
        context.startActivity(intent);
    }

    public static final void a(Context context) {
        b a2;
        b a3;
        k.c(context, "context");
        DeepLinkData deepLinkData = f50382d;
        if (deepLinkData != null) {
            if (deepLinkData == null) {
                k.a();
            }
            String str = deepLinkData.f50284b;
            String name = x.ADD_TOP_SEARCHES.name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                String str2 = null;
                if (k.a((Object) str, (Object) lowerCase)) {
                    b a4 = a();
                    if (a4 != null) {
                        Bundle bundle = deepLinkData.f50290h;
                        if (bundle != null) {
                            str2 = bundle.getString(x.ADD_TOP_SEARCHES.name());
                        }
                        a4.addTopSearches(context, str2);
                        return;
                    }
                    return;
                }
                String name2 = x.UPDATE_CART_CACHE.name();
                if (name2 != null) {
                    String lowerCase2 = name2.toLowerCase();
                    k.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (k.a((Object) str, (Object) lowerCase2)) {
                        b a5 = a();
                        if (a5 != null) {
                            Bundle bundle2 = deepLinkData.f50290h;
                            if (bundle2 != null) {
                                str2 = bundle2.getString(x.UPDATE_CART_CACHE.name());
                            }
                            a5.updateCartCache(context, str2);
                            return;
                        }
                        return;
                    }
                    String name3 = x.ON_LOG_OUT.name();
                    if (name3 != null) {
                        String lowerCase3 = name3.toLowerCase();
                        k.b(lowerCase3, "(this as java.lang.String).toLowerCase()");
                        if (k.a((Object) str, (Object) lowerCase3)) {
                            b a6 = a();
                            if (a6 != null) {
                                a6.onLogout(context);
                                return;
                            }
                            return;
                        }
                        String name4 = x.GET_IMAGE_PLUGIN.name();
                        if (name4 != null) {
                            String lowerCase4 = name4.toLowerCase();
                            k.b(lowerCase4, "(this as java.lang.String).toLowerCase()");
                            if (k.a((Object) str, (Object) lowerCase4)) {
                                b a7 = a();
                                if (a7 != null) {
                                    Bundle bundle3 = deepLinkData.f50290h;
                                    if (bundle3 == null) {
                                        k.a();
                                    }
                                    a7.getImagePlugin(context, bundle3.getInt("RESULT_CODE"), deepLinkData.f50290h);
                                    return;
                                }
                                return;
                            }
                            String name5 = x.SEND_SCAN_RESULLT.name();
                            if (name5 != null) {
                                String lowerCase5 = name5.toLowerCase();
                                k.b(lowerCase5, "(this as java.lang.String).toLowerCase()");
                                if (k.a((Object) str, (Object) lowerCase5)) {
                                    b a8 = a();
                                    if (a8 != null) {
                                        Bundle bundle4 = deepLinkData.f50290h;
                                        if (bundle4 == null) {
                                            k.a();
                                        }
                                        int i2 = bundle4.getInt("REQUEST_CODE");
                                        Bundle bundle5 = deepLinkData.f50290h;
                                        if (bundle5 == null) {
                                            k.a();
                                        }
                                        a8.sendScanResult(context, i2, bundle5.getInt("RESULT_CODE"), deepLinkData.f50290h);
                                        return;
                                    }
                                    return;
                                }
                                String name6 = x.CLEAR_RECENT_SEARCHES.name();
                                if (name6 != null) {
                                    String lowerCase6 = name6.toLowerCase();
                                    k.b(lowerCase6, "(this as java.lang.String).toLowerCase()");
                                    if (k.a((Object) str, (Object) lowerCase6)) {
                                        b a9 = a();
                                        if (a9 != null) {
                                            a9.clearRecentSearches(context);
                                            return;
                                        }
                                        return;
                                    }
                                    String name7 = x.SAVE_SEARCH_RESPONSE.name();
                                    if (name7 != null) {
                                        String lowerCase7 = name7.toLowerCase();
                                        k.b(lowerCase7, "(this as java.lang.String).toLowerCase()");
                                        if (k.a((Object) str, (Object) lowerCase7)) {
                                            b a10 = a();
                                            if (a10 != null) {
                                                Bundle bundle6 = deepLinkData.f50290h;
                                                if (bundle6 != null) {
                                                    str2 = bundle6.getString(x.SAVE_SEARCH_RESPONSE.name());
                                                }
                                                a10.saveSearchResponse(context, str2);
                                                return;
                                            }
                                            return;
                                        }
                                        String name8 = x.REMOVE_RECENT_SEARCH_BY_INDEX.name();
                                        if (name8 != null) {
                                            String lowerCase8 = name8.toLowerCase();
                                            k.b(lowerCase8, "(this as java.lang.String).toLowerCase()");
                                            if (k.a((Object) str, (Object) lowerCase8)) {
                                                b a11 = a();
                                                if (a11 != null) {
                                                    Bundle bundle7 = deepLinkData.f50290h;
                                                    if (bundle7 == null) {
                                                        k.a();
                                                    }
                                                    a11.removeRecentSearchByIndex(context, bundle7.getInt(x.REMOVE_RECENT_SEARCH_BY_INDEX.name()));
                                                    return;
                                                }
                                                return;
                                            }
                                            String name9 = x.SEND_LOCATION_SERVICE_RESULT.name();
                                            if (name9 != null) {
                                                String lowerCase9 = name9.toLowerCase();
                                                k.b(lowerCase9, "(this as java.lang.String).toLowerCase()");
                                                if (!k.a((Object) str, (Object) lowerCase9)) {
                                                    String name10 = x.DEFAULT_ADDRESS_FROM_API.name();
                                                    if (name10 != null) {
                                                        String lowerCase10 = name10.toLowerCase();
                                                        k.b(lowerCase10, "(this as java.lang.String).toLowerCase()");
                                                        if (k.a((Object) str, (Object) lowerCase10)) {
                                                            b a12 = a();
                                                            if (a12 != null) {
                                                                Bundle bundle8 = deepLinkData.f50290h;
                                                                if (bundle8 == null) {
                                                                    k.a();
                                                                }
                                                                a12.getDefaultAddressFromAPI(context, bundle8.getString(x.DEFAULT_ADDRESS_FROM_API.name()));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        String name11 = x.SET_SAVED_ADDRESS.name();
                                                        if (name11 != null) {
                                                            String lowerCase11 = name11.toLowerCase();
                                                            k.b(lowerCase11, "(this as java.lang.String).toLowerCase()");
                                                            if (k.a((Object) str, (Object) lowerCase11)) {
                                                                b a13 = a();
                                                                if (a13 != null) {
                                                                    Bundle bundle9 = deepLinkData.f50290h;
                                                                    if (bundle9 == null) {
                                                                        k.a();
                                                                    }
                                                                    a13.setSavedAddress(context, bundle9.getString(x.SET_SAVED_ADDRESS.name()));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            String name12 = x.SET_SAVED_ADDRESS_LIST_RESPONSE.name();
                                                            if (name12 != null) {
                                                                String lowerCase12 = name12.toLowerCase();
                                                                k.b(lowerCase12, "(this as java.lang.String).toLowerCase()");
                                                                if (k.a((Object) str, (Object) lowerCase12)) {
                                                                    b a14 = a();
                                                                    if (a14 != null) {
                                                                        Bundle bundle10 = deepLinkData.f50290h;
                                                                        if (bundle10 == null) {
                                                                            k.a();
                                                                        }
                                                                        a14.setSavedAddressListResponse(context, bundle10.getString(x.SET_SAVED_ADDRESS_LIST_RESPONSE.name()));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                String name13 = x.REMOVE_ADDRESS_LIST_AND_SAVED_ADDRESS.name();
                                                                if (name13 != null) {
                                                                    String lowerCase13 = name13.toLowerCase();
                                                                    k.b(lowerCase13, "(this as java.lang.String).toLowerCase()");
                                                                    if (!k.a((Object) str, (Object) lowerCase13)) {
                                                                        q.d("Outer deeplink data for mall : " + deepLinkData.f50284b);
                                                                        String str3 = deepLinkData.f50283a;
                                                                        String str4 = deepLinkData.f50284b;
                                                                        if (str3 != null) {
                                                                            String d2 = d(str3);
                                                                            if (b(d2)) {
                                                                                if (d2 == null) {
                                                                                    k.a();
                                                                                }
                                                                                c(d2);
                                                                                return;
                                                                            }
                                                                            CharSequence charSequence = str3;
                                                                            if (!TextUtils.isEmpty(charSequence) && p.a(charSequence, (CharSequence) "utm_", false)) {
                                                                                try {
                                                                                    str3 = URLDecoder.decode(str3, AppConstants.UTF_8);
                                                                                } catch (Exception e2) {
                                                                                    q.b(e2.getMessage());
                                                                                }
                                                                            }
                                                                            if (str4 != null) {
                                                                                if (p.a("external", str4, true)) {
                                                                                    Intent intent = new Intent("android.intent.action.VIEW");
                                                                                    intent.setData(Uri.parse(str3));
                                                                                    context.startActivity(intent);
                                                                                    return;
                                                                                } else if (!p.a(Utility.VERTICAL_NAME_MALL, str4, true)) {
                                                                                    c cVar = c.f50324a;
                                                                                    if (p.a(c.q(), str4, true)) {
                                                                                        if (str3 == null) {
                                                                                            k.a();
                                                                                        }
                                                                                        if (!p.a((CharSequence) str3, (CharSequence) "url", false)) {
                                                                                            StringBuilder sb = new StringBuilder("paytmmp://");
                                                                                            c cVar2 = c.f50324a;
                                                                                            sb.append(c.q());
                                                                                            sb.append("?url=");
                                                                                            sb.append(d.b().a("paytmbangURL"));
                                                                                            str3 = sb.toString();
                                                                                        }
                                                                                    }
                                                                                } else if (!(context instanceof Activity) || (context instanceof AJRMainActivity)) {
                                                                                    str4 = "homepage_secondary";
                                                                                    str3 = "paytmmp://" + str4 + "?url=" + d.b().a("mall_homepage");
                                                                                } else {
                                                                                    Intent intent2 = new Intent(context, AJRMainActivity.class);
                                                                                    intent2.putExtra("open_mall_tab", "true");
                                                                                    context.startActivity(intent2);
                                                                                    return;
                                                                                }
                                                                            }
                                                                            HashMap<String, Serializable> a15 = a(a(deepLinkData.f50290h, str3, str4));
                                                                            b a16 = a();
                                                                            if (a16 != null) {
                                                                                a16.loadPage(context, str4, a15);
                                                                            }
                                                                        }
                                                                    } else if ((context instanceof Activity) && (a2 = a()) != null) {
                                                                        a2.removeAddressListAndSavedAddress((Activity) context);
                                                                    }
                                                                } else {
                                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                }
                                                            } else {
                                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                            }
                                                        } else {
                                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                        }
                                                    } else {
                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                    }
                                                } else if ((context instanceof Activity) && (a3 = a()) != null) {
                                                    a3.sendLocationServiceResult((Activity) context);
                                                }
                                            } else {
                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                            }
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    private static HashMap<String, Serializable> a(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("BUNDLE_MAP_TAG")) {
                    Serializable serializable = bundle.getSerializable("BUNDLE_MAP_TAG");
                    if (serializable != null) {
                        return (HashMap) serializable;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, java.io.Serializable> /* = java.util.HashMap<kotlin.String, java.io.Serializable> */");
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }

    private static Bundle a(Bundle bundle, String str, String str2) {
        if (TextUtils.isEmpty(str) && bundle == null) {
            return null;
        }
        HashMap<String, Serializable> a2 = a(bundle);
        CJRHomePageItem a3 = a(a2);
        if (a3 != null) {
            a3.setDeeplink(str);
            a3.setUrlType(str2);
            a3.setUrl(a(bundle, str, a3));
            a2.put("extra_home_data", a3);
        }
        return a(bundle, a2);
    }

    private static Bundle a(Bundle bundle, HashMap<String, Serializable> hashMap) {
        k.c(hashMap, "dataMap");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable("BUNDLE_MAP_TAG", hashMap);
        return bundle;
    }

    public static String a(x xVar) {
        k.c(xVar, "type");
        Uri.Builder scheme = new Uri.Builder().scheme("paytmmp");
        String name = xVar.name();
        if (name != null) {
            String lowerCase = name.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            String uri = scheme.authority(lowerCase).build().toString();
            k.a((Object) uri, "Uri.Builder().scheme(\"pa…ase()).build().toString()");
            return uri;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static b a() {
        WeakReference<Object> weakReference = j;
        if (weakReference != null) {
            if (weakReference == null) {
                k.a("mallProviderInstanceRef");
            }
            if (weakReference != null) {
                WeakReference<Object> weakReference2 = j;
                if (weakReference2 == null) {
                    k.a("mallProviderInstanceRef");
                }
                if (weakReference2.get() != null) {
                    WeakReference<Object> weakReference3 = j;
                    if (weakReference3 == null) {
                        k.a("mallProviderInstanceRef");
                    }
                    if (weakReference3.get() instanceof b) {
                        WeakReference<Object> weakReference4 = j;
                        if (weakReference4 == null) {
                            k.a("mallProviderInstanceRef");
                        }
                        Object obj = weakReference4.get();
                        if (obj != null) {
                            return (b) obj;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.marketplace.MallModuleProvider");
                    }
                }
            }
        }
        b b2 = b();
        if (b2 == null) {
            return null;
        }
        j = new WeakReference<>(b2);
        return b2;
    }

    private static b b() {
        try {
            Class<?> cls = Class.forName(f50384f);
            k.a((Object) cls, "Class.forName(MALL_MODULE_PROVIDER_IMPL)");
            Constructor<?> constructor = cls.getConstructor(new Class[0]);
            k.a((Object) constructor, "clazz.getConstructor()");
            Object newInstance = constructor.newInstance(new Object[0]);
            if (newInstance != null) {
                return (b) newInstance;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.marketplace.MallModuleProvider");
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String c2 = c();
            Uri parse = Uri.parse(str);
            if (!(c2 == null || parse == null || parse.getHost() == null)) {
                return p.a((CharSequence) c2, (CharSequence) "\"" + parse.getHost() + "\"", false);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return false;
    }

    private static String c() {
        try {
            c.a();
            String a2 = c.a(f50387i, (String) null);
            if (TextUtils.isEmpty(a2)) {
                return d();
            }
            k.a((Object) a2, "mallH5Urls");
            return a2;
        } catch (Exception unused) {
            return d();
        }
    }

    private static String d() {
        return "[\"" + f50385g + "\"]";
    }

    private static void c(String str) {
        k.c(str, "url");
        b a2 = a();
        if (a2 != null) {
            a2.loadMallH5Page(str);
        }
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str == null) {
            k.a();
        }
        if (p.b(str, "http://", false) || p.b(str, "https://", false)) {
            return str;
        }
        try {
            if (p.a((CharSequence) str, (CharSequence) f50386h, false)) {
                String substring = str.substring(p.a((CharSequence) str, f50386h, 0, false, 6) + f50386h.length());
                k.b(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return null;
    }

    private static String a(Bundle bundle, String str, CJRHomePageItem cJRHomePageItem) {
        String substring;
        try {
            if (!TextUtils.isEmpty(str) || bundle == null) {
                if (str == null) {
                    return "";
                }
                Uri e2 = e(str);
                String str2 = cJRHomePageItem.mseourl;
                if (!(e2 == null || e2.getQueryParameterNames() == null || !e2.getQueryParameterNames().contains("url"))) {
                    String uri = e2.toString();
                    k.a((Object) uri, "uri.toString()");
                    int a2 = uri != null ? p.a((CharSequence) uri, f50386h, 0, false, 6) + 4 : -1;
                    if (a2 != -1 && uri.length() > a2) {
                        if (uri != null) {
                            substring = uri.substring(a2);
                            k.b(substring, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
                return str2;
            } else if (!bundle.containsKey("url") || bundle == null) {
                return "";
            } else {
                substring = bundle.getString("url");
            }
            return substring;
        } catch (Exception e3) {
            q.b(e3.getMessage());
            return "";
        }
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    private static CJRHomePageItem a(HashMap<String, Serializable> hashMap) {
        try {
            return hashMap.containsKey("extra_home_data") ? CJRHomePageItem.class.cast(hashMap.get("extra_home_data")) : new CJRHomePageItem();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return new CJRHomePageItem();
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (TextUtils.isEmpty(deepLinkData.f50284b)) {
            return false;
        }
        String str = deepLinkData.f50284b;
        if (str == null) {
            k.a();
        }
        k.c(deepLinkData, "data");
        k.c(str, "urlType");
        String name = x.ADD_TOP_SEARCHES.name();
        if (name != null) {
            String lowerCase = name.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str, (Object) lowerCase)) {
                return true;
            }
            String name2 = x.UPDATE_CART_CACHE.name();
            if (name2 != null) {
                String lowerCase2 = name2.toLowerCase();
                k.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (k.a((Object) str, (Object) lowerCase2)) {
                    return true;
                }
                String name3 = x.ON_LOG_OUT.name();
                if (name3 != null) {
                    String lowerCase3 = name3.toLowerCase();
                    k.b(lowerCase3, "(this as java.lang.String).toLowerCase()");
                    if (k.a((Object) str, (Object) lowerCase3)) {
                        return true;
                    }
                    String name4 = x.GET_IMAGE_PLUGIN.name();
                    if (name4 != null) {
                        String lowerCase4 = name4.toLowerCase();
                        k.b(lowerCase4, "(this as java.lang.String).toLowerCase()");
                        if (k.a((Object) str, (Object) lowerCase4)) {
                            return true;
                        }
                        String name5 = x.SEND_SCAN_RESULLT.name();
                        if (name5 != null) {
                            String lowerCase5 = name5.toLowerCase();
                            k.b(lowerCase5, "(this as java.lang.String).toLowerCase()");
                            if (k.a((Object) str, (Object) lowerCase5)) {
                                return true;
                            }
                            String name6 = x.GET_SESSION_DETAILS.name();
                            if (name6 != null) {
                                String lowerCase6 = name6.toLowerCase();
                                k.b(lowerCase6, "(this as java.lang.String).toLowerCase()");
                                if (k.a((Object) str, (Object) lowerCase6)) {
                                    return true;
                                }
                                String name7 = x.GET_H5_FLAGS.name();
                                if (name7 != null) {
                                    String lowerCase7 = name7.toLowerCase();
                                    k.b(lowerCase7, "(this as java.lang.String).toLowerCase()");
                                    if (k.a((Object) str, (Object) lowerCase7)) {
                                        return true;
                                    }
                                    String name8 = x.GET_TOP_SEARCHES.name();
                                    if (name8 != null) {
                                        String lowerCase8 = name8.toLowerCase();
                                        k.b(lowerCase8, "(this as java.lang.String).toLowerCase()");
                                        if (k.a((Object) str, (Object) lowerCase8)) {
                                            return true;
                                        }
                                        String name9 = x.SAVE_SEARCH_RESPONSE.name();
                                        if (name9 != null) {
                                            String lowerCase9 = name9.toLowerCase();
                                            k.b(lowerCase9, "(this as java.lang.String).toLowerCase()");
                                            if (k.a((Object) str, (Object) lowerCase9)) {
                                                return true;
                                            }
                                            String name10 = x.CLEAR_RECENT_SEARCHES.name();
                                            if (name10 != null) {
                                                String lowerCase10 = name10.toLowerCase();
                                                k.b(lowerCase10, "(this as java.lang.String).toLowerCase()");
                                                if (k.a((Object) str, (Object) lowerCase10)) {
                                                    return true;
                                                }
                                                String name11 = x.HANDLE_SEARCH_URL.name();
                                                if (name11 != null) {
                                                    String lowerCase11 = name11.toLowerCase();
                                                    k.b(lowerCase11, "(this as java.lang.String).toLowerCase()");
                                                    if (k.a((Object) str, (Object) lowerCase11)) {
                                                        return true;
                                                    }
                                                    String name12 = x.GET_BASE_H5_URL.name();
                                                    if (name12 != null) {
                                                        String lowerCase12 = name12.toLowerCase();
                                                        k.b(lowerCase12, "(this as java.lang.String).toLowerCase()");
                                                        if (k.a((Object) str, (Object) lowerCase12)) {
                                                            return true;
                                                        }
                                                        String name13 = x.OPEN_ORDER_DETAIL.name();
                                                        if (name13 != null) {
                                                            String lowerCase13 = name13.toLowerCase();
                                                            k.b(lowerCase13, "(this as java.lang.String).toLowerCase()");
                                                            if (k.a((Object) str, (Object) lowerCase13)) {
                                                                return true;
                                                            }
                                                            String name14 = x.OPEN_H5_ORDER_SUMMARY.name();
                                                            if (name14 != null) {
                                                                String lowerCase14 = name14.toLowerCase();
                                                                k.b(lowerCase14, "(this as java.lang.String).toLowerCase()");
                                                                if (k.a((Object) str, (Object) lowerCase14)) {
                                                                    return true;
                                                                }
                                                                String name15 = x.ADD_TO_WISH_LIST.name();
                                                                if (name15 != null) {
                                                                    String lowerCase15 = name15.toLowerCase();
                                                                    k.b(lowerCase15, "(this as java.lang.String).toLowerCase()");
                                                                    if (k.a((Object) str, (Object) lowerCase15)) {
                                                                        return true;
                                                                    }
                                                                    String name16 = x.REMOVE_RECENT_SEARCH_BY_INDEX.name();
                                                                    if (name16 != null) {
                                                                        String lowerCase16 = name16.toLowerCase();
                                                                        k.b(lowerCase16, "(this as java.lang.String).toLowerCase()");
                                                                        if (k.a((Object) str, (Object) lowerCase16)) {
                                                                            return true;
                                                                        }
                                                                        String name17 = x.SEND_LOCATION_SERVICE_RESULT.name();
                                                                        if (name17 != null) {
                                                                            String lowerCase17 = name17.toLowerCase();
                                                                            k.b(lowerCase17, "(this as java.lang.String).toLowerCase()");
                                                                            if (k.a((Object) str, (Object) lowerCase17)) {
                                                                                return true;
                                                                            }
                                                                            String name18 = x.GET_MALL_TAB_FRAGMENT.name();
                                                                            if (name18 != null) {
                                                                                String lowerCase18 = name18.toLowerCase();
                                                                                k.b(lowerCase18, "(this as java.lang.String).toLowerCase()");
                                                                                if (k.a((Object) str, (Object) lowerCase18)) {
                                                                                    return true;
                                                                                }
                                                                                String name19 = x.SET_SAVED_ADDRESS.name();
                                                                                if (name19 != null) {
                                                                                    String lowerCase19 = name19.toLowerCase();
                                                                                    k.b(lowerCase19, "(this as java.lang.String).toLowerCase()");
                                                                                    if (k.a((Object) str, (Object) lowerCase19)) {
                                                                                        return true;
                                                                                    }
                                                                                    String name20 = x.REMOVE_ADDRESS_LIST_AND_SAVED_ADDRESS.name();
                                                                                    if (name20 != null) {
                                                                                        String lowerCase20 = name20.toLowerCase();
                                                                                        k.b(lowerCase20, "(this as java.lang.String).toLowerCase()");
                                                                                        if (k.a((Object) str, (Object) lowerCase20)) {
                                                                                            return true;
                                                                                        }
                                                                                        String name21 = x.LOAD_MALL_H5_PAGE.name();
                                                                                        if (name21 != null) {
                                                                                            String lowerCase21 = name21.toLowerCase();
                                                                                            k.b(lowerCase21, "(this as java.lang.String).toLowerCase()");
                                                                                            if (k.a((Object) str, (Object) lowerCase21)) {
                                                                                                return true;
                                                                                            }
                                                                                            String name22 = x.SHOW_GRID_POPUP.name();
                                                                                            if (name22 != null) {
                                                                                                String lowerCase22 = name22.toLowerCase();
                                                                                                k.b(lowerCase22, "(this as java.lang.String).toLowerCase()");
                                                                                                if (k.a((Object) str, (Object) lowerCase22)) {
                                                                                                    return true;
                                                                                                }
                                                                                                String name23 = x.SET_GA_JSON.name();
                                                                                                if (name23 != null) {
                                                                                                    String lowerCase23 = name23.toLowerCase();
                                                                                                    k.b(lowerCase23, "(this as java.lang.String).toLowerCase()");
                                                                                                    if (k.a((Object) str, (Object) lowerCase23)) {
                                                                                                        return true;
                                                                                                    }
                                                                                                    String name24 = x.HANDLE_PLAY_SERVICES_ERROR.name();
                                                                                                    if (name24 != null) {
                                                                                                        String lowerCase24 = name24.toLowerCase();
                                                                                                        k.b(lowerCase24, "(this as java.lang.String).toLowerCase()");
                                                                                                        if (k.a((Object) str, (Object) lowerCase24)) {
                                                                                                            return true;
                                                                                                        }
                                                                                                        String name25 = x.SET_SAVED_ADDRESS_LIST_RESPONSE.name();
                                                                                                        if (name25 != null) {
                                                                                                            String lowerCase25 = name25.toLowerCase();
                                                                                                            k.b(lowerCase25, "(this as java.lang.String).toLowerCase()");
                                                                                                            if (k.a((Object) str, (Object) lowerCase25)) {
                                                                                                                return true;
                                                                                                            }
                                                                                                            String name26 = x.DEFAULT_ADDRESS_FROM_API.name();
                                                                                                            if (name26 != null) {
                                                                                                                String lowerCase26 = name26.toLowerCase();
                                                                                                                k.b(lowerCase26, "(this as java.lang.String).toLowerCase()");
                                                                                                                if (k.a((Object) str, (Object) lowerCase26)) {
                                                                                                                    return true;
                                                                                                                }
                                                                                                                return a(str);
                                                                                                            }
                                                                                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                                        }
                                                                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                                    }
                                                                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                                }
                                                                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                            }
                                                                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                        }
                                                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                    }
                                                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                                }
                                                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                            }
                                                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                        }
                                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                    }
                                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                }
                                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                            }
                                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                        }
                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                    }
                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                }
                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
