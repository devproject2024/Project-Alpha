package net.one97.paytm.phoenix;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.phoenix.api.d;
import net.one97.paytm.phoenix.core.web.b;
import net.one97.paytm.phoenix.d.aa;
import net.one97.paytm.phoenix.d.ab;
import net.one97.paytm.phoenix.d.ac;
import net.one97.paytm.phoenix.d.ad;
import net.one97.paytm.phoenix.d.ae;
import net.one97.paytm.phoenix.d.af;
import net.one97.paytm.phoenix.d.ag;
import net.one97.paytm.phoenix.d.ah;
import net.one97.paytm.phoenix.d.ai;
import net.one97.paytm.phoenix.d.aj;
import net.one97.paytm.phoenix.d.ak;
import net.one97.paytm.phoenix.d.al;
import net.one97.paytm.phoenix.d.am;
import net.one97.paytm.phoenix.d.an;
import net.one97.paytm.phoenix.d.ao;
import net.one97.paytm.phoenix.d.ap;
import net.one97.paytm.phoenix.d.aq;
import net.one97.paytm.phoenix.d.ar;
import net.one97.paytm.phoenix.d.as;
import net.one97.paytm.phoenix.d.at;
import net.one97.paytm.phoenix.d.au;
import net.one97.paytm.phoenix.d.av;
import net.one97.paytm.phoenix.d.aw;
import net.one97.paytm.phoenix.d.ax;
import net.one97.paytm.phoenix.d.ay;
import net.one97.paytm.phoenix.d.az;
import net.one97.paytm.phoenix.d.ba;
import net.one97.paytm.phoenix.d.bb;
import net.one97.paytm.phoenix.d.bc;
import net.one97.paytm.phoenix.d.bd;
import net.one97.paytm.phoenix.d.f;
import net.one97.paytm.phoenix.d.r;
import net.one97.paytm.phoenix.d.s;
import net.one97.paytm.phoenix.d.t;
import net.one97.paytm.phoenix.d.u;
import net.one97.paytm.phoenix.d.v;
import net.one97.paytm.phoenix.d.w;
import net.one97.paytm.phoenix.d.x;
import net.one97.paytm.phoenix.d.z;
import net.one97.paytm.phoenix.data.PhoenixMenuDialogItems;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProvider;
import net.one97.paytm.phoenix.provider.PaymentProvider;
import net.one97.paytm.phoenix.provider.PaytmBuildTypeProvider;
import net.one97.paytm.phoenix.provider.PaytmH5AppAnalyticsProvider;
import net.one97.paytm.phoenix.provider.PaytmH5LocationProvider;
import net.one97.paytm.phoenix.provider.PaytmH5RestringProvider;
import net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider;
import net.one97.paytm.phoenix.provider.PhoenixActivityResultProvider;
import net.one97.paytm.phoenix.provider.PhoenixAnalyticsProvider;
import net.one97.paytm.phoenix.provider.PhoenixAppInfoProvider;
import net.one97.paytm.phoenix.provider.PhoenixAppPermissionProvider;
import net.one97.paytm.phoenix.provider.PhoenixAppShortCutProvider;
import net.one97.paytm.phoenix.provider.PhoenixAppsFlerSendEventProvider;
import net.one97.paytm.phoenix.provider.PhoenixAuthProvider;
import net.one97.paytm.phoenix.provider.PhoenixBridgeInterceptorProvider;
import net.one97.paytm.phoenix.provider.PhoenixDeepLinkHandlerProvider;
import net.one97.paytm.phoenix.provider.PhoenixDeveloperModeWhitelisDataProvider;
import net.one97.paytm.phoenix.provider.PhoenixExitSessionProvider;
import net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProvider;
import net.one97.paytm.phoenix.provider.PhoenixHttpProvider;
import net.one97.paytm.phoenix.provider.PhoenixLanguageSelectedProvider;
import net.one97.paytm.phoenix.provider.PhoenixLoadingViewProvider;
import net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl;
import net.one97.paytm.phoenix.provider.PhoenixNavigationClassProvider;
import net.one97.paytm.phoenix.provider.PhoenixSessionTimeOutPopUpProvider;
import net.one97.paytm.phoenix.provider.PhoenixTitleLoadingProvider;
import net.one97.paytm.phoenix.provider.PhoenixTitleLoadingProviderImpl;
import net.one97.paytm.phoenix.provider.SplashIconViewProvider;
import net.one97.paytm.phoenix.provider.SplashIconViewProviderImpl;
import net.one97.paytm.phoenix.provider.TitleBarImageProvider;
import net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.g;
import net.one97.paytm.phoenix.util.i;
import net.one97.paytm.phoenix.util.j;
import net.one97.paytm.phoenix.util.p;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class PhoenixManager {
    public static final PhoenixManager INSTANCE = new PhoenixManager();
    /* access modifiers changed from: private */
    public static Application application;
    private static boolean isDebug;
    private static boolean isFromDeepLinkStatus;
    private static boolean isInit;
    private static String lastOpenedAppUniqueId = "";
    private static long lastPageOpenTimeStamp;
    private static List<String> listOfSubscribeBridges = k.c(H5Plugin.InternalEvents.H5_TITLEBAR_TITLE_CLICK, "start", "resume", "pause", "stop");
    private static final Map<String, List<d>> mapOfTempPlugins = new LinkedHashMap();
    private static final Map<String, List<Object>> mapOfTempProviders = new LinkedHashMap();
    private static List<PhoenixMenuDialogItems> menuItemsList = new ArrayList();
    private static b.a phoenixOnShowFileChooser;
    private static Bundle sParamsBundle;

    public interface a {
    }

    private PhoenixManager() {
    }

    public static final /* synthetic */ Application access$getApplication$p(PhoenixManager phoenixManager) {
        Application application2 = application;
        if (application2 == null) {
            kotlin.g.b.k.a("application");
        }
        return application2;
    }

    public final boolean isDebug$phoenix_debug() {
        return isDebug;
    }

    public final void setDebug$phoenix_debug(boolean z) {
        isDebug = z;
    }

    public final boolean isFromDeepLinkStatus$phoenix_debug() {
        return isFromDeepLinkStatus;
    }

    public final void setFromDeepLinkStatus$phoenix_debug(boolean z) {
        isFromDeepLinkStatus = z;
    }

    public final String getLastOpenedAppUniqueId() {
        return lastOpenedAppUniqueId;
    }

    public final void setLastOpenedAppUniqueId(String str) {
        kotlin.g.b.k.c(str, "<set-?>");
        lastOpenedAppUniqueId = str;
    }

    public final Map<String, List<d>> getMapOfTempPlugins() {
        return mapOfTempPlugins;
    }

    public final Map<String, List<Object>> getMapOfTempProviders() {
        return mapOfTempProviders;
    }

    public final List<String> getListOfSubscribeBridges() {
        return listOfSubscribeBridges;
    }

    public final void setListOfSubscribeBridges(List<String> list) {
        kotlin.g.b.k.c(list, "<set-?>");
        listOfSubscribeBridges = list;
    }

    public final b.a getPhoenixOnShowFileChooser() {
        return phoenixOnShowFileChooser;
    }

    public final void setPhoenixOnShowFileChooser(b.a aVar) {
        phoenixOnShowFileChooser = aVar;
    }

    public final long getLastPageOpenTimeStamp() {
        return lastPageOpenTimeStamp;
    }

    public final void setLastPageOpenTimeStamp(long j) {
        lastPageOpenTimeStamp = j;
    }

    public final List<PhoenixMenuDialogItems> getMenuItemsList() {
        return menuItemsList;
    }

    public final void setMenuItemsList(List<PhoenixMenuDialogItems> list) {
        menuItemsList = list;
    }

    public final Bundle getSParamsBundle() {
        return sParamsBundle;
    }

    public final void setSParamsBundle(Bundle bundle) {
        sParamsBundle = bundle;
    }

    public static /* synthetic */ void init$default(PhoenixManager phoenixManager, Application application2, List list, List list2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = null;
        }
        if ((i2 & 4) != 0) {
            list2 = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        phoenixManager.init(application2, list, list2, z);
    }

    public final void init(Application application2, List<? extends d> list, List<? extends Object> list2, boolean z) {
        kotlin.g.b.k.c(application2, "application");
        if (!isInit) {
            isDebug = z;
            application = application2;
            j jVar = j.f59646a;
            j.a(z);
            addProviders(list2);
            registerPlugins(list);
            isInit = true;
        }
    }

    private final void registerPlugins(List<? extends d> list) {
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new s());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ae());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new av());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new az());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ah());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ar());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new an());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new bd());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new aw());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new bb());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new al());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ab());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ba());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new as());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new bc());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new u());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ak());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ad());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new at());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new t());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new w());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new am());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new au());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ag());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new aa());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ao());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new af());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new f());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new r());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ay());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ai());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new aq());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ax());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new x());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new z());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ap());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new ac());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new aj());
        net.one97.paytm.phoenix.core.c.f59399a.a().a(new v());
        if (list != null) {
            for (d a2 : list) {
                net.one97.paytm.phoenix.core.c.f59399a.a().a(a2);
            }
        }
        net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = SplashIconViewProvider.class.getName();
        kotlin.g.b.k.a((Object) name, "SplashIconViewProvider::class.java.name");
        if (b2.a(name) == null) {
            net.one97.paytm.phoenix.api.f b3 = net.one97.paytm.phoenix.core.c.f59399a.b();
            String name2 = SplashIconViewProvider.class.getName();
            kotlin.g.b.k.a((Object) name2, "SplashIconViewProvider::class.java.name");
            b3.a(name2, new SplashIconViewProviderImpl());
        }
        net.one97.paytm.phoenix.api.f b4 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name3 = PhoenixLoadingViewProvider.class.getName();
        kotlin.g.b.k.a((Object) name3, "PhoenixLoadingViewProvider::class.java.name");
        if (b4.a(name3) == null) {
            net.one97.paytm.phoenix.api.f b5 = net.one97.paytm.phoenix.core.c.f59399a.b();
            String name4 = PhoenixLoadingViewProvider.class.getName();
            kotlin.g.b.k.a((Object) name4, "PhoenixLoadingViewProvider::class.java.name");
            b5.a(name4, new PhoenixLoadingViewProviderImpl());
        }
        net.one97.paytm.phoenix.api.f b6 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name5 = PhoenixTitleLoadingProvider.class.getName();
        kotlin.g.b.k.a((Object) name5, "PhoenixTitleLoadingProvider::class.java.name");
        b6.a(name5, new PhoenixTitleLoadingProviderImpl());
        net.one97.paytm.phoenix.api.f b7 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name6 = PhoenixFileDownloadProvider.class.getName();
        kotlin.g.b.k.a((Object) name6, "PhoenixFileDownloadProvider::class.java.name");
        b7.a(name6, new PhoenixFileDownloadProvider());
    }

    static /* synthetic */ void addProviders$default(PhoenixManager phoenixManager, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        phoenixManager.addProviders(list);
    }

    private final void addProviders(List<? extends Object> list) {
        if (list != null) {
            for (Object next : list) {
                if (next instanceof FetchValuesForKeysProvider) {
                    net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name = FetchValuesForKeysProvider.class.getName();
                    kotlin.g.b.k.a((Object) name, "FetchValuesForKeysProvider::class.java.name");
                    b2.a(name, next);
                } else if (next instanceof PaytmPhoenixWhitelistAppDataProvider) {
                    net.one97.paytm.phoenix.api.f b3 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name2 = PaytmPhoenixWhitelistAppDataProvider.class.getName();
                    kotlin.g.b.k.a((Object) name2, "PaytmPhoenixWhitelistApp…Provider::class.java.name");
                    b3.a(name2, next);
                } else if (next instanceof PhoenixAppPermissionProvider) {
                    net.one97.paytm.phoenix.api.f b4 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name3 = PhoenixAppPermissionProvider.class.getName();
                    kotlin.g.b.k.a((Object) name3, "PhoenixAppPermissionProvider::class.java.name");
                    b4.a(name3, next);
                } else if (next instanceof PaymentProvider) {
                    net.one97.paytm.phoenix.api.f b5 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name4 = PaymentProvider.class.getName();
                    kotlin.g.b.k.a((Object) name4, "PaymentProvider::class.java.name");
                    b5.a(name4, next);
                } else if (next instanceof PhoenixLoadingViewProvider) {
                    net.one97.paytm.phoenix.api.f b6 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name5 = PhoenixLoadingViewProvider.class.getName();
                    kotlin.g.b.k.a((Object) name5, "PhoenixLoadingViewProvider::class.java.name");
                    b6.a(name5, next);
                } else if (next instanceof SplashIconViewProvider) {
                    net.one97.paytm.phoenix.api.f b7 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name6 = SplashIconViewProvider.class.getName();
                    kotlin.g.b.k.a((Object) name6, "SplashIconViewProvider::class.java.name");
                    b7.a(name6, next);
                } else if (next instanceof PhoenixActivityResultProvider) {
                    net.one97.paytm.phoenix.api.f b8 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name7 = PhoenixActivityResultProvider.class.getName();
                    kotlin.g.b.k.a((Object) name7, "PhoenixActivityResultProvider::class.java.name");
                    b8.a(name7, next);
                } else if (next instanceof TitleBarImageProvider) {
                    net.one97.paytm.phoenix.api.f b9 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name8 = TitleBarImageProvider.class.getName();
                    kotlin.g.b.k.a((Object) name8, "TitleBarImageProvider::class.java.name");
                    b9.a(name8, next);
                } else if (next instanceof PaytmH5LocationProvider) {
                    net.one97.paytm.phoenix.api.f b10 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name9 = PaytmH5LocationProvider.class.getName();
                    kotlin.g.b.k.a((Object) name9, "PaytmH5LocationProvider::class.java.name");
                    b10.a(name9, next);
                } else if (next instanceof PhoenixAppInfoProvider) {
                    net.one97.paytm.phoenix.api.f b11 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name10 = PhoenixAppInfoProvider.class.getName();
                    kotlin.g.b.k.a((Object) name10, "PhoenixAppInfoProvider::class.java.name");
                    b11.a(name10, next);
                } else if (next instanceof PhoenixAppShortCutProvider) {
                    net.one97.paytm.phoenix.api.f b12 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name11 = PhoenixAppShortCutProvider.class.getName();
                    kotlin.g.b.k.a((Object) name11, "PhoenixAppShortCutProvider::class.java.name");
                    b12.a(name11, next);
                } else if (next instanceof PhoenixLanguageSelectedProvider) {
                    net.one97.paytm.phoenix.api.f b13 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name12 = PhoenixLanguageSelectedProvider.class.getName();
                    kotlin.g.b.k.a((Object) name12, "PhoenixLanguageSelectedProvider::class.java.name");
                    b13.a(name12, next);
                } else if (next instanceof PhoenixAnalyticsProvider) {
                    net.one97.paytm.phoenix.api.f b14 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name13 = PhoenixAnalyticsProvider.class.getName();
                    kotlin.g.b.k.a((Object) name13, "PhoenixAnalyticsProvider::class.java.name");
                    b14.a(name13, next);
                } else if (next instanceof PhoenixHttpProvider) {
                    net.one97.paytm.phoenix.api.f b15 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name14 = PhoenixHttpProvider.class.getName();
                    kotlin.g.b.k.a((Object) name14, "PhoenixHttpProvider::class.java.name");
                    b15.a(name14, next);
                } else if (next instanceof PhoenixAuthProvider) {
                    net.one97.paytm.phoenix.api.f b16 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name15 = PhoenixAuthProvider.class.getName();
                    kotlin.g.b.k.a((Object) name15, "PhoenixAuthProvider::class.java.name");
                    b16.a(name15, next);
                } else if (next instanceof PhoenixSessionTimeOutPopUpProvider) {
                    net.one97.paytm.phoenix.api.f b17 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name16 = PhoenixSessionTimeOutPopUpProvider.class.getName();
                    kotlin.g.b.k.a((Object) name16, "PhoenixSessionTimeOutPop…Provider::class.java.name");
                    b17.a(name16, next);
                } else if (next instanceof PhoenixBridgeInterceptorProvider) {
                    net.one97.paytm.phoenix.api.f b18 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name17 = PhoenixBridgeInterceptorProvider.class.getName();
                    kotlin.g.b.k.a((Object) name17, "PhoenixBridgeInterceptorProvider::class.java.name");
                    b18.a(name17, next);
                } else if (next instanceof PhoenixDeepLinkHandlerProvider) {
                    net.one97.paytm.phoenix.api.f b19 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name18 = PhoenixDeepLinkHandlerProvider.class.getName();
                    kotlin.g.b.k.a((Object) name18, "PhoenixDeepLinkHandlerProvider::class.java.name");
                    b19.a(name18, next);
                } else if (next instanceof PhoenixNavigationClassProvider) {
                    net.one97.paytm.phoenix.api.f b20 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name19 = PhoenixNavigationClassProvider.class.getName();
                    kotlin.g.b.k.a((Object) name19, "PhoenixNavigationClassProvider::class.java.name");
                    b20.a(name19, next);
                } else if (next instanceof PhoenixExitSessionProvider) {
                    net.one97.paytm.phoenix.api.f b21 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name20 = PhoenixExitSessionProvider.class.getName();
                    kotlin.g.b.k.a((Object) name20, "PhoenixExitSessionProvider::class.java.name");
                    b21.a(name20, next);
                } else if (next instanceof PaytmH5AppAnalyticsProvider) {
                    net.one97.paytm.phoenix.api.f b22 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name21 = PaytmH5AppAnalyticsProvider.class.getName();
                    kotlin.g.b.k.a((Object) name21, "PaytmH5AppAnalyticsProvider::class.java.name");
                    b22.a(name21, next);
                } else if (next instanceof PaytmBuildTypeProvider) {
                    net.one97.paytm.phoenix.api.f b23 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name22 = PaytmBuildTypeProvider.class.getName();
                    kotlin.g.b.k.a((Object) name22, "PaytmBuildTypeProvider::class.java.name");
                    b23.a(name22, next);
                } else if (next instanceof PhoenixDeveloperModeWhitelisDataProvider) {
                    net.one97.paytm.phoenix.api.f b24 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name23 = PhoenixDeveloperModeWhitelisDataProvider.class.getName();
                    kotlin.g.b.k.a((Object) name23, "PhoenixDeveloperModeWhit…Provider::class.java.name");
                    b24.a(name23, next);
                } else if (next instanceof PhoenixGenerateShortLinkProvider) {
                    net.one97.paytm.phoenix.api.f b25 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name24 = PhoenixGenerateShortLinkProvider.class.getName();
                    kotlin.g.b.k.a((Object) name24, "PhoenixGenerateShortLinkProvider::class.java.name");
                    b25.a(name24, next);
                } else if (next instanceof PaytmH5RestringProvider) {
                    net.one97.paytm.phoenix.api.f b26 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name25 = PaytmH5RestringProvider.class.getName();
                    kotlin.g.b.k.a((Object) name25, "PaytmH5RestringProvider::class.java.name");
                    b26.a(name25, next);
                } else if (next instanceof PhoenixAppsFlerSendEventProvider) {
                    net.one97.paytm.phoenix.api.f b27 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name26 = PhoenixAppsFlerSendEventProvider.class.getName();
                    kotlin.g.b.k.a((Object) name26, "PhoenixAppsFlerSendEventProvider::class.java.name");
                    b27.a(name26, next);
                } else {
                    net.one97.paytm.phoenix.api.f b28 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name27 = next.getClass().getName();
                    kotlin.g.b.k.a((Object) name27, "provider::class.java.name");
                    b28.a(name27, next);
                }
            }
        }
    }

    public static final void addSubscribeBridges(List<String> list) {
        kotlin.g.b.k.c(list, "listOfSubscribeBridgesOne");
        for (String str : list) {
            if (!listOfSubscribeBridges.contains(str)) {
                listOfSubscribeBridges.add(str);
            }
        }
    }

    public static final void removeSubScribeBridges(String str) {
        kotlin.g.b.k.c(str, "bridgeName");
        if (listOfSubscribeBridges.contains(str)) {
            listOfSubscribeBridges.remove(str);
        }
    }

    public static /* synthetic */ void loadPage$default(String str, String str2, a aVar, Bundle bundle, String str3, boolean z, List list, List list2, Activity activity, int i2, Object obj) {
        int i3 = i2;
        loadPage(str, str2, aVar, (i3 & 8) != 0 ? null : bundle, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? null : list, (i3 & 128) != 0 ? null : list2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? null : activity);
    }

    public static final void loadPage(String str, String str2, a aVar, Bundle bundle, String str3, boolean z, List<? extends d> list, List<? extends Object> list2, Activity activity) {
        String str4 = str;
        Bundle bundle2 = bundle;
        kotlin.g.b.k.c(str, "appUniqueId");
        String str5 = str2;
        kotlin.g.b.k.c(str2, "urlOrAssetPath");
        j jVar = j.f59646a;
        j.b("PhoenixManager", "loadPage:".concat(String.valueOf(str)));
        boolean z2 = false;
        if (bundle2 != null) {
            z2 = bundle2.getBoolean("devModeEnabled", false);
        }
        if (z2) {
            INSTANCE.onDoesAppExistCallback(true, str, str2, bundle, str3, z, list, list2, aVar, activity);
            return;
        }
        net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = PhoenixAppInfoProvider.class.getName();
        kotlin.g.b.k.a((Object) name, "PhoenixAppInfoProvider::class.java.name");
        PhoenixAppInfoProvider phoenixAppInfoProvider = (PhoenixAppInfoProvider) b2.a(name);
        if (phoenixAppInfoProvider != null) {
            phoenixAppInfoProvider.startPhoenixActivityToWebPageStartTrace(str);
        }
        net.one97.paytm.phoenix.api.f b3 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name2 = PaytmPhoenixWhitelistAppDataProvider.class.getName();
        kotlin.g.b.k.a((Object) name2, "PaytmPhoenixWhitelistApp…Provider::class.java.name");
        PaytmPhoenixWhitelistAppDataProvider paytmPhoenixWhitelistAppDataProvider = (PaytmPhoenixWhitelistAppDataProvider) b3.a(name2);
        if (paytmPhoenixWhitelistAppDataProvider != null) {
            paytmPhoenixWhitelistAppDataProvider.doesAppExist(str, getContext(), new c(str, str2, bundle, str3, z, list, list2, aVar, activity));
        }
    }

    public static final class c implements net.one97.paytm.phoenix.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f59354a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f59355b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f59356c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f59357d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f59358e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List f59359f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List f59360g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ a f59361h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Activity f59362i;

        c(String str, String str2, Bundle bundle, String str3, boolean z, List list, List list2, a aVar, Activity activity) {
            this.f59354a = str;
            this.f59355b = str2;
            this.f59356c = bundle;
            this.f59357d = str3;
            this.f59358e = z;
            this.f59359f = list;
            this.f59360g = list2;
            this.f59361h = aVar;
            this.f59362i = activity;
        }

        public final /* synthetic */ void a(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            j jVar = j.f59646a;
            j.b("PhoenixManager", "doesAppExist:".concat(String.valueOf(booleanValue)));
            PhoenixManager.INSTANCE.onDoesAppExistCallback(booleanValue, this.f59354a, this.f59355b, this.f59356c, this.f59357d, this.f59358e, this.f59359f, this.f59360g, this.f59361h, this.f59362i);
        }
    }

    /* access modifiers changed from: private */
    public final void onDoesAppExistCallback(boolean z, String str, String str2, Bundle bundle, String str3, boolean z2, List<? extends d> list, List<? extends Object> list2, a aVar, Activity activity) {
        Context context;
        String str4 = str;
        String str5 = str2;
        Bundle bundle2 = bundle;
        Activity activity2 = activity;
        j jVar = j.f59646a;
        j.b("PhoenixManager", "onDoesAppExistCallback:".concat(String.valueOf(z)));
        j jVar2 = j.f59646a;
        j.b("PhoenixManager", "onDoesAppExistCallback url:".concat(String.valueOf(str2)));
        j jVar3 = j.f59646a;
        j.b("PhoenixManager", "onDoesAppExistCallback deeplinkdata:".concat(String.valueOf(str3)));
        isFromDeepLinkStatus = bundle2 != null ? bundle2.getBoolean("isFromDeeplink") : false;
        if (!z) {
            Toast.makeText(getContext(), "Your app is not registered with Paytm. Please contact Paytm administrator team.", 1).show();
        } else if (isDebug || !p.b(str5, "http://", false)) {
            boolean z3 = bundle2 != null ? bundle2.getBoolean("devModeEnabled", false) : false;
            if (z3) {
                net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
                String name = PhoenixDeveloperModeWhitelisDataProvider.class.getName();
                kotlin.g.b.k.a((Object) name, "PhoenixDeveloperModeWhit…Provider::class.java.name");
                PhoenixDeveloperModeWhitelisDataProvider phoenixDeveloperModeWhitelisDataProvider = (PhoenixDeveloperModeWhitelisDataProvider) b2.a(name);
                if (!(phoenixDeveloperModeWhitelisDataProvider != null ? phoenixDeveloperModeWhitelisDataProvider.isAppIdWhitelistedForDeveloperMode(lastOpenedAppUniqueId) : false) && (!(activity2 instanceof PhoenixActivity) || !((PhoenixActivity) activity2).z)) {
                    z3 = false;
                }
            }
            net.one97.paytm.phoenix.api.f b3 = net.one97.paytm.phoenix.core.c.f59399a.b();
            String name2 = PaytmBuildTypeProvider.class.getName();
            kotlin.g.b.k.a((Object) name2, "PaytmBuildTypeProvider::class.java.name");
            PaytmBuildTypeProvider paytmBuildTypeProvider = (PaytmBuildTypeProvider) b3.a(name2);
            if (paytmBuildTypeProvider == null || paytmBuildTypeProvider.isStagingApp()) {
                j jVar4 = j.f59646a;
                j.b("PhoenixManager", "Staging build. Skipping domain whitelisting");
            } else {
                j jVar5 = j.f59646a;
                j.b("PhoenixManager", "Not Staging build. Applying domain whitelisting: ");
                boolean z4 = !(bundle2 != null ? bundle2.getBoolean("isFromDeeplink") : false);
                if (str5 != null) {
                    CharSequence charSequence = str5;
                    boolean b4 = p.b(p.b(charSequence).toString(), "http://", false);
                    if (str5 == null) {
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                    } else if ((z4 & (b4 | p.b(p.b(charSequence).toString(), "https://", false))) || z3) {
                        net.one97.paytm.phoenix.api.f b5 = net.one97.paytm.phoenix.core.c.f59399a.b();
                        String name3 = PaytmPhoenixWhitelistAppDataProvider.class.getName();
                        kotlin.g.b.k.a((Object) name3, "PaytmPhoenixWhitelistApp…Provider::class.java.name");
                        PaytmPhoenixWhitelistAppDataProvider paytmPhoenixWhitelistAppDataProvider = (PaytmPhoenixWhitelistAppDataProvider) b5.a(name3);
                        if (paytmPhoenixWhitelistAppDataProvider != null) {
                            boolean isDomainWhitelisted = paytmPhoenixWhitelistAppDataProvider.isDomainWhitelisted(str5);
                            if (z3) {
                                if (isDomainWhitelisted) {
                                    Toast.makeText(getContext(), "This url is not allowed. Please contact Paytm administrator team.", 1).show();
                                    return;
                                }
                            } else if (!isDomainWhitelisted) {
                                loadError("AN");
                                return;
                            }
                        }
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            if (str5 != null) {
                CharSequence charSequence2 = str5;
                boolean b6 = p.b(p.b(charSequence2).toString(), "http://", false);
                if (str5 != null) {
                    String a2 = p.b(p.b(charSequence2).toString(), "https://", false) | b6 ? str5 : i.a(str2);
                    j jVar6 = j.f59646a;
                    j.b("PhoenixManager", "onDoesAppExistCallback url:".concat(String.valueOf(a2)));
                    j jVar7 = j.f59646a;
                    j.b("PhoenixManager", "appuniqueId from load page:".concat(String.valueOf(str)));
                    j jVar8 = j.f59646a;
                    j.b("PhoenixManager", "lastOpenedAppUniqueId:" + lastOpenedAppUniqueId);
                    lastPageOpenTimeStamp = System.currentTimeMillis();
                    mapOfTempPlugins.put(str4 + lastPageOpenTimeStamp, list);
                    mapOfTempProviders.put(str4 + lastPageOpenTimeStamp, list2);
                    lastOpenedAppUniqueId = str4;
                    j jVar9 = j.f59646a;
                    j.b("PhoenixManager", "lastOpenedAppUniqueId:" + lastOpenedAppUniqueId);
                    j jVar10 = j.f59646a;
                    j.b("PhoenixManager", "bundleTosend: " + String.valueOf(bundle));
                    Bundle bundle3 = bundle2 == null ? new Bundle() : bundle2;
                    Bundle bundle4 = bundle3.getBundle("sParams");
                    if (bundle4 == null) {
                        bundle4 = new Bundle();
                    }
                    sParamsBundle = bundle4;
                    j jVar11 = j.f59646a;
                    j.b("PhoenixManager", "sParamsBundle: " + String.valueOf(sParamsBundle));
                    bundle3.putString("deeplinkData", str3);
                    bundle3.putBoolean(H5Param.LONG_TRANSPARENT, z2);
                    bundle3.putString("appUniqueId", str4);
                    bundle3.putBoolean("devModeEnabled", z3);
                    j jVar12 = j.f59646a;
                    j.b("PhoenixManager", "bundleTosend before adding startup params: " + bundle3.toString());
                    addStartupParams(bundle3);
                    j jVar13 = j.f59646a;
                    j.b("PaytmH5Manager", "URL: ".concat(String.valueOf(str2)));
                    j jVar14 = j.f59646a;
                    j.b("PaytmH5Manager", "isTransparent: ".concat(String.valueOf(z2)));
                    j jVar15 = j.f59646a;
                    j.b("PaytmH5Manager", "DeeplinkData: ".concat(String.valueOf(str3)));
                    j jVar16 = j.f59646a;
                    j.b("PaytmH5Manager", "Bundle: " + String.valueOf(bundle));
                    PhoenixActivity.e eVar = PhoenixActivity.L;
                    if (activity2 == null) {
                        context = application;
                        if (context == null) {
                            kotlin.g.b.k.a("application");
                        }
                    } else {
                        context = activity2;
                    }
                    PhoenixActivity.e.a(context, a2, bundle3);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
        } else {
            Application application2 = application;
            if (application2 == null) {
                kotlin.g.b.k.a("application");
            }
            Toast.makeText(application2, "'http' calls not allowed. Use 'https' only or Please contact Paytm administrator team.", 1).show();
        }
    }

    private final void addStartupParams(Bundle bundle) {
        g gVar = g.f59641a;
        addParams(bundle, g.a());
    }

    private final void addParams(Bundle bundle, Map<String, Object> map) {
        Object obj;
        Iterable<String> keySet = map.keySet();
        Collection arrayList = new ArrayList(k.a(keySet));
        for (String str : keySet) {
            Bundle bundle2 = sParamsBundle;
            if (bundle2 == null || (obj = bundle2.get(str)) == null) {
                obj = bundle.get(str);
            }
            Object obj2 = map.get(str);
            if (obj == null) {
                obj = obj2;
            }
            arrayList.add(kotlin.t.a(str, obj));
        }
        for (o oVar : (List) arrayList) {
            String str2 = (String) oVar.component1();
            Object component2 = oVar.component2();
            if (component2 instanceof String) {
                bundle.putString(str2, (String) component2);
            } else if (component2 instanceof Boolean) {
                bundle.putBoolean(str2, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Integer) {
                bundle.putInt(str2, ((Number) component2).intValue());
            } else if (component2 instanceof Float) {
                bundle.putFloat(str2, ((Number) component2).floatValue());
            } else if (component2 instanceof Long) {
                bundle.putLong(str2, ((Number) component2).longValue());
            } else if (component2 instanceof Double) {
                bundle.putDouble(str2, ((Number) component2).doubleValue());
            } else if (component2 instanceof Byte) {
                bundle.putByte(str2, ((Number) component2).byteValue());
            } else if (component2 instanceof Character) {
                bundle.putChar(str2, ((Character) component2).charValue());
            } else if (component2 instanceof Short) {
                bundle.putShort(str2, ((Number) component2).shortValue());
            } else if (component2 == null) {
                j jVar = j.f59646a;
                j.c("PhoenixManager", "This " + str2 + " has empty " + component2);
            } else {
                throw new UnsupportedOperationException("This type of data is not being handled!");
            }
        }
        j jVar2 = j.f59646a;
        j.b("PhoenixManager", "final bundle after adding startup params: " + bundle.toString());
    }

    public static /* synthetic */ void addTempProviders$default(List list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        addTempProviders(list, str);
    }

    public static final void addTempProviders(List<? extends Object> list, String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        mapOfTempProviders.put(str, list);
        j jVar = j.f59646a;
        j.b("Phoenixmanager PhoenixFetchValuesForKeysPlugin", " added for aid ".concat(String.valueOf(str)));
        if (list != null) {
            for (Object next : list) {
                if (next instanceof FetchValuesForKeysProvider) {
                    net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name = FetchValuesForKeysProvider.class.getName();
                    kotlin.g.b.k.a((Object) name, "FetchValuesForKeysProvider::class.java.name");
                    b2.a(name, next);
                } else {
                    net.one97.paytm.phoenix.api.f b3 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name2 = next.getClass().getName();
                    kotlin.g.b.k.a((Object) name2, "provider::class.java.name");
                    b3.a(name2, next);
                }
            }
        }
    }

    public static final void removeTempProviders(String str) {
        kotlin.g.b.k.c(str, "uniqueId");
        try {
            List<Object> list = mapOfTempProviders.get(str);
            if (list != null) {
                for (Object obj : list) {
                    if (obj instanceof FetchValuesForKeysProvider) {
                        net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
                        String name = FetchValuesForKeysProvider.class.getName();
                        kotlin.g.b.k.a((Object) name, "FetchValuesForKeysProvider::class.java.name");
                        b2.b(name);
                    }
                }
            }
            j jVar = j.f59646a;
            j.b("Phoenixmanager PhoenixFetchValuesForKeysPlugin", " removed for aid ".concat(String.valueOf(str)));
            mapOfTempProviders.remove(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final void removeTempPlugins(String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        List<d> list = mapOfTempPlugins.get(str);
        if (list != null) {
            for (d b2 : list) {
                net.one97.paytm.phoenix.core.c.f59399a.a().b(b2);
            }
        }
        mapOfTempPlugins.remove(str);
    }

    public static /* synthetic */ void addTempPlugins$default(List list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        addTempPlugins(list, str);
    }

    public static final void addTempPlugins(List<? extends d> list, String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        mapOfTempPlugins.put(str, list);
        if (list != null) {
            for (d a2 : list) {
                net.one97.paytm.phoenix.core.c.f59399a.a().a(a2);
            }
        }
    }

    public static final void loadError(String str) {
        j jVar = j.f59646a;
        j.b("PhoenixManager", "loadError:".concat(String.valueOf(str)));
        Bundle bundle = new Bundle();
        INSTANCE.addStartupParams(bundle);
        bundle.putBoolean("paytmShowTitleBar", false);
        if (application != null) {
            PhoenixActivity.e eVar = PhoenixActivity.L;
            Application application2 = application;
            if (application2 == null) {
                kotlin.g.b.k.a("application");
            }
            PhoenixActivity.e.a(application2, i.a("h5_errors/phoenix_index.html?type=".concat(String.valueOf(str))), bundle);
            return;
        }
        j jVar2 = j.f59646a;
        StringBuilder sb = new StringBuilder("application is not initialized: ");
        Application application3 = application;
        if (application3 == null) {
            kotlin.g.b.k.a("application");
        }
        sb.append(application3);
        j.b("PhoenixManager", sb.toString());
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f59353a;

        b(Activity activity) {
            this.f59353a = activity;
        }

        public final void run() {
            j jVar = j.f59646a;
            j.b("PhoenixManager", "before runonuithread");
            WebView webView = new WebView(this.f59353a);
            j jVar2 = j.f59646a;
            j.b("PhoenixManager", "2");
            this.f59353a.deleteDatabase("webviewCache.db");
            j jVar3 = j.f59646a;
            j.b("PhoenixManager", "3");
            this.f59353a.deleteDatabase("webview.db");
            j jVar4 = j.f59646a;
            j.b("PhoenixManager", "4");
            webView.clearCache(true);
            j jVar5 = j.f59646a;
            j.b("PhoenixManager", "5");
            webView.clearHistory();
            j jVar6 = j.f59646a;
            j.b("PhoenixManager", "6");
            webView.clearFormData();
            j jVar7 = j.f59646a;
            j.b("PhoenixManager", "7");
            WebStorage.getInstance().deleteAllData();
            j jVar8 = j.f59646a;
            j.b("PhoenixManager", "webview cleared");
        }
    }

    public final void clearCache(Activity activity) {
        Set<String> keySet;
        kotlin.g.b.k.c(activity, "activity");
        try {
            j jVar = j.f59646a;
            j.b("PhoenixManager", "inside try catch");
            activity.runOnUiThread(new b(activity));
            j jVar2 = j.f59646a;
            j.b("PhoenixManager", "after runonuithread");
            ComponentName componentName = activity.getComponentName();
            String localClassName = activity.getLocalClassName();
            kotlin.g.b.k.a((Object) localClassName, "activity.localClassName");
            j jVar3 = j.f59646a;
            j.b("PhoenixManager", "1" + componentName + localClassName);
            p.a aVar = net.one97.paytm.phoenix.util.p.f59656a;
            p.a aVar2 = net.one97.paytm.phoenix.util.p.f59656a;
            Map<String, ?> all = p.a.a(net.one97.paytm.phoenix.util.p.f59657b).getAll();
            if (all != null && (keySet = all.keySet()) != null) {
                for (String str : keySet) {
                    j jVar4 = j.f59646a;
                    j.b("PhoenixManager", "file name".concat(String.valueOf(str)));
                    INSTANCE.deleteSharedPreferenceForFileName(str);
                }
            }
        } catch (Exception e2) {
            j jVar5 = j.f59646a;
            j.b("PhoenixManager", "exception".concat(String.valueOf(e2)));
            e2.printStackTrace();
        }
    }

    private final void deleteSharedPreferenceForFileName(String str) {
        j jVar = j.f59646a;
        j.b("PhoenixManager", "file name".concat(String.valueOf(str)));
        if (str != null) {
            j jVar2 = j.f59646a;
            j.b("PhoenixManager", "file name".concat(String.valueOf(str)));
            p.a aVar = net.one97.paytm.phoenix.util.p.f59656a;
            p.a.a(str).edit().clear().apply();
        }
    }

    public static final Application getContext() {
        Application application2 = application;
        if (application2 == null) {
            kotlin.g.b.k.a("application");
        }
        return application2;
    }

    public static final void addMenuItems(List<PhoenixMenuDialogItems> list) {
        menuItemsList = list;
    }

    public static final void sendDataOnSubscribeEvent(String str, JSONObject jSONObject, Context context) {
        kotlin.g.b.k.c(str, "bridgeName");
        kotlin.g.b.k.c(jSONObject, "dataObject");
        kotlin.g.b.k.c(context, "context");
        Intent intent = new Intent();
        intent.setAction(str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", jSONObject);
        Bundle bundle = new Bundle();
        g gVar = g.f59641a;
        g.a(jSONObject2, bundle);
        intent.putExtras(bundle);
        androidx.localbroadcastmanager.a.a.a(context).a(intent);
    }

    public final FetchValuesForKeysProvider getTempFetchValueForProvider(Activity activity) {
        Map<String, List<Object>> map = mapOfTempProviders;
        StringBuilder sb = new StringBuilder();
        if (activity != null) {
            PhoenixActivity phoenixActivity = (PhoenixActivity) activity;
            sb.append(phoenixActivity.f59606d);
            sb.append(phoenixActivity.C);
            List list = map.get(sb.toString());
            if (list == null) {
                return null;
            }
            for (Object next : list) {
                if (next instanceof FetchValuesForKeysProvider) {
                    return (FetchValuesForKeysProvider) next;
                }
            }
            return null;
        }
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
    }
}
